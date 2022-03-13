package part8;

import part8.model.User;

import java.util.Arrays;
import java.util.List;

public class ParallelMain {
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

        long startTime = System.currentTimeMillis();
        users.stream()
                .filter(User::isVerified)
                .forEach(user -> System.out.println("user.getName() = " + user.getName()));
        long endTime = System.currentTimeMillis();
        System.out.println("seq time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        users.stream().parallel()
                .filter(User::isVerified)
                .forEach(user -> System.out.println("user.getName() = " + user.getName()));
        endTime = System.currentTimeMillis();
        System.out.println("parallel time " + (endTime - startTime));

    }
}
