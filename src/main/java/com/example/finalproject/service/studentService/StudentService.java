package com.example.finalproject.service.studentService;

import com.example.finalproject.dao.studentDao.StudentDao;
import com.example.finalproject.model.studentDTO.DAOStudent;
import com.example.finalproject.model.studentDTO.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Iterable<DAOStudent> GetAllStudent() {

        return studentDao.findAll();
    }

    public Iterable<DAOStudent> SearchStudent(SearchRequest param) {
        return studentDao.FindByCategory(param);
    }
}
