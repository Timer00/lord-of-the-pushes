package com.lordofthepushes.user.facades;

import com.lordofthepushes.user.data.UserData;

import java.util.List;

public interface UserFacade {
    UserData saveUser(UserData userData);
    UserData getUserById(Integer id);
    List<UserData> getUsers();
}
