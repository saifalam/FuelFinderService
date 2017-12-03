package com.fuelfinder.dao;

import java.io.Serializable;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fuelfinder.model.User;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Serializable> {

}
