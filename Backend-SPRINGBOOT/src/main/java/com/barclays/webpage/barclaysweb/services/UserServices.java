package com.barclays.webpage.barclaysweb.services;
import com.barclays.webpage.barclaysweb.dto.Forms;
import com.barclays.webpage.barclaysweb.domain.Users;
import com.barclays.webpage.barclaysweb.dto.Response;
import com.barclays.webpage.barclaysweb.repositories.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices implements IUserServices{
    private final IUserRepository iUserRepository;
    public UserServices(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public Optional<Users> getUserByID(int id){
        return this.iUserRepository.getUserByID(id);
    }

    @Override
    public ResponseEntity<?> userData(int id) {
        Optional<Users> userData = getUserByID(id);
        if(userData.isPresent()){
            return new ResponseEntity<>(Response.getResponse(true, userData.get(),0),HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(true, null,500),HttpStatus.OK );
        }
    }

    @Override
    public ResponseEntity<?> login(Forms.LoginForm loginForm) {
        if(loginForm.getEmail() == null || loginForm.getPassword() == null){        //Email or Passwords sent check
            return new ResponseEntity<>(Response.getResponse(false, null,100), HttpStatus.OK );
        }else {
            Users target = this.iUserRepository.getUserByEmail(loginForm.getEmail());
            if(target != null && target.credentialsCheck(loginForm)){
                return new ResponseEntity<>(Response.getResponse(true, target,0),HttpStatus.OK );
            }else{
                return new ResponseEntity<>(Response.getResponse(false, null, 300),HttpStatus.OK );
            }
        }
    }

    @Override
    public ResponseEntity<?> register(Forms.RegisterForm registerForm) {
        if(registerForm.check()){
            if(this.iUserRepository.getUserByEmail(registerForm.getEmail()) == null){
                Users newUser = this.iUserRepository.save(new Users(registerForm));
                return new ResponseEntity<>(Response.getResponse(true, newUser,0),HttpStatus.OK );
            }else{ //email is in use
                return new ResponseEntity<>(Response.getResponse(false, null, 200),HttpStatus.OK );
            }
        }else { //register form is wrong (missing field or password mismatch)
            return new ResponseEntity<>(Response.getResponse(false, null,100),HttpStatus.OK );
        }
    }

    @Override
    public ResponseEntity<?> modifyUser(int id, Forms.RegisterForm registerForm) {
        Optional<Users> targetOptional = getUserByID(id);
        if (targetOptional.isPresent()){
            Users modUser = targetOptional.get();
            modUser.setFirstname(registerForm.getFirstName());
            modUser.setLastname(registerForm.getLastName());
            modUser.setEmail(registerForm.getEmail());
            modUser.setPassword(registerForm.getPassword());
            this.iUserRepository.save(modUser);
            return new ResponseEntity<>(Response.getResponse(true, modUser,0), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(false, null, 400),HttpStatus.BAD_REQUEST );
        }
    }

    @Override
    public ResponseEntity<?> deleteUserDB(int id, Forms.LoginForm loginForm) {
        Optional<Users> target = getUserByID(id);
        if (target.isPresent() && target.get().credentialsCheck(loginForm)){
            this.iUserRepository.delete(target.get());
            return new ResponseEntity<>(Response.getResponse(true, null,0), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(Response.getResponse(false, null, 300),HttpStatus.BAD_REQUEST );
        }
    }
}
