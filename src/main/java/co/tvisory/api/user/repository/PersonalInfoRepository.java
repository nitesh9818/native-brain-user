package co.tvisory.api.user.repository;

import co.tvisory.api.user.domain.PersonalInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;

@RepositoryRestResource(path = "personalInfo", collectionResourceRel = "personalInfo")
@Transactional
@CrossOrigin
public interface PersonalInfoRepository extends PagingAndSortingRepository<PersonalInfo, Long> {
}
