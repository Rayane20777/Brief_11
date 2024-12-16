package com.example.brief_11;

import com.example.brief_11.entity.Role;
import com.example.brief_11.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Brief11Application implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Brief11Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createRoleIfNotExists("ADMIN");
		createRoleIfNotExists("USER");
	}

	private void createRoleIfNotExists(String roleName) {
		if (!roleRepository.existsByName(roleName)) {
			Role role = new Role();
			role.setName(roleName);
			roleRepository.save(role);
			System.out.println("Role " + roleName + " created.");
		} else {
			System.out.println("Role " + roleName + " already exists.");
		}
	}
}