package com.mmanda.wcf.featureRequestAppBackend.service;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import com.mmanda.wcf.featureRequestAppBackend.model.FeatureRequest;
import com.mmanda.wcf.featureRequestAppBackend.repository.FeatureRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class FeatureRequestServiceImpl implements FeatureRequestService {


    @Autowired
    FeatureRequestRepository featureRequestRepository;

    @Override
    public FeatureRequestEntity save(FeatureRequest request) {
        List<FeatureRequestEntity> list = getAllRecordsForClient(request.getClient());

        FeatureRequestEntity returnVal = null;


        int index = Collections.binarySearch(list, request.getPriority(), new Comparator<Comparable<? extends Serializable>>() {
            @Override
            public int compare(Comparable<? extends Serializable> o1, Comparable<? extends Serializable> o2) {
                return 0;
            }
        });

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
