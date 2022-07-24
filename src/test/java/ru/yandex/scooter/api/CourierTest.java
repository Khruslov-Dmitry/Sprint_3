package ru.yandex.scooter.api;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.scooter.api.client.CourierClient;
import ru.yandex.scooter.api.model.CourierData;
import ru.yandex.scooter.api.util.CourierDataGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourierTest {

    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp() {

        courierClient = new CourierClient();
    }

    @After
    public void tearDown() {

        courierClient.deleteCourier(courierId);
    }

    @Test
    @DisplayName("Тест на создание нового курьера и последующий логин")
    public void checkCourierCreationAndLogin() {

        CourierDataGenerator newCourier = CourierDataGenerator.getRandomCourier();
        boolean created = courierClient.createCourier(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        courierId = courierClient.login(courierData);

        assertTrue(created);
    }

    @Test
    @DisplayName("Тест на невозможность создания 2 одинаковых курьеров")
    public void failToCreateCourierWithExistingData() {

        CourierDataGenerator newCourier = CourierDataGenerator.getRandomCourier();
        courierClient.createCourier(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        courierId = courierClient.login(courierData);

        String expected = "Этот логин уже используется. Попробуйте другой.";
        String actual = courierClient.createSameCourier(courierData);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест на проверку обязательности поля login при создании курьера")
    public void failToCreateCourierWithoutLogin() {

        CourierDataGenerator newCourierWithoutRequiredParameter = CourierDataGenerator.getRandomCourier();
        newCourierWithoutRequiredParameter.setLogin(null);
        String actual = courierClient.createCourierWithoutRequiredParameter(newCourierWithoutRequiredParameter);

        String expected = "Недостаточно данных для создания учетной записи";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест на проверку обязательности поля password при создании курьера")
    public void failToCreateCourierWithoutPassword() {

        CourierDataGenerator newCourierWithoutRequiredParameter = CourierDataGenerator.getRandomCourier();
        newCourierWithoutRequiredParameter.setPassword(null);
        String actual = courierClient.createCourierWithoutRequiredParameter(newCourierWithoutRequiredParameter);

        String expected = "Недостаточно данных для создания учетной записи";
        assertEquals(expected, actual);
    }

    // тест падает из-за ошибки документации API в части обязательности поля firstName
    @Test
    @DisplayName("Тест на проверку обязательности поля firstName при создании курьера")
    public void failToCreateCourierWithoutFirstName() {

        CourierDataGenerator newCourierWithoutRequiredParameter = CourierDataGenerator.getRandomCourier();
        newCourierWithoutRequiredParameter.setFirstName(null);
        String actual = courierClient.createCourierWithoutRequiredParameter(newCourierWithoutRequiredParameter);

        String expected = "Недостаточно данных для создания учетной записи";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест на проверку обязательности поля login при логине курьера")
    public void failToLoginCourierWithoutLogin() {

        CourierDataGenerator newCourier = CourierDataGenerator.getRandomCourier();
        courierClient.createCourier(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        courierId = courierClient.login(courierData);

        courierData.setLogin(null);
        String actual = courierClient.loginCourierWithoutRequiredParameter(courierData);

        String expected = "Недостаточно данных для входа";
        assertEquals(expected, actual);
    }

    // тест падает из-за ошибки документации API в части ответа при запросе без обязательного поля password
    @Test
    @DisplayName("Тест на проверку обязательности поля password при логине курьера")
    public void failToLoginCourierWithoutPassword() {

        CourierDataGenerator newCourier = CourierDataGenerator.getRandomCourier();
        courierClient.createCourier(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        courierId = courierClient.login(courierData);

        courierData.setPassword(null);
        String actual = courierClient.loginCourierWithoutRequiredParameter(courierData);

        String expected = "Недостаточно данных для входа";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест на проверку логина с несуществующей парой логин-пароль")
    public void failToLoginCourierWithNonExistingData() {

        CourierDataGenerator newCourier = CourierDataGenerator.getRandomCourier();
        String actual = courierClient.loginCourierWithNonExistingData(newCourier);

        String expected = "Учетная запись не найдена";
        assertEquals(expected, actual);
    }
}
