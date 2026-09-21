package com.aguiabranca.ConectaGab.controller;

import com.aguiabranca.ConectaGab.dto.UserCreationDTO;
import com.aguiabranca.ConectaGab.dto.UserExhibitionDTO;
import com.aguiabranca.ConectaGab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserExhibitionDTO create(@RequestBody UserCreationDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserExhibitionDTO> listAll() {
        return userService.listAll();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserExhibitionDTO> findById(
            @PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
