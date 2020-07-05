package com.ali.wassouf.service;

import com.ali.wassouf.exceptions.InvalidInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ali Wassouf
 */
class ChemicalSymbolCheckerServiceTest {

    private ChemicalSymbolCheckerService chemicalSymbolCheckerService = new ChemicalSymbolCheckerService();

    @Test
    void init(){
        assertNotNull(chemicalSymbolCheckerService);
    }

    @Test
    void whenPassedAnEmptyStringNameThrowException(){
        assertThatThrownBy(()->{
            chemicalSymbolCheckerService.isValid("", "");
        }).isInstanceOf(InvalidInputException.class).hasMessage("Symbol and name can't be empty");
    }

    @Test
    void whenPassedNameAndSymbolCorrectlyReturnTrue() throws InvalidInputException {
        assertTrue(chemicalSymbolCheckerService.isValid("spenglerium", "ee"));
        assertTrue(chemicalSymbolCheckerService.isValid("zeddemorium", "zr"));
    }

    @Test
    void whenPassedNameAndSymbolIncorrectlyReturnFalse() throws InvalidInputException {
        assertFalse(chemicalSymbolCheckerService.isValid("stantzon", "zt"));
    }
}