package project.Vegan_Milk.model.dto;

public record AccountRegisterResponse(Long id, String email, String username,
                                      project.Vegan_Milk.model.enums.AccountRole accountRole, String token, String message) {
}
