package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.Audit;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.AuditRepository;

import java.util.List;

@Service
public class AuditService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuditRepository auditRepository;

    public List<Audit> findAll(){
        return auditRepository.findAll();
    }

    public Audit findById(Long Id){
        Audit audit = auditRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return audit;
    }

    public Audit save(Audit audit){
        return auditRepository.save(audit);
    }

}
