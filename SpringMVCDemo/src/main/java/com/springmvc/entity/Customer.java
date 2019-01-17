package com.springmvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by geson on 2018/9/10.
 * 15:54
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
        @NamedQuery(name = "queryCustomerBalance", query = "SELECT c.balance FROM Customer c WHERE c.name = :customerName"),
        @NamedQuery(name = "updateCustomerBalance", query = "UPDATE Customer c SET c.balance = c.balance - :bookPrice WHERE c.name = :customerName"),
        @NamedQuery(name = "queryCustomersByName", query = "from Customer c where c.name = :customerName"),
        @NamedQuery(name = "queryCustomers", query = "from Customer ")
})
//@EntityListeners(AuditingEntityListener.class)
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Customer {
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid")
    @GeneratedValue(generator = "generator")
    @Column(name = "ID")
    private String id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSSWORD")
    private String password;

    @Column(name = "NAME", nullable = true)
    private String name;

    @Column(name = "BALANCE", nullable = true)
    private float balance;

    @Column(name = "CREATE_TIME", updatable = false, nullable = false)
//    @CreatedDate
    private Timestamp createTime;

    public Customer() {
    }

    @Column(name = "MODIFY_DTIME")
//    @LastModifiedDate
    private long modifiedDate;

    public Customer(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreate_time() {
        return createTime;
    }

    public void setCreateTime(Timestamp create_time) {
        this.createTime = create_time;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}