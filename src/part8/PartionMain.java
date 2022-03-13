package part8;

import part8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartionMain {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1231, 45345, 62, 2, 3, 4, 65, 16, 3, 4, 4361, 234, 2356);
        Map<Boolean, List<Integer>> collect = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println("collect = " + collect.get(true));


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

        Map<Boolean, List<User>> friendsmap = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getFriendUserIds().size() > 4));

        System.out.println("friendsmap.get(true) = " + friendsmap.get(true));


    }
}
