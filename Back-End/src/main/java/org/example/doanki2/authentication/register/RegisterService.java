package org.example.doanki2.authentication.register;

import org.example.doanki2.entity.Users;
import org.example.doanki2.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder ;

    public ResponseEntity<Users> registerUser(Register register){
        Users users = new Users();
        users.setUsername(register.getUsername());
        users.setPassword(passwordEncoder.encode(register.getPassword()));
        users.setEmail(register.getEmail());
        users.setPhone(register.getPhone());
        Users save = userRepository.save(users);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.getUsername()).toUri();
        return ResponseEntity.created(location).body(save);
    }
}
