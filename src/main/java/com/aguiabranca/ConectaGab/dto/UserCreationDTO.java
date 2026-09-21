package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.User;
import com.aguiabranca.ConectaGab.model.UserProfile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserCreationDTO(
        String id, // O id é opcional, é muito recomendado que ele não seja passado

        @NotBlank(message = "O nome deve ser informado")
        String nome,

        @NotBlank(message = "O email deve ser informado")
        @Email
        String email,

        @NotBlank(message = "É obrigatório informar uma senha")
        @Size(min = 8, max = 20, message = "A senha deve obrigatoriamente ter entre 8 a 20 caracteres")
        String senha,

        String categoria,

        @NotNull(message = "Por favor, informe o seu perfil")
        UserProfile tipoPerfil
) {

    public UserCreationDTO(User user) {
        this(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getSenha(),
                user.getCategoria(),
                user.getTipoPerfil()
        );
    }

}
