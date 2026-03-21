package project.Vegan_Milk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.Vegan_Milk.model.dto.AccountLoginRequest;
import project.Vegan_Milk.model.dto.AccountLoginResponse;
import project.Vegan_Milk.model.dto.AccountRegisterRequest;
import project.Vegan_Milk.model.dto.AccountRegisterResponse;
import project.Vegan_Milk.model.entity.Account;
import project.Vegan_Milk.model.enums.AccountRole;
import project.Vegan_Milk.repository.AccountRepository;
import project.Vegan_Milk.security.JwtService;

@Service
public class AccountService {
    @Autowired
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AccountRegisterResponse registerResponse(AccountRegisterRequest accountRegisterRequest) {
        if (accountRepository.existsByEmail(accountRegisterRequest.email())) {
            throw new RuntimeException("Email already exists");

        }
        Account account = new Account();
        account.setEmail(accountRegisterRequest.email());
        account.setUsername(accountRegisterRequest.username());
        account.setPassword(passwordEncoder.encode(accountRegisterRequest.password()));
        account.setAccountRole(AccountRole.USER);
        account.setEnabled(true);

        Account savedAccount = accountRepository.save(account);

        String token = jwtService.generateToken(savedAccount.getEmail());
        return new AccountRegisterResponse(savedAccount.getId(),
                savedAccount.getEmail(),
                savedAccount.getUsername(),
                savedAccount.getAccountRole(),
                token, "Account registerd successfully");


    }

    public AccountLoginResponse login( AccountLoginRequest accountLoginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                accountLoginRequest.email(), accountLoginRequest.password()));
        Account account = accountRepository.findByEmail(accountLoginRequest.email()).orElseThrow(() -> new UsernameNotFoundException("Account not found"));
        String token = jwtService.generateToken(account.getEmail());
        return new AccountLoginResponse(
                account.getId(),
                account.getEmail(),
                account.getUsername(),
                account.getAccountRole(),
                token,
                "Login successful");

    }
}
