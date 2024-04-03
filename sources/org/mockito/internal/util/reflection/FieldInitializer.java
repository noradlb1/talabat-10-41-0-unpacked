package org.mockito.internal.util.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.util.MockUtil;
import org.mockito.plugins.MemberAccessor;

public class FieldInitializer {
    private final Field field;
    private final Object fieldOwner;
    private final ConstructorInstantiator instantiator;

    public interface ConstructorArgumentResolver {
        Object[] resolveTypeInstances(Class<?>... clsArr);
    }

    public interface ConstructorInstantiator {
        FieldInitializationReport instantiate();
    }

    public static class NoArgConstructorInstantiator implements ConstructorInstantiator {
        private final Field field;
        private final Object testClass;

        public NoArgConstructorInstantiator(Object obj, Field field2) {
            this.testClass = obj;
            this.field = field2;
        }

        public FieldInitializationReport instantiate() {
            MemberAccessor memberAccessor = Plugins.getMemberAccessor();
            try {
                memberAccessor.set(this.field, this.testClass, memberAccessor.newInstance(this.field.getType().getDeclaredConstructor(new Class[0]), new Object[0]));
                return new FieldInitializationReport(memberAccessor.get(this.field, this.testClass), true, false);
            } catch (NoSuchMethodException e11) {
                throw new MockitoException("the type '" + this.field.getType().getSimpleName() + "' has no default constructor", e11);
            } catch (InvocationTargetException e12) {
                throw new MockitoException("the default constructor of type '" + this.field.getType().getSimpleName() + "' has raised an exception (see the stack trace for cause): " + e12.getTargetException(), e12);
            } catch (InstantiationException e13) {
                throw new MockitoException("InstantiationException (see the stack trace for cause): " + e13, e13);
            } catch (IllegalAccessException e14) {
                throw new MockitoException("IllegalAccessException (see the stack trace for cause): " + e14, e14);
            }
        }
    }

    public static class ParameterizedConstructorInstantiator implements ConstructorInstantiator {
        private final ConstructorArgumentResolver argResolver;
        private final Comparator<Constructor<?>> byParameterNumber = new Comparator<Constructor<?>>() {
            private int countMockableParams(Constructor<?> constructor) {
                int i11 = 0;
                for (Class typeMockabilityOf : constructor.getParameterTypes()) {
                    if (MockUtil.typeMockabilityOf(typeMockabilityOf).mockable()) {
                        i11++;
                    }
                }
                return i11;
            }

            public int compare(Constructor<?> constructor, Constructor<?> constructor2) {
                int length = constructor2.getParameterTypes().length - constructor.getParameterTypes().length;
                if (length != 0) {
                    return length;
                }
                return countMockableParams(constructor2) - countMockableParams(constructor);
            }
        };
        private final Field field;
        private final Object testClass;

        public ParameterizedConstructorInstantiator(Object obj, Field field2, ConstructorArgumentResolver constructorArgumentResolver) {
            this.testClass = obj;
            this.field = field2;
            this.argResolver = constructorArgumentResolver;
        }

        private Constructor<?> biggestConstructor(Class<?> cls) {
            List asList = Arrays.asList(cls.getDeclaredConstructors());
            Collections.sort(asList, this.byParameterNumber);
            Constructor<?> constructor = (Constructor) asList.get(0);
            checkParameterized(constructor, this.field);
            return constructor;
        }

        private void checkParameterized(Constructor<?> constructor, Field field2) {
            if (constructor.getParameterTypes().length == 0) {
                throw new MockitoException("the field " + field2.getName() + " of type " + field2.getType() + " has no parameterized constructor");
            }
        }

        public FieldInitializationReport instantiate() {
            MemberAccessor memberAccessor = Plugins.getMemberAccessor();
            Constructor<?> biggestConstructor = biggestConstructor(this.field.getType());
            try {
                memberAccessor.set(this.field, this.testClass, memberAccessor.newInstance(biggestConstructor, this.argResolver.resolveTypeInstances(biggestConstructor.getParameterTypes())));
                return new FieldInitializationReport(memberAccessor.get(this.field, this.testClass), false, true);
            } catch (IllegalArgumentException e11) {
                throw new MockitoException("internal error : argResolver provided incorrect types for constructor " + biggestConstructor + " of type " + this.field.getType().getSimpleName(), e11);
            } catch (InvocationTargetException e12) {
                throw new MockitoException("the constructor of type '" + this.field.getType().getSimpleName() + "' has raised an exception (see the stack trace for cause): " + e12.getTargetException(), e12);
            } catch (InstantiationException e13) {
                throw new MockitoException("InstantiationException (see the stack trace for cause): " + e13, e13);
            } catch (IllegalAccessException e14) {
                throw new MockitoException("IllegalAccessException (see the stack trace for cause): " + e14, e14);
            }
        }
    }

    public FieldInitializer(Object obj, Field field2) {
        this(obj, field2, (ConstructorInstantiator) new NoArgConstructorInstantiator(obj, field2));
    }

    private FieldInitializationReport acquireFieldInstance() throws IllegalAccessException {
        Object obj = Plugins.getMemberAccessor().get(this.field, this.fieldOwner);
        if (obj != null) {
            return new FieldInitializationReport(obj, false, false);
        }
        return this.instantiator.instantiate();
    }

    private void checkNotAbstract(Field field2) {
        if (Modifier.isAbstract(field2.getType().getModifiers())) {
            throw new MockitoException("the type '" + field2.getType().getSimpleName() + "' is an abstract class.");
        }
    }

    private void checkNotEnum(Field field2) {
        if (field2.getType().isEnum()) {
            throw new MockitoException("the type '" + field2.getType().getSimpleName() + "' is an enum.");
        }
    }

    private void checkNotInner(Field field2) {
        Class<?> type = field2.getType();
        if (type.isMemberClass() && !Modifier.isStatic(type.getModifiers())) {
            throw new MockitoException("the type '" + type.getSimpleName() + "' is an inner non static class.");
        }
    }

    private void checkNotInterface(Field field2) {
        if (field2.getType().isInterface()) {
            throw new MockitoException("the type '" + field2.getType().getSimpleName() + "' is an interface.");
        }
    }

    private void checkNotLocal(Field field2) {
        if (field2.getType().isLocalClass()) {
            throw new MockitoException("the type '" + field2.getType().getSimpleName() + "' is a local class.");
        }
    }

    public FieldInitializationReport initialize() {
        try {
            return acquireFieldInstance();
        } catch (IllegalAccessException e11) {
            throw new MockitoException("Problems initializing field '" + this.field.getName() + "' of type '" + this.field.getType().getSimpleName() + "'", e11);
        }
    }

    public FieldInitializer(Object obj, Field field2, ConstructorArgumentResolver constructorArgumentResolver) {
        this(obj, field2, (ConstructorInstantiator) new ParameterizedConstructorInstantiator(obj, field2, constructorArgumentResolver));
    }

    private FieldInitializer(Object obj, Field field2, ConstructorInstantiator constructorInstantiator) {
        if (new FieldReader(obj, field2).isNull()) {
            checkNotLocal(field2);
            checkNotInner(field2);
            checkNotInterface(field2);
            checkNotEnum(field2);
            checkNotAbstract(field2);
        }
        this.fieldOwner = obj;
        this.field = field2;
        this.instantiator = constructorInstantiator;
    }
}
