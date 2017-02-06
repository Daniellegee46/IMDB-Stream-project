
//import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class IMDBDirectors {

	public static long countMovies(Path file) {

		String contents = null;
		
		try {
			contents = new String(Files.readAllBytes(Paths.get(file.toUri())), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		} // Read file into string
		
		//List<String> words = Arrays.asList(contents.split("\\t"));
		//words.SortBy.MOVIE;
		Stream<String> stream = Stream.of(contents.split("\t"));
		long count = stream.count();
		return count;

	}

	public static long countDirectors(Path file) {
		return 0;

	}

	public static List<String> getMoviesOfDirector(Path file, String last, String first, SortBy sort) {
		return null;

	}

	public static List<String> getMoviesInYear(Path file, int year, SortBy sort) {
		return null;

	}

	public static List<String> getDirectorWithMostMovies(Path file) {
		return null;

	}

	public static List<String> getDirectorsOfMovie(Path file, String movie, int year, boolean sortByLastname) {
		return null;

	}

	public static List<String> getNumberOfDirectorsPerMovie(Path file, boolean sortByMovie) {
		return null;

	}

	public static List<String> getNumberOfMoviesPerYear(Path file, boolean sortByYear) {
		return null;

	}

	public static List<String> getDirectorsByNumberOfMovies(Path file, boolean sortByName) {
		return null;

	}

	public static void main(String[] args) {

		//countMovies(../Assignment1\directors.csv);
	}
}
