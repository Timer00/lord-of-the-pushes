package com.lordofthepushes.lordofthepushes.services;

import com.lordofthepushes.dao.user.UserDAO;
import com.lordofthepushes.data.UserData;
import com.lordofthepushes.services.user.impl.DefaultUserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DefaultUserServiceUnitTest {

    private UserDAO userDAO;
    private UserData userData;
    private DefaultUserService userService;

    @BeforeEach
    public void setUp() {
        userDAO = mock(UserDAO.class);
        assertNotNull(userDAO);
        userService = new DefaultUserService();
        userService.setUserDAO(userDAO);
        userData = new UserData();
        userData.setUser_id(1L);
        userData.setFirst_name("Vinícus");
        userData.setEmail("viniciusmarc_@hotmail.com");
        userData.setPassword("qwe123");
    }

    @Test
    public void testGetUserById() {
        when(userDAO.findById(2)).thenReturn(java.util.Optional.ofNullable(userData));
        final UserData result = userService.getUserById(2);
        System.out.println("result: " + result.getFirst_name() + "\nuserData: " + userData.getFirst_name());
        assertEquals(userData, result);
    }
}
