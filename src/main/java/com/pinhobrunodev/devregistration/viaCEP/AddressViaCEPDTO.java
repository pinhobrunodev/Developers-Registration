package com.pinhobrunodev.devregistration.viaCEP;


import com.pinhobrunodev.devregistration.entities.Address;

public class AddressViaCEPDTO {

    private Long id;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public AddressViaCEPDTO() {
    }


    public AddressViaCEPDTO(Address entity) {
        id = entity.getId();
        localidade = entity.getLocalidade();
        logradouro = entity.getLogradouro();
        bairro = entity.getBairro();
        complemento = entity.getComplemento();
        uf = entity.getUf();
    }


    public AddressViaCEPDTO(Long id, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.id = id;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public AddressViaCEPDTO(AddressViaCEPDTO addressViaCEPDTO) {
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

}
