package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.Actor;
import dev.sarvesh.BookMyShow.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
