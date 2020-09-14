package com.mmanda.wcf.featureRequestAppBackend.service;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import com.mmanda.wcf.featureRequestAppBackend.model.FeatureRequest;
import com.mmanda.wcf.featureRequestAppBackend.repository.FeatureRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.mmanda.wcf.featureRequestAppBackend.constants.ConstantsDeclarations.NEW_FEATURE_REQUEST_COMPLETE;

@Component
public class FeatureRequestServiceImpl implements FeatureRequestService {


    private final Logger logger = LoggerFactory.getLogger(FeatureRequestServiceImpl.class);

    @Autowired
    FeatureRequestRepository featureRequestRepository;

    @Override
    public FeatureRequestEntity save(FeatureRequest request) {
        List<FeatureRequestEntity> list = getAllRecordsForClient(request.getClient());

        FeatureRequestEntity returnVal = null;

        int count=0,index=-1;

        for(FeatureRequestEntity fe:list) {

            if(fe.getPriority()==request.getPriority()) {
                index=count;
                break;
            }
            count++;

        }


        if(index < 0) {

            returnVal = featureRequestRepository.save(convertToEntity(request));
        }
        else {
            List<FeatureRequestEntity> rearrange = new ArrayList<>();
            int previousVal = request.getPriority();

            for(;index < list.size(); index++) {

                int priority = list.get(index).getPriority();
                if(previousVal == priority) {
                    previousVal = priority+1;
                    FeatureRequestEntity f = list.get(index);
                    f.setPriority(previousVal);
                    rearrange.add(f);
                }
                else {
                    break;
                }
            }
            featureRequestRepository.saveAll(rearrange);
            returnVal = featureRequestRepository.save(convertToEntity(request));

        }

        logger.info(NEW_FEATURE_REQUEST_COMPLETE);
        return returnVal;
    }


    @Override
    public void delete(Integer id) {

    }

    public List<FeatureRequestEntity> getAllRecordsForClient(String clientId){
        return featureRequestRepository.findByClientId(clientId.toLowerCase());
    }

    private FeatureRequestEntity convertToEntity(FeatureRequest request) {
        return new FeatureRequestEntity(null,
                request.getPriority(),
                request.getTitle(),
                request.getDescription(),
                request.getClient().toLowerCase(),
                request.getTargetDate(),
                request.getProductArea());
    }

}
