package com.devsuperior.movieflix.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.entities.User;

@Component
public class UserMapper {
	
	private final ModelMapper mapper;
	
	public UserMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public UserDTO toDTO(User entity) {
		return mapper.map(entity, UserDTO.class);
	}
}
