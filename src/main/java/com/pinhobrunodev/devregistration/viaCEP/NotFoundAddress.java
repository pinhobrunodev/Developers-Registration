package com.pinhobrunodev.devregistration.viaCEP;

public class NotFoundAddress {

    private String erro;

    public NotFoundAddress() {
    }

    public NotFoundAddress(String erro) {
        this.erro = erro;
    }


    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

}
