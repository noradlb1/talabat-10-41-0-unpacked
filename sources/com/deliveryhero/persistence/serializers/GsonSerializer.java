package com.deliveryhero.persistence.serializers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.reflect.Type;

@Instrumented
public class GsonSerializer implements SerializerInterface {
    private Gson gson;

    public GsonSerializer(Gson gson2) {
        this.gson = gson2;
    }

    public <T> T deSerialize(String str, Class<T> cls) {
        Gson gson2 = this.gson;
        return !(gson2 instanceof Gson) ? gson2.fromJson(str, cls) : GsonInstrumentation.fromJson(gson2, str, cls);
    }

    public String serialize(Object obj) {
        Gson gson2 = this.gson;
        return !(gson2 instanceof Gson) ? gson2.toJson(obj) : GsonInstrumentation.toJson(gson2, obj);
    }

    public <T> T deSerialize(String str, TypeToken<T> typeToken) {
        Gson gson2 = this.gson;
        Type type = typeToken.getType();
        return !(gson2 instanceof Gson) ? gson2.fromJson(str, type) : GsonInstrumentation.fromJson(gson2, str, type);
    }

    public <T> T deSerialize(String str, Type type) {
        Gson gson2 = this.gson;
        return !(gson2 instanceof Gson) ? gson2.fromJson(str, type) : GsonInstrumentation.fromJson(gson2, str, type);
    }
}
