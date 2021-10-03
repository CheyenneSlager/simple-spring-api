package com.rockstars.techscreening.api;

import com.rockstars.techscreening.exception.ItemNotFoundException;
import com.rockstars.techscreening.model.Artist;
import com.rockstars.techscreening.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/artist")
@RestController
public class ArtistController {

    private final ArtistService artistService;

    @Autowired  // Dependency injection.
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public void addArtists(@Valid @NotNull @RequestBody Artist[] artists) {
        artistService.addArtists(Arrays.stream(artists).toList());
    }

    @GetMapping(path = "/all")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping
    public Artist getArtistByName(@RequestParam("name") String name) {
        Optional<Artist> result = artistService.getArtistByName(name);
        if (result.isEmpty()) {
            throw new ItemNotFoundException();
        }
        return result.get();
    }

    @PutMapping(path = "{id}")
    public void updateArtistById(@PathVariable("id") int id, @RequestBody Artist artist) {
        boolean result = artistService.updateArtistById(id, artist);
        if (!result) {
            throw new ItemNotFoundException();
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteArtistBy(@PathVariable("id") int id) {
        boolean result = artistService.deleteArtistById(id);
        if (!result) {
            throw new ItemNotFoundException();
        }
    }
}
