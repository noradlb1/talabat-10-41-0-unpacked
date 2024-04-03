package org.mockito.internal.configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.ScopedMock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.plugins.AnnotationEngine;
import u30.a;

public class IndependentAnnotationEngine implements AnnotationEngine {
    private final Map<Class<? extends Annotation>, FieldAnnotationProcessor<?>> annotationProcessorMap = new HashMap();

    public IndependentAnnotationEngine() {
        registerAnnotationProcessor(Mock.class, new MockAnnotationProcessor());
        registerAnnotationProcessor(Captor.class, new CaptorAnnotationProcessor());
    }

    private Object createMockFor(Annotation annotation, Field field) {
        return forAnnotation(annotation).process(annotation, field);
    }

    private <A extends Annotation> FieldAnnotationProcessor<A> forAnnotation(A a11) {
        if (this.annotationProcessorMap.containsKey(a11.annotationType())) {
            return this.annotationProcessorMap.get(a11.annotationType());
        }
        return new FieldAnnotationProcessor<A>() {
            public Object process(A a11, Field field) {
                return null;
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$process$0(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ScopedMock) it.next()).closeOnDemand();
        }
    }

    private <A extends Annotation> void registerAnnotationProcessor(Class<A> cls, FieldAnnotationProcessor<A> fieldAnnotationProcessor) {
        this.annotationProcessorMap.put(cls, fieldAnnotationProcessor);
    }

    public void b(Field field, boolean z11) {
        if (z11) {
            throw Reporter.moreThanOneAnnotationNotAllowed(field.getName());
        }
    }

    public AutoCloseable process(Class<?> cls, Object obj) {
        ArrayList<ScopedMock> arrayList = new ArrayList<>();
        for (Field field : cls.getDeclaredFields()) {
            boolean z11 = false;
            for (Annotation annotation : field.getAnnotations()) {
                Object createMockFor = createMockFor(annotation, field);
                if (createMockFor instanceof ScopedMock) {
                    arrayList.add((ScopedMock) createMockFor);
                }
                if (createMockFor != null) {
                    b(field, z11);
                    try {
                        Plugins.getMemberAccessor().set(field, obj, createMockFor);
                        z11 = true;
                    } catch (Exception e11) {
                        for (ScopedMock close : arrayList) {
                            close.close();
                        }
                        throw new MockitoException("Problems setting field " + field.getName() + " annotated with " + annotation, e11);
                    }
                }
            }
        }
        return new a(arrayList);
    }
}
