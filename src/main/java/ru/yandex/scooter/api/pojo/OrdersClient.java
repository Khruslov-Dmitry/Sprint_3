package ru.yandex.scooter.api.pojo;

import static io.restassured.RestAssured.given;

public class OrdersClient {

    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    private final String ORDERS = "/orders";

    public int create(NewOrder newOrder) {

        return given().log().all()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(newOrder)
                .when()
                .post(ORDERS)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("track");
    }
}
