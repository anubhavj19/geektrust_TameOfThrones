package com.example;

public class SeasarCipher {

    private int key;

    private final int totalAlphabets = 26;
    private final int upperCaseA = 65;
    private final int lowerCaseA = 97;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public SeasarCipher(int key) {
        this.key = key;
    }


    public String encryptMessage(String message) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < message.length(); i++)
        {
            if (Character.isUpperCase(message.charAt(i)))
            {
                char ch = (char)(((int)message.charAt(i) + key - upperCaseA) % totalAlphabets + upperCaseA);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)message.charAt(i) + key - 97) % totalAlphabets + 97);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public String decryptMessage(String message) {
        StringBuffer result = new StringBuffer();
        key = totalAlphabets - key;

        for (int i = 0; i < message.length(); i++)
        {
            if (Character.isUpperCase(message.charAt(i)))
            {
                char ch = (char)(((int)message.charAt(i) + key - upperCaseA) % totalAlphabets + upperCaseA);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)message.charAt(i) + key - lowerCaseA) % totalAlphabets + lowerCaseA);
                result.append(ch);
            }
        }

        return result.toString();
    }


}
