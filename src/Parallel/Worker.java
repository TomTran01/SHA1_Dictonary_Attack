package Parallel;

import Helper.SHA1;

public class Worker extends Thread{

    private Queue queue;
    private WorkerPool pool;

    public Worker(Queue queue, WorkerPool pool) {
        this.queue = queue;
        this.pool = pool;
    }

    @Override
    public void run() {
        while(!interrupted()) {
            Task task = queue.nextTask();

            if (SHA1.convert(task.getWord()).equals(Task.hash)) {
                pool.setPassword(task.getWord());
            }
        }
    }


}
