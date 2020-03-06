package com.ayceay.controller;

import com.ayceay.converter.MaterialConverter;
import com.ayceay.dto.MaterialModel;
import com.ayceay.repo.MaterialRepository;
import com.ayceay.services.PublicServiceMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PublicServiceMaterialController implements PublicServiceMaterial {


    MaterialConverter materialConverter;
    MaterialRepository materialRepository;

    @Autowired
    public PublicServiceMaterialController(MaterialConverter materialConverter, MaterialRepository materialRepository) {
        this.materialConverter = materialConverter;
        this.materialRepository = materialRepository;
    }

    @Override
    @PostMapping("/savematerial")
    public MaterialModel saveMaterial(@RequestBody @Valid MaterialModel materialModel) {
        return materialConverter.convertToModel(materialRepository.save(materialConverter.convertToEntity(materialModel)));
    }
}
