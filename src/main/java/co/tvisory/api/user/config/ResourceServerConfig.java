package co.tvisory.api.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	private EnvConfig envConfig;
	
	private ResourceServerTokenServices tokenServices;
	
	@Autowired
	public ResourceServerConfig(ResourceServerTokenServices tokenServices, EnvConfig envConfig) {
		this.tokenServices = tokenServices;
		this.envConfig = envConfig;
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(envConfig.getResourceIds()).tokenServices(tokenServices);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors()
			.and()
			.authorizeRequests()
			.antMatchers(envConfig.getBaseUrl() + "/**")
			.fullyAuthenticated();
	}
	
}
