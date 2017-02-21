package akatomakhin.apps.usermanager.dao;

import akatomakhin.apps.usermanager.entity.User;

import java.util.ArrayList;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public interface UserDAO
{
    User getUser(int id);
    void createUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    ArrayList<User> getAllUsers();
}
