package ru.yandex.scooter.api;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.scooter.api.pojo.*;

public class CourierTest {

    private CourierClient courierClient;

    @Before
    public void setUp() {

        courierClient = new CourierClient();
    }

    // тест на создание нового курьера с рандомными данными и последующий логин
    @Test
    public void createNewCourier() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        courierClient.delete(courierId);
    }

    // тест на создание двух одинаковых курьеров
    @Test
    public void failToCreateCourierWithExistingData() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        courierClient.createSameCourier(courierData);

        courierClient.delete(courierId);
    }

    // тест на проверку обязательности поля login при создании курьера
    @Test
    public void failToCreateCourierWithoutLogin() {

        NewCourierWithoutLogin newCourierWithoutLogin = NewCourierWithoutLogin.getRandomCourierWithoutLogin();
        courierClient.createCourierWithoutLogin(newCourierWithoutLogin);
    }

    // тест на проверку обязательности поля password при создании курьера
    @Test
    public void failToCreateCourierWithoutPassword() {

        NewCourierWithoutPassword newCourierWithoutPassword = NewCourierWithoutPassword.getRandomCourierWithoutPassword();
        courierClient.createCourierWithoutPassword(newCourierWithoutPassword);
    }

    // тест на проверку обязательности поля firstName при создании курьера
    // тест падает из-за ошибки документации API в части обязательности поля firstName
    @Test
    public void failToCreateCourierWithoutFirstName() {

        NewCourierWithoutFirstName newCourierWithoutFirstName = NewCourierWithoutFirstName.getRandomCourierWithoutFirstName();
        courierClient.createCourierWithoutFirstName(newCourierWithoutFirstName);
    }

    // тест на проверку обязательности поля login при логине курьера
    @Test
    public void failToLoginCourierWithoutLogin() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        CourierDataWithoutLogin courierDataWithoutLogin = CourierDataWithoutLogin.from(newCourier);
        courierClient.loginWithoutLogin(courierDataWithoutLogin);

        courierClient.delete(courierId);
    }

    // тест на проверку обязательности поля password при логине курьера
    // тест падает из-за ошибки документации API в части ответа при запросе без обязательного поля password
    @Test
    public void failToLoginCourierWithoutPassword() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        CourierDataWithoutPassword courierDataWithoutPassword = CourierDataWithoutPassword.from(newCourier);
        courierClient.loginWithoutPassword(courierDataWithoutPassword);

        courierClient.delete(courierId);
    }

    // тест на проверку логина с несуществующей парой логин-пароль
    @Test
    public void failToLoginCourierWithNonExistingData() {

        NewCourierForLogin newCourierForLogin = NewCourierForLogin.getRandom();
        courierClient.loginCourierWithNonExistingData(newCourierForLogin);
    }
}























