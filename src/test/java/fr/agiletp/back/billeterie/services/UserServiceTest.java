package fr.agiletp.back.billeterie.services;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Test le bon fonctionnement de la méthode login()")
    void testLogin() throws Exception {
        createUser();
        // When
        User user = userService.login("test@gmail.com", "123456");
        // Then
        assertNotNull(user);
    }

    @Test
    @DisplayName("Test de la méthode login() avec un email incorrect")
    void testLoginWithIncorrectEmail() {
        createUser();
        // When
        Exception exception = assertThrows(Exception.class, () -> {
            userService.login("incorrect@gmail.com", "123456");
        });
        // Then
        assertEquals("Utilisateur introuvable", exception.getMessage());
    }

    @Test
    @DisplayName("Test de la méthode login() avec un mot de passe incorrect")
    void testLoginWithIncorrectPassword() {
        createUser();
        // When
        Exception exception = assertThrows(Exception.class, () -> {
            userService.login("test@gmail.com", "incorrect");
        });
        // Then
        assertEquals("Utilisateur introuvable", exception.getMessage());
    }

    // Test de la méthode de création d'un utilisateur

    public void createUser() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("123456");
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setAdmin(Boolean.FALSE);
        userRepository.save(user);
    }

}