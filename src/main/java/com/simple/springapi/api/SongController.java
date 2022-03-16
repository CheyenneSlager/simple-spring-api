package com.simple.springapi.api;

import com.simple.springapi.exception.ItemNotFoundException;
import com.simple.springapi.model.Song;
import com.simple.springapi.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1/song")
@RestController
public class SongController {

    private final SongService songService;

    @Autowired  // Dependency injection.
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public void addSongs(@Valid @NotNull @RequestBody Song[] songs) {
        songService.addSongs(Arrays.stream(songs).toList());
    }

    @GetMapping
    public List<Song> getSongsByGenre(@RequestParam("genre") String genre) {
        List<Song> result = songService.getSongsByGenre(genre);
        if (result.isEmpty()) {
            throw new ItemNotFoundException();
        }
        return result;
    }

    @GetMapping(path = "/all")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @PutMapping(path = "{id}")
    public void updateSongById(@PathVariable("id") int id, @RequestBody Song song) {
        boolean result = songService.updateSongById(id, song);
        if (!result) {
            throw new ItemNotFoundException();
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteSong(@PathVariable("id") int id) {
        boolean result = songService.deleteSongById(id);
        if (!result) {
            throw new ItemNotFoundException();
        }
    }
}
