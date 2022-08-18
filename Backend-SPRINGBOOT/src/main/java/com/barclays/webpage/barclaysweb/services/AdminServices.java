package com.barclays.webpage.barclaysweb.services;
import com.barclays.webpage.barclaysweb.domain.User;
import com.barclays.webpage.barclaysweb.dto.Response;
import com.barclays.webpage.barclaysweb.repositories.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServices implements IAdminServices{

    private final IUserRepository iUserRepository;

    public AdminServices(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public ResponseEntity<?> getAllDB(){
        ArrayList<User> allDB = iUserRepository.getAllDB();
        return new ResponseEntity<>(Response.getResponse(true, allDB,0), HttpStatus.OK );
    }
}
