package com.tcs.service.component

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.nhaarman.mockito_kotlin.whenever
import com.tcs.service.constant.URLPath.DUMMY_DATA_COLLECTION
import com.tcs.service.model.BaseModel
import com.tcs.service.repository.BaseRepository
import com.tcs.service.service.BaseService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.io.File


@SpringBootTest()
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class BaseServiceTest {

    @Autowired
    lateinit var service: BaseService

    @MockBean
    lateinit var repository: BaseRepository


    /**
     * Method for preparing stub  data from sample json
     **/
    fun getTemplateContainer(): BaseModel {
        val mapper = jacksonObjectMapper()
        mapper.registerKotlinModule()
        val jsonString: String = File(DUMMY_DATA_COLLECTION).readText(Charsets.UTF_8)
        return mapper.readValue(jsonString)
    }

    @BeforeEach
    fun setup() {
        whenever(repository.findById("101")).thenAnswer {
            getTemplateContainer()
        }

    }


    @Test
    fun getModelByIDTest() {
      //  assert(service.getBaseModelById("101").modDesc.equals("Sample"))
    }


}