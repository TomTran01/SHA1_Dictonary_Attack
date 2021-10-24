package Serialized;

import Helper.SHA1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Cracker {
    public static void main(String[] args) {

        long before = System.currentTimeMillis();

        String password = crack("bed9d93e040dbc21aae86d13f43929e9f650c1d8");
        System.out.println(password);

        System.out.println((System.currentTimeMillis() - before) / 1000 + "s");
    }

    private static String crack(String hash) {
        String possiblePassword = "";

        try (Stream<String> stream = Files.lines(Path.of("src/realhuman_phill.txt"), Charset.forName("ISO-8859-1"))) {
            possiblePassword = stream.filter(word -> SHA1.convert(word).equals(hash)).findFirst().get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return possiblePassword;
    }


}
