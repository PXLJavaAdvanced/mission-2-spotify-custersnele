package be.pxl.ja;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpotifyRecordMapperTest {

    @Test
    public void mapDataToSpotifyRecord() throws InvalidSpotifyRecordException {
        String line = "Taylor Swift;Cruel Summer;False;2019-08-23;['pop'];0.552;0.564;0.702;-5.707;0.117;2.06e-05;0.105;0.157;9;169.994;1;178427;4;99";
        SpotifyRecord spotifyRecord = SpotifyRecordMapper.mapDataToSpotifyRecord(line);
        assertEquals("Cruel Summer", spotifyRecord.getTrackName());
        assertEquals("Taylor Swift", spotifyRecord.getArtistName());
        assertEquals(1, spotifyRecord.getGenres().size());
	    assertEquals(List.of(Genre.POP), spotifyRecord.getGenres());
        assertEquals(0.702, spotifyRecord.getEnergy());
        assertEquals(0.552, spotifyRecord.getDanceability());
        assertEquals(-5.707, spotifyRecord.getLoudness());
        assertEquals(0.105, spotifyRecord.getLiveness());
        assertEquals(0.564, spotifyRecord.getValence());
        assertEquals(178427, spotifyRecord.getDuration());
        assertEquals(0.117, spotifyRecord.getAcousticness());
        assertEquals(0.157, spotifyRecord.getSpeechiness());
        assertEquals(99, spotifyRecord.getPopularity());
    }
}
