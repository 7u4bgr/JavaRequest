package com.example.sqldatabasenew.repositary;

import com.example.sqldatabasenew.users.UsersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repositary extends JpaRepository<UsersData,Long> {
    @Query(value = "SELECT * FROM USERSDATA u WHERE u.surname=:surname",nativeQuery = true)
    List<UsersData> findBySurname(@Param("surname") String findSurname);
    @Query(value = "SELECT * FROM USERSDATA u WHERE u.name=:name",nativeQuery = true)
    List<UsersData> findByName(@Param("name") String findName);
    @Query(value = "SELECT * FROM USERSDATA u WHERE u.age=:age",nativeQuery = true)
    List<UsersData> findByAge(@Param("age") Integer findAge);
    @Query(value = "SELECT * FROM USERSDATA u WHERE u.name=:name AND u.surname=:surname AND u.age=:age",nativeQuery = true)
    List<UsersData> findAll(@Param("name") String filterName,@Param("surname") String filterSurname,@Param("age") Integer filterAge);



}

