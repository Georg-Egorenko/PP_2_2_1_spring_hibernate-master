package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addUserOnly(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.addUserOnly(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.addUserOnly(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.addUserOnly(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.addCar(new Car("Toyota", 1));
      userService.addCar(new Car("Honda", 2));
      userService.addCar(new Car("BMW", 3));
      userService.addCar(new Car("Audi", 4));

      List<User> users = userService.getAllUsers();
      List<Car> cars = userService.getAllCars();

      for (int i = 0; i < users.size(); i++) {
         User user = users.get(i);
         Car car = cars.get(i);
         user.setCar(car);
         userService.updateUser(user);
      }



      System.out.println("=== Все пользователи ===");
      userService.listUsers().forEach(user -> {
         System.out.println(user.getFirstName() + " " + user.getLastName());
         System.out.println("Машина: " + user.getCar().getModel() + " (" + user.getCar().getSeries() + ")");
         System.out.println();
      });

      System.out.println("=== Поиск пользователя ===");
      User user = userService.findUserByCarModelAndSeries("Honda", 2);
      System.out.println(user != null ? "Найден: " + user.getFirstName() : "Не найден");

      context.close();
   }
}
