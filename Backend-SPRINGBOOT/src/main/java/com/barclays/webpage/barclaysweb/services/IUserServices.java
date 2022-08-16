package com.barclays.webpage.barclaysweb.services;
import com.barclays.webpage.barclaysweb.dto.Forms;
import com.barclays.webpage.barclaysweb.domain.Users;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;


public interface IUserServices {
    ResponseEntity<?> getAllDB();

    Optional<Users> getUserByID(int id);

    ResponseEntity<?> login(Forms.LoginForm loginForm);

    ResponseEntity<?> register(Forms.RegisterForm registerForm);

    ResponseEntity<?> modifyUserDB(int id, Forms.RegisterForm registerForm);

    ResponseEntity<?> deleteUserDB(int id, Forms.LoginForm loginForm);
}
