package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.portal.permits.entities.UF;

@Repository
public interface UfRepository extends JpaRepository<UF, Long> {
}
