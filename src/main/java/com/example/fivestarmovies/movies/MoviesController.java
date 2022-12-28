package com.example.fivestarmovies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(path="/movies")
@CrossOrigin("*")
public class MoviesController {
  @Autowired
  private MoviesRepository movieRepository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Movies> getMovies(@RequestParam(required = false) String genre_id) {
    if (genre_id == null || genre_id.equals("0")) {
      return movieRepository.findAllOrderByRating();
    }
    return movieRepository.getMoviesByGenre(parseInt(genre_id));
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Movies> getAllMovies() {
    return movieRepository.findAll();
  }

  @GetMapping(path="/rating")
  public @ResponseBody Iterable<Movies> getAllMoviesByRating() {
    return movieRepository.findAllOrderByRating();
  }

}
