package web.portal.permits.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import web.portal.permits.entities.Company;
import web.portal.permits.errors.ResourceNotFoundProblem;

@SpringBootTest
@Transactional
public class CompanyServiceIT {

    @Autowired
    private CompanyService companyService;
    Long existingId = 1L;

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        Company company = new Company("Petrobras", "13.333.666/0001-01");

        company = companyService.save(company);

        Assertions.assertNotNull(company.getId());
    }

    @Test
    public void GivenFindByIdMethodWhenIdIsNullThenThrowException() {

        Assertions.assertThrows(ResourceNotFoundProblem.class, () -> companyService.findById(10000L));
    }

}
