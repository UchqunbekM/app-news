package com.example.appnews.Service;

import com.example.appnews.ApiResponce.ApiResponse;
import com.example.appnews.Dto.RegisterDto;
import com.example.appnews.Entity.User;
import com.example.appnews.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;
    public ApiResponse registerUser(@RequestBody  RegisterDto registerDto) {
        boolean b = userRepo.existsByUsername(registerDto.getUsername());
        if (b) {
            return new ApiResponse(false,"user already exist");
        }
//        User user=new User(
//                registerDto.getFullName(),
//                registerDto.getUsername(),
//                registerDto.getPassword()
//
//        );

        return new ApiResponse(true,"Successfully");
    }
}
