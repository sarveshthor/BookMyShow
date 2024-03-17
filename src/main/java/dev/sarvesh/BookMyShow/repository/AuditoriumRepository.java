package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.Auditorium;
import dev.sarvesh.BookMyShow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
}
