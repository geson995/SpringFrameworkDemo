package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CustomerBookEntityPK implements Serializable {
    private int uid;
    private int bid;

    @Column(name = "uid", nullable = false)
    @Id
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Column(name = "bid", nullable = false)
    @Id
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBookEntityPK that = (CustomerBookEntityPK) o;

        if (uid != that.uid) return false;
        if (bid != that.bid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + bid;
        return result;
    }
}
