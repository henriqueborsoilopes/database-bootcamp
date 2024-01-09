package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.mapper.UserMapper;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;
	private final UserMapper mapper;
	private final AuthService authService;
	
	public UserService(UserRepository userRepository, UserMapper mapper, AuthService authService) {
		this.userRepository = userRepository;
		this.mapper = mapper;
		this.authService = authService;
	}
	
	public UserDTO getProfile() {
		User entity = authService.authenticated();
		return mapper.toDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByEmail(username);
		User entity = optional.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
		return entity;
	}
}
