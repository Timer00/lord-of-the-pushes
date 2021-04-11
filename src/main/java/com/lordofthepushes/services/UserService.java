package com.lordofthepushes.services;

import com.lordofthepushes.data.UserData;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void saveUser(UserData userData);
    void updateUser(UserData userData);
    void deleteUser(Long userId);
    UserData getUserById(Long userId);
    Iterable<UserData> getAllUsers();
    Iterable<UserData> getAllUsers(Pageable page);

}
