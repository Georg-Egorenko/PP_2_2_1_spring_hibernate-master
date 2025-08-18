package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Toyota", 1)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Honda", 2)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW", 3)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Audi", 4)));

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
