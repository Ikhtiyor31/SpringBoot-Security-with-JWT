package uz.ikhtiyor.userservice.service;

import uz.ikhtiyor.userservice.model.Role;
import uz.ikhtiyor.userservice.model.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
