package com.simple.springapi.dao;

import com.simple.springapi.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The data access service functions as a "fake" in-memory database.
 */
@Repository("fakeSongDao")
public class SongDataAccessService implements SongDao {

    private static List<Song> songs = new ArrayList<>();

    @Override
    public boolean insertSongs(List<Song> newSongs) {
        for (Song song : newSongs) {
            if (!songs.stream().map(s -> s.getId()).toList().contains(song.getId())) {
                songs.add(song);
            }
        }
        return true;
    }

    @Override
    public List<Song> selectAllSongs() {
        return songs;
    }

    @Override
    public Optional<Song> selectSongById(int id) {
        return songs.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public List<Song> selectSongsByGenre(String genre) {
        return songs
                .stream()
                .filter(s -> s.getGenre().equals(genre))
                .toList();
    }

    @Override
    public boolean deleteSongById(int id) {
        Optional<Song> song = selectSongById(id);
        if (song.isEmpty()) {
            return false;
        } else {
            songs.remove(song.get());
            return true;
        }
    }

    @Override
    public boolean updateSongById(int id, Song song) {
        return selectSongById(id)
                .map(s -> {
                    int index = songs.indexOf(s);
                    if (index >= 0) {
                        songs.set(index, song);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    @Override
    public List<Song> getAllSongs() {
        return songs;
    }

}
