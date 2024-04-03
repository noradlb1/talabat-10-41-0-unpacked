package org.mockito.internal.util.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.ClassFileVersion;
import org.mockito.plugins.MemberAccessor;

public class ModuleMemberAccessor implements MemberAccessor {
    private final MemberAccessor delegate;

    public ModuleMemberAccessor() {
        MemberAccessor memberAccessor;
        try {
            memberAccessor = delegate();
        } catch (Throwable unused) {
            memberAccessor = new ReflectionMemberAccessor();
        }
        this.delegate = memberAccessor;
    }

    private static MemberAccessor delegate() {
        if (ClassFileVersion.ofThisVm().isAtLeast(ClassFileVersion.JAVA_V9)) {
            return new InstrumentationMemberAccessor();
        }
        return new ReflectionMemberAccessor();
    }

    public Object get(Field field, Object obj) throws IllegalAccessException {
        return this.delegate.get(field, obj);
    }

    public Object invoke(Method method, Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return this.delegate.invoke(method, obj, objArr);
    }

    public Object newInstance(Constructor<?> constructor, Object... objArr) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        return this.delegate.newInstance(constructor, objArr);
    }

    public void set(Field field, Object obj, Object obj2) throws IllegalAccessException {
        this.delegate.set(field, obj, obj2);
    }

    public Object newInstance(Constructor<?> constructor, MemberAccessor.OnConstruction onConstruction, Object... objArr) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        return this.delegate.newInstance(constructor, onConstruction, objArr);
    }
}
