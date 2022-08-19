package com.barclays.webpage.barclaysweb.controllers;
import com.barclays.webpage.barclaysweb.domain.User;
import com.barclays.webpage.barclaysweb.dto.Forms;
import com.barclays.webpage.barclaysweb.dto.Response;
import com.barclays.webpage.barclaysweb.security.SecurityPasswordMng;
import com.barclays.webpage.barclaysweb.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    public final IUserServices iUserServices;
    @Autowired
    public UserController(IUserServices iUserServices){
        this.iUserServices = iUserServices;
    }

//
//    @GetMapping("/test/1")
//    public String setCookie(HttpServletResponse response) {
//        // create a cookie
//        Cookie cookie = new Cookie("username", "Jovan");
//        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//        cookie.setSecure(true);
//        cookie.setHttpOnly(true);
//        //add cookie to response
//        response.addCookie(cookie);
//
//        return "Cockie test";
//    }
//
//    @GetMapping("test/2")
//    public String readCookie(@CookieValue(value = "username", defaultValue = "Atta") String username) {
//        return "Hey! My username is " + username;
//    }
//    @GetMapping("test/3")
//    public String deleteCookie(HttpServletResponse response) {
//        // create a cookie
//        Cookie cookie = new Cookie("username", null);
//        cookie.setMaxAge(0);
//        cookie.setSecure(true);
//        cookie.setHttpOnly(true);
//        //add cookie to response
//        response.addCookie(cookie);
//
//        return "deleteCookie";
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> userData(@PathVariable(name="id") int id){
        Optional<User> userData = iUserServices.getUserByID(id);
        if(userData.isPresent()){
            return new ResponseEntity<>(Response.getResponse(true, userData.get(),0), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(true, null,500),HttpStatus.OK );
        }
    }

    @PutMapping("/{id}/modify")
    public ResponseEntity<?> modify(@PathVariable(name="id") int id,
                                    @RequestBody Forms.RegisterFormDAO registerForm){
        Optional<User> targetOptional = iUserServices.getUserByID(id);
        if (targetOptional.isPresent()){
            User modUser = targetOptional.get();
            modUser.setFirstname(registerForm.getFirstName() == null? modUser.getFirstname() : registerForm.getFirstName());
            modUser.setLastname(registerForm.getLastName() == null? modUser.getLastname() : registerForm.getLastName());
            modUser.setEmail(registerForm.getEmail() == null? modUser.getEmail() : registerForm.getEmail());
            modUser.setPassword(registerForm.getPassword() == null? modUser.getPassword() : registerForm.getPassword());
            iUserServices.save(modUser);
            return new ResponseEntity<>(Response.getResponse(true, modUser,0), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(false, null, 400),HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id,
                                    @RequestBody Forms.LoginFormDAO loginForm){
        Optional<User> target = iUserServices.getUserByID(id);
        if (target.isPresent() && SecurityPasswordMng.credentialsCheck(loginForm, target.get())){
            iUserServices.deleteUserDB(target.get());
            return new ResponseEntity<>(Response.getResponse(true, null,0), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(false, null, 300),HttpStatus.BAD_REQUEST );
        }
    }
}
