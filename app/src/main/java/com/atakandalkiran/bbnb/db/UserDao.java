package com.atakandalkiran.bbnb.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.OnConflictStrategy;
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

    @Insert
    void InsertCardInformations(CardDetailsModel cardDetails);

    @Query("SELECT * FROM carddetailsmodel")
    List<CardDetailsModel> getAllCardInformations();

    @Delete
    void DeleteCardInformations(CardDetailsModel cardDetails);

    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);

    @Query("SELECT * FROM user WHERE citizenship_no = :citizenshipNo AND password = :password")
    User getUserLoginInformations(String citizenshipNo, String password);

    @Query("UPDATE user SET password = :newPassword WHERE email = :email")
    void updatePassword(String email, String newPassword);

}
