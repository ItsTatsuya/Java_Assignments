package SleepingBarber;
public class SleepingBarberMain {
    public static void main(String[] args) {
        int numBarbers = 2;
        int numCustomers = 5;

        BarberShop barberShop = new BarberShop(numBarbers);

        for (int i = 1; i <= numBarbers; i++) {
            new Barber(barberShop, i).start();
        }

        for (int i = 1; i <= numCustomers; i++) {
            new Customer(barberShop, i).start();
        }
    }
}


