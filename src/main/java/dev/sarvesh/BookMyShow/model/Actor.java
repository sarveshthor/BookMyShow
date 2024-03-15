package dev.sarvesh.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity //(name = "xxxx") if we do not write this then class name will become the table name
public class Actor extends BaseModel{
    //@Column(name = "xxx") if we do not write this then attribute name becomes the column name
    private String name;
    @ManyToMany
    private List<Movie> movies;
}
