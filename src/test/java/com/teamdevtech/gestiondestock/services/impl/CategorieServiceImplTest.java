package com.teamdevtech.gestiondestock.services.impl;

import com.teamdevtech.gestiondestock.dto.CategorieDto;
import com.teamdevtech.gestiondestock.exception.EntityNotFoundException;
import com.teamdevtech.gestiondestock.exception.ErrorCodes;
import com.teamdevtech.gestiondestock.exception.InvalidEntityException;
import com.teamdevtech.gestiondestock.services.CategorieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieServiceImplTest {

    @Autowired
    private CategorieService service;

    @Test
    public void shouldSaveCategoryWithSuccess(){
        CategorieDto expectedCategory = CategorieDto.builder()
                .code("Cat Test")
                .designation("Designation test")
                .idEntreprise(1)
                .build();

        CategorieDto saveCategory = service.save(expectedCategory);

        assertNotNull(saveCategory);
        assertNotNull(saveCategory.getId());
        assertEquals(expectedCategory.getCode(), saveCategory.getCode());
        assertEquals(expectedCategory.getDesignation(), saveCategory.getDesignation());
        assertEquals(expectedCategory.getIdEntreprise(), saveCategory.getIdEntreprise());
    }

    @Test
    public void shouldUpdateCategoryWithSuccess(){
        CategorieDto expectedCategory = CategorieDto.builder()
                .code("Cat Test")
                .designation("Designation test")
                .idEntreprise(1)
                .build();

        CategorieDto saveCategory = service.save(expectedCategory);

        CategorieDto categorieToUpdate = saveCategory;
        categorieToUpdate.setCode("Cat update");

        saveCategory = service.save(categorieToUpdate);

        assertNotNull(categorieToUpdate);
        assertNotNull(categorieToUpdate.getId());
        assertEquals(categorieToUpdate.getCode(), saveCategory.getCode());
        assertEquals(categorieToUpdate.getDesignation(), saveCategory.getDesignation());
        assertEquals(categorieToUpdate.getIdEntreprise(), saveCategory.getIdEntreprise());
    }

    @Test
    public void shouldThrowInvalidEntityException(){
        CategorieDto expectedCategory = CategorieDto.builder().build();

        InvalidEntityException expectedException = assertThrows(InvalidEntityException.class, () -> service.save(expectedCategory));

       assertEquals(ErrorCodes.CATEGORY_NOT_VALID, expectedException.getErrorCode());
       assertEquals(1, expectedException.getErrors().size());
       assertEquals("Veuillez renseigner le code de la categorie", expectedException.getErrors().get(0));
    }

    @Test
    public void shouldThrowEntityNotFoundException() {
        EntityNotFoundException expectedException = assertThrows(EntityNotFoundException.class, () -> service.findById(0));

        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("Aucune category avec l'ID = 0 n' ete trouve dans la BDD", expectedException.getMessage());
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotFoundException2() {
        service.findById(0);
    }


}