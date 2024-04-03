package com.squareup.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public int f53255b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f53256c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f53257d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f53258e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53259f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53260g;
    private Map<Class<?>, Object> tags;

    /* renamed from: com.squareup.moshi.JsonReader$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f53261a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.squareup.moshi.JsonReader$Token[] r0 = com.squareup.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f53261a = r0
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f53261a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f53261a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f53261a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f53261a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f53261a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonReader.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Options {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f53262a;

        /* renamed from: b  reason: collision with root package name */
        public final okio.Options f53263b;

        private Options(String[] strArr, okio.Options options) {
            this.f53262a = strArr;
            this.f53263b = options;
        }

        @CheckReturnValue
        public static Options of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    JsonUtf8Writer.f(buffer, strArr[i11]);
                    buffer.readByte();
                    byteStringArr[i11] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.of(byteStringArr));
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public List<String> strings() {
            return Collections.unmodifiableList(Arrays.asList(this.f53262a));
        }
    }

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public JsonReader() {
        this.f53256c = new int[32];
        this.f53257d = new String[32];
        this.f53258e = new int[32];
    }

    @CheckReturnValue
    public static JsonReader of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    public final void a(int i11) {
        int i12 = this.f53255b;
        int[] iArr = this.f53256c;
        if (i12 == iArr.length) {
            if (i12 != 256) {
                this.f53256c = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f53257d;
                this.f53257d = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f53258e;
                this.f53258e = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f53256c;
        int i13 = this.f53255b;
        this.f53255b = i13 + 1;
        iArr3[i13] = i11;
    }

    public final JsonEncodingException b(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public final JsonDataException c(@Nullable Object obj, Object obj2) {
        if (obj == null) {
            return new JsonDataException("Expected " + obj2 + " but was null at path " + getPath());
        }
        return new JsonDataException("Expected " + obj2 + " but was " + obj + ", a " + obj.getClass().getName() + ", at path " + getPath());
    }

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    @CheckReturnValue
    public final boolean failOnUnknown() {
        return this.f53260g;
    }

    @CheckReturnValue
    public final String getPath() {
        return JsonScope.a(this.f53255b, this.f53256c, this.f53257d, this.f53258e);
    }

    @CheckReturnValue
    public abstract boolean hasNext() throws IOException;

    @CheckReturnValue
    public final boolean isLenient() {
        return this.f53259f;
    }

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract long nextLong() throws IOException;

    @CheckReturnValue
    public abstract String nextName() throws IOException;

    @Nullable
    public abstract <T> T nextNull() throws IOException;

    public abstract BufferedSource nextSource() throws IOException;

    public abstract String nextString() throws IOException;

    @CheckReturnValue
    public abstract Token peek() throws IOException;

    @CheckReturnValue
    public abstract JsonReader peekJson();

    public abstract void promoteNameToValue() throws IOException;

    @Nullable
    public final Object readJsonValue() throws IOException {
        switch (AnonymousClass1.f53261a[peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                beginArray();
                while (hasNext()) {
                    arrayList.add(readJsonValue());
                }
                endArray();
                return arrayList;
            case 2:
                LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
                beginObject();
                while (hasNext()) {
                    String nextName = nextName();
                    Object readJsonValue = readJsonValue();
                    Object put = linkedHashTreeMap.put(nextName, readJsonValue);
                    if (put != null) {
                        throw new JsonDataException("Map key '" + nextName + "' has multiple values at path " + getPath() + ": " + put + " and " + readJsonValue);
                    }
                }
                endObject();
                return linkedHashTreeMap;
            case 3:
                return nextString();
            case 4:
                return Double.valueOf(nextDouble());
            case 5:
                return Boolean.valueOf(nextBoolean());
            case 6:
                return nextNull();
            default:
                throw new IllegalStateException("Expected a value but was " + peek() + " at path " + getPath());
        }
    }

    @CheckReturnValue
    public abstract int selectName(Options options) throws IOException;

    @CheckReturnValue
    public abstract int selectString(Options options) throws IOException;

    public final void setFailOnUnknown(boolean z11) {
        this.f53260g = z11;
    }

    public final void setLenient(boolean z11) {
        this.f53259f = z11;
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

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    @CheckReturnValue
    @Nullable
    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return map.get(cls);
    }

    public JsonReader(JsonReader jsonReader) {
        this.f53255b = jsonReader.f53255b;
        this.f53256c = (int[]) jsonReader.f53256c.clone();
        this.f53257d = (String[]) jsonReader.f53257d.clone();
        this.f53258e = (int[]) jsonReader.f53258e.clone();
        this.f53259f = jsonReader.f53259f;
        this.f53260g = jsonReader.f53260g;
    }
}
