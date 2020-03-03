/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author remar
 */
public class Contract implements Serializable {

    private Long id;
    private Date dateCreation;
    private Date dateExpiration;
    private BigDecimal amount;
    private List<ContractItem> contractItems;
    private User user;
    private Customer customer;

    public Contract() {
        contractItems = new ArrayList();
    }

    public Contract(Long id, Date dateCreation, Date dateExpiration, BigDecimal amount, List<ContractItem> contractItems, User user, Customer customer) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.amount = amount;
        this.contractItems = contractItems;
        this.user = user;
        this.customer = customer;
    }

    public Contract(Date dateCreation, Date dateExpiration, BigDecimal amount, List<ContractItem> contractItems, User user, Customer customer) {
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.amount = amount;
        this.contractItems = contractItems;
        this.user = user;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ContractItem> getContractItems() {
        return contractItems;
    }

    public void setContractItems(List<ContractItem> contractItems) {
        this.contractItems = contractItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" + "id=" + id + ", dateCreation=" + dateCreation + ", dateExpiration=" + dateExpiration + ", amount=" + amount + ", contractItems=" + contractItems + ", user=" + user + ", customer=" + customer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Contract other = (Contract) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
