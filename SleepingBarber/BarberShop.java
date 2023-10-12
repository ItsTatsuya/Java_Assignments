package SleepingBarber;

import java.util.concurrent.Semaphore;

public class BarberShop {
    private Semaphore customers;
    private Semaphore barbers;
    private Semaphore mutex;

    public BarberShop(int numBarbers) {
        customers = new Semaphore(0);
        barbers = new Semaphore(numBarbers);
        mutex = new Semaphore(1);
    }

    public void enterShop(int customerId) throws InterruptedException {
        mutex.acquire();
        System.out.println("Customer " + customerId + " enters the shop");
        mutex.release();
    }

    public void waitForBarber(int customerId) throws InterruptedException {
        customers.release();
        barbers.acquire();
        mutex.acquire();
        System.out.println("Customer " + customerId + " waits for a barber");
        mutex.release();
    }

    public void waitForCustomer(int barberId) throws InterruptedException {
        customers.acquire();
        barbers.release();
        mutex.acquire();
        System.out.println("Barber " + barberId + " calls in a customer");
        mutex.release();
    }

    public void finishedHaircut() throws InterruptedException {
        mutex.acquire();
        System.out.println("Barber finished haircut");
        mutex.release();
    }

    public void leaveShop(int customerId) throws InterruptedException {
        mutex.acquire();
        System.out.println("Customer " + customerId + " leaves the shop");
        mutex.release();
    }
}
