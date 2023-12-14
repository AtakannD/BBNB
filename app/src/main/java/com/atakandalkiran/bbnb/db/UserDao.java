package com.atakandalkiran.bbnb.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Insert;



import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM  user")
    List<User> getAllUsers();

    @Insert
    void InsertUser(User users);

    @Delete
    void DeleteUser(User user);
}
