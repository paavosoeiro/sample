package com.sample.sampleclient.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.sample.sampleclient.model.Sample;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 8080)
public class SampleClientControllerTest {

    @Autowired
    private SampleClientController controller;

    @Test
    void testGetAll() {
        // WireMock.stubFor(WireMock.get("/sample").willReturn(WireMock.aResponse().withStatus(200).withBody("""
        //     [
        //         {
        //             "id": 1,
        //             "name": "Sample"
        //         }
        //     ]
        // """)));

        var all = controller.getAll();
    }

    @Test
    void testPost() {
        var sample = new Sample();
        sample.setName("Buiu");
        controller.addSample(sample);

    }
}
