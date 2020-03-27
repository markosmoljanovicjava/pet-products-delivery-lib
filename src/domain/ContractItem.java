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
    private Product product;
    private BigDecimal price;
    private Long quantity;
    private Contract contract;
    private BigDecimal amount;

    public ContractItem() {
    }

    public ContractItem(Long itemNumber, Product product, BigDecimal price, Long quantity, Contract contract, BigDecimal amount) {
        this.itemNumber = itemNumber;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.contract = contract;
        this.amount = amount;
    }

    public ContractItem(Long id, Long itemNumber, Product product, BigDecimal price, Long quantity, Contract contract, BigDecimal amount) {
        this.id = id;
        this.itemNumber = itemNumber;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.contract = contract;
        this.amount = amount;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
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
        return "ContractItem{" + "id=" + id + ", itemNumber=" + itemNumber + ", product=" + product + ", price=" + price + ", quantity=" + quantity + ", contract=" + contract + ", amount=" + amount + '}';
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
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
}
