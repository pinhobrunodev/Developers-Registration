package com.pinhobrunodev.devregistration.dto.user;

import com.pinhobrunodev.devregistration.entities.Address;
import com.pinhobrunodev.devregistration.entities.User;
import com.pinhobrunodev.devregistration.viaCEP.AddressViaCEPDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private Long id;
    private String github_username;
    private String cep;
    private String name;
    private String bio;
    private String blog;
    private String email;
    private String company;
    private List<AddressViaCEPDTO> addresses = new ArrayList<>();

    public UserDTO(){

    }


    public UserDTO(User entity){
        id = entity.getId();
        github_username = entity.getGithub_username();
        cep = entity.getCep();
        name =entity.getName();
        bio = entity.getBio();
        blog = entity.getBlog();
        email = entity.getEmail();
        company = entity.getCompany();
    }

    public UserDTO(User entity, Set<Address> addressEntity){
    this(entity);
    addressEntity.forEach(x-> addresses.add(new AddressViaCEPDTO(x)));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGithub_username() {
        return github_username;
    }

    public void setGithub_username(String github_username) {
        this.github_username = github_username;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<AddressViaCEPDTO> getAddresses() {
        return addresses;
    }
}
