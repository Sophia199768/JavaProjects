package com.example.microserviceforaccessingmasters.ports;

import com.example.linkagecatmaster.models.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MasterRepositoryInterface extends JpaRepository<Master, Integer> {
    Master findMasterById(Integer id);
    Master findMasterByLogin(String login);
    void deleteMasterById (Integer id);
}
