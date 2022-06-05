package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.portal.permits.entities.UF;

public interface UfRepository extends JpaRepository<UF, Long> {
}
