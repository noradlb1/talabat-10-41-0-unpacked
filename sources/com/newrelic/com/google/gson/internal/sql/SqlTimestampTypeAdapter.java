package com.newrelic.com.google.gson.internal.sql;

import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.TypeAdapter;
import com.newrelic.com.google.gson.TypeAdapterFactory;
import com.newrelic.com.google.gson.reflect.TypeToken;
import com.newrelic.com.google.gson.stream.JsonReader;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.getAdapter(Date.class));
            }
            return null;
        }
    };
    private final TypeAdapter<Date> dateTypeAdapter;

    private SqlTimestampTypeAdapter(TypeAdapter<Date> typeAdapter) {
        this.dateTypeAdapter = typeAdapter;
    }

    public Timestamp read(JsonReader jsonReader) throws IOException {
        Date read = this.dateTypeAdapter.read(jsonReader);
        if (read != null) {
            return new Timestamp(read.getTime());
        }
        return null;
    }

    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.dateTypeAdapter.write(jsonWriter, timestamp);
    }
}
