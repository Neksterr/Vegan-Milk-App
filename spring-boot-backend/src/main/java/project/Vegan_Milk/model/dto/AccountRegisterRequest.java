package project.Vegan_Milk.model.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountRegisterRequest(@NotBlank String email,
                                     @NotBlank String username,
                                     @NotBlank String password) {
}
