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

        System.out.println(getAllies(southeros, args[0]));
        //System.out.println(getAllies(southeros, "/home/anubhavj19/Anubhav/geektrust/src/main/resources/test.txt"));
    }

    public static String getAllies(Southeros southeros, String filePath) throws IOException {
        //initializing allies and final output
        List<String> allies = new ArrayList<>();
        String failureMessage = "NONE";
        List<String> allLines = Files.readAllLines(Paths.get(filePath));

        //initializing cipher class object
        SeasarCipher cipherObject;

        //looping each line of the input file
            for (String line : allLines) {
                String kingdomName = line.split(" ")[0];

                try {
                    //check if kingdom exists in Southeros
                    if (southeros.kingdomExists(kingdomName.toLowerCase())) {
                        String emblem = southeros.getKingdom(kingdomName.toLowerCase()).getEmblem();
                        cipherObject = new SeasarCipher(emblem.length());

                        String message = line.substring(kingdomName.length() + 1);
                        String decryptedMessage = cipherObject.decryptMessage(message);

                        if (secretMessageIdentified(decryptedMessage.toLowerCase(), emblem.toLowerCase())) {
                            allies.add(kingdomName);
                        }

                        if (allies.size() >= 3) {
                            String alliedKingdoms = "";

                            for (int i = 0; i < allies.size(); i++) {
                                if (i == 0) {
                                    alliedKingdoms = allies.get(i).toString();
                                }
                                else {
                                    alliedKingdoms += " " + allies.get(i);
                                }
                            }

                            return "SPACE " + alliedKingdoms;
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Incorrect input.");
                }
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
