package ru.yandex.scooter.api.pojo;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class NewCourier {

    private String login;
    private String password;
    private String firstName;

    public NewCourier(String login, String password, String firstName) {

        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public static NewCourier getRandom() {

        String login = RandomStringUtils.randomAlphanumeric(10);
        String password = RandomStringUtils.randomAlphanumeric(10);
        String firstName = RandomStringUtils.randomAlphanumeric(10);

        return new NewCourier(login, password, firstName);
    }
}

