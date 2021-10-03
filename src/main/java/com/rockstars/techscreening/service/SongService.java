package com.rockstars.techscreening.service;

import com.rockstars.techscreening.dao.SongDao;
import com.rockstars.techscreening.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // By default, this class is instantiated as a singleton, which is then injected into other classes.
public class SongService {

    private final SongDao songDao;

    @Autowired  // Dependency injection.
    public SongService(@Qualifier("fakeSongDao") SongDao songDao) {
        this.songDao = songDao;
    }

    public boolean addSongs(List<Song> songs) {
        List<Song> filteredSongs = songs.
                stream().
                filter(Song::songFilter).
                toList();
        return songDao.insertSongs(filteredSongs);
    }

    public List<Song> getSongsByGenre(String genre) {
        return songDao.selectSongsByGenre(genre);
    }

    public boolean updateSongById(int id, Song song) {
        if (song.songFilter()) {
            return songDao.updateSongById(id, song);
        } else return false;
    }

    public boolean deleteSongById(int id) {
        return songDao.deleteSongById(id);
    }

    public List<Song> getAllSongs() {
        return songDao.getAllSongs();
    }
}
