package project.Vegan_Milk.account.model.dto;

import project.Vegan_Milk.account.model.enums.AccountRole;

public record AccountLoginResponse(Long id, String accountEmail, String email,
                                   AccountRole accountRole, String token, String message) {

}
