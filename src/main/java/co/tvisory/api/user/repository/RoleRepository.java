package co.tvisory.api.user.repository;

import co.tvisory.api.user.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;

@RepositoryRestResource(path = "role", collectionResourceRel = "role")
@Transactional
@CrossOrigin
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
