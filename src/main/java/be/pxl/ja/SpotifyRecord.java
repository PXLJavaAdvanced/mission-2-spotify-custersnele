package be.pxl.ja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpotifyRecord {
	private String trackName;
	private String artistName;
	private List<Genre> genres = new ArrayList<>();
	private boolean explicit;
	private LocalDate albumReleaseDate;
	private double danceability;
	private double valence;
	private double energy;
	private double loudness;
	private double acousticness;
	private double instrumentalness;
	private double liveness;
	private double speechiness;
	private double key;
	private double tempo;
	private int mode;
	private int duration;
	private int timeSignature;
	private int popularity;

	public String getTrackName() {
		return trackName;
	}

	public boolean isExplicit() {
		return explicit;
	}

	public void setExplicit(boolean explicit) {
		this.explicit = explicit;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}


	public void setAlbumReleaseDate(LocalDate albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}

	public LocalDate getAlbumReleaseDate() {
		return albumReleaseDate;
	}

	public void setGenre(List<Genre> genres) {
		this.genres = genres;
	}

	public void addGenre(Genre genre) {
		genres.add(genre);
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public double getDanceability() {
		return danceability;
	}

	public void setDanceability(double danceability) {
		this.danceability = danceability;
	}

	public double getValence() {
		return valence;
	}

	public void setValence(double valence) {
		this.valence = valence;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public double getLoudness() {
		return loudness;
	}

	public void setLoudness(double loudness) {
		this.loudness = loudness;
	}

	public double getAcousticness() {
		return acousticness;
	}

	public void setAcousticness(double acousticness) {
		this.acousticness = acousticness;
	}

	public double getInstrumentalness() {
		return instrumentalness;
	}

	public void setInstrumentalness(double instrumentalness) {
		this.instrumentalness = instrumentalness;
	}

	public double getLiveness() {
		return liveness;
	}

	public void setLiveness(double liveness) {
		this.liveness = liveness;
	}

	public double getSpeechiness() {
		return speechiness;
	}

	public void setSpeechiness(double speechiness) {
		this.speechiness = speechiness;
	}

	public double getKey() {
		return key;
	}

	public void setKey(double key) {
		this.key = key;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTimeSignature() {
		return timeSignature;
	}

	public void setTimeSignature(int timeSignature) {
		this.timeSignature = timeSignature;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	@Override
	public String toString() {
		return "SpotifyRecord{" +
				"trackName='" + trackName + '\'' +
				", artistName='" + artistName + '\'' +
				", popularity=" + popularity +
				'}';
	}
}
