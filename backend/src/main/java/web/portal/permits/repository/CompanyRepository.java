package web.portal.permits.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.portal.permits.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

  Optional<Company> findByName(String Name);
  Optional<Company> findByCnpj(String Cnpj);
}
