package be.pxl.ja;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpotifyRecordMapperTest {

    @Test
    public void mapDataToSpotifyRecord() {
        String line = "32;7 rings;Ariana Grande;dance pop;140;32;78;-11;9;33;179;59;33;89";
        SpotifyRecord spotifyRecord = SpotifyRecordMapper.mapDataToSpotifyRecord(line);
        assertEquals(32, spotifyRecord.getId());
        assertEquals("7 rings", spotifyRecord.getTrackName());
        assertEquals("Ariana Grande", spotifyRecord.getArtistName());
        assertEquals(Genre.DANCE_POP, spotifyRecord.getGenre());
        assertEquals(140, spotifyRecord.getBpm());
        assertEquals(32, spotifyRecord.getEnergy());
        assertEquals(78, spotifyRecord.getDanceability());
        assertEquals(-11, spotifyRecord.getLoudness());
        assertEquals(9, spotifyRecord.getLiveness());
        assertEquals(33, spotifyRecord.getValence());
        assertEquals(179, spotifyRecord.getLength());
        assertEquals(59, spotifyRecord.getAcousticness());
        assertEquals(33, spotifyRecord.getSpeechiness());
        assertEquals(89, spotifyRecord.getPopularity());
    }
}
