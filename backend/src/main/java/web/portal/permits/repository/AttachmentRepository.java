package web.portal.permits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.portal.permits.entities.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
