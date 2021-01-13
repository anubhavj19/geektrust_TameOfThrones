package com.example;

import org.junit.jupiter.api.Test;

import static com.example.Main.secretMessageIdentified;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void secretMessageIdentifiedTest() {
    //testing incorrect message

        String text = "pand";
        String emblem = "panda";

        assertFalse(secretMessageIdentified(text, emblem));
    }
}