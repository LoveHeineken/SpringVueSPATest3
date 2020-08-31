package com.example.SpringVueSPATest3.service

import com.example.SpringVueSPATest3.entity.TestEntity

interface TestService {

    fun selectAll(): List<TestEntity>

    //fun insert(insertId: Int, insertName: String): List<TestEntity>
    fun insert(insertId: Int)

    fun edit(id: Int, testEntity: TestEntity): TestEntity

    fun delete(id: Int): List<TestEntity>
}
