package sample;

public class AffineCipher {
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int keyA;
    private int keyB;
    private String message;
    private String encryption;

    /**
     * keyA must be coprime of alphabet.length()
     * otherwise the encryption may conflict and it results of an error(logic)
     * because of the Math.floorMod() in decrypt methods
     */

    public AffineCipher(String message, int keyA, int keyB){
        this.message = message.toUpperCase();
        this.keyA = keyA;
        this.keyB = keyB;
        this.encryption = encrypt();
    }

    public String encrypt(){
        String encryption = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') encryption += " ";
            else encryption += alphabet.charAt(((alphabet.indexOf(message.charAt(i)) * keyA) + keyB) % alphabet.length());
        }
        return encryption;
    }

    public static String encrypt(String message,int keyA,int keyB){
        String encryption = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') encryption += " ";
            else encryption += alphabet.charAt(((alphabet.indexOf(message.charAt(i)) * keyA) + keyB) % alphabet.length());
        }
        return encryption;
    }

    public String decrypt(){
        String message = "";
        int mmi = 0;

        for(int i = 1;i<alphabet.length();i++){
            if(((i * keyA) % 26 ) == 1){
                mmi = i;
                break;
            }
        }

        for (int i = 0; i < encryption.length(); i++) {
            if (encryption.charAt(i) == ' ') message += " ";
            else message += alphabet.charAt(Math.floorMod(((alphabet.indexOf(encryption.charAt(i)) - keyB) * mmi),alphabet.length()));
        }
        return message;
    }

    public static String decrypt(String encryption,int keyA,int keyB){
        String message = "";
        encryption = encryption.toUpperCase();
        int mmi = 0;

        for(int i = 1;i<alphabet.length();i++){
            if(((i * keyA) % 26 ) == 1){
                mmi = i;
                break;
            }
        }

        for (int i = 0; i < encryption.length(); i++) {
            if (encryption.charAt(i) == ' ') message += " ";
            else message += alphabet.charAt(Math.floorMod(((alphabet.indexOf(encryption.charAt(i)) - keyB) * mmi),alphabet.length()));
        }
        return message;
    }

    public String getKey() {
        return keyA + " " + keyB;
    }

    public void setKey(int keyA,int keyB) {
        this.keyA = keyA;
        this.keyB = keyB;
        this.encryption = encrypt();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message.toUpperCase();
        this.encryption = encrypt();
    }

    public String getEncryption() {
        return encryption;
    }

    @Override
    public String toString() {
        return keyA + " / " + keyB + " / " + message + " / " + encryption;
    }
}
