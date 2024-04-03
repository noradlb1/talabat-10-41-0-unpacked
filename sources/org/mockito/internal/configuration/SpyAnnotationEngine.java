package org.mockito.internal.configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.StringUtil;
import org.mockito.plugins.AnnotationEngine;
import org.mockito.plugins.MemberAccessor;

public class SpyAnnotationEngine implements AnnotationEngine {
    private static void assertNoIncompatibleAnnotations(Class<? extends Annotation> cls, Field field, Class<? extends Annotation>... clsArr) {
        int length = clsArr.length;
        int i11 = 0;
        while (i11 < length) {
            Class<? extends Annotation> cls2 = clsArr[i11];
            if (!field.isAnnotationPresent(cls2)) {
                i11++;
            } else {
                throw Reporter.unsupportedCombinationOfAnnotations(cls.getSimpleName(), cls2.getSimpleName());
            }
        }
    }

    private static Constructor<?> noArgConstructorOf(Class<?> cls) {
        try {
            return cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException e11) {
            throw new MockitoException("Please ensure that the type '" + cls.getSimpleName() + "' has a no-arg constructor.", e11);
        }
    }

    private static Object spyInstance(Field field, Object obj) {
        return Mockito.mock(obj.getClass(), Mockito.withSettings().spiedInstance(obj).defaultAnswer(Mockito.CALLS_REAL_METHODS).name(field.getName()));
    }

    private static Object spyNewInstance(Object obj, Field field) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        MockSettings name2 = Mockito.withSettings().defaultAnswer(Mockito.CALLS_REAL_METHODS).name(field.getName());
        Class<?> type = field.getType();
        if (type.isInterface()) {
            return Mockito.mock(type, name2.useConstructor(new Object[0]));
        }
        int modifiers = type.getModifiers();
        if (typeIsPrivateAbstractInnerClass(type, modifiers)) {
            throw new MockitoException(StringUtil.join("@Spy annotation can't initialize private abstract inner classes.", "  inner class: '" + type.getSimpleName() + "'", "  outer class: '" + type.getEnclosingClass().getSimpleName() + "'", "", "You should augment the visibility of this inner class"));
        } else if (typeIsNonStaticInnerClass(type, modifiers)) {
            Class<?> enclosingClass = type.getEnclosingClass();
            if (enclosingClass.isInstance(obj)) {
                return Mockito.mock(type, name2.useConstructor(new Object[0]).outerInstance(obj));
            }
            throw new MockitoException(StringUtil.join("@Spy annotation can only initialize inner classes declared in the test.", "  inner class: '" + type.getSimpleName() + "'", "  outer class: '" + enclosingClass.getSimpleName() + "'", ""));
        } else {
            Constructor<?> noArgConstructorOf = noArgConstructorOf(type);
            if (Modifier.isPrivate(noArgConstructorOf.getModifiers())) {
                return Mockito.mock(type, name2.spiedInstance(Plugins.getMemberAccessor().newInstance(noArgConstructorOf, new Object[0])));
            }
            return Mockito.mock(type, name2.useConstructor(new Object[0]));
        }
    }

    private static boolean typeIsNonStaticInnerClass(Class<?> cls, int i11) {
        return !Modifier.isStatic(i11) && cls.getEnclosingClass() != null;
    }

    private static boolean typeIsPrivateAbstractInnerClass(Class<?> cls, int i11) {
        if (!Modifier.isPrivate(i11) || !Modifier.isAbstract(i11) || cls.getEnclosingClass() == null) {
            return false;
        }
        return true;
    }

    public AutoCloseable process(Class<?> cls, Object obj) {
        Field[] declaredFields = cls.getDeclaredFields();
        MemberAccessor memberAccessor = Plugins.getMemberAccessor();
        for (Field field : declaredFields) {
            Class<Spy> cls2 = Spy.class;
            if (field.isAnnotationPresent(cls2) && !field.isAnnotationPresent(InjectMocks.class)) {
                assertNoIncompatibleAnnotations(cls2, field, Mock.class, Captor.class);
                try {
                    Object obj2 = memberAccessor.get(field, obj);
                    if (MockUtil.isMock(obj2)) {
                        Mockito.reset(obj2);
                    } else if (obj2 != null) {
                        memberAccessor.set(field, obj, spyInstance(field, obj2));
                    } else {
                        memberAccessor.set(field, obj, spyNewInstance(obj, field));
                    }
                } catch (Exception e11) {
                    throw new MockitoException("Unable to initialize @Spy annotated field '" + field.getName() + "'.\n" + e11.getMessage(), e11);
                }
            }
        }
        return new AnnotationEngine.NoAction();
    }
}
