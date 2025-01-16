package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.impl.ProfImpl;
import org.ensa.schoolmanagementbackend.metier.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


import org.ensa.schoolmanagementbackend.dao.entity.Prof;
import org.ensa.schoolmanagementbackend.dao.impl.ProfImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/prof")
@CrossOrigin(origins = "http://localhost:5173")
    public class ProfRestAPI {
        @Autowired
        private ProfImpl profimpl;
        @Autowired
    private  CloudinaryService cloudinaryservice;
        @GetMapping("/getprof")
        public List<Prof> getProf() {
            return profimpl.getprofs();
        }
    @GetMapping("/getprof/{id}")
    public Prof getProf(@PathVariable int id) {
        return profimpl.getprof(id);
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
    @PostMapping("/setphoto")
    public void getphoto(@RequestBody Prof p) throws IOException {
        System.out.println(p);
        Prof prof = profimpl.getprof(p.getCode());
        prof.setPhotourl(p.getPhotourl());
        profimpl.updateprof(prof);
    }
    @GetMapping("/getphoto/{id}")
    public ResponseEntity<String> getphoto(@PathVariable int id) throws IOException {
        Prof prof = profimpl.getprof(id);
        String photourl = prof.getPhotourl();
        return ResponseEntity.ok().body(photourl);
    }
    }