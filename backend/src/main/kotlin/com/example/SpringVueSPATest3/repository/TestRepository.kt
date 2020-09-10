package com.example.SpringVueSPATest3.repository

import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import com.example.SpringVueSPATest3.entity.TestEntity

@Mapper
@Repository
interface  TestRepository {

    @Select("SELECT * FROM testdb1;")
    fun selectAll(): List<TestEntity>

    @Insert("INSERT INTO testdb1(id, name) values(#{insertId}, #{insertName})")
    fun insert(insertId: Int, insertName: String): Nothing = throw Exception()

    @Update("UPDATE testdb1 SET id=#{updateId}, name=#{updateName} WHERE id=#{updateId}")
    fun update(updateId: Int, updateName: String): Nothing = throw Exception()

    @Delete("DELETE FROM testdb1 WHERE id=#{deleteId}")
    fun delete(deleteId: Int): Nothing = throw Exception()
}
