package ru.yandex.scooter.api;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.scooter.api.pojo.*;

public class CourierTest {

    private CourierClient courierClient;

    @Before
    public void setUp() {

        courierClient = new CourierClient();
    }

    @Test
    @DisplayName("тест на создание нового курьера и последующий логин")
    public void createNewCourier() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("тест на невозможность создания 2 одинаковых курьеров")
    public void failToCreateCourierWithExistingData() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        courierClient.createSameCourier(courierData);

        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("тест на проверку обязательности поля login при создании курьера")
    public void failToCreateCourierWithoutLogin() {

        NewCourierWithoutLogin newCourierWithoutLogin = NewCourierWithoutLogin.getRandomCourierWithoutLogin();
        courierClient.createCourierWithoutLogin(newCourierWithoutLogin);
    }

    @Test
    @DisplayName("тест на проверку обязательности поля password при создании курьера")
    public void failToCreateCourierWithoutPassword() {

        NewCourierWithoutPassword newCourierWithoutPassword = NewCourierWithoutPassword.getRandomCourierWithoutPassword();
        courierClient.createCourierWithoutPassword(newCourierWithoutPassword);
    }

    // тест падает из-за ошибки документации API в части обязательности поля firstName
    @Test
    @DisplayName("тест на проверку обязательности поля firstName при создании курьера")
    public void failToCreateCourierWithoutFirstName() {

        NewCourierWithoutFirstName newCourierWithoutFirstName = NewCourierWithoutFirstName.getRandomCourierWithoutFirstName();
        courierClient.createCourierWithoutFirstName(newCourierWithoutFirstName);
    }

    @Test
    @DisplayName("тест на проверку обязательности поля login при логине курьера")
    public void failToLoginCourierWithoutLogin() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        CourierDataWithoutLogin courierDataWithoutLogin = CourierDataWithoutLogin.from(newCourier);
        courierClient.loginWithoutLogin(courierDataWithoutLogin);

        courierClient.delete(courierId);
    }

    // тест падает из-за ошибки документации API в части ответа при запросе без обязательного поля password
    @Test
    @DisplayName("тест на проверку обязательности поля password при логине курьера")
    public void failToLoginCourierWithoutPassword() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        CourierDataWithoutPassword courierDataWithoutPassword = CourierDataWithoutPassword.from(newCourier);
        courierClient.loginWithoutPassword(courierDataWithoutPassword);

        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("тест на проверку логина с несуществующей парой логин-пароль")
    public void failToLoginCourierWithNonExistingData() {

        NewCourierForLogin newCourierForLogin = NewCourierForLogin.getRandom();
        courierClient.loginCourierWithNonExistingData(newCourierForLogin);
    }
}
