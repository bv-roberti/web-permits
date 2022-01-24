package web.portal.permits.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.portal.permits.entities.Company;
import web.portal.permits.repository.CompanyRepository;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

  @Autowired private CompanyRepository companyRepo;

  @GetMapping
  public ResponseEntity<List<Company>> findAll() {

    return ResponseEntity.ok().body(companyRepo.findAll().stream().collect(Collectors.toList()));
  }
}
