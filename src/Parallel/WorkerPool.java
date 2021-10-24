package Parallel;

import java.util.ArrayList;
import java.util.List;

public class WorkerPool extends Thread{

    private Integer maxWorkers;
    private List<Worker> workers;
    private Queue queue;

    private Future<String> password = new Future<>();


    public WorkerPool(Integer maxWorkers, Queue queue){
        this.maxWorkers = maxWorkers;
        this.queue = queue;
        workers = new ArrayList<>();
    }

    public void run(){
        for (int i = 0; i < maxWorkers; i++) {
            Worker worker = new Worker(queue, this);
            workers.add(worker);
            worker.start();
        }
    }

    public String getPassword() {
        return this.password.get();
    }

    public void setPassword(String password) {

        for (Worker worker: workers) {
            worker.interrupt();
        }

        this.password.set(password);
    }
}
