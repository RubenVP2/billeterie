package fr.agiletp.back.billeterie.services;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    final static private String FILENAME = "application-test.yml";

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        this.createUser();
    }

    // Connexion de l'utilisateur
    @Test
    @DisplayName("Test le bon fonctionnement de la méthode login()")
    void testLogin() throws Exception {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME)) {
            // Given
            Map<String, Object> config = yaml.load(inputStream);
            String email = (String) config.get("email");
            String password = (String) config.get("password");
            // When
            User user = userService.login(email, password);
            // Then
            assertNotNull(user);
        }
    }

    @Test
    @DisplayName("Test de la méthode login() avec un email incorrect")
    void testLoginWithIncorrectEmail() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME)) {
            // Given
            Map<String, Object> config = yaml.load(inputStream);
            String email = (String) config.get("emailIncorrect");
            String password = (String) config.get("password");
            // When
            Exception exception = assertThrows(Exception.class, () -> {
                userService.login(email, password);
            });
            // Then
            assertEquals("Utilisateur introuvable, veuillez vérifier l'email ou le mot de passe.", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Test de la méthode login() avec un mot de passe incorrect")
    void testLoginWithIncorrectPassword() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME)) {
            // Given
            Map<String, Object> config = yaml.load(inputStream);
            String email = (String) config.get("email");
            String password = (String) config.get("passwordIncorrect");
            // When
            Exception exception = assertThrows(Exception.class, () -> {
                userService.login(email, password);
            });
            // Then
            assertEquals("Utilisateur introuvable, veuillez vérifier l'email ou le mot de passe.", exception.getMessage());
        }
    }

    // Test de la méthode de création d'un utilisateur
    @Test
    @DisplayName("Test le bon fonctionnement de la méthode createUser()")
    void testCreateUser() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME)) {
            // Given
            Map<String, Object> config = yaml.load(inputStream);
            User user = new User();
            user.setEmail((String) config.get("newUserEmail"));
            user.setPassword((String) config.get("newUserPassword"));
            user.setFirstName((String) config.get("newUserFirstName"));
            user.setLastName((String) config.get("newUserLastName"));
            user.setAdmin(Boolean.parseBoolean((String) config.get("newUserAdmin")));
            // When
            User newUser = userService.create(user);
            // Then
            assertEquals(user, newUser);
        }
    }

    @Test
    @DisplayName("Test de la méthode createUser() avec un email déjà existant")
    void testCreateUserWithExistingEmail() throws IOException{
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME)) {
            // Given
            Map<String, Object> config = yaml.load(inputStream);
            User user = new User();
            // La propriété email est une valeur déjà existante en base de données
            user.setEmail((String) config.get("email"));
            user.setPassword((String) config.get("newUserPassword"));
            user.setFirstName((String) config.get("newUserFirstName"));
            user.setLastName((String) config.get("newUserLastName"));
            user.setAdmin(Boolean.parseBoolean((String) config.get("newUserAdmin")));
            // When
            Exception exception = assertThrows(Exception.class, () -> {
                userService.create(user);
            });
            // Then
            assertEquals("409 CONFLICT Un utilisateur existe déjà avec cet email", exception.getMessage().replace("\"", ""));
        }
    }

    // Test sur la suppression d'un utilisateur
    @Test
    @DisplayName("Test le bon fonctionnement de la méthode deleteUser()")
    void testDeleteUser() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME)) {
            // Given
            Map<String, Object> config = yaml.load(inputStream);
            String email = (String) config.get("email");
            // When
            userService.deleteUser(email);
            // Then
            assertNull(userRepository.findByEmail("test@gmail.com"));
        }
    }

    @Test
    @DisplayName("Test de la méthode deleteUser() avec un email incorrect")
    void testDeleteUserWithIncorrectEmail() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILENAME)) {
            // Given
            Map<String, Object> config = yaml.load(inputStream);
            String email = (String) config.get("emmaiIncorrect");
            // When
            Exception exception = assertThrows(Exception.class, () -> {
                userService.deleteUser(email);
            });
            // Then
            assertEquals("404 NOT_FOUND Suppression impossible, utilisateur introuvable.", exception.getMessage().replace("\"", ""));
        }
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