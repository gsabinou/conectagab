package com.aguiabranca.ConectaGab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO(

        @NotBlank(message = "É obrigatório informar o e-mail")
        @Email
        String email,

        @NotBlank(message = "Por favor, digite a sua senha")
        @Size(min = 8, max = 20, message = "A sua senha deve ter entre 8 a 20 caracteres")
        String senha
) {

}
