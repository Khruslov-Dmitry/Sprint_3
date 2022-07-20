package ru.yandex.scooter.api.pojo;

import java.io.File;

import static io.restassured.RestAssured.given;

public class OrdersClient {

    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    private static final String ORDERS = "/orders";

    public static int create(File json) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(json)
                .when()
                .post(ORDERS)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .statusCode();
    }

    public static void getOrderList() {

        given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .when()
                .get(ORDERS)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("orders");
    }
}
