package com.serjltt.moshi.adapters;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.lang.Enum;

final class FallbackEnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
    private final T[] constants;
    private final Class<T> enumType;
    private final T fallbackConstant;
    private final String[] nameStrings;
    private final JsonReader.Options options;

    public FallbackEnumJsonAdapter(Class<T> cls, String str) {
        String str2;
        this.fallbackConstant = Enum.valueOf(cls, str);
        this.enumType = cls;
        try {
            T[] tArr = (Enum[]) cls.getEnumConstants();
            this.constants = tArr;
            this.nameStrings = new String[tArr.length];
            int i11 = 0;
            while (true) {
                T[] tArr2 = this.constants;
                if (i11 < tArr2.length) {
                    T t11 = tArr2[i11];
                    Json json = (Json) cls.getField(t11.name()).getAnnotation(Json.class);
                    if (json != null) {
                        str2 = json.name();
                    } else {
                        str2 = t11.name();
                    }
                    this.nameStrings[i11] = str2;
                    i11++;
                } else {
                    this.options = JsonReader.Options.of(this.nameStrings);
                    return;
                }
            }
        } catch (NoSuchFieldException e11) {
            throw new AssertionError(e11);
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.enumType.getName() + ").fallbackEnum(" + this.fallbackConstant + ")";
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        int selectString = jsonReader.selectString(this.options);
        if (selectString != -1) {
            return this.constants[selectString];
        }
        jsonReader.nextString();
        return this.fallbackConstant;
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        jsonWriter.value(this.nameStrings[t11.ordinal()]);
    }
}
