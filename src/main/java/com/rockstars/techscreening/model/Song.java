package com.rockstars.techscreening.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Song {

    @NotBlank
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private int year;
    private String artist;
    private String shortName;
    private int bpm;
    private int duration;
    @NotBlank
    private String genre;
    private String spotifyId;
    private String album;

    /**
     * Constructor method.
     *
     * @param id        id
     * @param name      name
     * @param year      year
     * @param artist    artist
     * @param shortName short name
     * @param bpm       bpm
     * @param duration  duration
     * @param genre     genre
     * @param spotifyId spotify id
     * @param album     album
     */
    public Song(@JsonProperty("Id") int id,
                @JsonProperty("Name") String name,
                @JsonProperty("Year") int year,
                @JsonProperty("Artist") String artist,
                @JsonProperty("Shortname") String shortName,
                @JsonProperty("Bpm") int bpm,
                @JsonProperty("Duration") int duration,
                @JsonProperty("Genre") String genre,
                @JsonProperty("SpotifyId") String spotifyId,
                @JsonProperty("Album") String album) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.artist = artist;
        this.shortName = shortName;
        this.bpm = bpm;
        this.duration = duration;
        this.genre = genre;
        this.spotifyId = spotifyId;
        this.album = album;
    }

    /**
     * Determines whether a song has the right characteristics.
     *
     * @return true iff the song is from before 2016 and its genre contains "Metal", and false otherwise.
     */
    public boolean songFilter() {
        return this.getYear() < 2016 && this.getGenre().contains("Metal");
    }

    /**
     * Getter method for the id.
     *
     * @return the id of the song.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the year.
     *
     * @return the year of the song.
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter method for the year.
     *
     * @param year the year of the song.
     */
    public void setYear(int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Getter method for the genre.
     *
     * @return the genre of the song.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Setter method for the genre.
     *
     * @param genre the genre of the song.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
