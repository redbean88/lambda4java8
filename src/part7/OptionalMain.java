package part7;

import part7.model.User;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {

        String email = "test@test.com";
        String nullemail = null;
        String defaultEmail = "default@test.com";

        Optional<String> email1 = Optional.of(email);
        Optional<String> email2 = Optional.empty();
        Optional<String> email3 = Optional.ofNullable(email);
        Optional<String> email4 = Optional.ofNullable(nullemail);

//        System.out.println("email1 = " + email1.get());
        if(email2.isPresent())
            System.out.println("email2 = " + email2.get());
//        System.out.println("email3 = " + email3.orElse(defaultEmail));
//        System.out.println("email4 = " + email4.orElseGet(() -> "any@test.com"));
//        System.out.println("email4 = " + email4.get());
//        System.out.println("email5 = " + email2.orElseThrow(() -> new RuntimeException("test")));


        Optional<User> maybeUser = Optional.ofNullable(getUser(true));
        maybeUser.ifPresent( user -> System.out.println(user.getId()));

        Optional<User> maybeUser2 = Optional.ofNullable(getUser(true));
        Optional<Integer> integer = maybeUser2.map(User::getId);
        integer.ifPresent(System.out::println);

        Optional<User> maybeUser3 = Optional.ofNullable(getUser(false));
        String myname = maybeUser3.map(user -> user.getName())
                .map(name -> "my name is " + name)
                .orElse("John Doe");
        System.out.println("myname = " + myname);
    }

    public static User getUser(boolean flag){
        if(flag){
            return new User()
                    .setId(101)
                    .setName("test")
                    .setEmailAddress("test@test.com")
                    .setVerified(true);
        }else{
            return null;
        }
    }
}
