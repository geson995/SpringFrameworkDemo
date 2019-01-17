package com.hnu.easy_ball.domain;

import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * create by  geson at 2019/1/14 22:12
 * email: pypiguo@gmail.com
 */
@Entity
@Table(name = "USER_DEMO")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    private static Long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid")
    @GeneratedValue(generator = "generator")
    @Column(name = "uid", length = 36)
    private String id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "pass_word", nullable = false)
    private String passWord;

    @Column(length = 64)
    private String email;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(name = "create_time")
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Date createTime;

    @Column(name = "modify_name", insertable = false)
    @Generated(GenerationTime.ALWAYS)
    private Date modifyTime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "create_time2")
    private Date createTime2;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "modify_name2", insertable = false)
    private Date modifyTime2;

    @CreatedDate
    @Column(name = "create_time_jpa")
    private Timestamp create_date_jpa;

    @LastModifiedDate
    @Column(name = "modify_time_jps", insertable = false)
    private Date modify_time_jpa;

    protected User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord, String nickName) {
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }
}
