package part5.model;

public class Bus extends Car{

    public Bus(String type, String location) {
        super(type, location);
    }

    @Override
    public void drive() {
        System.out.println("type = " + type + "location = " + location);
    }
}
