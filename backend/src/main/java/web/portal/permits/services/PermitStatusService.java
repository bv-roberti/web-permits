package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.PermitStatus;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.PermitStatusRepository;

import java.util.List;

@Service
public class PermitStatusService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermitStatusRepository permitStatusRepository;

    public List<PermitStatus> findAll(){
        return permitStatusRepository.findAll();
    }

    public PermitStatus findById(Long Id){
        PermitStatus permitStatus = permitStatusRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return permitStatus;
    }

    public PermitStatus save(PermitStatus permitStatus){
        return permitStatusRepository.save(permitStatus);
    }

    public PermitStatus update(Long Id, PermitStatus permitStatus){
        PermitStatus _permitStatus = permitStatusRepository.getById(Id);

        _permitStatus.setName(permitStatus.getName());

        return permitStatusRepository.save(_permitStatus);
    }

    public boolean delete(Long Id){

        try{
            permitStatusRepository.deleteById(Id);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
