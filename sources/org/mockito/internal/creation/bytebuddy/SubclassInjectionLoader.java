package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.mockito.codegen.InjectionBase;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;

class SubclassInjectionLoader implements SubclassLoader {
    private static final String ERROR_MESSAGE = StringUtil.join("The current JVM does not support any class injection mechanism.", "", "Currently, Mockito supports injection via either by method handle lookups or using sun.misc.Unsafe", "Neither seems to be available on your current JVM.");
    private final SubclassLoader loader;

    public static class WithLookup implements SubclassLoader {
        private final Object codegenLookup;
        private final Object lookup;
        private final Method privateLookupIn;

        public WithLookup(Object obj, Object obj2, Method method) {
            this.lookup = obj;
            this.codegenLookup = obj2;
            this.privateLookupIn = method;
        }

        public boolean isDisrespectingOpenness() {
            return false;
        }

        public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z11) {
            if (z11) {
                try {
                    return ClassLoadingStrategy.UsingLookup.of(this.privateLookupIn.invoke((Object) null, new Object[]{cls, this.lookup}));
                } catch (InvocationTargetException e11) {
                    if (e11.getCause() instanceof IllegalAccessException) {
                        return ClassLoadingStrategy.Default.WRAPPER.with(cls.getProtectionDomain());
                    }
                    throw e11.getCause();
                } catch (Throwable th2) {
                    throw new MockitoException(StringUtil.join("The Java module system prevents Mockito from defining a mock class in the same package as " + cls, "", "To overcome this, you must open and export the mocked type to Mockito.", "Remember that you can also do so programmatically if the mocked class is defined by the same module as your test code", th2));
                }
            } else if (classLoader == InjectionBase.class.getClassLoader()) {
                return ClassLoadingStrategy.UsingLookup.of(this.codegenLookup);
            } else {
                return ClassLoadingStrategy.Default.WRAPPER.with(cls.getProtectionDomain());
            }
        }
    }

    public static class WithReflection implements SubclassLoader {
        private WithReflection() {
        }

        public boolean isDisrespectingOpenness() {
            return true;
        }

        public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z11) {
            ProtectionDomain protectionDomain;
            ClassLoadingStrategy.Default defaultR = ClassLoadingStrategy.Default.INJECTION;
            if (z11) {
                protectionDomain = cls.getProtectionDomain();
            } else {
                protectionDomain = InjectionBase.class.getProtectionDomain();
            }
            return defaultR.with(protectionDomain);
        }
    }

    public SubclassInjectionLoader() {
        if (!Boolean.getBoolean("org.mockito.internal.noUnsafeInjection") && ClassInjector.UsingReflection.isAvailable()) {
            this.loader = new WithReflection();
        } else if (ClassInjector.UsingLookup.isAvailable()) {
            this.loader = tryLookup();
        } else {
            throw new MockitoException(StringUtil.join(ERROR_MESSAGE, "", Platform.describe()));
        }
    }

    private static SubclassLoader tryLookup() {
        try {
            Class<?> cls = Class.forName("java.lang.invoke.MethodHandles");
            Object invoke = cls.getMethod("lookup", new Class[0]).invoke((Object) null, new Object[0]);
            Method method = cls.getMethod("privateLookupIn", new Class[]{Class.class, Class.forName("java.lang.invoke.MethodHandles$Lookup")});
            return new WithLookup(invoke, method.invoke((Object) null, new Object[]{InjectionBase.class, invoke}), method);
        } catch (Exception e11) {
            throw new MockitoException(StringUtil.join(ERROR_MESSAGE, "", Platform.describe()), e11);
        }
    }

    public boolean isDisrespectingOpenness() {
        return this.loader.isDisrespectingOpenness();
    }

    public ClassLoadingStrategy<ClassLoader> resolveStrategy(Class<?> cls, ClassLoader classLoader, boolean z11) {
        return this.loader.resolveStrategy(cls, classLoader, z11);
    }
}
