package project.Vegan_Milk.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.Vegan_Milk.account.model.entity.Account;
import project.Vegan_Milk.account.repository.AccountRepository;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    public CustomUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUsername(email);

        return accountRepository.findByEmail(email)
                .map(AccountPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found"));
    }
}
