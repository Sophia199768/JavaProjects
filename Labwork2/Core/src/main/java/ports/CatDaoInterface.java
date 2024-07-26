package ports;

import model.Cat;

import java.util.Date;
import java.util.List;

public interface CatDaoInterface {
    void createCat(String name, Date birthday, String breed, String color, List<Cat> cats);
    List<Cat> read(Cat cat);
    void update(Cat cat);
    Cat findById(Integer id);
    void delete(Integer id);
}

