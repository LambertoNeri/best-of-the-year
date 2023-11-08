package com.experis.course.bestoftheyear.controller;

import com.experis.course.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {


  @GetMapping
  public String songs(Model model) {
    model.addAttribute("songList", getBestSongs());
    model.addAttribute("name", " Lamberto Neri");
    return "song-list";
  }

  @GetMapping("/{id}")
  public String songDetail(@PathVariable("id") String songId, Model model) {
    Song song = getSongById(songId);
    model.addAttribute("songDetail", song);
    return "song-detail";
  }


  private List<Song> getBestSongs() {
    Song[] songsArray = {new Song("123", "Till I collapse"),
        new Song("456", "Lose yourself"), new Song("789", "My name is"),
        new Song("1011", "Whithout me"), new Song("1213", "Forgot about Dre"),
        new Song("1415", "Mockingbird")};
    return Arrays.asList(songsArray);
  }

  private Song getSongById(String id) {

    for (Song song : getBestSongs()) {
      if (song.getId().equals(id)) {
        return song;
      }
    }
    return null;
  }

}
