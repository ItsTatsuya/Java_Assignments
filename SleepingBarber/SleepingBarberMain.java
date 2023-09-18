package SleepingBarber;

import java.util.concurrent.Semaphore;

public class SleepingBarberMain {
    public static void main(String[] args) {
        Semaphore customers = new Semaphore(0);
        Semaphore barber = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        Barber b1 = new Barber(customers, barber, mutex, 1);
        Barber b2 = new Barber(customers, barber, mutex, 2);
        Customer c1 = new Customer(customers, barber, mutex, 1);
        Customer c2 = new Customer(customers, barber, mutex, 2);
        Customer c3 = new Customer(customers, barber, mutex, 3);
        Customer c4 = new Customer(customers, barber, mutex, 4);
        Customer c5 = new Customer(customers, barber, mutex, 5);
        b1.start();
        b2.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
