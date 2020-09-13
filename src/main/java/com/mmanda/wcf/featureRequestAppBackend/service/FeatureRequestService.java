package com.mmanda.wcf.featureRequestAppBackend.service;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import com.mmanda.wcf.featureRequestAppBackend.model.FeatureRequest;

import java.util.List;

public interface FeatureRequestService {

    FeatureRequestEntity save(FeatureRequest request);
    void delete(Integer id);
}
