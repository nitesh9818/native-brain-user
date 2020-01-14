package co.tvisory.api.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.tvisory.api.user.domain.User;
import io.swagger.annotations.Api;

@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
@RepositoryRestResource(path = "user", collectionResourceRel = "user")
@Transactional
@CrossOrigin
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
