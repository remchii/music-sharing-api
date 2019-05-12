package se.remchii.musicsharingapi.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.remchii.musicsharingapi.model.UserRegistration;
import se.remchii.musicsharingapi.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

    private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@Valid @NotNull @RequestBody UserRegistration user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {
        String response = "{\"message\":\"All user\"}";
        return ResponseEntity.ok(response);
    }

}
