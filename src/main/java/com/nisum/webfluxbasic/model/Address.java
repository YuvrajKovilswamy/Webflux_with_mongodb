package com.nisum.webfluxbasic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Address {

    String addressLine;
    String state;

    public Address() {
    }

    public Address(int addressId, String addressLine, String state) {
        this.addressLine = addressLine;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +

                ", addressLine='" + addressLine + '\'' +
                ", state='" + state + '\'' +
                '}';
    }


    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
