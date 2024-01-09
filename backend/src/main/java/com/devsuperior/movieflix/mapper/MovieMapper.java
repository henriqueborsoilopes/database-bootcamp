package com.devsuperior.movieflix.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.movieflix.dtos.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;

@Component
public class MovieMapper {
	
	private final ModelMapper mapper;
	
	public MovieMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public MovieDTO toDTO(Movie entity) {
		return mapper.map(entity, MovieDTO.class);
	}
}
