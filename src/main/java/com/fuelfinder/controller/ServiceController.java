package com.fuelfinder.controller;

import com.fuelfinder.model.response.PriceDetailResponse;
import com.fuelfinder.model.response.SearchResponse;
import com.fuelfinder.model.response.StationDetailResponse;
import com.fuelfinder.model.request.AllStationRequest;
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
        SearchResponse response = null;
        if(requestModel != null && !requestModel.getApiKey().equals("")) {

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
    // TODO: Need to fix the Request and Response object structure and fix the URL as well
    public PriceDetailResponse getAllPrices (@RequestBody AllStationRequest requestModel) {
        PriceDetailResponse response = null;
        if(requestModel != null) {

            String mainUrl = "https://creativecommons.tankerkoenig.de/json/prices.php?ids=4429a7d9-fb2d-4c29-8cfe-2ca90323f9f8,446bdcf5-9f75-47fc-9cfa-2c3d6fda1c3b,60c0eefa-d2a8-4f5c-82cc-b5244ecae955,44444444-4444-4444-4444-444444444444&apikey=00000000-0000-0000-0000-000000000002";

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
        StationDetailResponse response = null;
        if(!id.equals("") && !apikey.equals("")) {
            String mainUrl = baseUrl+"detail.php"+"?id="+id+"&apikey="+apikey;
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
