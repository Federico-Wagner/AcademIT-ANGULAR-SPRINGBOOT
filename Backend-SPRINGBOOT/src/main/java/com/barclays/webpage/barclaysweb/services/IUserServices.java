package com.barclays.webpage.barclaysweb.services;
import com.barclays.webpage.barclaysweb.controllers.Forms;
import com.barclays.webpage.barclaysweb.domain.Users;
import java.util.ArrayList;
import java.util.Optional;

public interface IUserServices {
    public ArrayList<Users> getAllDB();
    public Users getUserByEmail(String email);

    public Optional<Users> getUserByID(int id);

    public Users insertNewUser(Forms.RegisterForm registerForm);

    public Users modifyUserDB(int id, Forms.RegisterForm registerForm , Optional<Users> target);

    public void deleteUserDB(Users target);
}
