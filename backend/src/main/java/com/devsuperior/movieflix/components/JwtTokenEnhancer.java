package com.devsuperior.movieflix.components;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {
	
	private final UserRepository userRepository;
	
	public JwtTokenEnhancer(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Optional<User> optional = userRepository.findByEmail(authentication.getName());
		User user = optional.get();
		
		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", user.getEmail());
		map.put("userId", user.getId());
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
}
