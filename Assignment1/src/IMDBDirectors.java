
//import java.awt.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		List<String> lines;
		try {
			lines = Files.lines(file, Charset.forName("ISO-8859-1")).collect(Collectors.toList());
			long directors = lines.stream()
					.map(line -> Arrays.asList(line.split("\t")))
					.map(list -> list.subList(0, 2))
					.distinct().count();
			return directors;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static List<String> getMoviesOfDirector(Path file, String last, String first, SortBy sort) {
		List<String> lines;

		try {
			lines = Files.lines(file, Charset.forName("ISO-8859-1")).collect(Collectors.toList());
			if(sort == SortBy.FIRSTNAME){
				List<String> dMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(0); 
					                  return name.equalsIgnoreCase(last);})
						   .filter(list -> {String fname = list.get(1);
						   return fname.equalsIgnoreCase(first);})
						   .sorted((n1, n2) -> n1.get(1).compareToIgnoreCase(n2.get(1)))	
						   .distinct()
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
							return yearMovies;})
							.collect(Collectors.toList());
				//System.out.println(dMovies);

				return dMovies;
			}
			if(sort == SortBy.LASTNAME){
				List<String> dMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(0); 
					                  return name.equalsIgnoreCase(last);})
						   .filter(list -> {String fname = list.get(1);
						   return fname.equalsIgnoreCase(first);})
						   .sorted((n1, n2) -> n1.get(0).compareToIgnoreCase(n2.get(0)))	
						   .distinct()
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
							return yearMovies;})
							.collect(Collectors.toList());
				//System.out.println(dMovies);

				return dMovies;
			}
			if(sort == SortBy.MOVIE){
				List<String> dMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(0); 
					                  return name.equalsIgnoreCase(last);})
						   .filter(list -> {String fname = list.get(1);
						   return fname.equalsIgnoreCase(first);})
						   .sorted((n1, n2) -> n1.get(2).compareToIgnoreCase(n2.get(2)))
						   .distinct()
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
							return yearMovies;})
							.collect(Collectors.toList());
					
				//System.out.println(dMovies);

				return dMovies;
			}
			if(sort == SortBy.YEAR){
				List<String> dMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(0); 
					                  return name.equalsIgnoreCase(last);})
						   .filter(list -> {String fname = list.get(1);
						   return fname.equalsIgnoreCase(first);})
						   .sorted((n1, n2) -> n1.get(3).compareToIgnoreCase(n2.get(3)))
						   .distinct()
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
							return yearMovies;})
							.collect(Collectors.toList());
				//System.out.println(dMovies);

				return dMovies;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	return null;
	}

	public static List<String> getMoviesInYear(Path file, int year, SortBy sort) {
		List<String> lines;
		try {
			lines = Files.lines(file, Charset.forName("ISO-8859-1")).collect(Collectors.toList());
			if(sort == SortBy.YEAR){
				List<String> yMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(3); 
					        return name.equalsIgnoreCase(Integer.toString(year));})
						   .sorted((n1, n2) -> n1.get(3).compareToIgnoreCase(n2.get(3)))					  
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
							return yearMovies;})
							.collect(Collectors.toList());
				//System.out.println(yMovies);

				return yMovies;
			}
			if(sort == SortBy.FIRSTNAME){
				List<String> yMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(3); 
					                  return name.equalsIgnoreCase(Integer.toString(year));})
						   .sorted((n1, n2) -> n1.get(1).compareToIgnoreCase(n2.get(1)))					  
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
							return yearMovies;})
							.collect(Collectors.toList());
				//System.out.println(yMovies);

				return yMovies;
			}
			if(sort == SortBy.LASTNAME){
				List<String> yMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(3); 
					        return name.equalsIgnoreCase(Integer.toString(year));})
						   .sorted((n1, n2) -> n1.get(0).compareToIgnoreCase(n2.get(0)))					  
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
							return yearMovies;})
							.collect(Collectors.toList());
				//System.out.println(yMovies);

				return yMovies;
			}
			if(sort == SortBy.MOVIE){
				List<String> yMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))	
						   .filter(list -> {String name=list.get(3); 
					        return name.equalsIgnoreCase(Integer.toString(year));})
						   .sorted((n1, n2) -> n1.get(2).compareToIgnoreCase(n2.get(2)))					  
						   .map(list -> {list.toString();
								String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), list.get(2), list.get(3));
								return yearMovies;})
								.collect(Collectors.toList());

				//System.out.println(yMovies);
				return yMovies;
						  
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;

	}

	public static List<String> getDirectorWithMostMovies(Path file) {
		List<String> lines;
		try {
			lines = Files.lines(file, Charset.forName("ISO-8859-1")).collect(Collectors.toList());
			
			Map<String, Long> mdCount = lines.stream().map(line -> Arrays.asList(line.split("\t")))
					.collect(Collectors.groupingBy(n -> n.get(0), Collectors.counting()));
			
					
			//get just first names and last names key set
			
			//use these as keys 
			//get key with highest values 
						    List<String> result = mdCount.entrySet().stream()
						            .sorted(Comparator.comparing(Map.Entry::getValue))
						            .map(Map.Entry::getKey)
						            .filter(list -> mdCount.keySet(list))
						            .map(list -> {list.toString();
//						            .map(list -> {list.toString();
								String yearMovies = String.format("%s\t%s\t%s\t%s", list.get(0), list.get(1), mdCount.values());
									return yearMovies;})
						            .collect(Collectors.toList());
						    
				//System.out.println(mdCount);
				return result;
		}
			catch (IOException e) {
				e.printStackTrace();		
				}
		return null;

	}

	public static List<String> getDirectorsOfMovie(Path file, String movie, int year, boolean sortByLastname) {
		List<String> lines;

		try {
			lines = Files.lines(file, Charset.forName("ISO-8859-1")).collect(Collectors.toList());
			
			if(sortByLastname){
//				List<String> dMovies = lines.stream()
//						.map(line -> Arrays.asList(line.split("\t")))	
//				  .filter(amovie -> {String movieName=amovie.get(2); 
//				                    return movieName.equalsIgnoreCase(movie);})
//				  .forEach(list -> {String director=list.get(0);
//				  director.});
				
				List<String> dMovies = lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))
						   .distinct()
						   
						   .filter(list -> {String name=list.get(2); 
					                  return name.equalsIgnoreCase(movie);})
						   .distinct()
						   .filter(list -> {String fname = list.get(1);
						   return fname.equalsIgnoreCase(list.get(1));})
						   .sorted((n1, n2) -> n1.get(0).compareToIgnoreCase(n2.get(0)))	
						   .distinct()
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s", list.get(0), list.get(1));
							return yearMovies;})
							.collect(Collectors.toList());
						
				
				System.out.println(dMovies);

				return dMovies;
			}
			if(!sortByLastname){
				List<String> dMovies=lines.stream()
						   .map(line -> Arrays.asList(line.split("\t")))
						   .distinct()
						   .filter(list -> {String name=list.get(2); 
					                  return name.equalsIgnoreCase(movie);})
						   
						   .filter(list -> {String fname = list.get(1);
						   return fname.equalsIgnoreCase(list.get(1));})
						   .sorted((n1, n2) -> n1.get(1).compareToIgnoreCase(n2.get(1)))	
						   .distinct()
						   .map(list -> {list.toString();
							String yearMovies = String.format("%s\t%s", list.get(0), list.get(1));
							return yearMovies;})
							.collect(Collectors.toList());
				System.out.println(dMovies);

				return dMovies;
			}

			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return null;

	}

	public static List<String> getNumberOfDirectorsPerMovie(Path file, boolean sortByMovie) {
		List<String> lines;

		try {
			lines = Files.lines(file, Charset.forName("ISO-8859-1")).collect(Collectors.toList());
			if(sortByMovie){
				lines.stream()
			     .skip(1)
			     .map(line -> Arrays.asList(line.split("/t")))	
			     .filter(movie -> {String nmovie=movie.get(1); 
		                             return (!nmovie.equals("")&& 
                                 nmovie.equalsIgnoreCase("documentary"));})
			     .filter(list -> {String tmovie=list.get(2);
		                            return (!tmovie.equals("")&& 
                                                 tmovie.equals(list.get(2)));})
			     .map(list -> {String name=list.get(0); return name;})
			     .collect(Collectors.toList());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;

	}

	public static List<String> getNumberOfMoviesPerYear(Path file, boolean sortByYear) {
		return null;

	}

	public static List<String> getDirectorsByNumberOfMovies(Path file, boolean sortByName) {
		return null;

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
