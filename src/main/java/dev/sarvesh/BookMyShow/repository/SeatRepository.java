package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.City;
import dev.sarvesh.BookMyShow.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
