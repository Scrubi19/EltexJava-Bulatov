package ru.eltex.laba5;

import com.google.gson.*;
import ru.eltex.laba1.Coffee;
import ru.eltex.laba1.Product;
import ru.eltex.laba1.Tea;

import java.lang.reflect.Type;

public class ProductDeserializer implements JsonDeserializer<Product> {

    @Override
    public Product deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jDContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.has("typeBox")) {
            return jDContext.deserialize(jsonObject, Tea.class);
        } else if (jsonObject.has("grainType")) {
            return jDContext.deserialize(jsonObject, Coffee.class);
        }
        return null;
    }
}
