package com.barclays.webpage.barclaysweb.controllers;
import com.barclays.webpage.barclaysweb.dto.Response;
import com.barclays.webpage.barclaysweb.services.IAdminServices;
import com.barclays.webpage.barclaysweb.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

    public final IAdminServices iAdminServices;

    @Autowired
    public AdminController(IAdminServices iAdminServices){
            this.iAdminServices = iAdminServices;
    }

    //TEST
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        System.out.println("API test was executed");
        return new ResponseEntity<>(Response.getResponse(true, null,0),HttpStatus.OK );
    }
    @GetMapping("/users")
    public ResponseEntity<?> userList(){return iAdminServices.getAllDB();}
}

