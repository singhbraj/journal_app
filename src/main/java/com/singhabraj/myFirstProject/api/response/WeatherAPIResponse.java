package com.singhabraj.myFirstProject.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherAPIResponse {

    private Current current;

    @Getter
    @Setter
    public class Current{
        private int temperature;

        @JsonProperty("weather_description")
        private List<String> weatherDescription;
        private int feelslike;
    }

}
