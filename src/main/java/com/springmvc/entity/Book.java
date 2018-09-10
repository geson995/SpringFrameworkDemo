package com.springmvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by geson on 2018/9/10.
 * 13:11
 */
@Entity
@Table(name = "BOOK")
@NamedQueries({
        @NamedQuery(name = "queryBookByName",query = "SELECT b FROM Book b WHERE b.name = :bookName"),
        @NamedQuery(name = "updateBookCountByName",query = "UPDATE Book b SET b.count = b.count - 1 WHERE b.name = :bookName")
})
//@org.hibernate.annotations.NamedQuery(name = "queryBookPriceByName11",query = "")
public class Book {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = true)
    private String name;

    @Column(name = "PRICE", nullable = true)
    private float price;

    @Column(name = "COUNT", nullable = true)
    private int count;

    public Book() {
    }

    public Book(String name, float price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}