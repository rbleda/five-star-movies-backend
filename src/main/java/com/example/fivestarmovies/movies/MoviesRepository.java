package com.example.fivestarmovies.movies;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {
  @Query("SELECT m FROM Movies m ORDER BY m.rating DESC")
  List<Movies> findAllOrderByRating();

  @Query("SELECT m FROM Movies m WHERE m.genre_id = :genre_id ORDER BY m.rating DESC")
  List<Movies> getMoviesByGenre(@Param("genre_id") Integer genre_id);
}
