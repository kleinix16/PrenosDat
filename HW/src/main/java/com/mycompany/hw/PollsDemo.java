/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author klein
 */
public class PollsDemo {

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-e342f-tomaskleinprenosdat.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PollsService polls = retrofit.create(PollsService.class);
        
        //GET - LIST USERS
        try {
            System.out.print( "GET - LIST USERS - getAllUsers()\n");
            Response<List<UsersList>> execute = polls.getAllUsers().execute();
            Logger.getGlobal().log(Level.INFO, execute.toString());
            if (execute.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, execute.body().toString());
                Logger.getGlobal().log(Level.INFO, "getSingleUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "getSingleUser() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        //GET - SINGLE USER
        try {
            System.out.print( "GET - SINGLE USER - getSingleUser()\n");
            Response<UserData> execute = polls.getSingleUser().execute();
            Logger.getGlobal().log(Level.INFO, execute.toString());
            if (execute.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, execute.body().toString());
                Logger.getGlobal().log(Level.INFO, "getSingleUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "getSingleUser() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        
        //GET - SINGLE USER - NOT FOUND
        try {
            System.out.print("GET - SINGLE USER - NOT FOUND - getFakeUser()\n");
            Response<UserWithAvatar> execute = polls.getFakeUser().execute();
            Logger.getGlobal().log(Level.INFO, execute.toString());
            if (!execute.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, "getFakeUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "getFakeUser() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        
        //GET - LIST <RESOURCE>
        try {
            System.out.print( "GET <RESOURCE> - getAllUnknown()\n");
            Response<UnknownList> execute = polls.getAllUnknown().execute();
            Logger.getGlobal().log(Level.INFO, execute.toString());
            if (execute.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, execute.body().toString());
                Logger.getGlobal().log(Level.INFO, "getAllUnknown() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "getAllUnknown() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        
        //GET - SINGLE <RESOURCE>
        try {
            System.out.print( "GET - SINGLE <RESOURCE> - getSingleUnknown()\n");
            Response<UnknownData> execute = polls.getSingleUnknown().execute();
            Logger.getGlobal().log(Level.INFO, execute.toString());
            if (execute.isSuccessful()) {
                Logger.getGlobal().log(Level.INFO, execute.body().toString());
                Logger.getGlobal().log(Level.INFO, "getSingleUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "getSingleUnknown() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        
        //GET - SINGLE <RESOURCE> - NOT FOUND
       try {
            System.out.print("GET - SINGLE <RESOURCE> - NOT FOUND - getFakeUnknown()\n");
            Response<Unknown> execute = polls.getFakeUnknown().execute();
            Logger.getGlobal().log(Level.INFO, execute.toString());
            if (!execute.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, "getFakeUnknown() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "getFakeUnknown() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        
        //POST - CREATE USER
        System.out.print("POST - CREAT USER - creatUser()\n");
        User userA = new User();
        userA.name = "morpheus";
        userA.job = "leader";
        
        try {
            Response<User> recievedUser = polls.creatUser(userA).execute();
            Logger.getGlobal().log(Level.INFO, recievedUser.toString());
            if (recievedUser.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, recievedUser.body().toString());
                Logger.getGlobal().log(Level.INFO, "creatUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "creatUser() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        
        //PUT and PATCH - UPDATE
        User userB = new User();
        userB.name = "morpheus";
        userB.job = "zion resident";
        //PUT
        System.out.print("PUT - UPDATE USER - updatePutUser()\n");
         try {
            Response<User> recievedUser = polls.updatePutUser(userB).execute();
            Logger.getGlobal().log(Level.INFO, recievedUser.toString());
            if (recievedUser.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, recievedUser.body().toString());
                Logger.getGlobal().log(Level.INFO, "updatePutUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "updatePutUser() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        //PATCH
        System.out.print("PATCH - UPDATE USER - updatePatchUser()\n");
        try {
            Response<User> recievedUser = polls.updatePatchUser(userB).execute();
            Logger.getGlobal().log(Level.INFO, recievedUser.toString());
            if (recievedUser.isSuccessful()) { 
                Logger.getGlobal().log(Level.INFO, recievedUser.body().toString());
                Logger.getGlobal().log(Level.INFO, "updatePatchUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "updatePatchUser() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("------------------------------------------------------------------\n\r");
        
        
        //DELETE - DELETE USER
        try {
            System.out.print("DELETE - DELETE USER - deleteUser()\n");
            Response<User> execute = polls.deleteUser().execute();
            Logger.getGlobal().log(Level.INFO, execute.toString());
            if (execute.isSuccessful()) {
                Logger.getGlobal().log(Level.INFO, "deleteUser() - SUCCESSFULL");
            }else 
               Logger.getGlobal().log(Level.INFO, "deleteUser() - FAILED");
        } catch (IOException ex) {
            Logger.getLogger(PollsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
