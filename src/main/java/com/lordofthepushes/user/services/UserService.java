package com.lordofthepushes.user.services;

import com.lordofthepushes.user.data.UserData;

import java.util.Collection;

public interface UserService {
    void save(UserData user);
    void delete(UserData user);
    UserData getUserById(Integer userId);
    Iterable<UserData> getAllUsers();

}
