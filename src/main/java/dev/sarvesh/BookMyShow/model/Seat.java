package dev.sarvesh.BookMyShow.model;

import dev.sarvesh.BookMyShow.model.constant.SeatStatus;
import dev.sarvesh.BookMyShow.model.constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Column(name = "seat_row")//import jakarta.persistence.*
    private int row;

    private int col;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

}
