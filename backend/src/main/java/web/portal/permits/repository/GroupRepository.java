package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.portal.permits.entities.Group;
import web.portal.permits.entities.User;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
