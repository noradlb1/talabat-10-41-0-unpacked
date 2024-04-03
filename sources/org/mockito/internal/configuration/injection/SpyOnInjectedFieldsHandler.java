package org.mockito.internal.configuration.injection;

import java.lang.reflect.Field;
import java.util.Set;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.reflection.FieldReader;
import org.mockito.plugins.MemberAccessor;

public class SpyOnInjectedFieldsHandler extends MockInjectionStrategy {
    private final MemberAccessor accessor = Plugins.getMemberAccessor();

    public boolean processInjection(Field field, Object obj, Set<Object> set) {
        FieldReader fieldReader = new FieldReader(obj, field);
        if (!fieldReader.isNull() && field.isAnnotationPresent(Spy.class)) {
            try {
                Object read = fieldReader.read();
                if (MockUtil.isMock(read)) {
                    Mockito.reset(read);
                } else {
                    this.accessor.set(field, obj, Mockito.mock(read.getClass(), Mockito.withSettings().spiedInstance(read).defaultAnswer(Mockito.CALLS_REAL_METHODS).name(field.getName())));
                }
            } catch (Exception e11) {
                throw new MockitoException("Problems initiating spied field " + field.getName(), e11);
            }
        }
        return false;
    }
}
