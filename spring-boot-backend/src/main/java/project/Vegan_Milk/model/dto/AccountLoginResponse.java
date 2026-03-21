package project.Vegan_Milk.model.dto;

import org.jspecify.annotations.Nullable;
import project.Vegan_Milk.model.enums.AccountRole;

public record AccountLoginResponse(Long id, String accountEmail, String email,
                                   AccountRole accountRole, String token, String message) {

}
