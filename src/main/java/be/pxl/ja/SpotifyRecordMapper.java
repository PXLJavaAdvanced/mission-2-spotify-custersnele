package be.pxl.ja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SpotifyRecordMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static SpotifyRecord mapDataToSpotifyRecord(String line) throws InvalidSpotifyRecordException {
        String[] data = line.split(";");
        if (data.length != 19) {
            throw new InvalidSpotifyRecordException("Error parsing spotify record [" + line + "]");
        }
        try {
            SpotifyRecord spotifyRecord = new SpotifyRecord();
            spotifyRecord.setTrackName(data[1]);
            spotifyRecord.setArtistName(data[0]);
            spotifyRecord.setExplicit(Boolean.parseBoolean(data[2]));
            spotifyRecord.setAlbumReleaseDate(LocalDate.parse(data[3], FORMATTER));
            mapGenreList(spotifyRecord, data[4]);
            spotifyRecord.setDanceability(Double.parseDouble(data[5]));
            spotifyRecord.setValence(Double.parseDouble(data[6]));
            spotifyRecord.setEnergy(Double.parseDouble(data[7]));
            spotifyRecord.setLoudness(Double.parseDouble(data[8]));
            spotifyRecord.setAcousticness(Double.parseDouble(data[9]));
            spotifyRecord.setInstrumentalness(Double.parseDouble(data[10]));
            spotifyRecord.setLiveness(Double.parseDouble(data[11]));
            spotifyRecord.setSpeechiness(Double.parseDouble(data[12]));
            spotifyRecord.setKey(Integer.parseInt(data[13]));
            spotifyRecord.setTempo(Double.parseDouble(data[14]));
            spotifyRecord.setMode(Integer.parseInt(data[15]));
            spotifyRecord.setDuration(Integer.parseInt(data[16]));
            spotifyRecord.setTimeSignature(Integer.parseInt(data[17]));
            spotifyRecord.setPopularity(Integer.parseInt(data[18]));
            return spotifyRecord;
        } catch (NumberFormatException e) {
            throw new InvalidSpotifyRecordException("Error parsing spotify record [" + line + "]");
        }
    }

    private static void mapGenreList(SpotifyRecord spotifyRecord, String data) {
        String[] parts = data.replaceAll("\\[", "").replaceAll("]", "").replaceAll("'", "").split(",");
        for (String part : parts) {
            Genre byDisplayName = Genre.findByDisplayName(part);
            if (byDisplayName == null) {
                System.out.println("ADD GENRE: " + part);
            }
            spotifyRecord.addGenre(byDisplayName);
        }
    }
}
