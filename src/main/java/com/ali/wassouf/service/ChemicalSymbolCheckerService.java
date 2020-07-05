package com.ali.wassouf.service;

import com.ali.wassouf.exceptions.InvalidInputException;

/**
 * @author Ali Wassouf
 */
public class ChemicalSymbolCheckerService {

    public boolean isValid(String name, String symbol) throws InvalidInputException {
        if (name.isBlank() || symbol.isBlank()) throw new InvalidInputException("Symbol and name can't be empty");
        int firstIndex = checkFirstLetter(name, symbol);
        int secondIndex = checkSecondLetter(name, symbol, firstIndex + 1);
        return validateLettersAppearance(firstIndex, secondIndex);
    }

    private int checkFirstLetter(String name, String symbol) {
        return checkLetterAppearance(name, symbol.charAt(0), 0);
    }

    private int checkSecondLetter(String name, String symbol, int startIndex) {
        return checkLetterAppearance(name, symbol.charAt(1), startIndex);
    }

    private int checkLetterAppearance(String name, char letter, int startIndex) {
        for (int i = startIndex; i < name.length(); i++) {
            if (name.charAt(i) == letter) return i;
        }
        return -1;
    }

    private boolean validateLettersAppearance(int firstIndex, int secondIndex) {
        return (firstIndex < secondIndex) && firstIndex != -1 && secondIndex != -1;
    }
}
