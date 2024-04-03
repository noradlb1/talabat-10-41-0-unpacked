package com.newrelic.com.google.gson.internal;

import com.newrelic.com.google.gson.ExclusionStrategy;
import com.newrelic.com.google.gson.FieldAttributes;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.TypeAdapter;
import com.newrelic.com.google.gson.TypeAdapterFactory;
import com.newrelic.com.google.gson.annotations.Expose;
import com.newrelic.com.google.gson.annotations.Since;
import com.newrelic.com.google.gson.annotations.Until;
import com.newrelic.com.google.gson.reflect.TypeToken;
import com.newrelic.com.google.gson.stream.JsonReader;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
    private int modifiers = Opcodes.L2I;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private boolean serializeInnerClasses = true;
    private double version = IGNORE_VERSIONS;

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((this.serializeInnerClasses || !isInnerClass(cls)) && !isAnonymousOrNonStaticLocal(cls)) {
            return false;
        }
        return true;
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z11) {
        List<ExclusionStrategy> list;
        if (z11) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        for (ExclusionStrategy shouldSkipClass : list) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) || isStatic(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) {
            return false;
        }
        return true;
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidSince(Since since) {
        if (since == null || since.value() <= this.version) {
            return true;
        }
        return false;
    }

    private boolean isValidUntil(Until until) {
        if (until == null || until.value() > this.version) {
            return true;
        }
        return false;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        final boolean z11;
        final boolean z12;
        Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        if (excludeClassChecks || excludeClassInStrategy(rawType, true)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (excludeClassChecks || excludeClassInStrategy(rawType, false)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 && !z12) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>() {
            private TypeAdapter<T> delegate;

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson2.getDelegateAdapter(Excluder.this, typeToken2);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }

            public T read(JsonReader jsonReader) throws IOException {
                if (!z12) {
                    return delegate().read(jsonReader);
                }
                jsonReader.skipValue();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t11) throws IOException {
                if (z11) {
                    jsonWriter.nullValue();
                } else {
                    delegate().write(jsonWriter, t11);
                }
            }
        };
    }

    public Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.serializeInnerClasses = false;
        return clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z11) {
        if (excludeClassChecks(cls) || excludeClassInStrategy(cls, z11)) {
            return true;
        }
        return false;
    }

    public boolean excludeField(Field field, boolean z11) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z11 ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrNonStaticLocal(field.getType())) {
            return true;
        }
        if (z11) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        for (ExclusionStrategy shouldSkipField : list) {
            if (shouldSkipField.shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.requireExpose = true;
        return clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z11, boolean z12) {
        Excluder clone = clone();
        if (z11) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z12) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.modifiers = 0;
        for (int i11 : iArr) {
            clone.modifiers = i11 | clone.modifiers;
        }
        return clone;
    }

    public Excluder withVersion(double d11) {
        Excluder clone = clone();
        clone.version = d11;
        return clone;
    }

    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }
}
