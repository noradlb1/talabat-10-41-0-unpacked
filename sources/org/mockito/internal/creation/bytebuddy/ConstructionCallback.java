package org.mockito.internal.creation.bytebuddy;

public interface ConstructionCallback {
    Object apply(Class<?> cls, Object obj, Object[] objArr, String[] strArr);
}
