package sample;

public class CaesarCipher {
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String message;
    private String encryption;
    private int key;

    public CaesarCipher(String message, int key) {
        this.key = key;
        this.message = message.toUpperCase();
        this.encryption = encrypt();
    }//Constructor ensures the message is uppercase and encrypts it

    public String encrypt() {
        String encryption = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') encryption += " ";
            else encryption += alphabet.charAt((alphabet.indexOf(message.charAt(i)) + key) % alphabet.length());
        }
        return encryption;
    }//ensures that message is uppercase then carries every character except spaces

    public static String encrypt(String message, int key) {
        String encryption = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') encryption += " ";
            else encryption += alphabet.charAt((alphabet.indexOf(message.charAt(i)) + key) % alphabet.length());
        }
        return encryption;
    }

    public String getEncryption() {
        return encryption;
    }

    public String decrypt() {
        String message = "";
        for (int i = 0; i < encryption.length(); i++) {
            if (encryption.charAt(i) == ' ') message += " ";
            else
                message += alphabet.charAt((alphabet.indexOf(encryption.charAt(i)) - key + alphabet.length()) % alphabet.length());
        }
        return message;
    }//carries every character back

    public static String decrypt(String encryption, int key) {
        String message = "";
        encryption = encryption.toUpperCase();
        for (int i = 0; i < encryption.length(); i++) {
            if (encryption.charAt(i) == ' ') message += " ";
            else
                message += alphabet.charAt((alphabet.indexOf(encryption.charAt(i)) - key + alphabet.length()) % alphabet.length());
        }
        return message;
    }

    public static void analyse(String encryption) {
        String message;
        encryption.toUpperCase();
        for (int j = 1; j < alphabet.length(); j++) {
            message = "";
            for (int i = 0; i < encryption.length(); i++) {
                if (encryption.charAt(i) == ' ') message += " ";
                else
                    message += alphabet.charAt((alphabet.indexOf(encryption.charAt(i)) - j + alphabet.length()) % alphabet.length());
            }
            System.out.println(message);
        }
    }

    public void setMessage(String message) {
        this.message = message.toUpperCase();
        this.encryption = encrypt();
    }//re-encrypts message when it is changed

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
        this.encryption = encrypt();
    }//re-encrypts message when key is changed

    @Override
    public String toString() {
        return key + " / " + message + " / " + encryption;
    }
}
