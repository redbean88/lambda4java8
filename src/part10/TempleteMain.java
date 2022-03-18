package part10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TempleteMain {
    public static void main(String[] args) {
        User user = new User();
        user.setName("hong");
        user.setId("1231");
        User user2 = new User();
        user2.setName("test");

        List<User> users = Arrays.asList(user, user2);

        UserService userService = new UserService();
        userService.createUser(user2);

        InterUserService interUserService = new InterUserService();
        interUserService.createUser(user2);

        AbstractUserService4Lambda abstractUserService4Lambda = new AbstractUserService4Lambda(
                u -> {
                    return u.getName() != null &&  u.getId() != null;
                },
                u -> {
                    System.out.println("insert into user ");
                }
        );
        abstractUserService4Lambda.createUser(user);
    }


}


abstract class AbstractUserService{
    protected abstract boolean validateUser(User user);
    protected abstract void writeDB(User user);

    public void createUser(User user){
        if(validateUser(user)){
            writeDB(user);
        }else{
            System.out.println("cannot create user");
        }
    }
}

class AbstractUserService4Lambda{
    private final Predicate<User> validateUser;
    private final Consumer<User> writeDB;

    public AbstractUserService4Lambda(Predicate<User> validateUser, Consumer<User> writeDB) {
        this.validateUser = validateUser;
        this.writeDB = writeDB;
    }

    public void createUser(User user){
        if(validateUser.test(user)){
            writeDB.accept(user);
        }else{
            System.out.println("cannot create user");
        }
    }
}


class UserService extends AbstractUserService{

    @Override
    protected boolean validateUser(User user) {
        return user.getName() != null &&  user.getId() != null;
    }

    @Override
    protected void writeDB(User user) {
        System.out.println("insert into user ");
    }
}
class InterUserService extends AbstractUserService{

    @Override
    protected boolean validateUser(User user) {
        System.out.println("in = " + user.getName());
        return user.getName() != null;
    }

    @Override
    protected void writeDB(User user) {
        System.out.println("insert into user ");
    }
}



class User {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}