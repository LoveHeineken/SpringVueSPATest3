package com.example.SpringVueSPATest3.controller

import com.example.SpringVueSPATest3.entity.TestEntity
import com.example.SpringVueSPATest3.service.TestService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*
import javax.servlet.Filter


@RestController
class TestController {

    @Autowired
    lateinit var testService: TestService

    private val logger = LoggerFactory.getLogger(javaClass)

    // ハローワールド
    @GetMapping("/helloworld")
    fun greet(): String {
        return "helloworld!"
    }

    // 全件取得
    @GetMapping("/select_all")
    fun select_all(): ResponseEntity<List<TestEntity>> {
        return ResponseEntity.ok().body(testService.selectAll())
    }

    //@PostMapping("/insert")
    @PostMapping("/insert/{insertId}")
    //fun insert(@PathVariable("insertId") insertId: Int, @PathVariable("insertName") insertName: String): List<TestEntity> {
    fun insert(@PathVariable("insertId") insertId: Int) {
        logger.info("insertId = " + insertId)
        //logger.info("insertName = " + insertName)
        //return testService.insert(insertId, insertName)
        return testService.insert(insertId)
    }

    // 1件編集
    @PutMapping("/edit")
    fun edit(@PathVariable("id") id: Int, @RequestBody testEntity: TestEntity): TestEntity {
        return testService.edit(id, testEntity)
    }

    // 1件削除
    @DeleteMapping("/delete")
    fun delete(@PathVariable("id") id: Int): List<TestEntity> {
        return testService.delete(id)
    }

    @Bean
    fun simpleCorsFilter(): FilterRegistrationBean<*> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        // *** 下記のURLはVueクライアントURLとポートに一致させる必要がある***
        config.allowedOrigins = Collections.singletonList("http://localhost:8080")
        config.allowedMethods = Collections.singletonList("*")
        config.allowedHeaders = Collections.singletonList("*")
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean<Filter>(CorsFilter(source))
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE)
        return bean
    }
}