package com.aguiabranca.ConectaGab.controller;

import com.aguiabranca.ConectaGab.config.security.TokenService;
import com.aguiabranca.ConectaGab.dto.LoginDTO;
import com.aguiabranca.ConectaGab.dto.TokenDTO;
import com.aguiabranca.ConectaGab.dto.UserCreationDTO;
import com.aguiabranca.ConectaGab.dto.UserExhibitionDTO;
import com.aguiabranca.ConectaGab.model.User;
import com.aguiabranca.ConectaGab.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            LoginDTO login
    ) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        login.email(),
                        login.senha()
                );

        Authentication auth =  authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity register(@RequestBody @Valid UserCreationDTO userCreationDTO) {

        UserExhibitionDTO savedUser = userService.createUser(userCreationDTO);

        return ResponseEntity.ok(savedUser);
    }

}
