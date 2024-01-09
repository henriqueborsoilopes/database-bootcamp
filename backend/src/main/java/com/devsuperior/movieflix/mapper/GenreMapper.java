package com.devsuperior.movieflix.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.movieflix.dtos.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;

@Component
public class GenreMapper {
	
	private final ModelMapper mapper;
	
	public GenreMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public GenreDTO toDTO(Genre entity) {
		return mapper.map(entity, GenreDTO.class);
	}
	
	public List<GenreDTO> toListDTO(List<Genre> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
