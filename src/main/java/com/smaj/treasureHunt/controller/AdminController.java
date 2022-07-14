package com.smaj.treasureHunt.controller;

import com.smaj.treasureHunt.model.Admin;
import com.smaj.treasureHunt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/createAdmin")
    public ResponseEntity createAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok(adminService.addAdmin(admin));
    }
}
