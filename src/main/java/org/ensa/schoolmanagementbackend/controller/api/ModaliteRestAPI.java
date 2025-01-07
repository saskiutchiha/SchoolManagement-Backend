package org.ensa.schoolmanagementbackend.controller.api;

import org.ensa.schoolmanagementbackend.dao.entity.MEvaluation;
import org.ensa.schoolmanagementbackend.metier.ModaliteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modalite")
@CrossOrigin(origins = "http://localhost:5173")
public class ModaliteRestAPI {

    @Autowired
    private ModaliteMetier modaliteMetier;

    @GetMapping("/getmodalites")
    public List<MEvaluation> getModalites() {
        return modaliteMetier.getModalites();
    }

    @PostMapping("/addmodalite")
    public void addModalite(@RequestBody MEvaluation modalite) {
        modaliteMetier.addModalite(modalite);
    }

    @PutMapping("/modifymodalite")
    public void modifyModalite(@RequestBody MEvaluation modalite) {
        modaliteMetier.modifyModalite(modalite);
    }

    @DeleteMapping("/deletemodalite/{id}")
    public void deleteModalite(@PathVariable Long id) {
        modaliteMetier.deleteModalite(id);
    }
}