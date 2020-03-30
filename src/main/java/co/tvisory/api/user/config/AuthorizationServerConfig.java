package co.tvisory.api.user.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import co.tvisory.api.user.security.CustomTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	private EnvConfig envConfig;
	
	private TokenStore tokenStore;
	
	private JwtAccessTokenConverter accessTokenConverter;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	private AuthenticationManager authenticationManager;
	
	public AuthorizationServerConfig(JwtAccessTokenConverter accessTokenConverter, TokenStore tokenStore,
									 BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
									 EnvConfig envConfig) {
		this.accessTokenConverter = accessTokenConverter;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.tokenStore = tokenStore;
		this.envConfig = envConfig;
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients
			.inMemory()
			.withClient(envConfig.getClientId())
			.secret(passwordEncoder.encode(envConfig.getClientSecret()))
			.authorizedGrantTypes(envConfig.getGrantType())
			.scopes("read", "write")
			.resourceIds(envConfig.getResourceIds())
			.accessTokenValiditySeconds(3600);
		
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter));
		endpoints
			.tokenStore(tokenStore)
			.accessTokenConverter(accessTokenConverter)
			.tokenEnhancer(enhancerChain)
			.authenticationManager(authenticationManager);
			
	}
	
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}

}
