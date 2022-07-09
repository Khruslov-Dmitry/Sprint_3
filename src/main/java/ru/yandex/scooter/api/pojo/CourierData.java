package ru.yandex.scooter.api.pojo;

import lombok.Data;

@Data
public class CourierData {

    private String login;
    private String password;

    public CourierData(String login, String password) {

        this.login = login;
        this.password = password;
    }

    public CourierData(NewCourier newCourier) {

        this.login = newCourier.getLogin();
        this.password = newCourier.getPassword();
    }

    public static CourierData from(NewCourier newCourier) {

        return new CourierData(newCourier);
    }
}
