package be.pxl.ja;

import java.nio.file.Path;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SpotifyApp {

	private List<SpotifyRecord> spotifyRecords;

	public SpotifyApp() {
		// TODO: read data from file top50spotify2019.csv and assign to spotifyRecores
		spotifyRecords = SpotifyReader.loadSpotifyRecords(Path.of("src/main/resources/top_50_2023.csv"));
	}

	// 1. get the number of spotify records in the list (no stream!)
	public int getNumberOfSpotifyRecords() {
		return spotifyRecords.size();
	}

	// 2. get artist name of top 5 spotify records with the highest popularity
	public List<String> getTop5ArtistsWithHighestPopularity() {
		return spotifyRecords.stream()
				.sorted(Comparator.comparingInt(SpotifyRecord::getPopularity).reversed())
				.limit(5)
				.map(SpotifyRecord::getArtistName)
				.toList();
	}

	// 3. get number of unique artists
	public long getNumberOfUniqueArtists() {
		return spotifyRecords.stream()
				.map(SpotifyRecord::getArtistName)
				.distinct()
				.count();
	}

	// 4. all spotify records by artist
	public List<SpotifyRecord> getSpotifyRecordsByArtist(String artistName) {
		return spotifyRecords.stream()
				.filter(s -> s.getArtistName().equals(artistName))
				.toList();
	}

	// 5. get most danceable spotify record
	public SpotifyRecord getMostDanceableSpotifyRecord() {
		return spotifyRecords.stream()
				//.max((s1, s2) ->  Integer.compare(s1.getDanceability(), s2.getDanceability()))
				.max(Comparator.comparingDouble(SpotifyRecord::getDanceability))
				.orElse(null);
	}

	// 6. return a string with the names of all genres with a spotify record with danceability > 80.
	// The names must be separated by a comma and doubles are not allowed.
	public String getDanceableGenres() {
		return spotifyRecords.stream()
				.filter(s -> s.getDanceability() > 0.8)
				.flatMap(s -> s.getGenres().stream())
				.distinct()
				.map(Genre::toString)
				.collect(Collectors.joining(","));
	}

	// 7. get max duration of all spotify records
	public int getMaxDuration() {
		return spotifyRecords.stream()
				.mapToInt(SpotifyRecord::getDuration)
				.max()
				.orElse(-1);
	}

	// 8. get average duration of all spotify records
	public double getAverageDuration() {
		return spotifyRecords.stream()
				.mapToInt(SpotifyRecord::getDuration)
				.average()
				.orElse(0);
	}

	// 9. get most popular genre (the genre with the most spotify records)
	public Genre getMostPopularGenre() {
		return spotifyRecords.stream()
				.flatMap(record -> record.getGenres().stream()) // Flatten the List<Genre> to a Stream<Genre>
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences of each genre
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue()) // Find the entry with the maximum count
				.map(Map.Entry::getKey) // Get the genre from the entry
				.orElse(null);
	}

	public int getNumberOfReleases(Month month) {
		return (int) spotifyRecords.stream().filter(s -> s.getAlbumReleaseDate().getMonth() == month).count();
	}


	public void saveToFile(List<SpotifyRecord> list, Path filename) {
		// TODO: implement this method
	}

}
