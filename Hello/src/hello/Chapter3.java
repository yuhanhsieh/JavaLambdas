package hello;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class Chapter3 {

	public Chapter3() {
		super();
	}

	@Test
	public void testFilter() {
		List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
				  .filter(value -> Character.isDigit(value.charAt(0)))
				  .collect(Collectors.toList());

		List<String> expected = new ArrayList<>();
		expected.add("1abc");
		
		assertEquals("filtered elements", expected, beginningWithNumbers);

		//

		List<Artist> allArtists = new ArrayList<>();
		allArtists.add(new Artist("Tokyo"));
		allArtists.add(new Artist("London"));
		allArtists.add(new Artist("New York"));
		
		long count = allArtists.stream()
							   .filter(artist -> artist.isForm("London"))
							   .count();
		
		assertEquals("count from London", 1, count);
	}
	
	@Test
	public void testMap() {
		List<String> collected = Stream.of("a", "b", "hello")
									   .map(string -> string.toUpperCase())
									   .collect(Collectors.toList());
		// [A, B, HELLO]
		List<String> expectedData = new ArrayList<String>();
		expectedData.add("A");
		expectedData.add("B");
		expectedData.add("HELLO");
		
		assertEquals("mapped elements", collected, expectedData);
	}
	
	@Test
	public void testFlatMap() {
		List<Integer> list_Integer_1 = new ArrayList<>();
		list_Integer_1.add(1);
		list_Integer_1.add(2);
		List<Integer> list_Integer_2 = new ArrayList<>();
		list_Integer_2.add(3);
		list_Integer_2.add(4);
		
		List<Integer> together = Stream.of(list_Integer_1, list_Integer_2)
									   .flatMap(numbers -> numbers.stream())
									   .collect(Collectors.toList());
		
		list_Integer_1.addAll(list_Integer_2);
		List<Integer> expectedList = list_Integer_1;
		
		assertEquals("flat map elements", expectedList, together);
	}

	@Test
	public void testMin() {
		List<Track> tracks = Utility.asList(new Track("Baka", 524),
											new Track("Violets for Your Furs", 378),
											new Track("Time Was", 451));
		
		Track shortestTrack = tracks.stream()
									.min(Comparator.comparing(track -> track.getLength()))
									.get();
		
		assertEquals("shortest track", 378, shortestTrack.getLength());
	}

	@Test
	public void testReduce() {
		int sum = Stream.of(1,2,3)
						.reduce(0, (acc, element) -> acc + element);
		
		assertEquals("sum", 6, sum);
	}

	@Test
	public void testFindTrackLengthGreaterThanOneMinute() {
		Track track_1 = new Track("Kero", 125);
		Track track_2 = new Track("Tama", 33);
		Track track_3 = new Track("Giro", 40);
		Track track_4 = new Track("kuru", 99);
		Track track_5 = new Track("Gero", 65);
		
		Album album_1 = new Album();
		album_1.setTrack(track_1);
		album_1.setTrack(track_2);
		Album album_2 = new Album();
		album_2.setTrack(track_3);
		album_2.setTrack(track_4);
		album_2.setTrack(track_5);
		
		List<Album> albums = new ArrayList<>();
		albums.add(album_1);
		albums.add(album_2);
		
		Set<String> expected = new HashSet<>();
		expected.add("Kero");
		expected.add("kuru");
		expected.add("Gero");
		
		Radio radio = new Radio();
		Set<String> macthedTracks_ver1 = radio.findLongTracks_ver1(albums);
		Set<String> macthedTracks_ver2 = radio.findLongTracks_ver2(albums);
		Set<String> macthedTracks_ver3 = radio.findLongTracks_ver3(albums);
		Set<String> macthedTracks_ver4 = radio.findLongTracks_ver4(albums);
		
		assertEquals("grater than 1 minute tracks", expected, macthedTracks_ver1);
		assertEquals("grater than 1 minute tracks", expected, macthedTracks_ver2);
		assertEquals("grater than 1 minute tracks", expected, macthedTracks_ver3);
		assertEquals("grater than 1 minute tracks", expected, macthedTracks_ver4);
	}
}