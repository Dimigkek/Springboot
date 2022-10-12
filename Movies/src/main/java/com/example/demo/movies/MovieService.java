package com.example.demo.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository
                .findMovieByName(movie.getName());
        if(movieOptional.isPresent()){
            throw new IllegalStateException("Movie Already added.");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if(!exists){
            throw new IllegalStateException(
                    "Movie does not exist" + movieId
            );
        }
        movieRepository.deleteById(movieId);
    }

}