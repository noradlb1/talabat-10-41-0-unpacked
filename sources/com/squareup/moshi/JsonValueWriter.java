package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

final class JsonValueWriter extends JsonWriter {
    @Nullable
    private String deferredName;

    /* renamed from: k  reason: collision with root package name */
    public Object[] f53274k = new Object[32];

    public JsonValueWriter() {
        c(6);
    }

    /* access modifiers changed from: private */
    public JsonValueWriter add(@Nullable Object obj) {
        String str;
        Object put;
        int b11 = b();
        int i11 = this.f53277b;
        if (i11 == 1) {
            if (b11 == 6) {
                this.f53278c[i11 - 1] = 7;
                this.f53274k[i11 - 1] = obj;
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (b11 != 3 || (str = this.deferredName) == null) {
            if (b11 == 1) {
                ((List) this.f53274k[i11 - 1]).add(obj);
            } else if (b11 == 9) {
                throw new IllegalStateException("Sink from valueSink() was not closed");
            } else {
                throw new IllegalStateException("Nesting problem.");
            }
        } else if ((obj != null || this.f53283h) && (put = ((Map) this.f53274k[i11 - 1]).put(str, obj)) != null) {
            throw new IllegalArgumentException("Map key '" + this.deferredName + "' has multiple values at path " + getPath() + ": " + put + " and " + obj);
        } else {
            this.deferredName = null;
        }
        return this;
    }

    public JsonWriter beginArray() throws IOException {
        if (!this.f53284i) {
            int i11 = this.f53277b;
            int i12 = this.f53285j;
            if (i11 == i12 && this.f53278c[i11 - 1] == 1) {
                this.f53285j = ~i12;
                return this;
            }
            a();
            ArrayList arrayList = new ArrayList();
            add(arrayList);
            Object[] objArr = this.f53274k;
            int i13 = this.f53277b;
            objArr[i13] = arrayList;
            this.f53280e[i13] = 0;
            c(1);
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    public JsonWriter beginObject() throws IOException {
        if (!this.f53284i) {
            int i11 = this.f53277b;
            int i12 = this.f53285j;
            if (i11 == i12 && this.f53278c[i11 - 1] == 3) {
                this.f53285j = ~i12;
                return this;
            }
            a();
            LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
            add(linkedHashTreeMap);
            this.f53274k[this.f53277b] = linkedHashTreeMap;
            c(3);
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    public void close() throws IOException {
        int i11 = this.f53277b;
        if (i11 > 1 || (i11 == 1 && this.f53278c[i11 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f53277b = 0;
    }

    public JsonWriter endArray() throws IOException {
        if (b() == 1) {
            int i11 = this.f53277b;
            int i12 = this.f53285j;
            if (i11 == (~i12)) {
                this.f53285j = ~i12;
                return this;
            }
            int i13 = i11 - 1;
            this.f53277b = i13;
            this.f53274k[i13] = null;
            int[] iArr = this.f53280e;
            int i14 = i13 - 1;
            iArr[i14] = iArr[i14] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public JsonWriter endObject() throws IOException {
        if (b() != 3) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.deferredName == null) {
            int i11 = this.f53277b;
            int i12 = this.f53285j;
            if (i11 == (~i12)) {
                this.f53285j = ~i12;
                return this;
            }
            this.f53284i = false;
            int i13 = i11 - 1;
            this.f53277b = i13;
            this.f53274k[i13] = null;
            this.f53279d[i13] = null;
            int[] iArr = this.f53280e;
            int i14 = i13 - 1;
            iArr[i14] = iArr[i14] + 1;
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
    }

    public void flush() throws IOException {
        if (this.f53277b == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public JsonWriter name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f53277b == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else if (b() == 3 && this.deferredName == null && !this.f53284i) {
            this.deferredName = str;
            this.f53279d[this.f53277b - 1] = str;
            return this;
        } else {
            throw new IllegalStateException("Nesting problem.");
        }
    }

    public JsonWriter nullValue() throws IOException {
        if (!this.f53284i) {
            add((Object) null);
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }

    public Object root() {
        int i11 = this.f53277b;
        if (i11 <= 1 && (i11 != 1 || this.f53278c[i11 - 1] == 7)) {
            return this.f53274k[0];
        }
        throw new IllegalStateException("Incomplete document");
    }

    public JsonWriter value(@Nullable String str) throws IOException {
        if (this.f53284i) {
            this.f53284i = false;
            return name(str);
        }
        add(str);
        int[] iArr = this.f53280e;
        int i11 = this.f53277b - 1;
        iArr[i11] = iArr[i11] + 1;
        return this;
    }

    public BufferedSink valueSink() {
        if (this.f53284i) {
            throw new IllegalStateException("BufferedSink cannot be used as a map key in JSON at path " + getPath());
        } else if (b() != 9) {
            c(9);
            final Buffer buffer = new Buffer();
            return Okio.buffer((Sink) new ForwardingSink(buffer) {
                /* JADX INFO: finally extract failed */
                public void close() throws IOException {
                    if (JsonValueWriter.this.b() == 9) {
                        JsonValueWriter jsonValueWriter = JsonValueWriter.this;
                        Object[] objArr = jsonValueWriter.f53274k;
                        int i11 = jsonValueWriter.f53277b;
                        if (objArr[i11] == null) {
                            jsonValueWriter.f53277b = i11 - 1;
                            Object readJsonValue = JsonReader.of(buffer).readJsonValue();
                            JsonValueWriter jsonValueWriter2 = JsonValueWriter.this;
                            boolean z11 = jsonValueWriter2.f53283h;
                            jsonValueWriter2.f53283h = true;
                            try {
                                JsonValueWriter unused = jsonValueWriter2.add(readJsonValue);
                                JsonValueWriter jsonValueWriter3 = JsonValueWriter.this;
                                jsonValueWriter3.f53283h = z11;
                                int[] iArr = jsonValueWriter3.f53280e;
                                int i12 = jsonValueWriter3.f53277b - 1;
                                iArr[i12] = iArr[i12] + 1;
                                return;
                            } catch (Throwable th2) {
                                JsonValueWriter.this.f53283h = z11;
                                throw th2;
                            }
                        }
                    }
                    throw new AssertionError();
                }
            });
        } else {
            throw new IllegalStateException("Sink from valueSink() was not closed");
        }
    }

    public JsonWriter value(boolean z11) throws IOException {
        if (!this.f53284i) {
            add(Boolean.valueOf(z11));
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    public JsonWriter value(@Nullable Boolean bool) throws IOException {
        if (!this.f53284i) {
            add(bool);
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    public JsonWriter value(double d11) throws IOException {
        if (!this.f53282g && (Double.isNaN(d11) || d11 == Double.NEGATIVE_INFINITY || d11 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d11);
        } else if (this.f53284i) {
            this.f53284i = false;
            return name(Double.toString(d11));
        } else {
            add(Double.valueOf(d11));
            int[] iArr = this.f53280e;
            int i11 = this.f53277b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this;
        }
    }

    public JsonWriter value(long j11) throws IOException {
        if (this.f53284i) {
            this.f53284i = false;
            return name(Long.toString(j11));
        }
        add(Long.valueOf(j11));
        int[] iArr = this.f53280e;
        int i11 = this.f53277b - 1;
        iArr[i11] = iArr[i11] + 1;
        return this;
    }

    public JsonWriter value(@Nullable Number number) throws IOException {
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            return value(number.longValue());
        }
        if ((number instanceof Float) || (number instanceof Double)) {
            return value(number.doubleValue());
        }
        if (number == null) {
            return nullValue();
        }
        BigDecimal bigDecimal = number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
        if (this.f53284i) {
            this.f53284i = false;
            return name(bigDecimal.toString());
        }
        add(bigDecimal);
        int[] iArr = this.f53280e;
        int i11 = this.f53277b - 1;
        iArr[i11] = iArr[i11] + 1;
        return this;
    }
}
