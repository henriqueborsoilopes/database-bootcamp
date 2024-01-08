package com.devsuperior.movieflix.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PreAuthorize("hasAnyRole('VISITOR_OR_MEMBER')")
	@GetMapping("/profile")
	public ResponseEntity<UserDTO> getProfile() {
		UserDTO dto = userService.getProfile();
		return ResponseEntity.ok().body(dto);
	}
}
