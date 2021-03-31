package com.example.finalproject.model.studentDTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DAOFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followerId;
    @Column
    private int companyId;
    @Column
    private int studentId;
}
