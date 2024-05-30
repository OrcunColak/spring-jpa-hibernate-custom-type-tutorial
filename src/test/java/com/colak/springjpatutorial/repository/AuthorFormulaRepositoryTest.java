package com.colak.springjpatutorial.repository;


import com.colak.springjpatutorial.customtype.AuthorFormula;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuthorFormulaRepositoryTest {

    @Autowired
    private AuthorFormulaRepository authorFormulaRepository;

    @Test
    void testFormula() {
        AuthorFormula authorFormula = new AuthorFormula();
        authorFormula.setAge(40);
        AuthorFormula savedAuthorFormula = authorFormulaRepository.saveAndFlush(authorFormula);

        Optional<AuthorFormula> optionalAuthorFormula = authorFormulaRepository.findById(savedAuthorFormula.getId());
        assertThat(optionalAuthorFormula).isPresent();

        AuthorFormula byId = optionalAuthorFormula.get();
        assertThat(byId.getTenAge()).isEqualTo(400);
    }
}

