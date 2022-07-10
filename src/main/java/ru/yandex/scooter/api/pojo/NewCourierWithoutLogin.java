package ru.yandex.scooter.api.pojo;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class NewCourierWithoutLogin {

    private String password;
    private String firstName;

    public NewCourierWithoutLogin(String password, String firstName) {

        this.password = password;
        this.firstName = firstName;
    }

    public static NewCourierWithoutLogin getRandomCourierWithoutLogin() {

        String password = RandomStringUtils.randomAlphanumeric(10);
        String firstName = RandomStringUtils.randomAlphanumeric(10);

        return new NewCourierWithoutLogin(password, firstName);
    }
}
