package dev.sarvesh.BookMyShow.service;

import dev.sarvesh.BookMyShow.model.User;
import dev.sarvesh.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) throws Exception {
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser == null){
            throw new Exception("user does not exist");
        }
        //compare password using bcrypt
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword())){
            return savedUser;
        }
        else{
            throw new Exception("Invalid password");
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE) // multiple users do not end up creating rows with same data
    public User signup(String name, String email, String password) throws Exception {
        User saveduser = userRepository.findUserByEmail(email);
        if(saveduser != null){
            throw new Exception("User with same email id already exists");
        }
        else{
            User user = new User();
            user.setUsername(name);
            user.setEmail(email);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(password));
            user.setTickets(new ArrayList<>());
            return userRepository.save(user);
        }
    }
}
