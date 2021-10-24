package Parallel;

public class Future<T> {
    private T result;

    public Future() {

    }

    public synchronized void set(T result) {
        this.result = result;
        this.notify();
    }

    public synchronized T get() {
        while (result == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
