//package com.barclays.webpage.barclaysweb.repositories;
//
//import com.barclays.webpage.barclaysweb.controllers.Forms;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//
//@Repository
//@Qualifier("UserRepositoryInMemory")
//public class UserRepositoryInMemory implements IUserRepository {
//    ArrayList<Forms.User> userDB= new ArrayList<>();
//
//    public UserRepositoryInMemory() {
//        //Synthetic DB population
//        Forms.User user1 = new Forms.User("Fede","wagner","f@gmail.com", "1234");
//        Forms.User user2 = new Forms.User("Juan","Ramirez","juan@gmail.com","1234");
//        userDB.add(user1);
//        userDB.add(user2);
//    }
//    @Override
//    public ArrayList<Forms.User> getAllDB(){
//        return userDB;
//    }
//
//    @Override
//    public Forms.User getUserByEmail(String email){
//        return userDB.stream()
//                .filter( user ->email.equals(user.getEmail()))
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public Forms.User getUserByID(int id){
//        return userDB.stream()
//                .filter( user -> user.getId() == id)
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public Forms.User insertNewUser(Forms.RegisterForm registerForm){
//        Forms.User newUser = new Forms.User(registerForm);
//        userDB.add(newUser);
//        return newUser;
//    }
//
//    @Override
//    public Forms.User modifyUserDB(Forms.RegisterForm registerForm , Forms.User target){
//        target.email = registerForm.getEmail();
//        target.password = registerForm.getPassword();
//        target.firstName = registerForm.getFirstName();
//        target.lastName = registerForm.getLastName();
//        userDB.set(userDB.indexOf(target), target);
//        return target;
//    }
//
//    @Override
//    public Forms.User deleteUserDB(Forms.User target){
//        userDB.remove(target);
//        return target;
//    }
//}
