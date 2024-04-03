package org.mockito.internal.creation.bytebuddy;

public interface BytecodeGenerator {
    void clearAllCaches();

    <T> Class<? extends T> mockClass(MockFeatures<T> mockFeatures);

    void mockClassConstruction(Class<?> cls);

    void mockClassStatic(Class<?> cls);
}
