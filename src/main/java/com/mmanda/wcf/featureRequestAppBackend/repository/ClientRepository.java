package com.mmanda.wcf.featureRequestAppBackend.repository;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ClientRepository extends CrudRepository<FeatureRequestEntity, Integer> {

    @Query(value = "Select * from feature_request_entity order by id", nativeQuery = true)
    public List<FeatureRequestEntity> findAll();


}

