package co.tvisory.api.user.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Properties;

@Configuration
public class AdditionalConfig {

    private final EnvConfig envConfig;

    public AdditionalConfig(EnvConfig envConfig) {
        this.envConfig = envConfig;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    @Qualifier("emailSender")
    public JavaMailSender getJavaMailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(envConfig.getHost());
        mailSender.setPort(envConfig.getPort());
        mailSender.setUsername(envConfig.getUsername());
        mailSender.setPassword(envConfig.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", envConfig.getSMTP());
        props.put("mail.smtp.auth", envConfig.isMailAuth());
        props.put("mail.stmp.port", envConfig.getPort());
        props.put("mail.smtp.starttls.enable", envConfig.getStarttlsEnable());
        props.put("mail.smtp.starttls.required", envConfig.getStarttlsRequired());
        props.put("mail.debug", envConfig.isMailDebug());

        return mailSender;

    }

}
