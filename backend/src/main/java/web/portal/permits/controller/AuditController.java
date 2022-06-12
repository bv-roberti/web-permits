package web.portal.permits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import web.portal.permits.entities.Audit;
import web.portal.permits.services.AuditService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/audit")
public class AuditController {

  @Autowired private AuditService auditService;

  @GetMapping
  public ResponseEntity<List<Audit>> findAll() {
    return ResponseEntity.ok().body(auditService.findAll().stream().collect(Collectors.toList()));
  }

  @GetMapping("/{Id}")
  public ResponseEntity<Audit> findById(@PathVariable Long Id) {
    return ResponseEntity.ok().body(auditService.findById(Id));
  }

  @PostMapping
  public ResponseEntity<Audit> insert(@RequestBody Audit dto) {
    Audit newAudit = auditService.save(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newAudit.getId()).toUri();
    return ResponseEntity.created(uri).body(newAudit);
  }
}
