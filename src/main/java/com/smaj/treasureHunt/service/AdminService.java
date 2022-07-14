package com.smaj.treasureHunt.service;

import com.smaj.treasureHunt.model.Admin;
import com.smaj.treasureHunt.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.Long.valueOf;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminService(@Autowired AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public boolean isAdmin(String password){
        Admin admin = adminRepository.findById(valueOf(10)).get();
        if (password == admin.getPassword()){
            return true;
        } else {
            return false;
        }

    }
}
