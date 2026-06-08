package test;

import model.PackageData;
import org.junit.jupiter.api.Test;
import service.PackageService;

import static org.junit.jupiter.api.Assertions.*;

public class PackageServiceTest {

    @Test
    void shouldAddPackage() {

        PackageService service =
                new PackageService();

        PackageData pack =
                new PackageData(
                        "testUser",
                        "Jan Kowalski",
                        "Kielce",
                        "Testowa 1",
                        "111111111",
                        "222222222",
                        "B",
                        "PP123456",
                        "Nowa"
                );

        service.addPackage(pack);

        PackageData found =
                service.findPackage(
                        "PP123456",
                        "111111111"
                );

        assertNotNull(found);
    }

    @Test
    void shouldFindPackageByReceiverPhone() {

        PackageService service =
                new PackageService();

        PackageData pack =
                new PackageData(
                        "testUser",
                        "Adam Nowak",
                        "Warszawa",
                        "Test 2",
                        "111111111",
                        "999999999",
                        "A",
                        "PP999999",
                        "W drodze"
                );

        service.addPackage(pack);

        PackageData found =
                service.findPackage(
                        "PP999999",
                        "999999999"
                );

        assertNotNull(found);
    }

    @Test
    void shouldReturnNullForWrongPackage() {

        PackageService service =
                new PackageService();

        PackageData found =
                service.findPackage(
                        "NIEISTNIEJE",
                        "123123123"
                );

        assertNull(found);
    }
}