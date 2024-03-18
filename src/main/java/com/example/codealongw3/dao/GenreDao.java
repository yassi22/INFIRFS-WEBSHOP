package com.example.codealongw3.dao;

import com.example.codealongw3.dto.GenreDTO;
import com.example.codealongw3.models.Genre;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreDao {

    private final  GenreRepository genreRepository;

    public GenreDao(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> GetAllGenre(){
        return this.genreRepository.findAll();
    }


    public void createGenre(GenreDTO genreDTO){
        Genre genre = new Genre(genreDTO.name);
        this.genreRepository.save(genre);
    }

    public void deleteGenreById(Long id) {
        this.genreRepository.deleteById(id);
    }


}
