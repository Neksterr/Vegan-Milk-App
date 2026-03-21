package project.Vegan_Milk.account.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.Vegan_Milk.account.model.dto.AccountLoginRequest;
import project.Vegan_Milk.account.model.dto.AccountLoginResponse;
import project.Vegan_Milk.account.model.dto.AccountRegisterRequest;
import project.Vegan_Milk.account.model.dto.AccountRegisterResponse;
import project.Vegan_Milk.account.service.AccountService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3001", "http://localhost:5173","http://localhost:3001",})
@Tag(name = "Authentication", description = "Register and login endpoints")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/register")
    public ResponseEntity<AccountRegisterResponse> register(@RequestBody AccountRegisterRequest request) {
        System.out.println("REGISTER CONTROLLER HIT: " + request.email());
        return ResponseEntity.ok(accountService.registerResponse(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AccountLoginResponse> login(@RequestBody AccountLoginRequest request) {
        return ResponseEntity.ok(accountService.login(request));
    }
}
