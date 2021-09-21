package com.pinhobrunodev.devregistration.github;

import com.pinhobrunodev.devregistration.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class GitHubWebService {


    private final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;

    @Autowired
    private RestTemplate restTemplate;

    private String payload = "";

    private String baseUrl = "https://api.github.com/users/";

    public GitHubUserInfoDTO gitHubWebService(String username) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("username", username.toString());
        System.out.println(baseUrl + username);
        try {
            ResponseEntity<GitHubUserInfoDTO> result = restTemplate.getForEntity(baseUrl + "/{username}", GitHubUserInfoDTO.class,
                    uriVariables);
            return  result.getBody();
        }catch (HttpClientErrorException e){
            payload = e.getResponseBodyAsString();
            throw  new ResourceNotFoundException(payload);
        }

    }
}
