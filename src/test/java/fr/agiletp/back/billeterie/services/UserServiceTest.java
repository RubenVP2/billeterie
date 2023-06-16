package fr.agiletp.back.billeterie.services;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        this.createUser();
    }

    @Test
    @DisplayName("Test le bon fonctionnement de la méthode login()")
    void testLogin() throws Exception {
        // When
        User user = userService.login("test@gmail.com", "123456");
        // Then
        assertNotNull(user);
    }

    @Test
    @DisplayName("Test de la méthode login() avec un email incorrect")
    void testLoginWithIncorrectEmail() {
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
        // When
        Exception exception = assertThrows(Exception.class, () -> {
            userService.login("test@gmail.com", "incorrect");
        });
        // Then
        assertEquals("Utilisateur introuvable", exception.getMessage());
    }

    // Test de la méthode de création d'un utilisateur
    @Test
    @DisplayName("Test le bon fonctionnement de la méthode createUser()")
    void testCreateUser() {
        // Given
        User user = new User();
        user.setEmail("newuser@gmail.com");
        user.setPassword("password");
        user.setFirstName("New");
        user.setLastName("User");
        user.setAdmin(Boolean.FALSE);
        // When
        User newUser = userService.create(user);
        // Then
        assertEquals(user, newUser);
    }

    @Test
    @DisplayName("Test de la méthode createUser() avec un email déjà existant")
    void testCreateUserWithExistingEmail() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("123456");
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setAdmin(Boolean.FALSE);
        // When
        Exception exception = assertThrows(Exception.class, () -> {
            userService.create(user);
        });
        // Then
        assertEquals("409 CONFLICT Un utilisateur existe déjà avec cet email", exception.getMessage().replace("\"", ""));
    }

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