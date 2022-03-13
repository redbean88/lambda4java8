package part8;

import part8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForeachMain {
    public static void main(String[] args) {


        User user1 = new User()
                .setId(101)
                .setName("kim")
                .setVerified(true)
                .setEmailAddress("test@test.com")
                .setFriendUserIds(Arrays.asList(202,211,255,233,555,222));

        User user2 = new User()
                .setId(102)
                .setName("park")
                .setVerified(false)
                .setEmailAddress("test@test2.com")
                .setFriendUserIds(Arrays.asList(211,255));

        User user3 = new User()
                .setId(103)
                .setName("choi")
                .setVerified(false)
                .setEmailAddress("test@test3.com")
                .setFriendUserIds(Arrays.asList(202,215,255));

        List<User> users = Arrays.asList(user1, user2, user3);
        
        users.forEach(user -> System.out.println("user.getName() = " + user.getName()));

        users.stream()
                .filter(User::isVerified)
                .forEach(user -> System.out.println("user.getName()2 = " + user.getName()));
        IntStream.range(0 , users.size()).forEach( i -> System.out.println("users.get(i).getFriendUserIds() = " + users.get(i).getFriendUserIds()));
    }
}
