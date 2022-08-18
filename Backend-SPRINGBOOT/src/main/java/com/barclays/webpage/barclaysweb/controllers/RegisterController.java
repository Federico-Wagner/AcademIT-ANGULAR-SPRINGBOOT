package com.barclays.webpage.barclaysweb.controllers;

import com.barclays.webpage.barclaysweb.domain.User;
import com.barclays.webpage.barclaysweb.dto.Forms;
import com.barclays.webpage.barclaysweb.dto.Response;
import com.barclays.webpage.barclaysweb.services.IUserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/API/V1")
public class RegisterController {

    public final IUserServices iUserServices;
    private static final Logger LOGGER = Logger.getLogger( RegisterController.class.getName());

    public RegisterController(IUserServices iUserServices) {
        this.iUserServices = iUserServices;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Forms.RegisterForm registerForm){
        System.out.println("executing api/v1/register");
        if(registerForm.check()){
            if(!this.iUserServices.getUserByEmail(registerForm.getEmail()).isPresent()){
                LOGGER.log(Level.INFO, "NEW user registered: " + registerForm.getLogInfo());
                User newUser = this.iUserServices.save(new User(registerForm));
                return new ResponseEntity<>(Response.getResponse(true, newUser,0), HttpStatus.OK );
            }else{ //email is in use
                return new ResponseEntity<>(Response.getResponse(false, null, 200),HttpStatus.OK );
            }
        }else { //register form is wrong (missing field or password mismatch)
            return new ResponseEntity<>(Response.getResponse(false, null,100),HttpStatus.OK );
        }

    }
}
