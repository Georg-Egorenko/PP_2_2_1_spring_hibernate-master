package hiber.dao;

import hiber.model.User;
import java.util.List;

public interface UserDao {
   void addUser(User user);
   void updateUser(User user);
   List<User> listUsers();
   User findUserByCar(String model, int series);
}