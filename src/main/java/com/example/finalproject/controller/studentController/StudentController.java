package com.example.finalproject.controller.studentController;

import com.example.finalproject.model.JwtRequest;
import com.example.finalproject.model.studentDTO.DAOStudent;
import com.example.finalproject.model.studentDTO.SearchRequest;
import com.example.finalproject.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public ResponseEntity<Iterable<DAOStudent>> getAllStudent(@RequestBody SearchRequest bodyRequest) throws Exception{

        return ResponseEntity.ok(studentService.SearchStudent(bodyRequest));
    }


}
