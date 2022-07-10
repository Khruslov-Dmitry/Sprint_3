package ru.yandex.scooter.api.pojo;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class NewCourierWithoutFirstName {

    private String login;
    private String password;

    public NewCourierWithoutFirstName(String login, String password) {

        this.login = login;
        this.password = password;
    }

    public static NewCourierWithoutFirstName getRandomCourierWithoutFirstName() {

        String login = RandomStringUtils.randomAlphanumeric(10);
        String password = RandomStringUtils.randomAlphanumeric(10);

        return new NewCourierWithoutFirstName(login, password);
    }
}
