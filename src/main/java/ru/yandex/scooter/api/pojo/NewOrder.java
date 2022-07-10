package ru.yandex.scooter.api.pojo;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class NewOrder {

    private String firstName;
    private String lastName;
    private String address;
    private int metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List color;

    public NewOrder(String firstName, String lastName, String address, int metroStation, String phone, int rentTime, String deliveryDate, String comment, String color) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = Collections.singletonList(color);
    }

    public NewOrder() {
    }
}
