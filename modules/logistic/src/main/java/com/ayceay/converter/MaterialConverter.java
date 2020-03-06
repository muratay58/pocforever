package com.ayceay.converter;

import com.ayceay.dto.MaterialModel;
import com.ayceay.dto.VendorModel;
import com.ayceay.entities.MaterialEntity;
import com.ayceay.entities.VendorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaterialConverter {


    ModelMapper modelMapper;

    @Autowired
    public MaterialConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MaterialModel convertToModel(MaterialEntity materialEntity){
        return modelMapper.map(materialEntity, MaterialModel.class);
    }

    public MaterialEntity convertToEntity(MaterialModel materialModel){

        MaterialEntity materialEntity = modelMapper.map(materialModel, MaterialEntity.class);

        if (materialModel.getVendorModelList() != null && !materialModel.getVendorModelList().isEmpty()) {
            for (VendorModel vendorModel : materialModel.getVendorModelList()) {
                VendorConverter vendorConverter = new VendorConverter(this.modelMapper);
                VendorEntity vendorEntity = vendorConverter.convertToEntity(vendorModel);
                materialEntity.addVendor(vendorEntity);
            }
        }

        return materialEntity;
    }
}
