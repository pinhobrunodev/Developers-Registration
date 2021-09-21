package com.pinhobrunodev.devregistration.viaCEP;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinhobrunodev.devregistration.services.exceptions.InvalidFormatZipCode;
import com.pinhobrunodev.devregistration.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Service
public class viaCEPWebService {

    @Autowired
    private RestTemplate restTemplate;
    private String baseUrl = "http://viacep.com.br/ws";
    private String type = "/json";
    private String payload = "";
    @Autowired
    ObjectMapper mapper;

    public AddressViaCEPDTO viaCEPWebService(String cep)throws  Exception {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("cep", cep.toString());
        System.out.println(baseUrl + "/" + cep + type);
        try {
            ResponseEntity<AddressViaCEPDTO> result = restTemplate.getForEntity(baseUrl + "/{cep}" + type, AddressViaCEPDTO.class,
                    uriVariables);
            if(result.getStatusCodeValue() == 200 && result.getBody().getLocalidade() ==  null){
                NotFoundAddress notFoundAddress = new NotFoundAddress("true");
               String aux =  mapper.writeValueAsString(notFoundAddress);
                throw  new ResourceNotFoundException(aux);
            }
            return result.getBody();
        } catch (HttpClientErrorException e) {
            payload = e.getResponseBodyAsString();
            System.out.println(payload);
            throw new InvalidFormatZipCode(payload);
        }
    }
}

