package com.devsuperior.movieflix.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.dtos.ReviewDetailsDTO;
import com.devsuperior.movieflix.entities.Review;

@Component
public class ReviewMapper {
	
	private final ModelMapper mapper;
	
	public ReviewMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public Review toEntity(ReviewDTO dto) {
		return mapper.map(dto, Review.class);
	}
	
	public ReviewDetailsDTO toDetailsDTO(Review entity) {
		return mapper.map(entity, ReviewDetailsDTO.class);
	}
}
