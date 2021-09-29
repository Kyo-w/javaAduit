package com.study.repository;
import com.study.entity.User;
import com.study.entity.UserVirtual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

//@RepositoryRestResource(path="users",  excerptProjection= UserVirtual.class)
//@RepositoryRestResource(path="users")
public interface UserRepository
    extends JpaRepository<User, Long> {
    @RestResource(path= "names", rel = "namess")
    public User findByName(@Param("name")String name);
}