package project.Vegan_Milk.model.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountLoginRequest(@NotBlank String email,
                                  @NotBlank String password) {
}
