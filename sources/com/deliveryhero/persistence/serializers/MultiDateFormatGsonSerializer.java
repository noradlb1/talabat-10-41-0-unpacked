package com.deliveryhero.persistence.serializers;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class MultiDateFormatGsonSerializer implements SerializerInterface {
    public <T> T deSerialize(String str, Class<T> cls) {
        return GsonSerializerFactory.deSerialize(str, cls);
    }

    public String serialize(Object obj) {
        return GsonSerializerFactory.serialize(obj);
    }

    public <T> T deSerialize(String str, TypeToken<T> typeToken) {
        return GsonSerializerFactory.deSerialize(str, typeToken);
    }

    public <T> T deSerialize(String str, Type type) {
        return GsonSerializerFactory.deSerialize(str, type);
    }
}
