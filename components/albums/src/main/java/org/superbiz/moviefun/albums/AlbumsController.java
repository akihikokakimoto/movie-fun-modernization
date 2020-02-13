package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {
    private AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
    }

    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable Long id) {
        return albumsRepository.find(id);
    }

    @GetMapping
    public List<Album> getAlbumList(){
        return albumsRepository.getAlbums();
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Long id){
        Album album = new Album();
        album.setId(id);
        albumsRepository.deleteAlbum(album);
    }
}
