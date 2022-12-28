package com.example.fivestarmovies.movies;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movies {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;

  private Integer genre_id;

  private Integer release_year;

  private float rating;

  private Integer director_id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public float getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public Integer getGenreId() {
    return this.genre_id;
  }

  public void setGenreId(Integer genre_id) {
    this.genre_id = genre_id;
  }
}
