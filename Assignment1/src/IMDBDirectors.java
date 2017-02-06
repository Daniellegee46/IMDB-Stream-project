
//import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IMDBDirectors {

	public static long countMovies(Path file) {
		long count = 0;
		try {
			count = Files.lines(file, Charset.forName("ISO-8859-1")).count();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static long countDirectors(Path file) {
		BufferedReader breader = null;
		try {
			breader = Files.newBufferedReader(file, StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			System.out.println("error");
		}
		List<String> lines = breader.lines().collect(Collectors.toList());
		long directors = lines.stream()
				.map(line -> Arrays.asList(line.split("\t")))
				.map(list -> list.subList(0, 2))
				.distinct().count();
		return directors;
		// List<String> directorNames = lines.stream()
		// .map(line -> Arrays.asList(line.split("\t")))
		// .map(list -> list.subList(0, 2))
		// .map(list -> list.toString())
		// .collect(Collectors.toList());
		//
		// System.out.println(directorNames);

	}

	public static List<String> getMoviesOfDirector(Path file, String last, String first, SortBy sort) {
		BufferedReader breader = null;
		try {
			breader = Files.newBufferedReader(file, StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			System.out.println("error");
		}
		List<String> lines = breader.lines().collect(Collectors.toList());
		
		List<String> dMovies=lines.stream()
				   .map(line -> Arrays.asList(line.split("\t")))	
				   .filter(list -> {String name=list.get(0); 
			                  return name.equalsIgnoreCase(last);})
				   .map(movie -> {String movieName=movie.get(2); 
	                               return movieName;})
				   .collect(Collectors.toList());
	System.out.println(dMovies);
	return dMovies;
	
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

		// countMovies(../Assignment1\directors.csv);
	}
}

// Print Helper
//
//
// List<String> directorNames = lines.stream()
// .map(line -> Arrays.asList(line.split("\t")).get(0))
// .collect(Collectors.toList());
//
// System.out.println(directorNames);
