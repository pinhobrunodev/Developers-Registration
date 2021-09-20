package com.pinhobrunodev.devregistration.entities;


import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario_github")
    private String github_username;
    private String cep;
    @Column(name = "nome")
    private String name;
    @Column(name = "biografia")
    private String bio;
    @Column(name = "site_pessoal")
    private String blog;
    private String email;
    @Column(name = "empresa")
    private String company;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant created_At;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updated_at;


   @ManyToMany
   @JoinTable(name = "tb_user_address"
           ,joinColumns = @JoinColumn(name = "user_id")
           ,inverseJoinColumns = @JoinColumn(name = "address_id"))
   private Set<Address> addresses = new HashSet<>();

    public User() {
    }

    public User(Long id, String github_username, String cep, String name, String bio, String blog, String email, String company, Instant created_At, Instant updated_at) {
        this.id = id;
        this.github_username = github_username;
        this.cep = cep;
        this.name = name;
        this.bio = bio;
        this.blog = blog;
        this.email = email;
        this.company = company;
        this.created_At = created_At;
        this.updated_at = updated_at;
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Instant getCreated_At() {
        return created_At;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }


    @PrePersist
    public void prePersist() {
        this.created_At = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated_at = Instant.now();
    }
}
