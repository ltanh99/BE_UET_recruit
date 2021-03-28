package com.example.finalproject.model.studentDTO;

import java.sql.Date;

public class SearchRequest {
    public SearchRequest() {
    }

    public SearchRequest(int id) {
        this.id = id;
    }

    public int id;
    public String name;
    public int code;
    public Date birthdayFrom;
    public Date birthdayTo;
    public String phoneNumber;
    public String pageIndex;
    public String pageSize;
}
