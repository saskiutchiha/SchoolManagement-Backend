package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.impl.ProfImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.impl.ProfImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prof")
@CrossOrigin(origins = "http://localhost:5173")
    public class ProfRestAPI {
        @Autowired
        private ProfImpl profimpl;
        @GetMapping("/getprof")
        public List<Prof> getProf() {
            return profimpl.getprofs();
        }
        @PostMapping("/addprof")
    public void addProf(@RequestBody Prof prof) {
            profimpl.addprof(prof);
        }
        @PostMapping("/deleteprof")
    public void deleteProf(@RequestBody Prof prof) {
            profimpl.deletprof(prof);
        }
    @PostMapping("/updateprof")
    public void updateProf(@RequestBody Prof prof) {
        profimpl.updateprof(prof);
    }
    }