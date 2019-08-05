package ru.eltex.laba5;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.eltex.laba2.*;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class OrdersDeserializer implements JsonDeserializer<Orders> {
    @Override
    public Orders deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jDContext) throws JsonParseException {
        JsonObject jsonElementObject = jsonElement.getAsJsonObject();

        Type listType = new TypeToken<LinkedList<Order>>() {
        }.getType();

        LinkedList<Order> list = jDContext.deserialize(jsonElementObject.get("orders"), listType);
        HashMap<Date, Order> map = new HashMap<>();
        for (var item : list) {
            map.put(item.getDateCreate(),item);
        }
        return new Orders<>(list, map);
    }
}

