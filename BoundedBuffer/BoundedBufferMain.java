package BoundedBuffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BoundedBufferMain {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        Producer producer = new Producer(queue, 10, "PRODUCER");
        Consumer consumer = new Consumer(queue, 10, "CONSUMER");
        producer.start();
        consumer.start();
    }
}
