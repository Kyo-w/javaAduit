package com.study.repository;

import com.study.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="test")
public interface TestRepository extends JpaRepository<Test, Integer> {
    Optional<Test> findById(@Param("id")Integer id);
}
