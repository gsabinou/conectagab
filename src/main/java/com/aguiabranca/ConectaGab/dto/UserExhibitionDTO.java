package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.User;
import com.aguiabranca.ConectaGab.model.UserProfile;

import java.time.LocalDate;

public record UserExhibitionDTO(
    String id,
    String nome,
    String categoria,
    UserProfile tipoPerfil
) {

    public UserExhibitionDTO(User user) {
        this(
                user.getId(),
                user.getNome(),
                user.getCategoria(),
                user.getTipoPerfil()
        );
    }

}
