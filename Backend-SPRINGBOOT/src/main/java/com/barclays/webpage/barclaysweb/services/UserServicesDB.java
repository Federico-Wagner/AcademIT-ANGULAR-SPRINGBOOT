package com.barclays.webpage.barclaysweb.services;
import com.barclays.webpage.barclaysweb.controllers.Forms;
import com.barclays.webpage.barclaysweb.domain.Users;
import com.barclays.webpage.barclaysweb.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServicesDB implements IUserServices{

    private final IUserRepository iUserRepository;

    public UserServicesDB(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public ArrayList<Users> getAllDB(){
        return iUserRepository.getAllDB();
    }

    @Override
    public Users getUserByEmail(String email){
        return this.iUserRepository.getUserByEmail(email);
    }

    @Override
    public Optional<Users> getUserByID(int id){
        return this.iUserRepository.getUserByID(id);
    }

    @Override
    public Users insertNewUser(Forms.RegisterForm registerForm){
        return this.iUserRepository.save(new Users(registerForm));
    }

    @Override
    public Users modifyUserDB(int id, Forms.RegisterForm registerForm , Optional<Users> targetOptional){
        Users modUser = targetOptional.get();
        modUser.setFirstname(registerForm.getFirstName());
        modUser.setLastname(registerForm.getLastName());
        modUser.setEmail(registerForm.getEmail());
        modUser.setPassword(registerForm.getPassword());
        this.iUserRepository.save(modUser);
        return modUser;
    }

    @Override
    public void deleteUserDB(Users target) {
        this.iUserRepository.delete(target);
    }
}
