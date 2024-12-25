package org.ensa.schoolmanagementbackend;

//import entity.Logininfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class loginAPI {
    @PostMapping("/logininfo")
    public ResponseEntity<Map<String,String>> student(@RequestBody Logininfo logininfo) {
        Map<String, String> response = new HashMap<>();
        if (logininfo.login.equals("testuser") && logininfo.password.equals("testuser")) {

            response.put("message", "good");

            return ResponseEntity.ok(response);
        }
        response.put("message", "baaad");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
}
