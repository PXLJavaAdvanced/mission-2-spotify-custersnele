package be.pxl.ja;

import java.time.Month;
import java.util.List;

public class SpotifyAppRunner {

	public static void main(String[] args) {
		SpotifyApp spotifyApp = new SpotifyApp();
		System.out.println("** Number of spotify records: " + spotifyApp.getNumberOfSpotifyRecords());
		System.out.println("** Number of unique artists: " + spotifyApp.getNumberOfUniqueArtists());
		System.out.println("** Songs by Taylor Swift saved to file.");
		List<SpotifyRecord> records = spotifyApp.getSpotifyRecordsByArtist("Taylor Swift");
		// TODO: save record titels to file
		System.out.println("** Top 5 artists: ");
		spotifyApp.getTop5ArtistsWithHighestPopularity().forEach(System.out::println);
		Genre mostPopularGenre = spotifyApp.getMostPopularGenre();
		System.out.println("** Most popular genre: " + mostPopularGenre);
		System.out.println("** Danceable genres: " + spotifyApp.getDanceableGenres());
		System.out.println("** Max duration: " + spotifyApp.getMaxDuration());
		System.out.println("** Average duration: " + spotifyApp.getAverageDuration());
		System.out.println("** Number of releases in April: " + spotifyApp.getNumberOfReleases(Month.APRIL));
		System.out.println("** Most danceable: ");
		SpotifyRecord mostDanceable = spotifyApp.getMostDanceableSpotifyRecord();
		System.out.println(mostDanceable);
	}

}
