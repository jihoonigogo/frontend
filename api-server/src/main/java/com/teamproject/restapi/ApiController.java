package com.teamproject.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/kobisdata")
    public String callAPI(){
        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";
        try {
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000);
            factory.setReadTimeout(5000);
            RestTemplate restTemplate = new RestTemplate(factory);

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "key=b61a88d01b3f805814dbbd68b34c81d1&targetDt=20210601").build();

            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
//            result.put("statuscode", resultMap.getStatusCode());
//            result.put("header", resultMap.getHeaders());
//            result.put("body", resultMap.getBody());
            LinkedHashMap lm = (LinkedHashMap)resultMap.getBody().get("boxOfficeResult");

            ArrayList<Map> dboxoffList = (ArrayList<Map>)lm.get("dailyBoxOfficeList");

            LinkedHashMap mnList = new LinkedHashMap<>();
            for (Map obj : dboxoffList) {
                mnList.put(obj.get("rnum"),obj.get("movieNm"));
            }
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(mnList);

        }catch (HttpClientErrorException | HttpServerErrorException e) {
//            result.put("statusCode", e.getRawStatusCode());
//            result.put("body"  , e.getStatusText());
            System.out.println(e.toString());

        } catch (Exception e) {
//            result.put("statusCode", "999");
//            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }
        return jsonInString;
    }
}
