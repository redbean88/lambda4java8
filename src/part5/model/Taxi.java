package part5.model;

public class Taxi extends Car{

    public Taxi(String type, String location) {
        super(type, location);
    }

    @Override
    public void drive() {
        System.out.println("type = " + type + "location = " + location);
    }
}
