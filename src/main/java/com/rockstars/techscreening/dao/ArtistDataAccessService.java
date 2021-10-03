package com.rockstars.techscreening.dao;

import com.rockstars.techscreening.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The data access service functions as a "fake" in-memory database.
 */
@Repository("fakeArtistDao")
public class ArtistDataAccessService implements ArtistDao {

    private static List<Artist> artists = new ArrayList<>();

    @Override
    public boolean insertArtists(List<Artist> newArtists) {
        List<String> names = artists.stream().map(s -> s.getName()).toList();
        List<Integer> ids = artists.stream().map(s -> s.getId()).toList();
        for (Artist newArtist : newArtists) {
            if (!names.contains(newArtist.getName()) && !ids.contains(newArtist.getId())) {
                artists.add(newArtist);
            }
        }
        return true;
    }

    @Override
    public Optional<Artist> selectArtistById(int id) {
        return artists.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    @Override
    public List<Artist> selectAllArtists() {
        return artists;
    }

    @Override
    public Optional<Artist> selectArtistByName(String name) {
        return artists.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
    }

    @Override
    public boolean deleteArtistById(int id) {
        Optional<Artist> artist = selectArtistById(id);
        if (artist.isEmpty()) {
            return false;
        } else {
            artists.remove(artist.get());
            return true;
        }
    }

    @Override
    public boolean updateArtistById(int id, Artist artist) {
        return selectArtistById(id)
                .map(a -> {
                    int index = artists.indexOf(a);
                    if (index >= 0) {
                        artists.set(index, artist);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }
}
