package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Album {

	private List<Track> tracks;
	
	public Album() {
		super();
		this.tracks = new ArrayList<Track>();
	}

	public void setTrack(Track track) {
		tracks.add(track);
	}
	
	public Stream<Track> getTracks() {
        return tracks.stream();
    }
}
