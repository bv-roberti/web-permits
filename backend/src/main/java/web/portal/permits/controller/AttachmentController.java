package web.portal.permits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import web.portal.permits.entities.Attachment;
import web.portal.permits.services.AttachmentService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/attachment")
public class AttachmentController {

  @Autowired private AttachmentService attachmentService;

  @GetMapping
  public ResponseEntity<List<Attachment>> findAll() {
    return ResponseEntity.ok().body(attachmentService.findAll().stream().collect(Collectors.toList()));
  }

  @GetMapping("/{Id}")
  public ResponseEntity<Attachment> findById(@PathVariable Long Id) {
    return ResponseEntity.ok().body(attachmentService.findById(Id));
  }

  @PostMapping
  public ResponseEntity<Attachment> insert(@RequestBody Attachment dto) {
    Attachment newAttachment = attachmentService.save(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newAttachment.getId()).toUri();
    return ResponseEntity.created(uri).body(newAttachment);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Attachment> update(@PathVariable Long Id, @RequestBody Attachment attachment){
    return ResponseEntity.ok(attachmentService.update(Id, attachment));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    attachmentService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
