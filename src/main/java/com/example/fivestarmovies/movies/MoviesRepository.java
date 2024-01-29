package com.example.fivestarmovies.movies;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {
  @Query(value = "SELECT * FROM Movies m ORDER BY m.position ASC LIMIT :start_limit, 35", nativeQuery = true)
  List<Movies> findThirtyOrderByRating(@Param("start_limit") Integer start_limit);

  @Query(value = "SELECT * FROM Movies m WHERE m.genre_id = :genre_id ORDER BY m.position ASC LIMIT :start_limit, 35", nativeQuery = true)
  List<Movies> getMoviesByGenre(@Param("genre_id") Integer genre_id, @Param("start_limit") Integer start_limit);

  @Query(value = "SELECT * FROM Movies m WHERE title LIKE %:title% ORDER BY m.position ASC LIMIT :start_limit, 35", nativeQuery = true)
  List<Movies> getMoviesByTitle(@Param("title") String title, @Param("start_limit") Integer start_limit);
}
