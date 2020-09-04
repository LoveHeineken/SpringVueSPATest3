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

    override fun insert(insertId: Int, insertName: String) {
        testRepository.insert(insertId, insertName)
    }

    override fun update(updateId: Int, updateName: String) {
        testRepository.update(updateId, updateName)
    }

    override fun delete(deleteId: Int) {
        testRepository.delete(deleteId)
    }

}