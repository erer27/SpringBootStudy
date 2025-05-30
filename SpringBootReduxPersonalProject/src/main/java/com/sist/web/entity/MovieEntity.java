package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="movie_info")
@Data
public class MovieEntity {
    @Id
    private int id;
    private String title;
    private String originalTitle;
    private String poster;
    private String releaseDate;
    private String rating;
    private String runtime;
    private String genre;
    private String director;
    private String cast;
    private String synopsis;
}
