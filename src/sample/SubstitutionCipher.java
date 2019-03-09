package sample;

public class SubstitutionCipher {
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key;
    private String message;
    private String encryption;

    public SubstitutionCipher(String message, String key) {
        this.key = key;
        this.message = message.toUpperCase();
        this.encryption = encrypt();
    }

    public String encrypt() {
        String encryption = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') encryption += " ";
            else encryption += key.charAt(alphabet.indexOf(message.charAt(i)));
        }
        return encryption;
    }

    public static String encrypt(String message, String key) {
        String encryption = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') encryption += " ";
            else encryption += key.charAt(alphabet.indexOf(message.charAt(i)));
        }
        return encryption;
    }

    public String decrypt() {
        String message = "";
        encryption = encryption.toUpperCase();
        for (int i = 0; i < encryption.length(); i++) {
            if (encryption.charAt(i) == ' ') message += " ";
            else message += alphabet.charAt(key.indexOf(encryption.charAt(i)));
        }
        return message;
    }

    public static String decrypt(String encryption, String key) {
        String message = "";
        encryption = encryption.toUpperCase();
        for (int i = 0; i < encryption.length(); i++) {
            if (encryption.charAt(i) == ' ') message += " ";
            else message += alphabet.charAt(key.indexOf(encryption.charAt(i)));
        }
        return message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        this.encryption = encrypt();
    }

    public String getEncryption() {
        return encryption;
    }

    @Override
    public String toString() {
        return key + " / " + message + " / " + encryption;
    }
}
