package co.tvisory.api.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    private final EnvConfig envConfig;

    private final TokenStore tokenStore;

    private final ResourceServerTokenServices tokenServices;

    public ResourceServerConfig(EnvConfig envConfig, TokenStore tokenStore, ResourceServerTokenServices tokenServices) {
        this.envConfig = envConfig;
        this.tokenStore = tokenStore;
        this.tokenServices = tokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId(envConfig.getResourceIds())
                .tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("**"+envConfig.getBaseUrl()+"/" ).fullyAuthenticated();
    }
}
