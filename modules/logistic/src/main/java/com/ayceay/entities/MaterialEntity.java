package com.ayceay.entities;

import com.ayceay.constants.LogisticsConstraints;
import com.ayceay.constraints.MaterialConstraints;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = LogisticsConstraints.SCHEMA_NAME, name = MaterialConstraints.TABLE_NAME)
public class MaterialEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = MaterialConstraints.COLUMN_NAME)
    @Size(max = MaterialConstraints.NAME_SIZE_MAX)
    @NotNull
    private String name;

    @Column(name = MaterialConstraints.DESCRIPTION)
    @Size(max = MaterialConstraints.DESCRIPTION_SIZE_MAX)
    private String description;

    @Column(name = MaterialConstraints.CODE)
    @Size(max = MaterialConstraints.CODE_SIZE_MAX)
    @NotNull
    private String code;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, orphanRemoval = true)
    //@OrderColumn(name = "entry")
    private List<VendorMaterialEntity> vendors = new ArrayList<>();


    public void addVendor(VendorEntity vendor) {
        final VendorMaterialEntity vendorMaterial = new VendorMaterialEntity(this, vendor);
        vendors.add(vendorMaterial);
        vendor.getMaterials().add(vendorMaterial);
    }

    public void removeVendor(VendorEntity vendor) {
        for (Iterator<VendorMaterialEntity> iterator = vendors.iterator(); iterator.hasNext(); ) {
            VendorMaterialEntity vendorMaterialEntity = iterator.next();
            if (vendorMaterialEntity.getMaterial().equals(this) && vendorMaterialEntity.getVendor().equals(vendor)) {
                iterator.remove();
                vendorMaterialEntity.getVendor().getMaterials().remove(vendorMaterialEntity);
                vendorMaterialEntity.setMaterial(null);
                vendorMaterialEntity.setVendor(null);
                break;
            }
        }
    }

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

    public List<VendorMaterialEntity> getVendors() {
        return vendors;
    }

    public void setVendors(List<VendorMaterialEntity> vendors) {
        this.vendors = vendors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MaterialEntity that = (MaterialEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, code);
    }
}
