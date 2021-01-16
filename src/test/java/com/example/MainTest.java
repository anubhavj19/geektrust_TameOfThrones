package com.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.example.Main.secretMessageIdentified;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSecretMessageIdentified() {
        //testing incorrect message
        String text = "pand";
        String emblem = "panda";

        assertFalse(secretMessageIdentified(text, emblem));
    }
}