package com.ayceay.converter;

import com.ayceay.dto.MaterialModel;
import com.ayceay.dto.VendorModel;
import com.ayceay.entities.MaterialEntity;
import com.ayceay.entities.VendorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendorConverter {


    ModelMapper modelMapper;

    @Autowired
    public VendorConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VendorModel convertToModel(VendorEntity vendorEntity){
        return modelMapper.map(vendorEntity, VendorModel.class);
    }

    public VendorEntity convertToEntity(VendorModel vendorModel){
        return modelMapper.map(vendorModel, VendorEntity.class);
    }
}
