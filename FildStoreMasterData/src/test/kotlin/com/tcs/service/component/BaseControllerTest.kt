package com.tcs.service.component

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.nhaarman.mockito_kotlin.whenever
import com.tcs.service.constant.URLPath.BASE_PATH
import com.tcs.service.constant.URLPath.GET_MODEL_BY_ID_URI
import com.tcs.service.constant.URLPath.SAMPLE_DATA_JSON_PATH
import com.tcs.service.constant.URLPath.SAMPLE_RESPONSE_JSON_PATH
import com.tcs.service.model.BaseModel
import com.tcs.service.service.BaseService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.get


import java.io.File

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class BaseControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: BaseService


    /**
     * Method for preparing stub  data from sample json
     **/
    fun getBaseModel(): BaseModel {
        val mapper = jacksonObjectMapper()
        mapper.registerKotlinModule()
        val jsonString: String = File(SAMPLE_DATA_JSON_PATH).readText(Charsets.UTF_8)
        val value: BaseModel = mapper.readValue<BaseModel>(jsonString)
        return value
    }

    /**
     * Preparing Mock Stub For service class
     **/
    @BeforeEach
    fun setup() {
        whenever(service.getBaseModelById(id = "101")).thenAnswer { getBaseModel() }
    }

    /**
     * Test Method  for Controller Get Endpoint
     * Service call is mocked
     **/
    @Test
    fun getBaseModelTest() {
        var expected = File(SAMPLE_RESPONSE_JSON_PATH).readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.get(BASE_PATH + GET_MODEL_BY_ID_URI, "101")
                {
                    contentType = MediaType.APPLICATION_JSON
                }.andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false)
    }

}