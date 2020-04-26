/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author remar
 */
public class Contract extends AbstractDomainObject implements Serializable {

    private Long id;
    private Date dateCreation;
    private Date dateExpiration;
    private BigDecimal amount;
    private List<ContractItem> contractItems;
    private User user;
    private Customer customer;

    public Contract() {
        contractItems = new ArrayList();
        amount = new BigDecimal(0);
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
        String string = String.format("Date: %s-%s; Amount: %s; Items: %s; User: %s; Customer: %s",
                new SimpleDateFormat("yyyy.MM.dd").format(dateCreation),
                new SimpleDateFormat("yyyy.MM.dd").format(dateExpiration),
                amount, contractItems, user, customer);
        return string;
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

    @Override
    public String getAttributeNamesInsert() {
        String string = super.getAttributeNamesInsert();
        //dateCreation, dateExpiration, amount, contractItems, user, customer
        return string.replace(", contractItems", "");
    }

    @Override
    public String getAttributeValuesInsert() {
        List<String> list = new ArrayList();
        list.add(String.format("'%s'", new java.sql.Date(dateCreation.getTime())));
        list.add(String.format("'%s'", new java.sql.Date(dateExpiration.getTime())));
        list.add(amount.toString());
        list.add(user.getId().toString());
        list.add(customer.getId().toString());
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
