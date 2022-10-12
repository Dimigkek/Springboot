package com.example.demo.movies;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name= "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;
    private String name;
    private String creator;
    private LocalDate date;
    private String genre;

    public Movie() {
    }

    public Movie(Long id,
                 String name,
                 String creator,
                 LocalDate date,
                 String genre) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.date = date;
        this.genre = genre;
    }

    public Movie(String name,
                 String creator,
                 LocalDate date,
                 String genre) {
        this.name = name;
        this.creator = creator;
        this.date = date;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", date=" + date +
                ", genre='" + genre + '\'' +
                '}';
    }
}
