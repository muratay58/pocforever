package com.ayceay.controller;

import com.ayceay.converter.VendorConverter;
import com.ayceay.dto.VendorModel;
import com.ayceay.repo.VendorRepository;
import com.ayceay.services.PublicServiceVendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PublicServiceVendorController implements PublicServiceVendor {

    VendorRepository vendorRepository;
    VendorConverter vendorConverter;


    @Autowired
    public PublicServiceVendorController(VendorRepository vendorRepository, VendorConverter vendorConverter) {
        this.vendorRepository = vendorRepository;
        this.vendorConverter = vendorConverter;
    }

    @Override
    @PostMapping("/savevendor")
    public VendorModel saveVendor(@RequestBody @Valid VendorModel vendorModel) {
        return vendorConverter.convertToModel(vendorRepository.save(vendorConverter.convertToEntity(vendorModel)));
    }
}
