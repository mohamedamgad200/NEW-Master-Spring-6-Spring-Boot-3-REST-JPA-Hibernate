package com.eazybytes.eazyschool.repository;

import com.eazybytes.eazyschool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
    //Descending Order
    List<Courses> findByOrderByNameDesc();
    //Ascending Order
    List<Courses> findByOrderByName();
}
