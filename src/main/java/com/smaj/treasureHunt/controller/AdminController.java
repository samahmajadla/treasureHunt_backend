package com.smaj.treasureHunt.controller;

import com.smaj.treasureHunt.model.Admin;
import com.smaj.treasureHunt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    public AdminController(@Autowired AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/createAdmin")
    public ResponseEntity createAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok(adminService.addAdmin(admin));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String password){
        boolean isAdmin =  adminService.isAdmin(password);
        if (isAdmin) {
            return ResponseEntity.ok().build();
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

}
