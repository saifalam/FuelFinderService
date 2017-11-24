package com.fuelfinder.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelfinder.model.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by saif on 22.11.17.
 */
@Service
public class FuelStationService <T extends BaseResponse> {

    private static final Logger log = LoggerFactory.getLogger(FuelStationService.class);

    @Value("${service.base.url}")
    private String baseUrl;

    @Value("${service.ok}")
    private String ok;

    @Value("${service.status}")
    private String status;

    @Value("${service.message}")
    private String message;

    @Value("${service.request.type}")
    private String reqParamType;

    @Value("${service.request.sort}")
    private String reqParamSort;


    public T getServiceModel(String url, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();

        T response = null;

        try {
            response = restTemplate.getForObject(url, type);

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            printResponse(response);
        }
        return response;

    }

    private void printResponse(T response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(response);
            log.info(jsonInString);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

/*    public SearchResponse getAllFuelStations (AllStationRequest requestModel) {
        SearchResponse response = null;

        if(requestModel != null && !requestModel.getApiKey().equals("")) {

            // If type = all is always sorted by distance - the specification of the sorting is then optional
            String mainUrl = baseUrl+"list.php"+"?lat="+ requestModel.getLatitude() +"&lng="+
                    requestModel.getLongitude() +"&rad="+ requestModel.getRadius() +"&sort="+
                    (requestModel.getType().equals("all") ? reqParamSort: requestModel.getSort())
                    +"&type="+ requestModel.getType() +"&apikey="+ requestModel.getApiKey();

            RestTemplate template = new RestTemplate();

            try {
                response = template.getForObject(mainUrl, SearchResponse.class);

                if(!response.getOk().equals("true")) {
                    response.setOk(ok);
                    response.setStatus(status);
                    response.setMessage(message);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                printResponse((T) response);
            }
        }
        else {
            response = new SearchResponse();
            response.setOk(ok);
            response.setStatus(status);
            response.setMessage(message);
        }
        return response;

    }


    public StationDetailResponse getStationDetail(String id, String apikey) {
        StationDetailResponse response = null;

        if(!id.equals("") && !apikey.equals("")) {
            String mainUrl = baseUrl+"detail.php"+"?id="+id+"&apikey="+apikey;
            RestTemplate template = new RestTemplate();

            try {
                response = template.getForObject(mainUrl, StationDetailResponse.class);

                if(!response.getOk().equals("true")) {
                    response.setOk(ok);
                    response.setStatus(status);
                    response.setMessage(message);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                printResponse((T) response);
            }
        }
        else {
            response = new StationDetailResponse();
            response.setOk(ok);
            response.setStatus(status);
            response.setMessage(message);
        }
        return response;
    }*/

}
