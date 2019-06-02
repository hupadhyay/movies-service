package in.himtech.in.movies.rating.cntrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.himtech.java.movies.models.Rating;

@RestController
@RequestMapping("/rate")
public class RatingController {

	@GetMapping("/{movieName}")
	public Rating getMoviesRating(@PathVariable("movieName") String movieName) {
		return new Rating(movieName, movieName.length());
	}
}
