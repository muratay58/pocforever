package com.ayceay.dto;

import com.ayceay.constraints.VendorConstraints;

import javax.validation.constraints.Size;

public class VendorModel {

    private Long id;

    @Size(max = VendorConstraints.NAME_SIZE_MAX)
    private String name;

    @Size(max = VendorConstraints.COUNTRY_SIZE_MAX)
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
