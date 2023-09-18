package DiningPhilospher;

import java.util.concurrent.Semaphore;

public class DiningPhilospherMain {
        public static void main(String[] args) {
        int n = 5;
        Semaphore[] forks = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            forks[i] = new Semaphore(1);
        }
        Semaphore maxDiners = new Semaphore(n - 1);
        Philospher[] philosphers = new Philospher[n];
        for (int i = 0; i < n; i++) {
            philosphers[i] = new Philospher(forks, maxDiners, i);
            philosphers[i].start();
        }
    }
}
