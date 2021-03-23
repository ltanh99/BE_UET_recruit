package com.example.finalproject.model.studentDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "student")
public class DAOStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int code;
    @Column
    private Date birthday;
    @Column
    private String phonenumber;
    @Column
    private String address;
    @Column
    private String email;

    public void setStudentId(int studentId) {
        this.id = studentId;
    }

    public void setStudentName(String studentName) {
        this.name = studentName;
    }

    public void setStudentCode(int studentCode) {
        this.code = studentCode;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentId() {
        return id;
    }

    public String getStudentName() {
        return name;
    }

    public int getStudentCode() {
        return code;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

}
