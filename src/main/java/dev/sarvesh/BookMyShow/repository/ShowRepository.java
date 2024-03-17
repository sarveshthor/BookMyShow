package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
