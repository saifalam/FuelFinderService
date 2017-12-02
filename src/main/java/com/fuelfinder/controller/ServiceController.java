package com.fuelfinder.controller;

import com.fuelfinder.model.request.AllStationRequest;
import com.fuelfinder.model.request.PriceRequest;
import com.fuelfinder.model.response.PriceDetailResponse;
import com.fuelfinder.model.response.SearchResponse;
import com.fuelfinder.model.response.PlaceDetailResponse;
import com.fuelfinder.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${service.api.key}")
    private String apikey;

    @Value("${service.ok}")
    private String ok;

    @Value("${service.status}")
    private String status;

    @Value("${service.message.invalid}")
    private String message;

    @Value("${service.request.type}")
    private String reqParamType;

    @Value("${service.request.sort}")
    private String reqParamSort;

    @Value("${service.request.default.radius}")
    private float radius;

    @Autowired
    private FuelStationService stationService;


    @ResponseBody
    @RequestMapping(value ="/place/all", method = RequestMethod.POST)
    public SearchResponse getAllFuelStation (@RequestBody AllStationRequest requestModel) {
        SearchResponse response;
        if(requestModel != null) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(listUrl)
                    .queryParam("lat", requestModel.getLatitude())
                    .queryParam("lng", requestModel.getLongitude())
                    .queryParam("rad", requestModel.getRadius() > 0 ? requestModel.getRadius() : radius)
                    .queryParam("sort", requestModel.getType().equals("all") ? reqParamSort: requestModel.getSort().
                            toLowerCase().trim())
                    .queryParam("type", requestModel.getType().toLowerCase().trim())
                    .queryParam("apikey", apikey.trim());
            response = (SearchResponse) stationService.getServiceModel(builder.build().encode().toUri(), SearchResponse.class);
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
        if(requestModel != null && requestModel.getIdList().size() > 0) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(priceUrl)
                    .queryParam("ids", String.join(",",requestModel.getIdList()))
                    .queryParam("apikey", apikey.trim());
            response = (PriceDetailResponse) stationService.getServiceModel(builder.build().encode().toUri(), PriceDetailResponse.class);
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
    @RequestMapping(value ="/place/detail/{id}", method = RequestMethod.GET)
    public PlaceDetailResponse getPlaceDetail (@PathVariable("id") String id) {
        PlaceDetailResponse response;
        if(!id.equals("") && !id.isEmpty()) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(detailUrl)
                    .queryParam("id", id)
                    .queryParam("apikey", apikey.trim());
            response = (PlaceDetailResponse) stationService.getServiceModel(builder.build().encode().toUri(), PlaceDetailResponse.class);
        }
        else {
            response = new PlaceDetailResponse();
            response.setOk(ok);
            response.setStatus(status);
            response.setMessage(message);
        }
        return response;
    }
}
