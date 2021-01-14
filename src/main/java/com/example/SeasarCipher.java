package com.example;

public class SeasarCipher {

    private int key;

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
                char ch = (char)(((int)message.charAt(i) + key - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)message.charAt(i) + key - 97) % 26 + 97);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public String decryptMessage(String message) {

        StringBuffer result = new StringBuffer();
        key = 26 - key;

        for (int i = 0; i < message.length(); i++)
        {
            if (Character.isUpperCase(message.charAt(i)))
            {
                char ch = (char)(((int)message.charAt(i) + key - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)message.charAt(i) + key - 97) % 26 + 97);
                result.append(ch);
            }
        }

        return result.toString();
    }


}
