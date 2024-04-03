package org.mockito.internal.creation.proxy;

import c40.c;
import j$.util.Optional;
import j$.util.function.Function;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicReference;
import org.mockito.MockedConstruction;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.invocation.DefaultInvocationFactory;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

public class ProxyMockMaker implements MockMaker {
    /* access modifiers changed from: private */
    public static final Object[] EMPTY = new Object[0];
    /* access modifiers changed from: private */
    public final ProxyRealMethod proxyRealMethod = b.b();

    public static class CommonClassLoader extends ClassLoader {
        private final ClassLoader left;
        private final ClassLoader right;

        public Class<?> loadClass(String str) throws ClassNotFoundException {
            try {
                return this.left.loadClass(str);
            } catch (ClassNotFoundException unused) {
                return this.right.loadClass(str);
            }
        }

        private CommonClassLoader(ClassLoader classLoader, ClassLoader classLoader2) {
            super((ClassLoader) null);
            this.left = classLoader;
            this.right = classLoader2;
        }
    }

    public class MockInvocationHandler implements InvocationHandler {
        /* access modifiers changed from: private */
        public final AtomicReference<MockHandler<?>> handler;
        private final MockCreationSettings<?> settings;

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            RealMethod realMethod;
            if (objArr == null) {
                objArr = ProxyMockMaker.EMPTY;
            }
            Object[] objArr2 = objArr;
            if (method.getDeclaringClass() == Object.class) {
                String name2 = method.getName();
                name2.hashCode();
                boolean z11 = true;
                char c11 = 65535;
                switch (name2.hashCode()) {
                    case -1776922004:
                        if (name2.equals("toString")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1295482945:
                        if (name2.equals("equals")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 147696667:
                        if (name2.equals("hashCode")) {
                            c11 = 2;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        break;
                    case 1:
                        if (obj != objArr2[0]) {
                            z11 = false;
                        }
                        return Boolean.valueOf(z11);
                    case 2:
                        return Integer.valueOf(System.identityHashCode(obj));
                    default:
                        throw new MockitoException(StringUtil.join("Unexpected overridable method of Object class found", "", "The method " + method + " was not expected to be declared. Either your JVM build offers non-official API or the current functionality is not supported", Platform.describe()));
                }
            }
            if (Modifier.isAbstract(method.getModifiers())) {
                realMethod = RealMethod.IsIllegal.INSTANCE;
            } else {
                realMethod = ProxyMockMaker.this.proxyRealMethod.resolve(obj, method, objArr2);
            }
            return this.handler.get().handle(DefaultInvocationFactory.createInvocation(obj, method, objArr2, realMethod, this.settings, new LocationImpl()));
        }

        private MockInvocationHandler(MockHandler<?> mockHandler, MockCreationSettings<?> mockCreationSettings) {
            this.handler = new AtomicReference<>(mockHandler);
            this.settings = mockCreationSettings;
        }
    }

    private static ClassLoader resolveCommonClassLoader(ClassLoader classLoader, Class<?> cls) {
        if (classLoader == null) {
            return cls.getClassLoader();
        }
        ClassLoader classLoader2 = cls.getClassLoader();
        if (classLoader2 == null || classLoader == classLoader2) {
            return classLoader;
        }
        while (classLoader2 != null) {
            if (classLoader2 == classLoader) {
                return cls.getClassLoader();
            }
            classLoader2 = classLoader2.getParent();
        }
        for (ClassLoader classLoader3 = classLoader; classLoader3 != null; classLoader3 = classLoader3.getParent()) {
            if (classLoader3 == cls.getClassLoader()) {
                return classLoader;
            }
        }
        return new CommonClassLoader(classLoader, cls.getClassLoader());
    }

    public /* synthetic */ void clearAllCaches() {
        c.a(this);
    }

    public /* synthetic */ MockMaker.ConstructionMockControl createConstructionMock(Class cls, Function function, Function function2, MockedConstruction.MockInitializer mockInitializer) {
        return c.b(this, cls, function, function2, mockInitializer);
    }

    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        int i11;
        int i12 = 0;
        if (mockCreationSettings.getTypeToMock() == Object.class) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        Class[] clsArr = new Class[(mockCreationSettings.getExtraInterfaces().size() + (i11 ^ 1))];
        if (i11 == 0) {
            clsArr[0] = mockCreationSettings.getTypeToMock();
            i12 = 1;
        }
        ClassLoader classLoader = mockCreationSettings.getTypeToMock().getClassLoader();
        for (Class next : mockCreationSettings.getExtraInterfaces()) {
            clsArr[i12] = next;
            classLoader = resolveCommonClassLoader(classLoader, next);
            i12++;
        }
        return Proxy.newProxyInstance(resolveCommonClassLoader(classLoader, ProxyMockMaker.class), clsArr, new MockInvocationHandler(mockHandler, mockCreationSettings));
    }

    public /* synthetic */ Optional createSpy(MockCreationSettings mockCreationSettings, MockHandler mockHandler, Object obj) {
        return c.c(this, mockCreationSettings, mockHandler, obj);
    }

    public /* synthetic */ MockMaker.StaticMockControl createStaticMock(Class cls, MockCreationSettings mockCreationSettings, MockHandler mockHandler) {
        return c.d(this, cls, mockCreationSettings, mockHandler);
    }

    public MockHandler getHandler(Object obj) {
        if (!Proxy.isProxyClass(obj.getClass())) {
            return null;
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        if (!(invocationHandler instanceof MockInvocationHandler)) {
            return null;
        }
        return (MockHandler) ((MockInvocationHandler) invocationHandler).handler.get();
    }

    public MockMaker.TypeMockability isTypeMockable(final Class<?> cls) {
        return new MockMaker.TypeMockability() {
            public boolean mockable() {
                return cls.isInterface() || cls == Object.class;
            }

            public String nonMockableReason() {
                return mockable() ? "" : "non-interface";
            }
        };
    }

    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        ((MockInvocationHandler) Proxy.getInvocationHandler(obj)).handler.set(mockHandler);
    }
}
