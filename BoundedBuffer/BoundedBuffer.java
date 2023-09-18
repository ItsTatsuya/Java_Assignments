package BoundedBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
    private BlockingQueue<Integer> queue;
    private int maxSize;

    public Producer(BlockingQueue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                queue.put(i);
                System.out.println("Producing value : " + i);
                i++;
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private BlockingQueue<Integer> queue;
    private int maxSize;

    public Consumer(BlockingQueue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int x = queue.take();
                System.out.println("Consuming value : " + x);
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}