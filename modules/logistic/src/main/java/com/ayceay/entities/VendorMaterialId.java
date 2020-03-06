package com.ayceay.entities;

import com.ayceay.constraints.VendorMaterialConstraints;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VendorMaterialId implements Serializable {
    @Column(name = VendorMaterialConstraints.COLUMN_VENDOR_ID)
    private Long vendorId;

    @Column(name = VendorMaterialConstraints.COLUMN_MATERIAL_ID)
    private Long materialId;

    public VendorMaterialId() {
    }

    public VendorMaterialId(Long materialId , Long vendorId) {
        this.materialId = materialId;
        this.vendorId = vendorId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        VendorMaterialId that = (VendorMaterialId) o;
        return Objects.equals(vendorId, that.vendorId) &&
                Objects.equals(materialId, that.materialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorId, materialId);
    }
}
