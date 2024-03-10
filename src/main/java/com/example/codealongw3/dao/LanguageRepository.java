package com.example.codealongw3.dao;

import com.example.codealongw3.dto.LanguageDTO;
import com.example.codealongw3.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
