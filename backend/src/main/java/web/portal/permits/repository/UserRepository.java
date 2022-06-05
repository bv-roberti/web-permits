package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.portal.permits.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
