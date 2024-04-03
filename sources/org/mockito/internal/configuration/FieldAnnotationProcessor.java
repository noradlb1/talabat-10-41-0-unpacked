package org.mockito.internal.configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface FieldAnnotationProcessor<A extends Annotation> {
    Object process(A a11, Field field);
}
