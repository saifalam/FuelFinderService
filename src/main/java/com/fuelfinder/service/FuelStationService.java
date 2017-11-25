package com.fuelfinder.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelfinder.model.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by saif on 22.11.17.
 */
@Service
public class FuelStationService <T extends BaseResponse> {

    private static final Logger log = LoggerFactory.getLogger(FuelStationService.class);

    @Value("${service.ok}")
    private String ok;

    @Value("${service.status}")
    private String status;

    @Value("${service.message.error}")
    private String errorMessage;



    // Generic class for all get requests
    public T getServiceModel(URI url, Class<T> type) {
        ResponseEntity<T> response = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.exchange(url, HttpMethod.GET, entity, type);

            if(response.getStatusCode() == HttpStatus.OK) {
                 //TODO: Need to modify response according to the demand
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            printResponse(response);
        }
        return response.getBody();

    }

    // Generic class for logging any response
    private void printResponse(ResponseEntity<T> response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(response);
            log.info(jsonInString);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
