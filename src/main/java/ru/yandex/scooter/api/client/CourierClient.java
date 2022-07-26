package ru.yandex.scooter.api.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.scooter.api.model.CourierData;
import ru.yandex.scooter.api.util.CourierDataGenerator;

import static io.restassured.RestAssured.given;

public class CourierClient {

    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    private final String COURIER = "/courier";

    @Step("Отправка POST запроса на эндпоинт /courier для создания курьера")
    public boolean createCourier(CourierDataGenerator newCourier) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(newCourier)
                .when()
                .post(COURIER)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");
    }

    @Step("Отправка POST запроса на эндпоинт /courier с данными уже имеющегося курьера")
    public String createSameCourier(CourierData courierData) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(courierData)
                .when()
                .post(COURIER)
                .then().log().all()
                .assertThat()
                .statusCode(409)
                .extract()
                .path("message");
    }

    @Step("Отправка POST запроса на эндпоинт /courier без одного из обязательных параметров")
    public String createCourierWithoutRequiredParameter(CourierDataGenerator newCourierWithoutRequiredParameter) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(newCourierWithoutRequiredParameter)
                .when()
                .post(COURIER)
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");
    }

    @Step("Отправка POST запроса на эндпоинт /courier/login для логина курьера")
    public int login(CourierData courierData) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(courierData)
                .when()
                .post(COURIER + "/login")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    @Step("Отправка POST запроса на эндпоинт /courier/login с несуществующей парой логин-пароль")
    public String loginCourierWithNonExistingData(CourierDataGenerator newCourierForLogin) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(newCourierForLogin)
                .when()
                .post(COURIER + "/login")
                .then().log().all()
                .assertThat()
                .statusCode(404)
                .extract()
                .path("message");
    }

    @Step("Отправка POST запроса на эндпоинт /courier/login без одного из обязательных параметров")
    public String loginCourierWithoutRequiredParameter(CourierData courierData) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(courierData)
                .when()
                .post(COURIER + "/login")
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");
    }

    @Step("Отправка запроса на удаление курьера")
    public ValidatableResponse deleteCourier(int courierId) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .when()
                .delete(COURIER + "/{courierId}", courierId)
                .then().log().all();
    }
}
