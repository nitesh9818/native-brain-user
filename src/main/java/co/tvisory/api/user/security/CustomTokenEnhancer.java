package co.tvisory.api.user.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import co.tvisory.api.user.security.model.User;

public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Map<String, Object> additionalInfo = new HashMap<String, Object>();
		User user = (User)authentication.getPrincipal();
		
		List<String> roles = new ArrayList<String>();
		user.getAuthorities().forEach(ga -> roles.add(ga.getAuthority()));
		
		additionalInfo.put("name", user.getName());
		additionalInfo.put("email", user.getEmail());
		additionalInfo.put("id", user.getId());
		additionalInfo.put("username", user.getUsername());
		additionalInfo.put("lastLogin", user.getLastLogin());
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(additionalInfo);;
		return accessToken;
	}

}
