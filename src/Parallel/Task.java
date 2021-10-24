package Parallel;

import Helper.SHA1;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Stream;

public class Task {

    public static String hash = "";

    private String word;

    public Task(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
