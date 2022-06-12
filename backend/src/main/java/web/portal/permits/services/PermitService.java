package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.Permit;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.PermitRepository;

import java.util.List;

@Service
public class PermitService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermitRepository permitRepository;

    public List<Permit> findAll(){
        return permitRepository.findAll();
    }

    public Permit findById(Long Id){
        Permit permit = permitRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return permit;
    }

    public Permit save(Permit permit){
        return permitRepository.save(permit);
    }

    public Permit update(Long Id, Permit permit){
        Permit _permit = permitRepository.getById(Id);

        _permit.setName(permit.getName());
        _permit.setCreatedAt(permit.getCreatedAt());

        return permitRepository.save(_permit);
    }

    public boolean delete(Long Id){

        try{
            permitRepository.deleteById(Id);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
