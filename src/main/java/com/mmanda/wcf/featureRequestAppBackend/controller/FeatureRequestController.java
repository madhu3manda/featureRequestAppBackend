package com.mmanda.wcf.featureRequestAppBackend.controller;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import com.mmanda.wcf.featureRequestAppBackend.model.FailureResponse;
import com.mmanda.wcf.featureRequestAppBackend.model.FeatureRequest;
import com.mmanda.wcf.featureRequestAppBackend.service.ClientService;
import com.mmanda.wcf.featureRequestAppBackend.service.FeatureRequestServiceImpl;
import com.mmanda.wcf.featureRequestAppBackend.utils.ProcessRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mmanda.wcf.featureRequestAppBackend.constants.ConstantsDeclarations.BASE_PATH;
import static com.mmanda.wcf.featureRequestAppBackend.constants.ConstantsDeclarations.NEW_REQUEST;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value=BASE_PATH, consumes="application/json")
public class FeatureRequestController {

    @Autowired
    ClientService cServ;

    @Autowired
    ProcessRequestUtil processRequestUtil;

    @Autowired
    FeatureRequestServiceImpl fetureRequestService;

    @PutMapping(value=NEW_REQUEST)
    public @ResponseBody Object newFeature(@RequestBody FeatureRequest featureRequest){

        if(processRequestUtil.preChecks(featureRequest)) {
            return fetureRequestService.save(featureRequest);
        } else {
            return new FailureResponse(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("getAllClients")
    public List<FeatureRequestEntity> getAllClients() {
        return cServ.getAllClients();
    }

    @GetMapping("getByClient")
    public @ResponseBody Object getByClient(@RequestParam("client") String client) {
        List<FeatureRequestEntity> response= fetureRequestService.getAllRecordsForClient(client.toLowerCase());

        if(response!=null) return response;

        return new FailureResponse(HttpStatus.NO_CONTENT);
    }

}
