package com.example.fivestarmovies.genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/genres")
@CrossOrigin("*")
public class GenresController {
  @Autowired
  private GenresRepository genresRepository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Genres> getGenres() {
    return genresRepository.findAll();
  }

}