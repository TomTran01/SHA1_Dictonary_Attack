package Parallel;

import Helper.SHA1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TaskProvider extends Thread{

    private Queue queue;
    private String filePath;

    public TaskProvider(String filePath, Queue queue) {
        this.filePath = filePath;
        this.queue = queue;
    }

    @Override
    public void run() {
        try (Stream<String> stream = Files.lines(Path.of(filePath), Charset.forName("ISO-8859-1"))) {
            stream.forEach(word -> queue.add(new Task(word)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
