package co.tvisory.api.user.repository;

import co.tvisory.api.user.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;

@RepositoryRestResource(path = "user", collectionResourceRel = "user")
@Transactional
@CrossOrigin
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
