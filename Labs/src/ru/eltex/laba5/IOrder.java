package ru.eltex.laba5;
import ru.eltex.laba2.*;
import java.util.UUID;

public interface IOrder {
    Order readByID(UUID id);
    void saveByID(Order order );
    Orders readAll();
    void saveAll(Orders orders);
}
