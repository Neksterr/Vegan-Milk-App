package project.Vegan_Milk.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.Vegan_Milk.account.model.entity.Account;

import java.util.Collection;
import java.util.List;

public class AccountPrincipal  implements UserDetails {
    private final Account account;

    public AccountPrincipal(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Long getId() {
        return account.getId();
    }

    public String getEmail() {
        return account.getEmail();
    }

    public String getUsernameValue() {
        return account.getUsername();
    }

    public String getRole() {
        return account.getAccountRole().name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + account.getAccountRole().name())
        );
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account.isEnabled();
    }
}
