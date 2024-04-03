package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

final class SerializeOnlyNonEmptyJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;

    public SerializeOnlyNonEmptyJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    private boolean isNotEmpty(T t11) {
        if (t11 instanceof Collection) {
            if (((Collection) t11).size() > 0) {
                return true;
            }
            return false;
        } else if (t11 instanceof Map) {
            if (((Map) t11).size() > 0) {
                return true;
            }
            return false;
        } else if (t11 == null) {
            return false;
        } else {
            if (Array.getLength(t11) > 0) {
                return true;
            }
            return false;
        }
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        return this.delegate.fromJson(jsonReader);
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        if (isNotEmpty(t11)) {
            this.delegate.toJson(jsonWriter, t11);
        } else {
            this.delegate.toJson(jsonWriter, null);
        }
    }

    public String toString() {
        return this.delegate + ".serializeOnlyNonEmpty()";
    }
}
