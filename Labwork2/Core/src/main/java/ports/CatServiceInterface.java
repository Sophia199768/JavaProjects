package ports;

import model.Cat;

import java.util.Date;
import java.util.List;

public interface CatServiceInterface {
    void createCat(String name, Date birthday, String breed, String color, List<Cat> cats);
    void madeCatsFriends(Cat catFriendOne, Cat catFriendTwo);
    Cat findById(Integer id);
    List<Cat> read(Cat cat);
    void update(Cat cat);
    void delete(Integer id);
}
