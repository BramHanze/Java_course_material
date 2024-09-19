package section3_apis.part1_interfaces;

public class CaesarCypher implements EncryptionEngine {

    @Override
    public String encrypt(String message) {
        String output = "";
        for (char ch : message.toCharArray()) {
            boolean isUpperCase = Character.isUpperCase(ch);
            ch = Character.toLowerCase(ch);

            if (!Character.isLetter(ch)) {
                output += ch;
                continue;
            }
            int pos = (ch - 'a' + 1 + 22) % 26;
            char newChar = (char)(pos + 'a');

            if (isUpperCase) {
                newChar = Character.toUpperCase(newChar);
            }
            output += newChar;
        }
            return output;
    }

    @Override
    public String decrypt(String encryptedMessage) {
        String output = "";
        for (char ch : encryptedMessage.toCharArray()) {
            boolean isUpperCase = Character.isUpperCase(ch);
            ch = Character.toLowerCase(ch);

            if (!Character.isLetter(ch)) {
                output += ch;
                continue;
            }
            int pos = (ch - 'a' + 1 + 2) % 26;
            char newChar = (char)(pos + 'a');

            if (isUpperCase) {
                newChar = Character.toUpperCase(newChar);
            }
            output += newChar;
        }
        return output;
    }
}

