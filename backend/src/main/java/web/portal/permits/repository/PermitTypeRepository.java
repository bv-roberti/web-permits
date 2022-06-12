package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.portal.permits.entities.PermitType;

@Repository
public interface PermitTypeRepository extends JpaRepository<PermitType, Long> {
}
