package com.ali.wassouf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ali Wassouf
 */
class MainTest {

    private Main main = new Main();

    @Test
    void init(){
        Assertions.assertNotNull(main);
    }
}