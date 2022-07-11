package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Oleg", "Pisanov", "oleg@gmail.com", new Car("BMW", 5)));
      userService.add(new User("Dima", "Dubov", "dima@gmail.com", new Car("Audi", 7)));
      userService.add(new User("Vadik", "Petrov", "vadik@gmail.com", new Car("Vaz", 2110)));
      userService.add(new User("Slava", "Artemov", "slava@mail.ru", new Car("Kia", 2)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      context.close();
   }
}
