package be.pxl.ja;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Genre {
	DANCE_POP("dance pop"),
	POP,
	K_POP("k-pop"),
	RNB("r&b"),
	RAP,
	MUSICA_MEXICANA("musica mexicana"),
	AFROBEATS,
	REGGAETON,
	ROCK("rock", "garage rock", "modern rock", "piano rock"),
	COUNTRY,
	HIP_HOP("hip hop", "trap");

	private List<String> displayNames;

	Genre(String... displayNames) {
		this.displayNames = Arrays.asList(displayNames);
	}

	Genre() {
		this.displayNames = Collections.singletonList(name().toLowerCase());
	}

	public static Genre findByDisplayName(String displayName) {
		return Arrays.stream(Genre.values()).filter(g -> g.displayNames.contains(displayName.trim())).findAny().orElse(null);
	}
}
