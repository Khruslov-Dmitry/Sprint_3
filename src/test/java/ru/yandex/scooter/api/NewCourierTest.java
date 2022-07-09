package ru.yandex.scooter.api;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.scooter.api.pojo.CourierClient;
import ru.yandex.scooter.api.pojo.CourierData;
import ru.yandex.scooter.api.pojo.NewCourier;

public class NewCourierTest {

    private CourierClient courierClient;

    @Before
    public void setUp() {

        courierClient = new CourierClient();
    }

    @Test
    public void createNewCourier() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        courierClient.delete(courierId);
    }

    @Test
    public void failToCreateCourierWithExistingData() {

        NewCourier newCourier = NewCourier.getRandom();
        courierClient.create(newCourier);

        CourierData courierData = CourierData.from(newCourier);
        int courierId = courierClient.login(courierData);

        courierClient.createSameCourier(courierData);

        courierClient.delete(courierId);
    }

    @Test
    public void failToCreateCourierWithoutLogin() {


    }
}























