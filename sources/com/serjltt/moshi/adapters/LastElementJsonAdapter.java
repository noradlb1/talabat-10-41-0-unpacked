package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

final class LastElementJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<List<T>> delegate;

    public LastElementJsonAdapter(Type type, Moshi moshi) {
        this.delegate = moshi.adapter((Type) Types.newParameterizedType(List.class, type));
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        List fromJson = this.delegate.fromJson(jsonReader);
        if (fromJson == null || fromJson.isEmpty()) {
            return null;
        }
        return fromJson.get(fromJson.size() - 1);
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        this.delegate.toJson(jsonWriter, Collections.singletonList(t11));
    }

    public String toString() {
        return this.delegate + ".lastElement()";
    }
}
