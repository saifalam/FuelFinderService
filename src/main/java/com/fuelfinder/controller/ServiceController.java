package com.fuelfinder.controller;

import com.fuelfinder.model.request.AllStationRequest;
import com.fuelfinder.model.request.PriceRequest;
import com.fuelfinder.model.response.PriceDetailResponse;
import com.fuelfinder.model.response.SearchResponse;
import com.fuelfinder.model.response.StationDetailResponse;
import com.fuelfinder.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by saif on 22.11.17.
 */

@RestController
@RequestMapping(value ="/api")
public class ServiceController {

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

    @Autowired
    private FuelStationService stationService;


    @ResponseBody
    @RequestMapping(value ="/station/all", method = RequestMethod.POST)
    public SearchResponse getAllFuelStation (@RequestBody AllStationRequest requestModel) {
        SearchResponse response;
        if(requestModel != null && requestModel.getApiKey()!=null && !requestModel.getApiKey().isEmpty()) {

            // If type = all is always sorted by distance - the specification of the sorting is then optional
            String mainUrl = baseUrl+"list.php"+"?lat="+ requestModel.getLatitude() +"&lng="+
                    requestModel.getLongitude() +"&rad="+ requestModel.getRadius() +"&sort="+
                    (requestModel.getType().equals("all") ? reqParamSort: requestModel.getSort())
                    +"&type="+ requestModel.getType() +"&apikey="+ requestModel.getApiKey();

            response = (SearchResponse) stationService.getServiceModel(mainUrl, SearchResponse.class);
        }
        else {
            response = new SearchResponse();
            response.setOk(ok);
            response.setStatus(status);
            response.setMessage(message);
        }

        return response;
    }


    @ResponseBody
    @RequestMapping(value ="/price/all", method = RequestMethod.POST)
    public PriceDetailResponse getAllPrices (@RequestBody PriceRequest requestModel) {
        PriceDetailResponse response;

        if(requestModel != null && !requestModel.getApiKey().isEmpty() && requestModel.getIdList().size() >0) {
            StringBuilder ids = new StringBuilder();
            for(int i = 0; i < requestModel.getIdList().size(); i++) {
                ids.append(requestModel.getIdList().get(i));
                if(i != requestModel.getIdList().size()-1) {
                    ids.append(",") ;
                }
            }

            String mainUrl = baseUrl+"prices.php?ids="+ids.toString()+"&apikey="+requestModel.getApiKey();
            response = (PriceDetailResponse) stationService.getServiceModel(mainUrl, PriceDetailResponse.class);
        }
        else {
            response = new PriceDetailResponse();
            response.setOk(ok);
            response.setStatus(status);
            response.setMessage(message);
        }
        return response;

    }



    @ResponseBody
    @RequestMapping(value ="/station/detail/{id}/{apikey}", method = RequestMethod.GET)
    public StationDetailResponse getStationDetail (@PathVariable("id") String id,
                                                   @PathVariable("apikey") String apikey) {
        StationDetailResponse response;
        if(!id.equals("") && !apikey.equals("")) {
            String mainUrl = baseUrl+"detail.php?id="+id+"&apikey="+apikey;
            response = (StationDetailResponse) stationService.getServiceModel(mainUrl, StationDetailResponse.class);
        }
        else {
            response = new StationDetailResponse();
            response.setOk(ok);
            response.setStatus(status);
            response.setMessage(message);
        }
        return response;
    }


    /* @ResponseBody
    @RequestMapping(value ="/all", method = RequestMethod.POST)
    public SearchResponse getAllFuelStation (@RequestBody AllStationRequest requestModel) {
        SearchResponse response = stationService.getAllFuelStations(requestModel);
        return response;
    }

    @ResponseBody
    @RequestMapping(value ="/detail/{id}/{apikey}", method = RequestMethod.GET)
    public StationDetailResponse getStationDetail (@PathVariable("id") String id,
                                                   @PathVariable("apikey") String apikey) {
        StationDetailResponse response = stationService.getStationDetail(id, apikey);
        return response;
    }*/
}
