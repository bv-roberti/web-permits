package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.PermitType;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.PermitTypeRepository;

import java.util.List;

@Service
public class PermitTypeService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermitTypeRepository permitTypeRepository;

    public List<PermitType> findAll(){
        return permitTypeRepository.findAll();
    }

    public PermitType findById(Long Id){
        PermitType permitType = permitTypeRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return permitType;
    }

    public PermitType save(PermitType permitType){
        return permitTypeRepository.save(permitType);
    }

    public PermitType update(Long Id, PermitType permitType){
        PermitType _permitType = permitTypeRepository.getById(Id);

        _permitType.setName(permitType.getName());

        return permitTypeRepository.save(_permitType);
    }

    public boolean delete(Long Id){

        try{
            permitTypeRepository.deleteById(Id);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
