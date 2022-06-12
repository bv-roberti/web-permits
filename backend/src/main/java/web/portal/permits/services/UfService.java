package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.UF;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.UfRepository;

import java.util.List;

@Service
public class UfService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UfRepository ufRepository;

    public List<UF> findAll(){
        return ufRepository.findAll();
    }

    public UF findById(Long Id){
        UF uf = ufRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return uf;
    }

}
