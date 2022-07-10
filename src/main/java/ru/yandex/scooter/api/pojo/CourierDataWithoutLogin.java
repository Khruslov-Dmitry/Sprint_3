package ru.yandex.scooter.api.pojo;

import lombok.Data;

@Data
public class CourierDataWithoutLogin {

    private String password;

    public CourierDataWithoutLogin(String password) {

        this.password = password;
    }

    public CourierDataWithoutLogin(NewCourier newCourier) {

        this.password = newCourier.getPassword();
    }

    public static CourierDataWithoutLogin from(NewCourier newCourier) {

        return new CourierDataWithoutLogin(newCourier);
    }
}
