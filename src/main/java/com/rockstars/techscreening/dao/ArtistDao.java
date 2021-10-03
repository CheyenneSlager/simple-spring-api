package com.rockstars.techscreening.dao;

import com.rockstars.techscreening.model.Artist;

import java.util.List;
import java.util.Optional;

/**
 * The ArtistDao interface defines the methods that must be implemented to perform CRUD operations regarding artists
 * on the database.
 */
public interface ArtistDao {

    /**
     * Inserts artists into the database.
     * @param artists a list of artists.
     * @return true if the insertion was successful, false otherwise.
     */
    public boolean insertArtists(List<Artist> artists);

    /**
     * Selects all artists from the database.
     * @return a list containing all artists.
     */
    List<Artist> selectAllArtists();

    /**
     * Selects an artist from the database by id.
     * @param id the id of the artist.
     * @return the artist if it was found, nothing otherwise.
     */
    public Optional<Artist> selectArtistById(int id);

    /**
     * Selects an artist from the database by name.
     * @param name the name of the artist.
     * @return the artist if it was found, nothing otherwise.
     */
    public Optional<Artist> selectArtistByName(String name);

    /**
     * Deletes an artist from the database by id.
     * @param id the id of the artist.
     * @return true if the artist was found and deleted, false otherwise.
     */
    public boolean deleteArtistById(int id);

    /**
     * Updates the details of an artist in the database.
     * @param id the id of the artist.
     * @param artist the new details of the artist.
     * @return true if the artist was found and updated, false otherwise.
     */
    public boolean updateArtistById(int id, Artist artist);
}
