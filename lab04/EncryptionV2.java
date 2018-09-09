package lab04;

/**
 * Created by rebeccaxu on 12/14/17.
 */
public class EncryptionV2 {
    final static int POSSIBLE_CHARACTERS = 95;

    public static String encrypt(int key, String text) {
        String stringEncryption = "";
        char newLetter;
        char originalLetter[] = text.toCharArray();

        for (int i = 0; i < originalLetter.length; i++) {
            newLetter = (char)(((originalLetter[i] + key - ' ') % POSSIBLE_CHARACTERS) + ' ');
            key = key + originalLetter[i];
            stringEncryption += newLetter;
        }

        return stringEncryption;
    }

    public static String decrypt(int key, String text) {
        String stringDecryption = "";
        int pos;
        char newLetter;
        char originalLetter[] = text.toCharArray();

        for (int i = 0; i < originalLetter.length; i++) {
            pos = (originalLetter[i] - key - ' ');
            while (pos < 0) {
                pos += POSSIBLE_CHARACTERS;
            }
            newLetter = (char)((pos % POSSIBLE_CHARACTERS) + ' ');
            key = ((key + newLetter) % POSSIBLE_CHARACTERS);
            stringDecryption += newLetter;
        }

        return stringDecryption;
    }
}

/*
The goal here is to take your work from the previous encryption lab
and extend it to be really useful.  We’re going to allow
it to take all of the standard characters from a space
to a tilde, including all of the standard punctuation and
capital and lowercase letters.  We’re also going to allow
arbitrarily long Strings.
*/
