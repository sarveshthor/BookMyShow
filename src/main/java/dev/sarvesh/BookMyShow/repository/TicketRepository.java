package dev.sarvesh.BookMyShow.repository;

import dev.sarvesh.BookMyShow.model.City;
import dev.sarvesh.BookMyShow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
