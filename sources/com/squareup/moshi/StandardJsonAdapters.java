package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.asm.Advice;

final class StandardJsonAdapters {
    private static final String ERROR_FORMAT = "Expected %s but was %s at path %s";
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return StandardJsonAdapters.f53326a;
            }
            if (type == Byte.TYPE) {
                return StandardJsonAdapters.f53327b;
            }
            if (type == Character.TYPE) {
                return StandardJsonAdapters.f53328c;
            }
            if (type == Double.TYPE) {
                return StandardJsonAdapters.f53329d;
            }
            if (type == Float.TYPE) {
                return StandardJsonAdapters.f53330e;
            }
            if (type == Integer.TYPE) {
                return StandardJsonAdapters.f53331f;
            }
            if (type == Long.TYPE) {
                return StandardJsonAdapters.f53332g;
            }
            if (type == Short.TYPE) {
                return StandardJsonAdapters.f53333h;
            }
            if (type == Boolean.class) {
                return StandardJsonAdapters.f53326a.nullSafe();
            }
            if (type == Byte.class) {
                return StandardJsonAdapters.f53327b.nullSafe();
            }
            if (type == Character.class) {
                return StandardJsonAdapters.f53328c.nullSafe();
            }
            if (type == Double.class) {
                return StandardJsonAdapters.f53329d.nullSafe();
            }
            if (type == Float.class) {
                return StandardJsonAdapters.f53330e.nullSafe();
            }
            if (type == Integer.class) {
                return StandardJsonAdapters.f53331f.nullSafe();
            }
            if (type == Long.class) {
                return StandardJsonAdapters.f53332g.nullSafe();
            }
            if (type == Short.class) {
                return StandardJsonAdapters.f53333h.nullSafe();
            }
            if (type == String.class) {
                return StandardJsonAdapters.f53334i.nullSafe();
            }
            if (type == Object.class) {
                return new ObjectJsonAdapter(moshi).nullSafe();
            }
            Class<?> rawType = Types.getRawType(type);
            JsonAdapter<?> generatedAdapter = Util.generatedAdapter(moshi, type, rawType);
            if (generatedAdapter != null) {
                return generatedAdapter;
            }
            if (rawType.isEnum()) {
                return new EnumJsonAdapter(rawType).nullSafe();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final JsonAdapter<Boolean> f53326a = new JsonAdapter<Boolean>() {
        public String toString() {
            return "JsonAdapter(Boolean)";
        }

        public Boolean fromJson(JsonReader jsonReader) throws IOException {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        public void toJson(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool.booleanValue());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final JsonAdapter<Byte> f53327b = new JsonAdapter<Byte>() {
        public String toString() {
            return "JsonAdapter(Byte)";
        }

        public Byte fromJson(JsonReader jsonReader) throws IOException {
            return Byte.valueOf((byte) StandardJsonAdapters.a(jsonReader, "a byte", -128, 255));
        }

        public void toJson(JsonWriter jsonWriter, Byte b11) throws IOException {
            jsonWriter.value((long) (b11.intValue() & 255));
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final JsonAdapter<Character> f53328c = new JsonAdapter<Character>() {
        public String toString() {
            return "JsonAdapter(Character)";
        }

        public Character fromJson(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            if (nextString.length() <= 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonDataException(String.format(StandardJsonAdapters.ERROR_FORMAT, new Object[]{"a char", '\"' + nextString + '\"', jsonReader.getPath()}));
        }

        public void toJson(JsonWriter jsonWriter, Character ch2) throws IOException {
            jsonWriter.value(ch2.toString());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final JsonAdapter<Double> f53329d = new JsonAdapter<Double>() {
        public String toString() {
            return "JsonAdapter(Double)";
        }

        public Double fromJson(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }

        public void toJson(JsonWriter jsonWriter, Double d11) throws IOException {
            jsonWriter.value(d11.doubleValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final JsonAdapter<Float> f53330e = new JsonAdapter<Float>() {
        public String toString() {
            return "JsonAdapter(Float)";
        }

        public Float fromJson(JsonReader jsonReader) throws IOException {
            float nextDouble = (float) jsonReader.nextDouble();
            if (jsonReader.isLenient() || !Float.isInfinite(nextDouble)) {
                return Float.valueOf(nextDouble);
            }
            throw new JsonDataException("JSON forbids NaN and infinities: " + nextDouble + " at path " + jsonReader.getPath());
        }

        public void toJson(JsonWriter jsonWriter, Float f11) throws IOException {
            f11.getClass();
            jsonWriter.value((Number) f11);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final JsonAdapter<Integer> f53331f = new JsonAdapter<Integer>() {
        public String toString() {
            return "JsonAdapter(Integer)";
        }

        public Integer fromJson(JsonReader jsonReader) throws IOException {
            return Integer.valueOf(jsonReader.nextInt());
        }

        public void toJson(JsonWriter jsonWriter, Integer num) throws IOException {
            jsonWriter.value((long) num.intValue());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final JsonAdapter<Long> f53332g = new JsonAdapter<Long>() {
        public String toString() {
            return "JsonAdapter(Long)";
        }

        public Long fromJson(JsonReader jsonReader) throws IOException {
            return Long.valueOf(jsonReader.nextLong());
        }

        public void toJson(JsonWriter jsonWriter, Long l11) throws IOException {
            jsonWriter.value(l11.longValue());
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final JsonAdapter<Short> f53333h = new JsonAdapter<Short>() {
        public String toString() {
            return "JsonAdapter(Short)";
        }

        public Short fromJson(JsonReader jsonReader) throws IOException {
            return Short.valueOf((short) StandardJsonAdapters.a(jsonReader, "a short", -32768, Advice.MethodSizeHandler.UNDEFINED_SIZE));
        }

        public void toJson(JsonWriter jsonWriter, Short sh2) throws IOException {
            jsonWriter.value((long) sh2.intValue());
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final JsonAdapter<String> f53334i = new JsonAdapter<String>() {
        public String toString() {
            return "JsonAdapter(String)";
        }

        public String fromJson(JsonReader jsonReader) throws IOException {
            return jsonReader.nextString();
        }

        public void toJson(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    };

    /* renamed from: com.squareup.moshi.StandardJsonAdapters$11  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass11 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f53335a;

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
                f53335a = r0
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f53335a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f53335a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f53335a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f53335a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f53335a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.StandardJsonAdapters.AnonymousClass11.<clinit>():void");
        }
    }

    public static final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
        private final T[] constants;
        private final Class<T> enumType;
        private final String[] nameStrings;
        private final JsonReader.Options options;

        public EnumJsonAdapter(Class<T> cls) {
            this.enumType = cls;
            try {
                T[] tArr = (Enum[]) cls.getEnumConstants();
                this.constants = tArr;
                this.nameStrings = new String[tArr.length];
                int i11 = 0;
                while (true) {
                    T[] tArr2 = this.constants;
                    if (i11 < tArr2.length) {
                        String name2 = tArr2[i11].name();
                        this.nameStrings[i11] = Util.jsonName(name2, (AnnotatedElement) cls.getField(name2));
                        i11++;
                    } else {
                        this.options = JsonReader.Options.of(this.nameStrings);
                        return;
                    }
                }
            } catch (NoSuchFieldException e11) {
                throw new AssertionError("Missing field in " + cls.getName(), e11);
            }
        }

        public String toString() {
            return "JsonAdapter(" + this.enumType.getName() + ")";
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            int selectString = jsonReader.selectString(this.options);
            if (selectString != -1) {
                return this.constants[selectString];
            }
            String path = jsonReader.getPath();
            String nextString = jsonReader.nextString();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.nameStrings) + " but was " + nextString + " at path " + path);
        }

        public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
            jsonWriter.value(this.nameStrings[t11.ordinal()]);
        }
    }

    public static final class ObjectJsonAdapter extends JsonAdapter<Object> {
        private final JsonAdapter<Boolean> booleanAdapter;
        private final JsonAdapter<Double> doubleAdapter;
        private final JsonAdapter<List> listJsonAdapter;
        private final JsonAdapter<Map> mapAdapter;
        private final Moshi moshi;
        private final JsonAdapter<String> stringAdapter;

        public ObjectJsonAdapter(Moshi moshi2) {
            this.moshi = moshi2;
            this.listJsonAdapter = moshi2.adapter(List.class);
            this.mapAdapter = moshi2.adapter(Map.class);
            this.stringAdapter = moshi2.adapter(String.class);
            this.doubleAdapter = moshi2.adapter(Double.class);
            this.booleanAdapter = moshi2.adapter(Boolean.class);
        }

        private Class<?> toJsonType(Class<?> cls) {
            Class<Map> cls2 = Map.class;
            if (cls2.isAssignableFrom(cls)) {
                return cls2;
            }
            Class<Collection> cls3 = Collection.class;
            if (cls3.isAssignableFrom(cls)) {
                return cls3;
            }
            return cls;
        }

        public Object fromJson(JsonReader jsonReader) throws IOException {
            switch (AnonymousClass11.f53335a[jsonReader.peek().ordinal()]) {
                case 1:
                    return this.listJsonAdapter.fromJson(jsonReader);
                case 2:
                    return this.mapAdapter.fromJson(jsonReader);
                case 3:
                    return this.stringAdapter.fromJson(jsonReader);
                case 4:
                    return this.doubleAdapter.fromJson(jsonReader);
                case 5:
                    return this.booleanAdapter.fromJson(jsonReader);
                case 6:
                    return jsonReader.nextNull();
                default:
                    throw new IllegalStateException("Expected a value but was " + jsonReader.peek() + " at path " + jsonReader.getPath());
            }
        }

        public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls == Object.class) {
                jsonWriter.beginObject();
                jsonWriter.endObject();
                return;
            }
            this.moshi.adapter((Type) toJsonType(cls), (Set<? extends Annotation>) Util.NO_ANNOTATIONS).toJson(jsonWriter, obj);
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    private StandardJsonAdapters() {
    }

    public static int a(JsonReader jsonReader, String str, int i11, int i12) throws IOException {
        int nextInt = jsonReader.nextInt();
        if (nextInt >= i11 && nextInt <= i12) {
            return nextInt;
        }
        throw new JsonDataException(String.format(ERROR_FORMAT, new Object[]{str, Integer.valueOf(nextInt), jsonReader.getPath()}));
    }
}
