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
    public String getAttributeValuesForInsert() {
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
    public String getSET() {
        return String.format("name = '%s', price = %s, manufacturer = %s", name, price, manufacturer.getId());
    }
    
    @Override
    public String getWHERE() {
        return String.format("id = %s", id);
    }
    
    @Override
    public String getAttributeNamesForJoin() {
        return "product.id, product.name, product.price, manufacturer.id, manufacturer.name, manufacturer.adress, manufacturer.phoneNumber";
    }
    
    @Override
    public String getConditionForJoin() {
        return "INNER JOIN manufacturer manufacturer ON product.manufacturer = manufacturer.id";
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
    public String getORDERBYForJoin() {
        return "product.name";
    }
    
    @Override
    public String getConditionForEquals() {
        return String.format("id = %s", id);
    }
    
    @Override
    public String getConditionForWhere() {
        return String.format("manufacturer = %s", manufacturer.getId());
    }
    
}
