package com.rockstars.techscreening.model;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongTests {

	private Song song;

	@BeforeEach
	private void init() {
		song = new Song(789,
				"Mr. Brightside",
				2004,
				"The Killers",
				"mrbrightside",
				148,
				223725,
				"Alternative",
				"7oK9VyNzrYvRFo7nQEYkWN",
				"Hot Fuss");
	}

	SongTests() throws JSONException {
	}

	@Test
	void filterRightYearRightGenreTest() {
		song.setYear(2004);
		song.setGenre("Metal");
		assert (song.songFilter());
	}

	@Test
	void filterWrongYearWrongGenreTest() {
		song.setYear(2010);
		song.setGenre("Alternative");
		assert (!song.songFilter());
	}

	@Test
	void filterRightYearWrongGenreTest() {
		assert (!song.songFilter());
	}

	@Test
	void filterWrongYearRightGenreTest() {
		song.setYear(2020);
		song.setGenre("Metal");
		assert (!song.songFilter());
	}

}
