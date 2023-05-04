package com.tourstravels.tourstravels.services.impl;


import com.tourstravels.tourstravels.models.User;
import com.tourstravels.tourstravels.repos.UsersRepository;
import com.tourstravels.tourstravels.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UsersRepository usersRepository;


    @Override
    public List<User> getAll(User user) {
        return usersRepository.findAll();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return usersRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User getById(Long id) {
        return usersRepository.findById(id).get();
    }

    public User saveUser(User user) {
       return usersRepository.save(user);
    }
    public  void  deleteById(Long id){
        usersRepository.deleteById(id);
    }

}

