package io.javabrains.moviecatalogservice.resources;


import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		RestTemplate restTemplate = new RestTemplate();
		
		//get all rated movie IDs
		List<Rating> ratings =Arrays.asList(
				new Rating("1234",4),
				new Rating("5678", 5)
		); 
		
		return ratings.stream().map(rating -> {
		//new CatalogItem("Transforms","Test",4))
		Movie movie = restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(), Movie.class);
		new CatalogItem(movie.getName(),"Test",rating.getRating());
		})
		.collect(Collectors.toList());
		// for each movie ID, CALL MVIE INFOR SERVICE AND GET DETAILS 
		
		//Put them all together
		 /*return Collections.singletonList(
				new CatalogItem(userId,"Test",4)
		);*/
	}

}
