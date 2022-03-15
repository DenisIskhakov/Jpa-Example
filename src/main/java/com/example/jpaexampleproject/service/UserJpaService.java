package com.example.jpaexampleproject.service;

import com.example.jpaexampleproject.model.Users;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Repository
public class UserJpaService {
    @PersistenceContext
    EntityManager entityManager;

    public List<Users> findAllSQL() {
        return entityManager.createNativeQuery("SELECT * FROM users", Users.class).getResultList();
    }

    public List<Users> findByIdUsersSQL(){
        return entityManager.createNativeQuery("select * from users name =?1", Users.class).getResultList();
    }

}
