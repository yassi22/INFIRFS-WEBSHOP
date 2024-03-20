package com.example.codealongw3.controller;


import com.example.codealongw3.dao.GenreDao;
import com.example.codealongw3.dto.GenreDTO;
import com.example.codealongw3.models.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/genre")
public class GenreController {

    private final GenreDao genreDao;

    public GenreController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenre(){
        return ResponseEntity.ok(genreDao.GetAllGenre());
    }

    @PreAuthorize("hasRole('ROLE_BEHEERDER') or hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<String> createGenre(@RequestBody GenreDTO genreDTO){
        this.genreDao.createGenre(genreDTO);
        return ResponseEntity.ok("Created a genre" + genreDTO.name);
    }

    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        this.genreDao.deleteGenreById(id);
        return ResponseEntity.ok("Genre is deleted");
    }


}
