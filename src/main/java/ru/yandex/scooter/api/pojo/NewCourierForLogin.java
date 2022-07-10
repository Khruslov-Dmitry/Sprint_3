package ru.yandex.scooter.api.pojo;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class NewCourierForLogin {

    private String login;
    private String password;

    public NewCourierForLogin(String login, String password) {

        this.login = login;
        this.password = password;
    }

    public static NewCourierForLogin getRandom() {

        String login = RandomStringUtils.randomAlphanumeric(10);
        String password = RandomStringUtils.randomAlphanumeric(10);

        return new NewCourierForLogin(login, password);
    }
}
