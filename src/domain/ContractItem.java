/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author remar
 */
public class ContractItem implements Serializable {

    private Long id;
    private Long itemNumber;
    private String description;
    private Product product;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal amount;
    private Contract contract;

    public ContractItem() {
    }

    public ContractItem(Long itemNumber, String description, Product product, BigDecimal price, BigDecimal quantity, BigDecimal amount, Contract contract) {
        this.itemNumber = itemNumber;
        this.description = description;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
        this.contract = contract;
    }

    public ContractItem(Long id, Long itemNumber, String description, Product product, BigDecimal price, BigDecimal quantity, BigDecimal amount, Contract contract) {
        this.id = id;
        this.itemNumber = itemNumber;
        this.description = description;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ContractItem{" + "id=" + id + ", itemNumber=" + itemNumber + ", description=" + description + ", product=" + product + ", price=" + price + ", quantity=" + quantity + ", amount=" + amount + ", contract=" + contract + '}';
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
        final ContractItem other = (ContractItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
