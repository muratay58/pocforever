package com.ayceay.dto;

import com.ayceay.constraints.MaterialConstraints;

import javax.validation.constraints.Size;
import java.util.List;

public class MaterialModel {

    private Long id;

    @Size(max = MaterialConstraints.NAME_SIZE_MAX)
    private String name;

    @Size(max = MaterialConstraints.DESCRIPTION_SIZE_MAX)
    private String description;

    @Size(max = MaterialConstraints.CODE_SIZE_MAX)
    private String code;

    private List<VendorModel> vendorModelList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<VendorModel> getVendorModelList() {
        return vendorModelList;
    }

    public void setVendorModelList(List<VendorModel> vendorModelList) {
        this.vendorModelList = vendorModelList;
    }
}
