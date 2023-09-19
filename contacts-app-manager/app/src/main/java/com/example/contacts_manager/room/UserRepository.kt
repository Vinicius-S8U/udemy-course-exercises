package com.example.contacts_manager.room

class UserRepository(private val dao: UserDAO) {

    val users = dao.getAllUsers()

    fun insert(user: User): Void = dao.insertUser(user)

    fun delete(user: User): Void = dao.deleteUser(user)

    fun deleteAll():Void = dao.deleteAll()

    fun update(user: User): Void = dao.updateUser(user)
}