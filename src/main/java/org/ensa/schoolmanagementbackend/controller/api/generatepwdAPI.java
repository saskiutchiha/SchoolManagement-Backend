package org.ensa.schoolmanagementbackend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.passay.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class generatepwdAPI {
    @GetMapping("/generatepwd")
    public ResponseEntity<Map<String,String>>  eneratepwd() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        CharacterRule lowerCaseRule = new CharacterRule(EnglishCharacterData.LowerCase, 2); // Min. 2 lettres minuscules
        CharacterRule upperCaseRule = new CharacterRule(EnglishCharacterData.UpperCase, 2); // Min. 2 lettres majuscules
        CharacterRule digitRule = new CharacterRule(EnglishCharacterData.Digit, 2);         // Min. 2 chiffres
        CharacterRule specialCharRule = new CharacterRule(EnglishCharacterData.Special, 2); // Min. 2 caractères spéciaux
        List lvalidators = new ArrayList();
        lvalidators.add(lowerCaseRule);
        lvalidators.add(upperCaseRule);
        lvalidators.add(digitRule);
        lvalidators.add(specialCharRule);
        Map<String, String> response = new HashMap<>();

        String password = passwordGenerator.generatePassword(12, lvalidators);
        response.put("password", password);
        System.out.println("Mot de passe généré : " + password);
        return ResponseEntity.ok(response);


    }

}
