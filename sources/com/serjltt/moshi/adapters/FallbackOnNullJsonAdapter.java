package com.serjltt.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

final class FallbackOnNullJsonAdapter<T> extends JsonAdapter<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<Class<?>> f52924d;

    /* renamed from: a  reason: collision with root package name */
    public final JsonAdapter<T> f52925a;

    /* renamed from: b  reason: collision with root package name */
    public final T f52926b;

    /* renamed from: c  reason: collision with root package name */
    public final String f52927c;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f52924d = linkedHashSet;
        linkedHashSet.add(Boolean.TYPE);
        linkedHashSet.add(Byte.TYPE);
        linkedHashSet.add(Character.TYPE);
        linkedHashSet.add(Double.TYPE);
        linkedHashSet.add(Float.TYPE);
        linkedHashSet.add(Integer.TYPE);
        linkedHashSet.add(Long.TYPE);
        linkedHashSet.add(Short.TYPE);
    }

    public FallbackOnNullJsonAdapter(JsonAdapter<T> jsonAdapter, T t11, String str) {
        this.f52925a = jsonAdapter;
        this.f52926b = t11;
        this.f52927c = str;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonReader.Token.NULL) {
            return this.f52925a.fromJson(jsonReader);
        }
        jsonReader.nextNull();
        return this.f52926b;
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        this.f52925a.toJson(jsonWriter, t11);
    }

    public String toString() {
        return this.f52925a + ".fallbackOnNull(" + this.f52927c + SignatureVisitor.INSTANCEOF + this.f52926b + ')';
    }
}
