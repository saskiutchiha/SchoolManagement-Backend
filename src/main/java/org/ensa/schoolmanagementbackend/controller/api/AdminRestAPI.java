package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.entity.Admin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/admin")
public class AdminRestAPI {

    @GetMapping("/getadmins")
    public List<Admin> getAdmin(){

    }
}
