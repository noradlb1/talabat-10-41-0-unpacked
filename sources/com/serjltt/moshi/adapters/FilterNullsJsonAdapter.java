package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

final class FilterNullsJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;

    public FilterNullsJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    private T removeNulls(T t11) {
        if (t11 != null) {
            Iterator it = ((Collection) t11).iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                }
            }
        }
        return t11;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        return removeNulls(this.delegate.fromJson(jsonReader));
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        this.delegate.toJson(jsonWriter, removeNulls(t11));
    }

    public String toString() {
        return this.delegate + ".filterNulls()";
    }
}
