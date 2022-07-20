package ru.yandex.scooter.api;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.scooter.api.pojo.OrdersClient;

public class OrderListTest {

    @Test
    @DisplayName("тест получения списка заказов")
    public void getOrderList() {

        OrdersClient.getOrderList();
    }
}
