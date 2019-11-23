package co.tvisory.api.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource({"classpath:/infra/${spring.active.replica}/${spring.profiles.active}.properties"})
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
    private String scopeRead;

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

    //-----------------------------------------------------
    @Value("${amazonProperties.endpointUrl}")
    private String s3EndPointUrl;

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    @Value("${amazonProperties.accessKey}")
    private String accessKey;

    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    //----------------------------------------------------------------------

    @Value("${registration.email.uri}")
    private String mailVerifyURI;

    @Value("${max.login.attempt}")
    private Integer maxLoginAttempt;

    @Value("${forget.password.request.uri}")
    private String resetPasswordURI;

    @Value("${forget.password.reset.key}")
    private String validFor;

    @Value("${user.notActive.status.msg}")
    private String userActiveState;

    @Value("${user.account.status.msg}")
    private String userAccountState;

    @Value("${otp.expire.time}")
    private Integer otpExpireIn;

    //-----------------------------------------------------------------------------

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

    @Value("${privacy.pageUrl}")
    private String privacyPageUrl;

    @Value("${terms.conditionUrl}")
    private String termsConditionUrl;

    @Value("${template.email.title.text}")
    private String titleText;

    //------------------------------------------------------------------------------
    @Value("${kyc.document.file.size}")
    private Long docMaxSize;

}
