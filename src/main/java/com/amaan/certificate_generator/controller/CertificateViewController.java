package com.amaan.certificate_generator.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CertificateViewController {

    // ✅ Generate using name, role, event
    @GetMapping("/certificate")
    public String showCertificate(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String event,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("role", role);
        model.addAttribute("event", event);

        return "certificate";
    }

    // ✅ Download using ID (REAL DATA 🔥)
    @GetMapping("/certificate/{id}")
    public String downloadCertificate(@PathVariable String id, Model model) {

        // 👉 stored data fetch
        Map<String, String> data = CertificateController.dataStore.get(id);

        if (data != null) {
            model.addAttribute("name", data.get("candidateName"));
            model.addAttribute("role", data.get("role"));
            model.addAttribute("event", data.get("eventName"));
        } else {
            model.addAttribute("name", "Not Found");
            model.addAttribute("role", "N/A");
            model.addAttribute("event", "N/A");
        }

        return "certificate";
    }
}