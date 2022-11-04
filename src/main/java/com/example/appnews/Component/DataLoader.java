package com.example.appnews.Component;

import com.example.appnews.Entity.Permission;
import com.example.appnews.Entity.Role;
import com.example.appnews.Entity.User;
import com.example.appnews.Repository.UserRepo;
import com.example.appnews.Service.RoleRepo;
import com.example.appnews.Utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        Permission[] permissions = Permission.values();
        Role admin = roleRepo.save(new Role(
                AppConstants.ADMIN, Arrays.asList(permissions)));

        Role user = roleRepo.save(new Role(
                AppConstants.USER, Arrays.asList(
                Permission.ADD_COMMENT,
                Permission.DELETE_COMMENT_BY_USER,
                Permission.EDIT_COMMENT
        )
        ));
        userRepo.save(new User(
                "Admin",
                "admin",
                "admin123",
                admin,
                true
        ));
        userRepo.save(new User(
                "User",
                "user",
                "user123",
                user,
                true
        ));
    }
}
