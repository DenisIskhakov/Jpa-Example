package com.example.jpaexampleproject.reposotory;


import com.example.jpaexampleproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    @Query(nativeQuery = true,value = "select * from users where id=?1") //sql
    Optional<Users> findById(Long id);

    @Query(value = "select * from users" , nativeQuery = true) // sql
    List<Users> findAll();

    @Query(value = "select u from Users u where u.work= :work") //jpql
    List<Users> findByWork(@Param("work")String work);
//    List<Users> findByWork();

//    @Query("select com.example.jpaexampleproject.model.Users(u.work) from Users as u")
//    List<Users> findByWorkJPQL();
}
