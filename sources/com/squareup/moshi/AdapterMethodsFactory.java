package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

final class AdapterMethodsFactory implements JsonAdapter.Factory {
    private final List<AdapterMethod> fromAdapters;
    private final List<AdapterMethod> toAdapters;

    public static abstract class AdapterMethod {

        /* renamed from: a  reason: collision with root package name */
        public final Type f53226a;

        /* renamed from: b  reason: collision with root package name */
        public final Set<? extends Annotation> f53227b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f53228c;

        /* renamed from: d  reason: collision with root package name */
        public final Method f53229d;

        /* renamed from: e  reason: collision with root package name */
        public final int f53230e;

        /* renamed from: f  reason: collision with root package name */
        public final JsonAdapter<?>[] f53231f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f53232g;

        public AdapterMethod(Type type, Set<? extends Annotation> set, Object obj, Method method, int i11, int i12, boolean z11) {
            this.f53226a = Util.canonicalize(type);
            this.f53227b = set;
            this.f53228c = obj;
            this.f53229d = method;
            this.f53230e = i12;
            this.f53231f = new JsonAdapter[(i11 - i12)];
            this.f53232g = z11;
        }

        @Nullable
        public Object a(@Nullable Object obj) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.f53231f;
            Object[] objArr = new Object[(jsonAdapterArr.length + 1)];
            objArr[0] = obj;
            System.arraycopy(jsonAdapterArr, 0, objArr, 1, jsonAdapterArr.length);
            try {
                return this.f53229d.invoke(this.f53228c, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        public Object b(@Nullable Object obj, @Nullable Object obj2) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.f53231f;
            Object[] objArr = new Object[(jsonAdapterArr.length + 2)];
            objArr[0] = obj;
            objArr[1] = obj2;
            System.arraycopy(jsonAdapterArr, 0, objArr, 2, jsonAdapterArr.length);
            try {
                return this.f53229d.invoke(this.f53228c, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        public void bind(Moshi moshi, JsonAdapter.Factory factory) {
            JsonAdapter<?> jsonAdapter;
            if (this.f53231f.length > 0) {
                Type[] genericParameterTypes = this.f53229d.getGenericParameterTypes();
                Annotation[][] parameterAnnotations = this.f53229d.getParameterAnnotations();
                int length = genericParameterTypes.length;
                for (int i11 = this.f53230e; i11 < length; i11++) {
                    Type type = ((ParameterizedType) genericParameterTypes[i11]).getActualTypeArguments()[0];
                    Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(parameterAnnotations[i11]);
                    JsonAdapter<?>[] jsonAdapterArr = this.f53231f;
                    int i12 = i11 - this.f53230e;
                    if (!Types.equals(this.f53226a, type) || !this.f53227b.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(type, jsonAnnotations);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, type, jsonAnnotations);
                    }
                    jsonAdapterArr[i12] = jsonAdapter;
                }
            }
        }

        @Nullable
        public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }
    }

    public AdapterMethodsFactory(List<AdapterMethod> list, List<AdapterMethod> list2) {
        this.toAdapters = list;
        this.fromAdapters = list2;
    }

    public static AdapterMethod a(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) method);
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 1 && genericParameterTypes[0] == JsonReader.class && genericReturnType != Void.TYPE && parametersAreJsonAdapters(1, genericParameterTypes)) {
            return new AdapterMethod(genericReturnType, jsonAnnotations, obj, method, genericParameterTypes.length, 1, true) {
                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                    return a(jsonReader);
                }
            };
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> R fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(JsonReader jsonReader, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
        } else {
            final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            return new AdapterMethod(genericReturnType, jsonAnnotations, obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) {

                /* renamed from: h  reason: collision with root package name */
                public JsonAdapter<Object> f53221h;

                public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                    JsonAdapter<Object> jsonAdapter;
                    super.bind(moshi, factory);
                    if (!Types.equals(genericParameterTypes[0], genericReturnType) || !jsonAnnotations2.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(genericParameterTypes[0], (Set<? extends Annotation>) jsonAnnotations2);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, genericParameterTypes[0], jsonAnnotations2);
                    }
                    this.f53221h = jsonAdapter;
                }

                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                    return a(this.f53221h.fromJson(jsonReader));
                }
            };
        }
    }

    public static AdapterMethod b(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 2 && genericParameterTypes[0] == JsonWriter.class && genericReturnType == Void.TYPE && parametersAreJsonAdapters(2, genericParameterTypes)) {
            return new AdapterMethod(genericParameterTypes[1], Util.jsonAnnotations(parameterAnnotations[1]), obj, method, genericParameterTypes.length, 2, true) {
                public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj) throws IOException, InvocationTargetException {
                    b(jsonWriter, obj);
                }
            };
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, T value, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
        } else {
            final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) method);
            final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            return new AdapterMethod(genericParameterTypes[0], jsonAnnotations2, obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) {
                private JsonAdapter<Object> delegate;

                public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                    JsonAdapter<Object> jsonAdapter;
                    super.bind(moshi, factory);
                    if (!Types.equals(genericParameterTypes[0], genericReturnType) || !jsonAnnotations2.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(genericReturnType, (Set<? extends Annotation>) jsonAnnotations);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, genericReturnType, jsonAnnotations);
                    }
                    this.delegate = jsonAdapter;
                }

                public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj) throws IOException, InvocationTargetException {
                    this.delegate.toJson(jsonWriter, a(obj));
                }
            };
        }
    }

    public static AdapterMethodsFactory get(Object obj) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ToJson.class)) {
                    AdapterMethod b11 = b(obj, method);
                    AdapterMethod adapterMethod = get(arrayList, b11.f53226a, b11.f53227b);
                    if (adapterMethod == null) {
                        arrayList.add(b11);
                    } else {
                        throw new IllegalArgumentException("Conflicting @ToJson methods:\n    " + adapterMethod.f53229d + "\n    " + b11.f53229d);
                    }
                }
                if (method.isAnnotationPresent(FromJson.class)) {
                    AdapterMethod a11 = a(obj, method);
                    AdapterMethod adapterMethod2 = get(arrayList2, a11.f53226a, a11.f53227b);
                    if (adapterMethod2 == null) {
                        arrayList2.add(a11);
                    } else {
                        throw new IllegalArgumentException("Conflicting @FromJson methods:\n    " + adapterMethod2.f53229d + "\n    " + a11.f53229d);
                    }
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return new AdapterMethodsFactory(arrayList, arrayList2);
        }
        throw new IllegalArgumentException("Expected at least one @ToJson or @FromJson method on " + obj.getClass().getName());
    }

    private static boolean parametersAreJsonAdapters(int i11, Type[] typeArr) {
        int length = typeArr.length;
        while (i11 < length) {
            ParameterizedType parameterizedType = typeArr[i11];
            if (!(parameterizedType instanceof ParameterizedType) || parameterizedType.getRawType() != JsonAdapter.class) {
                return false;
            }
            i11++;
        }
        return true;
    }

    @Nullable
    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        String str;
        final AdapterMethod adapterMethod = get(this.toAdapters, type, set);
        final AdapterMethod adapterMethod2 = get(this.fromAdapters, type, set);
        JsonAdapter<T> jsonAdapter = null;
        if (adapterMethod == null && adapterMethod2 == null) {
            return null;
        }
        if (adapterMethod == null || adapterMethod2 == null) {
            try {
                jsonAdapter = moshi.nextAdapter(this, type, set);
            } catch (IllegalArgumentException e11) {
                if (adapterMethod == null) {
                    str = "@ToJson";
                } else {
                    str = "@FromJson";
                }
                throw new IllegalArgumentException("No " + str + " adapter for " + Util.typeAnnotatedWithAnnotations(type, set), e11);
            }
        }
        final JsonAdapter<T> jsonAdapter2 = jsonAdapter;
        if (adapterMethod != null) {
            adapterMethod.bind(moshi, this);
        }
        if (adapterMethod2 != null) {
            adapterMethod2.bind(moshi, this);
        }
        final Moshi moshi2 = moshi;
        final Set<? extends Annotation> set2 = set;
        final Type type2 = type;
        return new JsonAdapter<Object>() {
            @Nullable
            public Object fromJson(JsonReader jsonReader) throws IOException {
                AdapterMethod adapterMethod = adapterMethod2;
                if (adapterMethod == null) {
                    return jsonAdapter2.fromJson(jsonReader);
                }
                if (adapterMethod.f53232g || jsonReader.peek() != JsonReader.Token.NULL) {
                    try {
                        return adapterMethod2.fromJson(moshi2, jsonReader);
                    } catch (InvocationTargetException e11) {
                        Throwable cause = e11.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        throw new JsonDataException(cause + " at " + jsonReader.getPath(), cause);
                    }
                } else {
                    jsonReader.nextNull();
                    return null;
                }
            }

            public void toJson(JsonWriter jsonWriter, @Nullable Object obj) throws IOException {
                AdapterMethod adapterMethod = adapterMethod;
                if (adapterMethod == null) {
                    jsonAdapter2.toJson(jsonWriter, obj);
                } else if (adapterMethod.f53232g || obj != null) {
                    try {
                        adapterMethod.toJson(moshi2, jsonWriter, obj);
                    } catch (InvocationTargetException e11) {
                        Throwable cause = e11.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        throw new JsonDataException(cause + " at " + jsonWriter.getPath(), cause);
                    }
                } else {
                    jsonWriter.nullValue();
                }
            }

            public String toString() {
                return "JsonAdapter" + set2 + "(" + type2 + ")";
            }
        };
    }

    @Nullable
    private static AdapterMethod get(List<AdapterMethod> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            AdapterMethod adapterMethod = list.get(i11);
            if (Types.equals(adapterMethod.f53226a, type) && adapterMethod.f53227b.equals(set)) {
                return adapterMethod;
            }
        }
        return null;
    }
}
