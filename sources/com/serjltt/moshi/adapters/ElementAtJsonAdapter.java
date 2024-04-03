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

final class ElementAtJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<List<T>> delegate;
    private final int index;

    public ElementAtJsonAdapter(Type type, Moshi moshi, int i11) {
        this.delegate = moshi.adapter((Type) Types.newParameterizedType(List.class, type));
        this.index = i11;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        List fromJson = this.delegate.fromJson(jsonReader);
        if (fromJson == null || this.index >= fromJson.size()) {
            return null;
        }
        return fromJson.get(this.index);
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        this.delegate.toJson(jsonWriter, Collections.singletonList(t11));
    }

    public String toString() {
        return this.delegate + ".elementAt(" + this.index + ")";
    }
}
