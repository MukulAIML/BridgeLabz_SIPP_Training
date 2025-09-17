
import java.util.*;
import java.util.stream.Collectors;

public class Top5TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 9.0, 2022),
            new Movie("Movie C", 7.5, 2023),
            new Movie("Movie D", 9.2, 2023),
            new Movie("Movie E", 8.9, 2021),
            new Movie("Movie F", 9.1, 2023)
        );

        List<Movie> top5 = movies.stream()
            .filter(m -> m.getReleaseYear() >= 2022)
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
            .limit(5)
            .collect(Collectors.toList());

        top5.forEach(System.out::println);
    }
}

class Movie {
    private String title;
    private double rating;
    private int releaseYear;

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public double getRating() { return rating; }
    public int getReleaseYear() { return releaseYear; }
    public String toString() { return title + " (" + releaseYear + ") - Rating: " + rating; }
}
