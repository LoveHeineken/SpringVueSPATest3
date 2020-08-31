package com.example.SpringVueSPATest3.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.SpringVueSPATest3.entity.TestEntity
import com.example.SpringVueSPATest3.repository.TestRepository
import org.apache.ibatis.annotations.Param
import org.slf4j.LoggerFactory

@Service
class TestServiceImpl: TestService {

    @Autowired
    lateinit var testRepository: TestRepository

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun selectAll(): List<TestEntity> {
        return testRepository.selectAll()
    }

    //override fun insert(insertId: Int, insertName: String): List<TestEntity> {
    override fun insert(insertId: Int) {
        logger.info(insertId.toString())
        //logger.info("insertName = " + insertName)
        //testRepository.insert(insertId, insertName)
        testRepository.insert(insertId)
    }

    override fun edit(id: Int, testEntity: TestEntity): TestEntity {
        //testEntity.id = id
        testRepository.edit(testEntity)
        return testEntity
    }

    override fun delete(@Param("id") id: Int): List<TestEntity> {
        testRepository.delete(id)
        return testRepository.selectAll()
    }

}