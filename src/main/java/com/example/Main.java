package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

        System.out.println(getAllies(southeros, "/home/anubhavj19/Anubhav/geektrust/src/main/resources/test.txt"));
        //"/home/anubhavj19/Anubhav/geektrust/src/main/resources/test.txt"
    }

    public static String getAllies(Southeros southeros, String filePath) throws IOException {
        //initializing allies and final output
        int allies = 0;
        String successMessage = "";
        String failureMessage = "NONE";

        //Taking file path input on command line
        //List<String> allLines = Files.readAllLines(Paths.get(args[0]));
        List<String> allLines = Files.readAllLines(Paths.get(filePath));

        //initializing cipher class object
        SeasarCipher cipherObject;

        //looping each line of the input file
        try {
            for (String line : allLines) {
                String kingdomName = line.split(" ")[0];

                //check if kingdom exists in Southeros
                if (southeros.kingdomExists(kingdomName.toLowerCase())) {
                    String emblem = southeros.getKingdom(kingdomName.toLowerCase()).getEmblem();
                    cipherObject = new SeasarCipher(emblem.length());

                    String message = line.substring(kingdomName.length() + 1);
                    String decryptedMessage = cipherObject.decryptMessage(message);

                    if (secretMessageIdentified(decryptedMessage.toLowerCase(), emblem.toLowerCase())) {
                        allies++;
                        successMessage += kingdomName + " ";
                    }

                    if (allies >= 3) {
                        return "SPACE " + successMessage;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Incorrect input.");
        }

        return failureMessage;
    }

    public static boolean secretMessageIdentified(String text, String emblem) {

        HashMap<Character, Integer> hashmap = new HashMap<>();

        //hashmap to store characters of emblem and their count
        for (char ch : emblem.toCharArray()) {
            if (!hashmap.containsKey(ch)) {
                hashmap.put(ch, 1);
            } else {
                int count = hashmap.get(ch);
                hashmap.put(ch, ++count);
            }
        }

        //iterating characters in text and subtracting 1 from value if character matches in emblem
        for (char ch : text.toCharArray()) {
            if (hashmap.containsKey(ch)) {
                int count = hashmap.get(ch);
                hashmap.put(ch, --count);
            }
        }

        //checking if the resulting hashmap has value > 0 for any character
        for (int value : hashmap.values()) {
            if (value > 0) {
                return false;
            }
        }

        return true;
    }
}
