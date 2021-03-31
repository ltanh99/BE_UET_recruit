package com.example.finalproject.dao.studentDao;

import com.example.finalproject.model.studentDTO.DAOStudent;
import com.example.finalproject.model.studentDTO.SearchRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Iterator;


@Repository
public interface StudentDao extends CrudRepository<DAOStudent, Integer> {
    @Query(nativeQuery = true, value = "SELECT *"
            + "FROM student a where a.name like %:#{#param.name}% or a.code = :#{#param.code} or a.id = :#{#param.id}")
    public Iterable<DAOStudent> FindByCategory(
            @Param("param") SearchRequest param
    );

//    @Query(nativeQuery = true, value = "SELECT *"
//            + "FROM student a where a.name like %:#{#param.name}% or a.code = :#{#param.code} or a.id = :#{#param.id}")
//    public Iterator<DAOStudent> FindByStudentCode(@Param("param") String param);

}
