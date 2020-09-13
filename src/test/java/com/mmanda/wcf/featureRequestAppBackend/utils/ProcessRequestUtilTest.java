package com.mmanda.wcf.featureRequestAppBackend.utils;

import com.mmanda.wcf.featureRequestAppBackend.model.FeatureRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(JUnit4.class)
public class ProcessRequestUtilTest {

    @Autowired
    ProcessRequestUtil processRequestUtil ;

    public ProcessRequestUtilTest(){
        processRequestUtil= new ProcessRequestUtil();
    }

    @Test
    public void preChecksTestEmptyRequest() {
        FeatureRequest featureRequest = new FeatureRequest();
        assertEquals(false,processRequestUtil.preChecks(featureRequest));

    }

    @Test
    public void preChecksTestValidRequest() {
        FeatureRequest featureRequest = new FeatureRequest();
        featureRequest.setClient("Client A");
        featureRequest.setPriority(1);
        assertEquals(true,processRequestUtil.preChecks(featureRequest));

    }

}
