package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

abstract class CollectionJsonAdapter<C extends Collection<T>, T> extends JsonAdapter<C> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType = Types.getRawType(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (rawType == List.class || rawType == Collection.class) {
                return CollectionJsonAdapter.a(type, moshi).nullSafe();
            }
            if (rawType == Set.class) {
                return CollectionJsonAdapter.c(type, moshi).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<T> elementAdapter;

    public static <T> JsonAdapter<Collection<T>> a(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Collection<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) {
            public Collection<T> b() {
                return new ArrayList();
            }

            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
                return CollectionJsonAdapter.super.fromJson(jsonReader);
            }

            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                CollectionJsonAdapter.super.toJson(jsonWriter, (Collection) obj);
            }
        };
    }

    public static <T> JsonAdapter<Set<T>> c(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Set<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) {
            /* renamed from: d */
            public Set<T> b() {
                return new LinkedHashSet();
            }

            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
                return CollectionJsonAdapter.super.fromJson(jsonReader);
            }

            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                CollectionJsonAdapter.super.toJson(jsonWriter, (Collection) obj);
            }
        };
    }

    public abstract C b();

    public String toString() {
        return this.elementAdapter + ".collection()";
    }

    private CollectionJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.elementAdapter = jsonAdapter;
    }

    public C fromJson(JsonReader jsonReader) throws IOException {
        C b11 = b();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            b11.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        return b11;
    }

    public void toJson(JsonWriter jsonWriter, C c11) throws IOException {
        jsonWriter.beginArray();
        for (Object json : c11) {
            this.elementAdapter.toJson(jsonWriter, json);
        }
        jsonWriter.endArray();
    }
}
