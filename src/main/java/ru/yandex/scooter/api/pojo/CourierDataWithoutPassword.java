package ru.yandex.scooter.api.pojo;

import lombok.Data;

@Data
public class CourierDataWithoutPassword {

    private String login;

    public CourierDataWithoutPassword(String login) {

        this.login = login;
    }

    public CourierDataWithoutPassword(NewCourier newCourier) {

        this.login = newCourier.getLogin();
    }

    public static CourierDataWithoutPassword from(NewCourier newCourier) {

        return new CourierDataWithoutPassword(newCourier);
    }
}
