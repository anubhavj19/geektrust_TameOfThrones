package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Southeros {

    private Map<String, String> kingdoms= new HashMap<>();

    public void addKingdom(String kingdomName, String kingdomEmblem) {
        kingdoms.put(kingdomName, kingdomEmblem);
    }

    public String getEmblem(String kingdomName) {
        return kingdoms.get(kingdomName);
    }
}
