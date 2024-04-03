package org.mockito.internal.creation.bytebuddy;

import c40.c;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.Optional;
import j$.util.function.Function;
import java.lang.reflect.Modifier;
import org.mockito.MockedConstruction;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

public class SubclassByteBuddyMockMaker implements ClassCreatingMockMaker {
    private final BytecodeGenerator cachingMockBytecodeGenerator;

    public SubclassByteBuddyMockMaker() {
        this(new SubclassInjectionLoader());
    }

    private static String describeClass(Class<?> cls) {
        if (cls == null) {
            return "null";
        }
        return "'" + cls.getCanonicalName() + "', loaded by classloader : '" + cls.getClassLoader() + "'";
    }

    private static <T> T ensureMockIsAssignableToMockedType(MockCreationSettings<T> mockCreationSettings, T t11) {
        return mockCreationSettings.getTypeToMock().cast(t11);
    }

    private <T> RuntimeException prettifyFailure(MockCreationSettings<T> mockCreationSettings, Exception exc) {
        String str;
        if (mockCreationSettings.getTypeToMock().isArray()) {
            throw new MockitoException(StringUtil.join("Mockito cannot mock arrays: " + mockCreationSettings.getTypeToMock() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, ""), exc);
        } else if (!Modifier.isPrivate(mockCreationSettings.getTypeToMock().getModifiers())) {
            Object[] objArr = new Object[9];
            objArr[0] = "Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
            objArr[1] = "";
            objArr[2] = "Mockito can only mock non-private & non-final classes.";
            objArr[3] = "If you're not sure why you're getting this error, please report to the mailing list.";
            objArr[4] = "";
            if (Platform.isJava8BelowUpdate45()) {
                str = "Java 8 early builds have bugs that were addressed in Java 1.8.0_45, please update your JDK!\n";
            } else {
                str = "";
            }
            objArr[5] = Platform.warnForVM("IBM J9 VM", "Early IBM virtual machine are known to have issues with Mockito, please upgrade to an up-to-date version.\n", "Hotspot", str);
            objArr[6] = Platform.describe();
            objArr[7] = "";
            objArr[8] = "Underlying exception : " + exc;
            throw new MockitoException(StringUtil.join(objArr), exc);
        } else {
            throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "Most likely it is due to mocking a private class that is not visible to Mockito", ""), exc);
        }
    }

    public void clearAllCaches() {
        this.cachingMockBytecodeGenerator.clearAllCaches();
    }

    public /* synthetic */ MockMaker.ConstructionMockControl createConstructionMock(Class cls, Function function, Function function2, MockedConstruction.MockInitializer mockInitializer) {
        return c.b(this, cls, function, function2, mockInitializer);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        throw new org.mockito.exceptions.base.MockitoException("Unable to create mock instance of type '" + r0.getSuperclass().getSimpleName() + "'", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022 A[ExcHandler: InstantiationException (r8v14 'e' org.mockito.creation.instance.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:1:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T createMock(org.mockito.mock.MockCreationSettings<T> r8, org.mockito.invocation.MockHandler r9) {
        /*
            r7 = this;
            java.lang.Class r0 = r7.createMockType(r8)
            org.mockito.plugins.InstantiatorProvider2 r1 = org.mockito.internal.configuration.plugins.Plugins.getInstantiatorProvider()
            org.mockito.creation.instance.Instantiator r1 = r1.getInstantiator(r8)
            java.lang.Object r2 = r1.newInstance(r0)     // Catch:{ ClassCastException -> 0x0047, InstantiationException -> 0x0022 }
            r3 = r2
            org.mockito.internal.creation.bytebuddy.MockAccess r3 = (org.mockito.internal.creation.bytebuddy.MockAccess) r3     // Catch:{ ClassCastException -> 0x0020, InstantiationException -> 0x0022 }
            org.mockito.internal.creation.bytebuddy.MockMethodInterceptor r4 = new org.mockito.internal.creation.bytebuddy.MockMethodInterceptor     // Catch:{ ClassCastException -> 0x0020, InstantiationException -> 0x0022 }
            r4.<init>(r9, r8)     // Catch:{ ClassCastException -> 0x0020, InstantiationException -> 0x0022 }
            r3.setMockitoInterceptor(r4)     // Catch:{ ClassCastException -> 0x0020, InstantiationException -> 0x0022 }
            java.lang.Object r8 = ensureMockIsAssignableToMockedType(r8, r2)     // Catch:{ ClassCastException -> 0x0020, InstantiationException -> 0x0022 }
            return r8
        L_0x0020:
            r9 = move-exception
            goto L_0x0049
        L_0x0022:
            r8 = move-exception
            org.mockito.exceptions.base.MockitoException r9 = new org.mockito.exceptions.base.MockitoException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to create mock instance of type '"
            r1.append(r2)
            java.lang.Class r0 = r0.getSuperclass()
            java.lang.String r0 = r0.getSimpleName()
            r1.append(r0)
            java.lang.String r0 = "'"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0, r8)
            throw r9
        L_0x0047:
            r9 = move-exception
            r2 = 0
        L_0x0049:
            org.mockito.exceptions.base.MockitoException r3 = new org.mockito.exceptions.base.MockitoException
            r4 = 8
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            java.lang.String r6 = "ClassCastException occurred while creating the mockito mock :"
            r4[r5] = r6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "  class to mock : "
            r5.append(r6)
            java.lang.Class r8 = r8.getTypeToMock()
            java.lang.String r8 = describeClass((java.lang.Class<?>) r8)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            r5 = 1
            r4[r5] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r5 = "  created class : "
            r8.append(r5)
            java.lang.String r0 = describeClass((java.lang.Class<?>) r0)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r0 = 2
            r4[r0] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "  proxy instance class : "
            r8.append(r0)
            java.lang.String r0 = describeClass((java.lang.Object) r2)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r0 = 3
            r4[r0] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "  instance creation by : "
            r8.append(r0)
            java.lang.Class r0 = r1.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r0 = 4
            r4[r0] = r8
            r8 = 5
            java.lang.String r0 = ""
            r4[r8] = r0
            r8 = 6
            java.lang.String r1 = "You might experience classloading issues, please ask the mockito mailing-list."
            r4[r8] = r1
            r8 = 7
            r4[r8] = r0
            java.lang.String r8 = org.mockito.internal.util.StringUtil.join(r4)
            r3.<init>(r8, r9)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(org.mockito.mock.MockCreationSettings, org.mockito.invocation.MockHandler):java.lang.Object");
    }

    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        try {
            return this.cachingMockBytecodeGenerator.mockClass(MockFeatures.withMockFeatures(mockCreationSettings.getTypeToMock(), mockCreationSettings.getExtraInterfaces(), mockCreationSettings.getSerializableMode(), mockCreationSettings.isStripAnnotations(), mockCreationSettings.getDefaultAnswer()));
        } catch (Exception e11) {
            throw prettifyFailure(mockCreationSettings, e11);
        }
    }

    public /* synthetic */ Optional createSpy(MockCreationSettings mockCreationSettings, MockHandler mockHandler, Object obj) {
        return c.c(this, mockCreationSettings, mockHandler, obj);
    }

    public /* synthetic */ MockMaker.StaticMockControl createStaticMock(Class cls, MockCreationSettings mockCreationSettings, MockHandler mockHandler) {
        return c.d(this, cls, mockCreationSettings, mockHandler);
    }

    public MockHandler getHandler(Object obj) {
        if (!(obj instanceof MockAccess)) {
            return null;
        }
        return ((MockAccess) obj).getMockitoInterceptor().getMockHandler();
    }

    public MockMaker.TypeMockability isTypeMockable(final Class<?> cls) {
        return new MockMaker.TypeMockability() {
            public boolean mockable() {
                if (cls.isPrimitive() || Modifier.isFinal(cls.getModifiers()) || TypeSupport.f63171a.a(cls)) {
                    return false;
                }
                return true;
            }

            public String nonMockableReason() {
                if (mockable()) {
                    return "";
                }
                if (cls.isPrimitive()) {
                    return "primitive type";
                }
                if (Modifier.isFinal(cls.getModifiers())) {
                    return "final class";
                }
                if (TypeSupport.f63171a.a(cls)) {
                    return "sealed class";
                }
                return StringUtil.join("not handled type");
            }
        };
    }

    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        ((MockAccess) obj).setMockitoInterceptor(new MockMethodInterceptor(mockHandler, mockCreationSettings));
    }

    public SubclassByteBuddyMockMaker(SubclassLoader subclassLoader) {
        this.cachingMockBytecodeGenerator = new TypeCachingBytecodeGenerator(new SubclassBytecodeGenerator(subclassLoader), false);
    }

    private static String describeClass(Object obj) {
        return obj == null ? "null" : describeClass(obj.getClass());
    }
}
