package com.mmanda.wcf.featureRequestAppBackend.repository;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeatureRequestRepository  extends CrudRepository<FeatureRequestEntity,Integer> {

    @Query(value="Select * from feature_request_entity order by id", nativeQuery = true)
    public List<FeatureRequestEntity> findAll();

    @Override
    <S extends FeatureRequestEntity> S save(S s);

    @Query(value="Select * from feature_request_entity where client = ?1 order by priority", nativeQuery = true)
    public List<FeatureRequestEntity> findByClientId(String clientId);
}
