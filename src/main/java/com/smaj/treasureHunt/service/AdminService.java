package com.smaj.treasureHunt.service;

import com.smaj.treasureHunt.model.Admin;
import com.smaj.treasureHunt.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }
}
