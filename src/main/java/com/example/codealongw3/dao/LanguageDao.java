package com.example.codealongw3.dao;

import com.example.codealongw3.dto.GenreDTO;
import com.example.codealongw3.dto.LanguageDTO;
import com.example.codealongw3.models.Genre;
import com.example.codealongw3.models.Language;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LanguageDao {

    private final  LanguageRepository languageRepository;

    public LanguageDao(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    public List<Language> GetAllLanguage(){
        return this.languageRepository.findAll();
    }


    public void createLanguage(LanguageDTO languageDTO){
        Language language = new Language(languageDTO.name);
        this.languageRepository.save(language);
    }

    public void createLanguage(Language language){

        this.languageRepository.save(language);
    }


}
