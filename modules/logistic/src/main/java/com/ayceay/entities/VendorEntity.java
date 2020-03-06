package com.ayceay.entities;

import com.ayceay.constants.LogisticsConstraints;
import com.ayceay.constraints.VendorConstraints;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = LogisticsConstraints.SCHEMA_NAME, name = VendorConstraints.TABLE_NAME)
public class VendorEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = VendorConstraints.COLUMN_NAME)
    @Size(max = VendorConstraints.NAME_SIZE_MAX)
    private String name;

    @Column(name = VendorConstraints.COLUMN_COUNTRY)
    @Size(max = VendorConstraints.COUNTRY_SIZE_MAX)
    private String country;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "entry")
    private List<VendorMaterialEntity> materials = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Personnel(uuid) responsible from contacting vendor
     */


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

    public List<VendorMaterialEntity> getMaterials() {
        return materials;
    }

    public void setMaterials(List<VendorMaterialEntity> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VendorEntity that = (VendorEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, country);
    }
}

