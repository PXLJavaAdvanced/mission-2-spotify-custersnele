package be.pxl.ja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpotifyAppTest {

	private SpotifyApp spotifyApp;

	@BeforeEach
	void setUp() {
		spotifyApp = new SpotifyApp();
	}

	@Test
	void getNumberOfSpotifyRecords() {
		assertEquals(50, spotifyApp.getNumberOfSpotifyRecords());
	}

	@Test
	void getTop5ArtistsWithHighestPopularity() {
		List<String> top5 = spotifyApp.getTop5ArtistsWithHighestPopularity();
		assertEquals("Taylor Swift", top5.get(0));
		assertEquals("Arctic Monkeys", top5.get(1));
		assertEquals("Harry Styles", top5.get(2));
		assertEquals("The Weeknd", top5.get(3));
		assertEquals("Olivia Rodrigo", top5.get(4));
	}

	@Test
	void getNumberOfUniqueArtists() {
		assertEquals(41, spotifyApp.getNumberOfUniqueArtists());
	}

	@Test
	void getSpotifyRecordsByArtist() {
		List<SpotifyRecord> records = spotifyApp.getSpotifyRecordsByArtist("The Weeknd");
		assertEquals(4, records.size());
		List<String> names = records.stream().map(SpotifyRecord::getArtistName).distinct().toList();
		assertEquals(1, names.size());
		assertEquals("The Weeknd", names.get(0));
	}

	@Test
	void getMostDanceableSpotifyRecord() {
		SpotifyRecord mostDanceable = spotifyApp.getMostDanceableSpotifyRecord();
		assertEquals("Bad Bunny", mostDanceable.getArtistName());
		assertEquals("Me Porto Bonito", mostDanceable.getTrackName());
	}

	@Test
	void getDanceableGenres() {
		String danceableGenres = spotifyApp.getDanceableGenres();
		System.out.println(danceableGenres);
		assertTrue(danceableGenres.contains("REGGAETON"));
		assertTrue(danceableGenres.contains("POP"));
		assertTrue(danceableGenres.contains("HIP_HOP"));
		assertTrue(danceableGenres.contains("DANCE_POP"));
		assertTrue(danceableGenres.contains("K_POP"));
		assertTrue(danceableGenres.contains(","));
	}

	@Test
	void getMaxDuration() {
		assertEquals(272373, spotifyApp.getMaxDuration());
	}

	@Test
	void getAverageDuration() {
		assertEquals(200458.1, spotifyApp.getAverageDuration());
	}

	@Test
	void getSpotifyRecordsReleasedInApril() {
		assertEquals(5, spotifyApp.getNumberOfReleases(Month.APRIL));
	}

	@Test
	void getMostPopularGenre() {
		assertEquals(Genre.POP, spotifyApp.getMostPopularGenre());
	}
}
