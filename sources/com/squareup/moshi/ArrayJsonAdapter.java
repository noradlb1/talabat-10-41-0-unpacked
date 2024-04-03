package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.Nullable;

final class ArrayJsonAdapter extends JsonAdapter<Object> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Type a11 = Types.a(type);
            if (a11 != null && set.isEmpty()) {
                return new ArrayJsonAdapter(Types.getRawType(a11), moshi.adapter(a11)).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<Object> elementAdapter;
    private final Class<?> elementClass;

    public ArrayJsonAdapter(Class<?> cls, JsonAdapter<Object> jsonAdapter) {
        this.elementClass = cls;
        this.elementAdapter = jsonAdapter;
    }

    public Object fromJson(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        Object newInstance = Array.newInstance(this.elementClass, arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Array.set(newInstance, i11, arrayList.get(i11));
        }
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i11 = 0; i11 < length; i11++) {
            this.elementAdapter.toJson(jsonWriter, Array.get(obj, i11));
        }
        jsonWriter.endArray();
    }

    public String toString() {
        return this.elementAdapter + ".array()";
    }
}
