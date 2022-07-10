package ru.yandex.scooter.api.pojo;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class NewCourierWithoutPassword {

    private String login;
    private String firstName;

    public NewCourierWithoutPassword(String login, String firstName) {

        this.login = login;
        this.firstName = firstName;
    }

    public static NewCourierWithoutPassword getRandomCourierWithoutPassword() {

        String login = RandomStringUtils.randomAlphanumeric(10);
        String firstName = RandomStringUtils.randomAlphanumeric(10);

        return new NewCourierWithoutPassword(login, firstName);
    }
}
