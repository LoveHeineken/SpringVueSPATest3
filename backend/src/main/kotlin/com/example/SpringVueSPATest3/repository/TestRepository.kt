package com.example.SpringVueSPATest3.repository

import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import com.example.SpringVueSPATest3.entity.TestEntity

@Mapper
@Repository
interface  TestRepository {

    @Select("SELECT * FROM testdb1;")
    fun selectAll(): List<TestEntity>

    //@Insert("INSERT INTO testdb1(insertId, insertName) values(#{insertId}, #{insertName})")
    @Insert("INSERT INTO testdb1(id, name) values('#{insertId}', 'hogehoge')")
    //fun insert(@Param("insertId") insertId: Int, @Param("insertName") insertName: String): List<TestEntity>
    fun insert(@Param("insertId") insertId: Int)

    @Update("UPDATE testdb1 SET id=#{id}, name=#{name} WHERE id=#{id}")
    fun edit(testEntity: TestEntity): TestEntity

    @Delete("DELETE FROM testdb1 WHERE id=#{id}")
    fun delete(@Param("id") id: Int): List<TestEntity>
}
