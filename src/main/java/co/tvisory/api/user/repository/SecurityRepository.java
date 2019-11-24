package co.tvisory.api.user.repository;

import co.tvisory.api.user.domain.Security;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends PagingAndSortingRepository<Security, Long> {
}
