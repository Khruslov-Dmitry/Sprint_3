package ru.yandex.scooter.api.model;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yandex.scooter.api.util.CourierDataGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierData {

    private String login;
    private String password;

    public CourierData(CourierDataGenerator newCourier) {

        this.login = newCourier.getLogin();
        this.password = newCourier.getPassword();
    }

    @Step("Получение данных созданного курьера для последующего логина")
    public static CourierData from(CourierDataGenerator newCourier) {

        return new CourierData(newCourier);
    }
}
