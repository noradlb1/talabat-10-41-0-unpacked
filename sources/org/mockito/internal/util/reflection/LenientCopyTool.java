package org.mockito.internal.util.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.plugins.MemberAccessor;

public class LenientCopyTool {

    /* renamed from: a  reason: collision with root package name */
    public MemberAccessor f63270a = Plugins.getMemberAccessor();

    private <T> void copy(T t11, T t12, Class<?> cls) {
        while (true) {
            Class<? super Object> cls2 = cls;
            if (cls2 != Object.class) {
                copyValues(t11, t12, cls2);
                cls2 = cls2.getSuperclass();
            } else {
                return;
            }
        }
    }

    private <T> void copyValues(T t11, T t12, Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    this.f63270a.set(field, t12, this.f63270a.get(field, t11));
                } catch (Throwable unused) {
                }
            }
        }
    }

    public <T> void copyToMock(T t11, T t12) {
        copy(t11, t12, t11.getClass());
    }

    public <T> void copyToRealObject(T t11, T t12) {
        copy(t11, t12, t11.getClass());
    }
}
