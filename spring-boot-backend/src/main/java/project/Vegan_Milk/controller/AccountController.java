package project.Vegan_Milk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.Vegan_Milk.model.dto.AccountLoginRequest;
import project.Vegan_Milk.model.dto.AccountLoginResponse;
import project.Vegan_Milk.model.dto.AccountRegisterRequest;
import project.Vegan_Milk.model.dto.AccountRegisterResponse;
import project.Vegan_Milk.service.AccountService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/register")
    public ResponseEntity<AccountRegisterResponse> register(@RequestBody AccountRegisterRequest request) {
        return ResponseEntity.ok(accountService.registerResponse(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AccountLoginResponse> login(@RequestBody AccountLoginRequest request) {
        return ResponseEntity.ok(accountService.login(request));
    }
}
