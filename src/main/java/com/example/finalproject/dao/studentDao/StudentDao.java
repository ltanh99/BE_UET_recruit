package com.example.finalproject.dao.studentDao;

import com.example.finalproject.model.studentDTO.DAOStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends CrudRepository<DAOStudent, Integer> {

}
