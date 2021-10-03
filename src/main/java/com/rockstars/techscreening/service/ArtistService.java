package com.rockstars.techscreening.service;

import com.rockstars.techscreening.dao.ArtistDao;
import com.rockstars.techscreening.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // By default, this class is instantiated as a singleton, which is then injected into other classes.
public class ArtistService {

    private final ArtistDao artistDao;

    @Autowired  // Dependency injection.
    public ArtistService(@Qualifier("fakeArtistDao") ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    public boolean addArtists(List<Artist> artists) {
        return artistDao.insertArtists(artists);
    }

    public List<Artist> getAllArtists() {
        return artistDao.selectAllArtists();
    }

    public Optional<Artist> getArtistByName(String name) {
        return artistDao.selectArtistByName(name);
    }

    public boolean updateArtistById(int id, Artist artist) {
        return artistDao.updateArtistById(id, artist);
    }

    public boolean deleteArtistById(int id) {
        return artistDao.deleteArtistById(id);
    }
}
