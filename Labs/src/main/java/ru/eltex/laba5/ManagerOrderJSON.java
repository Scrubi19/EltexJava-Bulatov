package ru.eltex.laba5;

import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder{

    @Override
    public Order readByID(UUID id) {
        return null;
    }

    @Override
    public void saveByID(Orders orders, UUID id) {

    }

    @Override
    public Orders readAll() {
        return null;
    }

    @Override
    public void saveAll(Orders orders) {

    }
}
