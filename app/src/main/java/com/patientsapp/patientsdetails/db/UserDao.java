package com.patientsapp.patientsdetails.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM tableName")
    List<User> getAll();

    @Insert
    void insert(User user);

}
