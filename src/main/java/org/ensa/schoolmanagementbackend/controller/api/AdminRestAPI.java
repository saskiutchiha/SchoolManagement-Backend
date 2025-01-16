package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.dto.LoginResponse;
import org.ensa.schoolmanagementbackend.dao.entity.Admin;
import org.ensa.schoolmanagementbackend.metier.AdminMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminRestAPI {

    @Autowired
    private AdminMetierImpl adminMetier;

    @GetMapping("/getadmins")
    public List<Admin> getAdmins(){
        return adminMetier.getAdmins();
    }

    @PostMapping("/addadmin")
    public void addAdmin(@RequestBody Admin admin){
        adminMetier.addAdmin(admin);
    }

    @PutMapping("/updateadmin")
    public void updateAdmin(@RequestBody Admin admin){
        adminMetier.updateAdmin(admin);
    }

    @DeleteMapping("deleteadmin")
    @CrossOrigin(origins = "http://localhost:5173")
    public void deleteAdmin(@RequestBody Admin admin){
        adminMetier.deleteAdmin(admin);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginAdmin(@RequestBody Admin admin) {
        boolean isValid = adminMetier.verifyAdmin(admin);

        if (isValid) {
            LoginResponse response = new LoginResponse("Login successful", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            LoginResponse response = new LoginResponse("Invalid credentials", false);
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

    }}
