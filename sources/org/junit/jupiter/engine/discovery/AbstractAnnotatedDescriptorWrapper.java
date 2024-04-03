package org.junit.jupiter.engine.discovery;

import j$.util.Optional;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.TestDescriptor;

abstract class AbstractAnnotatedDescriptorWrapper<E extends AnnotatedElement> {
    private final E annotatedElement;
    private final TestDescriptor testDescriptor;

    public AbstractAnnotatedDescriptorWrapper(TestDescriptor testDescriptor2, E e11) {
        this.testDescriptor = testDescriptor2;
        this.annotatedElement = e11;
    }

    public E a() {
        return this.annotatedElement;
    }

    public TestDescriptor b() {
        return this.testDescriptor;
    }

    public final <A extends Annotation> Optional<A> findAnnotation(Class<A> cls) {
        Preconditions.notNull(cls, "annotationType must not be null");
        return AnnotationUtils.findAnnotation(a(), cls);
    }

    public final <A extends Annotation> List<A> findRepeatableAnnotations(Class<A> cls) {
        Preconditions.notNull(cls, "annotationType must not be null");
        return AnnotationUtils.findRepeatableAnnotations(a(), cls);
    }

    public final String getDisplayName() {
        return this.testDescriptor.getDisplayName();
    }

    public final boolean isAnnotated(Class<? extends Annotation> cls) {
        Preconditions.notNull(cls, "annotationType must not be null");
        return AnnotationUtils.isAnnotated(a(), cls);
    }
}
