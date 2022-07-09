package ru.yandex.scooter.api.pojo;

import static io.restassured.RestAssured.given;

public class CourierClient {

    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    private final String COURIER = "/courier";

    public boolean create(NewCourier newCourier) {

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

    public boolean delete(int courierId) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .when()
                .delete(COURIER + "/{courierId}", courierId)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");
    }
}
