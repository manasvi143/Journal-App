package com.manasvi.Journal.App.service;

import com.manasvi.Journal.App.entity.Users;
import com.manasvi.Journal.App.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository user;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewEntry(Users myentry){
        myentry.setPassword(passwordEncoder.encode(myentry.getPassword()));
        myentry.setRoles(Arrays.asList("USER"));
        user.save(myentry);
    }

    public void saveEntry(Users myentry){
        user.save(myentry);
    }

    public List<Users> getAll(){
        return user.findAll();
    }

    public Optional<Users> getByID(ObjectId id){
        return user.findById(id);
    }

    public void deletebyId(ObjectId id){
        user.deleteById(id);
    }

    public Users findByusername(String username){
        return user.findByUsername(username);
    }

    public void saveNewAdmin(Users myentry){
        myentry.setPassword(passwordEncoder.encode(myentry.getPassword()));
        myentry.setRoles(Arrays.asList("USER" , "ADMIN"));
        user.save(myentry);
    }
}
