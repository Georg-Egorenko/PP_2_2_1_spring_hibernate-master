package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import java.util.List;

public interface UserDao {
   void addUser(User user);
   void updateUser(User user);
   List<User> listUsers();
   void addCar(Car car);
   List<Car> listCars();
   User findUserByCar(String model, int series);
}