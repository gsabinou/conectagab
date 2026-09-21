package com.aguiabranca.ConectaGab.model;

import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {

    @Id
    private String id;

    private String nome;

    @Indexed(unique = true)
    private String email;

    private String senha;
    private String categoria;
    private UserProfile tipoPerfil;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipoPerfil == UserProfile.LIDER) {
            return List.of(new SimpleGrantedAuthority("ROLE_LIDER"));
        } else if (this.tipoPerfil == UserProfile.GESTOR) {
            return List.of(new SimpleGrantedAuthority("ROLE_GESTOR"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_OPERADOR"));
    }

    @Override
    public @Nullable String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
