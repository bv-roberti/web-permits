package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.portal.permits.entities.Group;
import web.portal.permits.entities.User;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
