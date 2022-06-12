package web.portal.permits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import web.portal.permits.entities.User;
import web.portal.permits.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok().body(userService.findAll().stream().collect(Collectors.toList()));
  }

  @GetMapping("/{Id}")
  public ResponseEntity<User> findById(@PathVariable Long Id) {
    return ResponseEntity.ok().body(userService.findById(Id));
  }

  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User dto) {
    User newUser = userService.save(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newUser.getId()).toUri();
    return ResponseEntity.created(uri).body(newUser);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<User> update(@PathVariable Long Id, @RequestBody User user){
    return ResponseEntity.ok(userService.update(Id, user));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
