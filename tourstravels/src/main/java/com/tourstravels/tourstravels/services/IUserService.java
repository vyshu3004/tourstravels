package com.tourstravels.tourstravels.services;

import com.tourstravels.tourstravels.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAll(User user);

    User findByEmailAndPassword(String email,String password);

    User getById(Long id);
    User saveUser(User user);
    void deleteById(Long id);

}
