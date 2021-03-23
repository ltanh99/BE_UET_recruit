package com.example.finalproject.service.studentService;

import com.example.finalproject.dao.studentDao.StudentDao;
import com.example.finalproject.model.studentDTO.DAOStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Iterable<DAOStudent> GetAllStudent() {

        return studentDao.findAll();
    }
}
