package net.bytebuddy.dynamic.loading;

import com.sun.jna.FunctionMapper;
import com.sun.jna.JNIEnv;
import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.MemberRemoval;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.privilege.GetMethodAction;

public interface ClassInjector {
    public static final boolean ALLOW_EXISTING_TYPES = false;
    public static final Permission SUPPRESS_ACCESS_CHECKS = new ReflectPermission("suppressAccessChecks");

    public static abstract class AbstractBase implements ClassInjector {
        public Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(((TypeDescription) next.getKey()).getName(), next.getValue());
            }
            Map<String, Class<?>> injectRaw = injectRaw(linkedHashMap);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (TypeDescription typeDescription : map.keySet()) {
                linkedHashMap2.put(typeDescription, injectRaw.get(typeDescription.getName()));
            }
            return linkedHashMap2;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingInstrumentation extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final String CLASS_FILE_EXTENSION = ".class";
        /* access modifiers changed from: private */
        public static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private static final String JAR = "jar";
        private final File folder;
        private final Instrumentation instrumentation;
        private final RandomString randomString;
        private final Target target;

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("appendToBootstrapClassLoaderSearch")
            void appendToBootstrapClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            @JavaDispatcher.Proxied("appendToSystemClassLoaderSearch")
            void appendToSystemClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            @JavaDispatcher.Proxied("isModifiableModule")
            boolean isModifiableModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj);

            @JavaDispatcher.Proxied("redefineModule")
            void redefineModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj, Set<?> set, Map<String, Set<?>> map, Map<String, Set<?>> map2, Set<Class<?>> set2, Map<Class<?>, List<Class<?>>> map3);
        }

        public enum Target {
            BOOTSTRAP((String) null) {
                public void b(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToBootstrapClassLoaderSearch(instrumentation, jarFile);
                }
            },
            SYSTEM(ClassLoader.getSystemClassLoader()) {
                public void b(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToSystemClassLoaderSearch(instrumentation, jarFile);
                }
            };
            
            private final ClassLoader classLoader;

            public ClassLoader a() {
                return this.classLoader;
            }

            public abstract void b(Instrumentation instrumentation, JarFile jarFile);

            private Target(ClassLoader classLoader2) {
                this.classLoader = classLoader2;
            }
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
            ACCESS_CONTROLLER = z11;
        }

        public UsingInstrumentation(File file, Target target2, Instrumentation instrumentation2, RandomString randomString2) {
            this.folder = file;
            this.target = target2;
            this.instrumentation = instrumentation2;
            this.randomString = randomString2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static boolean isAvailable() {
            return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V6);
        }

        public static ClassInjector of(File file, Target target2, Instrumentation instrumentation2) {
            return new UsingInstrumentation(file, target2, instrumentation2, new RandomString());
        }

        public static void redefineModule(Instrumentation instrumentation2, JavaModule javaModule, Set<JavaModule> set, Map<String, Set<JavaModule>> map, Map<String, Set<JavaModule>> map2, Set<Class<?>> set2, Map<Class<?>, List<Class<?>>> map3) {
            if (DISPATCHER.isModifiableModule(instrumentation2, javaModule.unwrap())) {
                HashSet hashSet = new HashSet();
                for (JavaModule unwrap : set) {
                    hashSet.add(unwrap.unwrap());
                }
                HashMap hashMap = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    HashSet hashSet2 = new HashSet();
                    for (JavaModule unwrap2 : (Set) next.getValue()) {
                        hashSet2.add(unwrap2.unwrap());
                    }
                    hashMap.put(next.getKey(), hashSet2);
                }
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next2 : map2.entrySet()) {
                    HashSet hashSet3 = new HashSet();
                    for (JavaModule unwrap3 : (Set) next2.getValue()) {
                        hashSet3.add(unwrap3.unwrap());
                    }
                    hashMap2.put(next2.getKey(), hashSet3);
                }
                DISPATCHER.redefineModule(instrumentation2, javaModule.unwrap(), hashSet, hashMap, hashMap2, set2, map3);
                return;
            }
            throw new IllegalArgumentException("Cannot modify module: " + javaModule);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UsingInstrumentation usingInstrumentation = (UsingInstrumentation) obj;
            return this.target.equals(usingInstrumentation.target) && this.instrumentation.equals(usingInstrumentation.instrumentation) && this.folder.equals(usingInstrumentation.folder) && this.randomString.equals(usingInstrumentation.randomString);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.target.hashCode()) * 31) + this.folder.hashCode()) * 31) + this.randomString.hashCode();
        }

        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            JarOutputStream jarOutputStream;
            JarFile jarFile;
            File file = this.folder;
            File file2 = new File(file, "jar" + this.randomString.nextString() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + "jar");
            try {
                if (file2.createNewFile()) {
                    try {
                        jarOutputStream = new JarOutputStream(new FileOutputStream(file2));
                        for (Map.Entry next : map.entrySet()) {
                            jarOutputStream.putNextEntry(new JarEntry(((String) next.getKey()).replace('.', '/') + ".class"));
                            jarOutputStream.write((byte[]) next.getValue());
                        }
                        jarOutputStream.close();
                        jarFile = new JarFile(file2, false);
                        this.target.b(this.instrumentation, jarFile);
                        jarFile.close();
                        HashMap hashMap = new HashMap();
                        for (String str : map.keySet()) {
                            hashMap.put(str, Class.forName(str, false, this.target.a()));
                        }
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        return hashMap;
                    } catch (Throwable th2) {
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("Cannot create file " + file2);
                }
            } catch (IOException e11) {
                throw new IllegalStateException("Cannot write jar file to disk", e11);
            } catch (ClassNotFoundException e12) {
                throw new IllegalStateException("Cannot load injected class", e12);
            }
        }

        public boolean isAlive() {
            return isAvailable();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingJna extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object BOOTSTRAP_LOADER_LOCK = new Object();
        private static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(Dispatcher.CreationAction.INSTANCE));
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;

        public interface Dispatcher {

            public enum CreationAction implements PrivilegedAction<Dispatcher> {
                INSTANCE;

                public Dispatcher run() {
                    if (System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9")) {
                        return new Unavailable("J9 does not support JNA-based class definition");
                    }
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("allow-objects", Boolean.TRUE);
                        if (Platform.isWindows() && !Platform.is64Bit()) {
                            hashMap.put("function-mapper", Windows32BitFunctionMapper.INSTANCE);
                        }
                        return new Enabled((Jvm) Native.loadLibrary("jvm", Jvm.class, hashMap));
                    } catch (Throwable th2) {
                        return new Unavailable(th2.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements Dispatcher {
                private final Jvm jvm;

                public Enabled(Jvm jvm2) {
                    this.jvm = jvm2;
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    return this.jvm.JVM_DefineClass(JNIEnv.CURRENT, str.replace('.', '/'), classLoader, bArr, bArr.length, protectionDomain);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.jvm.equals(((Enabled) obj).jvm);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.jvm.hashCode();
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Jvm extends Library {
                Class<?> JVM_DefineClass(JNIEnv jNIEnv, String str, ClassLoader classLoader, byte[] bArr, int i11, ProtectionDomain protectionDomain) throws LastErrorException;
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher {
                private final String error;

                public Unavailable(String str) {
                    this.error = str;
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("JNA is not available and JNA-based injection cannot be used: " + this.error);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.error.equals(((Unavailable) obj).error);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.error.hashCode();
                }

                public boolean isAvailable() {
                    return false;
                }
            }

            public enum Windows32BitFunctionMapper implements FunctionMapper {
                INSTANCE;

                public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
                    if (method.getName().equals("JVM_DefineClass")) {
                        return "_JVM_DefineClass@24";
                    }
                    return method.getName();
                }
            }

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain);

            boolean isAvailable();
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
            ACCESS_CONTROLLER = z11;
        }

        public UsingJna(ClassLoader classLoader2) {
            this(classLoader2, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofBootLoader() {
            return new UsingJna(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r2 != null) goto L_0x0026;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0039 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L_0x0004
                return r0
            L_0x0004:
                r1 = 0
                if (r5 != 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L_0x0013
                return r1
            L_0x0013:
                java.lang.ClassLoader r2 = r4.classLoader
                net.bytebuddy.dynamic.loading.ClassInjector$UsingJna r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingJna) r5
                java.lang.ClassLoader r3 = r5.classLoader
                if (r3 == 0) goto L_0x0024
                if (r2 == 0) goto L_0x0026
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0027
                return r1
            L_0x0024:
                if (r2 == 0) goto L_0x0027
            L_0x0026:
                return r1
            L_0x0027:
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r5 = r5.protectionDomain
                if (r5 == 0) goto L_0x0036
                if (r2 == 0) goto L_0x0038
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0039
                return r1
            L_0x0036:
                if (r2 == 0) goto L_0x0039
            L_0x0038:
                return r1
            L_0x0039:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            ClassLoader classLoader2 = this.classLoader;
            if (classLoader2 != null) {
                hashCode += classLoader2.hashCode();
            }
            int i11 = hashCode * 31;
            ProtectionDomain protectionDomain2 = this.protectionDomain;
            return protectionDomain2 != null ? i11 + protectionDomain2.hashCode() : i11;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|11|12|21|18|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r9) {
            /*
                r8 = this;
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.lang.ClassLoader r1 = r8.classLoader
                if (r1 != 0) goto L_0x000b
                java.lang.Object r1 = BOOTSTRAP_LOADER_LOCK
            L_0x000b:
                monitor-enter(r1)
                java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0055 }
                java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0055 }
            L_0x0014:
                boolean r2 = r9.hasNext()     // Catch:{ all -> 0x0055 }
                if (r2 == 0) goto L_0x0053
                java.lang.Object r2 = r9.next()     // Catch:{ all -> 0x0055 }
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0055 }
                java.lang.Object r3 = r2.getKey()     // Catch:{ ClassNotFoundException -> 0x0035 }
                java.lang.Object r4 = r2.getKey()     // Catch:{ ClassNotFoundException -> 0x0035 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ ClassNotFoundException -> 0x0035 }
                java.lang.ClassLoader r5 = r8.classLoader     // Catch:{ ClassNotFoundException -> 0x0035 }
                r6 = 0
                java.lang.Class r4 = java.lang.Class.forName(r4, r6, r5)     // Catch:{ ClassNotFoundException -> 0x0035 }
                r0.put(r3, r4)     // Catch:{ ClassNotFoundException -> 0x0035 }
                goto L_0x0014
            L_0x0035:
                java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x0055 }
                net.bytebuddy.dynamic.loading.ClassInjector$UsingJna$Dispatcher r4 = DISPATCHER     // Catch:{ all -> 0x0055 }
                java.lang.ClassLoader r5 = r8.classLoader     // Catch:{ all -> 0x0055 }
                java.lang.Object r6 = r2.getKey()     // Catch:{ all -> 0x0055 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0055 }
                java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0055 }
                byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x0055 }
                java.security.ProtectionDomain r7 = r8.protectionDomain     // Catch:{ all -> 0x0055 }
                java.lang.Class r2 = r4.defineClass(r5, r6, r2, r7)     // Catch:{ all -> 0x0055 }
                r0.put(r3, r2)     // Catch:{ all -> 0x0055 }
                goto L_0x0014
            L_0x0053:
                monitor-exit(r1)     // Catch:{ all -> 0x0055 }
                return r0
            L_0x0055:
                r9 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0055 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.injectRaw(java.util.Map):java.util.Map");
        }

        public boolean isAlive() {
            return DISPATCHER.isAvailable();
        }

        public UsingJna(ClassLoader classLoader2, ProtectionDomain protectionDomain2) {
            this.classLoader = classLoader2;
            this.protectionDomain = protectionDomain2;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingLookup extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final MethodHandles METHOD_HANDLES = ((MethodHandles) doPrivileged(JavaDispatcher.of(MethodHandles.class)));
        private static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP = ((MethodHandles.Lookup) doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class)));
        private static final int PACKAGE_LOOKUP = 8;
        private final Object lookup;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        public interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            public interface Lookup {
                @JavaDispatcher.Proxied("defineClass")
                Class<?> defineClass(Object obj, byte[] bArr) throws IllegalAccessException;

                @JavaDispatcher.Proxied("lookupClass")
                Class<?> lookupClass(Object obj);

                @JavaDispatcher.Proxied("lookupModes")
                int lookupModes(Object obj);
            }

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("privateLookupIn")
            Object privateLookupIn(Class<?> cls, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup") Object obj) throws IllegalAccessException;
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
            ACCESS_CONTROLLER = z11;
        }

        public UsingLookup(Object obj) {
            this.lookup = obj;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static boolean isAvailable() {
            return JavaType.MODULE.isAvailable();
        }

        public static UsingLookup of(Object obj) {
            if (!isAvailable()) {
                throw new IllegalStateException("The current VM does not support class definition via method handle lookups");
            } else if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(obj)) {
                throw new IllegalArgumentException("Not a method handle lookup: " + obj);
            } else if ((METHOD_HANDLES_LOOKUP.lookupModes(obj) & 8) != 0) {
                return new UsingLookup(obj);
            } else {
                throw new IllegalArgumentException("Lookup does not imply package-access: " + obj);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.lookup.equals(((UsingLookup) obj).lookup);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.lookup.hashCode();
        }

        public UsingLookup in(Class<?> cls) {
            try {
                return new UsingLookup(METHOD_HANDLES.privateLookupIn(cls, this.lookup));
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException("Cannot access " + cls.getName() + " from " + this.lookup, e11);
            }
        }

        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            String str;
            String name2 = TypeDescription.ForLoadedType.of(lookupType()).getPackage().getName();
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                int lastIndexOf = ((String) next.getKey()).lastIndexOf(46);
                if (lastIndexOf == -1) {
                    str = "";
                } else {
                    str = ((String) next.getKey()).substring(0, lastIndexOf);
                }
                if (name2.equals(str)) {
                    try {
                        hashMap.put(next.getKey(), METHOD_HANDLES_LOOKUP.defineClass(this.lookup, (byte[]) next.getValue()));
                    } catch (Exception e11) {
                        throw new IllegalStateException(e11);
                    }
                } else {
                    throw new IllegalArgumentException(((String) next.getKey()) + " must be defined in the same package as " + this.lookup);
                }
            }
            return hashMap;
        }

        public boolean isAlive() {
            return isAvailable();
        }

        public Class<?> lookupType() {
            return METHOD_HANDLES_LOOKUP.lookupClass(this.lookup);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingReflection extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        /* access modifiers changed from: private */
        public static final Method CHECK_PERMISSION = ((Method) doPrivileged(new GetMethodAction("java.lang.SecurityManager", "checkPermission", Permission.class)));
        private static final Dispatcher.Initializable DISPATCHER = ((Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE));
        /* access modifiers changed from: private */
        public static final System SYSTEM = ((System) doPrivileged(JavaDispatcher.of(System.class)));
        private final ClassLoader classLoader;
        private final boolean forbidExisting;
        private final PackageDefinitionStrategy packageDefinitionStrategy;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;

        public interface Dispatcher {
            public static final Class<?> UNDEFINED = null;

            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
                public Initializable run() {
                    try {
                        if (!JavaModule.isSupported()) {
                            return Direct.a();
                        }
                        if (UsingUnsafe.isAvailable()) {
                            return UsingUnsafeInjection.a();
                        }
                        return UsingUnsafeOverride.a();
                    } catch (InvocationTargetException e11) {
                        return new Initializable.Unavailable(e11.getTargetException().getMessage());
                    } catch (Exception e12) {
                        return new Initializable.Unavailable(e12.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Direct implements Dispatcher, Initializable {

                /* renamed from: a  reason: collision with root package name */
                public final Method f27187a;

                /* renamed from: b  reason: collision with root package name */
                public final Method f27188b;

                /* renamed from: c  reason: collision with root package name */
                public final Method f27189c;

                /* renamed from: d  reason: collision with root package name */
                public final Method f27190d;

                /* renamed from: e  reason: collision with root package name */
                public final Method f27191e;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava7CapableVm extends Direct {
                    private final Method getClassLoadingLock;

                    public ForJava7CapableVm(Method method, Method method2, Method method3, Method method4, Method method5, Method method6) {
                        super(method, method2, method3, method4, method5);
                        this.getClassLoadingLock = method6;
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, new Object[]{str});
                        } catch (IllegalAccessException e11) {
                            throw new IllegalStateException(e11);
                        } catch (InvocationTargetException e12) {
                            throw new IllegalStateException(e12.getTargetException());
                        }
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.getClassLoadingLock.hashCode();
                    }
                }

                public static class ForLegacyVm extends Direct {
                    public ForLegacyVm(Method method, Method method2, Method method3, Method method4, Method method5) {
                        super(method, method2, method3, method4, method5);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }
                }

                public Direct(Method method, Method method2, Method method3, Method method4, Method method5) {
                    this.f27187a = method;
                    this.f27188b = method2;
                    this.f27189c = method3;
                    this.f27190d = method4;
                    this.f27191e = method5;
                }

                @SuppressFBWarnings(justification = "Privilege is explicit caller responsibility", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                public static Initializable a() throws Exception {
                    Method method = null;
                    Class<ClassLoader> cls = ClassLoader.class;
                    Class<String> cls2 = String.class;
                    if (JavaModule.isSupported()) {
                        try {
                            method = cls.getMethod("getDefinedPackage", new Class[]{cls2});
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    Method declaredMethod = cls.getDeclaredMethod("getPackage", new Class[]{cls2});
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = cls.getDeclaredMethod("findLoadedClass", new Class[]{cls2});
                    declaredMethod2.setAccessible(true);
                    Class cls3 = Integer.TYPE;
                    Method declaredMethod3 = cls.getDeclaredMethod("defineClass", new Class[]{cls2, byte[].class, cls3, cls3, ProtectionDomain.class});
                    declaredMethod3.setAccessible(true);
                    Method declaredMethod4 = cls.getDeclaredMethod("definePackage", new Class[]{cls2, cls2, cls2, cls2, cls2, cls2, cls2, URL.class});
                    declaredMethod4.setAccessible(true);
                    try {
                        Method declaredMethod5 = cls.getDeclaredMethod("getClassLoadingLock", new Class[]{cls2});
                        declaredMethod5.setAccessible(true);
                        return new ForJava7CapableVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4, declaredMethod5);
                    } catch (NoSuchMethodException unused2) {
                        return new ForLegacyVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4);
                    }
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.f27188b.invoke(classLoader, new Object[]{str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package definePackage(ClassLoader classLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
                    try {
                        return (Package) this.f27191e.invoke(classLoader, new Object[]{str, str2, str3, str4, str5, str6, str7, url});
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
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Direct direct = (Direct) obj;
                    return this.f27187a.equals(direct.f27187a) && this.f27188b.equals(direct.f27188b) && this.f27189c.equals(direct.f27189c) && this.f27190d.equals(direct.f27190d) && this.f27191e.equals(direct.f27191e);
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.f27187a.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.f27189c;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.f27190d.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.f27187a.hashCode()) * 31) + this.f27188b.hashCode()) * 31) + this.f27189c.hashCode()) * 31) + this.f27190d.hashCode()) * 31) + this.f27191e.hashCode();
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingReflection.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e11) {
                            return new Unavailable(e11.getTargetException().getMessage());
                        } catch (Exception e12) {
                            return new Unavailable(e12.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Initializable {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Unavailable implements Dispatcher, Initializable {
                    private final String message;

                    public Unavailable(String str) {
                        this.message = str;
                    }

                    public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                        throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                    }

                    public Package definePackage(ClassLoader classLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
                        throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                    }

                    public Class<?> findClass(ClassLoader classLoader, String str) {
                        try {
                            return classLoader.loadClass(str);
                        } catch (ClassNotFoundException unused) {
                            return Dispatcher.UNDEFINED;
                        }
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }

                    public Package getDefinedPackage(ClassLoader classLoader, String str) {
                        throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                    }

                    public Package getPackage(ClassLoader classLoader, String str) {
                        throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.message.hashCode();
                    }

                    public Dispatcher initialize() {
                        return this;
                    }

                    public boolean isAvailable() {
                        return false;
                    }
                }

                Dispatcher initialize();

                boolean isAvailable();
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher {
                private final String message;

                public Unavailable(String str) {
                    this.message = str;
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                }

                public Package definePackage(ClassLoader classLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
                    throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return classLoader.loadClass(str);
                    } catch (ClassNotFoundException unused) {
                        return Dispatcher.UNDEFINED;
                    }
                }

                public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                    return classLoader;
                }

                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.message.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class UsingUnsafeInjection implements Dispatcher, Initializable {
                private final Object accessor;
                private final Method defineClass;
                private final Method definePackage;
                private final Method findLoadedClass;
                private final Method getClassLoadingLock;
                private final Method getDefinedPackage;
                private final Method getPackage;

                public UsingUnsafeInjection(Object obj, Method method, Method method2, Method method3, Method method4, Method method5, Method method6) {
                    this.accessor = obj;
                    this.findLoadedClass = method;
                    this.defineClass = method2;
                    this.getDefinedPackage = method3;
                    this.getPackage = method4;
                    this.definePackage = method5;
                    this.getClassLoadingLock = method6;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x019b  */
                /* JADX WARNING: Removed duplicated region for block: B:29:0x0262  */
                /* JADX WARNING: Removed duplicated region for block: B:30:0x026f  */
                @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Privilege is explicit caller responsibility", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public static net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable a() throws java.lang.Exception {
                    /*
                        java.lang.String r0 = "getClassLoadingLock"
                        java.lang.String r1 = "net.bytebuddy.safe"
                        boolean r1 = java.lang.Boolean.getBoolean(r1)
                        if (r1 == 0) goto L_0x0012
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Initializable$Unavailable r0 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Initializable$Unavailable
                        java.lang.String r1 = "Use of Unsafe was disabled by system property"
                        r0.<init>(r1)
                        return r0
                    L_0x0012:
                        java.lang.String r1 = "sun.misc.Unsafe"
                        java.lang.Class r1 = java.lang.Class.forName(r1)
                        java.lang.String r2 = "theUnsafe"
                        java.lang.reflect.Field r2 = r1.getDeclaredField(r2)
                        r3 = 1
                        r2.setAccessible(r3)
                        r4 = 0
                        java.lang.Object r2 = r2.get(r4)
                        boolean r5 = net.bytebuddy.utility.JavaModule.isSupported()
                        java.lang.String r6 = "getDefinedPackage"
                        java.lang.Class<java.lang.ClassLoader> r7 = java.lang.ClassLoader.class
                        java.lang.Class<java.lang.String> r8 = java.lang.String.class
                        r9 = 0
                        if (r5 == 0) goto L_0x003d
                        java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x003d }
                        r5[r9] = r8     // Catch:{ NoSuchMethodException -> 0x003d }
                        java.lang.reflect.Method r5 = r7.getDeclaredMethod(r6, r5)     // Catch:{ NoSuchMethodException -> 0x003d }
                        goto L_0x003e
                    L_0x003d:
                        r5 = r4
                    L_0x003e:
                        net.bytebuddy.ByteBuddy r10 = new net.bytebuddy.ByteBuddy
                        r10.<init>()
                        net.bytebuddy.dynamic.scaffold.TypeValidation r11 = net.bytebuddy.dynamic.scaffold.TypeValidation.DISABLED
                        net.bytebuddy.ByteBuddy r10 = r10.with((net.bytebuddy.dynamic.scaffold.TypeValidation) r11)
                        net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy$Default r11 = net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.NO_CONSTRUCTORS
                        java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
                        net.bytebuddy.dynamic.DynamicType$Builder r10 = r10.subclass(r12, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) r11)
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder
                        r11.<init>()
                        java.lang.String r13 = r7.getName()
                        r11.append(r13)
                        java.lang.String r13 = "$ByteBuddyAccessor$"
                        r11.append(r13)
                        java.lang.String r13 = net.bytebuddy.utility.RandomString.make()
                        r11.append(r13)
                        java.lang.String r11 = r11.toString()
                        net.bytebuddy.dynamic.DynamicType$Builder r10 = r10.name(r11)
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r11 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r3]
                        net.bytebuddy.description.modifier.Visibility r13 = net.bytebuddy.description.modifier.Visibility.PUBLIC
                        r11[r9] = r13
                        java.lang.String r14 = "findLoadedClass"
                        java.lang.Class<java.lang.Class> r15 = java.lang.Class.class
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r10 = r10.defineMethod((java.lang.String) r14, (java.lang.reflect.Type) r15, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r11)
                        r11 = 2
                        java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r11]
                        r4[r9] = r7
                        r4[r3] = r8
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r4 = r10.withParameters((java.lang.reflect.Type[]) r4)
                        java.lang.Class[] r10 = new java.lang.Class[r3]
                        r10[r9] = r8
                        java.lang.String r11 = "findLoadedClass"
                        java.lang.reflect.Method r10 = r7.getDeclaredMethod(r11, r10)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r10 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r10)
                        net.bytebuddy.implementation.MethodCall r10 = r10.onArgument(r9)
                        int[] r11 = new int[r3]
                        r11[r9] = r3
                        net.bytebuddy.implementation.MethodCall r10 = r10.withArgument(r11)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r4 = r4.intercept(r10)
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r10 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r3]
                        r10[r9] = r13
                        java.lang.String r11 = "defineClass"
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r4 = r4.defineMethod((java.lang.String) r11, (java.lang.reflect.Type) r15, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r10)
                        r10 = 6
                        r17 = r11
                        java.lang.reflect.Type[] r11 = new java.lang.reflect.Type[r10]
                        r11[r9] = r7
                        r11[r3] = r8
                        java.lang.Class<byte[]> r18 = byte[].class
                        r16 = 2
                        r11[r16] = r18
                        java.lang.Class r19 = java.lang.Integer.TYPE
                        r20 = 3
                        r11[r20] = r19
                        r21 = 4
                        r11[r21] = r19
                        r10 = 5
                        java.lang.Class<java.security.ProtectionDomain> r23 = java.security.ProtectionDomain.class
                        r11[r10] = r23
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r4 = r4.withParameters((java.lang.reflect.Type[]) r11)
                        java.lang.Class[] r11 = new java.lang.Class[r10]
                        r11[r9] = r8
                        r11[r3] = r18
                        r16 = 2
                        r11[r16] = r19
                        r11[r20] = r19
                        r11[r21] = r23
                        java.lang.String r3 = "defineClass"
                        java.lang.reflect.Method r3 = r7.getDeclaredMethod(r3, r11)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r3 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r3)
                        net.bytebuddy.implementation.MethodCall r3 = r3.onArgument(r9)
                        int[] r11 = new int[r10]
                        r11 = {1, 2, 3, 4, 5} // fill-array
                        net.bytebuddy.implementation.MethodCall r3 = r3.withArgument(r11)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r4.intercept(r3)
                        r4 = 1
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r11 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r4]
                        r11[r9] = r13
                        java.lang.String r10 = "getPackage"
                        java.lang.Class<java.lang.Package> r4 = java.lang.Package.class
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r3 = r3.defineMethod((java.lang.String) r10, (java.lang.reflect.Type) r4, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r11)
                        r10 = 2
                        java.lang.reflect.Type[] r11 = new java.lang.reflect.Type[r10]
                        r11[r9] = r7
                        r10 = 1
                        r11[r10] = r8
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r3 = r3.withParameters((java.lang.reflect.Type[]) r11)
                        java.lang.Class[] r11 = new java.lang.Class[r10]
                        r11[r9] = r8
                        java.lang.String r10 = "getPackage"
                        java.lang.reflect.Method r10 = r7.getDeclaredMethod(r10, r11)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r10 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r10)
                        net.bytebuddy.implementation.MethodCall r10 = r10.onArgument(r9)
                        r25 = r14
                        r11 = 1
                        int[] r14 = new int[r11]
                        r14[r9] = r11
                        net.bytebuddy.implementation.MethodCall r10 = r10.withArgument(r14)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r3.intercept(r10)
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r10 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r11]
                        r10[r9] = r13
                        java.lang.String r14 = "definePackage"
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r3 = r3.defineMethod((java.lang.String) r14, (java.lang.reflect.Type) r4, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r10)
                        r10 = 9
                        java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r10]
                        r10[r9] = r7
                        r10[r11] = r8
                        r11 = 2
                        r10[r11] = r8
                        r10[r20] = r8
                        r10[r21] = r8
                        r11 = 5
                        r10[r11] = r8
                        r11 = 6
                        r10[r11] = r8
                        r11 = 7
                        r10[r11] = r8
                        r14 = 8
                        java.lang.Class<java.net.URL> r26 = java.net.URL.class
                        r10[r14] = r26
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r3 = r3.withParameters((java.lang.reflect.Type[]) r10)
                        java.lang.Class[] r10 = new java.lang.Class[r14]
                        r10[r9] = r8
                        r19 = 1
                        r10[r19] = r8
                        r16 = 2
                        r10[r16] = r8
                        r10[r20] = r8
                        r10[r21] = r8
                        r24 = 5
                        r10[r24] = r8
                        r22 = 6
                        r10[r22] = r8
                        r10[r11] = r26
                        java.lang.String r11 = "definePackage"
                        java.lang.reflect.Method r10 = r7.getDeclaredMethod(r11, r10)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r10 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r10)
                        net.bytebuddy.implementation.MethodCall r10 = r10.onArgument(r9)
                        int[] r11 = new int[r14]
                        r11 = {1, 2, 3, 4, 5, 6, 7, 8} // fill-array
                        net.bytebuddy.implementation.MethodCall r10 = r10.withArgument(r11)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r3.intercept(r10)
                        r10 = 1
                        if (r5 == 0) goto L_0x01c2
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r11 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r10]
                        r11[r9] = r13
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r3 = r3.defineMethod((java.lang.String) r6, (java.lang.reflect.Type) r4, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r11)
                        r4 = 2
                        java.lang.reflect.Type[] r11 = new java.lang.reflect.Type[r4]
                        r11[r9] = r7
                        r11[r10] = r8
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r3 = r3.withParameters((java.lang.reflect.Type[]) r11)
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r4 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r5)
                        net.bytebuddy.implementation.MethodCall r4 = r4.onArgument(r9)
                        int[] r11 = new int[r10]
                        r11[r9] = r10
                        net.bytebuddy.implementation.MethodCall r4 = r4.withArgument(r11)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r3.intercept(r4)
                    L_0x01c2:
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r4 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r10]     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        r4[r9] = r13     // Catch:{ NoSuchMethodException -> 0x01f3 }
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r4 = r3.defineMethod((java.lang.String) r0, (java.lang.reflect.Type) r12, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r4)     // Catch:{ NoSuchMethodException -> 0x01f3 }
                        r10 = 2
                        java.lang.reflect.Type[] r11 = new java.lang.reflect.Type[r10]     // Catch:{ NoSuchMethodException -> 0x01f3 }
                        r11[r9] = r7     // Catch:{ NoSuchMethodException -> 0x01f3 }
                        r10 = 1
                        r11[r10] = r8     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r4 = r4.withParameters((java.lang.reflect.Type[]) r11)     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        r11[r9] = r8     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        java.lang.reflect.Method r11 = r7.getDeclaredMethod(r0, r11)     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r11 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r11)     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        net.bytebuddy.implementation.MethodCall r11 = r11.onArgument(r9)     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        int[] r13 = new int[r10]     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        r13[r9] = r10     // Catch:{ NoSuchMethodException -> 0x01f5 }
                        net.bytebuddy.implementation.MethodCall r10 = r11.withArgument(r13)     // Catch:{ NoSuchMethodException -> 0x01f3 }
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r4.intercept(r10)     // Catch:{ NoSuchMethodException -> 0x01f3 }
                        goto L_0x0213
                    L_0x01f3:
                        r4 = 1
                        goto L_0x01f6
                    L_0x01f5:
                        r4 = r10
                    L_0x01f6:
                        net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r10 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r4]
                        net.bytebuddy.description.modifier.Visibility r11 = net.bytebuddy.description.modifier.Visibility.PUBLIC
                        r10[r9] = r11
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r3 = r3.defineMethod((java.lang.String) r0, (java.lang.reflect.Type) r12, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r10)
                        r10 = 2
                        java.lang.reflect.Type[] r11 = new java.lang.reflect.Type[r10]
                        r11[r9] = r7
                        r11[r4] = r8
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r3 = r3.withParameters((java.lang.reflect.Type[]) r11)
                        net.bytebuddy.implementation.FixedValue$AssignerConfigurable r4 = net.bytebuddy.implementation.FixedValue.argument(r9)
                        net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r3 = r3.intercept(r4)
                    L_0x0213:
                        net.bytebuddy.dynamic.DynamicType$Unloaded r3 = r3.make()
                        java.lang.ClassLoader r4 = net.bytebuddy.dynamic.loading.ClassLoadingStrategy.BOOTSTRAP_LOADER
                        net.bytebuddy.dynamic.loading.ClassLoadingStrategy$ForUnsafeInjection r10 = new net.bytebuddy.dynamic.loading.ClassLoadingStrategy$ForUnsafeInjection
                        r10.<init>()
                        net.bytebuddy.dynamic.DynamicType$Loaded r3 = r3.load(r4, r10)
                        java.lang.Class r3 = r3.getLoaded()
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$UsingUnsafeInjection r4 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$UsingUnsafeInjection
                        r10 = 1
                        java.lang.Class[] r11 = new java.lang.Class[r10]
                        r11[r9] = r15
                        java.lang.String r12 = "allocateInstance"
                        java.lang.reflect.Method r1 = r1.getMethod(r12, r11)
                        java.lang.Object[] r11 = new java.lang.Object[r10]
                        r11[r9] = r3
                        java.lang.Object r28 = r1.invoke(r2, r11)
                        r1 = 2
                        java.lang.Class[] r2 = new java.lang.Class[r1]
                        r2[r9] = r7
                        r2[r10] = r8
                        r11 = r25
                        java.lang.reflect.Method r29 = r3.getMethod(r11, r2)
                        r2 = 6
                        java.lang.Class[] r11 = new java.lang.Class[r2]
                        r11[r9] = r7
                        r11[r10] = r8
                        r11[r1] = r18
                        java.lang.Class r2 = java.lang.Integer.TYPE
                        r11[r20] = r2
                        r11[r21] = r2
                        r2 = 5
                        r11[r2] = r23
                        r2 = r17
                        java.lang.reflect.Method r30 = r3.getMethod(r2, r11)
                        if (r5 == 0) goto L_0x026f
                        java.lang.Class[] r2 = new java.lang.Class[r1]
                        r2[r9] = r7
                        r2[r10] = r8
                        java.lang.reflect.Method r2 = r3.getMethod(r6, r2)
                        r31 = r2
                        goto L_0x0271
                    L_0x026f:
                        r31 = 0
                    L_0x0271:
                        java.lang.Class[] r2 = new java.lang.Class[r1]
                        r2[r9] = r7
                        r2[r10] = r8
                        java.lang.String r5 = "getPackage"
                        java.lang.reflect.Method r32 = r3.getMethod(r5, r2)
                        r2 = 9
                        java.lang.Class[] r2 = new java.lang.Class[r2]
                        r2[r9] = r7
                        r2[r10] = r8
                        r2[r1] = r8
                        r2[r20] = r8
                        r2[r21] = r8
                        r5 = 5
                        r2[r5] = r8
                        r5 = 6
                        r2[r5] = r8
                        r5 = 7
                        r2[r5] = r8
                        r2[r14] = r26
                        java.lang.String r5 = "definePackage"
                        java.lang.reflect.Method r33 = r3.getMethod(r5, r2)
                        java.lang.Class[] r1 = new java.lang.Class[r1]
                        r1[r9] = r7
                        r2 = 1
                        r1[r2] = r8
                        java.lang.reflect.Method r34 = r3.getMethod(r0, r1)
                        r27 = r4
                        r27.<init>(r28, r29, r30, r31, r32, r33, r34)
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.UsingUnsafeInjection.a():net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Initializable");
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.accessor, new Object[]{classLoader, str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package definePackage(ClassLoader classLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
                    try {
                        return (Package) this.definePackage.invoke(this.accessor, new Object[]{classLoader, str, str2, str3, str4, str5, str6, str7, url});
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
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    UsingUnsafeInjection usingUnsafeInjection = (UsingUnsafeInjection) obj;
                    return this.accessor.equals(usingUnsafeInjection.accessor) && this.findLoadedClass.equals(usingUnsafeInjection.findLoadedClass) && this.defineClass.equals(usingUnsafeInjection.defineClass) && this.getDefinedPackage.equals(usingUnsafeInjection.getDefinedPackage) && this.getPackage.equals(usingUnsafeInjection.getPackage) && this.definePackage.equals(usingUnsafeInjection.definePackage) && this.getClassLoadingLock.equals(usingUnsafeInjection.getClassLoadingLock);
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.findLoadedClass.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                    try {
                        return this.getClassLoadingLock.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.getDefinedPackage;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.getPackage.invoke(this.accessor, new Object[]{classLoader, str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.accessor.hashCode()) * 31) + this.findLoadedClass.hashCode()) * 31) + this.defineClass.hashCode()) * 31) + this.getDefinedPackage.hashCode()) * 31) + this.getPackage.hashCode()) * 31) + this.definePackage.hashCode()) * 31) + this.getClassLoadingLock.hashCode();
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingReflection.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e11) {
                            return new Unavailable(e11.getTargetException().getMessage());
                        } catch (Exception e12) {
                            return new Unavailable(e12.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public static abstract class UsingUnsafeOverride implements Dispatcher, Initializable {

                /* renamed from: a  reason: collision with root package name */
                public final Method f27192a;

                /* renamed from: b  reason: collision with root package name */
                public final Method f27193b;

                /* renamed from: c  reason: collision with root package name */
                public final Method f27194c;

                /* renamed from: d  reason: collision with root package name */
                public final Method f27195d;

                /* renamed from: e  reason: collision with root package name */
                public final Method f27196e;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava7CapableVm extends UsingUnsafeOverride {
                    private final Method getClassLoadingLock;

                    public ForJava7CapableVm(Method method, Method method2, Method method3, Method method4, Method method5, Method method6) {
                        super(method, method2, method3, method4, method5);
                        this.getClassLoadingLock = method6;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, new Object[]{str});
                        } catch (IllegalAccessException e11) {
                            throw new IllegalStateException(e11);
                        } catch (InvocationTargetException e12) {
                            throw new IllegalStateException(e12.getTargetException());
                        }
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.getClassLoadingLock.hashCode();
                    }
                }

                public static class ForLegacyVm extends UsingUnsafeOverride {
                    public ForLegacyVm(Method method, Method method2, Method method3, Method method4, Method method5) {
                        super(method, method2, method3, method4, method5);
                    }

                    public Object getClassLoadingLock(ClassLoader classLoader, String str) {
                        return classLoader;
                    }
                }

                public UsingUnsafeOverride(Method method, Method method2, Method method3, Method method4, Method method5) {
                    this.f27192a = method;
                    this.f27193b = method2;
                    this.f27194c = method3;
                    this.f27195d = method4;
                    this.f27196e = method5;
                }

                @SuppressFBWarnings(justification = "Privilege is explicit caller responsibility", value = {"DP_DO_INSIDE_DO_PRIVILEGED"})
                public static Initializable a() throws Exception {
                    Field field;
                    Class<AccessibleObject> cls = AccessibleObject.class;
                    if (Boolean.getBoolean(UsingUnsafe.SAFE_PROPERTY)) {
                        return new Initializable.Unavailable("Use of Unsafe was disabled by system property");
                    }
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    Method method = null;
                    Object obj = declaredField.get((Object) null);
                    try {
                        field = cls.getDeclaredField("override");
                    } catch (NoSuchFieldException unused) {
                        DynamicType.Builder<AccessibleObject> redefine = new ByteBuddy().redefine(cls);
                        field = redefine.name("net.bytebuddy.mirror." + cls.getSimpleName()).noNestMate().visit(new MemberRemoval().stripInvokables(ElementMatchers.any())).make().load(cls.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded().getDeclaredField("override");
                    }
                    long longValue = ((Long) cls2.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(obj, new Object[]{field})).longValue();
                    Method method2 = cls2.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
                    Class<ClassLoader> cls3 = ClassLoader.class;
                    Class<String> cls4 = String.class;
                    if (JavaModule.isSupported()) {
                        try {
                            method = cls3.getMethod("getDefinedPackage", new Class[]{cls4});
                        } catch (NoSuchMethodException unused2) {
                        }
                    }
                    Method declaredMethod = cls3.getDeclaredMethod("getPackage", new Class[]{cls4});
                    Boolean bool = Boolean.TRUE;
                    method2.invoke(obj, new Object[]{declaredMethod, Long.valueOf(longValue), bool});
                    Method declaredMethod2 = cls3.getDeclaredMethod("findLoadedClass", new Class[]{cls4});
                    Class cls5 = Integer.TYPE;
                    Method declaredMethod3 = cls3.getDeclaredMethod("defineClass", new Class[]{cls4, byte[].class, cls5, cls5, ProtectionDomain.class});
                    Method declaredMethod4 = cls3.getDeclaredMethod("definePackage", new Class[]{cls4, cls4, cls4, cls4, cls4, cls4, cls4, URL.class});
                    method2.invoke(obj, new Object[]{declaredMethod3, Long.valueOf(longValue), bool});
                    method2.invoke(obj, new Object[]{declaredMethod2, Long.valueOf(longValue), bool});
                    method2.invoke(obj, new Object[]{declaredMethod4, Long.valueOf(longValue), bool});
                    try {
                        Method declaredMethod5 = cls3.getDeclaredMethod("getClassLoadingLock", new Class[]{cls4});
                        method2.invoke(obj, new Object[]{declaredMethod5, Long.valueOf(longValue), bool});
                        return new ForJava7CapableVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4, declaredMethod5);
                    } catch (NoSuchMethodException unused3) {
                        return new ForLegacyVm(declaredMethod2, declaredMethod3, method, declaredMethod, declaredMethod4);
                    }
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.f27193b.invoke(classLoader, new Object[]{str, bArr, 0, Integer.valueOf(bArr.length), protectionDomain});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package definePackage(ClassLoader classLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) {
                    try {
                        return (Package) this.f27196e.invoke(classLoader, new Object[]{str, str2, str3, str4, str5, str6, str7, url});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Class<?> findClass(ClassLoader classLoader, String str) {
                    try {
                        return (Class) this.f27192a.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package getDefinedPackage(ClassLoader classLoader, String str) {
                    Method method = this.f27194c;
                    if (method == null) {
                        return getPackage(classLoader, str);
                    }
                    try {
                        return (Package) method.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Package getPackage(ClassLoader classLoader, String str) {
                    try {
                        return (Package) this.f27195d.invoke(classLoader, new Object[]{str});
                    } catch (IllegalAccessException e11) {
                        throw new IllegalStateException(e11);
                    } catch (InvocationTargetException e12) {
                        throw new IllegalStateException(e12.getTargetException());
                    }
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingReflection.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingReflection.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e11) {
                            return new Unavailable(e11.getTargetException().getMessage());
                        } catch (Exception e12) {
                            return new Unavailable(e12.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain);

            Package definePackage(ClassLoader classLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url);

            Class<?> findClass(ClassLoader classLoader, String str);

            Object getClassLoadingLock(ClassLoader classLoader, String str);

            Package getDefinedPackage(ClassLoader classLoader, String str);

            Package getPackage(ClassLoader classLoader, String str);
        }

        @JavaDispatcher.Proxied("java.lang.System")
        public interface System {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("getSecurityManager")
            @JavaDispatcher.Defaults
            Object getSecurityManager();
        }

        static {
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
        }

        public UsingReflection(ClassLoader classLoader2) {
            this(classLoader2, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofSystemClassLoader() {
            return new UsingReflection(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
            if (r2 != null) goto L_0x0038;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L_0x0004
                return r0
            L_0x0004:
                r1 = 0
                if (r5 != 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L_0x0013
                return r1
            L_0x0013:
                boolean r2 = r4.forbidExisting
                net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection) r5
                boolean r3 = r5.forbidExisting
                if (r2 == r3) goto L_0x001c
                return r1
            L_0x001c:
                java.lang.ClassLoader r2 = r4.classLoader
                java.lang.ClassLoader r3 = r5.classLoader
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0027
                return r1
            L_0x0027:
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r3 = r5.protectionDomain
                if (r3 == 0) goto L_0x0036
                if (r2 == 0) goto L_0x0038
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0039
                return r1
            L_0x0036:
                if (r2 == 0) goto L_0x0039
            L_0x0038:
                return r1
            L_0x0039:
                net.bytebuddy.dynamic.loading.PackageDefinitionStrategy r2 = r4.packageDefinitionStrategy
                net.bytebuddy.dynamic.loading.PackageDefinitionStrategy r5 = r5.packageDefinitionStrategy
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0044
                return r1
            L_0x0044:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = ((getClass().hashCode() * 31) + this.classLoader.hashCode()) * 31;
            ProtectionDomain protectionDomain2 = this.protectionDomain;
            if (protectionDomain2 != null) {
                hashCode += protectionDomain2.hashCode();
            }
            return (((hashCode * 31) + this.packageDefinitionStrategy.hashCode()) * 31) + (this.forbidExisting ? 1 : 0);
        }

        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map) {
            Iterator<Map.Entry<? extends String, byte[]>> it;
            HashMap hashMap;
            PackageDefinitionStrategy.Definition definition;
            String str;
            Dispatcher initialize = DISPATCHER.initialize();
            HashMap hashMap2 = new HashMap();
            Iterator<Map.Entry<? extends String, byte[]>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                synchronized (initialize.getClassLoadingLock(this.classLoader, (String) next.getKey())) {
                    Class<?> findClass = initialize.findClass(this.classLoader, (String) next.getKey());
                    if (findClass == null) {
                        int lastIndexOf = ((String) next.getKey()).lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            String substring = ((String) next.getKey()).substring(0, lastIndexOf);
                            PackageDefinitionStrategy.Definition define = this.packageDefinitionStrategy.define(this.classLoader, substring, (String) next.getKey());
                            if (define.isDefined()) {
                                Package definedPackage = initialize.getDefinedPackage(this.classLoader, substring);
                                if (definedPackage == null) {
                                    try {
                                        it = it2;
                                        definition = define;
                                        hashMap = hashMap2;
                                        str = substring;
                                        try {
                                            initialize.definePackage(this.classLoader, substring, define.getSpecificationTitle(), define.getSpecificationVersion(), define.getSpecificationVendor(), define.getImplementationTitle(), define.getImplementationVersion(), define.getImplementationVendor(), define.getSealBase());
                                        } catch (IllegalStateException e11) {
                                            e = e11;
                                        }
                                    } catch (IllegalStateException e12) {
                                        e = e12;
                                        hashMap = hashMap2;
                                        it = it2;
                                        definition = define;
                                        str = substring;
                                        Package packageR = initialize.getPackage(this.classLoader, str);
                                        if (packageR == null) {
                                            throw e;
                                        } else if (definition.isCompatibleTo(packageR)) {
                                            findClass = initialize.defineClass(this.classLoader, (String) next.getKey(), (byte[]) next.getValue(), this.protectionDomain);
                                            HashMap hashMap3 = hashMap;
                                            hashMap3.put(next.getKey(), findClass);
                                            it2 = it;
                                            hashMap2 = hashMap3;
                                        } else {
                                            throw new SecurityException("Sealing violation for package " + str + " (getPackage fallback)");
                                        }
                                    }
                                } else {
                                    hashMap = hashMap2;
                                    it = it2;
                                    String str2 = substring;
                                    if (!define.isCompatibleTo(definedPackage)) {
                                        throw new SecurityException("Sealing violation for package " + str2);
                                    }
                                }
                                findClass = initialize.defineClass(this.classLoader, (String) next.getKey(), (byte[]) next.getValue(), this.protectionDomain);
                            }
                        }
                        hashMap = hashMap2;
                        it = it2;
                        findClass = initialize.defineClass(this.classLoader, (String) next.getKey(), (byte[]) next.getValue(), this.protectionDomain);
                    } else {
                        hashMap = hashMap2;
                        it = it2;
                        if (this.forbidExisting) {
                            throw new IllegalStateException("Cannot inject already loaded type: " + findClass);
                        }
                    }
                    HashMap hashMap32 = hashMap;
                    hashMap32.put(next.getKey(), findClass);
                }
                it2 = it;
                hashMap2 = hashMap32;
            }
            return hashMap2;
        }

        public boolean isAlive() {
            return isAvailable();
        }

        public UsingReflection(ClassLoader classLoader2, ProtectionDomain protectionDomain2) {
            this(classLoader2, protectionDomain2, PackageDefinitionStrategy.Trivial.INSTANCE, false);
        }

        public UsingReflection(ClassLoader classLoader2, ProtectionDomain protectionDomain2, PackageDefinitionStrategy packageDefinitionStrategy2, boolean z11) {
            if (classLoader2 != null) {
                this.classLoader = classLoader2;
                this.protectionDomain = protectionDomain2;
                this.packageDefinitionStrategy = packageDefinitionStrategy2;
                this.forbidExisting = z11;
                return;
            }
            throw new IllegalArgumentException("Cannot inject classes into the bootstrap class loader");
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class UsingUnsafe extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object BOOTSTRAP_LOADER_LOCK = new Object();
        /* access modifiers changed from: private */
        public static final Method CHECK_PERMISSION = ((Method) doPrivileged(new GetMethodAction("java.lang.SecurityManager", "checkPermission", Permission.class)));
        /* access modifiers changed from: private */
        public static final Dispatcher.Initializable DISPATCHER = ((Dispatcher.Initializable) doPrivileged(Dispatcher.CreationAction.INSTANCE));
        public static final String SAFE_PROPERTY = "net.bytebuddy.safe";
        /* access modifiers changed from: private */
        public static final System SYSTEM = ((System) doPrivileged(JavaDispatcher.of(System.class)));
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;
        private final Dispatcher.Initializable dispatcher;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;

        public interface Dispatcher {

            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
                /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
                /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                    r13 = new net.bytebuddy.ByteBuddy().redefine(r8);
                    r4 = r13.name("net.bytebuddy.mirror." + r8.getSimpleName()).noNestMate().visit(new net.bytebuddy.asm.MemberRemoval().stripInvokables(net.bytebuddy.matcher.ElementMatchers.any())).make().load(r8.getClassLoader(), net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Default.WRAPPER).getLoaded().getDeclaredField("override");
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
                    throw r0;
                 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x005e */
                /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0125 */
                @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable run() {
                    /*
                        r19 = this;
                        java.lang.Class<java.security.ProtectionDomain> r1 = java.security.ProtectionDomain.class
                        java.lang.Class<java.lang.ClassLoader> r2 = java.lang.ClassLoader.class
                        java.lang.Class<byte[]> r3 = byte[].class
                        java.lang.String r4 = "override"
                        java.lang.Class<java.lang.String> r5 = java.lang.String.class
                        java.lang.String r6 = "defineClass"
                        java.lang.String r7 = "theUnsafe"
                        java.lang.Class<java.lang.reflect.AccessibleObject> r8 = java.lang.reflect.AccessibleObject.class
                        java.lang.String r0 = "net.bytebuddy.safe"
                        boolean r0 = java.lang.Boolean.getBoolean(r0)
                        if (r0 == 0) goto L_0x0020
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable r0 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable
                        java.lang.String r1 = "Use of Unsafe was disabled by system property"
                        r0.<init>(r1)
                        return r0
                    L_0x0020:
                        java.lang.String r0 = "sun.misc.Unsafe"
                        java.lang.Class r9 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0126 }
                        java.lang.reflect.Field r0 = r9.getDeclaredField(r7)     // Catch:{ Exception -> 0x0126 }
                        r10 = 1
                        r0.setAccessible(r10)     // Catch:{ Exception -> 0x0126 }
                        r11 = 0
                        java.lang.Object r12 = r0.get(r11)     // Catch:{ Exception -> 0x0126 }
                        r13 = 5
                        r14 = 4
                        r15 = 6
                        r11 = 3
                        r16 = 2
                        r17 = 0
                        java.lang.Class[] r0 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0058 }
                        r0[r17] = r5     // Catch:{ Exception -> 0x0058 }
                        r0[r10] = r3     // Catch:{ Exception -> 0x0058 }
                        java.lang.Class r18 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0058 }
                        r0[r16] = r18     // Catch:{ Exception -> 0x0058 }
                        r0[r11] = r18     // Catch:{ Exception -> 0x0058 }
                        r0[r14] = r2     // Catch:{ Exception -> 0x0058 }
                        r0[r13] = r1     // Catch:{ Exception -> 0x0058 }
                        java.lang.reflect.Method r0 = r9.getMethod(r6, r0)     // Catch:{ Exception -> 0x0058 }
                        r0.setAccessible(r10)     // Catch:{ Exception -> 0x0058 }
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled r13 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled     // Catch:{ Exception -> 0x0058 }
                        r13.<init>(r12, r0)     // Catch:{ Exception -> 0x0058 }
                        return r13
                    L_0x0058:
                        r0 = move-exception
                        java.lang.reflect.Field r4 = r8.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x005e }
                        goto L_0x00ab
                    L_0x005e:
                        net.bytebuddy.ByteBuddy r13 = new net.bytebuddy.ByteBuddy     // Catch:{ Exception -> 0x0125 }
                        r13.<init>()     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.DynamicType$Builder r13 = r13.redefine(r8)     // Catch:{ Exception -> 0x0125 }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0125 }
                        r14.<init>()     // Catch:{ Exception -> 0x0125 }
                        java.lang.String r15 = "net.bytebuddy.mirror."
                        r14.append(r15)     // Catch:{ Exception -> 0x0125 }
                        java.lang.String r15 = r8.getSimpleName()     // Catch:{ Exception -> 0x0125 }
                        r14.append(r15)     // Catch:{ Exception -> 0x0125 }
                        java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.DynamicType$Builder r13 = r13.name(r14)     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.DynamicType$Builder r13 = r13.noNestMate()     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.asm.MemberRemoval r14 = new net.bytebuddy.asm.MemberRemoval     // Catch:{ Exception -> 0x0125 }
                        r14.<init>()     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.matcher.ElementMatcher$Junction r15 = net.bytebuddy.matcher.ElementMatchers.any()     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.asm.MemberRemoval r14 = r14.stripInvokables(r15)     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.DynamicType$Builder r13 = r13.visit(r14)     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.DynamicType$Unloaded r13 = r13.make()     // Catch:{ Exception -> 0x0125 }
                        java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default r14 = net.bytebuddy.dynamic.loading.ClassLoadingStrategy.Default.WRAPPER     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.DynamicType$Loaded r8 = r13.load(r8, r14)     // Catch:{ Exception -> 0x0125 }
                        java.lang.Class r8 = r8.getLoaded()     // Catch:{ Exception -> 0x0125 }
                        java.lang.reflect.Field r4 = r8.getDeclaredField(r4)     // Catch:{ Exception -> 0x0125 }
                    L_0x00ab:
                        java.lang.String r8 = "objectFieldOffset"
                        java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0125 }
                        java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
                        r13[r17] = r14     // Catch:{ Exception -> 0x0125 }
                        java.lang.reflect.Method r8 = r9.getMethod(r8, r13)     // Catch:{ Exception -> 0x0125 }
                        java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0125 }
                        r13[r17] = r4     // Catch:{ Exception -> 0x0125 }
                        java.lang.Object r4 = r8.invoke(r12, r13)     // Catch:{ Exception -> 0x0125 }
                        java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0125 }
                        long r13 = r4.longValue()     // Catch:{ Exception -> 0x0125 }
                        java.lang.String r4 = "putBoolean"
                        java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x0125 }
                        java.lang.Class<java.lang.Object> r15 = java.lang.Object.class
                        r8[r17] = r15     // Catch:{ Exception -> 0x0125 }
                        java.lang.Class r15 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x0125 }
                        r8[r10] = r15     // Catch:{ Exception -> 0x0125 }
                        java.lang.Class r15 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x0125 }
                        r8[r16] = r15     // Catch:{ Exception -> 0x0125 }
                        java.lang.reflect.Method r4 = r9.getMethod(r4, r8)     // Catch:{ Exception -> 0x0125 }
                        java.lang.String r8 = "jdk.internal.misc.Unsafe"
                        java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x0125 }
                        java.lang.reflect.Field r7 = r8.getDeclaredField(r7)     // Catch:{ Exception -> 0x0125 }
                        java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0125 }
                        r9[r17] = r7     // Catch:{ Exception -> 0x0125 }
                        java.lang.Long r15 = java.lang.Long.valueOf(r13)     // Catch:{ Exception -> 0x0125 }
                        r9[r10] = r15     // Catch:{ Exception -> 0x0125 }
                        java.lang.Boolean r15 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0125 }
                        r9[r16] = r15     // Catch:{ Exception -> 0x0125 }
                        r4.invoke(r12, r9)     // Catch:{ Exception -> 0x0125 }
                        r9 = 6
                        java.lang.Class[] r9 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x0125 }
                        r9[r17] = r5     // Catch:{ Exception -> 0x0125 }
                        r9[r10] = r3     // Catch:{ Exception -> 0x0125 }
                        java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0125 }
                        r9[r16] = r3     // Catch:{ Exception -> 0x0125 }
                        r9[r11] = r3     // Catch:{ Exception -> 0x0125 }
                        r3 = 4
                        r9[r3] = r2     // Catch:{ Exception -> 0x0125 }
                        r2 = 5
                        r9[r2] = r1     // Catch:{ Exception -> 0x0125 }
                        java.lang.reflect.Method r1 = r8.getMethod(r6, r9)     // Catch:{ Exception -> 0x0125 }
                        java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0125 }
                        r2[r17] = r1     // Catch:{ Exception -> 0x0125 }
                        java.lang.Long r3 = java.lang.Long.valueOf(r13)     // Catch:{ Exception -> 0x0125 }
                        r2[r10] = r3     // Catch:{ Exception -> 0x0125 }
                        r2[r16] = r15     // Catch:{ Exception -> 0x0125 }
                        r4.invoke(r12, r2)     // Catch:{ Exception -> 0x0125 }
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled r2 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Enabled     // Catch:{ Exception -> 0x0125 }
                        r3 = 0
                        java.lang.Object r3 = r7.get(r3)     // Catch:{ Exception -> 0x0125 }
                        r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0125 }
                        return r2
                    L_0x0125:
                        throw r0     // Catch:{ Exception -> 0x0126 }
                    L_0x0126:
                        r0 = move-exception
                        net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable r1 = new net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Unavailable
                        java.lang.String r0 = r0.getMessage()
                        r1.<init>(r0)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.CreationAction.run():net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements Dispatcher, Initializable {
                private final Method defineClass;
                private final Object unsafe;

                public Enabled(Object obj, Method method) {
                    this.unsafe = obj;
                    this.defineClass = method;
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.unsafe, new Object[]{str, bArr, 0, Integer.valueOf(bArr.length), classLoader, protectionDomain});
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
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Enabled enabled = (Enabled) obj;
                    return this.unsafe.equals(enabled.unsafe) && this.defineClass.equals(enabled.defineClass);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.unsafe.hashCode()) * 31) + this.defineClass.hashCode();
                }

                public Dispatcher initialize() {
                    Object securityManager = UsingUnsafe.SYSTEM.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            UsingUnsafe.CHECK_PERMISSION.invoke(securityManager, new Object[]{ClassInjector.SUPPRESS_ACCESS_CHECKS});
                        } catch (InvocationTargetException e11) {
                            return new Unavailable(e11.getTargetException().getMessage());
                        } catch (Exception e12) {
                            return new Unavailable(e12.getMessage());
                        }
                    }
                    return this;
                }

                public boolean isAvailable() {
                    return true;
                }
            }

            public interface Initializable {
                Dispatcher initialize();

                boolean isAvailable();
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Unavailable implements Dispatcher, Initializable {
                private final String message;

                public Unavailable(String str) {
                    this.message = str;
                }

                public Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.message.hashCode();
                }

                public Dispatcher initialize() {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }

                public boolean isAvailable() {
                    return false;
                }
            }

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory {
            private final Dispatcher.Initializable dispatcher;

            public interface AccessResolver {

                public enum Default implements AccessResolver {
                    INSTANCE;

                    public void apply(AccessibleObject accessibleObject) {
                        accessibleObject.setAccessible(true);
                    }
                }

                void apply(AccessibleObject accessibleObject);
            }

            public Factory() {
                this((AccessResolver) AccessResolver.Default.INSTANCE);
            }

            public static Factory resolve(Instrumentation instrumentation) {
                return resolve(instrumentation, false);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((Factory) obj).dispatcher);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.dispatcher.hashCode();
            }

            public boolean isAvailable() {
                return this.dispatcher.isAvailable();
            }

            public ClassInjector make(ClassLoader classLoader) {
                return make(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
            }

            @SuppressFBWarnings(justification = "Exception is captured to trigger lazy error upon use.", value = {"REC_CATCH_EXCEPTION"})
            public Factory(AccessResolver accessResolver) {
                Dispatcher.Initializable initializable;
                if (UsingUnsafe.DISPATCHER.isAvailable()) {
                    initializable = UsingUnsafe.DISPATCHER;
                } else {
                    try {
                        Class<?> cls = Class.forName("jdk.internal.misc.Unsafe");
                        Field declaredField = cls.getDeclaredField("theUnsafe");
                        accessResolver.apply(declaredField);
                        Object obj = declaredField.get((Object) null);
                        Class cls2 = Integer.TYPE;
                        Method method = cls.getMethod("defineClass", new Class[]{String.class, byte[].class, cls2, cls2, ClassLoader.class, ProtectionDomain.class});
                        accessResolver.apply(method);
                        initializable = new Dispatcher.Enabled(obj, method);
                    } catch (Exception e11) {
                        initializable = new Dispatcher.Unavailable(e11.getMessage());
                    }
                }
                this.dispatcher = initializable;
            }

            @SuppressFBWarnings(justification = "Exception intends to trigger disabled injection strategy.", value = {"REC_CATCH_EXCEPTION"})
            public static Factory resolve(Instrumentation instrumentation, boolean z11) {
                Class<AccessResolver> cls = AccessResolver.class;
                if (UsingUnsafe.isAvailable() || !JavaModule.isSupported()) {
                    return new Factory();
                }
                try {
                    Class<?> cls2 = Class.forName("jdk.internal.misc.Unsafe");
                    PackageDescription.ForLoadedPackage forLoadedPackage = new PackageDescription.ForLoadedPackage(cls2.getPackage());
                    JavaModule ofType = JavaModule.ofType(cls2);
                    if (ofType.isOpened(forLoadedPackage, JavaModule.ofType(UsingUnsafe.class))) {
                        return new Factory();
                    }
                    if (z11) {
                        JavaModule ofType2 = JavaModule.ofType(AccessResolver.Default.class);
                        UsingInstrumentation.redefineModule(instrumentation, ofType, Collections.singleton(ofType2), Collections.emptyMap(), Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(ofType2)), Collections.emptySet(), Collections.emptyMap());
                        return new Factory();
                    }
                    Class<? extends T> loaded = new ByteBuddy().subclass(cls).method(ElementMatchers.named("apply")).intercept(MethodCall.invoke(AccessibleObject.class.getMethod("setAccessible", new Class[]{Boolean.TYPE})).onArgument(0).with(Boolean.TRUE)).make().load(cls.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(cls.getProtectionDomain())).getLoaded();
                    JavaModule ofType3 = JavaModule.ofType(loaded);
                    UsingInstrumentation.redefineModule(instrumentation, ofType, Collections.singleton(ofType3), Collections.emptyMap(), Collections.singletonMap(forLoadedPackage.getName(), Collections.singleton(ofType3)), Collections.emptySet(), Collections.emptyMap());
                    return new Factory((AccessResolver) loaded.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e11) {
                    return new Factory((Dispatcher.Initializable) new Dispatcher.Unavailable(e11.getMessage()));
                }
            }

            public ClassInjector make(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                return new UsingUnsafe(classLoader, protectionDomain, this.dispatcher);
            }

            public Factory(Dispatcher.Initializable initializable) {
                this.dispatcher = initializable;
            }
        }

        @JavaDispatcher.Proxied("java.lang.System")
        public interface System {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("getSecurityManager")
            @JavaDispatcher.Defaults
            Object getSecurityManager();
        }

        static {
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
        }

        public UsingUnsafe(ClassLoader classLoader2) {
            this(classLoader2, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofBootLoader() {
            return new UsingUnsafe(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r2 != null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
            if (r2 != null) goto L_0x0038;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L_0x0004
                return r0
            L_0x0004:
                r1 = 0
                if (r5 != 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.Class r2 = r4.getClass()
                java.lang.Class r3 = r5.getClass()
                if (r2 == r3) goto L_0x0013
                return r1
            L_0x0013:
                java.lang.ClassLoader r2 = r4.classLoader
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe r5 = (net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe) r5
                java.lang.ClassLoader r3 = r5.classLoader
                if (r3 == 0) goto L_0x0024
                if (r2 == 0) goto L_0x0026
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0027
                return r1
            L_0x0024:
                if (r2 == 0) goto L_0x0027
            L_0x0026:
                return r1
            L_0x0027:
                java.security.ProtectionDomain r2 = r4.protectionDomain
                java.security.ProtectionDomain r3 = r5.protectionDomain
                if (r3 == 0) goto L_0x0036
                if (r2 == 0) goto L_0x0038
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0039
                return r1
            L_0x0036:
                if (r2 == 0) goto L_0x0039
            L_0x0038:
                return r1
            L_0x0039:
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r2 = r4.dispatcher
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r5 = r5.dispatcher
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L_0x0044
                return r1
            L_0x0044:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            ClassLoader classLoader2 = this.classLoader;
            if (classLoader2 != null) {
                hashCode += classLoader2.hashCode();
            }
            int i11 = hashCode * 31;
            ProtectionDomain protectionDomain2 = this.protectionDomain;
            if (protectionDomain2 != null) {
                i11 += protectionDomain2.hashCode();
            }
            return (i11 * 31) + this.dispatcher.hashCode();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|11|12|21|18|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x001a, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r9) {
            /*
                r8 = this;
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r0 = r8.dispatcher
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher r0 = r0.initialize()
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                java.lang.ClassLoader r2 = r8.classLoader
                if (r2 != 0) goto L_0x0011
                java.lang.Object r2 = BOOTSTRAP_LOADER_LOCK
            L_0x0011:
                monitor-enter(r2)
                java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0059 }
                java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0059 }
            L_0x001a:
                boolean r3 = r9.hasNext()     // Catch:{ all -> 0x0059 }
                if (r3 == 0) goto L_0x0057
                java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x0059 }
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0059 }
                java.lang.Object r4 = r3.getKey()     // Catch:{ ClassNotFoundException -> 0x003b }
                java.lang.Object r5 = r3.getKey()     // Catch:{ ClassNotFoundException -> 0x003b }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ ClassNotFoundException -> 0x003b }
                java.lang.ClassLoader r6 = r8.classLoader     // Catch:{ ClassNotFoundException -> 0x003b }
                r7 = 0
                java.lang.Class r5 = java.lang.Class.forName(r5, r7, r6)     // Catch:{ ClassNotFoundException -> 0x003b }
                r1.put(r4, r5)     // Catch:{ ClassNotFoundException -> 0x003b }
                goto L_0x001a
            L_0x003b:
                java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0059 }
                java.lang.ClassLoader r5 = r8.classLoader     // Catch:{ all -> 0x0059 }
                java.lang.Object r6 = r3.getKey()     // Catch:{ all -> 0x0059 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0059 }
                java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0059 }
                byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0059 }
                java.security.ProtectionDomain r7 = r8.protectionDomain     // Catch:{ all -> 0x0059 }
                java.lang.Class r3 = r0.defineClass(r5, r6, r3, r7)     // Catch:{ all -> 0x0059 }
                r1.put(r4, r3)     // Catch:{ all -> 0x0059 }
                goto L_0x001a
            L_0x0057:
                monitor-exit(r2)     // Catch:{ all -> 0x0059 }
                return r1
            L_0x0059:
                r9 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0059 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.injectRaw(java.util.Map):java.util.Map");
        }

        public boolean isAlive() {
            return this.dispatcher.isAvailable();
        }

        public UsingUnsafe(ClassLoader classLoader2, ProtectionDomain protectionDomain2) {
            this(classLoader2, protectionDomain2, DISPATCHER);
        }

        public UsingUnsafe(ClassLoader classLoader2, ProtectionDomain protectionDomain2, Dispatcher.Initializable initializable) {
            this.classLoader = classLoader2;
            this.protectionDomain = protectionDomain2;
            this.dispatcher = initializable;
        }
    }

    Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> map);

    Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map);

    boolean isAlive();
}
