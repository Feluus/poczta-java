package test;

import model.UserProfile;
import org.junit.jupiter.api.Test;
import service.UserProfileService;

import static org.junit.jupiter.api.Assertions.*;

public class UserProfileServiceTest {

    @Test
    void shouldSaveNewProfile() {

        UserProfileService service =
                new UserProfileService();

        String login =
                "testProfile" + System.currentTimeMillis();

        UserProfile profile =
                new UserProfile(
                        login,
                        "Jan",
                        "Kowalski",
                        "Kielce",
                        "123123123"
                );

        service.saveProfile(profile);

        UserProfile loaded =
                service.getProfile(login);

        assertNotNull(loaded);
    }

    @Test
    void shouldLoadCorrectData() {

        UserProfileService service =
                new UserProfileService();

        String login =
                "testProfile" + System.currentTimeMillis();

        UserProfile profile =
                new UserProfile(
                        login,
                        "Adam",
                        "Nowak",
                        "Warszawa",
                        "999888777"
                );

        service.saveProfile(profile);

        UserProfile loaded =
                service.getProfile(login);

        assertEquals("Adam", loaded.firstName);
        assertEquals("Nowak", loaded.lastName);
        assertEquals("Warszawa", loaded.address);
        assertEquals("999888777", loaded.phone);
    }

    @Test
    void shouldUpdateExistingProfile() {

        UserProfileService service =
                new UserProfileService();

        String login =
                "testProfile" + System.currentTimeMillis();

        service.saveProfile(
                new UserProfile(
                        login,
                        "Jan",
                        "Kowalski",
                        "Kielce",
                        "111111111"
                )
        );

        service.saveProfile(
                new UserProfile(
                        login,
                        "Jan",
                        "Kowalski",
                        "Kraków",
                        "222222222"
                )
        );

        UserProfile loaded =
                service.getProfile(login);

        assertEquals(
                "Kraków",
                loaded.address
        );

        assertEquals(
                "222222222",
                loaded.phone
        );
    }

    @Test
    void shouldReturnNullForUnknownUser() {

        UserProfileService service =
                new UserProfileService();

        UserProfile profile =
                service.getProfile(
                        "nieIstnieje123456"
                );

        assertNull(profile);
    }
}