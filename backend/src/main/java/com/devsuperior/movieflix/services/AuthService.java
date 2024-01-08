package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional(readOnly = true)
	public User authenticated() {
		String useremail = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> optional = userRepository.findByEmail(useremail);
		return optional.orElseThrow(() -> new UnauthorizedException("User not found!"));
	}
}
