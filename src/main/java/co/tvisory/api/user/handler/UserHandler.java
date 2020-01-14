package co.tvisory.api.user.handler;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.tvisory.api.user.domain.Role;
import co.tvisory.api.user.domain.Security;
import co.tvisory.api.user.domain.User;
import co.tvisory.api.user.repository.RoleRepository;
import co.tvisory.api.user.repository.SecurityRepository;

@Component
@RepositoryEventHandler(User.class)
public class UserHandler {
	
	@Autowired
	private SecurityRepository securityRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@HandleBeforeCreate
	public void onCreateRole(User user) {
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findById(1L).get());
		user.setRoles(roles);
	}
	
	@HandleAfterCreate
	public void onCreate(User user) {
		Security security = new Security();
		security.setUser(user);
		security.setUsername(user.getUsername());
		security.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setSecurity(security);
		securityRepository.save(security);
	}

}
