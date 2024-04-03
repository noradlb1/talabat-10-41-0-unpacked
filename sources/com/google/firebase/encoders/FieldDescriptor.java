package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor {

    /* renamed from: name  reason: collision with root package name */
    private final String f47416name;
    private final Map<Class<?>, Object> properties;

    public static final class Builder {

        /* renamed from: name  reason: collision with root package name */
        private final String f47417name;
        private Map<Class<?>, Object> properties = null;

        public Builder(String str) {
            this.f47417name = str;
        }

        @NonNull
        public FieldDescriptor build() {
            Map map;
            String str = this.f47417name;
            if (this.properties == null) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(new HashMap(this.properties));
            }
            return new FieldDescriptor(str, map);
        }

        @NonNull
        public <T extends Annotation> Builder withProperty(@NonNull T t11) {
            if (this.properties == null) {
                this.properties = new HashMap();
            }
            this.properties.put(t11.annotationType(), t11);
            return this;
        }
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new Builder(str);
    }

    @NonNull
    public static FieldDescriptor of(@NonNull String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (!this.f47416name.equals(fieldDescriptor.f47416name) || !this.properties.equals(fieldDescriptor.properties)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getName() {
        return this.f47416name;
    }

    @Nullable
    public <T extends Annotation> T getProperty(@NonNull Class<T> cls) {
        return (Annotation) this.properties.get(cls);
    }

    public int hashCode() {
        return (this.f47416name.hashCode() * 31) + this.properties.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f47416name + ", properties=" + this.properties.values() + "}";
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.f47416name = str;
        this.properties = map;
    }
}
