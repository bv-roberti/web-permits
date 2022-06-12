package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.portal.permits.entities.Permit;

@Repository
public interface PermitRepository extends JpaRepository<Permit, Long> {
}
