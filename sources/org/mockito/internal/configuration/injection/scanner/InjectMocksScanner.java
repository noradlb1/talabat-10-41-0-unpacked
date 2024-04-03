package org.mockito.internal.configuration.injection.scanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.exceptions.Reporter;

public class InjectMocksScanner {
    private final Class<?> clazz;

    public InjectMocksScanner(Class<?> cls) {
        this.clazz = cls;
    }

    private static void assertNoAnnotations(Field field, Class<? extends Annotation>... clsArr) {
        int length = clsArr.length;
        int i11 = 0;
        while (i11 < length) {
            Class<? extends Annotation> cls = clsArr[i11];
            if (!field.isAnnotationPresent(cls)) {
                i11++;
            } else {
                throw Reporter.unsupportedCombinationOfAnnotations(cls.getSimpleName(), InjectMocks.class.getSimpleName());
            }
        }
    }

    private Set<Field> scan() {
        HashSet hashSet = new HashSet();
        for (Field field : this.clazz.getDeclaredFields()) {
            if (field.getAnnotation(InjectMocks.class) != null) {
                assertNoAnnotations(field, Mock.class, Captor.class);
                hashSet.add(field);
            }
        }
        return hashSet;
    }

    public void addTo(Set<Field> set) {
        set.addAll(scan());
    }
}
