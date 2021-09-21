package com.pinhobrunodev.devregistration.services.exceptions;

public class InvalidFormatZipCode extends  RuntimeException {

    public InvalidFormatZipCode(String  msg){
        super(msg);
    }
}
