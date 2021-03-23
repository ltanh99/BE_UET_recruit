package com.example.finalproject.controller.studentController;

import com.example.finalproject.model.studentDTO.DAOStudent;
import com.example.finalproject.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/get_all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<DAOStudent>> getAllStudent() throws Exception{

        return ResponseEntity.ok(studentService.GetAllStudent());
    }
}
