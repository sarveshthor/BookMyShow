package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.Payment;
import dev.sarvesh.BookMyShow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);
}
