package com.barclays.webpage.barclaysweb.repositories;
import com.barclays.webpage.barclaysweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Long> {
    //SELECT ALL
    @Query("select c from User c ")
    ArrayList<User> getAllDB();

    //SELECT BY ID
    @Query("select c from User c where c.id = ?1")
    Optional<User> getUserByID(int id);

    //SELECT BY EMAIL
    @Query("select c from User c where c.email = ?1")
    Optional<User> getUserByEmail(String email);
}
