package part4;

import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
         Supplier<String> mySupplier = () ->  "hello world";
        System.out.println("mySupplier.get() = " + mySupplier.get());


        Supplier<Double> randomNumber = () -> Math.random();
        printDoubles(randomNumber, 5);
    }

    public static void printDoubles(Supplier<Double> supplier, int count){
        for (int i = 0; i < count; i++) {
            System.out.println(supplier.get());
        }

    }
}
