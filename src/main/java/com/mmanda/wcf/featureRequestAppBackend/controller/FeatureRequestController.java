package com.mmanda.wcf.featureRequestAppBackend.controller;

import com.mmanda.wcf.featureRequestAppBackend.entity.FeatureRequestEntity;
import com.mmanda.wcf.featureRequestAppBackend.model.FailureResponse;
import com.mmanda.wcf.featureRequestAppBackend.model.FeatureRequest;
import com.mmanda.wcf.featureRequestAppBackend.service.ClientService;
import com.mmanda.wcf.featureRequestAppBackend.service.FeatureRequestServiceImpl;
import com.mmanda.wcf.featureRequestAppBackend.utils.ProcessRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.mmanda.wcf.featureRequestAppBackend.constants.ConstantsDeclarations.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value=BASE_PATH, consumes=APP_JSON)
public class FeatureRequestController {

    private final Logger logger = LoggerFactory.getLogger(FeatureRequestController.class);

    @Autowired
    ClientService cServ;

    @Autowired
    ProcessRequestUtil processRequestUtil;

    @Autowired
    FeatureRequestServiceImpl fetureRequestService;

    @PutMapping(value=NEW_REQUEST)
    public @ResponseBody Object newFeature(@RequestBody FeatureRequest featureRequest) {

        if(processRequestUtil.preChecks(featureRequest)) {

            logger.info(NEW_FEATURE_REQUEST_START);
            logger.debug("FeatureRequest {}",featureRequest);
            return fetureRequestService.save(featureRequest);

        } else {

            logger.error(NEW_FEATURE_REQUEST_ERROR);
            return new FailureResponse(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(GET_ALL_CLIENTS_REQUESTS)
    public List<FeatureRequestEntity> getAllClients() {

        return cServ.getAllClients();
    }

    @GetMapping(GET_BY_CLIENT)
    public @ResponseBody Object getByClient(@RequestParam("client") String client) {

        List<FeatureRequestEntity> response = new ArrayList<>();

        if(client!=null) {

            response = fetureRequestService.getAllRecordsForClient(client.toLowerCase());

        }

        if(response!=null)  {

            return response;
        } else {
            return new FailureResponse(HttpStatus.NO_CONTENT);
        }


    }

}
