package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

final class WrappedJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;
    private final boolean failOnNotFound;
    private final String[] path;

    public WrappedJsonAdapter(JsonAdapter<T> jsonAdapter, String[] strArr, boolean z11) {
        this.delegate = jsonAdapter;
        this.path = strArr;
        this.failOnNotFound = z11;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        return fromJson(this.delegate, jsonReader, this.path, 0, this.failOnNotFound);
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        toJson(this.delegate, jsonWriter, t11, this.path, 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.delegate);
        sb2.append(String.format(".wrapped(%s)", new Object[]{Arrays.asList(this.path)}));
        sb2.append(this.failOnNotFound ? ".failOnNotFound()" : "");
        return sb2.toString();
    }

    private static <T> T fromJson(JsonAdapter<T> jsonAdapter, JsonReader jsonReader, String[] strArr, int i11, boolean z11) throws IOException {
        if (i11 == strArr.length) {
            return jsonAdapter.fromJson(jsonReader);
        }
        jsonReader.beginObject();
        try {
            String str = strArr[i11];
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals(str)) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() != JsonReader.Token.NULL) {
                    T fromJson = fromJson(jsonAdapter, jsonReader, strArr, i11 + 1, z11);
                    while (jsonReader.hasNext()) {
                        jsonReader.skipValue();
                    }
                    jsonReader.endObject();
                    return fromJson;
                } else if (!z11) {
                    T nextNull = jsonReader.nextNull();
                    while (jsonReader.hasNext()) {
                        jsonReader.skipValue();
                    }
                    jsonReader.endObject();
                    return nextNull;
                } else {
                    throw new JsonDataException(String.format("Wrapped Json expected at path: %s. Found null at %s", new Object[]{Arrays.asList(strArr), jsonReader.getPath()}));
                }
            }
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            throw new JsonDataException(String.format("Wrapped Json expected at path: %s. Actual: %s", new Object[]{Arrays.asList(strArr), jsonReader.getPath()}));
        } catch (Exception e11) {
            if (e11 instanceof IOException) {
                throw ((IOException) e11);
            } else if (!(e11 instanceof JsonDataException)) {
                throw new AssertionError(e11);
            } else {
                throw ((JsonDataException) e11);
            }
        } catch (Throwable th2) {
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            throw th2;
        }
    }

    private static <T> void toJson(JsonAdapter<T> jsonAdapter, JsonWriter jsonWriter, T t11, String[] strArr, int i11) throws IOException {
        if (t11 == null && !jsonWriter.getSerializeNulls()) {
            jsonWriter.nullValue();
        } else if (i11 == strArr.length) {
            jsonAdapter.toJson(jsonWriter, t11);
        } else {
            jsonWriter.beginObject();
            jsonWriter.name(strArr[i11]);
            toJson(jsonAdapter, jsonWriter, t11, strArr, i11 + 1);
            jsonWriter.endObject();
        }
    }
}
