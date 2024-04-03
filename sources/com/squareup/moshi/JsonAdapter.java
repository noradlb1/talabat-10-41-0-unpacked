package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class JsonAdapter<T> {

    public interface Factory {
        @CheckReturnValue
        @Nullable
        JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi);
    }

    @CheckReturnValue
    public final JsonAdapter<T> failOnUnknown() {
        return new JsonAdapter<T>() {
            @Nullable
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean failOnUnknown = jsonReader.failOnUnknown();
                jsonReader.setFailOnUnknown(true);
                try {
                    return this.fromJson(jsonReader);
                } finally {
                    jsonReader.setFailOnUnknown(failOnUnknown);
                }
            }

            public boolean isLenient() {
                return this.isLenient();
            }

            public void toJson(JsonWriter jsonWriter, @Nullable T t11) throws IOException {
                this.toJson(jsonWriter, t11);
            }

            public String toString() {
                return this + ".failOnUnknown()";
            }
        };
    }

    @CheckReturnValue
    @Nullable
    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    @CheckReturnValue
    @Nullable
    public final T fromJson(BufferedSource bufferedSource) throws IOException {
        return fromJson(JsonReader.of(bufferedSource));
    }

    @CheckReturnValue
    @Nullable
    public final T fromJsonValue(@Nullable Object obj) {
        try {
            return fromJson((JsonReader) new JsonValueReader(obj));
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    @CheckReturnValue
    public JsonAdapter<T> indent(final String str) {
        if (str != null) {
            return new JsonAdapter<T>() {
                @Nullable
                public T fromJson(JsonReader jsonReader) throws IOException {
                    return this.fromJson(jsonReader);
                }

                public boolean isLenient() {
                    return this.isLenient();
                }

                public void toJson(JsonWriter jsonWriter, @Nullable T t11) throws IOException {
                    String indent = jsonWriter.getIndent();
                    jsonWriter.setIndent(str);
                    try {
                        this.toJson(jsonWriter, t11);
                    } finally {
                        jsonWriter.setIndent(indent);
                    }
                }

                public String toString() {
                    return this + ".indent(\"" + str + "\")";
                }
            };
        }
        throw new NullPointerException("indent == null");
    }

    public boolean isLenient() {
        return false;
    }

    @CheckReturnValue
    public final JsonAdapter<T> lenient() {
        return new JsonAdapter<T>() {
            @Nullable
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean isLenient = jsonReader.isLenient();
                jsonReader.setLenient(true);
                try {
                    return this.fromJson(jsonReader);
                } finally {
                    jsonReader.setLenient(isLenient);
                }
            }

            public boolean isLenient() {
                return true;
            }

            public void toJson(JsonWriter jsonWriter, @Nullable T t11) throws IOException {
                boolean isLenient = jsonWriter.isLenient();
                jsonWriter.setLenient(true);
                try {
                    this.toJson(jsonWriter, t11);
                } finally {
                    jsonWriter.setLenient(isLenient);
                }
            }

            public String toString() {
                return this + ".lenient()";
            }
        };
    }

    @CheckReturnValue
    public final JsonAdapter<T> nonNull() {
        if (this instanceof NonNullJsonAdapter) {
            return this;
        }
        return new NonNullJsonAdapter(this);
    }

    @CheckReturnValue
    public final JsonAdapter<T> nullSafe() {
        if (this instanceof NullSafeJsonAdapter) {
            return this;
        }
        return new NullSafeJsonAdapter(this);
    }

    @CheckReturnValue
    public final JsonAdapter<T> serializeNulls() {
        return new JsonAdapter<T>() {
            @Nullable
            public T fromJson(JsonReader jsonReader) throws IOException {
                return this.fromJson(jsonReader);
            }

            public boolean isLenient() {
                return this.isLenient();
            }

            public void toJson(JsonWriter jsonWriter, @Nullable T t11) throws IOException {
                boolean serializeNulls = jsonWriter.getSerializeNulls();
                jsonWriter.setSerializeNulls(true);
                try {
                    this.toJson(jsonWriter, t11);
                } finally {
                    jsonWriter.setSerializeNulls(serializeNulls);
                }
            }

            public String toString() {
                return this + ".serializeNulls()";
            }
        };
    }

    public abstract void toJson(JsonWriter jsonWriter, @Nullable T t11) throws IOException;

    public final void toJson(BufferedSink bufferedSink, @Nullable T t11) throws IOException {
        toJson(JsonWriter.of(bufferedSink), t11);
    }

    @CheckReturnValue
    @Nullable
    public final Object toJsonValue(@Nullable T t11) {
        JsonValueWriter jsonValueWriter = new JsonValueWriter();
        try {
            toJson((JsonWriter) jsonValueWriter, t11);
            return jsonValueWriter.root();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    @CheckReturnValue
    @Nullable
    public final T fromJson(String str) throws IOException {
        JsonReader of2 = JsonReader.of(new Buffer().writeUtf8(str));
        T fromJson = fromJson(of2);
        if (isLenient() || of2.peek() == JsonReader.Token.END_DOCUMENT) {
            return fromJson;
        }
        throw new JsonDataException("JSON document was not fully consumed.");
    }

    @CheckReturnValue
    public final String toJson(@Nullable T t11) {
        Buffer buffer = new Buffer();
        try {
            toJson((BufferedSink) buffer, t11);
            return buffer.readUtf8();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
