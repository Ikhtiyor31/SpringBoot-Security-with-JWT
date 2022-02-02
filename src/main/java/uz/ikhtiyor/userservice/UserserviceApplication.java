package uz.ikhtiyor.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.ikhtiyor.userservice.model.Role;
import uz.ikhtiyor.userservice.model.User;
import uz.ikhtiyor.userservice.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Hasan Jurayev", "hasan", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Ikhtiyor Abduazizov", "ikhtiyor", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold", "12345", new ArrayList<>()));

			userService.addRoleToUser("hasan", "ROLE_USER");
			userService.addRoleToUser("hasan", "ROLE_MANAGER");
			userService.addRoleToUser("Ikhtiyor", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_USER");
		};
	}
}
