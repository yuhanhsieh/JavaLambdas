package bookcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Radio {

	public Radio() {
		super();
	}

	public Set<String> findLongTracks_ver1(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
			  .forEach(album -> {
				  album.getTracks()
				  	   .forEach(track -> {
				  		   if (track.getLength() > 60) {
				  			   String name = track.getName();
				  			   trackNames.add(name);
				  		   }
				  	   });
			  });
		return trackNames;
	}

	public Set<String> findLongTracks_ver2(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
			  .forEach(album -> {
				  album.getTracks()
				  	   .filter(track -> track.getLength() > 60)
				  	   .map(track -> track.getName())
				  	   .forEach(name -> trackNames.add(name));
			  });
		return trackNames;
	}

	public Set<String> findLongTracks_ver3(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
			  .flatMap(album -> album.getTracks())
		  	  .filter(track -> track.getLength() > 60)
			  .map(track -> track.getName())
			  .forEach(name -> trackNames.add(name));
		return trackNames;
	}

	public Set<String> findLongTracks_ver4(List<Album> albums) {
		return albums.stream()
					 .flatMap(album -> album.getTracks())
					 .filter(track -> track.getLength() > 60)
					 .map(track -> track.getName())
					 .collect(Collectors.toSet());
	}
	
}