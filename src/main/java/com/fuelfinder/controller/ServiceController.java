package com.fuelfinder.controller;

import com.fuelfinder.model.request.AllStationRequest;
import com.fuelfinder.model.request.PriceRequest;
import com.fuelfinder.model.response.PriceDetailResponse;
import com.fuelfinder.model.response.SearchResponse;
import com.fuelfinder.model.response.StationDetailResponse;
import com.fuelfinder.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by saif on 22.11.17.
 */

@RestController
@RequestMapping(value ="/api")
public class ServiceController {

    @Value("${service.detail.url}")
    private String detailUrl;

    @Value("${service.list.url}")
    private String listUrl;

    @Value("${service.price.url}")
    private String priceUrl;

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

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(listUrl)
                    .queryParam("lat", requestModel.getLatitude())
                    .queryParam("lng", requestModel.getLongitude())
                    .queryParam("rad", requestModel.getRadius())
                    .queryParam("sort", requestModel.getType().equals("all") ? reqParamSort: requestModel.getSort())
                    .queryParam("type", requestModel.getType())
                    .queryParam("apikey", requestModel.getApiKey());

            HttpEntity entity = new HttpEntity<>(headers);

            response = (SearchResponse) stationService.getServiceModel(builder.build().encode().toUri(), entity, SearchResponse.class);
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

        if(requestModel != null && !requestModel.getApiKey().isEmpty() && requestModel.getIdList().size() > 0) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(priceUrl)
                    .queryParam("ids", String.join(",",requestModel.getIdList()))
                    .queryParam("apikey", requestModel.getApiKey());

            HttpEntity entity = new HttpEntity<>(headers);

            response = (PriceDetailResponse) stationService.getServiceModel(builder.build().encode().toUri(), entity, PriceDetailResponse.class);
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

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(detailUrl)
                    .queryParam("id", id)
                    .queryParam("apikey", apikey);
            HttpEntity entity = new HttpEntity<>(headers);

            response = (StationDetailResponse) stationService.getServiceModel(builder.build().encode().toUri(), entity, StationDetailResponse.class);
        }
        else {
            response = new StationDetailResponse();
            response.setOk(ok);
            response.setStatus(status);
            response.setMessage(message);
        }
        return response;
    }
}
