package com.barclays.webpage.barclaysweb.controllers;

import com.barclays.webpage.barclaysweb.domain.User;
import com.barclays.webpage.barclaysweb.dto.Forms;
import com.barclays.webpage.barclaysweb.dto.Response;
import com.barclays.webpage.barclaysweb.services.IUserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/V1")
public class LoginControler {

    public final IUserServices iUserServices;
    private static final Logger LOGGER = Logger.getLogger( RegisterController.class.getName());

    public LoginControler(IUserServices iUserServices) {
        this.iUserServices = iUserServices;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Forms.LoginForm loginForm){

        if(loginForm.getEmail() == null || loginForm.getPassword() == null){        //Email or Passwords sent check
            return new ResponseEntity<>(Response.getResponse(false, null,100), HttpStatus.OK );
        }else {
            Optional<User> target = this.iUserServices.getUserByEmail(loginForm.getEmail());
            if(target.isPresent() && target.get().credentialsCheck(loginForm)){
                return new ResponseEntity<>(Response.getResponse(true, target,0),HttpStatus.OK );
            }else{
                return new ResponseEntity<>(Response.getResponse(false, null, 300),HttpStatus.OK );
            }
        }
    }
}
