package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.City;
import dev.sarvesh.BookMyShow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
}
