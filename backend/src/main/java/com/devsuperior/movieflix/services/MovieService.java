package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.mapper.MovieMapper;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ObjectNotFoundException;

@Service
public class MovieService {

	private final MovieRepository movieRepository;
	private final GenreRepository genreRepository;
	private final MovieMapper mapper;
	
	public MovieService(MovieRepository movieRepository, MovieMapper mapper, GenreRepository genreRepository) {
		this.movieRepository = movieRepository;
		this.genreRepository = genreRepository;
		this.mapper = mapper;
	}


	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> optional = movieRepository.findById(id);
		Movie entity = optional.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
		return mapper.toDTO(entity);
	}


	@Transactional(readOnly = true)
	public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable) {
		Genre genre = genreId == 0 ? null : genreRepository.getReferenceById(genreId);
		Page<Movie> page = movieRepository.findByGenre(genre, pageable);
		return page.map((entity) -> mapper.toDTO(entity));
	}
}
