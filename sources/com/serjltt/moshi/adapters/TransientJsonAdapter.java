package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;

final class TransientJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;
    private final boolean deserialize;
    private final boolean serialize;

    public TransientJsonAdapter(JsonAdapter<T> jsonAdapter, boolean z11, boolean z12) {
        this.delegate = jsonAdapter;
        this.serialize = z11;
        this.deserialize = z12;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        if (this.deserialize) {
            return this.delegate.fromJson(jsonReader);
        }
        jsonReader.skipValue();
        return null;
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        if (this.serialize) {
            this.delegate.toJson(jsonWriter, t11);
        } else {
            this.delegate.toJson(jsonWriter, null);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.delegate);
        boolean z11 = this.serialize;
        sb2.append((!z11 || !this.deserialize) ? z11 ? ".serializeOnly()" : this.deserialize ? ".deserializeOnly()" : ".transient()" : "");
        return sb2.toString();
    }
}
