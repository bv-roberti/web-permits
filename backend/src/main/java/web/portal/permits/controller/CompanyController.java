package web.portal.permits.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.portal.permits.Services.CompanyService;
import web.portal.permits.entities.Company;

@RestController
@RequestMapping(value = "api/companies")
public class CompanyController {

  @Autowired private CompanyService companyService;

  @GetMapping
  public ResponseEntity<List<Company>> findAll() {

    return ResponseEntity.ok().body(companyService.findAll().stream().collect(Collectors.toList()));
  }

  @GetMapping("/{Id}")
  public ResponseEntity<Company> findById(@PathVariable Long Id) {

    return ResponseEntity.ok().body(companyService.findById(Id));
  }
}
