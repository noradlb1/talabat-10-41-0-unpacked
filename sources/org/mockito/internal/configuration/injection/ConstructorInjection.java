package org.mockito.internal.configuration.injection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.reflection.FieldInitializer;

public class ConstructorInjection extends MockInjectionStrategy {

    public static class SimpleArgumentResolver implements FieldInitializer.ConstructorArgumentResolver {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Object> f63145a;

        public SimpleArgumentResolver(Set<Object> set) {
            this.f63145a = set;
        }

        private Object objectThatIsAssignableFrom(Class<?> cls) {
            for (Object next : this.f63145a) {
                if (cls.isAssignableFrom(next.getClass())) {
                    return next;
                }
            }
            return null;
        }

        public Object[] resolveTypeInstances(Class<?>... clsArr) {
            ArrayList arrayList = new ArrayList(clsArr.length);
            for (Class<?> objectThatIsAssignableFrom : clsArr) {
                arrayList.add(objectThatIsAssignableFrom(objectThatIsAssignableFrom));
            }
            return arrayList.toArray();
        }
    }

    public boolean processInjection(Field field, Object obj, Set<Object> set) {
        try {
            return new FieldInitializer(obj, field, (FieldInitializer.ConstructorArgumentResolver) new SimpleArgumentResolver(set)).initialize().fieldWasInitializedUsingContructorArgs();
        } catch (MockitoException e11) {
            if (!(e11.getCause() instanceof InvocationTargetException)) {
                return false;
            }
            throw Reporter.fieldInitialisationThrewException(field, e11.getCause().getCause());
        }
    }
}
