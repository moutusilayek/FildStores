/*
package com.ah.service.contract;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ah.service.controller.BaseController;
//import com.ah.service.controller.BaseController;
//import com.ah.service.model.BaseModel;
//import com.ah.service.repository.BaseRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.io.File;

//import static com.ah.service.constant.URLPath.SAMPLE_CONTRACT_JSON_PATH;
import static org.mockito.Mockito.doReturn;

*/
/**
 * This class is for setup Contract Testing.
 * The contract is mentioned in the groovy script inside test/resources/contracts
 *//*

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class Provider {

    @Autowired
   // private BaseController baseController;
    @MockBean
   // private BaseRepository repository;

    @BeforeEach
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(baseController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    */
/**
     * Method for preparing stub  data from sample json
     **//*


    private BaseModel getBaseModel() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(SAMPLE_CONTRACT_JSON_PATH);
        BaseModel value = mapper.readValue(file, BaseModel.class);
        return value;
    }

    @BeforeEach
    public void repositorySetup() throws Exception {

        doReturn(getBaseModel()).when(repository).findByModId("101");

    }
}
*/
