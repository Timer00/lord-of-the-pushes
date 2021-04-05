package com.lordofthepushes.services.user;

import com.lordofthepushes.data.UserData;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void saveUser(UserData userData);
    void updateUser(UserData userData);
    void deleteUser(Integer userId);
    UserData getUserById(Integer userId);
    Iterable<UserData> getAllUsers();
    Iterable<UserData> getAllUsers(Pageable page);

}
