package com.talk2amareswaran.projects.resourceserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

	@Override
	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		OAuth2Authentication auth = super.extractAuthentication(map);
		AccessTokenMapper details = new AccessTokenMapper();
		if (map.get("id") != null)
			details.setId((String) map.get("id"));
		if (map.get("first_name") != null)
			details.setFirst_name((String) map.get("first_name"));
		if (map.get("last_name") != null)
			details.setLast_name((String) map.get("last_name"));
		if (map.get("country") != null)
			details.setCountry((String) map.get("country"));
		if (map.get("mobile") != null)
			details.setMobile((String) map.get("mobile"));
		if (map.get("user_type") != null)
			details.setUser_type((String) map.get("user_type"));
		if (auth.getAuthorities() != null && !auth.getAuthorities().isEmpty()) {
			List<String> authorities = new ArrayList<>();
			for (GrantedAuthority gn : auth.getAuthorities()) {
				authorities.add(gn.getAuthority());
			}
			details.setAuthorities(authorities);
		}
		auth.setDetails(details);
		return auth;
	}
	
}