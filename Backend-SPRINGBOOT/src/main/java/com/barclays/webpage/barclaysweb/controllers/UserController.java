package com.barclays.webpage.barclaysweb.controllers;
import com.barclays.webpage.barclaysweb.domain.Users;
import com.barclays.webpage.barclaysweb.services.IUserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    public final IUserServices iUserServices;
    public UserController(IUserServices iUserServices){
        this.iUserServices = iUserServices;
    }

    //TEST
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        System.out.println("API test was executed");

        Optional<Users> user = iUserServices.getUserByID(1);
        Users userSend = user.get();
        System.out.println(userSend);
        return new ResponseEntity<>(userSend, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> userList(){
        ArrayList<Users> allDB = iUserServices.getAllDB();
        return new ResponseEntity<>(Response.getResponse(true, allDB,0),HttpStatus.OK );
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
        if(loginForm.getEmail() == null || loginForm.getPassword() == null){        //Email or Passwords sent check
            return new ResponseEntity<>(Response.getResponse(false, null,100),HttpStatus.OK );
        }else {
            Users target = iUserServices.getUserByEmail(loginForm.getEmail());
            if(target != null && target.credentialsCheck(loginForm)){
                return new ResponseEntity<>(Response.getResponse(true, target,0),HttpStatus.OK );
            }else{
                return new ResponseEntity<>(Response.getResponse(false, null, 300),HttpStatus.OK );
            }
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Forms.RegisterForm registerForm){
        if(registerForm.check()){
            if(iUserServices.getUserByEmail(registerForm.getEmail()) == null){
                Users newUser = iUserServices.insertNewUser(registerForm);
                return new ResponseEntity<>(Response.getResponse(true, newUser,0),HttpStatus.OK );
            }else{ //email is in use
                return new ResponseEntity<>(Response.getResponse(false, null, 200),HttpStatus.OK );
            }
        }else { //register form is wrong (missing field or password mismatch)
            return new ResponseEntity<>(Response.getResponse(false, null,100),HttpStatus.OK );
        }
    }

    @PutMapping("/{id}/modify")
    public ResponseEntity<?> modify(@PathVariable(name="id") int id,
                                    @RequestBody Forms.RegisterForm registerForm){
        Optional<Users> targetOptional = iUserServices.getUserByID(id);
        if (targetOptional.isPresent()){
            Users targetOptionalMod = iUserServices.modifyUserDB(id, registerForm, targetOptional);
            return new ResponseEntity<>(Response.getResponse(true, targetOptionalMod,0), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(false, null, 400),HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id,
                                    @RequestBody Forms.LoginForm loginForm){
        Optional<Users> target = iUserServices.getUserByID(id);
        if (target.isPresent() && target.get().credentialsCheck(loginForm)){
            System.out.println("eliminando: " + id + target.get());
            iUserServices.deleteUserDB(target.get());
            return new ResponseEntity<>(Response.getResponse(true, null,0), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(false, null, 300),HttpStatus.BAD_REQUEST );
        }
    }
}
