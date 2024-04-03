package net.bytebuddy.dynamic.loading;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URLStreamHandler;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.loading.ClassFilePostProcessor;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import net.bytebuddy.utility.JavaModule;

public class ByteArrayClassLoader extends InjectionClassLoader {
    private static final boolean ACCESS_CONTROLLER;
    private static final int FROM_BEGINNING = 0;
    /* access modifiers changed from: private */
    public static final URL NO_URL = null;
    /* access modifiers changed from: private */
    public static final PackageLookupStrategy PACKAGE_LOOKUP_STRATEGY = ((PackageLookupStrategy) doPrivileged(PackageLookupStrategy.CreationAction.INSTANCE));
    public static final String URL_SCHEMA = "bytebuddy";

    /* renamed from: g  reason: collision with root package name */
    public static final SynchronizationStrategy.Initializable f27178g = ((SynchronizationStrategy.Initializable) doPrivileged(SynchronizationStrategy.CreationAction.INSTANCE));

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap<String, byte[]> f27179a;

    /* renamed from: b  reason: collision with root package name */
    public final PersistenceHandler f27180b;

    /* renamed from: c  reason: collision with root package name */
    public final ProtectionDomain f27181c;

    /* renamed from: d  reason: collision with root package name */
    public final PackageDefinitionStrategy f27182d;

    /* renamed from: e  reason: collision with root package name */
    public final ClassFilePostProcessor f27183e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f27184f;

    public static class ChildFirst extends ByteArrayClassLoader {
        private static final String CLASS_FILE_SUFFIX = ".class";

        public static class PrependingEnumeration implements Enumeration<URL> {
            private final Enumeration<URL> enumeration;
            private URL nextElement;

            public PrependingEnumeration(URL url, Enumeration<URL> enumeration2) {
                this.nextElement = url;
                this.enumeration = enumeration2;
            }

            public boolean hasMoreElements() {
                return this.nextElement != null && this.enumeration.hasMoreElements();
            }

            public URL nextElement() {
                if (this.nextElement == null || !this.enumeration.hasMoreElements()) {
                    throw new NoSuchElementException();
                }
                try {
                    return this.nextElement;
                } finally {
                    this.nextElement = this.enumeration.nextElement();
                }
            }
        }

        static {
            doRegisterAsParallelCapable();
        }

        public ChildFirst(ClassLoader classLoader, Map<String, byte[]> map) {
            super(classLoader, map);
        }

        @SuppressFBWarnings(justification = "Must be invoked from targeting ClassLoader class.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
        private static void doRegisterAsParallelCapable() {
            try {
                Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke((Object) null, new Object[0]);
            } catch (Throwable unused) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean isShadowed(java.lang.String r4) {
            /*
                r3 = this;
                net.bytebuddy.dynamic.loading.ByteArrayClassLoader$PersistenceHandler r0 = r3.f27180b
                boolean r0 = r0.isManifest()
                r1 = 0
                if (r0 != 0) goto L_0x0042
                java.lang.String r0 = ".class"
                boolean r0 = r4.endsWith(r0)
                if (r0 != 0) goto L_0x0012
                goto L_0x0042
            L_0x0012:
                monitor-enter(r3)
                r0 = 47
                r2 = 46
                java.lang.String r0 = r4.replace(r0, r2)     // Catch:{ all -> 0x003f }
                int r4 = r4.length()     // Catch:{ all -> 0x003f }
                int r4 = r4 + -6
                java.lang.String r4 = r0.substring(r1, r4)     // Catch:{ all -> 0x003f }
                java.util.concurrent.ConcurrentMap<java.lang.String, byte[]> r0 = r3.f27179a     // Catch:{ all -> 0x003f }
                boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x003f }
                r2 = 1
                if (r0 == 0) goto L_0x0030
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                return r2
            L_0x0030:
                java.lang.Class r4 = r3.findLoadedClass(r4)     // Catch:{ all -> 0x003f }
                if (r4 == 0) goto L_0x003d
                java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x003f }
                if (r4 != r3) goto L_0x003d
                r1 = r2
            L_0x003d:
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                return r1
            L_0x003f:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x003f }
                throw r4
            L_0x0042:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.ChildFirst.isShadowed(java.lang.String):boolean");
        }

        public static Map<TypeDescription, Class<?>> load(ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
            return load(classLoader, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
        }

        public URL getResource(String str) {
            URL c11 = this.f27180b.c(str, this.f27179a);
            if (c11 != null || isShadowed(str)) {
                return c11;
            }
            return super.getResource(str);
        }

        public Enumeration<URL> getResources(String str) throws IOException {
            URL c11 = this.f27180b.c(str, this.f27179a);
            if (c11 == null) {
                return super.getResources(str);
            }
            return new PrependingEnumeration(c11, super.getResources(str));
        }

        public Class<?> loadClass(String str, boolean z11) throws ClassNotFoundException {
            synchronized (ByteArrayClassLoader.f27178g.initialize().getClassLoadingLock(this, str)) {
                Class<?> findLoadedClass = findLoadedClass(str);
                if (findLoadedClass != null) {
                    return findLoadedClass;
                }
                try {
                    Class<?> findClass = findClass(str);
                    if (z11) {
                        resolveClass(findClass);
                    }
                    return findClass;
                } catch (ClassNotFoundException unused) {
                    return super.loadClass(str, z11);
                }
            }
        }

        public ChildFirst(ClassLoader classLoader, boolean z11, Map<String, byte[]> map) {
            super(classLoader, z11, map);
        }

        @SuppressFBWarnings(justification = "Privilege is explicit user responsibility", value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        public static Map<TypeDescription, Class<?>> load(ClassLoader classLoader, Map<TypeDescription, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, boolean z11, boolean z12) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                hashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
            }
            ChildFirst childFirst = new ChildFirst(classLoader, z12, hashMap, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (TypeDescription next2 : map.keySet()) {
                try {
                    Class<?> cls = Class.forName(next2.getName(), false, childFirst);
                    if (z11) {
                        if (cls.getClassLoader() != childFirst) {
                            throw new IllegalStateException("Class already loaded: " + cls);
                        }
                    }
                    linkedHashMap.put(next2, cls);
                } catch (ClassNotFoundException e11) {
                    throw new IllegalStateException("Cannot load class " + next2, e11);
                }
            }
            return linkedHashMap;
        }

        public ChildFirst(ClassLoader classLoader, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
            super(classLoader, map, persistenceHandler);
        }

        public ChildFirst(ClassLoader classLoader, boolean z11, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
            super(classLoader, z11, map, persistenceHandler);
        }

        public ChildFirst(ClassLoader classLoader, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
            super(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
        }

        public ChildFirst(ClassLoader classLoader, boolean z11, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
            super(classLoader, z11, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
        }

        public ChildFirst(ClassLoader classLoader, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
            super(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
        }

        public ChildFirst(ClassLoader classLoader, boolean z11, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
            super(classLoader, z11, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class ClassDefinitionAction implements PrivilegedAction<Class<?>> {
        private final byte[] binaryRepresentation;

        /* renamed from: name  reason: collision with root package name */
        private final String f27186name;

        public ClassDefinitionAction(String str, byte[] bArr) {
            this.f27186name = str;
            this.binaryRepresentation = bArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassDefinitionAction classDefinitionAction = (ClassDefinitionAction) obj;
            return this.f27186name.equals(classDefinitionAction.f27186name) && Arrays.equals(this.binaryRepresentation, classDefinitionAction.binaryRepresentation) && ByteArrayClassLoader.this.equals(ByteArrayClassLoader.this);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.f27186name.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + ByteArrayClassLoader.this.hashCode();
        }

        public Class<?> run() {
            int lastIndexOf = this.f27186name.lastIndexOf(46);
            if (lastIndexOf != -1) {
                String substring = this.f27186name.substring(0, lastIndexOf);
                ByteArrayClassLoader byteArrayClassLoader = ByteArrayClassLoader.this;
                PackageDefinitionStrategy.Definition define = byteArrayClassLoader.f27182d.define(byteArrayClassLoader, substring, this.f27186name);
                if (define.isDefined()) {
                    Package apply = ByteArrayClassLoader.PACKAGE_LOOKUP_STRATEGY.apply(ByteArrayClassLoader.this, substring);
                    if (apply == null) {
                        Package unused = ByteArrayClassLoader.this.definePackage(substring, define.getSpecificationTitle(), define.getSpecificationVersion(), define.getSpecificationVendor(), define.getImplementationTitle(), define.getImplementationVersion(), define.getImplementationVendor(), define.getSealBase());
                    } else if (!define.isCompatibleTo(apply)) {
                        throw new SecurityException("Sealing violation for package " + substring);
                    }
                }
            }
            ByteArrayClassLoader byteArrayClassLoader2 = ByteArrayClassLoader.this;
            String str = this.f27186name;
            byte[] bArr = this.binaryRepresentation;
            return byteArrayClassLoader2.defineClass(str, bArr, 0, bArr.length, byteArrayClassLoader2.f27181c);
        }
    }

    public enum EmptyEnumeration implements Enumeration<URL> {
        INSTANCE;

        public boolean hasMoreElements() {
            return false;
        }

        public URL nextElement() {
            throw new NoSuchElementException();
        }
    }

    public interface PackageLookupStrategy {

        public enum CreationAction implements PrivilegedAction<PackageLookupStrategy> {
            INSTANCE;

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
            public PackageLookupStrategy run() {
                if (!JavaModule.isSupported()) {
                    return ForLegacyVm.INSTANCE;
                }
                try {
                    return new ForJava9CapableVm(ClassLoader.class.getMethod("getDefinedPackage", new Class[]{String.class}));
                } catch (Exception unused) {
                    return ForLegacyVm.INSTANCE;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava9CapableVm implements PackageLookupStrategy {
            private final Method getDefinedPackage;

            public ForJava9CapableVm(Method method) {
                this.getDefinedPackage = method;
            }

            public Package apply(ByteArrayClassLoader byteArrayClassLoader, String str) {
                try {
                    return (Package) this.getDefinedPackage.invoke(byteArrayClassLoader, new Object[]{str});
                } catch (IllegalAccessException e11) {
                    throw new IllegalStateException(e11);
                } catch (InvocationTargetException e12) {
                    throw new IllegalStateException(e12.getTargetException());
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.getDefinedPackage.equals(((ForJava9CapableVm) obj).getDefinedPackage);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.getDefinedPackage.hashCode();
            }
        }

        public enum ForLegacyVm implements PackageLookupStrategy {
            INSTANCE;

            public Package apply(ByteArrayClassLoader byteArrayClassLoader, String str) {
                return byteArrayClassLoader.doGetPackage(str);
            }
        }

        Package apply(ByteArrayClassLoader byteArrayClassLoader, String str);
    }

    public enum PersistenceHandler {
        MANIFEST(true) {
            public byte[] a(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return concurrentMap.get(str);
            }

            public void b(String str, ConcurrentMap<String, byte[]> concurrentMap) {
            }

            public URL c(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                if (!str.endsWith(".class")) {
                    return ByteArrayClassLoader.NO_URL;
                }
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                byte[] bArr = concurrentMap.get(str.replace('/', '.').substring(0, str.length() - 6));
                if (bArr == null) {
                    return ByteArrayClassLoader.NO_URL;
                }
                return (URL) ByteArrayClassLoader.doPrivileged(new UrlDefinitionAction(str, bArr));
            }
        },
        LATENT(false) {
            public byte[] a(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return concurrentMap.remove(str);
            }

            public void b(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                concurrentMap.remove(str);
            }

            public URL c(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return ByteArrayClassLoader.NO_URL;
            }
        };
        
        private static final String CLASS_FILE_SUFFIX = ".class";
        private final boolean manifest;

        @HashCodeAndEqualsPlugin.Enhance
        public static class UrlDefinitionAction implements PrivilegedAction<URL> {
            private static final String ENCODING = "UTF-8";
            private static final String NO_FILE = "";
            private static final int NO_PORT = -1;
            private final byte[] binaryRepresentation;
            private final String typeName;

            @HashCodeAndEqualsPlugin.Enhance
            public static class ByteArrayUrlStreamHandler extends URLStreamHandler {
                private final byte[] binaryRepresentation;

                public static class ByteArrayUrlConnection extends URLConnection {
                    private final InputStream inputStream;

                    public ByteArrayUrlConnection(URL url, InputStream inputStream2) {
                        super(url);
                        this.inputStream = inputStream2;
                    }

                    public void connect() {
                        this.connected = true;
                    }

                    public InputStream getInputStream() {
                        connect();
                        return this.inputStream;
                    }
                }

                public ByteArrayUrlStreamHandler(byte[] bArr) {
                    this.binaryRepresentation = bArr;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && Arrays.equals(this.binaryRepresentation, ((ByteArrayUrlStreamHandler) obj).binaryRepresentation);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + Arrays.hashCode(this.binaryRepresentation);
                }

                public URLConnection openConnection(URL url) {
                    return new ByteArrayUrlConnection(url, new ByteArrayInputStream(this.binaryRepresentation));
                }
            }

            public UrlDefinitionAction(String str, byte[] bArr) {
                this.typeName = str;
                this.binaryRepresentation = bArr;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UrlDefinitionAction urlDefinitionAction = (UrlDefinitionAction) obj;
                return this.typeName.equals(urlDefinitionAction.typeName) && Arrays.equals(this.binaryRepresentation, urlDefinitionAction.binaryRepresentation);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typeName.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation);
            }

            public URL run() {
                try {
                    return new URL(ByteArrayClassLoader.URL_SCHEMA, URLEncoder.encode(this.typeName.replace('.', '/'), "UTF-8"), -1, "", new ByteArrayUrlStreamHandler(this.binaryRepresentation));
                } catch (MalformedURLException e11) {
                    throw new IllegalStateException("Cannot create URL for " + this.typeName, e11);
                } catch (UnsupportedEncodingException e12) {
                    throw new IllegalStateException("Could not find encoding: UTF-8", e12);
                }
            }
        }

        public abstract byte[] a(String str, ConcurrentMap<String, byte[]> concurrentMap);

        public abstract void b(String str, ConcurrentMap<String, byte[]> concurrentMap);

        public abstract URL c(String str, ConcurrentMap<String, byte[]> concurrentMap);

        public boolean isManifest() {
            return this.manifest;
        }

        private PersistenceHandler(boolean z11) {
            this.manifest = z11;
        }
    }

    public static class SingletonEnumeration implements Enumeration<URL> {
        private URL element;

        public SingletonEnumeration(URL url) {
            this.element = url;
        }

        public boolean hasMoreElements() {
            return this.element != null;
        }

        public URL nextElement() {
            URL url = this.element;
            if (url != null) {
                this.element = null;
                return url;
            }
            throw new NoSuchElementException();
        }
    }

    public interface SynchronizationStrategy {

        public enum CreationAction implements PrivilegedAction<Initializable> {
            INSTANCE;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object[]} */
            /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|(2:10|14)(2:9|15)) */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a0, code lost:
                return net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                return new net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForJava7CapableVm(r3.getDeclaredMethod("getClassLoadingLock", new java.lang.Class[]{r4}));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                return net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0083, code lost:
                if (net.bytebuddy.ClassFileVersion.ofThisVm(net.bytebuddy.ClassFileVersion.JAVA_V5).isAtLeast(net.bytebuddy.ClassFileVersion.JAVA_V9) == false) goto L_0x0090;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0077 */
            /* JADX WARNING: Multi-variable type inference failed */
            @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.Initializable run() {
                /*
                    r16 = this;
                    java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                    java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
                    java.lang.String r2 = "getClassLoadingLock"
                    java.lang.Class<java.lang.ClassLoader> r3 = java.lang.ClassLoader.class
                    java.lang.Class<java.lang.String> r4 = java.lang.String.class
                    r5 = 1
                    r6 = 0
                    java.lang.String r7 = "java.lang.invoke.MethodType"
                    java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ Exception -> 0x0077 }
                    java.lang.String r8 = "java.lang.invoke.MethodHandle"
                    java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x0077 }
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava8CapableVm r9 = new net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava8CapableVm     // Catch:{ Exception -> 0x0077 }
                    java.lang.String r10 = "java.lang.invoke.MethodHandles$Lookup"
                    java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ Exception -> 0x0077 }
                    java.lang.String r11 = "findVirtual"
                    r12 = 3
                    java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ Exception -> 0x0077 }
                    r13[r6] = r1     // Catch:{ Exception -> 0x0077 }
                    r13[r5] = r4     // Catch:{ Exception -> 0x0077 }
                    r14 = 2
                    r13[r14] = r7     // Catch:{ Exception -> 0x0077 }
                    java.lang.reflect.Method r10 = r10.getMethod(r11, r13)     // Catch:{ Exception -> 0x0077 }
                    java.lang.Object r11 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.methodHandle()     // Catch:{ Exception -> 0x0077 }
                    java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0077 }
                    r12[r6] = r3     // Catch:{ Exception -> 0x0077 }
                    r12[r5] = r2     // Catch:{ Exception -> 0x0077 }
                    java.lang.String r13 = "methodType"
                    java.lang.Class[] r15 = new java.lang.Class[r14]     // Catch:{ Exception -> 0x0077 }
                    r15[r6] = r1     // Catch:{ Exception -> 0x0077 }
                    java.lang.Class<java.lang.Class[]> r1 = java.lang.Class[].class
                    r15[r5] = r1     // Catch:{ Exception -> 0x0077 }
                    java.lang.reflect.Method r1 = r7.getMethod(r13, r15)     // Catch:{ Exception -> 0x0077 }
                    java.lang.Object[] r7 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0077 }
                    r7[r6] = r0     // Catch:{ Exception -> 0x0077 }
                    java.lang.Class[] r13 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0077 }
                    r13[r6] = r4     // Catch:{ Exception -> 0x0077 }
                    r7[r5] = r13     // Catch:{ Exception -> 0x0077 }
                    r13 = 0
                    java.lang.Object r1 = r1.invoke(r13, r7)     // Catch:{ Exception -> 0x0077 }
                    r12[r14] = r1     // Catch:{ Exception -> 0x0077 }
                    java.lang.Object r1 = r10.invoke(r11, r12)     // Catch:{ Exception -> 0x0077 }
                    java.lang.String r7 = "bindTo"
                    java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0077 }
                    r10[r6] = r0     // Catch:{ Exception -> 0x0077 }
                    java.lang.reflect.Method r0 = r8.getMethod(r7, r10)     // Catch:{ Exception -> 0x0077 }
                    java.lang.String r7 = "invokeWithArguments"
                    java.lang.Class[] r10 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0077 }
                    java.lang.Class<java.lang.Object[]> r11 = java.lang.Object[].class
                    r10[r6] = r11     // Catch:{ Exception -> 0x0077 }
                    java.lang.reflect.Method r7 = r8.getMethod(r7, r10)     // Catch:{ Exception -> 0x0077 }
                    r9.<init>(r1, r0, r7)     // Catch:{ Exception -> 0x0077 }
                    return r9
                L_0x0077:
                    net.bytebuddy.ClassFileVersion r0 = net.bytebuddy.ClassFileVersion.JAVA_V5     // Catch:{ Exception -> 0x009e }
                    net.bytebuddy.ClassFileVersion r0 = net.bytebuddy.ClassFileVersion.ofThisVm(r0)     // Catch:{ Exception -> 0x009e }
                    net.bytebuddy.ClassFileVersion r1 = net.bytebuddy.ClassFileVersion.JAVA_V9     // Catch:{ Exception -> 0x009e }
                    boolean r0 = r0.isAtLeast(r1)     // Catch:{ Exception -> 0x009e }
                    if (r0 == 0) goto L_0x0090
                    java.lang.Class<net.bytebuddy.dynamic.loading.ByteArrayClassLoader> r0 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.class
                    java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ Exception -> 0x009e }
                    if (r0 != 0) goto L_0x0090
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForLegacyVm r0 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE     // Catch:{ Exception -> 0x009e }
                    goto L_0x009d
                L_0x0090:
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava7CapableVm r0 = new net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForJava7CapableVm     // Catch:{ Exception -> 0x009e }
                    java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x009e }
                    r1[r6] = r4     // Catch:{ Exception -> 0x009e }
                    java.lang.reflect.Method r1 = r3.getDeclaredMethod(r2, r1)     // Catch:{ Exception -> 0x009e }
                    r0.<init>(r1)     // Catch:{ Exception -> 0x009e }
                L_0x009d:
                    return r0
                L_0x009e:
                    net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$ForLegacyVm r0 = net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForLegacyVm.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.CreationAction.run():net.bytebuddy.dynamic.loading.ByteArrayClassLoader$SynchronizationStrategy$Initializable");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava7CapableVm implements SynchronizationStrategy, Initializable {
            private final Method method;

            public ForJava7CapableVm(Method method2) {
                this.method = method2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForJava7CapableVm) obj).method);
            }

            public Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str) {
                try {
                    return this.method.invoke(byteArrayClassLoader, new Object[]{str});
                } catch (IllegalAccessException e11) {
                    throw new IllegalStateException(e11);
                } catch (InvocationTargetException e12) {
                    throw new IllegalStateException(e12.getTargetException());
                }
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            @SuppressFBWarnings(justification = "Privilege is explicitly user responsibility", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
            public SynchronizationStrategy initialize() {
                try {
                    this.method.setAccessible(true);
                    return this;
                } catch (Exception unused) {
                    return ForLegacyVm.INSTANCE;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava8CapableVm implements SynchronizationStrategy, Initializable {
            private final Method bindTo;
            private final Method invokeWithArguments;
            private final Object methodHandle;

            public ForJava8CapableVm(Object obj, Method method, Method method2) {
                this.methodHandle = obj;
                this.bindTo = method;
                this.invokeWithArguments = method2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForJava8CapableVm forJava8CapableVm = (ForJava8CapableVm) obj;
                return this.methodHandle.equals(forJava8CapableVm.methodHandle) && this.bindTo.equals(forJava8CapableVm.bindTo) && this.invokeWithArguments.equals(forJava8CapableVm.invokeWithArguments);
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object[]} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object getClassLoadingLock(net.bytebuddy.dynamic.loading.ByteArrayClassLoader r7, java.lang.String r8) {
                /*
                    r6 = this;
                    java.lang.reflect.Method r0 = r6.invokeWithArguments     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.reflect.Method r1 = r6.bindTo     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object r2 = r6.methodHandle     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r3 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r5 = 0
                    r4[r5] = r7     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object r7 = r1.invoke(r2, r4)     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r2[r5] = r8     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    r1[r5] = r2     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    java.lang.Object r7 = r0.invoke(r7, r1)     // Catch:{ IllegalAccessException -> 0x0028, InvocationTargetException -> 0x001d }
                    return r7
                L_0x001d:
                    r7 = move-exception
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.Throwable r7 = r7.getTargetException()
                    r8.<init>(r7)
                    throw r8
                L_0x0028:
                    r7 = move-exception
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    r8.<init>(r7)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.ForJava8CapableVm.getClassLoadingLock(net.bytebuddy.dynamic.loading.ByteArrayClassLoader, java.lang.String):java.lang.Object");
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.methodHandle.hashCode()) * 31) + this.bindTo.hashCode()) * 31) + this.invokeWithArguments.hashCode();
            }

            public SynchronizationStrategy initialize() {
                return this;
            }
        }

        public enum ForLegacyVm implements SynchronizationStrategy, Initializable {
            INSTANCE;

            public Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str) {
                return byteArrayClassLoader;
            }

            public SynchronizationStrategy initialize() {
                return this;
            }
        }

        public interface Initializable {
            SynchronizationStrategy initialize();
        }

        Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str);
    }

    static {
        boolean z11 = false;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
        } catch (SecurityException unused2) {
            z11 = true;
        }
        doRegisterAsParallelCapable();
        ACCESS_CONTROLLER = z11;
        doRegisterAsParallelCapable();
    }

    public ByteArrayClassLoader(ClassLoader classLoader, Map<String, byte[]> map) {
        this(classLoader, true, map);
    }

    /* access modifiers changed from: private */
    public Package doGetPackage(String str) {
        return getPackage(str);
    }

    /* access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    @SuppressFBWarnings(justification = "Must be invoked from targeting ClassLoader class.", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
    private static void doRegisterAsParallelCapable() {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    @AccessControllerPlugin.Enhance
    private static Object getContext() {
        if (ACCESS_CONTROLLER) {
            return AccessController.getContext();
        }
        return null;
    }

    public static Map<TypeDescription, Class<?>> load(ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
        return load(classLoader, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
    }

    /* access modifiers changed from: private */
    public static Object methodHandle() throws Exception {
        return Class.forName("java.lang.invoke.MethodHandles").getMethod("lookup", new Class[0]).invoke((Object) null, new Object[0]);
    }

    public Map<String, Class<?>> a(Map<String, byte[]> map) throws ClassNotFoundException {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getKey(), this.f27179a.putIfAbsent(next.getKey(), next.getValue()));
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String next2 : map.keySet()) {
                synchronized (f27178g.initialize().getClassLoadingLock(this, next2)) {
                    linkedHashMap.put(next2, loadClass(next2));
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() == null) {
                    this.f27180b.b((String) entry.getKey(), this.f27179a);
                } else {
                    this.f27179a.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            for (Map.Entry entry2 : hashMap.entrySet()) {
                if (entry2.getValue() == null) {
                    this.f27180b.b((String) entry2.getKey(), this.f27179a);
                } else {
                    this.f27179a.put(entry2.getKey(), entry2.getValue());
                }
            }
            throw th2;
        }
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        byte[] a11 = this.f27180b.a(str, this.f27179a);
        if (a11 != null) {
            return (Class) doPrivileged(new ClassDefinitionAction(str, this.f27183e.transform(this, str, this.f27181c, a11)), this.f27184f);
        }
        throw new ClassNotFoundException(str);
    }

    public URL findResource(String str) {
        return this.f27180b.c(str, this.f27179a);
    }

    public Enumeration<URL> findResources(String str) {
        URL c11 = this.f27180b.c(str, this.f27179a);
        if (c11 == null) {
            return EmptyEnumeration.INSTANCE;
        }
        return new SingletonEnumeration(c11);
    }

    public ByteArrayClassLoader(ClassLoader classLoader, boolean z11, Map<String, byte[]> map) {
        this(classLoader, z11, map, PersistenceHandler.LATENT);
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, Object obj) {
        return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction, (AccessControlContext) obj) : privilegedAction.run();
    }

    @SuppressFBWarnings(justification = "Privilege is explicit user responsibility", value = {"DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
    public static Map<TypeDescription, Class<?>> load(ClassLoader classLoader, Map<TypeDescription, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, boolean z11, boolean z12) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
        }
        ByteArrayClassLoader byteArrayClassLoader = new ByteArrayClassLoader(classLoader, z12, hashMap, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TypeDescription next2 : map.keySet()) {
            try {
                Class<?> cls = Class.forName(next2.getName(), false, byteArrayClassLoader);
                if (z11) {
                    if (cls.getClassLoader() != byteArrayClassLoader) {
                        throw new IllegalStateException("Class already loaded: " + cls);
                    }
                }
                linkedHashMap.put(next2, cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Cannot load class " + next2, e11);
            }
        }
        return linkedHashMap;
    }

    public ByteArrayClassLoader(ClassLoader classLoader, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
        this(classLoader, true, map, persistenceHandler);
    }

    public ByteArrayClassLoader(ClassLoader classLoader, boolean z11, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
        this(classLoader, z11, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, persistenceHandler, (PackageDefinitionStrategy) PackageDefinitionStrategy.Trivial.INSTANCE);
    }

    public ByteArrayClassLoader(ClassLoader classLoader, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
        this(classLoader, true, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
    }

    public ByteArrayClassLoader(ClassLoader classLoader, boolean z11, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
        this(classLoader, z11, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
    }

    public ByteArrayClassLoader(ClassLoader classLoader, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
        this(classLoader, true, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
    }

    public ByteArrayClassLoader(ClassLoader classLoader, boolean z11, Map<String, byte[]> map, ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
        super(classLoader, z11);
        this.f27179a = new ConcurrentHashMap(map);
        this.f27181c = protectionDomain;
        this.f27180b = persistenceHandler;
        this.f27182d = packageDefinitionStrategy;
        this.f27183e = classFilePostProcessor;
        this.f27184f = getContext();
    }
}
