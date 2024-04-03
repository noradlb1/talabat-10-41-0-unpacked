package org.mockito.internal.creation.bytebuddy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.implementation.bind.annotation.FieldValue;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.StubValue;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.invocation.DefaultInvocationFactory;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.invocation.Location;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

public class MockMethodInterceptor implements Serializable {
    private static final long serialVersionUID = 7152947254057253027L;

    /* renamed from: b  reason: collision with root package name */
    public final MockHandler f63168b;
    private final MockCreationSettings mockCreationSettings;
    private final ByteBuddyCrossClassLoaderSerializationSupport serializationSupport;
    private transient ThreadLocal<Object> weakReferenceHatch = new ThreadLocal<>();

    public static class DispatcherDefaultingToRealMethod {
        @RuntimeType
        public static Object interceptAbstract(@This Object obj, @FieldValue("mockitoInterceptor") MockMethodInterceptor mockMethodInterceptor, @StubValue Object obj2, @Origin Method method, @AllArguments Object[] objArr) throws Throwable {
            return mockMethodInterceptor == null ? obj2 : mockMethodInterceptor.a(obj, method, objArr, RealMethod.IsIllegal.INSTANCE);
        }

        @BindingPriority(2)
        @RuntimeType
        public static Object interceptSuperCallable(@This Object obj, @FieldValue("mockitoInterceptor") MockMethodInterceptor mockMethodInterceptor, @Origin Method method, @AllArguments Object[] objArr, @SuperCall(serializableProxy = true) Callable<?> callable) throws Throwable {
            if (mockMethodInterceptor == null) {
                return callable.call();
            }
            return mockMethodInterceptor.a(obj, method, objArr, new RealMethod.FromCallable(callable));
        }
    }

    public static class ForEquals {
        public static boolean doIdentityEquals(@This Object obj, @Argument(0) Object obj2) {
            return obj == obj2;
        }
    }

    public static final class ForHashCode {
        private ForHashCode() {
        }

        public static int doIdentityHashCode(@This Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static final class ForWriteReplace {
        private ForWriteReplace() {
        }

        public static Object doWriteReplace(@This MockAccess mockAccess) throws ObjectStreamException {
            return mockAccess.getMockitoInterceptor().getSerializationSupport().writeReplace(mockAccess);
        }
    }

    public MockMethodInterceptor(MockHandler mockHandler, MockCreationSettings mockCreationSettings2) {
        this.f63168b = mockHandler;
        this.mockCreationSettings = mockCreationSettings2;
        this.serializationSupport = new ByteBuddyCrossClassLoaderSerializationSupport();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.weakReferenceHatch = new ThreadLocal<>();
    }

    public Object a(Object obj, Method method, Object[] objArr, RealMethod realMethod) throws Throwable {
        return b(obj, method, objArr, realMethod, new LocationImpl());
    }

    public Object b(Object obj, Method method, Object[] objArr, RealMethod realMethod, Location location) throws Throwable {
        this.weakReferenceHatch.set(obj);
        try {
            return this.f63168b.handle(DefaultInvocationFactory.createInvocation(obj, method, objArr, realMethod, this.mockCreationSettings, location));
        } finally {
            this.weakReferenceHatch.remove();
        }
    }

    public MockHandler getMockHandler() {
        return this.f63168b;
    }

    public ByteBuddyCrossClassLoaderSerializationSupport getSerializationSupport() {
        return this.serializationSupport;
    }
}
