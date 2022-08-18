package com.barclays.webpage.barclaysweb.services;
import com.barclays.webpage.barclaysweb.domain.User;
import java.util.Optional;

public interface IUserServices {

    Optional<User> getUserByID(int id);

    Optional<User> getUserByEmail(String email);

    User save(User user);

    void deleteUserDB(User target);
}
