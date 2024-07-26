package com.example.core.ports;

import com.example.core.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface MasterRepositoryInterface extends JpaRepository<Master, Integer> {
    Master findMasterById(Integer id);

    Master findMasterByLogin(String login);
    void deleteMasterById (Integer id);
}
