package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import java.util.List;

public interface UserService {
    void addUserOnly(User user);
    void updateUser(User user);

    List<User> listUsers();
    void addCar(Car car);

    List<Car> getAllCars();
    List<User> getAllUsers();
    User findUserByCarModelAndSeries(String model, int series);

}