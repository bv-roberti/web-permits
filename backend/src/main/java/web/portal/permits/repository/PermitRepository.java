package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.portal.permits.entities.Permit;

public interface PermitRepository extends JpaRepository<Permit, Long> {
}
