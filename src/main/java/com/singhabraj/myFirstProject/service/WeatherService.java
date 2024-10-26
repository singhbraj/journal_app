package com.singhabraj.myFirstProject.service;

import com.singhabraj.myFirstProject.api.response.WeatherAPIResponse;
import com.singhabraj.myFirstProject.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherAPIResponse getWeather(String city){

      String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace("<city>",city).replace("<apiKey>",apiKey);
        ResponseEntity<WeatherAPIResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherAPIResponse.class);
       WeatherAPIResponse body =  response.getBody();
       return body;
    }

}
