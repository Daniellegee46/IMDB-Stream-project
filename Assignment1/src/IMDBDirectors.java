
//import java.awt.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class IMDBDirectors {

	public static long countMovies(Path file) {

		//long count = 0;
		long count = file.getNameCount();
		
		return count;
		/*Book
		 * Path path = Paths.get("."); 
		 * try { 
		 * 		Stream<Path> list = Files.list(path); 
		 * 		list.forEach(System.out::println); 
		 * } catch
		 * 		(IOException ex) { ex.printStackTrace();
		 *  }
		 *}
		 * 
		 */
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

		//countMovies("directors.csv");
	}
}
