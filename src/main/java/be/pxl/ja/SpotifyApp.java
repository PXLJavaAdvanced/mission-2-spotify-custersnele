package be.pxl.ja;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class SpotifyApp {

	private List<SpotifyRecord> spotifyRecords;

	public SpotifyApp() {
		// TODO: read data from file top50spotify2019.csv and assign to spotifyRecores
		spotifyRecords = SpotifyReader.loadSpotifyRecords(Path.of("src/main/resources/top50spotify2019.csv"));
	}

	// 1. get the number of spotify records in the list (no stream!)
	public int getNumberOfSpotifyRecords() {
		return spotifyRecords.size();
	}

	// 2. get artist name of top 5 spotify records with highest popularity
	public List<String> getTop5ArtistsWithHighestPopularity() {
		return spotifyRecords.stream()
				.sorted()
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
				.max(Comparator.comparingInt(SpotifyRecord::getDanceability))
				.orElse(null);
	}

	// 6. return a string with the names of all genres with a spotify record with danceability > 80.
	// The names must be separated by a comma and doubles are not allowed.
	public String getDanceableGenres() {
		return spotifyRecords.stream()
				.filter(s -> s.getDanceability() > 80)
				.map(s -> s.getGenre().toString())
				.distinct()
				//.map(Genre::toString)
				.collect(Collectors.joining(","));
	}

	// 7. get max length of all spotify records
	public int getMaxLength() {
		return spotifyRecords.stream()
				.mapToInt(SpotifyRecord::getLength)
				.max()
				.orElse(-1);
	}

	// 8. get most popular genre (the genre with the most spotify records)
	public Genre getMostPopularGenre() {
		Map<Genre, Integer> genreCount = new HashMap<>();
		for (Genre genre : Genre.values()) {
			genreCount.put(genre, (int) spotifyRecords.stream().filter(s -> s.getGenre() == genre).count());
		}
		Optional<Map.Entry<Genre, Integer>> max = genreCount.entrySet()
				.stream()
				.max(Comparator.comparingInt(Map.Entry::getValue));
		if (max.isPresent()) {
			return max.get().getKey();
		} else {
			return null;
		}

	}


	public void saveToFile(List<SpotifyRecord> list, Path filename) {
		// TODO: implement this method
	}

}
