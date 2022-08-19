package com.barclays.webpage.barclaysweb.security;

import com.barclays.webpage.barclaysweb.domain.User;
import com.barclays.webpage.barclaysweb.dto.Forms;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class SecurityPasswordMng {

    public static boolean credentialsCheck(Forms.LoginForm loginForm, User user){
        return (BCrypt.checkpw(loginForm.getPassword(),user.getPassword()) && user.getEmail().equals(loginForm.getEmail()));
    }

    public static String passwordEncrypt(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
