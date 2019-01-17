package com.springmvc.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CUSTOMER_BOOK", schema = "book_store")
@IdClass(CustomerBookEntityPK.class)
public class CustomerBookEntity {
    private int uid;
    private int bid;
    private Timestamp updateTime;

    @Id
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Id
    @Column(name = "bid", nullable = false)
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBookEntity that = (CustomerBookEntity) o;

        if (uid != that.uid) return false;
        if (bid != that.bid) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + bid;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
