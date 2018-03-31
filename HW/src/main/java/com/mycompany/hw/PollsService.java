/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 *
 * @author klein
 */
public interface PollsService {
    @GET("/api/users?page=2")
    Call<List<UsersList>> getAllUsers();
    
    @GET("/api/users/2")
    Call<UserData> getSingleUser();
    
    @GET("/api/users/23")
    Call<UserWithAvatar> getFakeUser();
    
    @GET("/api/unknown")
    Call<UnknownList> getAllUnknown();
    
    @GET("/api/unknown/2")
    Call<UnknownData> getSingleUnknown();
    
    @GET("/api/unknown/23")
    Call<Unknown> getFakeUnknown();
    
    @POST("/api/user")
    Call<User> creatUser(@Body User user);
    
    @PUT("/api/users/2")
    Call<User> updatePutUser(@Body User user);
    
    @PATCH("/api/users/2")
    Call<User> updatePatchUser(@Body User user);
    
    @DELETE("/api/users/2")
    Call<User> deleteUser();
}
