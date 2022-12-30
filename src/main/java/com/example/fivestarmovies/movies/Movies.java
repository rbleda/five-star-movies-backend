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

  private String image_uri;

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

  public Integer getGenre_id() {
    return this.genre_id;
  }

  public void setGenre_id(Integer genre_id) {
    this.genre_id = genre_id;
  }

  public String getImage_uri() {
    return this.image_uri;
  }

  public void setImage_uri(String image_uri) {
    this.image_uri = image_uri;
  }
}
