package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Space {

    public final String failureMessage = "NONE";

    private List<String> allyNames;

    public Space() {
        allyNames = new ArrayList<>();
    }

    public List<String> getAllyNames() {
        return allyNames;
    }

    public void addAllyName(String allyName) {
        this.allyNames.add(allyName);
    }

    public int getAllyCount() {
        return this.allyNames.size();
    }

    public String getListOfAllies(Southeros southeros, List<String> secretMessages) {
        //initializing cipher class object
        SeasarCipher cipherObject;


            //looping each secret message
        for (String secretMessage : secretMessages) {
            String kingdomName = secretMessage.split(" ")[0];

            try {
                //check if kingdom exists in Southeros
                if (southeros.kingdomExists(kingdomName)) {
                    String emblem = southeros.getKingdom(kingdomName).getEmblem();
                    cipherObject = new SeasarCipher(emblem.length());

                    String message = secretMessage.substring(kingdomName.length() + 1);
                    String decryptedMessage = cipherObject.decryptMessage(message);

                    if (secretMessageIdentified(decryptedMessage.toLowerCase(), emblem.toLowerCase())) {
                        addAllyName(kingdomName);
                    }

                    if (getAllyCount() >= 3) {
                        List<String> allies = getAllyNames();
                        String alliedKingdoms = "";

                        for (int i = 0; i < getAllyCount(); i++) {
                            if (i == 0) {
                                alliedKingdoms = allies.get(i).toString();
                            } else {
                                alliedKingdoms += " " + allies.get(i);
                            }
                        }

                        return "SPACE " + alliedKingdoms;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Invalid input.");
            }
        }

        return failureMessage;
    }

    public boolean secretMessageIdentified(String text, String emblem) {

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
