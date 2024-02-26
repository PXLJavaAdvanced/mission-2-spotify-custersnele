## 2019 spotify top 50

### Introductie
Gegeven is een dataset die als muziek in de oren zal klinken, de top 50 van Spotify van 2023
(top_50_2023.csv). In deze opdracht ga je leren om de data in te lezen. Vervolgens ga
je bewerkingen maken met streams en lambda expressies.
### Leerdoelen:

- File I/O
- ArrayList
- Streams en lambda expressies
- Unit testen schrijven
- Maven gebruiken voor dependencies

### Probleemstelling

Het csv bestand bestaat uit een 50 lijnen met telkens dezelfde opbouw, de eerste
regel van het bestand bevat de kolomnamen:

     artist_name;track_name;is_explicit;album_release_date;genres;danceability;valence;energy;loudness;acousticness;instrumentalness;liveness;speechiness;key;tempo;mode;duration_ms;time_signature;popularity

| Field              | Description                                                                              | 
|--------------------|------------------------------------------------------------------------------------------|
| track_name         | The track name                                                                           |
| artist_name        | The artist name                                                                          |
| is_explicit        | Indicates whether the track contains explicit content                                    |
| album_release_date | The date when the track was released                                                     |
| genres             | A list of genres associated with the track's artist(s)                                   |
| danceability       | A measure from 0.0 to 1.0 indicating how suitable a track is for dancing                 |
| valence            | A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track        |
| energy             | A measure from 0.0 to 1.0 that represents a perceptual measure of intensity and activity |
| loudness           | The overall loudness of a track in decibels (dB)                                         |
| acousticness       | A measure from 0.0 to 1.0 indicating the likelihood of the track being acoustic          |
| instrumentalness           | Predicts whether a track contains no vocals                                              |
| liveness | Detects the presence of an audience in the recording                                     | 
| speechiness | Detects the presence of spoken words in a track                                          |
| key | The key the track is in |
| tempo | The overall estimated tempo of a track in beats per minute (BPM) |
| mode | The modality of the track |
| duration_ms | The length of the track in milliseconds |
| time_signature | An estimated overall time signature of a track |
| popularity | A score between 0 and 100, with 100 being the most popular |
 
 ### Gegeven
De klasse SpotifyRecord.
  
### Taak 1

Vervolledig de helper-klasse SpotifyRecordMapper met de static methode
mapDataToSpotifyRecord om de data van één spotify record uit het bestand om te
vormen naar een SpotifyRecord-object. Indien een fout optreedt tijdens het inlezen van een record, dan gooi je een unchecked InvalidSpotifyRecordException.
Schrijf unit testen om te controleren of de methode correct werkt.
  
### Taak 2

Vervolledig de klasse SpotifyReader. Implementeer de methode loadSpotifyRecords. Hou hierbij rekening met de volgende richtlijnen:
- Gebruik de static methode mapDataToSpotifyRecord in de klasse
  SpotifyRecordMapper om de data van een spotify record uit het bestand om te
  vormen naar een SpotifyRecord-object.
- Alle SpotifyRecord-objecten worden in een List opgeslagen die wordt
  teruggegeven als resultaat.
- De inlees-methode van de SpotifyReader klasse heeft als argumenten het Path
  naar de te lezen file.
- Als bij het aanroepen van de SpotifyRecordMapper een exception wordt opgegooid
  omdat een lijn niet ingelezen kan worden door ontbrekende data, dan zorg je dat
  de SpotifyReader de foutboodschap met System.err.println() afdrukt en je
  garandeert dat de SpotifyReader verder gaat met het inlezen van overige
  SpotifyRecords.

### Taak 3
  Vul nu in de klasse SpotifyApp de onderstaande methoden aan. In elke methode (behave
  getNumberOfSpotifyRecords) moet minstens één stream gebruikt worden om de
  oplossing te bekomen.
  Enkel oplossingen die door middel van een stream slagen in de unit testen worden
  goedgekeurd. Met behulp van de klasse SpotifyAppTest kan je je implementatie testen.
  Je mag geen wijzigingen aanbrengen in het bestand top50spotify2019.csv en de
  testklasse SpotifyAppTest.
  In de constructor van de klasse SpotifyApp gebruik je eerst de SpotifyReader om het
  bestand top_50_2023.csv in te lezen. De ingelezen SpotifyRecords worden
  toegekend aan een instantievariabele van de klasse SpotifyApp.

1. **int getNumberOfSpotifyRecords()**

   Geef het aantal spotify records in de lijst. Hiervoor gebruik je geen stream!

2. **List<String> getTop5ArtistsWithHighestPopularity()**

   Geef een lijst terug met de namen van de artiesten van de 5 populairste spotify
   records. (Je mag ervan uitgaan dat het 5 verschillende namen zijn.)

3. **int getNumberOfUniqueArtists()**
   
    Hoeveel unieke namen van artiesten zijn er in de lijst?

4. **List<SpotifyRecord> getSpotifyRecordsByArtist(String artistName)**

    Geen voor de gegeven artiest alle SpotifyRecords uit de lijst.

5. **SpotifyRecord getMostDanceableSpotifyRecord()**
   
    Welke SpotifyRecord heeft de hoogste waarde voor danceability?

6. **String getDanceableGenres()**
   
    Geef de verschillende genres terug met een danceability groter of gelijk aan 0.8 in
   een String. De namen van de genres moeten gescheiden zijn door een komma en
   mogen geen dubbels bevatten.

7. **int getMaxDuration()**

   Wat is de langste duur van een SpotifyRecord?

8. **int getAverageLength()**
    Wat is de gemiddelde duur van een SpotifyRecord?

9. **Genre getMostPopularGenre()**
   Geef het genre dat het meeste voorkomt. Met andere woorden, van welk genre zijn er het meeste SpotifyRecords?

10. **int getNumberOfReleases(Month month)**
    Geef het aantal SpotifyRecords dat is uitgekomen in de opgegeven maand.

Je kan de verschillende implementaties testen met de testklasse SpotifyAppTest.

### Taak 4

Tenslotte implementeer je een methode saveToFile in de klasse SpotifyApp. De methode
saveToFile heeft 1 parameter: een lijst van SpotifyRecords.

In de klasse SpotifyAppRunner gebruik je de methode saveToFile om de SpotifyRecords
van Taylor Swift (zie variabele records) weg te schrijven naar het bestand taylor.txt in de
resources-folder.
   
### Taak 5

Het hoofdprogramma is gegeven, maar het wegschrijven van de titels van de records van
Taylor Swift ontbreekt nog in de code. Voeg deze functionaliteit nog toe.

### Output
Wanneer je het hoofdprogramma in de klasse SpotifyAppRunner uitvoert zou je de onderstaande output moeten krijgen.

```
Error parsing spotify record [Tom Odell;Another Love;True;2013-06-24;['pop'];0.445;0.131;0.537;0.04;4;122.769;0;244360;4;72]
Error parsing spotify record [SZA;Snooze;True;2022-12-09;['pop', 'r&b', 'rap'];0.559;0.392;verkeerde;data;0.141;0.0;0.11;0.132;5;143.008;1;201800;4;93]
** Number of spotify records: 50
** Number of unique artists: 41
** Songs by Taylor Swift saved to file.
** Top 5 artists: 
Taylor Swift
Arctic Monkeys
Harry Styles
The Weeknd
Olivia Rodrigo
** Most popular genre: POP
** Danceable genres: REGGAETON,POP,HIP_HOP,DANCE_POP,K_POP
** Max duration: 272373
** Average duration: 200458.1
** Number of releases in April: 5
** Most danceable: 
SpotifyRecord{trackName='Me Porto Bonito', artistName='Bad Bunny', popularity=89}
 ```
