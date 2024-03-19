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

    public Seat() {
    }

    public Seat(String seatNumber, SeatType seatType, int row, int col, SeatStatus seatStatus) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.row = row;
        this.col = col;
        this.seatStatus = seatStatus;
    }
}
