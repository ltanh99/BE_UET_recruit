package com.example.finalproject.controller;

import java.util.Objects;

import com.example.finalproject.config.JwtTokenUtil;
import com.example.finalproject.dao.UserDao;
import com.example.finalproject.model.*;
import com.example.finalproject.model.studentDTO.DAOStudent;
import com.example.finalproject.model.studentDTO.SearchRequest;
import com.example.finalproject.service.JwtUserDetailsService;
import com.example.finalproject.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//        DAOUser ExistUser = userDao.findByUsername(authenticationRequest.getUsername());
//        Iterable<DAOStudent> student = studentService.SearchStudent(new SearchRequest(ExistUser.studentid));
//        UserResponse userResponse = new UserResponse();
//        userResponse.students = student;
//        userResponse.token = token;
//        return ResponseEntity.ok(userResponse);
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
