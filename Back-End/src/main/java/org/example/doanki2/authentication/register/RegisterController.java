package org.example.doanki2.authentication.register;

import org.example.doanki2.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping
    public ResponseEntity<Users> registerUser(@RequestBody Register users){
        return registerService.registerUser(users);
    }
}
