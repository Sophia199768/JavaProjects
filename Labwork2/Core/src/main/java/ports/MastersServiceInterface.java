package ports;

import model.Cat;
import model.Master;

import java.util.Date;
import java.util.List;

public interface MastersServiceInterface {
    void createMaster(String name, Date birthday, List<Cat> listOfCats);
    void addNewCat(Master master, Cat cat);
    List<Master> read();
    void update(Master master);
    void delete(Integer id);
    Master findById(Integer id);
}
