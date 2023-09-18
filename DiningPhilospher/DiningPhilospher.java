package DiningPhilospher;

import java.util.concurrent.Semaphore;

class Philospher extends Thread {
    private Semaphore[] forks;
    private Semaphore maxDiners;
    private int id;

    public Philospher(Semaphore[] forks, Semaphore maxDiners, int id) {
        this.forks = forks;
        this.maxDiners = maxDiners;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                maxDiners.acquire();
                forks[id].acquire();
                forks[(id + 1) % forks.length].acquire();
                System.out.println("Philospher " + id + " is eating");
                Thread.sleep(1000);
                forks[id].release();
                forks[(id + 1) % forks.length].release();
                maxDiners.release();
                System.out.println("Philospher " + id + " is thinking");
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}