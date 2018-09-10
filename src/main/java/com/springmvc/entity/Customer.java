package com.springmvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by geson on 2018/9/10.
 * 15:54
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
        @NamedQuery(name = "queryCustomerBalance",query = "SELECT c.balance FROM Customer c WHERE c.name = :customerName"),
        @NamedQuery(name = "updateCustomerBalance",query = "UPDATE Customer c SET c.balance = c.balance - :bookPrice WHERE c.name = :customerName"),
        @NamedQuery(name = "queryCustomersByName",query = "from Customer c where c.name = :customerName")
})
public class Customer {
    @Id
    @GenericGenerator(name = "generator",strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "ID")
    private  int id;

    @Column(name = "NAME",nullable = true)
    private String name;

    @Column(name = "BALANCE",nullable = true)
    private float balance;

    public Customer() {
    }

    public Customer(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}