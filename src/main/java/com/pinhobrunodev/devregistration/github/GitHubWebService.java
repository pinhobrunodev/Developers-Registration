package com.pinhobrunodev.devregistration.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GitHubWebService {

    @Autowired
    private RestTemplate restTemplate;

    private String baseUrl = "https://api.github.com/users/";

    public GitHubUserInfoDTO gitHubWebService(String username) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("username", username.toString());
        System.out.println(baseUrl + username);
        ResponseEntity<GitHubUserInfoDTO> result = restTemplate.getForEntity(baseUrl + "/{username}", GitHubUserInfoDTO.class,
                uriVariables);
        return result.getBody();
    }
}
