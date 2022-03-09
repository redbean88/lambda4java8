package part5.model;

public abstract class Car {
    protected String type;
    protected String location;

    public Car(String type, String location) {
        this.type = type;
        this.location = location;
    }

    public abstract void drive();

}
