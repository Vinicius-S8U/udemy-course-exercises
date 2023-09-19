package com.example.contacts_manager.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDAO {
    @Insert
    fun insertUser(user: User): Void

    @Update
    fun updateUser(user: User): Void

    @Delete
    fun deleteUser(user: User): Void

    @Query("Delete from User")
    fun deleteAll(): Void

    @Query("Select * from User")
    fun getAllUsers(): LiveData<List<User>>
}