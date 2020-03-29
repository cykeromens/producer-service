package com.ps.producerservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


public class ContractVerifierBase {

    @Before
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(new LicenceCheckController(new LicenceCheckService()));
    }

    public void assertThatRejectionReasonIsNull(String reason){
        assertNull(reason);
    }

    public void assertThatRejectionReasonIsNotNull(String reason){
        assertThat(reason, is("Licence is invalid"));
    }

    public void assertLicenceInactive(String inactive){
        assertThat(inactive, is("INACTIVE"));
    }
}
