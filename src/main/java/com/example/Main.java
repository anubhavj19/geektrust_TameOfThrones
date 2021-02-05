package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //initializing southeros and adding kingdoms
        Southeros southeros = new Southeros();
        southeros.addKingdom("space", "gorilla");
        southeros.addKingdom("land", "panda");
        southeros.addKingdom("water", "octopus");
        southeros.addKingdom("ice", "mammoth");
        southeros.addKingdom("air", "owl");
        southeros.addKingdom("fire", "dragon");

        List<String> secretMessages = Files.readAllLines(Paths.get(args[0]));
        //List<String> secretMessages = Files.readAllLines(Paths.get("/home/anubhavj19/Anubhav/geektrust/src/main/resources/test.txt"));

        Space space = new Space();
        System.out.println(space.getListOfAllies(southeros, secretMessages));
    }
}
