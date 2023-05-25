package com.athtech.android.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void save(UserTable userTable);

//    @Insert
//    void insert(UserTable userTable) throws Exception;
//
//    @Update
//    void update(UserTable userTable) throws Exception;

    @Delete
    void delete(UserTable userTable);

    @Query("SELECT * FROM UserTable")
    @NonNull
    List<UserTable> retrieve();

    @Query("SELECT * FROM UserTable LIMIT 1")
    @Nullable
    UserTable retrieveOneItem();

    @Query("SELECT * FROM UserTable WHERE full_name LIKE :name LIMIT 1")
    UserTable retrieveOneItem(String name);
}
