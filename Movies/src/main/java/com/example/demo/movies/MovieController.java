package com.example.demo.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/movies")
public class MovieController {
    private  final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovie();
    }

    @PostMapping
    public void registerNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }

    @DeleteMapping(path="{movieID}")
    public void deleteMovie(@PathVariable("movieID")Long movieId){
        movieService.deleteMovie(movieId);
    }

    
}
