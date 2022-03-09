package part4;

import part4.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(10, "Alice"));
        list.add(new User(22, "Bob"));
        list.add(new User(4, "John"));
        list.add(new User(9, "Ren"));

        Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();
        Collections.sort(list , idComparator);
        System.out.println("list = " + list);

        Collections.sort(list , (u1 , u2 ) -> u1.getName().compareTo(u2.getName()));
        System.out.println("list = " + list);

    }
}
