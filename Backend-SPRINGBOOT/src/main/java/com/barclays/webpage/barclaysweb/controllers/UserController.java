package com.barclays.webpage.barclaysweb.controllers;
import com.barclays.webpage.barclaysweb.domain.Users;
import com.barclays.webpage.barclaysweb.dto.Forms;
import com.barclays.webpage.barclaysweb.dto.Response;
import com.barclays.webpage.barclaysweb.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    public final IUserServices iUserServices;
    @Autowired
    public UserController(IUserServices iUserServices){
        this.iUserServices = iUserServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> userData(@PathVariable(name="id") int id){
        Optional<Users> userData = iUserServices.getUserByID(id);
        if(userData.isPresent()){
            return new ResponseEntity<>(Response.getResponse(true, userData.get(),0),HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(true, null,500),HttpStatus.OK );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Forms.LoginForm loginForm){
        return iUserServices.login(loginForm);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Forms.RegisterForm registerForm){
        return iUserServices.register(registerForm);
    }

    @PutMapping("/{id}/modify")
    public ResponseEntity<?> modify(@PathVariable(name="id") int id,
                                    @RequestBody Forms.RegisterForm registerForm){
        return iUserServices.modifyUser(id, registerForm);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id,
                                    @RequestBody Forms.LoginForm loginForm){
        return iUserServices.deleteUserDB(id, loginForm);
    }
}
