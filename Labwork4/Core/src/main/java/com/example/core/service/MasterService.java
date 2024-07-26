package com.example.core.service;

import com.example.core.model.Cat;
import com.example.core.model.Master;
import com.example.core.model.Role;
import com.example.core.ports.CatRepositoryInterface;
import com.example.core.ports.MasterRepositoryInterface;
import com.example.core.ports.MastersServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MasterService implements MastersServiceInterface {
    private final MasterRepositoryInterface masterRepository;

    private final CatRepositoryInterface catRepositoryInterface;

    @Override
    public void createMaster(String login, String password, Date birthday, Role role) {
        PasswordEncoder coderpassword = new BCryptPasswordEncoder();
        Master newMaster = new Master(login, coderpassword.encode(password), birthday, role);
        masterRepository.save(newMaster);
    }

    @Override
    public void addNewCat(Integer masterId, Integer catId) {
        Master master = masterRepository.findMasterById(masterId);
        Cat cat = catRepositoryInterface.findCatById(catId);
        master.getCats().add(cat);
        masterRepository.save(master);
    }

    @Override
    public void updateName(Integer id, String newName) {
        Master master = masterRepository.findMasterById(id);
        master.setLogin(newName);
        masterRepository.save(master);
    }

    @Override
    public void delete(Integer id) {
        masterRepository.deleteMasterById(id);
    }

    @Override
    public Master findById(Integer id) {
        return masterRepository.findMasterById(id);
    }

    @Override
    public List<Master> findAll() {
        return masterRepository.findAll();
    }
}
