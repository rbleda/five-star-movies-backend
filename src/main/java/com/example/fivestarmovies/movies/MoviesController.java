package com.example.fivestarmovies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(path="/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MoviesController {
  @Autowired
  private MoviesRepository movieRepository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Movies> getMovies(@RequestParam(required = false) String genre_id,
                                    @RequestParam(required = false) String page_number) {
    int start_limit = ((parseInt(page_number) - 1) * 35);
    if (genre_id == null || genre_id.equals("0")) {
      return movieRepository.findThirtyOrderByRating(start_limit);
    }
    return movieRepository.getMoviesByGenre(parseInt(genre_id), start_limit);
  }

  @GetMapping(path="/search")
  public Iterable<Movies> getMoviesTitle(@RequestParam(required = true) String title,
                                         @RequestParam(required = false) String page_number) {
    int start_limit = ((parseInt(page_number) - 1) * 35);
    return movieRepository.getMoviesByTitle(title, start_limit);
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Movies> getAllMovies() {
    return movieRepository.findAll();
  }

  @GetMapping(path="/single_movie")
  public ResponseEntity<Optional<Movies>> getMovie(@RequestParam(required = false) Integer id) {
    Optional<Movies> movie = movieRepository.findById(id);
    if (movie.isPresent()) {
      return ResponseEntity.ok(movie);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
