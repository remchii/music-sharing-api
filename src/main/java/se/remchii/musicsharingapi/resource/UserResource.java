package se.remchii.musicsharingapi.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.remchii.musicsharingapi.model.UserRegistration;
import se.remchii.musicsharingapi.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody UserRegistration user) {

        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {
        String response = "{\"message\":\"test message\"}";
        return ResponseEntity.ok(response);
    }


}
