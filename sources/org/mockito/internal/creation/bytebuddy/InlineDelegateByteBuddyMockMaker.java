package org.mockito.internal.creation.bytebuddy;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.Map;
import j$.util.Optional;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.mockito.MockedConstruction;
import org.mockito.creation.instance.InstantiationException;
import org.mockito.creation.instance.Instantiator;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.exceptions.base.MockitoInitializationException;
import org.mockito.exceptions.misusing.MockitoConfigurationException;
import org.mockito.internal.SuppressSignatureCheck;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.instance.ConstructorInstantiator;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.util.concurrent.DetachedThreadLocal;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.InlineMockMaker;
import org.mockito.plugins.MemberAccessor;
import org.mockito.plugins.MockMaker;
import z1.b;

@SuppressSignatureCheck
class InlineDelegateByteBuddyMockMaker implements ClassCreatingMockMaker, InlineMockMaker, Instantiator {
    private static final Throwable INITIALIZATION_ERROR;
    /* access modifiers changed from: private */
    public static final Instrumentation INSTRUMENTATION;
    private final BytecodeGenerator bytecodeGenerator;
    private final ThreadLocal<Object> currentSpied = new ThreadLocal<>();
    private final DetachedThreadLocal<Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>>> mockedConstruction;
    private final DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> mockedStatics;
    private final ThreadLocal<Boolean> mockitoConstruction = new b(new c());
    /* access modifiers changed from: private */
    public final WeakConcurrentMap<Object, MockMethodInterceptor> mocks;

    public static class InlineConstructionMockContext implements MockedConstruction.Context {
        private static final Map<String, Class<?>> PRIMITIVES;
        private final Object[] arguments;
        /* access modifiers changed from: private */
        public int count;
        private final String[] parameterTypeNames;
        private final Class<?> type;

        static {
            HashMap hashMap = new HashMap();
            PRIMITIVES = hashMap;
            Class cls = Boolean.TYPE;
            hashMap.put(cls.getName(), cls);
            hashMap.put(Byte.TYPE.getName(), Byte.TYPE);
            hashMap.put(Short.TYPE.getName(), Short.TYPE);
            hashMap.put(Character.TYPE.getName(), Character.TYPE);
            Class cls2 = Integer.TYPE;
            hashMap.put(cls2.getName(), cls2);
            Class cls3 = Long.TYPE;
            hashMap.put(cls3.getName(), cls3);
            Class cls4 = Float.TYPE;
            hashMap.put(cls4.getName(), cls4);
            hashMap.put(Double.TYPE.getName(), Double.TYPE);
        }

        public List<?> arguments() {
            return Collections.unmodifiableList(Arrays.asList(this.arguments));
        }

        public Constructor<?> constructor() {
            String[] strArr = this.parameterTypeNames;
            Class[] clsArr = new Class[strArr.length];
            int i11 = 0;
            for (String str : strArr) {
                Map<String, Class<?>> map = PRIMITIVES;
                if (map.containsKey(str)) {
                    clsArr[i11] = map.get(str);
                    i11++;
                } else {
                    int i12 = i11 + 1;
                    try {
                        clsArr[i11] = Class.forName(str, false, this.type.getClassLoader());
                        i11 = i12;
                    } catch (ClassNotFoundException e11) {
                        throw new MockitoException("Could not find parameter of type " + str, e11);
                    }
                }
            }
            try {
                return this.type.getDeclaredConstructor(clsArr);
            } catch (NoSuchMethodException e12) {
                throw new MockitoException(StringUtil.join("Could not resolve constructor of type", "", this.type.getName(), "", "with arguments of types", Arrays.toString(clsArr)), e12);
            }
        }

        public int getCount() {
            int i11 = this.count;
            if (i11 != 0) {
                return i11;
            }
            throw new MockitoConfigurationException("mocked construction context is not initialized");
        }

        private InlineConstructionMockContext(Object[] objArr, Class<?> cls, String[] strArr) {
            this.arguments = objArr;
            this.type = cls;
            this.parameterTypeNames = strArr;
        }
    }

    public class InlineConstructionMockControl<T> implements MockMaker.ConstructionMockControl<T> {
        private final List<Object> all;
        private int count;
        private final Function<MockedConstruction.Context, MockHandler<T>> handlerFactory;
        private final Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> interceptors;
        private final MockedConstruction.MockInitializer<T> mockInitializer;
        private final Function<MockedConstruction.Context, MockCreationSettings<T>> settingsFactory;
        private final Class<T> type;

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$enable$0(Object obj, MockedConstruction.Context context) {
            int i11 = this.count + 1;
            this.count = i11;
            int unused = ((InlineConstructionMockContext) context).count = i11;
            InlineDelegateByteBuddyMockMaker.this.mocks.put(obj, new MockMethodInterceptor(this.handlerFactory.apply(context), this.settingsFactory.apply(context)));
            try {
                this.mockInitializer.prepare(obj, context);
                this.all.add(obj);
            } catch (Throwable th2) {
                InlineDelegateByteBuddyMockMaker.this.mocks.remove(obj);
                throw new MockitoException("Could not initialize mocked construction", th2);
            }
        }

        public void disable() {
            if (this.interceptors.remove(this.type) != null) {
                this.all.clear();
                return;
            }
            throw new MockitoException(StringUtil.join("Could not deregister " + this.type.getName() + " as a static mock since it is not currently registered", "", "To register a static mock, use Mockito.mockStatic(" + this.type.getSimpleName() + ".class)"));
        }

        public void enable() {
            if (Map.EL.putIfAbsent(this.interceptors, this.type, new g(this)) != null) {
                throw new MockitoException(StringUtil.join("For " + this.type.getName() + ", static mocking is already registered in the current thread", "", "To create a new mock, the existing static mock registration must be deregistered"));
            }
        }

        public List<T> getMocks() {
            return this.all;
        }

        public Class<T> getType() {
            return this.type;
        }

        private InlineConstructionMockControl(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer2, java.util.Map<Class<?>, BiConsumer<Object, MockedConstruction.Context>> map) {
            this.all = new ArrayList();
            this.type = cls;
            this.settingsFactory = function;
            this.handlerFactory = function2;
            this.mockInitializer = mockInitializer2;
            this.interceptors = map;
        }
    }

    public static class InlineStaticMockControl<T> implements MockMaker.StaticMockControl<T> {
        private final MockHandler handler;
        private final java.util.Map<Class<?>, MockMethodInterceptor> interceptors;
        private final MockCreationSettings<T> settings;
        private final Class<T> type;

        public void disable() {
            if (this.interceptors.remove(this.type) == null) {
                throw new MockitoException(StringUtil.join("Could not deregister " + this.type.getName() + " as a static mock since it is not currently registered", "", "To register a static mock, use Mockito.mockStatic(" + this.type.getSimpleName() + ".class)"));
            }
        }

        public void enable() {
            if (Map.EL.putIfAbsent(this.interceptors, this.type, new MockMethodInterceptor(this.handler, this.settings)) != null) {
                throw new MockitoException(StringUtil.join("For " + this.type.getName() + ", static mocking is already registered in the current thread", "", "To create a new mock, the existing static mock registration must be deregistered"));
            }
        }

        public Class<T> getType() {
            return this.type;
        }

        private InlineStaticMockControl(Class<T> cls, java.util.Map<Class<?>, MockMethodInterceptor> map, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
            this.type = cls;
            this.interceptors = map;
            this.settings = mockCreationSettings;
            this.handler = mockHandler;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ac, code lost:
        throw r8;
     */
    static {
        /*
            java.lang.String r0 = ".raw"
            java.lang.Class<org.mockito.internal.creation.bytebuddy.InlineDelegateByteBuddyMockMaker> r1 = org.mockito.internal.creation.bytebuddy.InlineDelegateByteBuddyMockMaker.class
            java.lang.String r2 = ""
            r3 = 2
            r4 = 1
            r5 = 3
            r6 = 0
            r7 = 0
            java.lang.instrument.Instrumentation r8 = net.bytebuddy.agent.ByteBuddyAgent.install()     // Catch:{ IOException -> 0x010a }
            boolean r9 = r8.isRetransformClassesSupported()     // Catch:{ IOException -> 0x010a }
            if (r9 == 0) goto L_0x00f2
            java.lang.String r9 = "mockitoboot"
            java.lang.String r10 = ".jar"
            java.io.File r9 = java.io.File.createTempFile(r9, r10)     // Catch:{ IOException -> 0x010a }
            r9.deleteOnExit()     // Catch:{ IOException -> 0x010a }
            java.util.jar.JarOutputStream r10 = new java.util.jar.JarOutputStream     // Catch:{ IOException -> 0x010a }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x010a }
            r11.<init>(r9)     // Catch:{ IOException -> 0x010a }
            r10.<init>(r11)     // Catch:{ IOException -> 0x010a }
            java.lang.String r11 = "org/mockito/internal/creation/bytebuddy/inject/MockMethodDispatcher"
            java.lang.ClassLoader r12 = r1.getClassLoader()     // Catch:{ all -> 0x00ed }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r13.<init>()     // Catch:{ all -> 0x00ed }
            r13.append(r11)     // Catch:{ all -> 0x00ed }
            r13.append(r0)     // Catch:{ all -> 0x00ed }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00ed }
            java.io.InputStream r12 = r12.getResourceAsStream(r13)     // Catch:{ all -> 0x00ed }
            if (r12 == 0) goto L_0x00b2
            java.util.jar.JarEntry r0 = new java.util.jar.JarEntry     // Catch:{ all -> 0x00ed }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r1.<init>()     // Catch:{ all -> 0x00ed }
            r1.append(r11)     // Catch:{ all -> 0x00ed }
            java.lang.String r11 = ".class"
            r1.append(r11)     // Catch:{ all -> 0x00ed }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ed }
            r0.<init>(r1)     // Catch:{ all -> 0x00ed }
            r10.putNextEntry(r0)     // Catch:{ all -> 0x00ed }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00ad }
        L_0x0062:
            int r1 = r12.read(r0)     // Catch:{ all -> 0x00ad }
            r11 = -1
            if (r1 == r11) goto L_0x006d
            r10.write(r0, r6, r1)     // Catch:{ all -> 0x00ad }
            goto L_0x0062
        L_0x006d:
            r12.close()     // Catch:{ all -> 0x00ed }
            r10.closeEntry()     // Catch:{ all -> 0x00ed }
            r10.close()     // Catch:{ IOException -> 0x010a }
            java.util.jar.JarFile r0 = new java.util.jar.JarFile     // Catch:{ IOException -> 0x010a }
            r0.<init>(r9)     // Catch:{ IOException -> 0x010a }
            r8.appendToBootstrapClassLoaderSearch(r0)     // Catch:{ all -> 0x00a1 }
            r0.close()     // Catch:{ IOException -> 0x010a }
            java.lang.String r0 = "org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher"
            java.lang.Class.forName(r0, r6, r7)     // Catch:{ ClassNotFoundException -> 0x008a }
            r0 = r7
            r7 = r8
            goto L_0x0135
        L_0x008a:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x010a }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x010a }
            java.lang.String r9 = "Mockito failed to inject the MockMethodDispatcher class into the bootstrap class loader"
            r8[r6] = r9     // Catch:{ IOException -> 0x010a }
            r8[r4] = r2     // Catch:{ IOException -> 0x010a }
            java.lang.String r9 = "It seems like your current VM does not support the instrumentation API correctly."
            r8[r3] = r9     // Catch:{ IOException -> 0x010a }
            java.lang.String r8 = org.mockito.internal.util.StringUtil.join(r8)     // Catch:{ IOException -> 0x010a }
            r1.<init>(r8, r0)     // Catch:{ IOException -> 0x010a }
            throw r1     // Catch:{ IOException -> 0x010a }
        L_0x00a1:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            r8 = move-exception
            r0.close()     // Catch:{ all -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException -> 0x010a }
        L_0x00ac:
            throw r8     // Catch:{ IOException -> 0x010a }
        L_0x00ad:
            r0 = move-exception
            r12.close()     // Catch:{ all -> 0x00ed }
            throw r0     // Catch:{ all -> 0x00ed }
        L_0x00b2:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00ed }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x00ed }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r12.<init>()     // Catch:{ all -> 0x00ed }
            java.lang.String r13 = "The MockMethodDispatcher class file is not locatable: "
            r12.append(r13)     // Catch:{ all -> 0x00ed }
            r12.append(r11)     // Catch:{ all -> 0x00ed }
            r12.append(r0)     // Catch:{ all -> 0x00ed }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x00ed }
            r9[r6] = r0     // Catch:{ all -> 0x00ed }
            r9[r4] = r2     // Catch:{ all -> 0x00ed }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r0.<init>()     // Catch:{ all -> 0x00ed }
            java.lang.String r11 = "The class loader responsible for looking up the resource: "
            r0.append(r11)     // Catch:{ all -> 0x00ed }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ all -> 0x00ed }
            r0.append(r1)     // Catch:{ all -> 0x00ed }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ed }
            r9[r3] = r0     // Catch:{ all -> 0x00ed }
            java.lang.String r0 = org.mockito.internal.util.StringUtil.join(r9)     // Catch:{ all -> 0x00ed }
            r8.<init>(r0)     // Catch:{ all -> 0x00ed }
            throw r8     // Catch:{ all -> 0x00ed }
        L_0x00ed:
            r0 = move-exception
            r10.close()     // Catch:{ IOException -> 0x010a }
            throw r0     // Catch:{ IOException -> 0x010a }
        L_0x00f2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x010a }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x010a }
            java.lang.String r8 = "Byte Buddy requires retransformation for creating inline mocks. This feature is unavailable on the current VM."
            r1[r6] = r8     // Catch:{ IOException -> 0x010a }
            r1[r4] = r2     // Catch:{ IOException -> 0x010a }
            java.lang.String r8 = "You cannot use this mock maker on this VM"
            r1[r3] = r8     // Catch:{ IOException -> 0x010a }
            java.lang.String r1 = org.mockito.internal.util.StringUtil.join(r1)     // Catch:{ IOException -> 0x010a }
            r0.<init>(r1)     // Catch:{ IOException -> 0x010a }
            throw r0     // Catch:{ IOException -> 0x010a }
        L_0x0108:
            r0 = move-exception
            goto L_0x0135
        L_0x010a:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0108 }
            r8 = 4
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0108 }
            java.lang.String r9 = "Mockito could not self-attach a Java agent to the current VM. This feature is required for inline mocking."
            r8[r6] = r9     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r6.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r9 = "This error occured due to an I/O error during the creation of this agent: "
            r6.append(r9)     // Catch:{ all -> 0x0108 }
            r6.append(r0)     // Catch:{ all -> 0x0108 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0108 }
            r8[r4] = r6     // Catch:{ all -> 0x0108 }
            r8[r3] = r2     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = "Potentially, the current VM does not support the instrumentation API correctly"
            r8[r5] = r2     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = org.mockito.internal.util.StringUtil.join(r8)     // Catch:{ all -> 0x0108 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0108 }
            throw r1     // Catch:{ all -> 0x0108 }
        L_0x0135:
            INSTRUMENTATION = r7
            INITIALIZATION_ERROR = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.InlineDelegateByteBuddyMockMaker.<clinit>():void");
    }

    public InlineDelegateByteBuddyMockMaker() {
        String str;
        WeakConcurrentMap.WithInlinedExpunction withInlinedExpunction = new WeakConcurrentMap.WithInlinedExpunction();
        this.mocks = withInlinedExpunction;
        DetachedThreadLocal.Cleaner cleaner = DetachedThreadLocal.Cleaner.INLINE;
        DetachedThreadLocal<java.util.Map<Class<?>, MockMethodInterceptor>> detachedThreadLocal = new DetachedThreadLocal<>(cleaner);
        this.mockedStatics = detachedThreadLocal;
        this.mockedConstruction = new DetachedThreadLocal<>(cleaner);
        Throwable th2 = INITIALIZATION_ERROR;
        if (th2 != null) {
            if (!System.getProperty("java.specification.vendor", "").toLowerCase().contains("android")) {
                try {
                    if ((th2 instanceof NoClassDefFoundError) && th2.getMessage() != null) {
                        if (th2.getMessage().startsWith("net/bytebuddy/agent/")) {
                            str = StringUtil.join("It seems like you are running Mockito with an incomplete or inconsistent class path. Byte Buddy Agent could not be loaded.", "", "Byte Buddy Agent is available on Maven Central as 'net.bytebuddy:byte-buddy-agent' with the module name 'net.bytebuddy.agent'.", "Normally, your IDE or build tool (such as Maven or Gradle) should take care of your class path completion but ");
                        }
                    }
                    if (Class.forName("javax.tools.ToolProvider").getMethod("getSystemJavaCompiler", new Class[0]).invoke((Object) null, new Object[0]) == null) {
                        str = "It appears as if you are running on a JRE. Either install a JDK or add JNA to the class path.";
                    } else {
                        str = "It appears as if your JDK does not supply a working agent attachment mechanism.";
                    }
                } catch (Throwable unused) {
                    str = "It appears as if you are running an incomplete JVM installation that might not support all tooling APIs";
                }
            } else {
                str = "It appears as if you are trying to run this mock maker on Android which does not support the instrumentation API.";
            }
            throw new MockitoInitializationException(StringUtil.join("Could not initialize inline Byte Buddy mock maker.", "", str, Platform.describe()), INITIALIZATION_ERROR);
        }
        ThreadLocal threadLocal = new ThreadLocal();
        b bVar = new b(new d());
        this.bytecodeGenerator = new TypeCachingBytecodeGenerator(new InlineBytecodeGenerator(INSTRUMENTATION, withInlinedExpunction, detachedThreadLocal, new e(this, bVar, threadLocal), new f(this, bVar, threadLocal)), true);
    }

    private <T> T doCreateMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, boolean z11) {
        T t11;
        boolean z12;
        Class<? extends T> createMockType = createMockType(mockCreationSettings);
        try {
            if (mockCreationSettings.isUsingConstructor()) {
                if (mockCreationSettings.getOuterClassInstance() != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                t11 = new ConstructorInstantiator(z12, mockCreationSettings.getConstructorArgs()).newInstance(createMockType);
            } else {
                try {
                    t11 = newInstance(createMockType);
                } catch (InstantiationException unused) {
                    if (z11) {
                        return null;
                    }
                    t11 = Plugins.getInstantiatorProvider().getInstantiator(mockCreationSettings).newInstance(createMockType);
                }
            }
            MockMethodInterceptor mockMethodInterceptor = new MockMethodInterceptor(mockHandler, mockCreationSettings);
            this.mocks.put(t11, mockMethodInterceptor);
            if (t11 instanceof MockAccess) {
                ((MockAccess) t11).setMockitoInterceptor(mockMethodInterceptor);
            }
            return t11;
        } catch (InstantiationException e11) {
            throw new MockitoException("Unable to create mock instance of type '" + createMockType.getSimpleName() + "'", e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(ThreadLocal threadLocal, ThreadLocal threadLocal2, Class cls) {
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return false;
        }
        if (this.mockitoConstruction.get().booleanValue() || threadLocal2.get() != null) {
            return true;
        }
        java.util.Map map = this.mockedConstruction.get();
        if (map == null || !map.containsKey(cls)) {
            return false;
        }
        threadLocal2.set(cls);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$3(ThreadLocal threadLocal, ThreadLocal threadLocal2, Class cls, Object obj, Object[] objArr, String[] strArr) {
        BiConsumer biConsumer;
        Throwable th2 = null;
        if (this.mockitoConstruction.get().booleanValue()) {
            Object obj2 = this.currentSpied.get();
            if (obj2 == null) {
                return null;
            }
            if (cls.isInstance(obj2)) {
                return obj2;
            }
            threadLocal.set(Boolean.TRUE);
            try {
                String str = "Unexpected spy for " + cls.getName() + " on instance of " + obj.getClass().getName();
                if (obj instanceof Throwable) {
                    th2 = (Throwable) obj;
                }
                throw new MockitoException(str, th2);
            } catch (Throwable th3) {
                threadLocal.set(Boolean.FALSE);
                throw th3;
            }
        } else if (threadLocal2.get() != cls) {
            return null;
        } else {
            threadLocal2.remove();
            threadLocal.set(Boolean.TRUE);
            try {
                java.util.Map map = this.mockedConstruction.get();
                if (!(map == null || (biConsumer = (BiConsumer) map.get(cls)) == null)) {
                    biConsumer.accept(obj, new InlineConstructionMockContext(objArr, obj.getClass(), strArr));
                }
                return null;
            } finally {
                threadLocal.set(Boolean.FALSE);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$newInstance$4(MemberAccessor.ConstructionDispatcher constructionDispatcher) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        this.mockitoConstruction.set(Boolean.TRUE);
        try {
            return constructionDispatcher.newInstance();
        } finally {
            this.mockitoConstruction.set(Boolean.FALSE);
        }
    }

    private Object makeStandardArgument(Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Character.TYPE) {
            return 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        return null;
    }

    private <T> RuntimeException prettifyFailure(MockCreationSettings<T> mockCreationSettings, Exception exc) {
        String str;
        Exception exc2 = exc;
        if (mockCreationSettings.getTypeToMock().isArray()) {
            throw new MockitoException(StringUtil.join("Arrays cannot be mocked: " + mockCreationSettings.getTypeToMock() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, ""), exc2);
        } else if (Modifier.isFinal(mockCreationSettings.getTypeToMock().getModifiers())) {
            throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "Can not mock final classes with the following settings :", " - explicit serialization (e.g. withSettings().serializable())", " - extra interfaces (e.g. withSettings().extraInterfaces(...))", "", "You are seeing this disclaimer because Mockito is configured to create inlined mocks.", "You can learn about inline mocks and their limitations under item #39 of the Mockito class javadoc.", "", "Underlying exception : " + exc2), exc2);
        } else if (!Modifier.isPrivate(mockCreationSettings.getTypeToMock().getModifiers())) {
            Object[] objArr = new Object[11];
            objArr[0] = "Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
            objArr[1] = "";
            objArr[2] = "If you're not sure why you're getting this error, please report to the mailing list.";
            objArr[3] = "";
            if (Platform.isJava8BelowUpdate45()) {
                str = "Java 8 early builds have bugs that were addressed in Java 1.8.0_45, please update your JDK!\n";
            } else {
                str = "";
            }
            objArr[4] = Platform.warnForVM("IBM J9 VM", "Early IBM virtual machine are known to have issues with Mockito, please upgrade to an up-to-date version.\n", "Hotspot", str);
            objArr[5] = Platform.describe();
            objArr[6] = "";
            objArr[7] = "You are seeing this disclaimer because Mockito is configured to create inlined mocks.";
            objArr[8] = "You can learn about inline mocks and their limitations under item #39 of the Mockito class javadoc.";
            objArr[9] = "";
            objArr[10] = "Underlying exception : " + exc2;
            throw new MockitoException(StringUtil.join(objArr), exc2);
        } else {
            throw new MockitoException(StringUtil.join("Mockito cannot mock this class: " + mockCreationSettings.getTypeToMock() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "Most likely it is a private class that is not visible by Mockito", "", "You are seeing this disclaimer because Mockito is configured to create inlined mocks.", "You can learn about inline mocks and their limitations under item #39 of the Mockito class javadoc.", ""), exc2);
        }
    }

    public void clearAllCaches() {
        clearAllMocks();
        this.bytecodeGenerator.clearAllCaches();
    }

    public void clearAllMocks() {
        this.mockedStatics.getBackingMap().clear();
        this.mocks.clear();
    }

    public void clearMock(Object obj) {
        if (obj instanceof Class) {
            for (V remove : this.mockedStatics.getBackingMap().target.values()) {
                remove.remove(obj);
            }
            return;
        }
        this.mocks.remove(obj);
    }

    public <T> MockMaker.ConstructionMockControl<T> createConstructionMock(Class<T> cls, Function<MockedConstruction.Context, MockCreationSettings<T>> function, Function<MockedConstruction.Context, MockHandler<T>> function2, MockedConstruction.MockInitializer<T> mockInitializer) {
        if (cls == Object.class) {
            throw new MockitoException("It is not possible to mock construction of the Object class to avoid inference with default object constructor chains");
        } else if (cls.isPrimitive() || Modifier.isAbstract(cls.getModifiers())) {
            throw new MockitoException("It is not possible to construct primitive types or abstract types: " + cls.getName());
        } else {
            this.bytecodeGenerator.mockClassConstruction(cls);
            java.util.Map map = this.mockedConstruction.get();
            if (map == null) {
                map = new WeakHashMap();
                this.mockedConstruction.set(map);
            }
            return new InlineConstructionMockControl(cls, function, function2, mockInitializer, map);
        }
    }

    public <T> T createMock(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        return doCreateMock(mockCreationSettings, mockHandler, false);
    }

    public <T> Class<? extends T> createMockType(MockCreationSettings<T> mockCreationSettings) {
        try {
            return this.bytecodeGenerator.mockClass(MockFeatures.withMockFeatures(mockCreationSettings.getTypeToMock(), mockCreationSettings.getExtraInterfaces(), mockCreationSettings.getSerializableMode(), mockCreationSettings.isStripAnnotations(), mockCreationSettings.getDefaultAnswer()));
        } catch (Exception e11) {
            throw prettifyFailure(mockCreationSettings, e11);
        }
    }

    public <T> Optional<T> createSpy(MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler, T t11) {
        if (t11 != null) {
            this.currentSpied.set(t11);
            try {
                return Optional.ofNullable(doCreateMock(mockCreationSettings, mockHandler, true));
            } finally {
                this.currentSpied.remove();
            }
        } else {
            throw new MockitoConfigurationException("Spy instance must not be null");
        }
    }

    public <T> MockMaker.StaticMockControl<T> createStaticMock(Class<T> cls, MockCreationSettings<T> mockCreationSettings, MockHandler mockHandler) {
        if (cls == ConcurrentHashMap.class) {
            throw new MockitoException("It is not possible to mock static methods of ConcurrentHashMap to avoid infinitive loops within Mockito's implementation of static mock handling");
        } else if (cls == Thread.class || cls == System.class || cls == Arrays.class || ClassLoader.class.isAssignableFrom(cls)) {
            throw new MockitoException("It is not possible to mock static methods of " + cls.getName() + " to avoid interfering with class loading what leads to infinite loops");
        } else {
            this.bytecodeGenerator.mockClassStatic(cls);
            java.util.Map map = this.mockedStatics.get();
            if (map == null) {
                map = new WeakHashMap();
                this.mockedStatics.set(map);
            }
            return new InlineStaticMockControl(cls, map, mockCreationSettings, mockHandler);
        }
    }

    public MockHandler getHandler(Object obj) {
        MockMethodInterceptor mockMethodInterceptor;
        if (obj instanceof Class) {
            java.util.Map map = this.mockedStatics.get();
            if (map != null) {
                mockMethodInterceptor = (MockMethodInterceptor) map.get(obj);
            } else {
                mockMethodInterceptor = null;
            }
        } else {
            mockMethodInterceptor = this.mocks.get(obj);
        }
        if (mockMethodInterceptor == null) {
            return null;
        }
        return mockMethodInterceptor.f63168b;
    }

    public MockMaker.TypeMockability isTypeMockable(final Class<?> cls) {
        return new MockMaker.TypeMockability() {
            public boolean mockable() {
                return InlineDelegateByteBuddyMockMaker.INSTRUMENTATION.isModifiableClass(cls) && !InlineBytecodeGenerator.f63154b.contains(cls);
            }

            public String nonMockableReason() {
                if (mockable()) {
                    return "";
                }
                if (cls.isPrimitive()) {
                    return "primitive type";
                }
                if (InlineBytecodeGenerator.f63154b.contains(cls)) {
                    return "Cannot mock wrapper types, String.class or Class.class";
                }
                return "VM does not support modification of given type";
            }
        };
    }

    public <T> T newInstance(Class<T> cls) throws InstantiationException {
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors.length != 0) {
            int i11 = 0;
            Constructor constructor = declaredConstructors[0];
            int length = declaredConstructors.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                Constructor constructor2 = declaredConstructors[i12];
                if (Modifier.isPublic(constructor2.getModifiers())) {
                    constructor = constructor2;
                    break;
                }
                i12++;
            }
            Class[] parameterTypes = constructor.getParameterTypes();
            Object[] objArr = new Object[parameterTypes.length];
            int length2 = parameterTypes.length;
            int i13 = 0;
            while (i11 < length2) {
                objArr[i13] = makeStandardArgument(parameterTypes[i11]);
                i11++;
                i13++;
            }
            try {
                return Plugins.getMemberAccessor().newInstance(constructor, new b(this), objArr);
            } catch (Exception e11) {
                throw new InstantiationException("Could not instantiate " + cls.getName(), e11);
            }
        } else {
            throw new InstantiationException(cls.getName() + " does not define a constructor");
        }
    }

    public void resetMock(Object obj, MockHandler mockHandler, MockCreationSettings mockCreationSettings) {
        MockMethodInterceptor mockMethodInterceptor = new MockMethodInterceptor(mockHandler, mockCreationSettings);
        if (obj instanceof Class) {
            java.util.Map map = this.mockedStatics.get();
            if (map == null || !map.containsKey(obj)) {
                throw new MockitoException("Cannot reset " + obj + " which is not currently registered as a static mock");
            }
            map.put((Class) obj, mockMethodInterceptor);
        } else if (this.mocks.containsKey(obj)) {
            this.mocks.put(obj, mockMethodInterceptor);
            if (obj instanceof MockAccess) {
                ((MockAccess) obj).setMockitoInterceptor(mockMethodInterceptor);
            }
        } else {
            throw new MockitoException("Cannot reset " + obj + " which is not currently registered as a mock");
        }
    }
}
