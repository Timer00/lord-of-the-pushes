package com.lordofthepushes.user.services;

import com.lordofthepushes.user.data.UserData;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface UserService {
    void saveUser(UserData userData);
    void updateUser(UserData userData);
    void deleteUser(Integer userId);
    UserData getUserById(Integer userId);
    Iterable<UserData> getAllUsers();
    Iterable<UserData> getAllUsers(Pageable page);

}
