package com.pinhobrunodev.devregistration.resources;

import com.pinhobrunodev.devregistration.dto.user.UserDTO;
import com.pinhobrunodev.devregistration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserResource {


    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> post(@RequestBody UserDTO dto){
        return  ResponseEntity.ok().body(service.save(dto));
    }
}
