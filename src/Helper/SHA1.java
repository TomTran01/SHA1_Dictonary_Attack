package Helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

    /**
     * Converts given text to SHA1-Hash
     * @param text Text, that shall be hashed
     * @return Hashed text
     */
    public static String convert(String text) {
        if(text.isBlank()) {
            return "";
        }

        MessageDigest msgDst = null;

        try {
            msgDst = MessageDigest.getInstance("SHA1"); // Siehe https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest
        } catch (NoSuchAlgorithmException e) {}

        BigInteger binaryText = new BigInteger(text.getBytes());
        byte[] byteHash = msgDst.digest(binaryText.toByteArray());

        return byteArrayToString(byteHash);
    }

    /**
     * Converts array of bytes into String.
     * @param bytes Byte-Array, that shall be converted.
     * @return Converted String.
     */
    private static String byteArrayToString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            // & 0xff: Macht Wert Vorzeichenlos und nimmt die letzen 8 Bits
            // + 0x100: Füllt auf 9 Bits auf, substring(1) reduziert auf 8 Bits
            // radix = 16: Basis 16 bzw. Hexadezimal-Darstellung
        }

        return builder.toString();
    }
}
