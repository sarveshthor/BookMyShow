package dev.sarvesh.BookMyShow.model;

import dev.sarvesh.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private LocalDateTime timeOfBooking;
    private double totalAmount;

    @OneToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private Show movie_show;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
