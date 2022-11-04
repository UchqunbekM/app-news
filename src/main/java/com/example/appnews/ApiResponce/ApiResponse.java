package com.example.appnews.ApiResponce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private  boolean success;
    private String messege;

}
