package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

final class ClassJsonAdapter<T> extends JsonAdapter<T> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        private void createFieldBindings(Moshi moshi, Type type, Map<String, FieldBinding<?>> map) {
            Json json;
            Class<?> rawType = Types.getRawType(type);
            boolean isPlatformType = Util.isPlatformType(rawType);
            for (Field field : rawType.getDeclaredFields()) {
                if (includeField(isPlatformType, field.getModifiers()) && ((json = (Json) field.getAnnotation(Json.class)) == null || !json.ignore())) {
                    Type resolve = Util.resolve(type, rawType, field.getGenericType());
                    Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) field);
                    String name2 = field.getName();
                    JsonAdapter<T> adapter = moshi.adapter(resolve, jsonAnnotations, name2);
                    field.setAccessible(true);
                    String jsonName = Util.jsonName(name2, json);
                    FieldBinding fieldBinding = new FieldBinding(jsonName, field, adapter);
                    FieldBinding put = map.put(jsonName, fieldBinding);
                    if (put != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + put.f53244b + "\n    " + fieldBinding.f53244b);
                    }
                }
            }
        }

        private boolean includeField(boolean z11, int i11) {
            if (Modifier.isStatic(i11) || Modifier.isTransient(i11)) {
                return false;
            }
            if (Modifier.isPublic(i11) || Modifier.isProtected(i11) || !z11) {
                return true;
            }
            return false;
        }

        private void throwIfIsCollectionClass(Type type, Class<?> cls) {
            Class<?> rawType = Types.getRawType(type);
            if (cls.isAssignableFrom(rawType)) {
                throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + rawType.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            }
        }

        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type);
            if (rawType.isInterface() || rawType.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (Util.isPlatformType(rawType)) {
                throwIfIsCollectionClass(type, List.class);
                throwIfIsCollectionClass(type, Set.class);
                throwIfIsCollectionClass(type, Map.class);
                throwIfIsCollectionClass(type, Collection.class);
                String str = "Platform " + rawType;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(str + " requires explicit JsonAdapter to be registered");
            } else if (rawType.isAnonymousClass()) {
                throw new IllegalArgumentException("Cannot serialize anonymous class " + rawType.getName());
            } else if (rawType.isLocalClass()) {
                throw new IllegalArgumentException("Cannot serialize local class " + rawType.getName());
            } else if (rawType.getEnclosingClass() != null && !Modifier.isStatic(rawType.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize non-static nested class " + rawType.getName());
            } else if (Modifier.isAbstract(rawType.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize abstract class " + rawType.getName());
            } else if (!Util.isKotlin(rawType)) {
                ClassFactory<?> classFactory = ClassFactory.get(rawType);
                TreeMap treeMap = new TreeMap();
                while (type != Object.class) {
                    createFieldBindings(moshi, type, treeMap);
                    type = Types.c(type);
                }
                return new ClassJsonAdapter(classFactory, treeMap).nullSafe();
            } else {
                throw new IllegalArgumentException("Cannot serialize Kotlin type " + rawType.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
            }
        }
    };
    private final ClassFactory<T> classFactory;
    private final FieldBinding<?>[] fieldsArray;
    private final JsonReader.Options options;

    public static class FieldBinding<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f53243a;

        /* renamed from: b  reason: collision with root package name */
        public final Field f53244b;

        /* renamed from: c  reason: collision with root package name */
        public final JsonAdapter<T> f53245c;

        public FieldBinding(String str, Field field, JsonAdapter<T> jsonAdapter) {
            this.f53243a = str;
            this.f53244b = field;
            this.f53245c = jsonAdapter;
        }

        public void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            this.f53244b.set(obj, this.f53245c.fromJson(jsonReader));
        }

        public void b(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
            this.f53245c.toJson(jsonWriter, this.f53244b.get(obj));
        }
    }

    public ClassJsonAdapter(ClassFactory<T> classFactory2, Map<String, FieldBinding<?>> map) {
        this.classFactory = classFactory2;
        this.fieldsArray = (FieldBinding[]) map.values().toArray(new FieldBinding[map.size()]);
        this.options = JsonReader.Options.of((String[]) map.keySet().toArray(new String[map.size()]));
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        try {
            T newInstance = this.classFactory.newInstance();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(this.options);
                    if (selectName == -1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        this.fieldsArray[selectName].a(jsonReader, newInstance);
                    }
                }
                jsonReader.endObject();
                return newInstance;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw Util.rethrowCause(e12);
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
        try {
            jsonWriter.beginObject();
            for (FieldBinding<?> fieldBinding : this.fieldsArray) {
                jsonWriter.name(fieldBinding.f53243a);
                fieldBinding.b(jsonWriter, t11);
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.classFactory + ")";
    }
}
