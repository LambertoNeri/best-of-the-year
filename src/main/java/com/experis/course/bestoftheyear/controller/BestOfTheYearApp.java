package com.experis.course.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")

public class BestOfTheYearApp {
  @GetMapping
  public String root(Model model) {
    String myName = "Lamberto Neri";
    model.addAttribute("name", myName);
    return "root";
  }

  @GetMapping("home")
  public String home() {
    return "home-page";
  }

  @GetMapping("songs")
  public String songs(Model model) {
    String delimiter = ", ";
    String songs = String.join(delimiter, getBestSongs());
    model.addAttribute("songs", songs);

    return "songs";
  }

  @GetMapping("movies")
  public String movies(Model model) {
    String delimiter = ", ";
    String movies = String.join(delimiter, getBestMovies());
    model.addAttribute("movies", movies);
    return "movies";
  }

  private List<String> getBestMovies() {
    List<String> moviesArray = new ArrayList<>();
    moviesArray.add("Matrix");
    moviesArray.add("CiccioGamer in pedalò");
    moviesArray.add("Paolo il poster");
    moviesArray.add("Kenpa: una vita dietro la lente");
    moviesArray.add("Baleno, il gatto sdraiato");

    return moviesArray;
  }

  private List<String> getBestSongs() {
    List<String> songsArray = new ArrayList<>();
    songsArray.add("Till I collapse");
    songsArray.add("Lose yourself");
    songsArray.add("My name is");
    songsArray.add("Whithout me");
    songsArray.add("Forgot about Dre");
    songsArray.add("Mockingbird");
    songsArray.add("");
    return songsArray;
  }
}


