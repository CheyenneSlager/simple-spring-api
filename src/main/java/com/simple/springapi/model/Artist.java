package com.simple.springapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Artist {

    @NotBlank
    private int id;
    @NotBlank
    private String name;

    /**
     * Constructor method.
     * @param id id
     * @param name name
     */
    public Artist(@JsonProperty("Id") int id,
                  @JsonProperty("Name") String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter method for the id.
     * @return the id of the artist.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for the name.
     * @return the name of the artist.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
