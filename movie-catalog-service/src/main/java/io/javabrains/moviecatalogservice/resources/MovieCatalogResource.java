package io.javabrains.moviecatalogservice.resources;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogueItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/{userId}")
	public List<CatalogueItem> getCatalog(@PathVariable("userId")String userId){
		//Movie movie = restTemplate.getForObject("localhost:8081/movies/foo", Movie.class);		
		//get all rated movie ids
//		List<Rating> ratings=Arrays.asList(
//				new Rating("1234", 4),
//				new Rating("5678", 3)
//				);		
		UserRating ratings = restTemplate.getForObject("http://ratings-catalog-service/ratingsdata/users/" + userId, UserRating.class);
				

		return (ratings.getUserRating().stream().map(rating -> {
//			Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getName())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();			
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getName(), Movie.class);
			return new CatalogueItem(rating.getRatings(), movie.getMovieName(), "Descriptions");			
		}
		).collect(Collectors.toList()));
		
//		return Collections.singletonList(
//				new CatalogueItem(4, "Transformers", "Test"));
	}
}
