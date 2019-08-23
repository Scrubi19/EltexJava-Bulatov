package ru.eltex.laba5;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.eltex.laba1.Product;
import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Order;
import ru.eltex.laba2.OrderStatus;
import ru.eltex.laba2.ShoppingCart;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderDeserializer implements JsonDeserializer<Order> {
    @Override
    public Order deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jDContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        UUID id = UUID.fromString(object.get("id").getAsString());
        var status = OrderStatus.valueOf(object.get("status").getAsString());

        Date dateCreate = null;
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        try {
            dateCreate = new Date(format.parse(object.get("dateCreate").getAsString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        var timeWaiting = object.get("timeWaiting").getAsLong();

        Type typecart = new TypeToken<ShoppingCart<Product>>() {
        }.getType();

        ShoppingCart<Product> cart = jDContext.deserialize(object.get("cart"), typecart);
        Credentials user = new Gson().fromJson(object.get("user"), Credentials.class);
        return new Order(id, status, dateCreate, timeWaiting, cart, user);

    }
}
