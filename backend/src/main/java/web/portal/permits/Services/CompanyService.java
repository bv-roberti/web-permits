package web.portal.permits.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.Company;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Long Id){
        Company company = companyRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return company;
    }

}
