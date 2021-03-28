package com.example.finalproject.model;

import com.example.finalproject.model.studentDTO.DAOStudent;

public class UserResponse {
    public UserResponse(){}
    public String token;
    public Iterable<DAOStudent> students;
}
