package in.himtech.in.movies.catalog.cntrl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.himtech.java.movies.catalog.models.Catalog;
import in.himtech.java.movies.info.models.Movies;
import in.himtech.java.movies.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping
	public List<Catalog> getAllMoviesCatalog(){
		List<String> listMovies = Arrays.asList("Deshbhakt", "Dosti", "Modi-Modi");
		
		return listMovies.stream().map(m -> {
			Rating rating = restTemplate.getForObject("http://RATING-SERVICE/rate/"+ m, Rating.class);
			Movies movie = restTemplate.getForObject("http://INFO-SERVICE/info/" + m, Movies.class);
			return new Catalog(m, movie.getDesc(), rating.getRate());
		}).collect(Collectors.toList());
			
	}
	
	/**
	 * To use this method commet out @LoadBalanced from the RestTemplate.
	 * @return
	 */
	@GetMapping("/client")
	public List<Catalog> getAllMoviesCatalogDirectoryClient(){
		List<String> listMovies = Arrays.asList("Deshbhakt", "Dosti", "Modi-Modi");
		
		return listMovies.stream().map(m -> {
			List<ServiceInstance> listInstanceInfo = discoveryClient.getInstances("RATING-SERVICE");
			ServiceInstance instance = listInstanceInfo.get(0);
			
			Rating rating = restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/rate/"+ m, Rating.class);
			
			List<ServiceInstance> listInstanceInfo1 = discoveryClient.getInstances ("INFO-SERVICE");
			instance = listInstanceInfo1.get(0);
			
			Movies movie = restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/info/" + m, Movies.class);
			return new Catalog(m, movie.getDesc(), rating.getRate());
		}).collect(Collectors.toList());
			
	}
}
