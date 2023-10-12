package SleepingBarber;

public class Customer extends Thread {
    private BarberShop barberShop;
    private int id;

    public Customer(BarberShop barberShop, int id) {
        this.barberShop = barberShop;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                barberShop.enterShop(id);
                barberShop.waitForBarber(id);
                System.out.println("Customer " + id + " is getting a haircut");
                barberShop.leaveShop(id);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

