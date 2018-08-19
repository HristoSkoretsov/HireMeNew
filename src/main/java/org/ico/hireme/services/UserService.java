package org.ico.hireme.services;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.models.binding.UserRegisterBindingModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    boolean createUser(UserRegisterBindingModel user);

    Set<User> getAllUsers();

    User findUserByUserName(String userName);

    void delete(User user);

    User getCurrentUser();
}
