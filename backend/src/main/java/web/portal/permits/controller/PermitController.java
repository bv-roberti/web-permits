package web.portal.permits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import web.portal.permits.entities.Permit;
import web.portal.permits.services.PermitService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/permit")
public class PermitController {

  @Autowired private PermitService permitService;

  @GetMapping
  public ResponseEntity<List<Permit>> findAll() {
    return ResponseEntity.ok().body(permitService.findAll().stream().collect(Collectors.toList()));
  }

  @GetMapping("/{Id}")
  public ResponseEntity<Permit> findById(@PathVariable Long Id) {
    return ResponseEntity.ok().body(permitService.findById(Id));
  }

  @PostMapping
  public ResponseEntity<Permit> insert(@RequestBody Permit dto) {
    Permit newPermit = permitService.save(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newPermit.getId()).toUri();
    return ResponseEntity.created(uri).body(newPermit);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Permit> update(@PathVariable Long Id, @RequestBody Permit permit){
    return ResponseEntity.ok(permitService.update(Id, permit));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    permitService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
