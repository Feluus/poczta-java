package Testy;

import org.junit.jupiter.api.Test;
import service.UserService;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void shouldRegisterUser() {

        UserService userService =
                new UserService();

        String login =
                "testUser" + System.currentTimeMillis();

        userService.register(
                login,
                "1234"
        );

        assertTrue(
                userService.loginExist(login)
        );
    }

    @Test
    void shouldLoginUser() {

        UserService userService =
                new UserService();

        String login =
                "testUser" + System.currentTimeMillis();

        userService.register(
                login,
                "1234"
        );

        assertTrue(
                userService.logging(
                        login,
                        "1234"
                )
        );
    }

    @Test
    void shouldRejectWrongPassword() {

        UserService userService =
                new UserService();

        String login =
                "testUser" + System.currentTimeMillis();

        userService.register(
                login,
                "1234"
        );

        assertFalse(
                userService.logging(
                        login,
                        "9999"
                )
        );
    }
}