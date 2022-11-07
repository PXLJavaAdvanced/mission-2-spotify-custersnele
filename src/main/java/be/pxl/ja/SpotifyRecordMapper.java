package be.pxl.ja;

public class SpotifyRecordMapper {

    public static SpotifyRecord mapDataToSpotifyRecord(String line) {
        String[] data = line.split(";");
        SpotifyRecord spotifyRecord = new SpotifyRecord();
        spotifyRecord.setId(Integer.parseInt(data[0]));
        spotifyRecord.setTrackName(data[1]);
        spotifyRecord.setArtistName(data[2]);
        spotifyRecord.setGenre(Genre.valueOf(data[3].replace(" ", "_").toUpperCase()));
        spotifyRecord.setBpm(Integer.parseInt(data[4]));
        spotifyRecord.setEnergy(Integer.parseInt(data[5]));
        spotifyRecord.setDanceability(Integer.parseInt(data[6]));
        spotifyRecord.setLoudness(Integer.parseInt(data[7]));
        spotifyRecord.setLiveness(Integer.parseInt(data[8]));
        spotifyRecord.setValence(Integer.parseInt(data[9]));
        spotifyRecord.setLength(Integer.parseInt(data[10]));
        spotifyRecord.setAcousticness(Integer.parseInt(data[11]));
        spotifyRecord.setSpeechiness(Integer.parseInt(data[12]));
        spotifyRecord.setPopularity(Integer.parseInt(data[13]));
        return spotifyRecord;
    }
}
