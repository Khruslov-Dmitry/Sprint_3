package ru.yandex.scooter.api;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.scooter.api.client.OrdersClient;

import java.io.File;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest {

    private static File json = null;
    private final int expected;

    public OrderTest(File json, int expected) {

        OrderTest.json = json;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} - файл с данными заказа, {1} - ожидаемый код ответа")
    public static Object[][] orderData() {

        return new Object[][] {
                {json = new File("src/test/resources/orderBLACK.json"), 201},
                {json = new File("src/test/resources/orderGRAY.json"), 201},
                {json = new File("src/test/resources/orderBothColors.json"), 201},
                {json = new File("src/test/resources/orderNoColor.json"), 201},
        };
    }

    @Step("Проверка кода ответа на запрос создания заказа")
    public void checkOrderCreation(int expected, int actual) {

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("параметризованный тест создания заказа")
    public void createNewOrder() {

        int actual = OrdersClient.create(json);
        checkOrderCreation(expected, actual);
    }
}
