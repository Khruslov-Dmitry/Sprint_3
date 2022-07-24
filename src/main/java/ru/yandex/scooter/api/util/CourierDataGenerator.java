package ru.yandex.scooter.api.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierDataGenerator {

    private String login;
    private String password;
    private String firstName;

    public static CourierDataGenerator getRandomCourier() {

        String login = RandomStringUtils.randomAlphanumeric(10);
        String password = RandomStringUtils.randomAlphanumeric(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);

        return new CourierDataGenerator(login, password, firstName);
    }
}
