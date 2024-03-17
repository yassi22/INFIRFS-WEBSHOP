package com.example.codealongw3.controller;


import com.example.codealongw3.dao.LanguageDao;
import com.example.codealongw3.dto.GenreDTO;
import com.example.codealongw3.dto.LanguageDTO;
import com.example.codealongw3.models.Genre;
import com.example.codealongw3.models.Language;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/language")
public class LanguageController {

    private final LanguageDao languageDao;

    public LanguageController(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguage(){
        return ResponseEntity.ok(languageDao.GetAllLanguage());
    }

    @PreAuthorize("hasRole('ROLE_BEHEERDER') or hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<String> createLanguage(@RequestBody LanguageDTO languageDTO){
        this.languageDao.createLanguage(languageDTO);
        return ResponseEntity.ok("Created a language" + languageDTO.name);
    }


}

