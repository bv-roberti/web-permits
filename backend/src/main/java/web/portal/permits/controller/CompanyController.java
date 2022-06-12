package web.portal.permits.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import web.portal.permits.services.CompanyService;
import web.portal.permits.entities.Company;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/company")
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

  @PostMapping
  public ResponseEntity<Company> insert(@RequestBody Company dto) {
    Company newCompany = companyService.save(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newCompany.getId()).toUri();
    return ResponseEntity.created(uri).body(newCompany);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Company> update(@PathVariable Long Id, @RequestBody Company company){
    return ResponseEntity.ok(companyService.update(Id, company));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    companyService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
