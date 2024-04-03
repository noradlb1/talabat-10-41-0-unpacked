package net.bytebuddy.agent.builder;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import datamodels.TypesAliasesKt;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import j$.util.Iterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.io.File;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.EntryPoint;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.NexusAccessor;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.ExceptionMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

public interface AgentBuilder {

    public interface CircularityLock {

        public static class Default extends ThreadLocal<Boolean> implements CircularityLock {
            private static final Boolean NOT_ACQUIRED = null;

            public boolean acquire() {
                if (get() != NOT_ACQUIRED) {
                    return false;
                }
                set(Boolean.TRUE);
                return true;
            }

            public void release() {
                set(NOT_ACQUIRED);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Global implements CircularityLock {
            private final Lock lock;
            private final long time;
            private final TimeUnit timeUnit;

            public Global() {
                this(0, TimeUnit.MILLISECONDS);
            }

            public boolean acquire() {
                try {
                    long j11 = this.time;
                    if (j11 == 0) {
                        return this.lock.tryLock();
                    }
                    return this.lock.tryLock(j11, this.timeUnit);
                } catch (InterruptedException unused) {
                    return false;
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Global global = (Global) obj;
                return this.time == global.time && this.timeUnit.equals(global.timeUnit) && this.lock.equals(global.lock);
            }

            public int hashCode() {
                long j11 = this.time;
                return (((((getClass().hashCode() * 31) + this.lock.hashCode()) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.timeUnit.hashCode();
            }

            public void release() {
                this.lock.unlock();
            }

            public Global(long j11, TimeUnit timeUnit2) {
                this.lock = new ReentrantLock();
                this.time = j11;
                this.timeUnit = timeUnit2;
            }
        }

        public enum Inactive implements CircularityLock {
            INSTANCE;

            public boolean acquire() {
                return true;
            }

            public void release() {
            }
        }

        boolean acquire();

        void release();
    }

    public interface ClassFileBufferStrategy {

        public enum Default implements ClassFileBufferStrategy {
            RETAINING {
                public ClassFileLocator resolve(String str, byte[] bArr, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return ClassFileLocator.Simple.of(str, bArr);
                }

                public TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator, ClassLoader classLoader, String str) {
                    return poolStrategy.typePool(classFileLocator, classLoader, str);
                }
            },
            DISCARDING {
                public ClassFileLocator resolve(String str, byte[] bArr, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return ClassFileLocator.NoOp.INSTANCE;
                }

                public TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator, ClassLoader classLoader, String str) {
                    return poolStrategy.typePool(classFileLocator, classLoader);
                }
            }
        }

        ClassFileLocator resolve(String str, byte[] bArr, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain);

        TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator, ClassLoader classLoader, String str);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements AgentBuilder {
        private static final boolean ACCESS_CONTROLLER;
        private static final CircularityLock DEFAULT_LOCK = new CircularityLock.Default();
        /* access modifiers changed from: private */
        public static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private static final String INSTALLER_TYPE = "net.bytebuddy.agent.Installer";
        private static final String INSTRUMENTATION_GETTER = "getInstrumentation";
        /* access modifiers changed from: private */
        public static final Class<?> NO_LOADED_TYPE = null;
        /* access modifiers changed from: private */
        public static final byte[] NO_TRANSFORMATION = null;
        private static final Object STATIC_MEMBER = null;

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuddy f26934a;

        /* renamed from: b  reason: collision with root package name */
        public final Listener f26935b;

        /* renamed from: c  reason: collision with root package name */
        public final CircularityLock f26936c;

        /* renamed from: d  reason: collision with root package name */
        public final PoolStrategy f26937d;

        /* renamed from: e  reason: collision with root package name */
        public final TypeStrategy f26938e;

        /* renamed from: f  reason: collision with root package name */
        public final LocationStrategy f26939f;

        /* renamed from: g  reason: collision with root package name */
        public final NativeMethodStrategy f26940g;

        /* renamed from: h  reason: collision with root package name */
        public final WarmupStrategy f26941h;

        /* renamed from: i  reason: collision with root package name */
        public final TransformerDecorator f26942i;

        /* renamed from: j  reason: collision with root package name */
        public final InitializationStrategy f26943j;

        /* renamed from: k  reason: collision with root package name */
        public final RedefinitionStrategy f26944k;

        /* renamed from: l  reason: collision with root package name */
        public final RedefinitionStrategy.DiscoveryStrategy f26945l;

        /* renamed from: m  reason: collision with root package name */
        public final RedefinitionStrategy.BatchAllocator f26946m;

        /* renamed from: n  reason: collision with root package name */
        public final RedefinitionStrategy.Listener f26947n;

        /* renamed from: o  reason: collision with root package name */
        public final RedefinitionStrategy.ResubmissionStrategy f26948o;

        /* renamed from: p  reason: collision with root package name */
        public final InjectionStrategy f26949p;

        /* renamed from: q  reason: collision with root package name */
        public final LambdaInstrumentationStrategy f26950q;

        /* renamed from: r  reason: collision with root package name */
        public final DescriptionStrategy f26951r;

        /* renamed from: s  reason: collision with root package name */
        public final FallbackStrategy f26952s;

        /* renamed from: t  reason: collision with root package name */
        public final ClassFileBufferStrategy f26953t;

        /* renamed from: u  reason: collision with root package name */
        public final InstallationListener f26954u;

        /* renamed from: v  reason: collision with root package name */
        public final RawMatcher f26955v;

        /* renamed from: w  reason: collision with root package name */
        public final List<Transformation> f26956w;

        public static abstract class Delegator implements AgentBuilder {

            public static abstract class Matchable<S extends Matchable<S>> extends Delegator implements Matchable<S> {
                public S and(ElementMatcher<? super TypeDescription> elementMatcher) {
                    return and(elementMatcher, ElementMatchers.any());
                }

                public S or(ElementMatcher<? super TypeDescription> elementMatcher) {
                    return or(elementMatcher, ElementMatchers.any());
                }

                public S and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return and(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public S or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return or(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public S and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    return and((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }

                public S or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    return or((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }
            }

            public abstract AgentBuilder a();

            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr) {
                return a().assureReadEdgeFromAndTo(instrumentation, clsArr);
            }

            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr) {
                return a().assureReadEdgeTo(instrumentation, clsArr);
            }

            public AgentBuilder disableClassFormatChanges() {
                return a().disableClassFormatChanges();
            }

            public AgentBuilder disableNativeMethodPrefix() {
                return a().disableNativeMethodPrefix();
            }

            public AgentBuilder enableNativeMethodPrefix(String str) {
                return a().enableNativeMethodPrefix(str);
            }

            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
                return a().ignore(elementMatcher);
            }

            public ResettableClassFileTransformer installOn(Instrumentation instrumentation) {
                return a().installOn(instrumentation);
            }

            public ResettableClassFileTransformer installOnByteBuddyAgent() {
                return a().installOnByteBuddyAgent();
            }

            public ClassFileTransformer makeRaw() {
                return a().makeRaw();
            }

            public ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                return a().patchOn(instrumentation, resettableClassFileTransformer);
            }

            public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer) {
                return a().patchOnByteBuddyAgent(resettableClassFileTransformer);
            }

            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher) {
                return a().type(elementMatcher);
            }

            public AgentBuilder warmUp(Class<?>... clsArr) {
                return a().warmUp(clsArr);
            }

            public AgentBuilder with(ByteBuddy byteBuddy) {
                return a().with(byteBuddy);
            }

            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
                return a().assureReadEdgeFromAndTo(instrumentation, javaModuleArr);
            }

            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
                return a().assureReadEdgeTo(instrumentation, javaModuleArr);
            }

            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                return a().ignore(elementMatcher, elementMatcher2);
            }

            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                return a().type(elementMatcher, elementMatcher2);
            }

            public AgentBuilder warmUp(Collection<Class<?>> collection) {
                return a().warmUp(collection);
            }

            public AgentBuilder with(Listener listener) {
                return a().with(listener);
            }

            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
                return a().assureReadEdgeFromAndTo(instrumentation, collection);
            }

            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
                return a().assureReadEdgeTo(instrumentation, collection);
            }

            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                return a().ignore(elementMatcher, elementMatcher2, elementMatcher3);
            }

            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                return a().type(elementMatcher, elementMatcher2, elementMatcher3);
            }

            public AgentBuilder with(CircularityLock circularityLock) {
                return a().with(circularityLock);
            }

            public Ignored ignore(RawMatcher rawMatcher) {
                return a().ignore(rawMatcher);
            }

            public Identified.Narrowable type(RawMatcher rawMatcher) {
                return a().type(rawMatcher);
            }

            public AgentBuilder with(TypeStrategy typeStrategy) {
                return a().with(typeStrategy);
            }

            public AgentBuilder with(PoolStrategy poolStrategy) {
                return a().with(poolStrategy);
            }

            public AgentBuilder with(LocationStrategy locationStrategy) {
                return a().with(locationStrategy);
            }

            public AgentBuilder with(InitializationStrategy initializationStrategy) {
                return a().with(initializationStrategy);
            }

            public RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy) {
                return a().with(redefinitionStrategy);
            }

            public AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy) {
                return a().with(lambdaInstrumentationStrategy);
            }

            public AgentBuilder with(DescriptionStrategy descriptionStrategy) {
                return a().with(descriptionStrategy);
            }

            public AgentBuilder with(FallbackStrategy fallbackStrategy) {
                return a().with(fallbackStrategy);
            }

            public AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy) {
                return a().with(classFileBufferStrategy);
            }

            public AgentBuilder with(InstallationListener installationListener) {
                return a().with(installationListener);
            }

            public AgentBuilder with(InjectionStrategy injectionStrategy) {
                return a().with(injectionStrategy);
            }

            public AgentBuilder with(TransformerDecorator transformerDecorator) {
                return a().with(transformerDecorator);
            }
        }

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("addTransformer")
            void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z11);

            @JavaDispatcher.Proxied("isNativeMethodPrefixSupported")
            @JavaDispatcher.Defaults
            boolean isNativeMethodPrefixSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("setNativeMethodPrefix")
            void setNativeMethodPrefix(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, String str);
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Ignoring extends Delegator.Matchable<Ignored> implements Ignored {
            private final RawMatcher rawMatcher;

            public Ignoring(RawMatcher rawMatcher2) {
                this.rawMatcher = rawMatcher2;
            }

            public AgentBuilder a() {
                Default defaultR = Default.this;
                ByteBuddy byteBuddy = defaultR.f26934a;
                Default defaultR2 = defaultR;
                return new Default(byteBuddy, defaultR.f26935b, defaultR.f26936c, defaultR.f26937d, defaultR.f26938e, defaultR.f26939f, defaultR.f26940g, defaultR.f26941h, defaultR.f26942i, defaultR.f26943j, defaultR.f26944k, defaultR.f26945l, defaultR.f26946m, defaultR.f26947n, defaultR2.f26948o, defaultR2.f26949p, defaultR2.f26950q, defaultR2.f26951r, defaultR2.f26952s, defaultR2.f26953t, defaultR2.f26954u, this.rawMatcher, defaultR2.f26956w);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Ignoring ignoring = (Ignoring) obj;
                return this.rawMatcher.equals(ignoring.rawMatcher) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.rawMatcher.hashCode()) * 31) + Default.this.hashCode();
            }

            public Ignored and(RawMatcher rawMatcher2) {
                return new Ignoring(new RawMatcher.Conjunction(this.rawMatcher, rawMatcher2));
            }

            public Ignored or(RawMatcher rawMatcher2) {
                return new Ignoring(new RawMatcher.Disjunction(this.rawMatcher, rawMatcher2));
            }
        }

        public interface NativeMethodStrategy {

            public enum Disabled implements NativeMethodStrategy {
                INSTANCE;

                public void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                }

                public MethodNameTransformer resolve() {
                    return MethodNameTransformer.Suffixing.withRandomSuffix();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPrefix implements NativeMethodStrategy {
                private final String prefix;

                public ForPrefix(String str) {
                    this.prefix = str;
                }

                public static NativeMethodStrategy a(String str) {
                    if (str.length() != 0) {
                        return new ForPrefix(str);
                    }
                    throw new IllegalArgumentException("A method name prefix must not be the empty string");
                }

                public void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                    if (Default.DISPATCHER.isNativeMethodPrefixSupported(instrumentation)) {
                        Default.DISPATCHER.setNativeMethodPrefix(instrumentation, classFileTransformer, this.prefix);
                        return;
                    }
                    throw new IllegalArgumentException("A prefix for native methods is not supported: " + instrumentation);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.prefix.equals(((ForPrefix) obj).prefix);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.prefix.hashCode();
                }

                public MethodNameTransformer resolve() {
                    return new MethodNameTransformer.Prefixing(this.prefix);
                }
            }

            void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer);

            MethodNameTransformer resolve();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Transformation {
            /* access modifiers changed from: private */
            public static final byte[] NONE = null;
            private final RawMatcher matcher;
            private final boolean terminal;
            private final List<Transformer> transformers;

            @HashCodeAndEqualsPlugin.Enhance
            public static class DifferentialMatcher implements RawMatcher {
                private final ResettableClassFileTransformer classFileTransformer;
                private final RawMatcher ignoreMatcher;
                private final List<Transformation> transformations;

                public DifferentialMatcher(RawMatcher rawMatcher, List<Transformation> list, ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.ignoreMatcher = rawMatcher;
                    this.transformations = list;
                    this.classFileTransformer = resettableClassFileTransformer;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    DifferentialMatcher differentialMatcher = (DifferentialMatcher) obj;
                    return this.ignoreMatcher.equals(differentialMatcher.ignoreMatcher) && this.transformations.equals(differentialMatcher.transformations) && this.classFileTransformer.equals(differentialMatcher.classFileTransformer);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.ignoreMatcher.hashCode()) * 31) + this.transformations.hashCode()) * 31) + this.classFileTransformer.hashCode();
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean matches(net.bytebuddy.description.type.TypeDescription r10, java.lang.ClassLoader r11, net.bytebuddy.utility.JavaModule r12, java.lang.Class<?> r13, java.security.ProtectionDomain r14) {
                    /*
                        r9 = this;
                        net.bytebuddy.agent.builder.ResettableClassFileTransformer r0 = r9.classFileTransformer
                        r1 = r10
                        r2 = r11
                        r3 = r12
                        r4 = r13
                        r5 = r14
                        java.util.Iterator r0 = r0.iterator(r1, r2, r3, r4, r5)
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r1 = r9.ignoreMatcher
                        r2 = r10
                        r3 = r11
                        r4 = r12
                        r5 = r13
                        r6 = r14
                        boolean r1 = r1.matches(r2, r3, r4, r5, r6)
                        if (r1 == 0) goto L_0x001d
                        boolean r10 = r0.hasNext()
                        return r10
                    L_0x001d:
                        java.util.List<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r9.transformations
                        java.util.Iterator r1 = r1.iterator()
                    L_0x0023:
                        boolean r2 = r1.hasNext()
                        if (r2 == 0) goto L_0x0066
                        java.lang.Object r2 = r1.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation r2 = (net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation) r2
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r3 = r2.b()
                        r4 = r10
                        r5 = r11
                        r6 = r12
                        r7 = r13
                        r8 = r14
                        boolean r3 = r3.matches(r4, r5, r6, r7, r8)
                        if (r3 == 0) goto L_0x0023
                        java.util.List r2 = r2.c()
                        java.util.Iterator r2 = r2.iterator()
                    L_0x0046:
                        boolean r3 = r2.hasNext()
                        if (r3 == 0) goto L_0x0023
                        java.lang.Object r3 = r2.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Transformer r3 = (net.bytebuddy.agent.builder.AgentBuilder.Transformer) r3
                        boolean r4 = r0.hasNext()
                        if (r4 == 0) goto L_0x0064
                        java.lang.Object r4 = r0.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Transformer r4 = (net.bytebuddy.agent.builder.AgentBuilder.Transformer) r4
                        boolean r3 = r4.equals(r3)
                        if (r3 != 0) goto L_0x0046
                    L_0x0064:
                        r10 = 1
                        return r10
                    L_0x0066:
                        boolean r10 = r0.hasNext()
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation.DifferentialMatcher.matches(net.bytebuddy.description.type.TypeDescription, java.lang.ClassLoader, net.bytebuddy.utility.JavaModule, java.lang.Class, java.security.ProtectionDomain):boolean");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class SimpleMatcher implements RawMatcher {
                private final RawMatcher ignoreMatcher;
                private final List<Transformation> transformations;

                public SimpleMatcher(RawMatcher rawMatcher, List<Transformation> list) {
                    this.ignoreMatcher = rawMatcher;
                    this.transformations = list;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    SimpleMatcher simpleMatcher = (SimpleMatcher) obj;
                    return this.ignoreMatcher.equals(simpleMatcher.ignoreMatcher) && this.transformations.equals(simpleMatcher.transformations);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.ignoreMatcher.hashCode()) * 31) + this.transformations.hashCode();
                }

                public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                    if (this.ignoreMatcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return false;
                    }
                    for (Transformation b11 : this.transformations) {
                        if (b11.b().matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                            return true;
                        }
                    }
                    return false;
                }
            }

            public static class TransformerIterator implements Iterator<Transformer>, j$.util.Iterator {
                private final Class<?> classBeingRedefined;
                private final ClassLoader classLoader;
                private final JavaModule module;
                private final ProtectionDomain protectionDomain;
                private final Iterator<Transformation> transformations;
                private Iterator<Transformer> transformers = Collections.emptySet().iterator();
                private final TypeDescription typeDescription;

                public TransformerIterator(TypeDescription typeDescription2, ClassLoader classLoader2, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain2, List<Transformation> list) {
                    this.typeDescription = typeDescription2;
                    this.classLoader = classLoader2;
                    this.module = javaModule;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain2;
                    this.transformations = list.iterator();
                    while (!this.transformers.hasNext() && this.transformations.hasNext()) {
                        Transformation next = this.transformations.next();
                        if (next.b().matches(typeDescription2, classLoader2, javaModule, cls, protectionDomain2)) {
                            this.transformers = next.c().iterator();
                        }
                    }
                }

                public /* synthetic */ void forEachRemaining(Consumer consumer) {
                    Iterator.CC.$default$forEachRemaining(this, consumer);
                }

                public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                    forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                }

                public boolean hasNext() {
                    return this.transformers.hasNext();
                }

                public void remove() {
                    throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                }

                /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: 
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                    	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                    */
                public net.bytebuddy.agent.builder.AgentBuilder.Transformer next() {
                    /*
                        r8 = this;
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Transformer> r0 = r8.transformers     // Catch:{ all -> 0x0040 }
                        java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0040 }
                        net.bytebuddy.agent.builder.AgentBuilder$Transformer r0 = (net.bytebuddy.agent.builder.AgentBuilder.Transformer) r0     // Catch:{ all -> 0x0040 }
                    L_0x0008:
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Transformer> r1 = r8.transformers
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x003f
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        boolean r1 = r1.hasNext()
                        if (r1 == 0) goto L_0x003f
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        java.lang.Object r1 = r1.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation r1 = (net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation) r1
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r2 = r1.b()
                        net.bytebuddy.description.type.TypeDescription r3 = r8.typeDescription
                        java.lang.ClassLoader r4 = r8.classLoader
                        net.bytebuddy.utility.JavaModule r5 = r8.module
                        java.lang.Class<?> r6 = r8.classBeingRedefined
                        java.security.ProtectionDomain r7 = r8.protectionDomain
                        boolean r2 = r2.matches(r3, r4, r5, r6, r7)
                        if (r2 == 0) goto L_0x0008
                        java.util.List r1 = r1.c()
                        java.util.Iterator r1 = r1.iterator()
                        r8.transformers = r1
                        goto L_0x0008
                    L_0x003f:
                        return r0
                    L_0x0040:
                        r0 = move-exception
                    L_0x0041:
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Transformer> r1 = r8.transformers
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x0078
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        boolean r1 = r1.hasNext()
                        if (r1 == 0) goto L_0x0078
                        java.util.Iterator<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r1 = r8.transformations
                        java.lang.Object r1 = r1.next()
                        net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation r1 = (net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation) r1
                        net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r2 = r1.b()
                        net.bytebuddy.description.type.TypeDescription r3 = r8.typeDescription
                        java.lang.ClassLoader r4 = r8.classLoader
                        net.bytebuddy.utility.JavaModule r5 = r8.module
                        java.lang.Class<?> r6 = r8.classBeingRedefined
                        java.security.ProtectionDomain r7 = r8.protectionDomain
                        boolean r2 = r2.matches(r3, r4, r5, r6, r7)
                        if (r2 == 0) goto L_0x0041
                        java.util.List r1 = r1.c()
                        java.util.Iterator r1 = r1.iterator()
                        r8.transformers = r1
                        goto L_0x0041
                    L_0x0078:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.Transformation.TransformerIterator.next():net.bytebuddy.agent.builder.AgentBuilder$Transformer");
                }
            }

            public Transformation(RawMatcher rawMatcher, List<Transformer> list, boolean z11) {
                this.matcher = rawMatcher;
                this.transformers = list;
                this.terminal = z11;
            }

            public RawMatcher b() {
                return this.matcher;
            }

            public List<Transformer> c() {
                return this.transformers;
            }

            public boolean d() {
                return this.terminal;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Transformation transformation = (Transformation) obj;
                return this.terminal == transformation.terminal && this.matcher.equals(transformation.matcher) && this.transformers.equals(transformation.transformers);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.transformers.hashCode()) * 31) + (this.terminal ? 1 : 0);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Transforming extends Delegator.Matchable<Identified.Narrowable> implements Identified.Extendable, Identified.Narrowable {
            private final RawMatcher rawMatcher;
            private final boolean terminal;
            private final List<Transformer> transformers;

            public Transforming(RawMatcher rawMatcher2, List<Transformer> list, boolean z11) {
                this.rawMatcher = rawMatcher2;
                this.transformers = list;
                this.terminal = z11;
            }

            public AgentBuilder a() {
                Default defaultR = Default.this;
                ByteBuddy byteBuddy = defaultR.f26934a;
                Listener listener = defaultR.f26935b;
                CircularityLock circularityLock = defaultR.f26936c;
                PoolStrategy poolStrategy = defaultR.f26937d;
                ByteBuddy byteBuddy2 = byteBuddy;
                Default defaultR2 = defaultR;
                return new Default(byteBuddy2, listener, circularityLock, poolStrategy, defaultR.f26938e, defaultR.f26939f, defaultR.f26940g, defaultR.f26941h, defaultR.f26942i, defaultR.f26943j, defaultR.f26944k, defaultR.f26945l, defaultR.f26946m, defaultR.f26947n, defaultR2.f26948o, defaultR2.f26949p, defaultR2.f26950q, defaultR2.f26951r, defaultR2.f26952s, defaultR2.f26953t, defaultR2.f26954u, defaultR2.f26955v, CompoundList.of(defaultR2.f26956w, new Transformation(this.rawMatcher, this.transformers, this.terminal)));
            }

            public AgentBuilder asTerminalTransformation() {
                return new Transforming(this.rawMatcher, this.transformers, true);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Transforming transforming = (Transforming) obj;
                return this.terminal == transforming.terminal && this.rawMatcher.equals(transforming.rawMatcher) && this.transformers.equals(transforming.transformers) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.rawMatcher.hashCode()) * 31) + this.transformers.hashCode()) * 31) + (this.terminal ? 1 : 0)) * 31) + Default.this.hashCode();
            }

            public Identified.Extendable transform(Transformer transformer) {
                return new Transforming(this.rawMatcher, CompoundList.of(this.transformers, transformer), this.terminal);
            }

            public Identified.Narrowable and(RawMatcher rawMatcher2) {
                return new Transforming(new RawMatcher.Conjunction(this.rawMatcher, rawMatcher2), this.transformers, this.terminal);
            }

            public Identified.Narrowable or(RawMatcher rawMatcher2) {
                return new Transforming(new RawMatcher.Disjunction(this.rawMatcher, rawMatcher2), this.transformers, this.terminal);
            }
        }

        public interface WarmupStrategy {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements WarmupStrategy {
                private static final Dispatcher DISPATCHER = ((Dispatcher) Default.doPrivileged(JavaDispatcher.of(Dispatcher.class)));
                private final Set<Class<?>> types;

                @JavaDispatcher.Proxied("java.lang.instrument.ClassFileTransformer")
                public interface Dispatcher {
                    @JavaDispatcher.Proxied("transform")
                    byte[] transform(ClassFileTransformer classFileTransformer, @JavaDispatcher.Proxied("java.lang.Module") Object obj, ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) throws IllegalClassFormatException;
                }

                public Enabled(Set<Class<?>> set) {
                    this.types = set;
                }

                public void apply(ResettableClassFileTransformer resettableClassFileTransformer, LocationStrategy locationStrategy, RedefinitionStrategy redefinitionStrategy, CircularityLock circularityLock, InstallationListener installationListener) {
                    boolean z11;
                    boolean z12;
                    boolean z13;
                    ResettableClassFileTransformer resettableClassFileTransformer2 = resettableClassFileTransformer;
                    InstallationListener installationListener2 = installationListener;
                    installationListener2.onBeforeWarmUp(this.types, resettableClassFileTransformer2);
                    boolean z14 = false;
                    for (Class next : this.types) {
                        try {
                            JavaModule ofType = JavaModule.ofType(next);
                            byte[] resolve = locationStrategy.classFileLocator(next.getClassLoader(), ofType).locate(next.getName()).resolve();
                            circularityLock.release();
                            boolean z15 = true;
                            if (ofType == null) {
                                if (resettableClassFileTransformer.transform(next.getClassLoader(), Type.getInternalName(next), Default.NO_LOADED_TYPE, next.getProtectionDomain(), resolve) != null) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                boolean z16 = z14 | z13;
                                try {
                                    if (redefinitionStrategy.b()) {
                                        if (resettableClassFileTransformer.transform(next.getClassLoader(), Type.getInternalName(next), next, next.getProtectionDomain(), resolve) == null) {
                                            z15 = false;
                                        }
                                        z12 = z16 | z15;
                                    } else {
                                        z14 = z16;
                                        circularityLock.acquire();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    boolean z17 = z16;
                                    circularityLock.acquire();
                                    throw th;
                                }
                            } else {
                                Dispatcher dispatcher = DISPATCHER;
                                if (dispatcher.transform(resettableClassFileTransformer, ofType.unwrap(), next.getClassLoader(), Type.getInternalName(next), Default.NO_LOADED_TYPE, next.getProtectionDomain(), resolve) != null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                z14 |= z11;
                                if (redefinitionStrategy.b()) {
                                    if (dispatcher.transform(resettableClassFileTransformer, ofType.unwrap(), next.getClassLoader(), Type.getInternalName(next), next, next.getProtectionDomain(), resolve) == null) {
                                        z15 = false;
                                    }
                                    z12 = z14 | z15;
                                }
                                circularityLock.acquire();
                            }
                            z14 = z12;
                            circularityLock.acquire();
                        } catch (Throwable th3) {
                            installationListener2.onWarmUpError(next, resettableClassFileTransformer2, th3);
                        }
                    }
                    installationListener2.onAfterWarmUp(this.types, resettableClassFileTransformer2, z14);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.types.equals(((Enabled) obj).types);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.types.hashCode();
                }

                public WarmupStrategy with(Collection<Class<?>> collection) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(this.types);
                    linkedHashSet.addAll(collection);
                    return new Enabled(linkedHashSet);
                }
            }

            public enum NoOp implements WarmupStrategy {
                INSTANCE;

                public void apply(ResettableClassFileTransformer resettableClassFileTransformer, LocationStrategy locationStrategy, RedefinitionStrategy redefinitionStrategy, CircularityLock circularityLock, InstallationListener installationListener) {
                }

                public WarmupStrategy with(Collection<Class<?>> collection) {
                    return new Enabled(new LinkedHashSet(collection));
                }
            }

            void apply(ResettableClassFileTransformer resettableClassFileTransformer, LocationStrategy locationStrategy, RedefinitionStrategy redefinitionStrategy, CircularityLock circularityLock, InstallationListener installationListener);

            WarmupStrategy with(Collection<Class<?>> collection);
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

        public Default() {
            this(new ByteBuddy());
        }

        private ResettableClassFileTransformer doInstall(Instrumentation instrumentation, RawMatcher rawMatcher) {
            ResettableClassFileTransformer resettableClassFileTransformer;
            Instrumentation instrumentation2 = instrumentation;
            RedefinitionStrategy.ResubmissionStrategy.Installation apply = this.f26948o.apply(instrumentation, this.f26937d, this.f26939f, this.f26951r, this.f26952s, this.f26935b, this.f26954u, this.f26936c, new Transformation.SimpleMatcher(this.f26955v, this.f26956w), this.f26944k, this.f26946m, this.f26947n);
            ResettableClassFileTransformer decorate = this.f26942i.decorate(makeRaw(apply.b(), apply.a(), apply.c()));
            apply.a().onBeforeInstall(instrumentation2, decorate);
            try {
                this.f26941h.apply(decorate, this.f26939f, this.f26944k, this.f26936c, apply.a());
                if (this.f26944k.c()) {
                    DISPATCHER.addTransformer(instrumentation2, decorate, true);
                } else {
                    instrumentation2.addTransformer(decorate);
                }
                this.f26940g.apply(instrumentation2, decorate);
                this.f26950q.b(this.f26934a, instrumentation2, decorate);
                RedefinitionStrategy redefinitionStrategy = this.f26944k;
                PoolStrategy poolStrategy = this.f26937d;
                LocationStrategy locationStrategy = this.f26939f;
                DescriptionStrategy descriptionStrategy = this.f26951r;
                FallbackStrategy fallbackStrategy = this.f26952s;
                RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = this.f26945l;
                LambdaInstrumentationStrategy lambdaInstrumentationStrategy = this.f26950q;
                Listener b11 = apply.b();
                RedefinitionStrategy.Listener listener = this.f26947n;
                RedefinitionStrategy.BatchAllocator batchAllocator = this.f26946m;
                CircularityLock circularityLock = this.f26936c;
                resettableClassFileTransformer = decorate;
                try {
                    redefinitionStrategy.apply(instrumentation, poolStrategy, locationStrategy, descriptionStrategy, fallbackStrategy, discoveryStrategy, lambdaInstrumentationStrategy, b11, listener, rawMatcher, batchAllocator, circularityLock);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                resettableClassFileTransformer = decorate;
                Throwable onError = apply.a().onError(instrumentation2, resettableClassFileTransformer, th);
                if (onError != null) {
                    instrumentation2.removeTransformer(resettableClassFileTransformer);
                    throw new IllegalStateException("Could not install class file transformer", onError);
                }
                apply.a().onInstall(instrumentation2, resettableClassFileTransformer);
                return resettableClassFileTransformer;
            }
            apply.a().onInstall(instrumentation2, resettableClassFileTransformer);
            return resettableClassFileTransformer;
        }

        /* access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static AgentBuilder of(Plugin... pluginArr) {
            return of((List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr) {
            return JavaModule.isSupported() ? with(Listener.ModuleReadEdgeCompleting.of(instrumentation, true, clsArr)) : this;
        }

        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr) {
            return JavaModule.isSupported() ? with(Listener.ModuleReadEdgeCompleting.of(instrumentation, false, clsArr)) : this;
        }

        public AgentBuilder disableClassFormatChanges() {
            ByteBuddy with = this.f26934a.with((Implementation.Context.Factory) Implementation.Context.Disabled.Factory.INSTANCE);
            Listener listener = this.f26935b;
            CircularityLock circularityLock = this.f26936c;
            PoolStrategy poolStrategy = this.f26937d;
            TypeStrategy typeStrategy = this.f26938e;
            TypeStrategy.Default defaultR = TypeStrategy.Default.DECORATE;
            if (typeStrategy != defaultR) {
                defaultR = TypeStrategy.Default.REDEFINE_FROZEN;
            }
            return new Default(with, listener, circularityLock, poolStrategy, defaultR, this.f26939f, NativeMethodStrategy.Disabled.INSTANCE, this.f26941h, this.f26942i, InitializationStrategy.NoOp.INSTANCE, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public AgentBuilder disableNativeMethodPrefix() {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, NativeMethodStrategy.Disabled.INSTANCE, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public AgentBuilder enableNativeMethodPrefix(String str) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, NativeMethodStrategy.ForPrefix.a(str), this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.f26944k.equals(defaultR.f26944k) && this.f26950q.equals(defaultR.f26950q) && this.f26934a.equals(defaultR.f26934a) && this.f26935b.equals(defaultR.f26935b) && this.f26936c.equals(defaultR.f26936c) && this.f26937d.equals(defaultR.f26937d) && this.f26938e.equals(defaultR.f26938e) && this.f26939f.equals(defaultR.f26939f) && this.f26940g.equals(defaultR.f26940g) && this.f26941h.equals(defaultR.f26941h) && this.f26942i.equals(defaultR.f26942i) && this.f26943j.equals(defaultR.f26943j) && this.f26945l.equals(defaultR.f26945l) && this.f26946m.equals(defaultR.f26946m) && this.f26947n.equals(defaultR.f26947n) && this.f26948o.equals(defaultR.f26948o) && this.f26949p.equals(defaultR.f26949p) && this.f26951r.equals(defaultR.f26951r) && this.f26952s.equals(defaultR.f26952s) && this.f26953t.equals(defaultR.f26953t) && this.f26954u.equals(defaultR.f26954u) && this.f26955v.equals(defaultR.f26955v) && this.f26956w.equals(defaultR.f26956w);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.f26934a.hashCode()) * 31) + this.f26935b.hashCode()) * 31) + this.f26936c.hashCode()) * 31) + this.f26937d.hashCode()) * 31) + this.f26938e.hashCode()) * 31) + this.f26939f.hashCode()) * 31) + this.f26940g.hashCode()) * 31) + this.f26941h.hashCode()) * 31) + this.f26942i.hashCode()) * 31) + this.f26943j.hashCode()) * 31) + this.f26944k.hashCode()) * 31) + this.f26945l.hashCode()) * 31) + this.f26946m.hashCode()) * 31) + this.f26947n.hashCode()) * 31) + this.f26948o.hashCode()) * 31) + this.f26949p.hashCode()) * 31) + this.f26950q.hashCode()) * 31) + this.f26951r.hashCode()) * 31) + this.f26952s.hashCode()) * 31) + this.f26953t.hashCode()) * 31) + this.f26954u.hashCode()) * 31) + this.f26955v.hashCode()) * 31) + this.f26956w.hashCode();
        }

        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
            return ignore(elementMatcher, ElementMatchers.any());
        }

        public ResettableClassFileTransformer installOn(Instrumentation instrumentation) {
            if (this.f26936c.acquire()) {
                try {
                    return doInstall(instrumentation, new Transformation.SimpleMatcher(this.f26955v, this.f26956w));
                } finally {
                    this.f26936c.release();
                }
            } else {
                throw new IllegalStateException("Could not acquire the circularity lock upon installation.");
            }
        }

        public ResettableClassFileTransformer installOnByteBuddyAgent() {
            try {
                return installOn((Instrumentation) ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE).getMethod(INSTRUMENTATION_GETTER, new Class[0]).invoke(STATIC_MEMBER, new Object[0]));
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e12);
            }
        }

        public ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            if (this.f26936c.acquire()) {
                try {
                    if (resettableClassFileTransformer.reset(instrumentation, RedefinitionStrategy.DISABLED)) {
                        return doInstall(instrumentation, new Transformation.DifferentialMatcher(this.f26955v, this.f26956w, resettableClassFileTransformer));
                    }
                    throw new IllegalArgumentException("Cannot patch unregistered class file transformer: " + resettableClassFileTransformer);
                } finally {
                    this.f26936c.release();
                }
            } else {
                throw new IllegalStateException("Could not acquire the circularity lock upon installation.");
            }
        }

        public ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer) {
            try {
                return patchOn((Instrumentation) ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE).getMethod(INSTRUMENTATION_GETTER, new Class[0]).invoke(STATIC_MEMBER, new Object[0]), resettableClassFileTransformer);
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e12);
            }
        }

        public Identified.Narrowable type(RawMatcher rawMatcher) {
            return new Transforming(rawMatcher, Collections.emptyList(), false);
        }

        public AgentBuilder warmUp(Class<?>... clsArr) {
            return warmUp((Collection<Class<?>>) Arrays.asList(clsArr));
        }

        public AgentBuilder with(ByteBuddy byteBuddy) {
            return new Default(byteBuddy, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Default(net.bytebuddy.ByteBuddy r30) {
            /*
                r29 = this;
                r0 = r29
                r1 = r30
                net.bytebuddy.agent.builder.AgentBuilder$Listener$NoOp r2 = net.bytebuddy.agent.builder.AgentBuilder.Listener.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r3 = DEFAULT_LOCK
                net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy$Default r4 = net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy.Default.FAST
                net.bytebuddy.agent.builder.AgentBuilder$TypeStrategy$Default r5 = net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy.Default.REBASE
                net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy$ForClassLoader r6 = net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy.ForClassLoader.STRONG
                net.bytebuddy.agent.builder.AgentBuilder$Default$NativeMethodStrategy$Disabled r7 = net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy.Disabled.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy$NoOp r8 = net.bytebuddy.agent.builder.AgentBuilder.Default.WarmupStrategy.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$TransformerDecorator$NoOp r9 = net.bytebuddy.agent.builder.AgentBuilder.TransformerDecorator.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Split r11 = new net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Split
                r10 = r11
                r11.<init>()
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy r11 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DISABLED
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$DiscoveryStrategy$SinglePass r12 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$BatchAllocator$ForTotal r13 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Listener$NoOp r14 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Disabled r15 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$InjectionStrategy$UsingReflection r16 = net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy.UsingReflection.INSTANCE
                net.bytebuddy.agent.builder.AgentBuilder$LambdaInstrumentationStrategy r17 = net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.DISABLED
                net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy$Default r18 = net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.Default.HYBRID
                net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r19 = net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.ByThrowableType.ofOptionalTypes()
                net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy$Default r20 = net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy.Default.RETAINING
                net.bytebuddy.agent.builder.AgentBuilder$InstallationListener$NoOp r21 = net.bytebuddy.agent.builder.AgentBuilder.InstallationListener.NoOp.INSTANCE
                r24 = r0
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$Disjunction r0 = new net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$Disjunction
                r22 = r0
                r1 = 2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher[] r1 = new net.bytebuddy.agent.builder.AgentBuilder.RawMatcher[r1]
                r25 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers r2 = new net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers
                r26 = r3
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = net.bytebuddy.matcher.ElementMatchers.any()
                r27 = r4
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.isBootstrapClassLoader()
                r28 = r5
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.isExtensionClassLoader()
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = r4.or(r5)
                r2.<init>(r3, r4)
                r3 = 0
                r1[r3] = r2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers r2 = new net.bytebuddy.agent.builder.AgentBuilder$RawMatcher$ForElementMatchers
                java.lang.String r3 = "net.bytebuddy."
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r3)
                java.lang.String r4 = "net.bytebuddy.renamed."
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r4)
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.not(r4)
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = r3.and(r4)
                java.lang.String r4 = "sun.reflect."
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r4)
                java.lang.String r5 = "jdk.internal.reflect."
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.nameStartsWith(r5)
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = r4.or(r5)
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = r3.or(r4)
                net.bytebuddy.matcher.ElementMatcher$Junction r4 = net.bytebuddy.matcher.ElementMatchers.isSynthetic()
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = r3.or(r4)
                r2.<init>(r3)
                r3 = 1
                r1[r3] = r2
                r0.<init>((net.bytebuddy.agent.builder.AgentBuilder.RawMatcher[]) r1)
                java.util.List r23 = java.util.Collections.emptyList()
                r1 = r30
                r0 = r24
                r2 = r25
                r3 = r26
                r4 = r27
                r5 = r28
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.<init>(net.bytebuddy.ByteBuddy):void");
        }

        public static AgentBuilder of(List<? extends Plugin> list) {
            return of((EntryPoint) EntryPoint.Default.REBASE, list);
        }

        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
            return ignore(elementMatcher, elementMatcher2, ElementMatchers.any());
        }

        public ResettableClassFileTransformer makeRaw() {
            return makeRaw(this.f26935b, InstallationListener.NoOp.INSTANCE, RedefinitionStrategy.ResubmissionEnforcer.Disabled.INSTANCE);
        }

        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher) {
            return type(elementMatcher, ElementMatchers.any());
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0013  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.agent.builder.AgentBuilder warmUp(java.util.Collection<java.lang.Class<?>> r28) {
            /*
                r27 = this;
                r0 = r27
                boolean r1 = r28.isEmpty()
                if (r1 == 0) goto L_0x0009
                return r0
            L_0x0009:
                java.util.Iterator r1 = r28.iterator()
            L_0x000d:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x003d
                java.lang.Object r2 = r1.next()
                java.lang.Class r2 = (java.lang.Class) r2
                boolean r3 = r2.isPrimitive()
                if (r3 != 0) goto L_0x0026
                boolean r3 = r2.isArray()
                if (r3 != 0) goto L_0x0026
                goto L_0x000d
            L_0x0026:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Cannot warm up primitive or array type: "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x003d:
                net.bytebuddy.agent.builder.AgentBuilder$Default r1 = new net.bytebuddy.agent.builder.AgentBuilder$Default
                r3 = r1
                net.bytebuddy.ByteBuddy r4 = r0.f26934a
                net.bytebuddy.agent.builder.AgentBuilder$Listener r5 = r0.f26935b
                net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r6 = r0.f26936c
                net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy r7 = r0.f26937d
                net.bytebuddy.agent.builder.AgentBuilder$TypeStrategy r8 = r0.f26938e
                net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy r9 = r0.f26939f
                net.bytebuddy.agent.builder.AgentBuilder$Default$NativeMethodStrategy r10 = r0.f26940g
                net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy r2 = r0.f26941h
                r11 = r28
                net.bytebuddy.agent.builder.AgentBuilder$Default$WarmupStrategy r11 = r2.with(r11)
                net.bytebuddy.agent.builder.AgentBuilder$TransformerDecorator r12 = r0.f26942i
                net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy r13 = r0.f26943j
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy r14 = r0.f26944k
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$DiscoveryStrategy r15 = r0.f26945l
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$BatchAllocator r2 = r0.f26946m
                r16 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Listener r2 = r0.f26947n
                r17 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy r2 = r0.f26948o
                r18 = r2
                net.bytebuddy.agent.builder.AgentBuilder$InjectionStrategy r2 = r0.f26949p
                r19 = r2
                net.bytebuddy.agent.builder.AgentBuilder$LambdaInstrumentationStrategy r2 = r0.f26950q
                r20 = r2
                net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy r2 = r0.f26951r
                r21 = r2
                net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r2 = r0.f26952s
                r22 = r2
                net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy r2 = r0.f26953t
                r23 = r2
                net.bytebuddy.agent.builder.AgentBuilder$InstallationListener r2 = r0.f26954u
                r24 = r2
                net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r2 = r0.f26955v
                r25 = r2
                java.util.List<net.bytebuddy.agent.builder.AgentBuilder$Default$Transformation> r2 = r0.f26956w
                r26 = r2
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.warmUp(java.util.Collection):net.bytebuddy.agent.builder.AgentBuilder");
        }

        public AgentBuilder with(Listener listener) {
            ByteBuddy byteBuddy = this.f26934a;
            Listener.Compound compound = r4;
            Listener.Compound compound2 = new Listener.Compound(this.f26935b, listener);
            return new Default(byteBuddy, compound, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public static class Redefining extends Default implements RedefinitionListenable.WithoutBatchStrategy {

            public class WithResubmission extends Delegator implements RedefinitionListenable.WithResubmissionSpecification {
                private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                private final RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler;

                public WithResubmission(RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler2, RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2, RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2) {
                    this.resubmissionScheduler = resubmissionScheduler2;
                    this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher2;
                    this.resubmissionImmediateMatcher = resubmissionImmediateMatcher2;
                }

                public AgentBuilder a() {
                    Redefining redefining = Redefining.this;
                    ByteBuddy byteBuddy = redefining.f26934a;
                    Listener listener = redefining.f26935b;
                    CircularityLock circularityLock = redefining.f26936c;
                    PoolStrategy poolStrategy = redefining.f26937d;
                    TypeStrategy typeStrategy = redefining.f26938e;
                    LocationStrategy locationStrategy = redefining.f26939f;
                    NativeMethodStrategy nativeMethodStrategy = redefining.f26940g;
                    WarmupStrategy warmupStrategy = redefining.f26941h;
                    TransformerDecorator transformerDecorator = redefining.f26942i;
                    InitializationStrategy initializationStrategy = redefining.f26943j;
                    RedefinitionStrategy redefinitionStrategy = redefining.f26944k;
                    RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = redefining.f26945l;
                    RedefinitionStrategy.BatchAllocator batchAllocator = redefining.f26946m;
                    RedefinitionStrategy.Listener listener2 = redefining.f26947n;
                    RedefinitionStrategy.ResubmissionStrategy.Enabled enabled = r1;
                    RedefinitionStrategy.ResubmissionStrategy.Enabled enabled2 = new RedefinitionStrategy.ResubmissionStrategy.Enabled(this.resubmissionScheduler, this.resubmissionOnErrorMatcher, this.resubmissionImmediateMatcher);
                    Redefining redefining2 = Redefining.this;
                    return new Default(byteBuddy, listener, circularityLock, poolStrategy, typeStrategy, locationStrategy, nativeMethodStrategy, warmupStrategy, transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, listener2, enabled, redefining2.f26949p, redefining2.f26950q, redefining2.f26951r, redefining2.f26952s, redefining2.f26953t, redefining2.f26954u, redefining2.f26955v, redefining2.f26956w);
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate() {
                    return resubmitImmediate((ElementMatcher<String>) ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError() {
                    return resubmitOnError((ElementMatcher<? super Throwable>) ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher) {
                    return resubmitImmediate(elementMatcher, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher) {
                    return resubmitOnError(elementMatcher, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return resubmitImmediate(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2) {
                    return resubmitOnError(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    return resubmitImmediate((RedefinitionListenable.ResubmissionImmediateMatcher) new RedefinitionListenable.ResubmissionImmediateMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3) {
                    return resubmitOnError(elementMatcher, elementMatcher2, elementMatcher3, ElementMatchers.any());
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2) {
                    return new WithResubmission(this.resubmissionScheduler, this.resubmissionOnErrorMatcher, new RedefinitionListenable.ResubmissionImmediateMatcher.Disjunction(this.resubmissionImmediateMatcher, resubmissionImmediateMatcher2));
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3, ElementMatcher<? super JavaModule> elementMatcher4) {
                    return resubmitOnError((RedefinitionListenable.ResubmissionOnErrorMatcher) new RedefinitionListenable.ResubmissionOnErrorMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3, elementMatcher4));
                }

                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2) {
                    return new WithResubmission(this.resubmissionScheduler, new RedefinitionListenable.ResubmissionOnErrorMatcher.Disjunction(this.resubmissionOnErrorMatcher, resubmissionOnErrorMatcher2), this.resubmissionImmediateMatcher);
                }
            }

            public Redefining(ByteBuddy byteBuddy, Listener listener, CircularityLock circularityLock, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, NativeMethodStrategy nativeMethodStrategy, WarmupStrategy warmupStrategy, TransformerDecorator transformerDecorator, InitializationStrategy initializationStrategy, RedefinitionStrategy redefinitionStrategy, RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener2, RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, List<Transformation> list) {
                super(byteBuddy, listener, circularityLock, poolStrategy, typeStrategy, locationStrategy, nativeMethodStrategy, warmupStrategy, transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, listener2, resubmissionStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy, classFileBufferStrategy, installationListener, rawMatcher, list);
            }

            public /* bridge */ /* synthetic */ ClassFileTransformer makeRaw() {
                return super.makeRaw();
            }

            public RedefinitionListenable redefineOnly(Class<?>... clsArr) {
                return with((RedefinitionStrategy.DiscoveryStrategy) new RedefinitionStrategy.DiscoveryStrategy.Explicit(clsArr));
            }

            public RedefinitionListenable.WithImplicitDiscoveryStrategy with(RedefinitionStrategy.BatchAllocator batchAllocator) {
                if (this.f26944k.b()) {
                    return new Redefining(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, batchAllocator, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
                }
                throw new IllegalStateException("Cannot set redefinition batch allocator when redefinition is disabled");
            }

            public RedefinitionListenable.WithoutResubmissionSpecification withResubmission(RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler) {
                if (this.f26944k.b()) {
                    return new WithResubmission(resubmissionScheduler, RedefinitionListenable.ResubmissionOnErrorMatcher.Trivial.NON_MATCHING, RedefinitionListenable.ResubmissionImmediateMatcher.Trivial.NON_MATCHING);
                }
                throw new IllegalStateException("Cannot enable resubmission when redefinition is disabled");
            }

            public RedefinitionListenable with(RedefinitionStrategy.DiscoveryStrategy discoveryStrategy) {
                if (this.f26944k.b()) {
                    return new Redefining(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, discoveryStrategy, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
                }
                throw new IllegalStateException("Cannot set redefinition discovery strategy when redefinition is disabled");
            }

            public RedefinitionListenable with(RedefinitionStrategy.Listener listener) {
                if (this.f26944k.b()) {
                    ByteBuddy byteBuddy = this.f26934a;
                    Listener listener2 = this.f26935b;
                    CircularityLock circularityLock = this.f26936c;
                    PoolStrategy poolStrategy = this.f26937d;
                    TypeStrategy typeStrategy = this.f26938e;
                    LocationStrategy locationStrategy = this.f26939f;
                    NativeMethodStrategy nativeMethodStrategy = this.f26940g;
                    WarmupStrategy warmupStrategy = this.f26941h;
                    TransformerDecorator transformerDecorator = this.f26942i;
                    InitializationStrategy initializationStrategy = this.f26943j;
                    RedefinitionStrategy redefinitionStrategy = this.f26944k;
                    RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = this.f26945l;
                    RedefinitionStrategy.BatchAllocator batchAllocator = this.f26946m;
                    Redefining redefining = r2;
                    RedefinitionStrategy.Listener.Compound compound = r1;
                    RedefinitionStrategy.Listener.Compound compound2 = new RedefinitionStrategy.Listener.Compound(this.f26947n, listener);
                    Redefining redefining2 = new Redefining(byteBuddy, listener2, circularityLock, poolStrategy, typeStrategy, locationStrategy, nativeMethodStrategy, warmupStrategy, transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, compound, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
                    return redefining;
                }
                throw new IllegalStateException("Cannot set redefinition listener when redefinition is disabled");
            }
        }

        private ResettableClassFileTransformer makeRaw(Listener listener, InstallationListener installationListener, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer) {
            ExecutingTransformer.Factory factory = ExecutingTransformer.f26957a;
            return factory.make(this.f26934a, listener, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26943j, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, installationListener, this.f26955v, resubmissionEnforcer, this.f26956w, this.f26936c);
        }

        public static AgentBuilder of(EntryPoint entryPoint, Plugin... pluginArr) {
            return of(entryPoint, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
            return assureReadEdgeFromAndTo(instrumentation, (Collection<? extends JavaModule>) Arrays.asList(javaModuleArr));
        }

        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
            return assureReadEdgeTo(instrumentation, (Collection<? extends JavaModule>) Arrays.asList(javaModuleArr));
        }

        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
            return ignore((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, ElementMatchers.not(ElementMatchers.supportsModules()).or(elementMatcher3)));
        }

        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
            return type(elementMatcher, elementMatcher2, ElementMatchers.any());
        }

        public AgentBuilder with(CircularityLock circularityLock) {
            return new Default(this.f26934a, this.f26935b, circularityLock, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public static AgentBuilder of(EntryPoint entryPoint, List<? extends Plugin> list) {
            return of(entryPoint, ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5), list);
        }

        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
            return with((Listener) new Listener.ModuleReadEdgeCompleting(instrumentation, true, new HashSet(collection)));
        }

        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection) {
            return with((Listener) new Listener.ModuleReadEdgeCompleting(instrumentation, false, new HashSet(collection)));
        }

        public Ignored ignore(RawMatcher rawMatcher) {
            return new Ignoring(rawMatcher);
        }

        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
            return type((RawMatcher) new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, ElementMatchers.not(ElementMatchers.supportsModules()).or(elementMatcher3)));
        }

        public AgentBuilder with(TypeStrategy typeStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, typeStrategy, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public static AgentBuilder of(ClassFileVersion classFileVersion, Plugin... pluginArr) {
            return of(classFileVersion, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        public AgentBuilder with(PoolStrategy poolStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, poolStrategy, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public static AgentBuilder of(ClassFileVersion classFileVersion, List<? extends Plugin> list) {
            return of((EntryPoint) EntryPoint.Default.REBASE, classFileVersion, list);
        }

        public AgentBuilder with(LocationStrategy locationStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, locationStrategy, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public static class ExecutingTransformer extends ResettableClassFileTransformer.AbstractBase {
            private static final boolean ACCESS_CONTROLLER;

            /* renamed from: a  reason: collision with root package name */
            public static final Factory f26957a = ((Factory) Default.doPrivileged(Factory.CreationAction.INSTANCE));
            private final Object accessControlContext = getContext();
            private final ByteBuddy byteBuddy;
            private final CircularityLock circularityLock;
            private final ClassFileBufferStrategy classFileBufferStrategy;
            private final DescriptionStrategy descriptionStrategy;
            private final FallbackStrategy fallbackStrategy;
            private final RawMatcher ignoreMatcher;
            private final InitializationStrategy initializationStrategy;
            private final InjectionStrategy injectionStrategy;
            private final InstallationListener installationListener;
            private final LambdaInstrumentationStrategy lambdaInstrumentationStrategy;
            private final Listener listener;
            private final LocationStrategy locationStrategy;
            private final NativeMethodStrategy nativeMethodStrategy;
            private final PoolStrategy poolStrategy;
            private final RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer;
            private final List<Transformation> transformations;
            private final TypeStrategy typeStrategy;

            public interface Factory {

                public enum CreationAction implements PrivilegedAction<Factory> {
                    INSTANCE;

                    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
                    public Factory run() {
                        try {
                            DynamicType.Builder<ExecutingTransformer> subclass = new ByteBuddy().with(TypeValidation.DISABLED).subclass(ExecutingTransformer.class);
                            return new ForJava9CapableVm(subclass.name(ExecutingTransformer.class.getName() + "$ByteBuddy$ModuleSupport").method(ElementMatchers.named("transform").and(ElementMatchers.takesArgument(0, (Class<?>) JavaType.MODULE.load()))).intercept(MethodCall.invoke(ExecutingTransformer.class.getDeclaredMethod("b", new Class[]{Object.class, ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class})).onSuper().withAllArguments()).make().load(ExecutingTransformer.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER_PERSISTENT.with(ExecutingTransformer.class.getProtectionDomain())).getLoaded().getDeclaredConstructor(new Class[]{ByteBuddy.class, Listener.class, PoolStrategy.class, TypeStrategy.class, LocationStrategy.class, NativeMethodStrategy.class, InitializationStrategy.class, InjectionStrategy.class, LambdaInstrumentationStrategy.class, DescriptionStrategy.class, FallbackStrategy.class, ClassFileBufferStrategy.class, InstallationListener.class, RawMatcher.class, RedefinitionStrategy.ResubmissionEnforcer.class, List.class, CircularityLock.class}));
                        } catch (Exception unused) {
                            return ForLegacyVm.INSTANCE;
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava9CapableVm implements Factory {
                    private final Constructor<? extends ResettableClassFileTransformer> executingTransformer;

                    public ForJava9CapableVm(Constructor<? extends ResettableClassFileTransformer> constructor) {
                        this.executingTransformer = constructor;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.executingTransformer.equals(((ForJava9CapableVm) obj).executingTransformer);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.executingTransformer.hashCode();
                    }

                    public ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer, List<Transformation> list, CircularityLock circularityLock) {
                        try {
                            return (ResettableClassFileTransformer) this.executingTransformer.newInstance(new Object[]{byteBuddy, listener, poolStrategy, typeStrategy, locationStrategy, nativeMethodStrategy, initializationStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy, classFileBufferStrategy, installationListener, rawMatcher, resubmissionEnforcer, list, circularityLock});
                        } catch (IllegalAccessException e11) {
                            throw new IllegalStateException("Cannot access " + this.executingTransformer, e11);
                        } catch (InstantiationException e12) {
                            throw new IllegalStateException("Cannot instantiate " + this.executingTransformer.getDeclaringClass(), e12);
                        } catch (InvocationTargetException e13) {
                            throw new IllegalStateException("Cannot invoke " + this.executingTransformer, e13.getTargetException());
                        }
                    }
                }

                public enum ForLegacyVm implements Factory {
                    INSTANCE;

                    public ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer, List<Transformation> list, CircularityLock circularityLock) {
                        return new ExecutingTransformer(byteBuddy, listener, poolStrategy, typeStrategy, locationStrategy, nativeMethodStrategy, initializationStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy, classFileBufferStrategy, installationListener, rawMatcher, resubmissionEnforcer, list, circularityLock);
                    }
                }

                ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer, List<Transformation> list, CircularityLock circularityLock);
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class Java9CapableVmDispatcher implements PrivilegedAction<byte[]> {
                private final byte[] binaryRepresentation;
                private final Class<?> classBeingRedefined;
                private final ClassLoader classLoader;
                private final String internalTypeName;
                private final ProtectionDomain protectionDomain;
                private final Object rawModule;

                public Java9CapableVmDispatcher(Object obj, ClassLoader classLoader2, String str, Class<?> cls, ProtectionDomain protectionDomain2, byte[] bArr) {
                    this.rawModule = obj;
                    this.classLoader = classLoader2;
                    this.internalTypeName = str;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain2;
                    this.binaryRepresentation = bArr;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Java9CapableVmDispatcher java9CapableVmDispatcher = (Java9CapableVmDispatcher) obj;
                    return this.internalTypeName.equals(java9CapableVmDispatcher.internalTypeName) && this.rawModule.equals(java9CapableVmDispatcher.rawModule) && this.classLoader.equals(java9CapableVmDispatcher.classLoader) && this.classBeingRedefined.equals(java9CapableVmDispatcher.classBeingRedefined) && this.protectionDomain.equals(java9CapableVmDispatcher.protectionDomain) && Arrays.equals(this.binaryRepresentation, java9CapableVmDispatcher.binaryRepresentation) && ExecutingTransformer.this.equals(ExecutingTransformer.this);
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.rawModule.hashCode()) * 31) + this.classLoader.hashCode()) * 31) + this.internalTypeName.hashCode()) * 31) + this.classBeingRedefined.hashCode()) * 31) + this.protectionDomain.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + ExecutingTransformer.this.hashCode();
                }

                public byte[] run() {
                    return ExecutingTransformer.this.transform(JavaModule.of(this.rawModule), this.classLoader, this.internalTypeName, this.classBeingRedefined, this.protectionDomain, this.binaryRepresentation);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class LegacyVmDispatcher implements PrivilegedAction<byte[]> {
                private final byte[] binaryRepresentation;
                private final Class<?> classBeingRedefined;
                private final ClassLoader classLoader;
                private final String internalTypeName;
                private final ProtectionDomain protectionDomain;

                public LegacyVmDispatcher(ClassLoader classLoader2, String str, Class<?> cls, ProtectionDomain protectionDomain2, byte[] bArr) {
                    this.classLoader = classLoader2;
                    this.internalTypeName = str;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain2;
                    this.binaryRepresentation = bArr;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    LegacyVmDispatcher legacyVmDispatcher = (LegacyVmDispatcher) obj;
                    return this.internalTypeName.equals(legacyVmDispatcher.internalTypeName) && this.classLoader.equals(legacyVmDispatcher.classLoader) && this.classBeingRedefined.equals(legacyVmDispatcher.classBeingRedefined) && this.protectionDomain.equals(legacyVmDispatcher.protectionDomain) && Arrays.equals(this.binaryRepresentation, legacyVmDispatcher.binaryRepresentation) && ExecutingTransformer.this.equals(ExecutingTransformer.this);
                }

                public int hashCode() {
                    return (((((((((((getClass().hashCode() * 31) + this.classLoader.hashCode()) * 31) + this.internalTypeName.hashCode()) * 31) + this.classBeingRedefined.hashCode()) * 31) + this.protectionDomain.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation)) * 31) + ExecutingTransformer.this.hashCode();
                }

                public byte[] run() {
                    return ExecutingTransformer.this.transform(JavaModule.UNSUPPORTED, this.classLoader, this.internalTypeName, this.classBeingRedefined, this.protectionDomain, this.binaryRepresentation);
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

            public ExecutingTransformer(ByteBuddy byteBuddy2, Listener listener2, PoolStrategy poolStrategy2, TypeStrategy typeStrategy2, LocationStrategy locationStrategy2, NativeMethodStrategy nativeMethodStrategy2, InitializationStrategy initializationStrategy2, InjectionStrategy injectionStrategy2, LambdaInstrumentationStrategy lambdaInstrumentationStrategy2, DescriptionStrategy descriptionStrategy2, FallbackStrategy fallbackStrategy2, ClassFileBufferStrategy classFileBufferStrategy2, InstallationListener installationListener2, RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer2, List<Transformation> list, CircularityLock circularityLock2) {
                this.byteBuddy = byteBuddy2;
                this.typeStrategy = typeStrategy2;
                this.poolStrategy = poolStrategy2;
                this.locationStrategy = locationStrategy2;
                this.listener = listener2;
                this.nativeMethodStrategy = nativeMethodStrategy2;
                this.initializationStrategy = initializationStrategy2;
                this.injectionStrategy = injectionStrategy2;
                this.lambdaInstrumentationStrategy = lambdaInstrumentationStrategy2;
                this.descriptionStrategy = descriptionStrategy2;
                this.fallbackStrategy = fallbackStrategy2;
                this.classFileBufferStrategy = classFileBufferStrategy2;
                this.installationListener = installationListener2;
                this.ignoreMatcher = rawMatcher;
                this.resubmissionEnforcer = resubmissionEnforcer2;
                this.transformations = list;
                this.circularityLock = circularityLock2;
            }

            @AccessControllerPlugin.Enhance
            private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, Object obj) {
                if (ACCESS_CONTROLLER) {
                    return AccessController.doPrivileged(privilegedAction, (AccessControlContext) obj);
                }
                return privilegedAction.run();
            }

            private byte[] doTransform(JavaModule javaModule, ClassLoader classLoader, String str, Class<?> cls, boolean z11, ProtectionDomain protectionDomain, TypePool typePool, ClassFileLocator classFileLocator) {
                JavaModule javaModule2 = javaModule;
                ClassLoader classLoader2 = classLoader;
                TypeDescription apply = this.descriptionStrategy.apply(str, cls, typePool, this.circularityLock, classLoader, javaModule);
                ArrayList<Transformer> arrayList = new ArrayList<>();
                if (!this.ignoreMatcher.matches(apply, classLoader, javaModule, cls, protectionDomain)) {
                    for (Transformation next : this.transformations) {
                        if (next.b().matches(apply, classLoader, javaModule, cls, protectionDomain)) {
                            arrayList.addAll(next.c());
                            if (next.d()) {
                                break;
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    this.listener.onIgnored(apply, classLoader2, javaModule, z11);
                    return Transformation.NONE;
                }
                boolean z12 = z11;
                DynamicType.Builder<?> builder = this.typeStrategy.builder(apply, this.byteBuddy, classFileLocator, this.nativeMethodStrategy.resolve(), classLoader, javaModule, protectionDomain);
                InitializationStrategy.Dispatcher dispatcher = this.initializationStrategy.dispatcher();
                for (Transformer transform : arrayList) {
                    builder = transform.transform(builder, apply, classLoader2, javaModule);
                }
                DynamicType.Unloaded<?> make = dispatcher.apply(builder).make(TypeResolutionStrategy.Disabled.INSTANCE, typePool);
                dispatcher.register(make, classLoader2, protectionDomain, this.injectionStrategy);
                this.listener.onTransformation(apply, classLoader, javaModule, z11, make);
                return make.getBytes();
            }

            @AccessControllerPlugin.Enhance
            private static Object getContext() {
                if (ACCESS_CONTROLLER) {
                    return AccessController.getContext();
                }
                return null;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
                throw r10;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
                r10 = net.bytebuddy.agent.builder.AgentBuilder.Default.c();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
                r10 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
                r9.circularityLock.release();
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0023 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public byte[] b(java.lang.Object r10, java.lang.ClassLoader r11, java.lang.String r12, java.lang.Class<?> r13, java.security.ProtectionDomain r14, byte[] r15) {
                /*
                    r9 = this;
                    net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                    boolean r0 = r0.acquire()
                    if (r0 == 0) goto L_0x002f
                    net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer$Java9CapableVmDispatcher r0 = new net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer$Java9CapableVmDispatcher     // Catch:{ all -> 0x0023 }
                    r1 = r0
                    r2 = r9
                    r3 = r10
                    r4 = r11
                    r5 = r12
                    r6 = r13
                    r7 = r14
                    r8 = r15
                    r1.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0023 }
                    java.lang.Object r10 = r9.accessControlContext     // Catch:{ all -> 0x0023 }
                    java.lang.Object r10 = doPrivileged(r0, r10)     // Catch:{ all -> 0x0023 }
                    byte[] r10 = (byte[]) r10     // Catch:{ all -> 0x0023 }
                L_0x001d:
                    net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r11 = r9.circularityLock
                    r11.release()
                    return r10
                L_0x0023:
                    byte[] r10 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION     // Catch:{ all -> 0x0028 }
                    goto L_0x001d
                L_0x0028:
                    r10 = move-exception
                    net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r11 = r9.circularityLock
                    r11.release()
                    throw r10
                L_0x002f:
                    byte[] r10 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.b(java.lang.Object, java.lang.ClassLoader, java.lang.String, java.lang.Class, java.security.ProtectionDomain, byte[]):byte[]");
            }

            public java.util.Iterator<Transformer> iterator(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                if (this.ignoreMatcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                    return Collections.emptySet().iterator();
                }
                return new Transformation.TransformerIterator(typeDescription, classLoader, javaModule, cls, protectionDomain, this.transformations);
            }

            public synchronized boolean reset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, RedefinitionStrategy redefinitionStrategy, RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener2) {
                synchronized (this) {
                    if (!instrumentation.removeTransformer(resettableClassFileTransformer)) {
                        return false;
                    }
                    redefinitionStrategy.apply(instrumentation, this.poolStrategy, this.locationStrategy, this.descriptionStrategy, this.fallbackStrategy, discoveryStrategy, this.lambdaInstrumentationStrategy, Listener.NoOp.INSTANCE, listener2, new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations), batchAllocator, CircularityLock.Inactive.INSTANCE);
                    this.installationListener.onReset(instrumentation, resettableClassFileTransformer);
                    return true;
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
                throw r9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
                r9 = net.bytebuddy.agent.builder.AgentBuilder.Default.c();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
                r9 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
                r8.circularityLock.release();
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0022 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public byte[] transform(java.lang.ClassLoader r9, java.lang.String r10, java.lang.Class<?> r11, java.security.ProtectionDomain r12, byte[] r13) {
                /*
                    r8 = this;
                    net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r8.circularityLock
                    boolean r0 = r0.acquire()
                    if (r0 == 0) goto L_0x002e
                    net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer$LegacyVmDispatcher r0 = new net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer$LegacyVmDispatcher     // Catch:{ all -> 0x0022 }
                    r1 = r0
                    r2 = r8
                    r3 = r9
                    r4 = r10
                    r5 = r11
                    r6 = r12
                    r7 = r13
                    r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0022 }
                    java.lang.Object r9 = r8.accessControlContext     // Catch:{ all -> 0x0022 }
                    java.lang.Object r9 = doPrivileged(r0, r9)     // Catch:{ all -> 0x0022 }
                    byte[] r9 = (byte[]) r9     // Catch:{ all -> 0x0022 }
                L_0x001c:
                    net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r10 = r8.circularityLock
                    r10.release()
                    return r9
                L_0x0022:
                    byte[] r9 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION     // Catch:{ all -> 0x0027 }
                    goto L_0x001c
                L_0x0027:
                    r9 = move-exception
                    net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r10 = r8.circularityLock
                    r10.release()
                    throw r9
                L_0x002e:
                    byte[] r9 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.transform(java.lang.ClassLoader, java.lang.String, java.lang.Class, java.security.ProtectionDomain, byte[]):byte[]");
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x00ef A[Catch:{ all -> 0x0109 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x00f1 A[Catch:{ all -> 0x0109 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x00f9  */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x00fb  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public byte[] transform(net.bytebuddy.utility.JavaModule r19, java.lang.ClassLoader r20, java.lang.String r21, java.lang.Class<?> r22, java.security.ProtectionDomain r23, byte[] r24) {
                /*
                    r18 = this;
                    r10 = r18
                    r11 = r19
                    r12 = r20
                    r0 = r21
                    r13 = r22
                    if (r0 == 0) goto L_0x011a
                    net.bytebuddy.agent.builder.AgentBuilder$LambdaInstrumentationStrategy r1 = r10.lambdaInstrumentationStrategy
                    boolean r1 = r1.c(r13)
                    if (r1 != 0) goto L_0x0016
                    goto L_0x011a
                L_0x0016:
                    r1 = 47
                    r2 = 46
                    java.lang.String r14 = r0.replace(r1, r2)
                    r15 = 0
                    r9 = 1
                    net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionEnforcer r0 = r10.resubmissionEnforcer     // Catch:{ all -> 0x00e8 }
                    boolean r0 = r0.isEnforced(r14, r12, r11, r13)     // Catch:{ all -> 0x00e8 }
                    if (r0 == 0) goto L_0x0032
                    byte[] r0 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION     // Catch:{ all -> 0x002d }
                    return r0
                L_0x002d:
                    r0 = move-exception
                    r6 = r0
                    r15 = r9
                    goto L_0x00eb
                L_0x0032:
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r0 = r10.listener     // Catch:{ all -> 0x00bd }
                    if (r13 == 0) goto L_0x0038
                    r1 = r9
                    goto L_0x0039
                L_0x0038:
                    r1 = r15
                L_0x0039:
                    r0.onDiscovery(r14, r12, r11, r1)     // Catch:{ all -> 0x00bd }
                    net.bytebuddy.dynamic.ClassFileLocator$Compound r8 = new net.bytebuddy.dynamic.ClassFileLocator$Compound     // Catch:{ all -> 0x00bd }
                    r0 = 2
                    net.bytebuddy.dynamic.ClassFileLocator[] r0 = new net.bytebuddy.dynamic.ClassFileLocator[r0]     // Catch:{ all -> 0x00bd }
                    net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy r1 = r10.classFileBufferStrategy     // Catch:{ all -> 0x00bd }
                    r2 = r14
                    r3 = r24
                    r4 = r20
                    r5 = r19
                    r6 = r23
                    net.bytebuddy.dynamic.ClassFileLocator r1 = r1.resolve(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00bd }
                    r0[r15] = r1     // Catch:{ all -> 0x00bd }
                    net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy r1 = r10.locationStrategy     // Catch:{ all -> 0x00bd }
                    net.bytebuddy.dynamic.ClassFileLocator r1 = r1.classFileLocator(r12, r11)     // Catch:{ all -> 0x00bd }
                    r0[r9] = r1     // Catch:{ all -> 0x00bd }
                    r8.<init>((net.bytebuddy.dynamic.ClassFileLocator[]) r0)     // Catch:{ all -> 0x00bd }
                    net.bytebuddy.agent.builder.AgentBuilder$ClassFileBufferStrategy r0 = r10.classFileBufferStrategy     // Catch:{ all -> 0x00bd }
                    net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy r1 = r10.poolStrategy     // Catch:{ all -> 0x00bd }
                    net.bytebuddy.pool.TypePool r16 = r0.typePool(r1, r8, r12, r14)     // Catch:{ all -> 0x00bd }
                    if (r13 == 0) goto L_0x0069
                    r6 = r9
                    goto L_0x006a
                L_0x0069:
                    r6 = r15
                L_0x006a:
                    r1 = r18
                    r2 = r19
                    r3 = r20
                    r4 = r14
                    r5 = r22
                    r7 = r23
                    r17 = r8
                    r8 = r16
                    r15 = r9
                    r9 = r17
                    byte[] r0 = r1.doTransform(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x008a }
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x0085
                    goto L_0x0086
                L_0x0085:
                    r15 = 0
                L_0x0086:
                    r1.onComplete(r14, r12, r11, r15)
                    return r0
                L_0x008a:
                    r0 = move-exception
                    r1 = r0
                    if (r13 == 0) goto L_0x00ba
                    net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy r0 = r10.descriptionStrategy     // Catch:{ all -> 0x00bb }
                    boolean r0 = r0.isLoadedFirst()     // Catch:{ all -> 0x00bb }
                    if (r0 == 0) goto L_0x00ba
                    net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r0 = r10.fallbackStrategy     // Catch:{ all -> 0x00bb }
                    boolean r0 = r0.isFallback(r13, r1)     // Catch:{ all -> 0x00bb }
                    if (r0 == 0) goto L_0x00ba
                    java.lang.Class r5 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_LOADED_TYPE     // Catch:{ all -> 0x00bb }
                    r6 = 1
                    r1 = r18
                    r2 = r19
                    r3 = r20
                    r4 = r14
                    r7 = r23
                    r8 = r16
                    r9 = r17
                    byte[] r0 = r1.doTransform(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00bb }
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    r1.onComplete(r14, r12, r11, r15)
                    return r0
                L_0x00ba:
                    throw r1     // Catch:{ all -> 0x00bb }
                L_0x00bb:
                    r0 = move-exception
                    goto L_0x00bf
                L_0x00bd:
                    r0 = move-exception
                    r15 = r9
                L_0x00bf:
                    r6 = r0
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener     // Catch:{ all -> 0x00dd }
                    if (r13 == 0) goto L_0x00c6
                    r5 = r15
                    goto L_0x00c7
                L_0x00c6:
                    r5 = 0
                L_0x00c7:
                    r2 = r14
                    r3 = r20
                    r4 = r19
                    r1.onError(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00dd }
                    byte[] r0 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION     // Catch:{ all -> 0x00dd }
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x00d8
                    goto L_0x00d9
                L_0x00d8:
                    r15 = 0
                L_0x00d9:
                    r1.onComplete(r14, r12, r11, r15)
                    return r0
                L_0x00dd:
                    r0 = move-exception
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x00e3
                    goto L_0x00e4
                L_0x00e3:
                    r15 = 0
                L_0x00e4:
                    r1.onComplete(r14, r12, r11, r15)
                    throw r0
                L_0x00e8:
                    r0 = move-exception
                    r15 = r9
                    r6 = r0
                L_0x00eb:
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r0 = r10.listener     // Catch:{ all -> 0x0109 }
                    if (r13 == 0) goto L_0x00f1
                    r9 = r15
                    goto L_0x00f2
                L_0x00f1:
                    r9 = 0
                L_0x00f2:
                    r0.onDiscovery(r14, r12, r11, r9)     // Catch:{ all -> 0x0109 }
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x00fb
                    r5 = r15
                    goto L_0x00fc
                L_0x00fb:
                    r5 = 0
                L_0x00fc:
                    r2 = r14
                    r3 = r20
                    r4 = r19
                    r1.onError(r2, r3, r4, r5, r6)
                    byte[] r0 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION
                    return r0
                L_0x0109:
                    r0 = move-exception
                    net.bytebuddy.agent.builder.AgentBuilder$Listener r1 = r10.listener
                    if (r13 == 0) goto L_0x0110
                    r5 = r15
                    goto L_0x0111
                L_0x0110:
                    r5 = 0
                L_0x0111:
                    r2 = r14
                    r3 = r20
                    r4 = r19
                    r1.onError(r2, r3, r4, r5, r6)
                    throw r0
                L_0x011a:
                    byte[] r0 = net.bytebuddy.agent.builder.AgentBuilder.Default.NO_TRANSFORMATION
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.transform(net.bytebuddy.utility.JavaModule, java.lang.ClassLoader, java.lang.String, java.lang.Class, java.security.ProtectionDomain, byte[]):byte[]");
            }
        }

        public static AgentBuilder of(EntryPoint entryPoint, ClassFileVersion classFileVersion, Plugin... pluginArr) {
            return of(entryPoint, classFileVersion, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        public AgentBuilder with(TransformerDecorator transformerDecorator) {
            ByteBuddy byteBuddy = this.f26934a;
            Listener listener = this.f26935b;
            CircularityLock circularityLock = this.f26936c;
            PoolStrategy poolStrategy = this.f26937d;
            TypeStrategy typeStrategy = this.f26938e;
            LocationStrategy locationStrategy = this.f26939f;
            NativeMethodStrategy nativeMethodStrategy = this.f26940g;
            WarmupStrategy warmupStrategy = this.f26941h;
            TransformerDecorator.Compound compound = r11;
            TransformerDecorator.Compound compound2 = new TransformerDecorator.Compound(this.f26942i, transformerDecorator);
            return new Default(byteBuddy, listener, circularityLock, poolStrategy, typeStrategy, locationStrategy, nativeMethodStrategy, warmupStrategy, compound, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public static AgentBuilder of(EntryPoint entryPoint, ClassFileVersion classFileVersion, List<? extends Plugin> list) {
            AgentBuilder with = new Default(entryPoint.byteBuddy(classFileVersion)).with((TypeStrategy) new TypeStrategy.ForBuildEntryPoint(entryPoint));
            for (Plugin plugin : list) {
                with = with.type((ElementMatcher<? super TypeDescription>) plugin).transform(new Transformer.ForBuildPlugin(plugin));
            }
            return with;
        }

        public RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy) {
            return new Redefining(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, redefinitionStrategy, RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE, RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, RedefinitionStrategy.Listener.NoOp.INSTANCE, RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public AgentBuilder with(InitializationStrategy initializationStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, initializationStrategy, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, lambdaInstrumentationStrategy, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public Default(ByteBuddy byteBuddy, Listener listener, CircularityLock circularityLock, PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy, NativeMethodStrategy nativeMethodStrategy, WarmupStrategy warmupStrategy, TransformerDecorator transformerDecorator, InitializationStrategy initializationStrategy, RedefinitionStrategy redefinitionStrategy, RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener2, RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy, InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener, RawMatcher rawMatcher, List<Transformation> list) {
            this.f26934a = byteBuddy;
            this.f26935b = listener;
            this.f26936c = circularityLock;
            this.f26937d = poolStrategy;
            this.f26938e = typeStrategy;
            this.f26939f = locationStrategy;
            this.f26940g = nativeMethodStrategy;
            this.f26941h = warmupStrategy;
            this.f26942i = transformerDecorator;
            this.f26943j = initializationStrategy;
            this.f26944k = redefinitionStrategy;
            this.f26945l = discoveryStrategy;
            this.f26946m = batchAllocator;
            this.f26947n = listener2;
            this.f26948o = resubmissionStrategy;
            this.f26949p = injectionStrategy;
            this.f26950q = lambdaInstrumentationStrategy;
            this.f26951r = descriptionStrategy;
            this.f26952s = fallbackStrategy;
            this.f26953t = classFileBufferStrategy;
            this.f26954u = installationListener;
            this.f26955v = rawMatcher;
            this.f26956w = list;
        }

        public AgentBuilder with(DescriptionStrategy descriptionStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, descriptionStrategy, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public AgentBuilder with(FallbackStrategy fallbackStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, fallbackStrategy, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }

        public AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, this.f26949p, this.f26950q, this.f26951r, this.f26952s, classFileBufferStrategy, this.f26954u, this.f26955v, this.f26956w);
        }

        public AgentBuilder with(InstallationListener installationListener) {
            ByteBuddy byteBuddy = this.f26934a;
            Listener listener = this.f26935b;
            CircularityLock circularityLock = this.f26936c;
            PoolStrategy poolStrategy = this.f26937d;
            TypeStrategy typeStrategy = this.f26938e;
            LocationStrategy locationStrategy = this.f26939f;
            NativeMethodStrategy nativeMethodStrategy = this.f26940g;
            WarmupStrategy warmupStrategy = this.f26941h;
            TransformerDecorator transformerDecorator = this.f26942i;
            InitializationStrategy initializationStrategy = this.f26943j;
            RedefinitionStrategy redefinitionStrategy = this.f26944k;
            RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = this.f26945l;
            RedefinitionStrategy.BatchAllocator batchAllocator = this.f26946m;
            RedefinitionStrategy.Listener listener2 = this.f26947n;
            RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy = this.f26948o;
            InjectionStrategy injectionStrategy = this.f26949p;
            LambdaInstrumentationStrategy lambdaInstrumentationStrategy = this.f26950q;
            DescriptionStrategy descriptionStrategy = this.f26951r;
            FallbackStrategy fallbackStrategy = this.f26952s;
            ClassFileBufferStrategy classFileBufferStrategy = this.f26953t;
            InstallationListener.Compound compound = r1;
            ByteBuddy byteBuddy2 = byteBuddy;
            InstallationListener.Compound compound2 = new InstallationListener.Compound(this.f26954u, installationListener);
            return new Default(byteBuddy2, listener, circularityLock, poolStrategy, typeStrategy, locationStrategy, nativeMethodStrategy, warmupStrategy, transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, listener2, resubmissionStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy, classFileBufferStrategy, compound, this.f26955v, this.f26956w);
        }

        public AgentBuilder with(InjectionStrategy injectionStrategy) {
            return new Default(this.f26934a, this.f26935b, this.f26936c, this.f26937d, this.f26938e, this.f26939f, this.f26940g, this.f26941h, this.f26942i, this.f26943j, this.f26944k, this.f26945l, this.f26946m, this.f26947n, this.f26948o, injectionStrategy, this.f26950q, this.f26951r, this.f26952s, this.f26953t, this.f26954u, this.f26955v, this.f26956w);
        }
    }

    public interface DescriptionStrategy {

        public enum Default implements DescriptionStrategy {
            HYBRID(true) {
                public TypeDescription apply(String str, Class<?> cls, TypePool typePool, CircularityLock circularityLock, ClassLoader classLoader, JavaModule javaModule) {
                    if (cls == null) {
                        return typePool.describe(str).resolve();
                    }
                    return TypeDescription.ForLoadedType.of(cls);
                }
            },
            POOL_ONLY(false) {
                public TypeDescription apply(String str, Class<?> cls, TypePool typePool, CircularityLock circularityLock, ClassLoader classLoader, JavaModule javaModule) {
                    return typePool.describe(str).resolve();
                }
            },
            POOL_FIRST(false) {
                public TypeDescription apply(String str, Class<?> cls, TypePool typePool, CircularityLock circularityLock, ClassLoader classLoader, JavaModule javaModule) {
                    TypePool.Resolution describe = typePool.describe(str);
                    if (describe.isResolved() || cls == null) {
                        return describe.resolve();
                    }
                    return TypeDescription.ForLoadedType.of(cls);
                }
            };
            
            private final boolean loadedFirst;

            public boolean isLoadedFirst() {
                return this.loadedFirst;
            }

            public DescriptionStrategy withSuperTypeLoading() {
                return new SuperTypeLoading(this);
            }

            private Default(boolean z11) {
                this.loadedFirst = z11;
            }

            public DescriptionStrategy withSuperTypeLoading(ExecutorService executorService) {
                return new SuperTypeLoading.Asynchronous(this, executorService);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class SuperTypeLoading implements DescriptionStrategy {
            private final DescriptionStrategy delegate;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Asynchronous implements DescriptionStrategy {
                private final DescriptionStrategy delegate;
                private final ExecutorService executorService;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ThreadSwitchingClassLoadingDelegate implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate {
                    private final ExecutorService executorService;

                    public static class NotifyingClassLoadingAction implements Callable<Class<?>> {
                        private final ClassLoader classLoader;

                        /* renamed from: name  reason: collision with root package name */
                        private final String f26963name;
                        private final AtomicBoolean signal;

                        public NotifyingClassLoadingAction(String str, ClassLoader classLoader2, AtomicBoolean atomicBoolean) {
                            this.f26963name = str;
                            this.classLoader = classLoader2;
                            this.signal = atomicBoolean;
                        }

                        public Class<?> call() throws ClassNotFoundException {
                            Class<?> cls;
                            synchronized (this.classLoader) {
                                try {
                                    cls = Class.forName(this.f26963name, false, this.classLoader);
                                    this.signal.set(false);
                                    this.classLoader.notifyAll();
                                } catch (Throwable th2) {
                                    this.signal.set(false);
                                    this.classLoader.notifyAll();
                                    throw th2;
                                }
                            }
                            return cls;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class SimpleClassLoadingAction implements Callable<Class<?>> {
                        private final ClassLoader classLoader;

                        /* renamed from: name  reason: collision with root package name */
                        private final String f26964name;

                        public SimpleClassLoadingAction(String str, ClassLoader classLoader2) {
                            this.f26964name = str;
                            this.classLoader = classLoader2;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            SimpleClassLoadingAction simpleClassLoadingAction = (SimpleClassLoadingAction) obj;
                            return this.f26964name.equals(simpleClassLoadingAction.f26964name) && this.classLoader.equals(simpleClassLoadingAction.classLoader);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.f26964name.hashCode()) * 31) + this.classLoader.hashCode();
                        }

                        public Class<?> call() throws ClassNotFoundException {
                            return Class.forName(this.f26964name, false, this.classLoader);
                        }
                    }

                    public ThreadSwitchingClassLoadingDelegate(ExecutorService executorService2) {
                        this.executorService = executorService2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.executorService.equals(((ThreadSwitchingClassLoadingDelegate) obj).executorService);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.executorService.hashCode();
                    }

                    public Class<?> load(String str, ClassLoader classLoader) {
                        boolean z11;
                        Callable callable;
                        if (classLoader == null || !Thread.holdsLock(classLoader)) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        AtomicBoolean atomicBoolean = new AtomicBoolean(z11);
                        ExecutorService executorService2 = this.executorService;
                        if (z11) {
                            callable = new NotifyingClassLoadingAction(str, classLoader, atomicBoolean);
                        } else {
                            callable = new SimpleClassLoadingAction(str, classLoader);
                        }
                        Future submit = executorService2.submit(callable);
                        while (z11) {
                            try {
                                if (!atomicBoolean.get()) {
                                    break;
                                }
                                classLoader.wait();
                            } catch (ExecutionException e11) {
                                throw new IllegalStateException("Could not load " + str + " asynchronously", e11.getCause());
                            } catch (Exception e12) {
                                throw new IllegalStateException("Could not load " + str + " asynchronously", e12);
                            }
                        }
                        return (Class) submit.get();
                    }
                }

                public Asynchronous(DescriptionStrategy descriptionStrategy, ExecutorService executorService2) {
                    this.delegate = descriptionStrategy;
                    this.executorService = executorService2;
                }

                public TypeDescription apply(String str, Class<?> cls, TypePool typePool, CircularityLock circularityLock, ClassLoader classLoader, JavaModule javaModule) {
                    TypeDescription apply = this.delegate.apply(str, cls, typePool, circularityLock, classLoader, javaModule);
                    if (apply instanceof TypeDescription.ForLoadedType) {
                        return apply;
                    }
                    return new TypeDescription.SuperTypeLoading(apply, classLoader, new ThreadSwitchingClassLoadingDelegate(this.executorService));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Asynchronous asynchronous = (Asynchronous) obj;
                    return this.delegate.equals(asynchronous.delegate) && this.executorService.equals(asynchronous.executorService);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.executorService.hashCode();
                }

                public boolean isLoadedFirst() {
                    return this.delegate.isLoadedFirst();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class UnlockingClassLoadingDelegate implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate {
                private final CircularityLock circularityLock;

                public UnlockingClassLoadingDelegate(CircularityLock circularityLock2) {
                    this.circularityLock = circularityLock2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.circularityLock.equals(((UnlockingClassLoadingDelegate) obj).circularityLock);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.circularityLock.hashCode();
                }

                public Class<?> load(String str, ClassLoader classLoader) throws ClassNotFoundException {
                    this.circularityLock.release();
                    try {
                        return Class.forName(str, false, classLoader);
                    } finally {
                        this.circularityLock.acquire();
                    }
                }
            }

            public SuperTypeLoading(DescriptionStrategy descriptionStrategy) {
                this.delegate = descriptionStrategy;
            }

            public TypeDescription apply(String str, Class<?> cls, TypePool typePool, CircularityLock circularityLock, ClassLoader classLoader, JavaModule javaModule) {
                TypeDescription apply = this.delegate.apply(str, cls, typePool, circularityLock, classLoader, javaModule);
                if (apply instanceof TypeDescription.ForLoadedType) {
                    return apply;
                }
                return new TypeDescription.SuperTypeLoading(apply, classLoader, new UnlockingClassLoadingDelegate(circularityLock));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((SuperTypeLoading) obj).delegate);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.delegate.hashCode();
            }

            public boolean isLoadedFirst() {
                return this.delegate.isLoadedFirst();
            }
        }

        TypeDescription apply(String str, Class<?> cls, TypePool typePool, CircularityLock circularityLock, ClassLoader classLoader, JavaModule javaModule);

        boolean isLoadedFirst();
    }

    public interface FallbackStrategy {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ByThrowableType implements FallbackStrategy {
            private final Set<? extends Class<? extends Throwable>> types;

            public ByThrowableType(Class<? extends Throwable>... clsArr) {
                this((Set<? extends Class<? extends Throwable>>) new HashSet(Arrays.asList(clsArr)));
            }

            public static FallbackStrategy ofOptionalTypes() {
                return new ByThrowableType((Class<? extends Throwable>[]) new Class[]{LinkageError.class, TypeNotPresentException.class});
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.types.equals(((ByThrowableType) obj).types);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.types.hashCode();
            }

            public boolean isFallback(Class<?> cls, Throwable th2) {
                for (Class isInstance : this.types) {
                    if (isInstance.isInstance(th2)) {
                        return true;
                    }
                }
                return false;
            }

            public ByThrowableType(Set<? extends Class<? extends Throwable>> set) {
                this.types = set;
            }
        }

        public enum Simple implements FallbackStrategy {
            ENABLED(true),
            DISABLED(false);
            
            private final boolean enabled;

            private Simple(boolean z11) {
                this.enabled = z11;
            }

            public boolean isFallback(Class<?> cls, Throwable th2) {
                return this.enabled;
            }
        }

        boolean isFallback(Class<?> cls, Throwable th2);
    }

    public interface Identified {

        public interface Extendable extends AgentBuilder, Identified {
            AgentBuilder asTerminalTransformation();
        }

        public interface Narrowable extends Matchable<Narrowable>, Identified {
        }

        Extendable transform(Transformer transformer);
    }

    public interface Ignored extends Matchable<Ignored>, AgentBuilder {
    }

    public interface InitializationStrategy {

        public interface Dispatcher {
            DynamicType.Builder<?> apply(DynamicType.Builder<?> builder);

            void register(DynamicType dynamicType, ClassLoader classLoader, ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy);
        }

        public enum Minimal implements InitializationStrategy, Dispatcher {
            INSTANCE;

            public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                return builder;
            }

            public Dispatcher dispatcher() {
                return this;
            }

            public void register(DynamicType dynamicType, ClassLoader classLoader, ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                Map<TypeDescription, byte[]> auxiliaryTypes = dynamicType.getAuxiliaryTypes();
                LinkedHashMap linkedHashMap = new LinkedHashMap(auxiliaryTypes);
                for (TypeDescription next : auxiliaryTypes.keySet()) {
                    if (!next.getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) AuxiliaryType.SignatureRelevant.class)) {
                        linkedHashMap.remove(next);
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    ClassInjector resolve = injectionStrategy.resolve(classLoader, protectionDomain);
                    Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers = dynamicType.getLoadedTypeInitializers();
                    for (Map.Entry next2 : resolve.inject(linkedHashMap).entrySet()) {
                        loadedTypeInitializers.get(next2.getKey()).onLoad((Class) next2.getValue());
                    }
                }
            }
        }

        public enum NoOp implements InitializationStrategy, Dispatcher {
            INSTANCE;

            public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                return builder;
            }

            public Dispatcher dispatcher() {
                return this;
            }

            public void register(DynamicType dynamicType, ClassLoader classLoader, ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class SelfInjection implements InitializationStrategy {

            /* renamed from: b  reason: collision with root package name */
            public final NexusAccessor f26965b;

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Dispatcher implements Dispatcher {

                /* renamed from: b  reason: collision with root package name */
                public final NexusAccessor f26966b;

                /* renamed from: c  reason: collision with root package name */
                public final int f26967c;

                @HashCodeAndEqualsPlugin.Enhance
                public static class InjectingInitializer implements LoadedTypeInitializer {
                    private final ClassInjector classInjector;
                    private final TypeDescription instrumentedType;
                    private final Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers;
                    private final Map<TypeDescription, byte[]> rawAuxiliaryTypes;

                    public InjectingInitializer(TypeDescription typeDescription, Map<TypeDescription, byte[]> map, Map<TypeDescription, LoadedTypeInitializer> map2, ClassInjector classInjector2) {
                        this.instrumentedType = typeDescription;
                        this.rawAuxiliaryTypes = map;
                        this.loadedTypeInitializers = map2;
                        this.classInjector = classInjector2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InjectingInitializer injectingInitializer = (InjectingInitializer) obj;
                        return this.instrumentedType.equals(injectingInitializer.instrumentedType) && this.rawAuxiliaryTypes.equals(injectingInitializer.rawAuxiliaryTypes) && this.loadedTypeInitializers.equals(injectingInitializer.loadedTypeInitializers) && this.classInjector.equals(injectingInitializer.classInjector);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.rawAuxiliaryTypes.hashCode()) * 31) + this.loadedTypeInitializers.hashCode()) * 31) + this.classInjector.hashCode();
                    }

                    public boolean isAlive() {
                        return true;
                    }

                    public void onLoad(Class<?> cls) {
                        for (Map.Entry next : this.classInjector.inject(this.rawAuxiliaryTypes).entrySet()) {
                            this.loadedTypeInitializers.get(next.getKey()).onLoad((Class) next.getValue());
                        }
                        this.loadedTypeInitializers.get(this.instrumentedType).onLoad(cls);
                    }
                }

                public Dispatcher(NexusAccessor nexusAccessor, int i11) {
                    this.f26966b = nexusAccessor;
                    this.f26967c = i11;
                }

                public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                    return builder.initializer((ByteCodeAppender) new NexusAccessor.InitializationAppender(this.f26967c));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Dispatcher dispatcher = (Dispatcher) obj;
                    return this.f26967c == dispatcher.f26967c && this.f26966b.equals(dispatcher.f26966b);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.f26966b.hashCode()) * 31) + this.f26967c;
                }
            }

            public static class Eager extends SelfInjection {

                public static class Dispatcher extends Dispatcher {
                    public Dispatcher(NexusAccessor nexusAccessor, int i11) {
                        super(nexusAccessor, i11);
                    }

                    public void register(DynamicType dynamicType, ClassLoader classLoader, ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                        Map<TypeDescription, byte[]> auxiliaryTypes = dynamicType.getAuxiliaryTypes();
                        Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers = dynamicType.getLoadedTypeInitializers();
                        if (!auxiliaryTypes.isEmpty()) {
                            for (Map.Entry next : injectionStrategy.resolve(classLoader, protectionDomain).inject(auxiliaryTypes).entrySet()) {
                                loadedTypeInitializers.get(next.getKey()).onLoad((Class) next.getValue());
                            }
                        }
                        this.f26966b.register(dynamicType.getTypeDescription().getName(), classLoader, this.f26967c, loadedTypeInitializers.get(dynamicType.getTypeDescription()));
                    }
                }

                public Eager() {
                    this(new NexusAccessor());
                }

                public Dispatcher a(int i11) {
                    return new Dispatcher(this.f26965b, i11);
                }

                public Eager(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            public static class Lazy extends SelfInjection {

                public static class Dispatcher extends Dispatcher {
                    public Dispatcher(NexusAccessor nexusAccessor, int i11) {
                        super(nexusAccessor, i11);
                    }

                    public void register(DynamicType dynamicType, ClassLoader classLoader, ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                        LoadedTypeInitializer loadedTypeInitializer;
                        Map<TypeDescription, byte[]> auxiliaryTypes = dynamicType.getAuxiliaryTypes();
                        if (auxiliaryTypes.isEmpty()) {
                            loadedTypeInitializer = dynamicType.getLoadedTypeInitializers().get(dynamicType.getTypeDescription());
                        } else {
                            loadedTypeInitializer = new Dispatcher.InjectingInitializer(dynamicType.getTypeDescription(), auxiliaryTypes, dynamicType.getLoadedTypeInitializers(), injectionStrategy.resolve(classLoader, protectionDomain));
                        }
                        this.f26966b.register(dynamicType.getTypeDescription().getName(), classLoader, this.f26967c, loadedTypeInitializer);
                    }
                }

                public Lazy() {
                    this(new NexusAccessor());
                }

                public Dispatcher a(int i11) {
                    return new Dispatcher(this.f26965b, i11);
                }

                public Lazy(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            public static class Split extends SelfInjection {

                public static class Dispatcher extends Dispatcher {
                    public Dispatcher(NexusAccessor nexusAccessor, int i11) {
                        super(nexusAccessor, i11);
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: net.bytebuddy.implementation.LoadedTypeInitializer} */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void register(net.bytebuddy.dynamic.DynamicType r7, java.lang.ClassLoader r8, java.security.ProtectionDomain r9, net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy r10) {
                        /*
                            r6 = this;
                            java.util.Map r0 = r7.getAuxiliaryTypes()
                            boolean r1 = r0.isEmpty()
                            if (r1 != 0) goto L_0x009e
                            net.bytebuddy.description.type.TypeDescription r1 = r7.getTypeDescription()
                            net.bytebuddy.dynamic.loading.ClassInjector r9 = r10.resolve(r8, r9)
                            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
                            r10.<init>(r0)
                            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                            r2.<init>(r0)
                            java.util.Set r0 = r0.keySet()
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0024:
                            boolean r3 = r0.hasNext()
                            if (r3 == 0) goto L_0x0043
                            java.lang.Object r3 = r0.next()
                            net.bytebuddy.description.type.TypeDescription r3 = (net.bytebuddy.description.type.TypeDescription) r3
                            net.bytebuddy.description.annotation.AnnotationList r4 = r3.getDeclaredAnnotations()
                            java.lang.Class<net.bytebuddy.implementation.auxiliary.AuxiliaryType$SignatureRelevant> r5 = net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant.class
                            boolean r4 = r4.isAnnotationPresent((java.lang.Class<? extends java.lang.annotation.Annotation>) r5)
                            if (r4 == 0) goto L_0x003e
                            r4 = r2
                            goto L_0x003f
                        L_0x003e:
                            r4 = r10
                        L_0x003f:
                            r4.remove(r3)
                            goto L_0x0024
                        L_0x0043:
                            java.util.Map r0 = r7.getLoadedTypeInitializers()
                            boolean r3 = r10.isEmpty()
                            if (r3 != 0) goto L_0x0079
                            java.util.Map r3 = r9.inject(r10)
                            java.util.Set r3 = r3.entrySet()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0059:
                            boolean r4 = r3.hasNext()
                            if (r4 == 0) goto L_0x0079
                            java.lang.Object r4 = r3.next()
                            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                            java.lang.Object r5 = r4.getKey()
                            java.lang.Object r5 = r0.get(r5)
                            net.bytebuddy.implementation.LoadedTypeInitializer r5 = (net.bytebuddy.implementation.LoadedTypeInitializer) r5
                            java.lang.Object r4 = r4.getValue()
                            java.lang.Class r4 = (java.lang.Class) r4
                            r5.onLoad(r4)
                            goto L_0x0059
                        L_0x0079:
                            java.util.HashMap r3 = new java.util.HashMap
                            r3.<init>(r0)
                            java.util.Set r0 = r0.keySet()
                            java.util.Set r10 = r10.keySet()
                            r0.removeAll(r10)
                            int r10 = r3.size()
                            r0 = 1
                            if (r10 <= r0) goto L_0x0096
                            net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Dispatcher$InjectingInitializer r10 = new net.bytebuddy.agent.builder.AgentBuilder$InitializationStrategy$SelfInjection$Dispatcher$InjectingInitializer
                            r10.<init>(r1, r2, r3, r9)
                            goto L_0x00ad
                        L_0x0096:
                            java.lang.Object r9 = r3.get(r1)
                            r10 = r9
                            net.bytebuddy.implementation.LoadedTypeInitializer r10 = (net.bytebuddy.implementation.LoadedTypeInitializer) r10
                            goto L_0x00ad
                        L_0x009e:
                            java.util.Map r9 = r7.getLoadedTypeInitializers()
                            net.bytebuddy.description.type.TypeDescription r10 = r7.getTypeDescription()
                            java.lang.Object r9 = r9.get(r10)
                            r10 = r9
                            net.bytebuddy.implementation.LoadedTypeInitializer r10 = (net.bytebuddy.implementation.LoadedTypeInitializer) r10
                        L_0x00ad:
                            net.bytebuddy.dynamic.NexusAccessor r9 = r6.f26966b
                            net.bytebuddy.description.type.TypeDescription r7 = r7.getTypeDescription()
                            java.lang.String r7 = r7.getName()
                            int r0 = r6.f26967c
                            r9.register(r7, r8, r0, r10)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split.Dispatcher.register(net.bytebuddy.dynamic.DynamicType, java.lang.ClassLoader, java.security.ProtectionDomain, net.bytebuddy.agent.builder.AgentBuilder$InjectionStrategy):void");
                    }
                }

                public Split() {
                    this(new NexusAccessor());
                }

                public Dispatcher a(int i11) {
                    return new Dispatcher(this.f26965b, i11);
                }

                public Split(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            public SelfInjection(NexusAccessor nexusAccessor) {
                this.f26965b = nexusAccessor;
            }

            public abstract Dispatcher a(int i11);

            @SuppressFBWarnings(justification = "Avoiding synchronization without security concerns", value = {"DMI_RANDOM_USED_ONLY_ONCE"})
            public Dispatcher dispatcher() {
                return a(new Random().nextInt());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.f26965b.equals(((SelfInjection) obj).f26965b);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.f26965b.hashCode();
            }
        }

        Dispatcher dispatcher();
    }

    public interface InjectionStrategy {

        public enum Disabled implements InjectionStrategy {
            INSTANCE;

            public ClassInjector resolve(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                throw new IllegalStateException("Class injection is disabled");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingInstrumentation implements InjectionStrategy {
            private final File folder;
            private final Instrumentation instrumentation;

            public UsingInstrumentation(Instrumentation instrumentation2, File file) {
                this.instrumentation = instrumentation2;
                this.folder = file;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingInstrumentation usingInstrumentation = (UsingInstrumentation) obj;
                return this.instrumentation.equals(usingInstrumentation.instrumentation) && this.folder.equals(usingInstrumentation.folder);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.folder.hashCode();
            }

            public ClassInjector resolve(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                if (classLoader == null) {
                    return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, this.instrumentation);
                }
                return UsingReflection.INSTANCE.resolve(classLoader, protectionDomain);
            }
        }

        public enum UsingJna implements InjectionStrategy {
            INSTANCE;

            public ClassInjector resolve(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                if (ClassInjector.UsingJna.isAvailable()) {
                    return new ClassInjector.UsingJna(classLoader, protectionDomain);
                }
                throw new IllegalStateException("JNA-based injection is not available on the current VM");
            }
        }

        public enum UsingReflection implements InjectionStrategy {
            INSTANCE;

            public ClassInjector resolve(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                if (classLoader == null) {
                    throw new IllegalStateException("Cannot inject auxiliary class into bootstrap loader using reflection");
                } else if (ClassInjector.UsingReflection.isAvailable()) {
                    return new ClassInjector.UsingReflection(classLoader, protectionDomain);
                } else {
                    throw new IllegalStateException("Reflection-based injection is not available on the current VM");
                }
            }
        }

        public enum UsingUnsafe implements InjectionStrategy {
            INSTANCE;

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfFactory implements InjectionStrategy {
                private final ClassInjector.UsingUnsafe.Factory factory;

                public OfFactory(ClassInjector.UsingUnsafe.Factory factory2) {
                    this.factory = factory2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factory.equals(((OfFactory) obj).factory);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.factory.hashCode();
                }

                public ClassInjector resolve(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                    return this.factory.make(classLoader, protectionDomain);
                }
            }

            public ClassInjector resolve(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                if (ClassInjector.UsingUnsafe.isAvailable()) {
                    return new ClassInjector.UsingUnsafe(classLoader, protectionDomain);
                }
                throw new IllegalStateException("Unsafe-based injection is not available on the current VM");
            }
        }

        ClassInjector resolve(ClassLoader classLoader, ProtectionDomain protectionDomain);
    }

    public interface InstallationListener {
        public static final Throwable SUPPRESS_ERROR = null;

        public static abstract class Adapter implements InstallationListener {
            public void onAfterWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer, boolean z11) {
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements InstallationListener {
            private final List<InstallationListener> installationListeners;

            public Compound(InstallationListener... installationListenerArr) {
                this((List<? extends InstallationListener>) Arrays.asList(installationListenerArr));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.installationListeners.equals(((Compound) obj).installationListeners);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.installationListeners.hashCode();
            }

            public void onAfterWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer, boolean z11) {
                for (InstallationListener onAfterWarmUp : this.installationListeners) {
                    onAfterWarmUp.onAfterWarmUp(set, resettableClassFileTransformer, z11);
                }
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onBeforeInstall : this.installationListeners) {
                    onBeforeInstall.onBeforeInstall(instrumentation, resettableClassFileTransformer);
                }
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onBeforeWarmUp : this.installationListeners) {
                    onBeforeWarmUp.onBeforeWarmUp(set, resettableClassFileTransformer);
                }
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                for (InstallationListener next : this.installationListeners) {
                    Throwable th3 = InstallationListener.SUPPRESS_ERROR;
                    if (th2 == th3) {
                        return th3;
                    }
                    th2 = next.onError(instrumentation, resettableClassFileTransformer, th2);
                }
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onInstall : this.installationListeners) {
                    onInstall.onInstall(instrumentation, resettableClassFileTransformer);
                }
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                for (InstallationListener onReset : this.installationListeners) {
                    onReset.onReset(instrumentation, resettableClassFileTransformer);
                }
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                for (InstallationListener onWarmUpError : this.installationListeners) {
                    onWarmUpError.onWarmUpError(cls, resettableClassFileTransformer, th2);
                }
            }

            public Compound(List<? extends InstallationListener> list) {
                this.installationListeners = new ArrayList();
                for (InstallationListener installationListener : list) {
                    if (installationListener instanceof Compound) {
                        this.installationListeners.addAll(((Compound) installationListener).installationListeners);
                    } else if (!(installationListener instanceof NoOp)) {
                        this.installationListeners.add(installationListener);
                    }
                }
            }
        }

        public enum ErrorSuppressing implements InstallationListener {
            INSTANCE;

            public void onAfterWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer, boolean z11) {
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                return InstallationListener.SUPPRESS_ERROR;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
            }
        }

        public enum NoOp implements InstallationListener {
            INSTANCE;

            public void onAfterWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer, boolean z11) {
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class StreamWriting implements InstallationListener {
            private final PrintStream printStream;

            public StreamWriting(PrintStream printStream2) {
                this.printStream = printStream2;
            }

            public static InstallationListener toSystemError() {
                return new StreamWriting(System.err);
            }

            public static InstallationListener toSystemOut() {
                return new StreamWriting(System.out);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.printStream.equals(((StreamWriting) obj).printStream);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.printStream.hashCode();
            }

            public void onAfterWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer, boolean z11) {
                PrintStream printStream2 = this.printStream;
                Object[] objArr = new Object[3];
                objArr[0] = z11 ? "transformed" : "not transformed";
                objArr[1] = resettableClassFileTransformer;
                objArr[2] = set;
                printStream2.printf("[Byte Buddy] AFTER_WARMUP %s %s on %s%n", objArr);
            }

            public void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] BEFORE_INSTALL %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
            }

            public void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] BEFORE_WARMUP %s on %s%n", new Object[]{resettableClassFileTransformer, set});
            }

            public Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
                    th2.printStackTrace(this.printStream);
                }
                return th2;
            }

            public void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] INSTALL %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
            }

            public void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] RESET %s on %s%n", new Object[]{resettableClassFileTransformer, instrumentation});
            }

            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR_WARMUP %s on %s%n", new Object[]{resettableClassFileTransformer, cls});
                    th2.printStackTrace(this.printStream);
                }
            }
        }

        void onAfterWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer, boolean z11);

        void onBeforeInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer);

        Throwable onError(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2);

        void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th2);
    }

    public enum LambdaInstrumentationStrategy {
        ENABLED {
            public void b(ByteBuddy byteBuddy, Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                if (LambdaFactory.register(classFileTransformer, new LambdaInstanceFactory(byteBuddy))) {
                    try {
                        Class<?> cls = Class.forName("java.lang.invoke.LambdaMetafactory");
                        byteBuddy.with((Implementation.Context.Factory) Implementation.Context.Disabled.Factory.INSTANCE).redefine(cls).visit(new AsmVisitorWrapper.ForDeclaredMethods().method((ElementMatcher<? super MethodDescription>) ElementMatchers.named("metafactory"), MetaFactoryRedirection.INSTANCE).method((ElementMatcher<? super MethodDescription>) ElementMatchers.named("altMetafactory"), AlternativeMetaFactoryRedirection.INSTANCE)).make().load(cls.getClassLoader(), ClassReloadingStrategy.of(instrumentation));
                    } catch (ClassNotFoundException unused) {
                    }
                }
            }

            public boolean c(Class<?> cls) {
                return true;
            }
        },
        DISABLED {
            public void b(ByteBuddy byteBuddy, Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
            }

            public boolean c(Class<?> cls) {
                return cls == null || !cls.getName().contains("/");
            }
        };
        
        /* access modifiers changed from: private */
        public static final String UNSAFE_CLASS = null;

        /* renamed from: b  reason: collision with root package name */
        public static final MethodVisitor f26968b = null;

        public enum AlternativeMetaFactoryRedirection implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
            INSTANCE;

            public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
                MethodVisitor methodVisitor2 = methodVisitor;
                methodVisitor.visitCode();
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitInsn(6);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitTypeInsn(192, "java/lang/Integer");
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
                methodVisitor2.visitVarInsn(54, 4);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitVarInsn(54, 5);
                methodVisitor2.visitVarInsn(21, 4);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitInsn(126);
                Label label = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitVarInsn(21, 5);
                methodVisitor2.visitIincInsn(5, 1);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitTypeInsn(192, "java/lang/Integer");
                MethodVisitor methodVisitor3 = methodVisitor;
                Label label2 = label;
                methodVisitor3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
                methodVisitor2.visitVarInsn(54, 7);
                methodVisitor2.visitVarInsn(21, 7);
                methodVisitor2.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                methodVisitor2.visitVarInsn(58, 6);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitVarInsn(21, 5);
                methodVisitor2.visitVarInsn(25, 6);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitVarInsn(21, 7);
                String str = TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME;
                methodVisitor3.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
                methodVisitor2.visitVarInsn(21, 5);
                methodVisitor2.visitVarInsn(21, 7);
                methodVisitor2.visitInsn(96);
                methodVisitor2.visitVarInsn(54, 5);
                Label label3 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label3);
                methodVisitor2.visitLabel(label2);
                Integer num = Opcodes.INTEGER;
                methodVisitor.visitFrame(1, 2, new Object[]{num, num}, 0, (Object[]) null);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitTypeInsn(189, str);
                methodVisitor2.visitVarInsn(58, 6);
                methodVisitor2.visitLabel(label3);
                methodVisitor.visitFrame(1, 1, new Object[]{"[Ljava/lang/Class;"}, 0, (Object[]) null);
                methodVisitor2.visitVarInsn(21, 4);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitInsn(126);
                Label label4 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label4);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitVarInsn(21, 5);
                methodVisitor2.visitIincInsn(5, 1);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitTypeInsn(192, "java/lang/Integer");
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
                methodVisitor2.visitVarInsn(54, 8);
                methodVisitor2.visitVarInsn(21, 8);
                methodVisitor2.visitTypeInsn(189, "java/lang/invoke/MethodType");
                methodVisitor2.visitVarInsn(58, 7);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitVarInsn(21, 5);
                methodVisitor2.visitVarInsn(25, 7);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitVarInsn(21, 8);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
                Label label5 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
                methodVisitor2.visitLabel(label4);
                methodVisitor.visitFrame(3, 0, (Object[]) null, 0, (Object[]) null);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitTypeInsn(189, "java/lang/invoke/MethodType");
                methodVisitor2.visitVarInsn(58, 7);
                methodVisitor2.visitLabel(label5);
                methodVisitor.visitFrame(1, 1, new Object[]{"[Ljava/lang/invoke/MethodType;"}, 0, (Object[]) null);
                String a11 = LambdaInstrumentationStrategy.UNSAFE_CLASS;
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, a11, "getUnsafe", "()L" + LambdaInstrumentationStrategy.UNSAFE_CLASS + TypesAliasesKt.separator, false);
                methodVisitor2.visitVarInsn(58, 8);
                methodVisitor2.visitVarInsn(25, 8);
                methodVisitor2.visitVarInsn(25, 0);
                MethodVisitor methodVisitor4 = methodVisitor;
                methodVisitor4.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
                methodVisitor4.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/ClassLoader", "getSystemClassLoader", "()Ljava/lang/ClassLoader;", false);
                methodVisitor2.visitLdcInsn("net.bytebuddy.agent.builder.LambdaFactory");
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/ClassLoader", "loadClass", "(Ljava/lang/String;)Ljava/lang/Class;", false);
                methodVisitor2.visitLdcInsn(TypeProxy.REFLECTION_METHOD);
                methodVisitor2.visitIntInsn(16, 9);
                methodVisitor2.visitTypeInsn(189, str);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitLdcInsn(Type.getType("Ljava/lang/String;"));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(6);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(8);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 6);
                methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 7);
                methodVisitor2.visitLdcInsn(Type.getType("Ljava/util/List;"));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 8);
                methodVisitor2.visitLdcInsn(Type.getType("Ljava/util/List;"));
                methodVisitor2.visitInsn(83);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME, "getDeclaredMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
                methodVisitor2.visitInsn(1);
                methodVisitor2.visitIntInsn(16, 9);
                methodVisitor2.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(6);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(8);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 6);
                methodVisitor2.visitVarInsn(21, 4);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitInsn(126);
                Label label6 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label6);
                methodVisitor2.visitInsn(4);
                Label label7 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label7);
                methodVisitor2.visitLabel(label6);
                Object[] objArr = {"java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "[Ljava/lang/Object;", num, num, "[Ljava/lang/Class;", "[Ljava/lang/invoke/MethodType;", LambdaInstrumentationStrategy.UNSAFE_CLASS};
                Integer num2 = Opcodes.NULL;
                methodVisitor.visitFrame(0, 9, objArr, 7, new Object[]{LambdaInstrumentationStrategy.UNSAFE_CLASS, str, "java/lang/reflect/Method", num2, "[Ljava/lang/Object;", "[Ljava/lang/Object;", num});
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitLabel(label7);
                MethodVisitor methodVisitor5 = methodVisitor;
                methodVisitor5.visitFrame(0, 9, new Object[]{"java/lang/invoke/MethodHandles$Lookup", "java/lang/String", "java/lang/invoke/MethodType", "[Ljava/lang/Object;", num, num, "[Ljava/lang/Class;", "[Ljava/lang/invoke/MethodType;", LambdaInstrumentationStrategy.UNSAFE_CLASS}, 8, new Object[]{LambdaInstrumentationStrategy.UNSAFE_CLASS, str, "java/lang/reflect/Method", num2, "[Ljava/lang/Object;", "[Ljava/lang/Object;", num, num});
                methodVisitor5.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 7);
                methodVisitor2.visitVarInsn(25, 6);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "asList", "([Ljava/lang/Object;)Ljava/util/List;", false);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 8);
                methodVisitor2.visitVarInsn(25, 7);
                MethodVisitor methodVisitor6 = methodVisitor;
                methodVisitor6.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Arrays", "asList", "([Ljava/lang/Object;)Ljava/util/List;", false);
                methodVisitor2.visitInsn(83);
                methodVisitor6.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
                methodVisitor2.visitTypeInsn(192, "[B");
                methodVisitor2.visitInsn(1);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, LambdaInstrumentationStrategy.UNSAFE_CLASS, "defineAnonymousClass", "(Ljava/lang/Class;[B[Ljava/lang/Object;)Ljava/lang/Class;", false);
                methodVisitor2.visitVarInsn(58, 9);
                methodVisitor2.visitVarInsn(25, 8);
                methodVisitor2.visitVarInsn(25, 9);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, LambdaInstrumentationStrategy.UNSAFE_CLASS, "ensureClassInitialized", "(Ljava/lang/Class;)V", false);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodType", "parameterCount", "()I", false);
                Label label8 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.IFNE, label8);
                methodVisitor2.visitTypeInsn(Opcodes.NEW, "java/lang/invoke/ConstantCallSite");
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodType", "returnType", "()Ljava/lang/Class;", false);
                methodVisitor2.visitVarInsn(25, 9);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME, "getDeclaredConstructors", "()[Ljava/lang/reflect/Constructor;", false);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                MethodVisitor methodVisitor7 = methodVisitor;
                methodVisitor7.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CONSTRUCTOR_INTERNAL_NAME, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_DESCRIPTOR, false);
                methodVisitor7.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/invoke/MethodHandles", "constant", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/invoke/MethodHandle;", false);
                methodVisitor7.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/invoke/ConstantCallSite", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                Label label9 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label9);
                methodVisitor2.visitLabel(label8);
                methodVisitor.visitFrame(1, 1, new Object[]{str}, 0, (Object[]) null);
                methodVisitor2.visitTypeInsn(Opcodes.NEW, "java/lang/invoke/ConstantCallSite");
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/invoke/MethodHandles$Lookup", "IMPL_LOOKUP", "Ljava/lang/invoke/MethodHandles$Lookup;");
                methodVisitor2.visitVarInsn(25, 9);
                methodVisitor2.visitLdcInsn("get$Lambda");
                methodVisitor2.visitVarInsn(25, 2);
                MethodVisitor methodVisitor8 = methodVisitor;
                methodVisitor8.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false);
                methodVisitor8.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/invoke/ConstantCallSite", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                methodVisitor2.visitLabel(label9);
                methodVisitor.visitFrame(4, 0, (Object[]) null, 1, new Object[]{"java/lang/invoke/CallSite"});
                methodVisitor2.visitInsn(Opcodes.ARETURN);
                methodVisitor2.visitMaxs(9, 10);
                methodVisitor.visitEnd();
                return LambdaInstrumentationStrategy.f26968b;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class LambdaInstanceFactory {
            private static final String FIELD_PREFIX = "arg$";
            private static final String LAMBDA_FACTORY = "get$Lambda";
            private static final AtomicInteger LAMBDA_NAME_COUNTER = null;
            private static final String LAMBDA_TYPE_INFIX = "$$Lambda$ByteBuddy$";
            private static final Class<?> NOT_PREVIOUSLY_DEFINED = null;
            private final ByteBuddy byteBuddy;

            @HashCodeAndEqualsPlugin.Enhance
            public static class BridgeMethodImplementation implements Implementation {
                private final JavaConstant.MethodType lambdaMethod;
                private final String lambdaMethodName;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final Implementation.SpecialMethodInvocation bridgeTargetInvocation;

                    public Appender(Implementation.SpecialMethodInvocation specialMethodInvocation) {
                        this.bridgeTargetInvocation = specialMethodInvocation;
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        StackManipulation stackManipulation;
                        ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[1];
                        StackManipulation[] stackManipulationArr = new StackManipulation[4];
                        stackManipulationArr[0] = MethodVariableAccess.allArgumentsOf(methodDescription).asBridgeOf(this.bridgeTargetInvocation.getMethodDescription()).prependThisReference();
                        Implementation.SpecialMethodInvocation specialMethodInvocation = this.bridgeTargetInvocation;
                        stackManipulationArr[1] = specialMethodInvocation;
                        if (specialMethodInvocation.getMethodDescription().getReturnType().asErasure().isAssignableTo(methodDescription.getReturnType().asErasure())) {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        } else {
                            stackManipulation = TypeCasting.to(methodDescription.getReceiverType());
                        }
                        stackManipulationArr[2] = stackManipulation;
                        stackManipulationArr[3] = MethodReturn.of(methodDescription.getReturnType());
                        byteCodeAppenderArr[0] = new ByteCodeAppender.Simple(stackManipulationArr);
                        return new ByteCodeAppender.Compound(byteCodeAppenderArr).apply(methodVisitor, context, methodDescription);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.bridgeTargetInvocation.equals(((Appender) obj).bridgeTargetInvocation);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.bridgeTargetInvocation.hashCode();
                    }
                }

                public BridgeMethodImplementation(String str, JavaConstant.MethodType methodType) {
                    this.lambdaMethodName = str;
                    this.lambdaMethod = methodType;
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.invokeSuper(new MethodDescription.SignatureToken(this.lambdaMethodName, this.lambdaMethod.getReturnType(), (List<? extends TypeDescription>) this.lambdaMethod.getParameterTypes())));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    BridgeMethodImplementation bridgeMethodImplementation = (BridgeMethodImplementation) obj;
                    return this.lambdaMethodName.equals(bridgeMethodImplementation.lambdaMethodName) && this.lambdaMethod.equals(bridgeMethodImplementation.lambdaMethod);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.lambdaMethodName.hashCode()) * 31) + this.lambdaMethod.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @SuppressFBWarnings(justification = "An enumeration does not serialize fields", value = {"SE_BAD_FIELD"})
            public enum ConstructorImplementation implements Implementation {
                INSTANCE;
                
                /* access modifiers changed from: private */
                public final MethodDescription.InDefinedShape objectConstructor;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final List<FieldDescription.InDefinedShape> declaredFields;

                    public Appender(List<FieldDescription.InDefinedShape> list) {
                        this.declaredFields = list;
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        ArrayList arrayList = new ArrayList(this.declaredFields.size() * 3);
                        java.util.Iterator<E> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            arrayList.add(MethodVariableAccess.loadThis());
                            arrayList.add(MethodVariableAccess.load(parameterDescription));
                            arrayList.add(FieldAccess.forField(this.declaredFields.get(parameterDescription.getIndex())).write());
                        }
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(ConstructorImplementation.INSTANCE.objectConstructor), new StackManipulation.Compound((List<? extends StackManipulation>) arrayList), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.declaredFields.equals(((Appender) obj).declaredFields);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.declaredFields.hashCode();
                    }
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.getInstrumentedType().getDeclaredFields());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            public enum FactoryImplementation implements Implementation {
                INSTANCE;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final TypeDescription instrumentedType;

                    public Appender(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(TypeCreation.of(this.instrumentedType), Duplication.SINGLE, MethodVariableAccess.allArgumentsOf(methodDescription), MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) this.instrumentedType.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly()), MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
                    }
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.getInstrumentedType());
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class LambdaMethodImplementation implements Implementation {
                private final JavaConstant.MethodType specializedLambdaMethod;
                private final JavaConstant.MethodHandle targetMethod;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final List<FieldDescription.InDefinedShape> declaredFields;
                    private final JavaConstant.MethodType specializedLambdaMethod;
                    private final MethodDescription targetMethod;

                    public Appender(MethodDescription methodDescription, JavaConstant.MethodType methodType, List<FieldDescription.InDefinedShape> list) {
                        this.targetMethod = methodDescription;
                        this.specializedLambdaMethod = methodType;
                        this.declaredFields = list;
                    }

                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        StackManipulation stackManipulation;
                        TypeDescription.Generic generic;
                        if (this.targetMethod.isConstructor()) {
                            stackManipulation = new StackManipulation.Compound(TypeCreation.of(this.targetMethod.getDeclaringType().asErasure()), Duplication.SINGLE);
                        } else {
                            stackManipulation = StackManipulation.Trivial.INSTANCE;
                        }
                        ArrayList arrayList = new ArrayList((this.declaredFields.size() * 2) + 1);
                        for (FieldDescription.InDefinedShape forField : this.declaredFields) {
                            arrayList.add(MethodVariableAccess.loadThis());
                            arrayList.add(FieldAccess.forField(forField).read());
                        }
                        ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size() * 2);
                        java.util.Iterator<E> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            arrayList2.add(MethodVariableAccess.load(parameterDescription));
                            arrayList2.add(Assigner.DEFAULT.assign(parameterDescription.getType(), ((TypeDescription) this.specializedLambdaMethod.getParameterTypes().get(parameterDescription.getIndex())).asGenericType(), Assigner.Typing.DYNAMIC));
                        }
                        StackManipulation[] stackManipulationArr = new StackManipulation[6];
                        stackManipulationArr[0] = stackManipulation;
                        stackManipulationArr[1] = new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
                        stackManipulationArr[2] = new StackManipulation.Compound((List<? extends StackManipulation>) arrayList2);
                        stackManipulationArr[3] = MethodInvocation.invoke(this.targetMethod);
                        Assigner assigner = Assigner.DEFAULT;
                        if (this.targetMethod.isConstructor()) {
                            generic = this.targetMethod.getDeclaringType().asGenericType();
                        } else {
                            generic = this.targetMethod.getReturnType();
                        }
                        stackManipulationArr[4] = assigner.assign(generic, this.specializedLambdaMethod.getReturnType().asGenericType(), Assigner.Typing.DYNAMIC);
                        stackManipulationArr[5] = MethodReturn.of(this.specializedLambdaMethod.getReturnType());
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Appender appender = (Appender) obj;
                        return this.targetMethod.equals(appender.targetMethod) && this.specializedLambdaMethod.equals(appender.specializedLambdaMethod) && this.declaredFields.equals(appender.declaredFields);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.targetMethod.hashCode()) * 31) + this.specializedLambdaMethod.hashCode()) * 31) + this.declaredFields.hashCode();
                    }
                }

                public LambdaMethodImplementation(JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType) {
                    this.targetMethod = methodHandle;
                    this.specializedLambdaMethod = methodType;
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender((MethodDescription) ((MethodList) this.targetMethod.getOwnerType().getDeclaredMethods().filter(ElementMatchers.hasMethodName(this.targetMethod.getName()).and(ElementMatchers.returns(this.targetMethod.getReturnType())).and(ElementMatchers.takesArguments((Iterable<? extends TypeDescription>) this.targetMethod.getParameterTypes())))).getOnly(), this.specializedLambdaMethod, target.getInstrumentedType().getDeclaredFields());
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    LambdaMethodImplementation lambdaMethodImplementation = (LambdaMethodImplementation) obj;
                    return this.targetMethod.equals(lambdaMethodImplementation.targetMethod) && this.specializedLambdaMethod.equals(lambdaMethodImplementation.specializedLambdaMethod);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.targetMethod.hashCode()) * 31) + this.specializedLambdaMethod.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class SerializationImplementation implements Implementation {
                private final JavaConstant.MethodType lambdaMethod;
                private final String lambdaMethodName;
                private final TypeDescription lambdaType;
                private final JavaConstant.MethodType specializedMethod;
                private final JavaConstant.MethodHandle targetMethod;
                private final TypeDescription targetType;

                public SerializationImplementation(TypeDescription typeDescription, TypeDescription typeDescription2, String str, JavaConstant.MethodType methodType, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType2) {
                    this.targetType = typeDescription;
                    this.lambdaType = typeDescription2;
                    this.lambdaMethodName = str;
                    this.lambdaMethod = methodType;
                    this.targetMethod = methodHandle;
                    this.specializedMethod = methodType2;
                }

                public ByteCodeAppender appender(Implementation.Target target) {
                    try {
                        TypeDescription of2 = TypeDescription.ForLoadedType.of(Class.forName("java.lang.invoke.SerializedLambda"));
                        ArrayList arrayList = new ArrayList(target.getInstrumentedType().getDeclaredFields().size());
                        for (FieldDescription.InDefinedShape inDefinedShape : target.getInstrumentedType().getDeclaredFields()) {
                            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.loadThis(), FieldAccess.forField(inDefinedShape).read(), Assigner.DEFAULT.assign(inDefinedShape.getType(), TypeDescription.Generic.OBJECT, Assigner.Typing.STATIC)));
                        }
                        return new ByteCodeAppender.Simple(new StackManipulation.Compound(TypeCreation.of(of2), Duplication.SINGLE, ClassConstant.of(this.targetType), new TextConstant(this.lambdaType.getInternalName()), new TextConstant(this.lambdaMethodName), new TextConstant(this.lambdaMethod.getDescriptor()), IntegerConstant.forValue(this.targetMethod.getHandleType().getIdentifier()), new TextConstant(this.targetMethod.getOwnerType().getInternalName()), new TextConstant(this.targetMethod.getName()), new TextConstant(this.targetMethod.getDescriptor()), new TextConstant(this.specializedMethod.getDescriptor()), ArrayFactory.forType(TypeDescription.Generic.OBJECT).withValues(arrayList), MethodInvocation.invoke((MethodDescription.InDefinedShape) ((MethodList) of2.getDeclaredMethods().filter(ElementMatchers.isConstructor())).getOnly()), MethodReturn.REFERENCE));
                    } catch (ClassNotFoundException e11) {
                        throw new IllegalStateException("Cannot find class for lambda serialization", e11);
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    SerializationImplementation serializationImplementation = (SerializationImplementation) obj;
                    return this.lambdaMethodName.equals(serializationImplementation.lambdaMethodName) && this.targetType.equals(serializationImplementation.targetType) && this.lambdaType.equals(serializationImplementation.lambdaType) && this.lambdaMethod.equals(serializationImplementation.lambdaMethod) && this.targetMethod.equals(serializationImplementation.targetMethod) && this.specializedMethod.equals(serializationImplementation.specializedMethod);
                }

                public int hashCode() {
                    return (((((((((((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.lambdaType.hashCode()) * 31) + this.lambdaMethodName.hashCode()) * 31) + this.lambdaMethod.hashCode()) * 31) + this.targetMethod.hashCode()) * 31) + this.specializedMethod.hashCode();
                }

                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            static {
                LAMBDA_NAME_COUNTER = new AtomicInteger();
            }

            public LambdaInstanceFactory(ByteBuddy byteBuddy2) {
                this.byteBuddy = byteBuddy2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.byteBuddy.equals(((LambdaInstanceFactory) obj).byteBuddy);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.byteBuddy.hashCode();
            }

            public byte[] make(Object obj, String str, Object obj2, Object obj3, Object obj4, Object obj5, boolean z11, List<Class<?>> list, List<?> list2, Collection<? extends ClassFileTransformer> collection) {
                char c11;
                String str2 = str;
                List<Class<?>> list3 = list;
                JavaConstant.MethodType ofLoaded = JavaConstant.MethodType.ofLoaded(obj2);
                JavaConstant.MethodType ofLoaded2 = JavaConstant.MethodType.ofLoaded(obj3);
                JavaConstant.MethodHandle ofLoaded3 = JavaConstant.MethodHandle.ofLoaded(obj4, obj);
                JavaConstant.MethodType ofLoaded4 = JavaConstant.MethodType.ofLoaded(obj5);
                Class<?> lookupType = JavaConstant.MethodHandle.lookupType(obj);
                String str3 = lookupType.getName() + LAMBDA_TYPE_INFIX + LAMBDA_NAME_COUNTER.incrementAndGet();
                DynamicType.Builder<?> subclass = this.byteBuddy.subclass((TypeDefinition) ofLoaded.getReturnType(), (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS);
                boolean z12 = false;
                Visibility visibility = Visibility.PUBLIC;
                DynamicType.Builder intercept = subclass.modifiers(TypeManifestation.FINAL, visibility).implement((List<? extends java.lang.reflect.Type>) list3).name(str3).defineConstructor(visibility).withParameters((Collection<? extends TypeDefinition>) ofLoaded.getParameterTypes()).intercept(ConstructorImplementation.INSTANCE).method(ElementMatchers.named(str).and(ElementMatchers.takesArguments((Iterable<? extends TypeDescription>) ofLoaded2.getParameterTypes())).and(ElementMatchers.returns(ofLoaded2.getReturnType()))).intercept(new LambdaMethodImplementation(ofLoaded3, ofLoaded4));
                int i11 = 0;
                for (TypeDescription defineField : ofLoaded.getParameterTypes()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(FIELD_PREFIX);
                    i11++;
                    sb2.append(i11);
                    intercept = intercept.defineField(sb2.toString(), (TypeDefinition) defineField, Visibility.PRIVATE, FieldManifestation.FINAL);
                    z12 = false;
                }
                char c12 = z12;
                if (!ofLoaded.getParameterTypes().isEmpty()) {
                    TypeDescription returnType = ofLoaded.getReturnType();
                    ModifierContributor.ForMethod[] forMethodArr = new ModifierContributor.ForMethod[2];
                    forMethodArr[c12] = Visibility.PRIVATE;
                    forMethodArr[1] = Ownership.STATIC;
                    intercept = intercept.defineMethod(LAMBDA_FACTORY, (TypeDefinition) returnType, forMethodArr).withParameters((Collection<? extends TypeDefinition>) ofLoaded.getParameterTypes()).intercept(FactoryImplementation.INSTANCE);
                }
                Class<Serializable> cls = Serializable.class;
                if (z11) {
                    if (!list3.contains(cls)) {
                        c11 = 0;
                        intercept = intercept.implement(cls);
                    } else {
                        c11 = 0;
                    }
                    ModifierContributor.ForMethod[] forMethodArr2 = new ModifierContributor.ForMethod[1];
                    forMethodArr2[c11] = Visibility.PRIVATE;
                    intercept = intercept.defineMethod("writeReplace", (java.lang.reflect.Type) Object.class, forMethodArr2).intercept(new SerializationImplementation(TypeDescription.ForLoadedType.of(lookupType), ofLoaded.getReturnType(), str, ofLoaded2, ofLoaded3, JavaConstant.MethodType.ofLoaded(obj5)));
                } else if (ofLoaded.getReturnType().isAssignableTo((Class<?>) cls)) {
                    Class cls2 = Void.TYPE;
                    Visibility visibility2 = Visibility.PRIVATE;
                    Class<NotSerializableException> cls3 = NotSerializableException.class;
                    intercept = intercept.defineMethod("readObject", (java.lang.reflect.Type) cls2, visibility2).withParameters(ObjectInputStream.class).throwing(cls3).intercept(ExceptionMethod.throwing((Class<? extends Throwable>) cls3, "Non-serializable lambda")).defineMethod("writeObject", (java.lang.reflect.Type) Void.TYPE, visibility2).withParameters(ObjectOutputStream.class).throwing(cls3).intercept(ExceptionMethod.throwing((Class<? extends Throwable>) cls3, "Non-serializable lambda"));
                }
                for (Object ofLoaded5 : list2) {
                    JavaConstant.MethodType ofLoaded6 = JavaConstant.MethodType.ofLoaded(ofLoaded5);
                    intercept = intercept.defineMethod(str2, (TypeDefinition) ofLoaded6.getReturnType(), MethodManifestation.BRIDGE, Visibility.PUBLIC).withParameters((Collection<? extends TypeDefinition>) ofLoaded6.getParameterTypes()).intercept(new BridgeMethodImplementation(str2, ofLoaded2));
                }
                byte[] bytes = intercept.make().getBytes();
                for (ClassFileTransformer transform : collection) {
                    try {
                        byte[] transform2 = transform.transform(lookupType.getClassLoader(), str3.replace('.', '/'), NOT_PREVIOUSLY_DEFINED, lookupType.getProtectionDomain(), bytes);
                        if (transform2 != null) {
                            bytes = transform2;
                        }
                    } catch (Throwable unused) {
                    }
                }
                return bytes;
            }
        }

        public enum MetaFactoryRedirection implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
            INSTANCE;

            public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
                MethodVisitor methodVisitor2 = methodVisitor;
                methodVisitor.visitCode();
                MethodVisitor methodVisitor3 = methodVisitor;
                methodVisitor3.visitMethodInsn(Opcodes.INVOKESTATIC, LambdaInstrumentationStrategy.UNSAFE_CLASS, "getUnsafe", "()L" + LambdaInstrumentationStrategy.UNSAFE_CLASS + TypesAliasesKt.separator, false);
                methodVisitor2.visitVarInsn(58, 6);
                methodVisitor2.visitVarInsn(25, 6);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "lookupClass", "()Ljava/lang/Class;", false);
                methodVisitor3.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/ClassLoader", "getSystemClassLoader", "()Ljava/lang/ClassLoader;", false);
                methodVisitor2.visitLdcInsn("net.bytebuddy.agent.builder.LambdaFactory");
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/ClassLoader", "loadClass", "(Ljava/lang/String;)Ljava/lang/Class;", false);
                methodVisitor2.visitLdcInsn(TypeProxy.REFLECTION_METHOD);
                methodVisitor2.visitIntInsn(16, 9);
                methodVisitor2.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitLdcInsn(Type.getType("Ljava/lang/String;"));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(6);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(8);
                methodVisitor2.visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 6);
                methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 7);
                methodVisitor2.visitLdcInsn(Type.getType("Ljava/util/List;"));
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 8);
                methodVisitor2.visitLdcInsn(Type.getType("Ljava/util/List;"));
                methodVisitor2.visitInsn(83);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME, "getDeclaredMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
                methodVisitor2.visitInsn(1);
                methodVisitor2.visitIntInsn(16, 9);
                methodVisitor2.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(4);
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(5);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(6);
                methodVisitor2.visitVarInsn(25, 3);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(7);
                methodVisitor2.visitVarInsn(25, 4);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitInsn(8);
                methodVisitor2.visitVarInsn(25, 5);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 6);
                methodVisitor2.visitInsn(3);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 7);
                MethodVisitor methodVisitor4 = methodVisitor;
                methodVisitor4.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Collections", "emptyList", "()Ljava/util/List;", false);
                methodVisitor2.visitInsn(83);
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitIntInsn(16, 8);
                methodVisitor4.visitMethodInsn(Opcodes.INVOKESTATIC, "java/util/Collections", "emptyList", "()Ljava/util/List;", false);
                methodVisitor2.visitInsn(83);
                methodVisitor4.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
                methodVisitor2.visitTypeInsn(192, "[B");
                methodVisitor2.visitInsn(1);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, LambdaInstrumentationStrategy.UNSAFE_CLASS, "defineAnonymousClass", "(Ljava/lang/Class;[B[Ljava/lang/Object;)Ljava/lang/Class;", false);
                methodVisitor2.visitVarInsn(58, 7);
                methodVisitor2.visitVarInsn(25, 6);
                methodVisitor2.visitVarInsn(25, 7);
                MethodVisitor methodVisitor5 = methodVisitor;
                methodVisitor5.visitMethodInsn(Opcodes.INVOKEVIRTUAL, LambdaInstrumentationStrategy.UNSAFE_CLASS, "ensureClassInitialized", "(Ljava/lang/Class;)V", false);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor5.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodType", "parameterCount", "()I", false);
                Label label = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.IFNE, label);
                methodVisitor2.visitTypeInsn(Opcodes.NEW, "java/lang/invoke/ConstantCallSite");
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodType", "returnType", "()Ljava/lang/Class;", false);
                methodVisitor2.visitVarInsn(25, 7);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME, "getDeclaredConstructors", "()[Ljava/lang/reflect/Constructor;", false);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitInsn(50);
                methodVisitor2.visitInsn(3);
                methodVisitor2.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                MethodVisitor methodVisitor6 = methodVisitor;
                methodVisitor6.visitMethodInsn(Opcodes.INVOKEVIRTUAL, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CONSTRUCTOR_INTERNAL_NAME, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_DESCRIPTOR, false);
                methodVisitor6.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/invoke/MethodHandles", "constant", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/invoke/MethodHandle;", false);
                methodVisitor6.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/invoke/ConstantCallSite", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                Label label2 = new Label();
                methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
                methodVisitor2.visitLabel(label);
                methodVisitor.visitFrame(1, 2, new Object[]{LambdaInstrumentationStrategy.UNSAFE_CLASS, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME}, 0, (Object[]) null);
                methodVisitor2.visitTypeInsn(Opcodes.NEW, "java/lang/invoke/ConstantCallSite");
                methodVisitor2.visitInsn(89);
                methodVisitor2.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/invoke/MethodHandles$Lookup", "IMPL_LOOKUP", "Ljava/lang/invoke/MethodHandles$Lookup;");
                methodVisitor2.visitVarInsn(25, 7);
                methodVisitor2.visitLdcInsn("get$Lambda");
                methodVisitor2.visitVarInsn(25, 2);
                MethodVisitor methodVisitor7 = methodVisitor;
                methodVisitor7.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/invoke/MethodHandles$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false);
                methodVisitor7.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/invoke/ConstantCallSite", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                methodVisitor2.visitLabel(label2);
                methodVisitor.visitFrame(4, 0, (Object[]) null, 1, new Object[]{"java/lang/invoke/CallSite"});
                methodVisitor2.visitInsn(Opcodes.ARETURN);
                methodVisitor2.visitMaxs(8, 8);
                methodVisitor.visitEnd();
                return LambdaInstrumentationStrategy.f26968b;
            }
        }

        public static LambdaInstrumentationStrategy of(boolean z11) {
            return z11 ? ENABLED : DISABLED;
        }

        public static void release(ClassFileTransformer classFileTransformer, Instrumentation instrumentation) {
            if (LambdaFactory.release(classFileTransformer)) {
                try {
                    ClassReloadingStrategy.of(instrumentation).reset(Class.forName("java.lang.invoke.LambdaMetafactory"));
                } catch (Exception e11) {
                    throw new IllegalStateException("Could not release lambda transformer", e11);
                }
            }
        }

        public abstract void b(ByteBuddy byteBuddy, Instrumentation instrumentation, ClassFileTransformer classFileTransformer);

        public abstract boolean c(Class<?> cls);

        public boolean isEnabled() {
            return this == ENABLED;
        }
    }

    public interface Listener {
        public static final boolean LOADED = true;

        public static abstract class Adapter implements Listener {
            public void onComplete(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
            }

            public void onDiscovery(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
            }

            public void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2) {
            }

            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
            }

            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements Listener {
            private final List<Listener> listeners;

            public Compound(Listener... listenerArr) {
                this((List<? extends Listener>) Arrays.asList(listenerArr));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.listeners.equals(((Compound) obj).listeners);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.listeners.hashCode();
            }

            public void onComplete(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                for (Listener onComplete : this.listeners) {
                    onComplete.onComplete(str, classLoader, javaModule, z11);
                }
            }

            public void onDiscovery(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                for (Listener onDiscovery : this.listeners) {
                    onDiscovery.onDiscovery(str, classLoader, javaModule, z11);
                }
            }

            public void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2) {
                for (Listener onError : this.listeners) {
                    onError.onError(str, classLoader, javaModule, z11, th2);
                }
            }

            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                for (Listener onIgnored : this.listeners) {
                    onIgnored.onIgnored(typeDescription, classLoader, javaModule, z11);
                }
            }

            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType) {
                for (Listener onTransformation : this.listeners) {
                    onTransformation.onTransformation(typeDescription, classLoader, javaModule, z11, dynamicType);
                }
            }

            public Compound(List<? extends Listener> list) {
                this.listeners = new ArrayList();
                for (Listener listener : list) {
                    if (listener instanceof Compound) {
                        this.listeners.addAll(((Compound) listener).listeners);
                    } else if (!(listener instanceof NoOp)) {
                        this.listeners.add(listener);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Filtering implements Listener {
            private final Listener delegate;
            private final ElementMatcher<? super String> matcher;

            public Filtering(ElementMatcher<? super String> elementMatcher, Listener listener) {
                this.matcher = elementMatcher;
                this.delegate = listener;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Filtering filtering = (Filtering) obj;
                return this.matcher.equals(filtering.matcher) && this.delegate.equals(filtering.delegate);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + this.delegate.hashCode();
            }

            public void onComplete(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                if (this.matcher.matches(str)) {
                    this.delegate.onComplete(str, classLoader, javaModule, z11);
                }
            }

            public void onDiscovery(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                if (this.matcher.matches(str)) {
                    this.delegate.onDiscovery(str, classLoader, javaModule, z11);
                }
            }

            public void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2) {
                if (this.matcher.matches(str)) {
                    this.delegate.onError(str, classLoader, javaModule, z11, th2);
                }
            }

            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                if (this.matcher.matches(typeDescription.getName())) {
                    this.delegate.onIgnored(typeDescription, classLoader, javaModule, z11);
                }
            }

            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType) {
                if (this.matcher.matches(typeDescription.getName())) {
                    this.delegate.onTransformation(typeDescription, classLoader, javaModule, z11, dynamicType);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ModuleReadEdgeCompleting extends Adapter {
            private final boolean addTargetEdge;
            private final Instrumentation instrumentation;
            private final Set<? extends JavaModule> modules;

            public ModuleReadEdgeCompleting(Instrumentation instrumentation2, boolean z11, Set<? extends JavaModule> set) {
                this.instrumentation = instrumentation2;
                this.addTargetEdge = z11;
                this.modules = set;
            }

            public static Listener of(Instrumentation instrumentation2, boolean z11, Class<?>... clsArr) {
                HashSet hashSet = new HashSet();
                for (Class<?> ofType : clsArr) {
                    hashSet.add(JavaModule.ofType(ofType));
                }
                if (hashSet.isEmpty()) {
                    return NoOp.INSTANCE;
                }
                return new ModuleReadEdgeCompleting(instrumentation2, z11, hashSet);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ModuleReadEdgeCompleting moduleReadEdgeCompleting = (ModuleReadEdgeCompleting) obj;
                return this.addTargetEdge == moduleReadEdgeCompleting.addTargetEdge && this.instrumentation.equals(moduleReadEdgeCompleting.instrumentation) && this.modules.equals(moduleReadEdgeCompleting.modules);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + (this.addTargetEdge ? 1 : 0)) * 31) + this.modules.hashCode();
            }

            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType) {
                Map map;
                if (javaModule != JavaModule.UNSUPPORTED && javaModule.isNamed()) {
                    for (JavaModule javaModule2 : this.modules) {
                        if (!javaModule.canRead(javaModule2) || (this.addTargetEdge && !javaModule.isOpened(typeDescription.getPackage(), javaModule2))) {
                            Instrumentation instrumentation2 = this.instrumentation;
                            Set singleton = Collections.singleton(javaModule2);
                            Map emptyMap = Collections.emptyMap();
                            if (!this.addTargetEdge || typeDescription.getPackage() == null) {
                                map = Collections.emptyMap();
                            } else {
                                map = Collections.singletonMap(typeDescription.getPackage().getName(), Collections.singleton(javaModule2));
                            }
                            ClassInjector.UsingInstrumentation.redefineModule(instrumentation2, javaModule, singleton, emptyMap, map, Collections.emptySet(), Collections.emptyMap());
                        }
                        if (this.addTargetEdge && !javaModule2.canRead(javaModule)) {
                            ClassInjector.UsingInstrumentation.redefineModule(this.instrumentation, javaModule2, Collections.singleton(javaModule), Collections.emptyMap(), Collections.emptyMap(), Collections.emptySet(), Collections.emptyMap());
                        }
                    }
                }
            }
        }

        public enum NoOp implements Listener {
            INSTANCE;

            public void onComplete(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
            }

            public void onDiscovery(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
            }

            public void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2) {
            }

            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
            }

            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType) {
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class StreamWriting implements Listener {
            private final PrintStream printStream;

            public StreamWriting(PrintStream printStream2) {
                this.printStream = printStream2;
            }

            public static StreamWriting toSystemError() {
                return new StreamWriting(System.err);
            }

            public static StreamWriting toSystemOut() {
                return new StreamWriting(System.out);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.printStream.equals(((StreamWriting) obj).printStream);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.printStream.hashCode();
            }

            public void onComplete(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                this.printStream.printf("[Byte Buddy] COMPLETE %s [%s, %s, %s, loaded=%b]%n", new Object[]{str, classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z11)});
            }

            public void onDiscovery(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                this.printStream.printf("[Byte Buddy] DISCOVERY %s [%s, %s, %s, loaded=%b]%n", new Object[]{str, classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z11)});
            }

            public void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR %s [%s, %s, %s, loaded=%b]%n", new Object[]{str, classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z11)});
                    th2.printStackTrace(this.printStream);
                }
            }

            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11) {
                this.printStream.printf("[Byte Buddy] IGNORE %s [%s, %s, %s, loaded=%b]%n", new Object[]{typeDescription.getName(), classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z11)});
            }

            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType) {
                this.printStream.printf("[Byte Buddy] TRANSFORM %s [%s, %s, %s, loaded=%b]%n", new Object[]{typeDescription.getName(), classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z11)});
            }

            public Listener withErrorsOnly() {
                return new WithErrorsOnly(this);
            }

            public Listener withTransformationsOnly() {
                return new WithTransformationsOnly(this);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class WithErrorsOnly extends Adapter {
            private final Listener delegate;

            public WithErrorsOnly(Listener listener) {
                this.delegate = listener;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((WithErrorsOnly) obj).delegate);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.delegate.hashCode();
            }

            public void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2) {
                this.delegate.onError(str, classLoader, javaModule, z11, th2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class WithTransformationsOnly extends Adapter {
            private final Listener delegate;

            public WithTransformationsOnly(Listener listener) {
                this.delegate = listener;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((WithTransformationsOnly) obj).delegate);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.delegate.hashCode();
            }

            public void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2) {
                this.delegate.onError(str, classLoader, javaModule, z11, th2);
            }

            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType) {
                this.delegate.onTransformation(typeDescription, classLoader, javaModule, z11, dynamicType);
            }
        }

        void onComplete(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11);

        void onDiscovery(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11);

        void onError(String str, ClassLoader classLoader, JavaModule javaModule, boolean z11, Throwable th2);

        void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11);

        void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean z11, DynamicType dynamicType);
    }

    public interface LocationStrategy {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements LocationStrategy {
            private final List<LocationStrategy> locationStrategies;

            public Compound(LocationStrategy... locationStrategyArr) {
                this((List<? extends LocationStrategy>) Arrays.asList(locationStrategyArr));
            }

            public ClassFileLocator classFileLocator(ClassLoader classLoader, JavaModule javaModule) {
                ArrayList arrayList = new ArrayList(this.locationStrategies.size());
                for (LocationStrategy classFileLocator : this.locationStrategies) {
                    arrayList.add(classFileLocator.classFileLocator(classLoader, javaModule));
                }
                return new ClassFileLocator.Compound((List<? extends ClassFileLocator>) arrayList);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.locationStrategies.equals(((Compound) obj).locationStrategies);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.locationStrategies.hashCode();
            }

            public Compound(List<? extends LocationStrategy> list) {
                this.locationStrategies = new ArrayList();
                for (LocationStrategy locationStrategy : list) {
                    if (locationStrategy instanceof Compound) {
                        this.locationStrategies.addAll(((Compound) locationStrategy).locationStrategies);
                    } else if (!(locationStrategy instanceof NoOp)) {
                        this.locationStrategies.add(locationStrategy);
                    }
                }
            }
        }

        public enum ForClassLoader implements LocationStrategy {
            STRONG {
                public ClassFileLocator classFileLocator(ClassLoader classLoader, JavaModule javaModule) {
                    return ClassFileLocator.ForClassLoader.of(classLoader);
                }
            },
            WEAK {
                public ClassFileLocator classFileLocator(ClassLoader classLoader, JavaModule javaModule) {
                    return ClassFileLocator.ForClassLoader.WeaklyReferenced.of(classLoader);
                }
            };

            public LocationStrategy withFallbackTo(ClassFileLocator... classFileLocatorArr) {
                return withFallbackTo((Collection<? extends ClassFileLocator>) Arrays.asList(classFileLocatorArr));
            }

            public LocationStrategy withFallbackTo(Collection<? extends ClassFileLocator> collection) {
                ArrayList arrayList = new ArrayList(collection.size());
                for (ClassFileLocator simple : collection) {
                    arrayList.add(new Simple(simple));
                }
                return withFallbackTo((List<? extends LocationStrategy>) arrayList);
            }

            public LocationStrategy withFallbackTo(LocationStrategy... locationStrategyArr) {
                return withFallbackTo((List<? extends LocationStrategy>) Arrays.asList(locationStrategyArr));
            }

            public LocationStrategy withFallbackTo(List<? extends LocationStrategy> list) {
                ArrayList arrayList = new ArrayList(list.size() + 1);
                arrayList.add(this);
                arrayList.addAll(list);
                return new Compound((List<? extends LocationStrategy>) arrayList);
            }
        }

        public enum NoOp implements LocationStrategy {
            INSTANCE;

            public ClassFileLocator classFileLocator(ClassLoader classLoader, JavaModule javaModule) {
                return ClassFileLocator.NoOp.INSTANCE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements LocationStrategy {
            private final ClassFileLocator classFileLocator;

            public Simple(ClassFileLocator classFileLocator2) {
                this.classFileLocator = classFileLocator2;
            }

            public ClassFileLocator classFileLocator(ClassLoader classLoader, JavaModule javaModule) {
                return this.classFileLocator;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileLocator.equals(((Simple) obj).classFileLocator);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.classFileLocator.hashCode();
            }
        }

        ClassFileLocator classFileLocator(ClassLoader classLoader, JavaModule javaModule);
    }

    public interface Matchable<T extends Matchable<T>> {
        T and(RawMatcher rawMatcher);

        T and(ElementMatcher<? super TypeDescription> elementMatcher);

        T and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

        T and(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

        T or(RawMatcher rawMatcher);

        T or(ElementMatcher<? super TypeDescription> elementMatcher);

        T or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

        T or(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);
    }

    public interface PoolStrategy {

        public enum ClassLoading implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);
            
            private final TypePool.Default.ReaderMode readerMode;

            private ClassLoading(TypePool.Default.ReaderMode readerMode2) {
                this.readerMode = readerMode2;
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader) {
                return TypePool.ClassLoading.of(classLoader, new TypePool.Default.WithLazyResolution(TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode));
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader, String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        public enum Default implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);
            
            private final TypePool.Default.ReaderMode readerMode;

            private Default(TypePool.Default.ReaderMode readerMode2) {
                this.readerMode = readerMode2;
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader) {
                return new TypePool.Default.WithLazyResolution(TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode);
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader, String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        public enum Eager implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);
            
            private final TypePool.Default.ReaderMode readerMode;

            private Eager(TypePool.Default.ReaderMode readerMode2) {
                this.readerMode = readerMode2;
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader) {
                return new TypePool.Default(TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode);
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader, String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class WithTypePoolCache implements PoolStrategy {

            /* renamed from: b  reason: collision with root package name */
            public final TypePool.Default.ReaderMode f26969b;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Simple extends WithTypePoolCache {
                private final ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> cacheProviders;

                public Simple(ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> concurrentMap) {
                    this(TypePool.Default.ReaderMode.FAST, concurrentMap);
                }

                public TypePool.CacheProvider a(ClassLoader classLoader) {
                    if (classLoader == null) {
                        classLoader = b();
                    }
                    TypePool.CacheProvider cacheProvider = this.cacheProviders.get(classLoader);
                    while (cacheProvider == null) {
                        cacheProvider = TypePool.CacheProvider.Simple.withObjectType();
                        TypePool.CacheProvider putIfAbsent = this.cacheProviders.putIfAbsent(classLoader, cacheProvider);
                        if (putIfAbsent != null) {
                            cacheProvider = putIfAbsent;
                        }
                    }
                    return cacheProvider;
                }

                public ClassLoader b() {
                    return ClassLoader.getSystemClassLoader();
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.cacheProviders.equals(((Simple) obj).cacheProviders);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.cacheProviders.hashCode();
                }

                public Simple(TypePool.Default.ReaderMode readerMode, ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> concurrentMap) {
                    super(readerMode);
                    this.cacheProviders = concurrentMap;
                }
            }

            public WithTypePoolCache(TypePool.Default.ReaderMode readerMode) {
                this.f26969b = readerMode;
            }

            public abstract TypePool.CacheProvider a(ClassLoader classLoader);

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.f26969b.equals(((WithTypePoolCache) obj).f26969b);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.f26969b.hashCode();
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader) {
                return new TypePool.Default.WithLazyResolution(a(classLoader), classFileLocator, this.f26969b);
            }

            public TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader, String str) {
                return new TypePool.Default.WithLazyResolution(new TypePool.CacheProvider.Discriminating(ElementMatchers.is((Object) str), new TypePool.CacheProvider.Simple(), a(classLoader)), classFileLocator, this.f26969b);
            }
        }

        TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader);

        TypePool typePool(ClassFileLocator classFileLocator, ClassLoader classLoader, String str);
    }

    public interface RawMatcher {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Conjunction implements RawMatcher {
            private final List<RawMatcher> matchers;

            public Conjunction(RawMatcher... rawMatcherArr) {
                this((List<? extends RawMatcher>) Arrays.asList(rawMatcherArr));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                for (RawMatcher matches : this.matchers) {
                    if (!matches.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return false;
                    }
                }
                return true;
            }

            public Conjunction(List<? extends RawMatcher> list) {
                this.matchers = new ArrayList(list.size());
                for (RawMatcher rawMatcher : list) {
                    if (rawMatcher instanceof Conjunction) {
                        this.matchers.addAll(((Conjunction) rawMatcher).matchers);
                    } else if (rawMatcher != Trivial.MATCHING) {
                        this.matchers.add(rawMatcher);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Disjunction implements RawMatcher {
            private final List<RawMatcher> matchers;

            public Disjunction(RawMatcher... rawMatcherArr) {
                this((List<? extends RawMatcher>) Arrays.asList(rawMatcherArr));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                for (RawMatcher matches : this.matchers) {
                    if (matches.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return true;
                    }
                }
                return false;
            }

            public Disjunction(List<? extends RawMatcher> list) {
                this.matchers = new ArrayList(list.size());
                for (RawMatcher rawMatcher : list) {
                    if (rawMatcher instanceof Disjunction) {
                        this.matchers.addAll(((Disjunction) rawMatcher).matchers);
                    } else if (rawMatcher != Trivial.NON_MATCHING) {
                        this.matchers.add(rawMatcher);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForElementMatchers implements RawMatcher {
            private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
            private final ElementMatcher<? super JavaModule> moduleMatcher;
            private final ElementMatcher<? super TypeDescription> typeMatcher;

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher) {
                this(elementMatcher, ElementMatchers.any());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                return this.typeMatcher.equals(forElementMatchers.typeMatcher) && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher) && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.typeMatcher.hashCode()) * 31) + this.classLoaderMatcher.hashCode()) * 31) + this.moduleMatcher.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                return this.moduleMatcher.matches(javaModule) && this.classLoaderMatcher.matches(classLoader) && this.typeMatcher.matches(typeDescription);
            }

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                this(elementMatcher, elementMatcher2, ElementMatchers.any());
            }

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                this.typeMatcher = elementMatcher;
                this.classLoaderMatcher = elementMatcher2;
                this.moduleMatcher = elementMatcher3;
            }
        }

        public enum ForLoadState implements RawMatcher {
            LOADED(false),
            UNLOADED(true);
            
            private final boolean unloaded;

            private ForLoadState(boolean z11) {
                this.unloaded = z11;
            }

            public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                return (cls == null) == this.unloaded;
            }
        }

        public enum ForResolvableTypes implements RawMatcher {
            INSTANCE;

            public RawMatcher inverted() {
                return new Inversion(this);
            }

            public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                if (cls == null) {
                    return true;
                }
                try {
                    return Class.forName(cls.getName(), true, classLoader) == cls;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Inversion implements RawMatcher {
            private final RawMatcher matcher;

            public Inversion(RawMatcher rawMatcher) {
                this.matcher = rawMatcher;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Inversion) obj).matcher);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matcher.hashCode();
            }

            public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                return !this.matcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain);
            }
        }

        public enum Trivial implements RawMatcher {
            MATCHING(true),
            NON_MATCHING(false);
            
            private final boolean matches;

            private Trivial(boolean z11) {
                this.matches = z11;
            }

            public boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
                return this.matches;
            }
        }

        boolean matches(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain);
    }

    public interface RedefinitionListenable extends AgentBuilder {

        public interface ResubmissionImmediateMatcher {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Conjunction implements ResubmissionImmediateMatcher {
                private final List<ResubmissionImmediateMatcher> matchers;

                public Conjunction(ResubmissionImmediateMatcher... resubmissionImmediateMatcherArr) {
                    this((List<? extends ResubmissionImmediateMatcher>) Arrays.asList(resubmissionImmediateMatcherArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(String str, ClassLoader classLoader, JavaModule javaModule) {
                    for (ResubmissionImmediateMatcher matches : this.matchers) {
                        if (!matches.matches(str, classLoader, javaModule)) {
                            return false;
                        }
                    }
                    return true;
                }

                public Conjunction(List<? extends ResubmissionImmediateMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionImmediateMatcher resubmissionImmediateMatcher : list) {
                        if (resubmissionImmediateMatcher instanceof Conjunction) {
                            this.matchers.addAll(((Conjunction) resubmissionImmediateMatcher).matchers);
                        } else if (resubmissionImmediateMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionImmediateMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Disjunction implements ResubmissionImmediateMatcher {
                private final List<ResubmissionImmediateMatcher> matchers;

                public Disjunction(ResubmissionImmediateMatcher... resubmissionImmediateMatcherArr) {
                    this((List<? extends ResubmissionImmediateMatcher>) Arrays.asList(resubmissionImmediateMatcherArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(String str, ClassLoader classLoader, JavaModule javaModule) {
                    for (ResubmissionImmediateMatcher matches : this.matchers) {
                        if (matches.matches(str, classLoader, javaModule)) {
                            return true;
                        }
                    }
                    return false;
                }

                public Disjunction(List<? extends ResubmissionImmediateMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionImmediateMatcher resubmissionImmediateMatcher : list) {
                        if (resubmissionImmediateMatcher instanceof Disjunction) {
                            this.matchers.addAll(((Disjunction) resubmissionImmediateMatcher).matchers);
                        } else if (resubmissionImmediateMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionImmediateMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForElementMatchers implements ResubmissionImmediateMatcher {
                private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
                private final ElementMatcher<? super JavaModule> moduleMatcher;
                private final ElementMatcher<String> typeNameMatcher;

                public ForElementMatchers(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3) {
                    this.typeNameMatcher = elementMatcher;
                    this.classLoaderMatcher = elementMatcher2;
                    this.moduleMatcher = elementMatcher3;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                    return this.typeNameMatcher.equals(forElementMatchers.typeNameMatcher) && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher) && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.typeNameMatcher.hashCode()) * 31) + this.classLoaderMatcher.hashCode()) * 31) + this.moduleMatcher.hashCode();
                }

                public boolean matches(String str, ClassLoader classLoader, JavaModule javaModule) {
                    if (!this.typeNameMatcher.matches(str) || !this.classLoaderMatcher.matches(classLoader) || !this.moduleMatcher.matches(javaModule)) {
                        return false;
                    }
                    return true;
                }
            }

            public enum Trivial implements ResubmissionImmediateMatcher {
                MATCHING(true),
                NON_MATCHING(false);
                
                private final boolean matching;

                private Trivial(boolean z11) {
                    this.matching = z11;
                }

                public boolean matches(String str, ClassLoader classLoader, JavaModule javaModule) {
                    return this.matching;
                }
            }

            boolean matches(String str, ClassLoader classLoader, JavaModule javaModule);
        }

        public interface ResubmissionOnErrorMatcher {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Conjunction implements ResubmissionOnErrorMatcher {
                private final List<ResubmissionOnErrorMatcher> matchers;

                public Conjunction(ResubmissionOnErrorMatcher... resubmissionOnErrorMatcherArr) {
                    this((List<? extends ResubmissionOnErrorMatcher>) Arrays.asList(resubmissionOnErrorMatcherArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(Throwable th2, String str, ClassLoader classLoader, JavaModule javaModule) {
                    for (ResubmissionOnErrorMatcher matches : this.matchers) {
                        if (!matches.matches(th2, str, classLoader, javaModule)) {
                            return false;
                        }
                    }
                    return true;
                }

                public Conjunction(List<? extends ResubmissionOnErrorMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionOnErrorMatcher resubmissionOnErrorMatcher : list) {
                        if (resubmissionOnErrorMatcher instanceof Conjunction) {
                            this.matchers.addAll(((Conjunction) resubmissionOnErrorMatcher).matchers);
                        } else if (resubmissionOnErrorMatcher != Trivial.MATCHING) {
                            this.matchers.add(resubmissionOnErrorMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Disjunction implements ResubmissionOnErrorMatcher {
                private final List<ResubmissionOnErrorMatcher> matchers;

                public Disjunction(ResubmissionOnErrorMatcher... resubmissionOnErrorMatcherArr) {
                    this((List<? extends ResubmissionOnErrorMatcher>) Arrays.asList(resubmissionOnErrorMatcherArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public boolean matches(Throwable th2, String str, ClassLoader classLoader, JavaModule javaModule) {
                    for (ResubmissionOnErrorMatcher matches : this.matchers) {
                        if (matches.matches(th2, str, classLoader, javaModule)) {
                            return true;
                        }
                    }
                    return false;
                }

                public Disjunction(List<? extends ResubmissionOnErrorMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionOnErrorMatcher resubmissionOnErrorMatcher : list) {
                        if (resubmissionOnErrorMatcher instanceof Disjunction) {
                            this.matchers.addAll(((Disjunction) resubmissionOnErrorMatcher).matchers);
                        } else if (resubmissionOnErrorMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionOnErrorMatcher);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForElementMatchers implements ResubmissionOnErrorMatcher {
                private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
                private final ElementMatcher<? super Throwable> exceptionMatcher;
                private final ElementMatcher<? super JavaModule> moduleMatcher;
                private final ElementMatcher<String> typeNameMatcher;

                public ForElementMatchers(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3, ElementMatcher<? super JavaModule> elementMatcher4) {
                    this.exceptionMatcher = elementMatcher;
                    this.typeNameMatcher = elementMatcher2;
                    this.classLoaderMatcher = elementMatcher3;
                    this.moduleMatcher = elementMatcher4;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                    return this.exceptionMatcher.equals(forElementMatchers.exceptionMatcher) && this.typeNameMatcher.equals(forElementMatchers.typeNameMatcher) && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher) && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.exceptionMatcher.hashCode()) * 31) + this.typeNameMatcher.hashCode()) * 31) + this.classLoaderMatcher.hashCode()) * 31) + this.moduleMatcher.hashCode();
                }

                public boolean matches(Throwable th2, String str, ClassLoader classLoader, JavaModule javaModule) {
                    if (!this.exceptionMatcher.matches(th2) || !this.typeNameMatcher.matches(str) || !this.classLoaderMatcher.matches(classLoader) || !this.moduleMatcher.matches(javaModule)) {
                        return false;
                    }
                    return true;
                }
            }

            public enum Trivial implements ResubmissionOnErrorMatcher {
                MATCHING(true),
                NON_MATCHING(false);
                
                private final boolean matching;

                private Trivial(boolean z11) {
                    this.matching = z11;
                }

                public boolean matches(Throwable th2, String str, ClassLoader classLoader, JavaModule javaModule) {
                    return this.matching;
                }
            }

            boolean matches(Throwable th2, String str, ClassLoader classLoader, JavaModule javaModule);
        }

        public interface WithImplicitDiscoveryStrategy extends RedefinitionListenable {
            RedefinitionListenable redefineOnly(Class<?>... clsArr);

            RedefinitionListenable with(RedefinitionStrategy.DiscoveryStrategy discoveryStrategy);
        }

        public interface WithResubmissionSpecification extends WithoutResubmissionSpecification, AgentBuilder {
        }

        public interface WithoutBatchStrategy extends WithImplicitDiscoveryStrategy {
            WithImplicitDiscoveryStrategy with(RedefinitionStrategy.BatchAllocator batchAllocator);
        }

        public interface WithoutResubmissionSpecification {
            WithResubmissionSpecification resubmitImmediate();

            WithResubmissionSpecification resubmitImmediate(ResubmissionImmediateMatcher resubmissionImmediateMatcher);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

            WithResubmissionSpecification resubmitOnError();

            WithResubmissionSpecification resubmitOnError(ResubmissionOnErrorMatcher resubmissionOnErrorMatcher);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3, ElementMatcher<? super JavaModule> elementMatcher4);
        }

        RedefinitionListenable with(RedefinitionStrategy.Listener listener);

        WithoutResubmissionSpecification withResubmission(RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler);
    }

    public enum RedefinitionStrategy {
        DISABLED(false, false) {
            public void a(Instrumentation instrumentation) {
                throw new IllegalStateException("Cannot apply redefinition on disabled strategy");
            }

            public void apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, DiscoveryStrategy discoveryStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, Listener listener, Listener listener2, RawMatcher rawMatcher, BatchAllocator batchAllocator, CircularityLock circularityLock) {
            }

            public Collector d(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock) {
                throw new IllegalStateException("A disabled redefinition strategy cannot create a collector");
            }
        },
        REDEFINITION(true, false) {
            public void a(Instrumentation instrumentation) {
                if (!instrumentation.isRedefineClassesSupported()) {
                    throw new IllegalStateException("Cannot apply redefinition on " + instrumentation);
                }
            }

            public Collector d(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock) {
                return new Collector.ForRedefinition(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
            }
        },
        RETRANSFORMATION(true, true) {
            public void a(Instrumentation instrumentation) {
                if (!RedefinitionStrategy.f26970b.isRetransformClassesSupported(instrumentation)) {
                    throw new IllegalStateException("Cannot apply retransformation on " + instrumentation);
                }
            }

            public Collector d(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock) {
                return new Collector.ForRetransformation(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
            }
        };
        

        /* renamed from: b  reason: collision with root package name */
        public static final Dispatcher f26970b = null;
        private final boolean enabled;
        private final boolean retransforming;

        public interface BatchAllocator {
            public static final int FIRST_BATCH = 0;

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFixedSize implements BatchAllocator {
                private final int size;

                public ForFixedSize(int i11) {
                    this.size = i11;
                }

                public static BatchAllocator ofSize(int i11) {
                    if (i11 > 0) {
                        return new ForFixedSize(i11);
                    }
                    if (i11 == 0) {
                        return ForTotal.INSTANCE;
                    }
                    throw new IllegalArgumentException("Cannot define a batch with a negative size: " + i11);
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    ArrayList arrayList = new ArrayList();
                    int i11 = 0;
                    while (i11 < list.size()) {
                        arrayList.add(new ArrayList(list.subList(i11, Math.min(list.size(), this.size + i11))));
                        i11 += this.size;
                    }
                    return arrayList;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.size == ((ForFixedSize) obj).size;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.size;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForMatchedGrouping implements BatchAllocator {
                private final Collection<? extends ElementMatcher<? super TypeDescription>> matchers;

                public ForMatchedGrouping(ElementMatcher<? super TypeDescription>... elementMatcherArr) {
                    this((Collection<? extends ElementMatcher<? super TypeDescription>>) new LinkedHashSet(Arrays.asList(elementMatcherArr)));
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ArrayList arrayList = new ArrayList();
                    for (ElementMatcher put : this.matchers) {
                        linkedHashMap.put(put, new ArrayList());
                    }
                    for (Class next : list) {
                        java.util.Iterator<? extends ElementMatcher<? super TypeDescription>> it = this.matchers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                arrayList.add(next);
                                break;
                            }
                            ElementMatcher elementMatcher = (ElementMatcher) it.next();
                            if (elementMatcher.matches(TypeDescription.ForLoadedType.of(next))) {
                                ((List) linkedHashMap.get(elementMatcher)).add(next);
                                break;
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(this.matchers.size() + 1);
                    for (List list2 : linkedHashMap.values()) {
                        if (!list2.isEmpty()) {
                            arrayList2.add(list2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        arrayList2.add(arrayList);
                    }
                    return arrayList2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matchers.equals(((ForMatchedGrouping) obj).matchers);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matchers.hashCode();
                }

                public BatchAllocator withMaximum(int i11) {
                    return Slicing.withMaximum(i11, this);
                }

                public BatchAllocator withMinimum(int i11) {
                    return Slicing.withMinimum(i11, this);
                }

                public BatchAllocator withinRange(int i11, int i12) {
                    return Slicing.withinRange(i11, i12, this);
                }

                public ForMatchedGrouping(Collection<? extends ElementMatcher<? super TypeDescription>> collection) {
                    this.matchers = collection;
                }
            }

            public enum ForTotal implements BatchAllocator {
                INSTANCE;

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    if (list.isEmpty()) {
                        return Collections.emptySet();
                    }
                    return Collections.singleton(list);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Partitioning implements BatchAllocator {
                private final int parts;

                public Partitioning(int i11) {
                    this.parts = i11;
                }

                public static BatchAllocator of(int i11) {
                    if (i11 >= 1) {
                        return new Partitioning(i11);
                    }
                    throw new IllegalArgumentException("A batch size must be positive: " + i11);
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    if (list.isEmpty()) {
                        return Collections.emptyList();
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = list.size() / this.parts;
                    int size2 = list.size() % this.parts;
                    int i11 = size2;
                    while (i11 < list.size()) {
                        int i12 = i11 + size;
                        arrayList.add(new ArrayList(list.subList(i11, i12)));
                        i11 = i12;
                    }
                    if (arrayList.isEmpty()) {
                        return Collections.singletonList(list);
                    }
                    ((List) arrayList.get(0)).addAll(0, list.subList(0, size2));
                    return arrayList;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parts == ((Partitioning) obj).parts;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.parts;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Slicing implements BatchAllocator {
                private final BatchAllocator batchAllocator;
                private final int maximum;
                private final int minimum;

                public static class SlicingIterable implements Iterable<List<Class<?>>> {
                    private final Iterable<? extends List<Class<?>>> iterable;
                    private final int maximum;
                    private final int minimum;

                    public static class SlicingIterator implements java.util.Iterator<List<Class<?>>>, j$.util.Iterator {
                        private List<Class<?>> buffer;
                        private final java.util.Iterator<? extends List<Class<?>>> iterator;
                        private final int maximum;
                        private final int minimum;

                        public SlicingIterator(int i11, int i12, java.util.Iterator<? extends List<Class<?>>> it) {
                            this.minimum = i11;
                            this.maximum = i12;
                            this.iterator = it;
                            this.buffer = new ArrayList();
                        }

                        public /* synthetic */ void forEachRemaining(Consumer consumer) {
                            Iterator.CC.$default$forEachRemaining(this, consumer);
                        }

                        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                        }

                        public boolean hasNext() {
                            return !this.buffer.isEmpty() || this.iterator.hasNext();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                        }

                        public List<Class<?>> next() {
                            if (this.buffer.isEmpty()) {
                                this.buffer = (List) this.iterator.next();
                            }
                            while (this.buffer.size() < this.minimum && this.iterator.hasNext()) {
                                this.buffer.addAll((Collection) this.iterator.next());
                            }
                            int size = this.buffer.size();
                            int i11 = this.maximum;
                            if (size > i11) {
                                try {
                                    return this.buffer.subList(0, i11);
                                } finally {
                                    List<Class<?>> list = this.buffer;
                                    this.buffer = new ArrayList(list.subList(this.maximum, list.size()));
                                }
                            } else {
                                try {
                                    return this.buffer;
                                } finally {
                                    this.buffer = new ArrayList();
                                }
                            }
                        }
                    }

                    public SlicingIterable(int i11, int i12, Iterable<? extends List<Class<?>>> iterable2) {
                        this.minimum = i11;
                        this.maximum = i12;
                        this.iterable = iterable2;
                    }

                    public java.util.Iterator<List<Class<?>>> iterator() {
                        return new SlicingIterator(this.minimum, this.maximum, this.iterable.iterator());
                    }
                }

                public Slicing(int i11, int i12, BatchAllocator batchAllocator2) {
                    this.minimum = i11;
                    this.maximum = i12;
                    this.batchAllocator = batchAllocator2;
                }

                public static BatchAllocator withMaximum(int i11, BatchAllocator batchAllocator2) {
                    return withinRange(1, i11, batchAllocator2);
                }

                public static BatchAllocator withMinimum(int i11, BatchAllocator batchAllocator2) {
                    return withinRange(i11, Integer.MAX_VALUE, batchAllocator2);
                }

                public static BatchAllocator withinRange(int i11, int i12, BatchAllocator batchAllocator2) {
                    if (i11 <= 0) {
                        throw new IllegalArgumentException("Minimum must be a positive number: " + i11);
                    } else if (i11 <= i12) {
                        return new Slicing(i11, i12, batchAllocator2);
                    } else {
                        throw new IllegalArgumentException("Minimum must not be bigger than maximum: " + i11 + " >" + i12);
                    }
                }

                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    return new SlicingIterable(this.minimum, this.maximum, this.batchAllocator.batch(list));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Slicing slicing = (Slicing) obj;
                    return this.minimum == slicing.minimum && this.maximum == slicing.maximum && this.batchAllocator.equals(slicing.batchAllocator);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.minimum) * 31) + this.maximum) * 31) + this.batchAllocator.hashCode();
                }
            }

            Iterable<? extends List<Class<?>>> batch(List<Class<?>> list);
        }

        public static abstract class Collector {

            /* renamed from: a  reason: collision with root package name */
            public final LocationStrategy f26971a;

            /* renamed from: b  reason: collision with root package name */
            public final Listener f26972b;

            /* renamed from: c  reason: collision with root package name */
            public final CircularityLock f26973c;

            /* renamed from: d  reason: collision with root package name */
            public final List<Class<?>> f26974d;
            private final DescriptionStrategy descriptionStrategy;
            private final FallbackStrategy fallbackStrategy;
            private final RawMatcher matcher;
            private final PoolStrategy poolStrategy;

            public static class ForRedefinition extends Collector {
                public ForRedefinition(RawMatcher rawMatcher, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, Listener listener, FallbackStrategy fallbackStrategy, CircularityLock circularityLock) {
                    super(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
                }

                public void c(Instrumentation instrumentation, List<Class<?>> list) throws UnmodifiableClassException, ClassNotFoundException {
                    Throwable th2;
                    JavaModule ofType;
                    ArrayList arrayList = new ArrayList(list.size());
                    for (Class next : list) {
                        try {
                            arrayList.add(new ClassDefinition(next, this.f26971a.classFileLocator(next.getClassLoader(), JavaModule.ofType(next)).locate(TypeDescription.ForLoadedType.getName(next)).resolve()));
                        } catch (Throwable th3) {
                            this.f26972b.onComplete(TypeDescription.ForLoadedType.getName(next), next.getClassLoader(), ofType, true);
                            throw th3;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        this.f26973c.release();
                        try {
                            instrumentation.redefineClasses((ClassDefinition[]) arrayList.toArray(new ClassDefinition[0]));
                        } finally {
                            this.f26973c.acquire();
                        }
                    }
                }
            }

            public static class ForRetransformation extends Collector {
                public ForRetransformation(RawMatcher rawMatcher, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, Listener listener, FallbackStrategy fallbackStrategy, CircularityLock circularityLock) {
                    super(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy, circularityLock);
                }

                public void c(Instrumentation instrumentation, List<Class<?>> list) throws UnmodifiableClassException {
                    if (!list.isEmpty()) {
                        this.f26973c.release();
                        try {
                            RedefinitionStrategy.f26970b.retransformClasses(instrumentation, (Class[]) list.toArray(new Class[0]));
                        } finally {
                            this.f26973c.acquire();
                        }
                    }
                }
            }

            public static class PrependableIterator implements java.util.Iterator<List<Class<?>>>, j$.util.Iterator {
                private final LinkedList<java.util.Iterator<? extends List<Class<?>>>> backlog;
                private java.util.Iterator<? extends List<Class<?>>> current;

                public PrependableIterator(Iterable<? extends List<Class<?>>> iterable) {
                    this.current = iterable.iterator();
                    this.backlog = new LinkedList<>();
                }

                public /* synthetic */ void forEachRemaining(Consumer consumer) {
                    Iterator.CC.$default$forEachRemaining(this, consumer);
                }

                public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                    forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                }

                public boolean hasNext() {
                    return this.current.hasNext();
                }

                public void prepend(Iterable<? extends List<Class<?>>> iterable) {
                    java.util.Iterator<? extends List<Class<?>>> it = iterable.iterator();
                    if (it.hasNext()) {
                        if (this.current.hasNext()) {
                            this.backlog.addLast(this.current);
                        }
                        this.current = it;
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                }

                /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: 
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                    	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                    */
                public java.util.List<java.lang.Class<?>> next() {
                    /*
                        r2 = this;
                        java.util.Iterator<? extends java.util.List<java.lang.Class<?>>> r0 = r2.current     // Catch:{ all -> 0x0024 }
                        java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0024 }
                        java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0024 }
                    L_0x0008:
                        java.util.Iterator<? extends java.util.List<java.lang.Class<?>>> r1 = r2.current
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x0023
                        java.util.LinkedList<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r2.backlog
                        boolean r1 = r1.isEmpty()
                        if (r1 != 0) goto L_0x0023
                        java.util.LinkedList<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r2.backlog
                        java.lang.Object r1 = r1.removeLast()
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        r2.current = r1
                        goto L_0x0008
                    L_0x0023:
                        return r0
                    L_0x0024:
                        r0 = move-exception
                    L_0x0025:
                        java.util.Iterator<? extends java.util.List<java.lang.Class<?>>> r1 = r2.current
                        boolean r1 = r1.hasNext()
                        if (r1 != 0) goto L_0x0040
                        java.util.LinkedList<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r2.backlog
                        boolean r1 = r1.isEmpty()
                        if (r1 != 0) goto L_0x0040
                        java.util.LinkedList<java.util.Iterator<? extends java.util.List<java.lang.Class<?>>>> r1 = r2.backlog
                        java.lang.Object r1 = r1.removeLast()
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        r2.current = r1
                        goto L_0x0025
                    L_0x0040:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Collector.PrependableIterator.next():java.util.List");
                }
            }

            public Collector(RawMatcher rawMatcher, PoolStrategy poolStrategy2, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy2, Listener listener, FallbackStrategy fallbackStrategy2, CircularityLock circularityLock) {
                this.matcher = rawMatcher;
                this.poolStrategy = poolStrategy2;
                this.f26971a = locationStrategy;
                this.descriptionStrategy = descriptionStrategy2;
                this.f26972b = listener;
                this.fallbackStrategy = fallbackStrategy2;
                this.f26973c = circularityLock;
                this.f26974d = new ArrayList();
            }

            private void doConsider(RawMatcher rawMatcher, Listener listener, TypeDescription typeDescription, Class<?> cls, Class<?> cls2, JavaModule javaModule, boolean z11) {
                boolean z12;
                String name2;
                ClassLoader classLoader;
                boolean z13;
                boolean z14;
                if (z11) {
                    if (rawMatcher.matches(typeDescription, cls.getClassLoader(), javaModule, cls2, cls.getProtectionDomain())) {
                        this.f26974d.add(cls);
                        return;
                    }
                }
                boolean z15 = true;
                try {
                    String name3 = TypeDescription.ForLoadedType.getName(cls);
                    ClassLoader classLoader2 = cls.getClassLoader();
                    if (cls2 != null) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    listener.onDiscovery(name3, classLoader2, javaModule, z13);
                    ClassLoader classLoader3 = cls.getClassLoader();
                    if (cls2 != null) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    listener.onIgnored(typeDescription, classLoader3, javaModule, z14);
                    name2 = TypeDescription.ForLoadedType.getName(cls);
                    classLoader = cls.getClassLoader();
                    if (cls2 != null) {
                        listener.onComplete(name2, classLoader, javaModule, z15);
                    }
                } catch (Throwable unused) {
                    return;
                }
                z15 = false;
                listener.onComplete(name2, classLoader, javaModule, z15);
            }

            public int a(Instrumentation instrumentation, BatchAllocator batchAllocator, Listener listener, int i11) {
                HashMap hashMap = new HashMap();
                PrependableIterator prependableIterator = new PrependableIterator(batchAllocator.batch(this.f26974d));
                while (prependableIterator.hasNext()) {
                    List next = prependableIterator.next();
                    listener.onBatch(i11, next, this.f26974d);
                    try {
                        c(instrumentation, next);
                    } catch (Throwable th2) {
                        prependableIterator.prepend(listener.onError(i11, next, th2, this.f26974d));
                        hashMap.put(next, th2);
                    }
                    i11++;
                }
                listener.onComplete(i11, this.f26974d, hashMap);
                return i11;
            }

            public void b(Class<?> cls, boolean z11) {
                TypePool typePool;
                JavaModule ofType = JavaModule.ofType(cls);
                try {
                    typePool = this.poolStrategy.typePool(this.f26971a.classFileLocator(cls.getClassLoader(), ofType), cls.getClassLoader());
                    doConsider(this.matcher, this.f26972b, this.descriptionStrategy.apply(TypeDescription.ForLoadedType.getName(cls), cls, typePool, this.f26973c, cls.getClassLoader(), ofType), cls, cls, ofType, z11);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    try {
                        this.f26972b.onDiscovery(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(), ofType, true);
                        this.f26972b.onError(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(), ofType, true, th3);
                        this.f26972b.onComplete(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(), ofType, true);
                    } catch (Throwable unused) {
                    }
                }
            }

            public abstract void c(Instrumentation instrumentation, List<Class<?>> list) throws UnmodifiableClassException, ClassNotFoundException;
        }

        public interface DiscoveryStrategy {

            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements DiscoveryStrategy {
                private final Set<Class<?>> types;

                public Explicit(Class<?>... clsArr) {
                    this((Set<Class<?>>) new LinkedHashSet(Arrays.asList(clsArr)));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.types.equals(((Explicit) obj).types);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.types.hashCode();
                }

                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return Collections.singleton(this.types);
                }

                public Explicit(Set<Class<?>> set) {
                    this.types = set;
                }
            }

            public enum Reiterating implements DiscoveryStrategy {
                INSTANCE;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ReiteratingIterable implements Iterable<Iterable<Class<?>>> {
                    private final Instrumentation instrumentation;

                    public ReiteratingIterable(Instrumentation instrumentation2) {
                        this.instrumentation = instrumentation2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.instrumentation.equals(((ReiteratingIterable) obj).instrumentation);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.instrumentation.hashCode();
                    }

                    public java.util.Iterator<Iterable<Class<?>>> iterator() {
                        return new ReiteratingIterator(this.instrumentation);
                    }
                }

                public static class ReiteratingIterator implements java.util.Iterator<Iterable<Class<?>>>, j$.util.Iterator {
                    private final Instrumentation instrumentation;
                    private final Set<Class<?>> processed;
                    private List<Class<?>> types;

                    public ReiteratingIterator(Instrumentation instrumentation2) {
                        this.instrumentation = instrumentation2;
                        this.processed = new HashSet();
                    }

                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                    }

                    public boolean hasNext() {
                        if (this.types == null) {
                            this.types = new ArrayList();
                            for (Class cls : this.instrumentation.getAllLoadedClasses()) {
                                if (cls != null && this.processed.add(cls)) {
                                    this.types.add(cls);
                                }
                            }
                        }
                        return !this.types.isEmpty();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                    }

                    public Iterable<Class<?>> next() {
                        if (hasNext()) {
                            try {
                                return this.types;
                            } finally {
                                this.types = null;
                            }
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                }

                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return new ReiteratingIterable(instrumentation);
                }
            }

            public enum SinglePass implements DiscoveryStrategy {
                INSTANCE;

                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return Collections.singleton(Arrays.asList(instrumentation.getAllLoadedClasses()));
                }
            }

            Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation);
        }

        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("isModifiableClass")
            boolean isModifiableClass(Instrumentation instrumentation, Class<?> cls);

            @JavaDispatcher.Proxied("isRetransformClassesSupported")
            @JavaDispatcher.Defaults
            boolean isRetransformClassesSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("retransformClasses")
            void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr) throws UnmodifiableClassException;
        }

        public interface Listener {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Adapter implements Listener {
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass();
                }

                public int hashCode() {
                    return getClass().hashCode();
                }

                public void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2) {
                }

                public void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    return Collections.emptyList();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class BatchReallocator extends Adapter {
                private final BatchAllocator batchAllocator;

                public BatchReallocator(BatchAllocator batchAllocator2) {
                    this.batchAllocator = batchAllocator2;
                }

                public static Listener splitting() {
                    return new BatchReallocator(new BatchAllocator.Partitioning(2));
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.batchAllocator.equals(((BatchReallocator) obj).batchAllocator);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.batchAllocator.hashCode();
                }

                public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    if (list.size() < 2) {
                        return Collections.emptyList();
                    }
                    return this.batchAllocator.batch(list);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Listener {
                private final List<Listener> listeners;

                @HashCodeAndEqualsPlugin.Enhance
                public static class CompoundIterable implements Iterable<List<Class<?>>> {
                    private final List<Iterable<? extends List<Class<?>>>> iterables;

                    public static class CompoundIterator implements java.util.Iterator<List<Class<?>>>, j$.util.Iterator {
                        private final List<Iterable<? extends List<Class<?>>>> backlog;
                        private java.util.Iterator<? extends List<Class<?>>> current;

                        public CompoundIterator(List<Iterable<? extends List<Class<?>>>> list) {
                            this.backlog = list;
                            forward();
                        }

                        private void forward() {
                            while (true) {
                                java.util.Iterator<? extends List<Class<?>>> it = this.current;
                                if ((it == null || !it.hasNext()) && !this.backlog.isEmpty()) {
                                    this.current = this.backlog.remove(0).iterator();
                                } else {
                                    return;
                                }
                            }
                        }

                        public /* synthetic */ void forEachRemaining(Consumer consumer) {
                            Iterator.CC.$default$forEachRemaining(this, consumer);
                        }

                        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                        }

                        public boolean hasNext() {
                            java.util.Iterator<? extends List<Class<?>>> it = this.current;
                            return it != null && it.hasNext();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                        }

                        public List<Class<?>> next() {
                            try {
                                java.util.Iterator<? extends List<Class<?>>> it = this.current;
                                if (it != null) {
                                    return (List) it.next();
                                }
                                throw new NoSuchElementException();
                            } finally {
                                forward();
                            }
                        }
                    }

                    public CompoundIterable(List<Iterable<? extends List<Class<?>>>> list) {
                        this.iterables = list;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.iterables.equals(((CompoundIterable) obj).iterables);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.iterables.hashCode();
                    }

                    public java.util.Iterator<List<Class<?>>> iterator() {
                        return new CompoundIterator(new ArrayList(this.iterables));
                    }
                }

                public Compound(Listener... listenerArr) {
                    this((List<? extends Listener>) Arrays.asList(listenerArr));
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.listeners.equals(((Compound) obj).listeners);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.listeners.hashCode();
                }

                public void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2) {
                    for (Listener onBatch : this.listeners) {
                        onBatch.onBatch(i11, list, list2);
                    }
                }

                public void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    for (Listener onComplete : this.listeners) {
                        onComplete.onComplete(i11, list, map);
                    }
                }

                public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    ArrayList arrayList = new ArrayList();
                    for (Listener onError : this.listeners) {
                        arrayList.add(onError.onError(i11, list, th2, list2));
                    }
                    return new CompoundIterable(arrayList);
                }

                public Compound(List<? extends Listener> list) {
                    this.listeners = new ArrayList();
                    for (Listener listener : list) {
                        if (listener instanceof Compound) {
                            this.listeners.addAll(((Compound) listener).listeners);
                        } else if (!(listener instanceof NoOp)) {
                            this.listeners.add(listener);
                        }
                    }
                }
            }

            public enum ErrorEscalating implements Listener {
                FAIL_FAST {
                    public void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    }

                    public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                        throw new IllegalStateException("Could not transform any of " + list, th2);
                    }
                },
                FAIL_LAST {
                    public void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                        if (!map.isEmpty()) {
                            throw new IllegalStateException("Could not transform any of " + map);
                        }
                    }

                    public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                        return Collections.emptyList();
                    }
                };

                public void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2) {
                }
            }

            public enum NoOp implements Listener {
                INSTANCE;

                public void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2) {
                }

                public void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    return Collections.emptyList();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Pausing extends Adapter {
                private final long value;

                public Pausing(long j11) {
                    this.value = j11;
                }

                public static Listener of(long j11, TimeUnit timeUnit) {
                    int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                    if (i11 > 0) {
                        return new Pausing(timeUnit.toMillis(j11));
                    }
                    if (i11 == 0) {
                        return NoOp.INSTANCE;
                    }
                    throw new IllegalArgumentException("Cannot sleep for a non-positive amount of time: " + j11);
                }

                public boolean equals(Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((Pausing) obj).value;
                }

                public int hashCode() {
                    long j11 = this.value;
                    return (super.hashCode() * 31) + ((int) (j11 ^ (j11 >>> 32)));
                }

                public void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2) {
                    if (i11 > 0) {
                        try {
                            Thread.sleep(this.value);
                        } catch (InterruptedException e11) {
                            Thread.currentThread().interrupt();
                            throw new IllegalStateException(e11);
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class StreamWriting implements Listener {
                private final PrintStream printStream;

                public StreamWriting(PrintStream printStream2) {
                    this.printStream = printStream2;
                }

                public static Listener toSystemError() {
                    return new StreamWriting(System.err);
                }

                public static Listener toSystemOut() {
                    return new StreamWriting(System.out);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.printStream.equals(((StreamWriting) obj).printStream);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.printStream.hashCode();
                }

                public void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2) {
                    this.printStream.printf("[Byte Buddy] REDEFINE BATCH #%d [%d of %d type(s)]%n", new Object[]{Integer.valueOf(i11), Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
                }

                public void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    this.printStream.printf("[Byte Buddy] REDEFINE COMPLETE %d batch(es) containing %d types [%d failed batch(es)]%n", new Object[]{Integer.valueOf(i11), Integer.valueOf(list.size()), Integer.valueOf(map.size())});
                }

                public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    synchronized (this.printStream) {
                        this.printStream.printf("[Byte Buddy] REDEFINE ERROR #%d [%d of %d type(s)]%n", new Object[]{Integer.valueOf(i11), Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
                        th2.printStackTrace(this.printStream);
                    }
                    return Collections.emptyList();
                }
            }

            public enum Yielding implements Listener {
                INSTANCE;

                public void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2) {
                    if (i11 > 0) {
                        Thread.yield();
                    }
                }

                public void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                public Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2) {
                    return Collections.emptyList();
                }
            }

            void onBatch(int i11, List<Class<?>> list, List<Class<?>> list2);

            void onComplete(int i11, List<Class<?>> list, Map<List<Class<?>>, Throwable> map);

            Iterable<? extends List<Class<?>>> onError(int i11, List<Class<?>> list, Throwable th2, List<Class<?>> list2);
        }

        public interface ResubmissionEnforcer {

            public enum Disabled implements ResubmissionEnforcer {
                INSTANCE;

                public boolean isEnforced(String str, ClassLoader classLoader, JavaModule javaModule, Class<?> cls) {
                    return false;
                }
            }

            boolean isEnforced(String str, ClassLoader classLoader, JavaModule javaModule, Class<?> cls);
        }

        public interface ResubmissionScheduler {

            @HashCodeAndEqualsPlugin.Enhance
            public static class AtFixedRate implements ResubmissionScheduler {
                private final ScheduledExecutorService scheduledExecutorService;
                private final long time;
                private final TimeUnit timeUnit;

                public AtFixedRate(ScheduledExecutorService scheduledExecutorService2, long j11, TimeUnit timeUnit2) {
                    this.scheduledExecutorService = scheduledExecutorService2;
                    this.time = j11;
                    this.timeUnit = timeUnit2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AtFixedRate atFixedRate = (AtFixedRate) obj;
                    return this.time == atFixedRate.time && this.timeUnit.equals(atFixedRate.timeUnit) && this.scheduledExecutorService.equals(atFixedRate.scheduledExecutorService);
                }

                public int hashCode() {
                    long j11 = this.time;
                    return (((((getClass().hashCode() * 31) + this.scheduledExecutorService.hashCode()) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.timeUnit.hashCode();
                }

                public boolean isAlive() {
                    return !this.scheduledExecutorService.isShutdown();
                }

                public Cancelable schedule(Runnable runnable) {
                    ScheduledExecutorService scheduledExecutorService2 = this.scheduledExecutorService;
                    long j11 = this.time;
                    return new Cancelable.ForFuture(scheduledExecutorService2.scheduleAtFixedRate(runnable, j11, j11, this.timeUnit));
                }
            }

            public interface Cancelable {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForFuture implements Cancelable {
                    private final Future<?> future;

                    public ForFuture(Future<?> future2) {
                        this.future = future2;
                    }

                    public void cancel() {
                        this.future.cancel(true);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.future.equals(((ForFuture) obj).future);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.future.hashCode();
                    }
                }

                public enum NoOp implements Cancelable {
                    INSTANCE;

                    public void cancel() {
                    }
                }

                void cancel();
            }

            public enum NoOp implements ResubmissionScheduler {
                INSTANCE;

                public boolean isAlive() {
                    return false;
                }

                public Cancelable schedule(Runnable runnable) {
                    return Cancelable.NoOp.INSTANCE;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class WithFixedDelay implements ResubmissionScheduler {
                private final ScheduledExecutorService scheduledExecutorService;
                private final long time;
                private final TimeUnit timeUnit;

                public WithFixedDelay(ScheduledExecutorService scheduledExecutorService2, long j11, TimeUnit timeUnit2) {
                    this.scheduledExecutorService = scheduledExecutorService2;
                    this.time = j11;
                    this.timeUnit = timeUnit2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    WithFixedDelay withFixedDelay = (WithFixedDelay) obj;
                    return this.time == withFixedDelay.time && this.timeUnit.equals(withFixedDelay.timeUnit) && this.scheduledExecutorService.equals(withFixedDelay.scheduledExecutorService);
                }

                public int hashCode() {
                    long j11 = this.time;
                    return (((((getClass().hashCode() * 31) + this.scheduledExecutorService.hashCode()) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.timeUnit.hashCode();
                }

                public boolean isAlive() {
                    return !this.scheduledExecutorService.isShutdown();
                }

                public Cancelable schedule(Runnable runnable) {
                    ScheduledExecutorService scheduledExecutorService2 = this.scheduledExecutorService;
                    long j11 = this.time;
                    return new Cancelable.ForFuture(scheduledExecutorService2.scheduleWithFixedDelay(runnable, j11, j11, this.timeUnit));
                }
            }

            boolean isAlive();

            Cancelable schedule(Runnable runnable);
        }

        public interface ResubmissionStrategy {

            public enum Disabled implements ResubmissionStrategy {
                INSTANCE;

                public Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener, CircularityLock circularityLock, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2) {
                    return new Installation(listener, installationListener, ResubmissionEnforcer.Disabled.INSTANCE);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements ResubmissionStrategy {
                private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                private final ResubmissionScheduler resubmissionScheduler;

                public static class LookupKey {
                    /* access modifiers changed from: private */
                    public final ClassLoader classLoader;
                    /* access modifiers changed from: private */
                    public final int hashCode;

                    public LookupKey(ClassLoader classLoader2) {
                        this.classLoader = classLoader2;
                        this.hashCode = System.identityHashCode(classLoader2);
                    }

                    @SuppressFBWarnings(justification = "Cross-comparison is intended", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof LookupKey) {
                            if (this.classLoader == ((LookupKey) obj).classLoader) {
                                return true;
                            }
                            return false;
                        } else if (!(obj instanceof StorageKey)) {
                            return false;
                        } else {
                            StorageKey storageKey = (StorageKey) obj;
                            if (this.hashCode == storageKey.hashCode && this.classLoader == storageKey.get()) {
                                return true;
                            }
                            return false;
                        }
                    }

                    public int hashCode() {
                        return this.hashCode;
                    }
                }

                public static class ResubmissionInstallationListener extends InstallationListener.Adapter implements Runnable {
                    private volatile ResubmissionScheduler.Cancelable cancelable;
                    private final CircularityLock circularityLock;
                    private final DescriptionStrategy descriptionStrategy;
                    private final FallbackStrategy fallbackStrategy;
                    private final Instrumentation instrumentation;
                    private final Listener listener;
                    private final LocationStrategy locationStrategy;
                    private final RawMatcher matcher;
                    private final PoolStrategy poolStrategy;
                    private final BatchAllocator redefinitionBatchAllocator;
                    private final Listener redefinitionBatchListener;
                    private final RedefinitionStrategy redefinitionStrategy;
                    private final ResubmissionScheduler resubmissionScheduler;
                    private final ConcurrentMap<StorageKey, Set<String>> types;

                    public ResubmissionInstallationListener(Instrumentation instrumentation2, ResubmissionScheduler resubmissionScheduler2, PoolStrategy poolStrategy2, LocationStrategy locationStrategy2, DescriptionStrategy descriptionStrategy2, FallbackStrategy fallbackStrategy2, Listener listener2, CircularityLock circularityLock2, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy2, BatchAllocator batchAllocator, Listener listener3, ConcurrentMap<StorageKey, Set<String>> concurrentMap) {
                        this.instrumentation = instrumentation2;
                        this.resubmissionScheduler = resubmissionScheduler2;
                        this.poolStrategy = poolStrategy2;
                        this.locationStrategy = locationStrategy2;
                        this.descriptionStrategy = descriptionStrategy2;
                        this.fallbackStrategy = fallbackStrategy2;
                        this.listener = listener2;
                        this.circularityLock = circularityLock2;
                        this.matcher = rawMatcher;
                        this.redefinitionStrategy = redefinitionStrategy2;
                        this.redefinitionBatchAllocator = batchAllocator;
                        this.redefinitionBatchListener = listener3;
                        this.types = concurrentMap;
                    }

                    public void onInstall(Instrumentation instrumentation2, ResettableClassFileTransformer resettableClassFileTransformer) {
                        this.cancelable = this.resubmissionScheduler.schedule(this);
                    }

                    public void onReset(Instrumentation instrumentation2, ResettableClassFileTransformer resettableClassFileTransformer) {
                        ResubmissionScheduler.Cancelable cancelable2 = this.cancelable;
                        if (cancelable2 != null) {
                            cancelable2.cancel();
                        }
                    }

                    /* JADX WARNING: Can't wrap try/catch for region: R(7:23|24|(6:28|(1:30)|32|34|35|36)|33|34|35|36) */
                    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
                        if (net.bytebuddy.ClassFileVersion.ofThisVm(r7).isAtMost(r7) != false) goto L_0x00a8;
                     */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ae */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r9 = this;
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            boolean r0 = r0.acquire()
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy r1 = r9.redefinitionStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$PoolStrategy r2 = r9.poolStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$LocationStrategy r3 = r9.locationStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$DescriptionStrategy r4 = r9.descriptionStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$FallbackStrategy r5 = r9.fallbackStrategy     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$Listener r6 = r9.listener     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RawMatcher r7 = r9.matcher     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r8 = r9.circularityLock     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Collector r1 = r1.d(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00c3 }
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r2 = r9.types     // Catch:{ all -> 0x00c3 }
                            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00c3 }
                            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00c3 }
                        L_0x0024:
                            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00c3 }
                            r4 = 0
                            if (r3 == 0) goto L_0x00b2
                            boolean r3 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x00c3 }
                            if (r3 == 0) goto L_0x0039
                            if (r0 == 0) goto L_0x0038
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x0038:
                            return
                        L_0x0039:
                            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00c3 }
                            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00c3 }
                            java.lang.Object r5 = r3.getKey()     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r5 = (net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey) r5     // Catch:{ all -> 0x00c3 }
                            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x00c3 }
                            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00c3 }
                            if (r5 != 0) goto L_0x005e
                            java.lang.Object r6 = r3.getKey()     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r6 = (net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.StorageKey) r6     // Catch:{ all -> 0x00c3 }
                            boolean r6 = r6.b()     // Catch:{ all -> 0x00c3 }
                            if (r6 == 0) goto L_0x005a
                            goto L_0x005e
                        L_0x005a:
                            r2.remove()     // Catch:{ all -> 0x00c3 }
                            goto L_0x0024
                        L_0x005e:
                            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00c3 }
                            java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x00c3 }
                            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c3 }
                        L_0x0068:
                            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x00c3 }
                            if (r6 == 0) goto L_0x0024
                            boolean r6 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x00c3 }
                            if (r6 == 0) goto L_0x007c
                            if (r0 == 0) goto L_0x007b
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x007b:
                            return
                        L_0x007c:
                            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x00ae }
                            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00ae }
                            java.lang.Class r6 = java.lang.Class.forName(r6, r4, r5)     // Catch:{ all -> 0x00ae }
                            boolean r7 = r6.isArray()     // Catch:{ all -> 0x00ae }
                            if (r7 != 0) goto L_0x00aa
                            boolean r7 = r6.isPrimitive()     // Catch:{ all -> 0x00ae }
                            if (r7 != 0) goto L_0x00aa
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Dispatcher r7 = net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.f26970b     // Catch:{ all -> 0x00ae }
                            java.lang.instrument.Instrumentation r8 = r9.instrumentation     // Catch:{ all -> 0x00ae }
                            boolean r7 = r7.isModifiableClass(r8, r6)     // Catch:{ all -> 0x00ae }
                            if (r7 != 0) goto L_0x00a8
                            net.bytebuddy.ClassFileVersion r7 = net.bytebuddy.ClassFileVersion.JAVA_V5     // Catch:{ all -> 0x00ae }
                            net.bytebuddy.ClassFileVersion r8 = net.bytebuddy.ClassFileVersion.ofThisVm(r7)     // Catch:{ all -> 0x00ae }
                            boolean r7 = r8.isAtMost(r7)     // Catch:{ all -> 0x00ae }
                            if (r7 == 0) goto L_0x00aa
                        L_0x00a8:
                            r7 = 1
                            goto L_0x00ab
                        L_0x00aa:
                            r7 = r4
                        L_0x00ab:
                            r1.b(r6, r7)     // Catch:{ all -> 0x00ae }
                        L_0x00ae:
                            r3.remove()     // Catch:{ all -> 0x00c3 }
                            goto L_0x0068
                        L_0x00b2:
                            java.lang.instrument.Instrumentation r2 = r9.instrumentation     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$BatchAllocator r3 = r9.redefinitionBatchAllocator     // Catch:{ all -> 0x00c3 }
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$Listener r5 = r9.redefinitionBatchListener     // Catch:{ all -> 0x00c3 }
                            r1.a(r2, r3, r5, r4)     // Catch:{ all -> 0x00c3 }
                            if (r0 == 0) goto L_0x00c2
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x00c2:
                            return
                        L_0x00c3:
                            r1 = move-exception
                            if (r0 == 0) goto L_0x00cb
                            net.bytebuddy.agent.builder.AgentBuilder$CircularityLock r0 = r9.circularityLock
                            r0.release()
                        L_0x00cb:
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.ResubmissionInstallationListener.run():void");
                    }
                }

                public static class Resubmitter extends Listener.Adapter implements ResubmissionEnforcer {
                    private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                    private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                    private final ConcurrentMap<StorageKey, Set<String>> types;

                    public static class ConcurrentHashSet<T> extends AbstractSet<T> {
                        private final ConcurrentMap<T, Boolean> delegate;

                        public ConcurrentHashSet() {
                            this.delegate = new ConcurrentHashMap();
                        }

                        public boolean add(T t11) {
                            return this.delegate.put(t11, Boolean.TRUE) == null;
                        }

                        public java.util.Iterator<T> iterator() {
                            return this.delegate.keySet().iterator();
                        }

                        public boolean remove(Object obj) {
                            return this.delegate.remove(obj) != null;
                        }

                        public int size() {
                            return this.delegate.size();
                        }
                    }

                    public Resubmitter(RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2, RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2, ConcurrentMap<StorageKey, Set<String>> concurrentMap) {
                        this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher2;
                        this.resubmissionImmediateMatcher = resubmissionImmediateMatcher2;
                        this.types = concurrentMap;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
                        r4 = new net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.ConcurrentHashSet();
                     */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Use of unrelated key is intended for avoiding unnecessary weak reference", value = {"GC_UNRELATED_TYPES"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean isEnforced(java.lang.String r2, java.lang.ClassLoader r3, net.bytebuddy.utility.JavaModule r4, java.lang.Class<?> r5) {
                        /*
                            r1 = this;
                            if (r5 != 0) goto L_0x0033
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionListenable$ResubmissionImmediateMatcher r5 = r1.resubmissionImmediateMatcher
                            boolean r4 = r5.matches(r2, r3, r4)
                            if (r4 == 0) goto L_0x0033
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r4 = r1.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey r5 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey
                            r5.<init>(r3)
                            java.lang.Object r4 = r4.get(r5)
                            java.util.Set r4 = (java.util.Set) r4
                            if (r4 != 0) goto L_0x002e
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet r4 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet
                            r4.<init>()
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r5 = r1.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r0 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey
                            r0.<init>(r3)
                            java.lang.Object r3 = r5.putIfAbsent(r0, r4)
                            java.util.Set r3 = (java.util.Set) r3
                            if (r3 == 0) goto L_0x002e
                            r4 = r3
                        L_0x002e:
                            r4.add(r2)
                            r2 = 1
                            return r2
                        L_0x0033:
                            r2 = 0
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.isEnforced(java.lang.String, java.lang.ClassLoader, net.bytebuddy.utility.JavaModule, java.lang.Class):boolean");
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
                        r3 = new net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.ConcurrentHashSet();
                     */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Use of unrelated key is intended for avoiding unnecessary weak reference", value = {"GC_UNRELATED_TYPES"})
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onError(java.lang.String r1, java.lang.ClassLoader r2, net.bytebuddy.utility.JavaModule r3, boolean r4, java.lang.Throwable r5) {
                        /*
                            r0 = this;
                            if (r4 != 0) goto L_0x0031
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionListenable$ResubmissionOnErrorMatcher r4 = r0.resubmissionOnErrorMatcher
                            boolean r3 = r4.matches(r5, r1, r2, r3)
                            if (r3 == 0) goto L_0x0031
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r3 = r0.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey r4 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$LookupKey
                            r4.<init>(r2)
                            java.lang.Object r3 = r3.get(r4)
                            java.util.Set r3 = (java.util.Set) r3
                            if (r3 != 0) goto L_0x002e
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet r3 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$Resubmitter$ConcurrentHashSet
                            r3.<init>()
                            java.util.concurrent.ConcurrentMap<net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey, java.util.Set<java.lang.String>> r4 = r0.types
                            net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey r5 = new net.bytebuddy.agent.builder.AgentBuilder$RedefinitionStrategy$ResubmissionStrategy$Enabled$StorageKey
                            r5.<init>(r2)
                            java.lang.Object r2 = r4.putIfAbsent(r5, r3)
                            java.util.Set r2 = (java.util.Set) r2
                            if (r2 == 0) goto L_0x002e
                            r3 = r2
                        L_0x002e:
                            r3.add(r1)
                        L_0x0031:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled.Resubmitter.onError(java.lang.String, java.lang.ClassLoader, net.bytebuddy.utility.JavaModule, boolean, java.lang.Throwable):void");
                    }
                }

                public static class StorageKey extends WeakReference<ClassLoader> {
                    /* access modifiers changed from: private */
                    public final int hashCode;

                    public StorageKey(ClassLoader classLoader) {
                        super(classLoader);
                        this.hashCode = System.identityHashCode(classLoader);
                    }

                    public boolean b() {
                        return this.hashCode == 0;
                    }

                    @SuppressFBWarnings(justification = "Cross-comparison is intended", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof LookupKey) {
                            LookupKey lookupKey = (LookupKey) obj;
                            if (this.hashCode == lookupKey.hashCode && get() == lookupKey.classLoader) {
                                return true;
                            }
                            return false;
                        } else if (!(obj instanceof StorageKey)) {
                            return false;
                        } else {
                            StorageKey storageKey = (StorageKey) obj;
                            if (this.hashCode == storageKey.hashCode && get() == storageKey.get()) {
                                return true;
                            }
                            return false;
                        }
                    }

                    public int hashCode() {
                        return this.hashCode;
                    }
                }

                public Enabled(ResubmissionScheduler resubmissionScheduler2, RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher2, RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher2) {
                    this.resubmissionScheduler = resubmissionScheduler2;
                    this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher2;
                    this.resubmissionImmediateMatcher = resubmissionImmediateMatcher2;
                }

                public Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener, CircularityLock circularityLock, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2) {
                    if (this.resubmissionScheduler.isAlive()) {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        Resubmitter resubmitter = new Resubmitter(this.resubmissionOnErrorMatcher, this.resubmissionImmediateMatcher, concurrentHashMap);
                        Listener.Compound compound = new Listener.Compound(resubmitter, listener);
                        return new Installation(compound, new InstallationListener.Compound(new ResubmissionInstallationListener(instrumentation, this.resubmissionScheduler, poolStrategy, locationStrategy, descriptionStrategy, fallbackStrategy, listener, circularityLock, rawMatcher, redefinitionStrategy, batchAllocator, listener2, concurrentHashMap), installationListener), resubmitter);
                    }
                    throw new IllegalStateException("Resubmission scheduler " + this.resubmissionScheduler + " is not alive");
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Enabled enabled = (Enabled) obj;
                    return this.resubmissionScheduler.equals(enabled.resubmissionScheduler) && this.resubmissionOnErrorMatcher.equals(enabled.resubmissionOnErrorMatcher) && this.resubmissionImmediateMatcher.equals(enabled.resubmissionImmediateMatcher);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.resubmissionScheduler.hashCode()) * 31) + this.resubmissionOnErrorMatcher.hashCode()) * 31) + this.resubmissionImmediateMatcher.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Installation {
                private final InstallationListener installationListener;
                private final Listener listener;
                private final ResubmissionEnforcer resubmissionEnforcer;

                public Installation(Listener listener2, InstallationListener installationListener2, ResubmissionEnforcer resubmissionEnforcer2) {
                    this.listener = listener2;
                    this.installationListener = installationListener2;
                    this.resubmissionEnforcer = resubmissionEnforcer2;
                }

                public InstallationListener a() {
                    return this.installationListener;
                }

                public Listener b() {
                    return this.listener;
                }

                public ResubmissionEnforcer c() {
                    return this.resubmissionEnforcer;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Installation installation = (Installation) obj;
                    return this.listener.equals(installation.listener) && this.installationListener.equals(installation.installationListener) && this.resubmissionEnforcer.equals(installation.resubmissionEnforcer);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.listener.hashCode()) * 31) + this.installationListener.hashCode()) * 31) + this.resubmissionEnforcer.hashCode();
                }
            }

            Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener, CircularityLock circularityLock, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2);
        }

        /* access modifiers changed from: public */
        static {
            f26970b = (Dispatcher) Default.doPrivileged(JavaDispatcher.of(Dispatcher.class));
        }

        public abstract void a(Instrumentation instrumentation);

        public void apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, DiscoveryStrategy discoveryStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy, Listener listener, Listener listener2, RawMatcher rawMatcher, BatchAllocator batchAllocator, CircularityLock circularityLock) {
            boolean z11;
            Instrumentation instrumentation2 = instrumentation;
            a(instrumentation);
            int i11 = 0;
            for (Iterable<Class<?>> it : discoveryStrategy.resolve(instrumentation)) {
                Collector d11 = d(poolStrategy, locationStrategy, descriptionStrategy, fallbackStrategy, listener, rawMatcher, circularityLock);
                for (Class cls : it) {
                    if (cls == null || cls.isArray() || cls.isPrimitive()) {
                        LambdaInstrumentationStrategy lambdaInstrumentationStrategy2 = lambdaInstrumentationStrategy;
                    } else if (lambdaInstrumentationStrategy.c(cls)) {
                        if (!f26970b.isModifiableClass(instrumentation, cls)) {
                            ClassFileVersion classFileVersion = ClassFileVersion.JAVA_V5;
                            if (!ClassFileVersion.ofThisVm(classFileVersion).isAtMost(classFileVersion)) {
                                z11 = false;
                                d11.b(cls, z11);
                            }
                        }
                        z11 = true;
                        d11.b(cls, z11);
                    }
                }
                LambdaInstrumentationStrategy lambdaInstrumentationStrategy3 = lambdaInstrumentationStrategy;
                i11 = d11.a(instrumentation, batchAllocator, listener2, i11);
            }
        }

        public boolean b() {
            return this.enabled;
        }

        public boolean c() {
            return this.retransforming;
        }

        public abstract Collector d(PoolStrategy poolStrategy, LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener, RawMatcher rawMatcher, CircularityLock circularityLock);

        private RedefinitionStrategy(boolean z11, boolean z12) {
            this.enabled = z11;
            this.retransforming = z12;
        }
    }

    public interface Transformer {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAdvice implements Transformer {
            private final Advice.WithCustomMapping advice;
            private final Assigner assigner;
            private final ClassFileLocator classFileLocator;
            private final List<Entry> entries;
            private final Advice.ExceptionHandler exceptionHandler;
            private final LocationStrategy locationStrategy;
            private final PoolStrategy poolStrategy;

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Entry {
                private final LatentMatcher<? super MethodDescription> matcher;

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForSplitAdvice extends Entry {
                    private final String enter;
                    private final String exit;

                    public ForSplitAdvice(LatentMatcher<? super MethodDescription> latentMatcher, String str, String str2) {
                        super(latentMatcher);
                        this.enter = str;
                        this.exit = str2;
                    }

                    public Advice b(Advice.WithCustomMapping withCustomMapping, TypePool typePool, ClassFileLocator classFileLocator) {
                        return withCustomMapping.to(typePool.describe(this.enter).resolve(), typePool.describe(this.exit).resolve(), classFileLocator);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForSplitAdvice forSplitAdvice = (ForSplitAdvice) obj;
                        return this.enter.equals(forSplitAdvice.enter) && this.exit.equals(forSplitAdvice.exit);
                    }

                    public int hashCode() {
                        return (((super.hashCode() * 31) + this.enter.hashCode()) * 31) + this.exit.hashCode();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForUnifiedAdvice extends Entry {

                    /* renamed from: a  reason: collision with root package name */
                    public final String f26975a;

                    public ForUnifiedAdvice(LatentMatcher<? super MethodDescription> latentMatcher, String str) {
                        super(latentMatcher);
                        this.f26975a = str;
                    }

                    public Advice b(Advice.WithCustomMapping withCustomMapping, TypePool typePool, ClassFileLocator classFileLocator) {
                        return withCustomMapping.to(typePool.describe(this.f26975a).resolve(), classFileLocator);
                    }

                    public boolean equals(Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.f26975a.equals(((ForUnifiedAdvice) obj).f26975a);
                    }

                    public int hashCode() {
                        return (super.hashCode() * 31) + this.f26975a.hashCode();
                    }
                }

                public Entry(LatentMatcher<? super MethodDescription> latentMatcher) {
                    this.matcher = latentMatcher;
                }

                public LatentMatcher<? super MethodDescription> a() {
                    return this.matcher;
                }

                public abstract Advice b(Advice.WithCustomMapping withCustomMapping, TypePool typePool, ClassFileLocator classFileLocator);

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Entry) obj).matcher);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.matcher.hashCode();
                }
            }

            public ForAdvice() {
                this(Advice.withCustomMapping());
            }

            public ForAdvice advice(ElementMatcher<? super MethodDescription> elementMatcher, String str) {
                return advice((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher), str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForAdvice forAdvice = (ForAdvice) obj;
                return this.advice.equals(forAdvice.advice) && this.exceptionHandler.equals(forAdvice.exceptionHandler) && this.assigner.equals(forAdvice.assigner) && this.classFileLocator.equals(forAdvice.classFileLocator) && this.poolStrategy.equals(forAdvice.poolStrategy) && this.locationStrategy.equals(forAdvice.locationStrategy) && this.entries.equals(forAdvice.entries);
            }

            public int hashCode() {
                return (((((((((((((getClass().hashCode() * 31) + this.advice.hashCode()) * 31) + this.exceptionHandler.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.classFileLocator.hashCode()) * 31) + this.poolStrategy.hashCode()) * 31) + this.locationStrategy.hashCode()) * 31) + this.entries.hashCode();
            }

            public ForAdvice include(ClassLoader... classLoaderArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (ClassLoader of2 : classLoaderArr) {
                    linkedHashSet.add(ClassFileLocator.ForClassLoader.of(of2));
                }
                return include((List<? extends ClassFileLocator>) new ArrayList(linkedHashSet));
            }

            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                ClassFileLocator.Compound compound = new ClassFileLocator.Compound(this.classFileLocator, this.locationStrategy.classFileLocator(classLoader, javaModule));
                TypePool typePool = this.poolStrategy.typePool(compound, classLoader);
                AsmVisitorWrapper.ForDeclaredMethods forDeclaredMethods = new AsmVisitorWrapper.ForDeclaredMethods();
                for (Entry next : this.entries) {
                    forDeclaredMethods = forDeclaredMethods.invokable((ElementMatcher<? super MethodDescription>) next.a().resolve(typeDescription), next.b(this.advice, typePool, compound).withAssigner(this.assigner).withExceptionHandler(this.exceptionHandler));
                }
                return builder.visit(forDeclaredMethods);
            }

            public ForAdvice with(PoolStrategy poolStrategy2) {
                return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, poolStrategy2, this.locationStrategy, this.entries);
            }

            public ForAdvice withExceptionHandler(Advice.ExceptionHandler exceptionHandler2) {
                return new ForAdvice(this.advice, exceptionHandler2, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, this.entries);
            }

            public ForAdvice(Advice.WithCustomMapping withCustomMapping) {
                this(withCustomMapping, Advice.ExceptionHandler.Default.SUPPRESSING, Assigner.DEFAULT, ClassFileLocator.NoOp.INSTANCE, PoolStrategy.Default.FAST, LocationStrategy.ForClassLoader.STRONG, Collections.emptyList());
            }

            public ForAdvice advice(LatentMatcher<? super MethodDescription> latentMatcher, String str) {
                return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, CompoundList.of(this.entries, new Entry.ForUnifiedAdvice(latentMatcher, str)));
            }

            public ForAdvice with(LocationStrategy locationStrategy2) {
                return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, locationStrategy2, this.entries);
            }

            public ForAdvice with(Assigner assigner2) {
                return new ForAdvice(this.advice, this.exceptionHandler, assigner2, this.classFileLocator, this.poolStrategy, this.locationStrategy, this.entries);
            }

            public ForAdvice advice(ElementMatcher<? super MethodDescription> elementMatcher, String str, String str2) {
                return advice((LatentMatcher<? super MethodDescription>) new LatentMatcher.Resolved(elementMatcher), str, str2);
            }

            public ForAdvice(Advice.WithCustomMapping withCustomMapping, Advice.ExceptionHandler exceptionHandler2, Assigner assigner2, ClassFileLocator classFileLocator2, PoolStrategy poolStrategy2, LocationStrategy locationStrategy2, List<Entry> list) {
                this.advice = withCustomMapping;
                this.exceptionHandler = exceptionHandler2;
                this.assigner = assigner2;
                this.classFileLocator = classFileLocator2;
                this.poolStrategy = poolStrategy2;
                this.locationStrategy = locationStrategy2;
                this.entries = list;
            }

            public ForAdvice advice(LatentMatcher<? super MethodDescription> latentMatcher, String str, String str2) {
                return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy, this.locationStrategy, CompoundList.of(this.entries, new Entry.ForSplitAdvice(latentMatcher, str, str2)));
            }

            public ForAdvice include(ClassFileLocator... classFileLocatorArr) {
                return include((List<? extends ClassFileLocator>) Arrays.asList(classFileLocatorArr));
            }

            public ForAdvice include(List<? extends ClassFileLocator> list) {
                return new ForAdvice(this.advice, this.exceptionHandler, this.assigner, new ClassFileLocator.Compound((List<? extends ClassFileLocator>) CompoundList.of(this.classFileLocator, list)), this.poolStrategy, this.locationStrategy, this.entries);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForBuildPlugin implements Transformer {
            private final Plugin plugin;

            public ForBuildPlugin(Plugin plugin2) {
                this.plugin = plugin2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.plugin.equals(((ForBuildPlugin) obj).plugin);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.plugin.hashCode();
            }

            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                return this.plugin.apply(builder, typeDescription, ClassFileLocator.ForClassLoader.of(classLoader));
            }
        }

        DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule);
    }

    public interface TransformerDecorator {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements TransformerDecorator {
            private final List<TransformerDecorator> transformerDecorators;

            public Compound(TransformerDecorator... transformerDecoratorArr) {
                this((List<? extends TransformerDecorator>) Arrays.asList(transformerDecoratorArr));
            }

            public ResettableClassFileTransformer decorate(ResettableClassFileTransformer resettableClassFileTransformer) {
                for (TransformerDecorator decorate : this.transformerDecorators) {
                    resettableClassFileTransformer = decorate.decorate(resettableClassFileTransformer);
                }
                return resettableClassFileTransformer;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.transformerDecorators.equals(((Compound) obj).transformerDecorators);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.transformerDecorators.hashCode();
            }

            public Compound(List<? extends TransformerDecorator> list) {
                this.transformerDecorators = new ArrayList();
                for (TransformerDecorator transformerDecorator : list) {
                    if (transformerDecorator instanceof Compound) {
                        this.transformerDecorators.addAll(((Compound) transformerDecorator).transformerDecorators);
                    } else if (!(transformerDecorator instanceof NoOp)) {
                        this.transformerDecorators.add(transformerDecorator);
                    }
                }
            }
        }

        public enum NoOp implements TransformerDecorator {
            INSTANCE;

            public ResettableClassFileTransformer decorate(ResettableClassFileTransformer resettableClassFileTransformer) {
                return resettableClassFileTransformer;
            }
        }

        ResettableClassFileTransformer decorate(ResettableClassFileTransformer resettableClassFileTransformer);
    }

    public interface TypeStrategy {

        public enum Default implements TypeStrategy {
            REBASE {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return byteBuddy.rebase(typeDescription, classFileLocator, methodNameTransformer);
                }
            },
            REDEFINE {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return byteBuddy.redefine(typeDescription, classFileLocator);
                }
            },
            REDEFINE_FROZEN {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return byteBuddy.with((InstrumentedType.Factory) InstrumentedType.Factory.Default.FROZEN).with((VisibilityBridgeStrategy) VisibilityBridgeStrategy.Default.NEVER).redefine(typeDescription, classFileLocator).ignoreAlso((LatentMatcher<? super MethodDescription>) LatentMatcher.ForSelfDeclaredMethod.NOT_DECLARED);
                }
            },
            DECORATE {
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                    return byteBuddy.decorate(typeDescription, classFileLocator);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForBuildEntryPoint implements TypeStrategy {
            private final EntryPoint entryPoint;

            public ForBuildEntryPoint(EntryPoint entryPoint2) {
                this.entryPoint = entryPoint2;
            }

            public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                return this.entryPoint.transform(typeDescription, byteBuddy, classFileLocator, methodNameTransformer);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.entryPoint.equals(((ForBuildEntryPoint) obj).entryPoint);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.entryPoint.hashCode();
            }
        }

        DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain);
    }

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection);

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr);

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr);

    AgentBuilder disableClassFormatChanges();

    AgentBuilder disableNativeMethodPrefix();

    AgentBuilder enableNativeMethodPrefix(String str);

    Ignored ignore(RawMatcher rawMatcher);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

    ResettableClassFileTransformer installOn(Instrumentation instrumentation);

    ResettableClassFileTransformer installOnByteBuddyAgent();

    ClassFileTransformer makeRaw();

    ResettableClassFileTransformer patchOn(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

    ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer);

    Identified.Narrowable type(RawMatcher rawMatcher);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

    AgentBuilder warmUp(Collection<Class<?>> collection);

    AgentBuilder warmUp(Class<?>... clsArr);

    RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy);

    AgentBuilder with(ByteBuddy byteBuddy);

    AgentBuilder with(CircularityLock circularityLock);

    AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy);

    AgentBuilder with(DescriptionStrategy descriptionStrategy);

    AgentBuilder with(FallbackStrategy fallbackStrategy);

    AgentBuilder with(InitializationStrategy initializationStrategy);

    AgentBuilder with(InjectionStrategy injectionStrategy);

    AgentBuilder with(InstallationListener installationListener);

    AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy);

    AgentBuilder with(Listener listener);

    AgentBuilder with(LocationStrategy locationStrategy);

    AgentBuilder with(PoolStrategy poolStrategy);

    AgentBuilder with(TransformerDecorator transformerDecorator);

    AgentBuilder with(TypeStrategy typeStrategy);
}
