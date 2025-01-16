package org.ensa.schoolmanagementbackend.metier;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    private Cloudinary cloudinary;

    @Value("${cloudinary.cloudName}")
    private String cloudName;

    @Value("${cloudinary.apiKey}")
    private String apiKey;

    @Value("${cloudinary.apiSecret}")
    private String apiSecret;

    // Constructor removed to allow field injection
    public CloudinaryService() {
        // Empty constructor to allow Spring to inject the values
    }

    // Initialize Cloudinary after properties are injected
    public void init() {


        Map config = new HashMap();
        config.put("cloud_name", "dn8mp0ekz");
        config.put("api_key", "328244342284616");

        config.put("api_secret", "7LEKGiX5iAEJNNit9pRQXQFVxlo");
        System.out.println(config);
        cloudinary = new Cloudinary(config);
    }

    public String uploadImage(MultipartFile file) throws IOException {
        // Ensure that Cloudinary is initialized before using it
        if (cloudinary == null) {
            init();
        }
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return (String) uploadResult.get("secure_url");  // URL sécurisé de l'image uploadée
    }
}
