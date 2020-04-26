/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return name;
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
    public String getAttributeValuesInsert() {
        List<String> list = new ArrayList();
        list.add(String.format("'%s'", name));
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

    @Override
    public Long getObjectId() {
        return id;
    }

    @Override
    public String getSet() {
        return String.format("name = '%s', price = %s, manufacturer = %s", name, price, manufacturer.getId());
    }

    @Override
    public String getAttributeNamesJoin() {
        return "Product.id, Product.name, Product.price, Manufacturer.id, Manufacturer.name, Manufacturer.adress, Manufacturer.phoneNumber";
    }

    @Override
    public String getJoin() {
        return "INNER JOIN Manufacturer ON Product.manufacturer = Manufacturer.id";
    }

    @Override
    public String getOrderBy(Boolean isJoin) {
        String prefix = "";
        if (isJoin) {
            prefix = tableName + ".";
        }
        return String.format("%sname", prefix);
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new ArrayList();
        while (rs.next()) {
            list.add(new Product(rs.getLong(1), rs.getString(2), rs.getBigDecimal(3),
                    new Manufacturer(rs.getLong(4), rs.getString(5), rs.getString(6), rs.getString(7))));
        }
        return list;
    }

    @Override
    public String getWhere(DomainObject domainObject, Boolean isJoin) {
        String prefix = "";
        if (isJoin) {
            prefix = tableName + ".";
        }
        String string = "";
        Product product = (Product) domainObject;
        if (product.getId() != null) {
            string += String.format("%s%s = %s AND ", prefix, attributeNames.get(0), id);
        }
        if (product.getName() != null) {
            string += String.format("%s%s = '%s' AND ", prefix, attributeNames.get(1), name);
        }
        if (product.getPrice() != null) {
            string += String.format("%s%s = %s AND ", prefix, attributeNames.get(2), price);
        }
        if (product.getManufacturer() != null) {
            string += String.format("%s = %s", attributeNames.get(3), manufacturer.getId());
        }
        if (string.endsWith("AND ")) {
            string = string.substring(0, string.length() - 4);
        }
        return string;
    }
}
