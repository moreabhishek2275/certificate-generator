package com.amaan.certificate_generator.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/certificates")
public class CertificateController {

    // 🔥 STORE DATA
    public static Map<String, Map<String, String>> dataStore = new HashMap<>();

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> data) {

        String id = UUID.randomUUID().toString();

        data.put("id", id);

        dataStore.put(id, data); // ✅ store data

        return data;
    }

    @GetMapping("/{id}")
    public Map<String, String> getById(@PathVariable String id) {
        return dataStore.get(id);
    }
}