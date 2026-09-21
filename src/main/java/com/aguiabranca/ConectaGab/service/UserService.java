package com.aguiabranca.ConectaGab.service;

import com.aguiabranca.ConectaGab.dto.UserCreationDTO;
import com.aguiabranca.ConectaGab.dto.UserExhibitionDTO;
import com.aguiabranca.ConectaGab.exceptions.UserNotFoundException;
import com.aguiabranca.ConectaGab.model.User;
import com.aguiabranca.ConectaGab.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserExhibitionDTO createUser(UserCreationDTO userCreationDTO) {

        String EncryptedSenha = new BCryptPasswordEncoder().encode(userCreationDTO.senha());

        User user = new User();
        BeanUtils.copyProperties(userCreationDTO, user);
        user.setSenha(EncryptedSenha);

        User savedUser = userRepository.save(user);
        return new UserExhibitionDTO(savedUser);
    }

    public List<UserExhibitionDTO> listAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserExhibitionDTO::new)
                .toList();
    }

    public UserExhibitionDTO findById(String id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return new UserExhibitionDTO(userOptional.get());
        } else {
            throw new UserNotFoundException("Usuário não encontrado");
        }

    }

}
