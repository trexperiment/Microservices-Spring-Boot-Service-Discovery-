package io.javabrains.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping("/movie")
public class MovieResource{

	
	@Value("$(api.key)")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		String moviedbUrl = "https://api.themoviedb.org/3/movie/"+ movieId + "?api_key=" + apiKey;
		System.out.println(moviedbUrl);
		MovieSummary movieSummary = restTemplate.getForObject(
				moviedbUrl,
				MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(),movieSummary.getOverview());
		
	}
	
}
