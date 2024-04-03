package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context = new GsonContextImpl();
    private volatile TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    @Instrumented
    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }

        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            Gson gson = TreeTypeAdapter.this.gson;
            return !(gson instanceof Gson) ? gson.fromJson(jsonElement, type) : GsonInstrumentation.fromJson(gson, jsonElement, type);
        }

        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z11, Class<?> cls) {
            JsonSerializer<?> jsonSerializer;
            boolean z12;
            JsonDeserializer<?> jsonDeserializer = null;
            if (obj instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) obj;
            } else {
                jsonSerializer = null;
            }
            this.serializer = jsonSerializer;
            jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : jsonDeserializer;
            this.deserializer = jsonDeserializer;
            if (jsonSerializer == null && jsonDeserializer == null) {
                z12 = false;
            } else {
                z12 = true;
            }
            C$Gson$Preconditions.checkArgument(z12);
            this.exactType = typeToken;
            this.matchRawType = z11;
            this.hierarchyType = cls;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean z11;
            TypeToken<?> typeToken2 = this.exactType;
            if (typeToken2 == null) {
                z11 = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            } else if (typeToken2.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType())) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson2;
        this.typeToken = typeToken2;
        this.skipPast = typeAdapterFactory;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken2, Object obj) {
        return new SingleTypeFactory(obj, typeToken2, false, (Class<?>) null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken2, Object obj) {
        boolean z11;
        if (typeToken2.getType() == typeToken2.getRawType()) {
            z11 = true;
        } else {
            z11 = false;
        }
        return new SingleTypeFactory(obj, typeToken2, z11, (Class<?>) null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, (TypeToken<?>) null, false, cls);
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
    }

    public void write(JsonWriter jsonWriter, T t11) throws IOException {
        JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, t11);
        } else if (t11 == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(t11, this.typeToken.getType(), this.context), jsonWriter);
        }
    }
}
