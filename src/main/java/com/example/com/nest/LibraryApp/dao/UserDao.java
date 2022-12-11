package com.example.com.nest.LibraryApp.dao;

import com.example.com.nest.LibraryApp.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {
    @Query(value = "SELECT * FROM `user` WHERE `username`= :username", nativeQuery = true)
    List<UserModel> FindUserLogin(@Param("username") String username);

    @Query(value = "SELECT * FROM `user` WHERE `username`= :username AND `password`= :password", nativeQuery = true)
    List<UserModel> GetLoginCreds(@Param("username") String username,@Param("password") String password);
}