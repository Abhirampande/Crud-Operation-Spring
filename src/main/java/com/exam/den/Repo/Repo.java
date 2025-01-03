package com.exam.den.Repo;

import com.exam.den.Model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Model, Long> {

    List<Model> findByAgeGreaterThan(int age);
}
