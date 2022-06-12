package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.portal.permits.entities.Audit;
import web.portal.permits.entities.User;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
}
