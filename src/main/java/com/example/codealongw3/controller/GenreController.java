package com.example.codealongw3.controller;


import com.example.codealongw3.dao.GenreDao;
import com.example.codealongw3.dto.CategoryDTO;
import com.example.codealongw3.dto.GameDTO;
import com.example.codealongw3.dto.GenreDTO;
import com.example.codealongw3.models.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PostMapping
    public ResponseEntity<String> createGenre(@RequestBody GenreDTO genreDTO){
        this.genreDao.createGenre(genreDTO);
        return ResponseEntity.ok("Created a genre" + genreDTO.name);
    }


}
