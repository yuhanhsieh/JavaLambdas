package bookcode;

import java.util.ArrayList;
import java.util.List;

public class Utility {

	public Utility() {
		super();
	}

	static List<Track> asList(Track... objects) {
		List<Track> list = new ArrayList<>();
		for (Track o : objects) {
			list.add(o);
		}		
		return list;
	}

}