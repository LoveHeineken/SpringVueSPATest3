package com.example.SpringVueSPATest3.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.example.SpringVueSPATest3.entity.TestEntity
import com.example.SpringVueSPATest3.repository.TestRepository
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
        runCatching { testRepository.insert(insertId, insertName) }
                .onFailure { it.printStackTrace() }
                .onSuccess { println("Success") }
    }

    override fun update(updateId: Int, updateName: String) {
        runCatching { testRepository.update(updateId, updateName) }
                .onFailure { it.printStackTrace() }
                .onSuccess { println("Success") }
    }

    override fun delete(deleteId: Int) {
        runCatching { testRepository.delete(deleteId) }
                .onFailure { it.printStackTrace() }
                .onSuccess { println("Success") }
    }

}