package org.vaccine.vaccinationmanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.vaccine.vaccinationmanagementsystem.user.Role;
import org.vaccine.vaccinationmanagementsystem.user.User;
import org.vaccine.vaccinationmanagementsystem.user.UserRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        createAdminUser();
        createTestUser();
    }
    private void createAdminUser() {
        String adminEmail = "admin@vaccine.com";
        if (!userRepository.existsByEmail(adminEmail)) {
            User admin = new User();
            admin.setEmail(adminEmail);
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setFirstName("Admin");
            admin.setLastName("User");
            admin.setRole(Role.ADMIN);
            admin.setPhoneNumber("1234567890");
            admin.setAddress("Admin Address");
            admin.setCity("Admin City");
            admin.setState("Admin State");
            admin.setPincode("12345");
            userRepository.save(admin);
            System.out.println("✅ Admin created - Email: admin@vaccine.com, Password: admin123");
        } else {
            System.out.println("ℹ️ Admin already exists");
        }
    }
    private void createTestUser() {
        String testEmail = "user@test.com";
        if (!userRepository.existsByEmail(testEmail)) {
            User testUser = new User();
            testUser.setEmail(testEmail);
            testUser.setPassword(passwordEncoder.encode("user123"));
            testUser.setFirstName("Test");
            testUser.setLastName("User");
            testUser.setRole(Role.USER);
            testUser.setPhoneNumber("9876543210");
            testUser.setAddress("Test Address");
            testUser.setCity("Test City");
            testUser.setState("Test State");
            testUser.setPincode("54321");
            userRepository.save(testUser);
            System.out.println("✅ Test user created - Email: user@test.com, Password: user123");
        } else {
            System.out.println("ℹ️ Test user already exists");
        }
    }
}
