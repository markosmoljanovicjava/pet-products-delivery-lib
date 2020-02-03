/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author remar
 */
public class Product extends AbstractDomainObject implements Serializable {

    private Long id;
    private String name;
    private BigDecimal price;
    private Manufacturer manufacturer;

    public Product() {
    }

    public Product(String naziv, BigDecimal price, Manufacturer manufacturer) {
        this.name = naziv;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public Product(Long id, String naziv, BigDecimal price, Manufacturer manufacturer) {
        this.id = id;
        this.name = naziv;
        this.price = price;
        this.manufacturer = manufacturer;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", naziv=" + name + ", price=" + price + ", manufacturer=" + manufacturer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String getAttributeValuesForInsert() {
        List<String> list = new ArrayList();
        list.add(id.toString());
        list.add("'" + name + "'");
        list.add(price.toString());
        list.add(manufacturer.getId().toString());
        return String.join(", ", list);
    }

    @Override
    public Boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setObjectId(Long id) {
        setId(id);
    }

}
