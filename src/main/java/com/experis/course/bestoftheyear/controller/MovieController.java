package com.experis.course.bestoftheyear.controller;

import com.experis.course.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {


  @GetMapping
  public String movies(Model model) {
//                       @RequestParam(name = "title", required = false) String titleParam) {
//    List<Movie> filteredMovies =
//        titleParam != null ? getFilteredMovies(titleParam) : getBestMovies();
//    model.addAttribute("movieList", filteredMovies);
    model.addAttribute("movieList", getBestMovies());
    model.addAttribute("name", " Lamberto Neri");
    return "movie-list";
  }

  @GetMapping("/{id}")
  public String movieDetail(@PathVariable("id") String movieId, Model model) {
    Movie movie = getMovieById(movieId);
    model.addAttribute("movieDetail", movie);
    return "movie-detail";
  }


  private List<Movie> getBestMovies() {
    Movie[] moviesArray = {new Movie("123", "Kenpa: una vita dietro la Lente"),
        new Movie("456", "CiccioGamer in Pedalò"), new Movie("789", "Paolo il Poster"),
        new Movie("1011", "Baleno, il gatto Sdraiato")};
    return Arrays.asList(moviesArray);
  }

//  private List<Movie> getFilteredMovies(String search) {
//    return getBestMovies().stream().filter(movie -> movie.getTitle().contains(search))
//        .collect(Collectors.toList());
//  }

  private Movie getMovieById(String id) {

    for (Movie movie : getBestMovies()) {
      if (movie.getId().equals(id)) {
        return movie;
      }
    }
    return null;
  }
}
