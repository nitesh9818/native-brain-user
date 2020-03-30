package co.tvisory.api.user.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.tvisory.api.user.domain.Security;

@Component
@RepositoryEventHandler(Security.class)
public class SecurityHandler {

	private BCryptPasswordEncoder passwordEncoder;

	public SecurityHandler(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@HandleBeforeCreate
	public void onCreateRole(Security security) {
		security.setPassword(passwordEncoder.encode(security.getPassword()));
	}

}
