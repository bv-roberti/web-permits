package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.Company;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.CompanyRepository;
import java.util.List;

@Service
public class CompanyService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Long Id){
        Company company = companyRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return company;
    }

    public Company save(Company company){
        return companyRepository.save(company);
    }

    public Company update(Long Id, Company company){
        Company _company = companyRepository.getById(Id);

        _company.setName(company.getName());
        _company.setCnpj(company.getCnpj());
        _company.setCreatedAt(company.getCreatedAt());

        return companyRepository.save(_company);
    }

    public boolean delete(Long Id){

        try{
            companyRepository.deleteById(Id);

            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
