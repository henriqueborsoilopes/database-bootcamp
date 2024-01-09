package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.mapper.GenreMapper;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {
	
	private final GenreRepository genreRepository;
	private final GenreMapper mapper;
	
	public GenreService(GenreRepository genreRepository, GenreMapper mapper) {
		this.genreRepository = genreRepository;
		this.mapper = mapper;
	}
	
	@Transactional(readOnly = true)
	public List<GenreDTO> findAll() {
		List<Genre> entities = genreRepository.findAll();
		return mapper.toListDTO(entities);
	}
}
