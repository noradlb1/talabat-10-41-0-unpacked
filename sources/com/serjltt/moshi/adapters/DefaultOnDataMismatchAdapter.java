package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

public final class DefaultOnDataMismatchAdapter<T> extends JsonAdapter<T> {
    private final T defaultValue;
    private final JsonAdapter<T> delegate;

    public DefaultOnDataMismatchAdapter(JsonAdapter<T> jsonAdapter, T t11) {
        this.delegate = jsonAdapter;
        this.defaultValue = t11;
    }

    public static <T> JsonAdapter.Factory newFactory(final Type type, final T t11) {
        return new JsonAdapter.Factory() {
            public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                if (Types.equals(type, type)) {
                    return new DefaultOnDataMismatchAdapter(moshi.nextAdapter(this, type, set), t11);
                }
                return null;
            }
        };
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        try {
            return this.delegate.fromJsonValue(jsonReader.readJsonValue());
        } catch (JsonDataException unused) {
            return this.defaultValue;
        }
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        this.delegate.toJson(jsonWriter, t11);
    }

    public String toString() {
        return this.delegate + ".defaultOnDatMisMatch(" + this.defaultValue + ')';
    }
}
