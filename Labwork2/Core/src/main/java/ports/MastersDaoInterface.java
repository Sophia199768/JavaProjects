package ports;

import model.Cat;
import model.Master;

import java.util.Date;
import java.util.List;

public interface MastersDaoInterface {
    void createMaster(String name, Date birthday, List<Cat> listOfCat);
    List<Master> read();
    void update(Master master);
    Master findById(Integer id);
    void delete(Integer id);
}
