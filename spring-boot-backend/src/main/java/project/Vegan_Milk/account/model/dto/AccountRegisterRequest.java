package project.Vegan_Milk.account.model.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountRegisterRequest(@NotBlank String email,
                                     @NotBlank String username,
                                     @NotBlank String password) {
}
