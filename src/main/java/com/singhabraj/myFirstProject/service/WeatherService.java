package com.singhabraj.myFirstProject.service;

import com.singhabraj.myFirstProject.api.response.WeatherAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    private static final String apiKey = "88d818d33968b2626afff0bdb3df5904";
    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherAPIResponse getWeather(String city){
      String finalAPI = API.replace("CITY",city).replace("API_KEY",apiKey);
        ResponseEntity<WeatherAPIResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherAPIResponse.class);
       WeatherAPIResponse body =  response.getBody();
       return body;
    }

}
