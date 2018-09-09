package lab03;

/**
 * Created by rebeccaxu on 11/27/17.
 */
public class Encryption {
    final static int LETTERS_IN_ALPHABET = 26;
    final static int NUM_OF_LETTERS = 8;

    public static String encrypt(int key, String text) {
        String stringEncryption = "";
        char newLetter;
        char originalLetter[] = text.toCharArray();

        for (int i = 0; i < NUM_OF_LETTERS; i++) {
            newLetter = (char)(((originalLetter[i] + key - 'A') % LETTERS_IN_ALPHABET) + 'A');
            key = key + originalLetter[i];
            stringEncryption += newLetter;
        }

         return stringEncryption;
    }

    public static String decrypt(int key, String text) {
        String stringDecryption = "";
        char newLetter;
        char originalLetter[] = text.toCharArray();

        for (int i = 0; i < NUM_OF_LETTERS; i++) {
            newLetter = (char)(((originalLetter[i] - key + 'A') % LETTERS_IN_ALPHABET) + 'A');
            key = ((key + newLetter) % LETTERS_IN_ALPHABET);
            stringDecryption += newLetter;
        }

        return stringDecryption;
    }
}

/*
A would be mapped to B, B to C, C to D... Z to A.
*/