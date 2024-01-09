package com.devsuperior.movieflix.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.dtos.ReviewDetailsDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.mapper.ReviewMapper;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	private final ReviewRepository reviewRepository;
	private final ReviewMapper mapper;
	private final AuthService authService;
	
	public ReviewService(ReviewRepository reviewRepository, ReviewMapper mapper, AuthService authService) {
		this.reviewRepository = reviewRepository;
		this.mapper = mapper;
		this.authService = authService;
	}

	@Transactional
	public ReviewDetailsDTO insert(ReviewDTO dto) {
		User user = authService.authenticated();
		Review entity = mapper.toEntity(dto);
		entity.setUser(user);
		entity = reviewRepository.save(entity);
		return mapper.toDetailsDTO(entity);
	}
}
