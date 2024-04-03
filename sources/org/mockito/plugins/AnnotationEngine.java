package org.mockito.plugins;

public interface AnnotationEngine {

    public static class NoAction implements AutoCloseable {
        public void close() {
        }
    }

    AutoCloseable process(Class<?> cls, Object obj);
}
