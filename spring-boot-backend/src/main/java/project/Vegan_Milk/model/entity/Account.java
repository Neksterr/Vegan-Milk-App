package project.Vegan_Milk.model.entity;

import jakarta.persistence.*;
import project.Vegan_Milk.model.enums.AccountRole;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
public class Account extends  BaseEntity{
    @Column(name = "email", nullable = false,unique = true)
    private String email;
    @Column(name = "username", nullable = false,unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_role", nullable = false)
    private AccountRole accountRole;
    @Column(name = "enabled", nullable = false)
    private boolean isEnabled;
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "last_modified", nullable = false)
    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastModifiedDate = LocalDateTime.now();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountRole getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
