package com.example.core.ports;

import com.example.core.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@org.springframework.stereotype.Repository
@Repository
public interface CatRepositoryInterface extends JpaRepository<Cat, Integer> {
    Cat findCatById(Integer id);
    void deleteCatById (Integer id);
}
