package project.Vegan_Milk.account.model.dto;

import project.Vegan_Milk.account.model.enums.AccountRole;

public record AccountRegisterResponse(Long id, String email, String username,
                                      AccountRole accountRole, String token, String message) {
}
