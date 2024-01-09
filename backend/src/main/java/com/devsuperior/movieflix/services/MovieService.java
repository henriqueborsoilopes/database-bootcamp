package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.mapper.MovieMapper;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ObjectNotFoundException;

@Service
public class MovieService {

	private final MovieRepository movieRepository;
	private final MovieMapper mapper;
	
	public MovieService(MovieRepository movieRepository, MovieMapper mapper) {
		this.movieRepository = movieRepository;
		this.mapper = mapper;
	}

	public MovieDTO findById(Long id) {
		Optional<Movie> optional = movieRepository.findById(id);
		Movie entity = optional.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
		return mapper.toDTO(entity);
	}
}
