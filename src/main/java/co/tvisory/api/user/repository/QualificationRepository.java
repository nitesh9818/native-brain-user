package co.tvisory.api.user.repository;

import co.tvisory.api.user.domain.Qualification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;

@RepositoryRestResource(path = "qualification", collectionResourceRel = "qualification")
@Transactional
@CrossOrigin
public interface QualificationRepository extends PagingAndSortingRepository<Qualification, Long> {
}
