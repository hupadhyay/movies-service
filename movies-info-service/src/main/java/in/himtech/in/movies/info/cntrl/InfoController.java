package in.himtech.in.movies.info.cntrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.himtech.java.movies.info.models.Movies;

@RestController
@RequestMapping("/info")
public class InfoController {

	@GetMapping("/{movieName}")
	public Movies getMoviesInfo(@PathVariable("movieName") String movieName) {
		return new Movies(movieName, movieName + " is a good movies");
		
	}
}
