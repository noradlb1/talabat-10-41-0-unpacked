package net.bytebuddy.dynamic.loading;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

@HashCodeAndEqualsPlugin.Enhance
public class ClassReloadingStrategy implements ClassLoadingStrategy<ClassLoader> {
    private static final boolean ACCESS_CONTROLLER;
    private static final String INSTALLER_TYPE = "net.bytebuddy.agent.Installer";
    private static final String INSTRUMENTATION_GETTER = "getInstrumentation";
    private static final Object STATIC_MEMBER = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Dispatcher f27197b = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
    private final BootstrapInjection bootstrapInjection;
    private final Instrumentation instrumentation;
    private final Map<String, Class<?>> preregisteredTypes;
    private final Strategy strategy;

    public interface BootstrapInjection {

        public enum Disabled implements BootstrapInjection {
            INSTANCE;

            public ClassInjector make(Instrumentation instrumentation) {
                throw new IllegalStateException("Bootstrap injection is not enabled");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Enabled implements BootstrapInjection {
            private final File folder;

            public Enabled(File file) {
                this.folder = file;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.folder.equals(((Enabled) obj).folder);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.folder.hashCode();
            }

            public ClassInjector make(Instrumentation instrumentation) {
                return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, instrumentation);
            }
        }

        ClassInjector make(Instrumentation instrumentation);
    }

    @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
    public interface Dispatcher {
        @JavaDispatcher.Proxied("addTransformer")
        void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z11);

        @JavaDispatcher.Proxied("isModifiableClass")
        boolean isModifiableClass(Instrumentation instrumentation, Class<?> cls);

        @JavaDispatcher.Proxied("isRetransformClassesSupported")
        boolean isRetransformClassesSupported(Instrumentation instrumentation);

        @JavaDispatcher.Proxied("retransformClasses")
        void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr) throws UnmodifiableClassException;
    }

    public enum Strategy {
        REDEFINITION(true) {
            public void b(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) throws UnmodifiableClassException, ClassNotFoundException {
                instrumentation.redefineClasses((ClassDefinition[]) map.values().toArray(new ClassDefinition[0]));
            }

            public Strategy c(Instrumentation instrumentation) {
                if (instrumentation.isRedefineClassesSupported()) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support redefinition: " + instrumentation);
            }

            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) throws IOException, UnmodifiableClassException, ClassNotFoundException {
                HashMap hashMap = new HashMap(list.size());
                for (Class next : list) {
                    hashMap.put(next, new ClassDefinition(next, classFileLocator.locate(TypeDescription.ForLoadedType.getName(next)).resolve()));
                }
                b(instrumentation, hashMap);
            }
        },
        RETRANSFORMATION(false) {
            public void b(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) throws UnmodifiableClassException {
                ClassRedefinitionTransformer classRedefinitionTransformer = new ClassRedefinitionTransformer(map);
                synchronized (this) {
                    Dispatcher dispatcher = ClassReloadingStrategy.f27197b;
                    dispatcher.addTransformer(instrumentation, classRedefinitionTransformer, true);
                    try {
                        dispatcher.retransformClasses(instrumentation, (Class[]) map.keySet().toArray(new Class[0]));
                    } finally {
                        instrumentation.removeTransformer(classRedefinitionTransformer);
                    }
                }
                classRedefinitionTransformer.assertTransformation();
            }

            public Strategy c(Instrumentation instrumentation) {
                if (ClassReloadingStrategy.f27197b.isRetransformClassesSupported(instrumentation)) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support retransformation: " + instrumentation);
            }

            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) throws UnmodifiableClassException, ClassNotFoundException {
                for (Class next : list) {
                    if (!ClassReloadingStrategy.f27197b.isModifiableClass(instrumentation, next)) {
                        throw new IllegalArgumentException("Cannot modify type: " + next);
                    }
                }
                Dispatcher dispatcher = ClassReloadingStrategy.f27197b;
                ClassResettingTransformer classResettingTransformer = ClassResettingTransformer.INSTANCE;
                dispatcher.addTransformer(instrumentation, classResettingTransformer, true);
                try {
                    dispatcher.retransformClasses(instrumentation, (Class[]) list.toArray(new Class[0]));
                    instrumentation.removeTransformer(classResettingTransformer);
                } catch (Throwable th2) {
                    instrumentation.removeTransformer(ClassResettingTransformer.INSTANCE);
                    throw th2;
                }
            }
        };
        
        /* access modifiers changed from: private */
        public static final byte[] NO_REDEFINITION = null;
        private static final boolean REDEFINE_CLASSES = true;
        private final boolean redefinition;

        public static class ClassRedefinitionTransformer implements ClassFileTransformer {
            private final Map<Class<?>, ClassDefinition> redefinedClasses;

            public ClassRedefinitionTransformer(Map<Class<?>, ClassDefinition> map) {
                this.redefinedClasses = map;
            }

            public void assertTransformation() {
                if (!this.redefinedClasses.isEmpty()) {
                    throw new IllegalStateException("Could not transform: " + this.redefinedClasses.keySet());
                }
            }

            @SuppressFBWarnings(justification = "Value is always null", value = {"EI_EXPOSE_REP"})
            public byte[] transform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                if (str == null) {
                    return Strategy.NO_REDEFINITION;
                }
                ClassDefinition remove = this.redefinedClasses.remove(cls);
                if (remove == null) {
                    return Strategy.NO_REDEFINITION;
                }
                return remove.getDefinitionClassFile();
            }
        }

        public enum ClassResettingTransformer implements ClassFileTransformer {
            INSTANCE;

            public byte[] transform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
                return Strategy.NO_REDEFINITION;
            }
        }

        /* access modifiers changed from: public */
        static {
            NO_REDEFINITION = null;
        }

        public abstract void b(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) throws UnmodifiableClassException, ClassNotFoundException;

        public abstract Strategy c(Instrumentation instrumentation);

        public boolean isRedefinition() {
            return this.redefinition;
        }

        public abstract void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) throws IOException, UnmodifiableClassException, ClassNotFoundException;

        private Strategy(boolean z11) {
            this.redefinition = z11;
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

    public ClassReloadingStrategy(Instrumentation instrumentation2, Strategy strategy2) {
        this(instrumentation2, strategy2, BootstrapInjection.Disabled.INSTANCE, Collections.emptyMap());
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        if (ACCESS_CONTROLLER) {
            return AccessController.doPrivileged(privilegedAction);
        }
        return privilegedAction.run();
    }

    public static ClassReloadingStrategy fromInstalledAgent() {
        try {
            return of((Instrumentation) ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE).getMethod(INSTRUMENTATION_GETTER, new Class[0]).invoke(STATIC_MEMBER, new Object[0]));
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e12);
        }
    }

    public static ClassReloadingStrategy of(Instrumentation instrumentation2) {
        if (f27197b.isRetransformClassesSupported(instrumentation2)) {
            return new ClassReloadingStrategy(instrumentation2, Strategy.RETRANSFORMATION);
        }
        if (instrumentation2.isRedefineClassesSupported()) {
            return new ClassReloadingStrategy(instrumentation2, Strategy.REDEFINITION);
        }
        throw new IllegalArgumentException("Instrumentation does not support reloading of classes: " + instrumentation2);
    }

    public ClassReloadingStrategy enableBootstrapInjection(File file) {
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, new BootstrapInjection.Enabled(file), this.preregisteredTypes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassReloadingStrategy classReloadingStrategy = (ClassReloadingStrategy) obj;
        return this.strategy.equals(classReloadingStrategy.strategy) && this.instrumentation.equals(classReloadingStrategy.instrumentation) && this.bootstrapInjection.equals(classReloadingStrategy.bootstrapInjection) && this.preregisteredTypes.equals(classReloadingStrategy.preregisteredTypes);
    }

    public int hashCode() {
        return (((((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.strategy.hashCode()) * 31) + this.bootstrapInjection.hashCode()) * 31) + this.preregisteredTypes.hashCode();
    }

    public Map<TypeDescription, Class<?>> load(ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
        ClassInjector classInjector;
        HashMap hashMap = new HashMap(this.preregisteredTypes);
        for (Class cls : this.instrumentation.getInitiatedClasses(classLoader)) {
            hashMap.put(TypeDescription.ForLoadedType.getName(cls), cls);
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        HashMap hashMap2 = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            Class cls2 = (Class) hashMap.get(((TypeDescription) next.getKey()).getName());
            if (cls2 != null) {
                concurrentHashMap.put(cls2, new ClassDefinition(cls2, (byte[]) next.getValue()));
                hashMap2.put(next.getKey(), cls2);
            } else {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        try {
            this.strategy.b(this.instrumentation, concurrentHashMap);
            if (!linkedHashMap.isEmpty()) {
                if (classLoader == null) {
                    classInjector = this.bootstrapInjection.make(this.instrumentation);
                } else {
                    classInjector = new ClassInjector.UsingReflection(classLoader);
                }
                hashMap2.putAll(classInjector.inject(linkedHashMap));
            }
            return hashMap2;
        } catch (ClassNotFoundException e11) {
            throw new IllegalArgumentException("Could not locate classes for redefinition", e11);
        } catch (UnmodifiableClassException e12) {
            throw new IllegalStateException("Cannot redefine specified class", e12);
        }
    }

    public ClassReloadingStrategy preregistered(Class<?>... clsArr) {
        HashMap hashMap = new HashMap(this.preregisteredTypes);
        for (Class<?> cls : clsArr) {
            hashMap.put(TypeDescription.ForLoadedType.getName(cls), cls);
        }
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, this.bootstrapInjection, hashMap);
    }

    public ClassReloadingStrategy reset(Class<?>... clsArr) throws IOException {
        if (clsArr.length == 0) {
            return this;
        }
        return reset(ClassFileLocator.ForClassLoader.of(clsArr[0].getClassLoader()), clsArr);
    }

    public ClassReloadingStrategy reset(ClassFileLocator classFileLocator, Class<?>... clsArr) throws IOException {
        if (clsArr.length > 0) {
            try {
                this.strategy.reset(this.instrumentation, classFileLocator, Arrays.asList(clsArr));
            } catch (ClassNotFoundException e11) {
                throw new IllegalArgumentException("Cannot locate types " + Arrays.toString(clsArr), e11);
            } catch (UnmodifiableClassException e12) {
                throw new IllegalStateException("Cannot reset types " + Arrays.toString(clsArr), e12);
            }
        }
        return this;
    }

    public ClassReloadingStrategy(Instrumentation instrumentation2, Strategy strategy2, BootstrapInjection bootstrapInjection2, Map<String, Class<?>> map) {
        this.instrumentation = instrumentation2;
        this.strategy = strategy2.c(instrumentation2);
        this.bootstrapInjection = bootstrapInjection2;
        this.preregisteredTypes = map;
    }

    public static ClassReloadingStrategy fromInstalledAgent(Strategy strategy2) {
        try {
            return new ClassReloadingStrategy((Instrumentation) ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE).getMethod(INSTRUMENTATION_GETTER, new Class[0]).invoke(STATIC_MEMBER, new Object[0]), strategy2);
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e12);
        }
    }
}
