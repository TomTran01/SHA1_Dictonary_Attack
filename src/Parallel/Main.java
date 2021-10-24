package Parallel;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue(20);
        WorkerPool pool = new WorkerPool(6, queue);
        TaskProvider provider = new TaskProvider("src/realhuman_phill.txt", queue);

        Task.hash = "bed9d93e040dbc21aae86d13f43929e9f650c1d8";

        pool.start();
        provider.start();

        long before = System.currentTimeMillis();
        System.out.println(pool.getPassword());
        System.out.println((System.currentTimeMillis() - before) / 1000 +"s");

        System.exit(0);

    }
}
