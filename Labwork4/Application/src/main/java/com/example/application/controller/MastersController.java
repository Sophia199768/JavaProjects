package com.example.application.controller;
import com.example.application.requests.CreateMasterRequest;
import com.example.application.requests.RequestMaster;
import com.example.application.requests.RequestMasterCat;
import com.example.application.response.ResponseGetMaster;
import com.example.core.model.Master;
import com.example.core.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/masters")
@RequiredArgsConstructor
public class MastersController {

    private final MasterService mastersService;

    @GetMapping("/{id}")
    public ResponseGetMaster getById(@PathVariable Integer id) {
        Master master = mastersService.findById(id);
        ResponseGetMaster getMaster = new ResponseGetMaster();
        getMaster.setId(master.getId());
        getMaster.setName(master.getLogin());
        getMaster.setBirthday(master.getBirthday());
        return getMaster;
    }

    @PostMapping("/newmaster")
    public void create(@RequestBody CreateMasterRequest master) {
        mastersService.createMaster(master.getLogin(), master.getPassword(), master.getBirthday(), master.getRole());
    }

    @PutMapping("/name")
    public void updateName(@RequestBody RequestMaster master) {
        mastersService.updateName(master.getId(), master.getLogin());
    }

    @PutMapping("/owncat")
    public void addNewCat(@RequestBody RequestMasterCat masterCat) {
        mastersService.addNewCat(masterCat.getMasterId(), masterCat.getCatId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        mastersService.delete(id);
    }

    @GetMapping("/all")
    public List<ResponseGetMaster> getAll() {
        return mastersService.findAll().stream().map(master -> {ResponseGetMaster response = new ResponseGetMaster();
            response.setId(master.getId());
            response.setName(master.getLogin());
            response.setBirthday(master.getBirthday());
            return response;
        }).collect(Collectors.toList());
    }
}