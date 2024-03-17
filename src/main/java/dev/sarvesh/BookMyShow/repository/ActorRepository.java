package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.Actor;
import dev.sarvesh.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
