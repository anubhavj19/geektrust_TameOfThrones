package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {

    private Space space;

    @BeforeEach
    void initializeSpaceKingdom() {
        space = new Space();
    }

    @Test
    void WhenInputIsEmpty() {
        Southeros southeros = new Southeros();
        List<String> secretMessages = new ArrayList<>();
        String output = space.getListOfAllies(southeros, secretMessages);

        assertEquals("NONE", output);
    }

    @Test
    void getListOfAlliesWhenInputIsInvalid() {
        Southeros southeros = new Southeros();
        List<String> secretMessages = Arrays.asList("a", "   b", "c  ", "abd", " a  b  cd");
        String output = space.getListOfAllies(southeros, secretMessages);

        assertEquals("NONE", output);
    }

    @Test
    void secretMessageIdentified() {
        String decryptedMessage = "AYDSSNJFFJAWWHP";
        String emblem = "panda";

        assertEquals(true, space.secretMessageIdentified(decryptedMessage, emblem));
    }
}