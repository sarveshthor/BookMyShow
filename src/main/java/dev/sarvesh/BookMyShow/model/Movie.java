package dev.sarvesh.BookMyShow.model;

import dev.sarvesh.BookMyShow.model.constant.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class Movie extends BaseModel{
    private String name;
    private String Description;
    @ManyToMany
    private List<Actor> actorList;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;
}
