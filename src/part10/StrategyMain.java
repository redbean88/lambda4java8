package part10;

import java.util.Arrays;
import java.util.List;

public class StrategyMain {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("candy");

        Item item2 = new Item();
        item2.setName("toy");

        List<Item> items = Arrays.asList(item, item2);

        Mall mall = new Mall();
        mall.setShop(new CandyShop());

        items.stream()
                .filter(x -> "candy".equalsIgnoreCase(x.getName()))
                .forEach(mall::printName);


    }

}

interface Shop {
    String getName(Item item);
}

class Mall {
    private Shop shop;

    public Mall setShop(Shop shop) {
        this.shop = shop;
        return this;
    }

    public void printName(Item item) {
        String name = shop.getName(item);
        System.out.println("name = " + name);
    }
}

class CandyShop implements Shop {

    @Override
    public String getName(Item item) {
        return "this candy is " + item.getName();
    }
}

class ToyShop implements Shop {

    @Override
    public String getName(Item item) {
        return "this toy is " + item.getName();
    }
}

class Item {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}