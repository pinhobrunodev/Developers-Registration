package com.pinhobrunodev.devregistration.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant created_At;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updated_at;


    @ManyToMany(mappedBy = "addresses")
    private Set<User> users = new HashSet<>();

    public Address() {
    }

    public Address(Long id, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.id = id;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Set<User> getUsers() {
        return users;
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
