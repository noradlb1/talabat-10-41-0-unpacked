package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FrameworkField extends FrameworkMember<FrameworkField> {
    private final Field field;

    public FrameworkField(Field field2) {
        if (field2 != null) {
            this.field = field2;
            return;
        }
        throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
    }

    public int a() {
        return this.field.getModifiers();
    }

    public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return this.field.get(obj);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.field.getAnnotation(cls);
    }

    public Annotation[] getAnnotations() {
        return this.field.getAnnotations();
    }

    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public Field getField() {
        return this.field;
    }

    public String getName() {
        return getField().getName();
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public String toString() {
        return this.field.toString();
    }

    public boolean isShadowedBy(FrameworkField frameworkField) {
        return frameworkField.getName().equals(getName());
    }
}
