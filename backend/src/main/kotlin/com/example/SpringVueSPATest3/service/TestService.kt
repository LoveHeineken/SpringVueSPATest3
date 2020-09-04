package com.example.SpringVueSPATest3.service

import com.example.SpringVueSPATest3.entity.TestEntity

interface TestService {

    fun selectAll(): List<TestEntity>

    fun insert(insertId: Int, insertName: String)

    fun update(updateId: Int, updateName: String)

    fun delete(deleteId: Int)
}
