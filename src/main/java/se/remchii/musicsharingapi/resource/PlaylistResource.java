package se.remchii.musicsharingapi.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.remchii.musicsharingapi.service.PlaylistService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/playlists")
public class PlaylistResource {

    private PlaylistService playlistService;

    public PlaylistResource(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity addPlaylist() {

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getPlaylist() {

        return ResponseEntity.ok().build();
    }
}
