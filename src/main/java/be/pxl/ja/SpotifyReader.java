package be.pxl.ja;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpotifyReader {
    public static List<SpotifyRecord> loadSpotifyRecords(Path path) {
        System.out.println(path.toAbsolutePath());
        System.out.println(path.getClass());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine(); // ignore first line
            while ( (line = reader.readLine()) != null) {
                System.out.println(line);
                line.split(";");
            }
        } catch (IOException e) {
            System.err.println("Er is een probleem met het lezen van het bestand. " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
