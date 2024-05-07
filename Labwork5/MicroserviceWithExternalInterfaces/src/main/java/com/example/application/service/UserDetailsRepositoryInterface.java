package com.example.application.service;

import com.example.linkagecatmaster.models.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepositoryInterface extends JpaRepository<Master, Integer> {
    Master findMasterByLogin(String login);
}
