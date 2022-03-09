package part5;

import part5.model.Bus;
import part5.model.Car;
import part5.model.Taxi;
import part5.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReference3 {
    public static void main(String[] args) {
        User user = new User(1, "kim");
        BiFunction<Integer, String, User> userCreate = User::new;
        User alice = userCreate.apply(4, "Alice");
        System.out.println(alice);


        String[][] carcube = new String[][]{
                {"bus", "마을", "강촌"},
                {"taxi", "마을", "강변"}
        };

        Map<String, BiFunction<String, String, Car>> carMap = new HashMap<>();
        carMap.put("bus", Bus::new);
        carMap.put("taxi", Taxi::new);

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carcube.length; i++) {
            String[] cube = carcube[i];
            String key = cube[0];
            String type = cube[1];
            String location = cube[2];
            carList.add(carMap.get(key).apply(type, location));
        }

        for (Car car : carList) {
            car.drive();
        }

    }

}
