package co.tvisory.api.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
//@PropertySource({"classpath:/infra/${spring.active.replica}/${spring.profiles.active}.properties"})
public class EnvConfig {

    @Value("${spring.data.rest.base-path}")
    private String baseUrl;

    //-------------------------------------------------------------------

    @Value("${security.jwt.client-id}")
    private String clientId;

    @Value("${security.jwt.client-secret}")
    private String clientSecret;

    @Value("${security.jwt.grant-type}")
    private String grantType;

    @Value("${security.jwt.scope-read}")
    private String scopeRead = "read";

    @Value("${security.jwt.scope-write}")
    private String scopeWrite = "write";

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Value("${security.signing-key}")
    private String signingKey;

    @Value("${security.encoding-strength}")
    private Integer encodingStrength;

    @Value("${security.security-realm}")
    private String securityRealm;
//    //-----------------------------------------------------------------------------
//
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.properties.mail.transport.protocol}")
    private String SMTP;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private boolean mailAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String starttlsEnable;

    @Value("${spring.mail.properties.mail.starttls.required}")
    private String starttlsRequired;

    @Value("${spring.mail.properties.mail.transport.debug}")
    private boolean mailDebug;

    @Value("${spring.mail.from.email}")
    private String mailFrom;

    @Value("${spring.mail.from.subject}")
    private String subject;


}
