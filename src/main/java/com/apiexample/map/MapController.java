package com.apiexample.map;

import com.apiexample.domain.config.ApiProperties;
import com.apiexample.map.json.ElevationResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 */
@RestController
@RequestMapping(value="api/map/")
public class MapController {

    @Autowired
    ApiProperties apiProperties;

    @RequestMapping(value="test", method=RequestMethod.GET)
    public ElevationResultJson get(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());


        Hoge response = restTemplate.getForObject("http://localhost:8090/api/users/1", Hoge.class);

        String googleApiKey = apiProperties.getGoogleKey();
        String url = "https://maps.googleapis.com/maps/api/elevation/json?locations=39.7391536,-104.9847034&key=" + googleApiKey;
        ElevationResultJson elevationResultJson = restTemplate.getForObject(url, ElevationResultJson.class);


        return elevationResultJson;
    }

}
