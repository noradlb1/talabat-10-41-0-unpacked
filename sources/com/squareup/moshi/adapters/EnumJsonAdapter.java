package com.squareup.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import javax.annotation.Nullable;

public final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<T> f53337a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f53338b;

    /* renamed from: c  reason: collision with root package name */
    public final T[] f53339c;

    /* renamed from: d  reason: collision with root package name */
    public final JsonReader.Options f53340d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f53341e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final T f53342f;

    public EnumJsonAdapter(Class<T> cls, @Nullable T t11, boolean z11) {
        this.f53337a = cls;
        this.f53342f = t11;
        this.f53341e = z11;
        try {
            T[] tArr = (Enum[]) cls.getEnumConstants();
            this.f53339c = tArr;
            this.f53338b = new String[tArr.length];
            int i11 = 0;
            while (true) {
                T[] tArr2 = this.f53339c;
                if (i11 < tArr2.length) {
                    String name2 = tArr2[i11].name();
                    this.f53338b[i11] = Util.jsonName(name2, (AnnotatedElement) cls.getField(name2));
                    i11++;
                } else {
                    this.f53340d = JsonReader.Options.of(this.f53338b);
                    return;
                }
            }
        } catch (NoSuchFieldException e11) {
            throw new AssertionError("Missing field in " + cls.getName(), e11);
        }
    }

    public static <T extends Enum<T>> EnumJsonAdapter<T> create(Class<T> cls) {
        return new EnumJsonAdapter<>(cls, (Enum) null, false);
    }

    public String toString() {
        return "EnumJsonAdapter(" + this.f53337a.getName() + ")";
    }

    public EnumJsonAdapter<T> withUnknownFallback(@Nullable T t11) {
        return new EnumJsonAdapter<>(this.f53337a, t11, true);
    }

    @Nullable
    public T fromJson(JsonReader jsonReader) throws IOException {
        int selectString = jsonReader.selectString(this.f53340d);
        if (selectString != -1) {
            return this.f53339c[selectString];
        }
        String path = jsonReader.getPath();
        if (!this.f53341e) {
            String nextString = jsonReader.nextString();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.f53338b) + " but was " + nextString + " at path " + path);
        } else if (jsonReader.peek() == JsonReader.Token.STRING) {
            jsonReader.skipValue();
            return this.f53342f;
        } else {
            throw new JsonDataException("Expected a string but was " + jsonReader.peek() + " at path " + path);
        }
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        if (t11 != null) {
            jsonWriter.value(this.f53338b[t11.ordinal()]);
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
