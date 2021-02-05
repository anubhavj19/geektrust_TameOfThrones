package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Southeros {

    private Map<String, Kingdom> kingdoms;

    public Southeros() {
        kingdoms = new HashMap<>();
    }

    public void addKingdom(String kingdomName, String kingdomEmblem) {
        if (!kingdoms.containsKey(kingdomName)) {
            kingdoms.put(kingdomName, new Kingdom(kingdomName, kingdomEmblem));
        }
    }

    public boolean kingdomExists(String kingdomName) {
        return(kingdoms.containsKey(kingdomName.toLowerCase()));
    }

    public Kingdom getKingdom(String kingdomName) {
        return kingdoms.get(kingdomName.toLowerCase());
    }
}
