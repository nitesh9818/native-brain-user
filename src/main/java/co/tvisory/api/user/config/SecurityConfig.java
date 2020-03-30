package co.tvisory.api.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import co.tvisory.api.user.security.AppUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private EnvConfig envConfig;
    
    private AppUserDetailService userDetailService;

    public SecurityConfig(AppUserDetailService userDetailService, EnvConfig envConfig) {
        this.userDetailService = userDetailService;
        this.envConfig = envConfig;
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
    	return super.authenticationManager();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth
    		.userDetailsService(userDetailService)
    		.passwordEncoder(passwordEncoder());
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/actuator/**");
        web.ignoring().antMatchers(HttpMethod.POST,"/api/v1/security");
        web.ignoring().antMatchers(HttpMethod.OPTIONS);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.cors()
        	.and()
        	.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .httpBasic()
            .realmName(envConfig.getSecurityRealm())
            .and()
            .csrf()
            .disable();
    }
    
    @Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(envConfig.getSigningKey());
		return converter;
	}
    
    @Bean
    public JwtTokenStore tokenStore() {
    	return new JwtTokenStore(accessTokenConverter());
    }
    
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
    	DefaultTokenServices tokenServices = new DefaultTokenServices();
    	tokenServices.setTokenStore(tokenStore());
    	tokenServices.setSupportRefreshToken(true);
    	return tokenServices;
    }
}
