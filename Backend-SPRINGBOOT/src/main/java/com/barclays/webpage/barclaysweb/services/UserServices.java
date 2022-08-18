package com.barclays.webpage.barclaysweb.services;
import com.barclays.webpage.barclaysweb.domain.User;
import com.barclays.webpage.barclaysweb.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServices implements IUserServices{
    private final IUserRepository iUserRepository;
    public UserServices(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public Optional<User> getUserByID(int id){
        return this.iUserRepository.getUserByID(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return this.iUserRepository.getUserByEmail(email);
    }

    @Override
    public User save(User user) {
        return this.iUserRepository.save(user);
    }

    @Override
    public void deleteUserDB(User target) {
        this.iUserRepository.delete(target);
    }
}
