package web.portal.permits.repository;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import web.portal.permits.entities.Company;

@DataJpaTest
public class CompanyRepositoryIT {

  @Autowired
  CompanyRepository repository;
  Long existingId = 1L;

  @BeforeAll
  public static void setup() {}

  @Test
  public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
    Company company = new Company("Petrobras", "13.333.666/0001-01");

    company = repository.save(company);
    Optional<Company> result = repository.findById(company.getId());

    Assertions.assertNotNull(company.getId());
    Assertions.assertTrue(result.isPresent());
    Assertions.assertSame(result.get(), company);
  }

  @Test
  public void deleteShouldDeleteObjectWhenIdExists() {
    Company company = new Company("DeletedPetrobras", "13.333.666/0001-01");

    repository.save(company);
    Optional<Company> result = repository.findByName("DeletedPetrobras");
    repository.deleteById(result.get().getId());
    result = repository.findByName("DeletedPetrobras");

    Assertions.assertFalse(result.isPresent());
  }

  @Test
  public void GivenCompanyObject_WhenIdExistis_ThenUpdateRecord() {
    Company company = new Company("UpdatedPetrobras", "13.333.666/0001-01");

    repository.save(company);
    Optional<Company> result = repository.findByName("UpdatedPetrobras");
    company = result.get();
    repository.save(company);
    result = repository.findByName("UpdatedPetrobras");

    Assertions.assertNotNull(result.get().getId());
    Assertions.assertEquals(result.get().getName(), "UpdatedPetrobras");
  }
}
