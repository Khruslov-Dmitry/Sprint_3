package ru.yandex.scooter.api;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.scooter.api.pojo.NewOrder;
import ru.yandex.scooter.api.pojo.OrdersClient;

public class OrderTest {

    private OrdersClient ordersClient;

    @Before
    public void setUp() {

        ordersClient = new OrdersClient();
    }

    // тест на создание нового заказа
    @Test
    public void createNewOrder() {

        NewOrder newOrder = new NewOrder(
                "Naruto",
                "Uchiha",
                "Konoha, 142 apt.",
                4,
                "+7 800 355 35 35",
                5,
                "2022-08-08",
                "Saske, come back to Konoha",
                "BLACK"

        );
        int orderTrackNumber = ordersClient.create(newOrder);
    }
}
