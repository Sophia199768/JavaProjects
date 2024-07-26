package com.example.application.controller;
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
        getMaster.setName(master.getName());
        getMaster.setBirthday(master.getBirthday());
        return getMaster;
    }

    @PostMapping("/newmaster")
    public void create(@RequestBody RequestMaster master) {
        mastersService.createMaster(master.getName(), master.getBirthday());
    }

    @PutMapping("/name")
    public void updateName(@RequestBody RequestMaster master) {
        mastersService.updateName(master.getId(), master.getName());
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
            response.setName(master.getName());
            response.setBirthday(master.getBirthday());
            return response;
        }).collect(Collectors.toList());
    }
}