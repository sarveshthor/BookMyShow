package dev.sarvesh.BookMyShow.model;

import dev.sarvesh.BookMyShow.model.constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String Description;
    @ManyToMany
    private List<Actor> actorList;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;
}
