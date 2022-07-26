package ru.yandex.scooter.api;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.scooter.api.client.OrdersClient;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class OrderListTest {

    @Step("Проверка, что вернувшийся список заказов не пустой")
    public void checkOrderListNotNull(ArrayList orderList) {

        assertNotNull(orderList);
    }

    @Test
    @DisplayName("Тест получения списка заказов")
    public void getOrderList() {

        ArrayList orderList = OrdersClient.getOrderList();
        checkOrderListNotNull(orderList);
    }
}
