package SleepingBarber;

/*sleeping barber problem */
import java.util.concurrent.Semaphore;

class Barber extends Thread {
    private Semaphore customers;
    private Semaphore barber;
    private Semaphore mutex;
    private int id;

    public Barber(Semaphore customers, Semaphore barber, Semaphore mutex, int id) {
        this.customers = customers;
        this.barber = barber;
        this.mutex = mutex;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                customers.acquire();
                mutex.acquire();
                barber.release();
                mutex.release();
                System.out.println("Barber " + id + " is cutting hair");
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

class Customer extends Thread {
    private Semaphore customers;
    private Semaphore barber;
    private Semaphore mutex;
    private int id;

    public Customer(Semaphore customers, Semaphore barber, Semaphore mutex, int id) {
        this.customers = customers;
        this.barber = barber;
        this.mutex = mutex;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                mutex.acquire();
                if (customers.availablePermits() == 0) {
                    System.out.println("Customer " + id + " is leaving");
                    mutex.release();
                    Thread.sleep(1000);
                } else {
                    customers.release();
                    mutex.release();
                    barber.acquire();
                    System.out.println("Customer " + id + " is getting a haircut");
                    Thread.sleep(1000);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
