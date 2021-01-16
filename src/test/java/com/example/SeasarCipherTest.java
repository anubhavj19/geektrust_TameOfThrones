package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SeasarCipherTest {

    @Test
    public void testDecryption() {
        int testKey = 4;
        SeasarCipher sc = new SeasarCipher(testKey);
        String message = "FdIXxsoKKOFbBMU";
        String decryptedMessage = "BzETtokGGKBxXIQ";

        assertEquals(sc.decryptMessage(message), decryptedMessage);
    }
}