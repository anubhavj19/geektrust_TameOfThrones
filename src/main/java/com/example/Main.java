package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int allies = 0;

        Southeros southeros = new Southeros();
        southeros.addKingdom("space", "gorilla");
        southeros.addKingdom("land", "panda");
        southeros.addKingdom("water", "octopus");
        southeros.addKingdom("ice", "mammoth");
        southeros.addKingdom("air", "owl");
        southeros.addKingdom("fire", "dragon");

        List<String> allLines = Files.readAllLines(Paths.get("/home/anubhavj19/Anubhav/geektrust/src/main/resources/test.txt"));
        SeasarCipher cipherObject = new SeasarCipher();
        String outputMessage = "";

        for (String line : allLines) {
            String kingdomName = line.split(" ")[0];
            String emblem = southeros.getEmblem(kingdomName.toLowerCase());

            String message = line.substring(kingdomName.length() + 1);
            String decryptedMessage = cipherObject.decryptMessage(message, emblem.length());

            if (secretMessageIdentified(decryptedMessage.toLowerCase(), emblem.toLowerCase())) {
                allies++;
                outputMessage += kingdomName + " ";
            }
        }

        if (allies >= 3) {
            System.out.println("SPACE " + outputMessage);
        } else {
            System.out.println("NONE");
        }
    }

    public static boolean secretMessageIdentified(String text, String emblem) {

        HashMap<Character, Integer> hashmap = new HashMap<>();

        for (char ch : emblem.toCharArray()) {
            if (!hashmap.containsKey(ch)) {
                hashmap.put(ch, 1);
            } else {
                int count = hashmap.get(ch);
                hashmap.put(ch, ++count);
            }
        }

        for (char ch : text.toCharArray()) {
            if (hashmap.containsKey(ch)) {
                int count = hashmap.get(ch);
                hashmap.put(ch, --count);
            }
        }

        for (int value : hashmap.values()) {
            if (value > 0) {
                return false;
            }
        }

        return true;
    }
}
