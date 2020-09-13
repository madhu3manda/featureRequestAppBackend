package com.mmanda.wcf.featureRequestAppBackend.utils;

import com.mmanda.wcf.featureRequestAppBackend.model.FeatureRequest;
import org.springframework.stereotype.Service;

@Service
public class ProcessRequestUtil {


    public boolean preChecks(FeatureRequest featureRequest) {

        return featureRequest!=null && featureRequest.getClient()!=null;
    }
}
