package co.tvisory.api.user.repository;

import co.tvisory.api.user.domain.Security;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.Optional;

@RepositoryRestResource(path = "security", collectionResourceRel = "security")
public interface SecurityRepository extends PagingAndSortingRepository<Security, Long> {
	Optional<Security> findByEmailOrMobileNo(String email, String mobileNo);
}
