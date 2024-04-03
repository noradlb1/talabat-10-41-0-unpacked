package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class JsonWriter implements Closeable, Flushable {

    /* renamed from: b  reason: collision with root package name */
    public int f53277b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int[] f53278c = new int[32];

    /* renamed from: d  reason: collision with root package name */
    public String[] f53279d = new String[32];

    /* renamed from: e  reason: collision with root package name */
    public int[] f53280e = new int[32];

    /* renamed from: f  reason: collision with root package name */
    public String f53281f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53282g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53283h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53284i;

    /* renamed from: j  reason: collision with root package name */
    public int f53285j = -1;
    private Map<Class<?>, Object> tags;

    @CheckReturnValue
    public static JsonWriter of(BufferedSink bufferedSink) {
        return new JsonUtf8Writer(bufferedSink);
    }

    public final boolean a() {
        int i11 = this.f53277b;
        int[] iArr = this.f53278c;
        if (i11 != iArr.length) {
            return false;
        }
        if (i11 != 256) {
            this.f53278c = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f53279d;
            this.f53279d = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f53280e;
            this.f53280e = Arrays.copyOf(iArr2, iArr2.length * 2);
            if (!(this instanceof JsonValueWriter)) {
                return true;
            }
            JsonValueWriter jsonValueWriter = (JsonValueWriter) this;
            Object[] objArr = jsonValueWriter.f53274k;
            jsonValueWriter.f53274k = Arrays.copyOf(objArr, objArr.length * 2);
            return true;
        }
        throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
    }

    public final int b() {
        int i11 = this.f53277b;
        if (i11 != 0) {
            return this.f53278c[i11 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public abstract JsonWriter beginArray() throws IOException;

    @CheckReturnValue
    public final int beginFlatten() {
        int b11 = b();
        if (b11 == 5 || b11 == 3 || b11 == 2 || b11 == 1) {
            int i11 = this.f53285j;
            this.f53285j = this.f53277b;
            return i11;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public abstract JsonWriter beginObject() throws IOException;

    public final void c(int i11) {
        int[] iArr = this.f53278c;
        int i12 = this.f53277b;
        this.f53277b = i12 + 1;
        iArr[i12] = i11;
    }

    public final void d(int i11) {
        this.f53278c[this.f53277b - 1] = i11;
    }

    public abstract JsonWriter endArray() throws IOException;

    public final void endFlatten(int i11) {
        this.f53285j = i11;
    }

    public abstract JsonWriter endObject() throws IOException;

    @CheckReturnValue
    public final String getIndent() {
        String str = this.f53281f;
        return str != null ? str : "";
    }

    @CheckReturnValue
    public final String getPath() {
        return JsonScope.a(this.f53277b, this.f53278c, this.f53279d, this.f53280e);
    }

    @CheckReturnValue
    public final boolean getSerializeNulls() {
        return this.f53283h;
    }

    @CheckReturnValue
    public final boolean isLenient() {
        return this.f53282g;
    }

    public final JsonWriter jsonValue(@Nullable Object obj) throws IOException {
        String str;
        if (obj instanceof Map) {
            beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    if (key == null) {
                        str = "Map keys must be non-null";
                    } else {
                        str = "Map keys must be of type String: " + key.getClass().getName();
                    }
                    throw new IllegalArgumentException(str);
                }
                name((String) key);
                jsonValue(entry.getValue());
            }
            endObject();
        } else if (obj instanceof List) {
            beginArray();
            for (Object jsonValue : (List) obj) {
                jsonValue(jsonValue);
            }
            endArray();
        } else if (obj instanceof String) {
            value((String) obj);
        } else if (obj instanceof Boolean) {
            value(((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            value(((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            value(((Long) obj).longValue());
        } else if (obj instanceof Number) {
            value((Number) obj);
        } else if (obj == null) {
            nullValue();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getName());
        }
        return this;
    }

    public abstract JsonWriter name(String str) throws IOException;

    public abstract JsonWriter nullValue() throws IOException;

    public final void promoteValueToName() throws IOException {
        int b11 = b();
        if (b11 == 5 || b11 == 3) {
            this.f53284i = true;
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public void setIndent(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.f53281f = str;
    }

    public final void setLenient(boolean z11) {
        this.f53282g = z11;
    }

    public final void setSerializeNulls(boolean z11) {
        this.f53283h = z11;
    }

    public final <T> void setTag(Class<T> cls, T t11) {
        if (cls.isAssignableFrom(t11.getClass())) {
            if (this.tags == null) {
                this.tags = new LinkedHashMap();
            }
            this.tags.put(cls, t11);
            return;
        }
        throw new IllegalArgumentException("Tag value must be of type " + cls.getName());
    }

    @CheckReturnValue
    @Nullable
    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return map.get(cls);
    }

    public abstract JsonWriter value(double d11) throws IOException;

    public abstract JsonWriter value(long j11) throws IOException;

    public abstract JsonWriter value(@Nullable Boolean bool) throws IOException;

    public abstract JsonWriter value(@Nullable Number number) throws IOException;

    public abstract JsonWriter value(@Nullable String str) throws IOException;

    public final JsonWriter value(BufferedSource bufferedSource) throws IOException {
        if (!this.f53284i) {
            BufferedSink valueSink = valueSink();
            try {
                bufferedSource.readAll(valueSink);
                if (valueSink != null) {
                    valueSink.close();
                }
                return this;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            throw new IllegalStateException("BufferedSource cannot be used as a map key in JSON at path " + getPath());
        }
        throw th;
    }

    public abstract JsonWriter value(boolean z11) throws IOException;

    @CheckReturnValue
    public abstract BufferedSink valueSink() throws IOException;
}
