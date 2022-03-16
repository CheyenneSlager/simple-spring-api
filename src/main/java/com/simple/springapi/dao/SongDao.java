package com.simple.springapi.dao;

import com.simple.springapi.model.Song;

import java.util.List;
import java.util.Optional;

/**
 * The SongDao interface defines the methods that must be implemented to perform CRUD operations regarding songs
 * on the database.
 */
public interface SongDao {

    /**
     * Adds new songs to the database.
     *
     * @param songs the new songs to be added
     * @return true if the insertion was successful, false otherwise.
     */
    public boolean insertSongs(List<Song> songs);

    /**
     * Selects all songs from the database.
     *
     * @return a list containing all songs.
     */
    public List<Song> selectAllSongs();

    /**
     * Selects all songs from the database.
     *
     * @return a list of songs.
     */
    public List<Song> getAllSongs();

    /**
     * Selects a song from the database by its identifier.
     *
     * @param id the id of the song.
     * @return the song with the given id if it exists, otherwise nothing.
     */
    public Optional<Song> selectSongById(int id);

    /**
     * Selects songs from the database by genre.
     *
     * @param genre the genre to filter on.
     * @return a list of songs, which will be empty if not matching songs were found.
     */
    public List<Song> selectSongsByGenre(String genre);

    /**
     * Updates a song by its it.
     *
     * @param id   the id of the song.
     * @param song the new information to be stored.
     * @return true if the updates was successful, false otherwise.
     */
    public boolean updateSongById(int id, Song song);

    /**
     * Deletes a song by its id.
     *
     * @param id the id of the song.
     * @return true if the song was found and deleted, false otherwise.
     */
    public boolean deleteSongById(int id);
}
