package SleepingBarber;

public class Barber extends Thread {
    private BarberShop barberShop;
    private int id;

    public Barber(BarberShop barberShop, int id) {
        this.barberShop = barberShop;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                barberShop.waitForCustomer(id);
                System.out.println("Barber " + id + " is cutting hair");
                barberShop.finishedHaircut();
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

