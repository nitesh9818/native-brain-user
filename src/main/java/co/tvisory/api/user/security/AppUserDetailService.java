package co.tvisory.api.user.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.tvisory.api.user.domain.Security;
import co.tvisory.api.user.repository.SecurityRepository;
import co.tvisory.api.user.security.model.User;

@Service
public class AppUserDetailService implements UserDetailsService {
	
	private SecurityRepository securityRepository;

	public AppUserDetailService(SecurityRepository securityRepository) {
		this.securityRepository = securityRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Security> security = securityRepository.findByUsername(username);
		if (!security.isPresent()) {
			throw new UsernameNotFoundException("user not found.");
		}
		
		co.tvisory.api.user.domain.User user = security.get().getUser();
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole())));
		
		User userDetails = new User(security.get().getUsername(), security.get().getPassword(), grantedAuthorities);
		userDetails.setId(user.getId());
		userDetails.setName(user.getFirstName()+" "+user.getLastName());
		userDetails.setEmail(user.getEmail());
		userDetails.setLastLogin(security.get().getLastLogin());
		return userDetails;
	}

}
