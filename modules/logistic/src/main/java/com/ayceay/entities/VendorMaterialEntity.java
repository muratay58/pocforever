package com.ayceay.entities;

import com.ayceay.constants.LogisticsConstraints;
import com.ayceay.constraints.VendorMaterialConstraints;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = LogisticsConstraints.SCHEMA_NAME, name = VendorMaterialConstraints.TABLE_NAME)
public class VendorMaterialEntity {

    @EmbeddedId
    private VendorMaterialId vendorMaterialId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = VendorMaterialConstraints.COLUMN_VENDOR_ID,
            foreignKey = @ForeignKey(name = "FK_VENDOR_MATERIAL_VENDOR"))
    @LazyToOne(LazyToOneOption.PROXY)
    @NotNull
    @MapsId("vendorId")
    private VendorEntity vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = VendorMaterialConstraints.COLUMN_MATERIAL_ID,
            foreignKey = @ForeignKey(name = "FK_VENDOR_MATERIAL_MATERIAL"))
    @LazyToOne(LazyToOneOption.PROXY)
    @NotNull
    @MapsId("materialId")
    private MaterialEntity material;


    public VendorMaterialEntity() {
    }

    public VendorMaterialEntity(MaterialEntity material, VendorEntity vendor) {
        this.material = material;
        this.vendor = vendor;
        this.vendorMaterialId = new VendorMaterialId(material.getId() , vendor.getId());

    }

    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }

}
