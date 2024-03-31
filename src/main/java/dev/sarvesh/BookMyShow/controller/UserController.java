package dev.sarvesh.BookMyShow.controller;

import dev.sarvesh.BookMyShow.dto.UserLoginRequestDTO;
import dev.sarvesh.BookMyShow.dto.UserSignUpRequestDTO;
import dev.sarvesh.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) throws Exception {
        return ResponseEntity.ok(
                userService.signup(userSignUpRequestDTO.getName(),
                        userSignUpRequestDTO.getEmail(),
                        userSignUpRequestDTO.getPassword())
        );
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO loginRequestDTO) throws Exception {
        return ResponseEntity.ok(userService.login(loginRequestDTO.getEmail(),
                loginRequestDTO.getPassword())
        );
    }
}
