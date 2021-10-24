package Parallel;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private Integer maxTasks;
    private List<Task> tasks;

    public Queue(Integer maxTasks) {
        this.maxTasks = maxTasks;
        tasks = new ArrayList<>();
    }

    public synchronized void add(Task task) {
        while(tasks.size() == maxTasks) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tasks.add(task);
        this.notify();
    }

    public synchronized Task nextTask() {
        while(tasks.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Task task = this.tasks.remove(0);
        this.notify();
        return task;
    }
}
