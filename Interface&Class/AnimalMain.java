interface Animal
{
    void sound();
    void eat();
}

class Birds implements Animal
{
    public void sound()
    {
        System.out.println("Birds chirp");
    }
    public void eat()
    {
        System.out.println("Birds eat worms");
    }
}

class Insects implements Animal
{
    public void sound()
    {
        System.out.println("Insects buzz");
    }
    public void eat()
    {
        System.out.println("Insects eat leaves");
    }
}

class Mammals implements Animal
{
    public void sound()
    {
        System.out.println("Mammals roar");
    }
    public void eat()
    {
        System.out.println("Mammals eat meat");
    }
}

public class AnimalMain
{
    public static void main(String[] args)
    {
        Birds b=new Birds();
        b.sound();
        b.eat();
        Insects i=new Insects();
        i.sound();
        i.eat();
        Mammals m=new Mammals();
        m.sound();
        m.eat();
    }
}
