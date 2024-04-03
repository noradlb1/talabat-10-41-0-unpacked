package com.squareup.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class PolymorphicJsonAdapterFactory<T> implements JsonAdapter.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final Class<T> f53344a;

    /* renamed from: b  reason: collision with root package name */
    public final String f53345b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f53346c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Type> f53347d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final JsonAdapter<Object> f53348e;

    public static final class PolymorphicJsonAdapter extends JsonAdapter<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final String f53351a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f53352b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Type> f53353c;

        /* renamed from: d  reason: collision with root package name */
        public final List<JsonAdapter<Object>> f53354d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final JsonAdapter<Object> f53355e;

        /* renamed from: f  reason: collision with root package name */
        public final JsonReader.Options f53356f;

        /* renamed from: g  reason: collision with root package name */
        public final JsonReader.Options f53357g;

        public PolymorphicJsonAdapter(String str, List<String> list, List<Type> list2, List<JsonAdapter<Object>> list3, @Nullable JsonAdapter<Object> jsonAdapter) {
            this.f53351a = str;
            this.f53352b = list;
            this.f53353c = list2;
            this.f53354d = list3;
            this.f53355e = jsonAdapter;
            this.f53356f = JsonReader.Options.of(str);
            this.f53357g = JsonReader.Options.of((String[]) list.toArray(new String[0]));
        }

        private int labelIndex(JsonReader jsonReader) throws IOException {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.selectName(this.f53356f) == -1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    int selectString = jsonReader.selectString(this.f53357g);
                    if (selectString != -1 || this.f53355e != null) {
                        return selectString;
                    }
                    throw new JsonDataException("Expected one of " + this.f53352b + " for key '" + this.f53351a + "' but found '" + jsonReader.nextString() + "'. Register a subtype for this label.");
                }
            }
            throw new JsonDataException("Missing label for " + this.f53351a);
        }

        /* JADX INFO: finally extract failed */
        public Object fromJson(JsonReader jsonReader) throws IOException {
            JsonReader peekJson = jsonReader.peekJson();
            peekJson.setFailOnUnknown(false);
            try {
                int labelIndex = labelIndex(peekJson);
                peekJson.close();
                if (labelIndex == -1) {
                    return this.f53355e.fromJson(jsonReader);
                }
                return this.f53354d.get(labelIndex).fromJson(jsonReader);
            } catch (Throwable th2) {
                peekJson.close();
                throw th2;
            }
        }

        public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            JsonAdapter<Object> jsonAdapter;
            int indexOf = this.f53353c.indexOf(obj.getClass());
            if (indexOf == -1) {
                jsonAdapter = this.f53355e;
                if (jsonAdapter == null) {
                    throw new IllegalArgumentException("Expected one of " + this.f53353c + " but found " + obj + ", a " + obj.getClass() + ". Register this subtype.");
                }
            } else {
                jsonAdapter = this.f53354d.get(indexOf);
            }
            jsonWriter.beginObject();
            if (jsonAdapter != this.f53355e) {
                jsonWriter.name(this.f53351a).value(this.f53352b.get(indexOf));
            }
            int beginFlatten = jsonWriter.beginFlatten();
            jsonAdapter.toJson(jsonWriter, obj);
            jsonWriter.endFlatten(beginFlatten);
            jsonWriter.endObject();
        }

        public String toString() {
            return "PolymorphicJsonAdapter(" + this.f53351a + ")";
        }
    }

    public PolymorphicJsonAdapterFactory(Class<T> cls, String str, List<String> list, List<Type> list2, @Nullable JsonAdapter<Object> jsonAdapter) {
        this.f53344a = cls;
        this.f53345b = str;
        this.f53346c = list;
        this.f53347d = list2;
        this.f53348e = jsonAdapter;
    }

    private JsonAdapter<Object> buildFallbackJsonAdapter(final T t11) {
        return new JsonAdapter<Object>() {
            @Nullable
            public Object fromJson(JsonReader jsonReader) throws IOException {
                jsonReader.skipValue();
                return t11;
            }

            public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                throw new IllegalArgumentException("Expected one of " + PolymorphicJsonAdapterFactory.this.f53347d + " but found " + obj + ", a " + obj.getClass() + ". Register this subtype.");
            }
        };
    }

    @CheckReturnValue
    public static <T> PolymorphicJsonAdapterFactory<T> of(Class<T> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("baseType == null");
        } else if (str != null) {
            return new PolymorphicJsonAdapterFactory(cls, str, Collections.emptyList(), Collections.emptyList(), (JsonAdapter<Object>) null);
        } else {
            throw new NullPointerException("labelKey == null");
        }
    }

    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        if (Types.getRawType(type) != this.f53344a || !set.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f53347d.size());
        int size = this.f53347d.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(moshi.adapter(this.f53347d.get(i11)));
        }
        return new PolymorphicJsonAdapter(this.f53345b, this.f53346c, this.f53347d, arrayList, this.f53348e).nullSafe();
    }

    public PolymorphicJsonAdapterFactory<T> withDefaultValue(@Nullable T t11) {
        return withFallbackJsonAdapter(buildFallbackJsonAdapter(t11));
    }

    public PolymorphicJsonAdapterFactory<T> withFallbackJsonAdapter(@Nullable JsonAdapter<Object> jsonAdapter) {
        return new PolymorphicJsonAdapterFactory(this.f53344a, this.f53345b, this.f53346c, this.f53347d, jsonAdapter);
    }

    public PolymorphicJsonAdapterFactory<T> withSubtype(Class<? extends T> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("subtype == null");
        } else if (str == null) {
            throw new NullPointerException("label == null");
        } else if (!this.f53346c.contains(str)) {
            ArrayList arrayList = new ArrayList(this.f53346c);
            arrayList.add(str);
            ArrayList arrayList2 = new ArrayList(this.f53347d);
            arrayList2.add(cls);
            return new PolymorphicJsonAdapterFactory(this.f53344a, this.f53345b, arrayList, arrayList2, this.f53348e);
        } else {
            throw new IllegalArgumentException("Labels must be unique.");
        }
    }
}
