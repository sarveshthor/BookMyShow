package dev.sarvesh.BookMyShow.model;

import dev.sarvesh.BookMyShow.model.constant.AuditoriumFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    private List<Show> shows;
    @OneToMany
    private List<Seat> seats;
    //for enum we use different annotation
    @ElementCollection// used when enums are multiple for eg. a list
    @Enumerated(EnumType.STRING) // creates a relationship between entity class and enum in DB
    private List<AuditoriumFeature> auditoriumFeatures;

}
