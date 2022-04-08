package com.example.practical.service;

import com.example.practical.dto.ResponseFunction;
import com.example.practical.dto.ResponseLogin;
import com.example.practical.entity.Account;
import com.example.practical.entity.Function;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountService {
    @POST("/Account/Login")
    Call<ResponseLogin> login(@Body Account account);

    @GET("/Function/GetFunctionList")
    Call<ResponseFunction> getListFunction();
}
