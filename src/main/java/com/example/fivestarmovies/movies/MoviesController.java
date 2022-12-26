package com.example.fivestarmovies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/movie")
public class MoviesController {
  @Autowired
  private MoviesRepository movieRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Movies> getAllMovies() {
    return movieRepository.findAll();
  }
}
