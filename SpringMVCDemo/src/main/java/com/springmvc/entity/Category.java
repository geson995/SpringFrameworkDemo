package com.springmvc.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CATE_NAME", length = 32)
    private String cateName;

//    @OneToMany(targetEntity = Book.class)
//    private List<Book> books;

    @Column(name = "CREATE_TIME", insertable = false, updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Category() {
    }

    public Category(String cateName) {
        this.cateName = cateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
