package com.barclays.webpage.barclaysweb.repositories;
import com.barclays.webpage.barclaysweb.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<Users, Long> {
    //SELECT BY EMAIL
    @Query("select c from Users c where c.email = ?1")
    Users getUserByEmail(String email);
    //SELECT ALL
    @Query("select c from Users c ")
    ArrayList<Users> getAllDB();
    //SELECT BY ID
    @Query("select c from Users c where c.id = ?1")
    Optional<Users> getUserByID(int id);
}
