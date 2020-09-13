package com.mmanda.wcf.featureRequestAppBackend.service;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import com.mmanda.wcf.featureRequestAppBackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class ClientService {

    @Autowired
    ClientRepository cRepo;


    public List<FeatureRequestEntity> getAllClients(){
        List<FeatureRequestEntity> returnVal = new ArrayList<>();
        List<FeatureRequestEntity> list = cRepo.findAll();
        System.out.println("Size: "+list.size());
        for(FeatureRequestEntity c : list) {
            returnVal.add(convertToClients(c));
        }

        List<FeatureRequestEntity> response = returnVal;

        if(response!=null) {
            Collections.sort(response, new Comparator<FeatureRequestEntity>() {
                @Override
                public int compare(FeatureRequestEntity o1, FeatureRequestEntity o2) {

                    return o1.getClient().compareTo(o2.getClient()) ;

                }
            });

        }

        return response;
    }

    private FeatureRequestEntity convertToClients(FeatureRequestEntity entity) {
        return new FeatureRequestEntity(entity.getId(), entity.getPriority(),entity.getTitle(),entity.getDescription(),entity.getClient(),entity.getTargetDate(),entity.getProductArea());
    }
}
