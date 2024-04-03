package net.bytebuddy.build;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.FileSystem;

public interface Plugin extends ElementMatcher<TypeDescription>, Closeable {

    public interface Factory {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements Factory {
            private final Plugin plugin;

            public Simple(Plugin plugin2) {
                this.plugin = plugin2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.plugin.equals(((Simple) obj).plugin);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.plugin.hashCode();
            }

            public Plugin make() {
                return this.plugin;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingReflection implements Factory {
            private final List<ArgumentResolver> argumentResolvers;
            private final Class<? extends Plugin> type;

            public interface ArgumentResolver {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForIndex implements ArgumentResolver {
                    /* access modifiers changed from: private */
                    public static final Map<Class<?>, Class<?>> WRAPPER_TYPES;
                    private final int index;
                    private final Object value;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithDynamicType implements ArgumentResolver {
                        private final int index;
                        private final String value;

                        public WithDynamicType(int i11, String str) {
                            this.index = i11;
                            this.value = str;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            WithDynamicType withDynamicType = (WithDynamicType) obj;
                            return this.index == withDynamicType.index && this.value.equals(withDynamicType.value);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.index) * 31) + this.value.hashCode();
                        }

                        public Resolution resolve(int i11, Class<?> cls) {
                            if (this.index != i11) {
                                return Resolution.Unresolved.INSTANCE;
                            }
                            if (cls != Character.TYPE && cls != Character.class) {
                                Class<String> cls2 = String.class;
                                if (cls == cls2) {
                                    return new Resolution.Resolved(this.value);
                                }
                                if (cls.isPrimitive()) {
                                    cls = (Class) ForIndex.WRAPPER_TYPES.get(cls);
                                }
                                try {
                                    Method method = cls.getMethod("valueOf", new Class[]{cls2});
                                    if (!Modifier.isStatic(method.getModifiers()) || !cls.isAssignableFrom(method.getReturnType())) {
                                        return Resolution.Unresolved.INSTANCE;
                                    }
                                    return new Resolution.Resolved(method.invoke((Object) null, new Object[]{this.value}));
                                } catch (IllegalAccessException e11) {
                                    throw new IllegalStateException(e11);
                                } catch (InvocationTargetException e12) {
                                    throw new IllegalStateException(e12.getTargetException());
                                } catch (NoSuchMethodException unused) {
                                    return Resolution.Unresolved.INSTANCE;
                                }
                            } else if (this.value.length() == 1) {
                                return new Resolution.Resolved(Character.valueOf(this.value.charAt(0)));
                            } else {
                                return Resolution.Unresolved.INSTANCE;
                            }
                        }
                    }

                    static {
                        HashMap hashMap = new HashMap();
                        WRAPPER_TYPES = hashMap;
                        hashMap.put(Boolean.TYPE, Boolean.class);
                        hashMap.put(Byte.TYPE, Byte.class);
                        hashMap.put(Short.TYPE, Short.class);
                        hashMap.put(Character.TYPE, Character.class);
                        hashMap.put(Integer.TYPE, Integer.class);
                        hashMap.put(Long.TYPE, Long.class);
                        hashMap.put(Float.TYPE, Float.class);
                        hashMap.put(Double.TYPE, Double.class);
                    }

                    public ForIndex(int i11, Object obj) {
                        this.index = i11;
                        this.value = obj;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForIndex forIndex = (ForIndex) obj;
                        return this.index == forIndex.index && this.value.equals(forIndex.value);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.index) * 31) + this.value.hashCode();
                    }

                    public Resolution resolve(int i11, Class<?> cls) {
                        if (this.index != i11) {
                            return Resolution.Unresolved.INSTANCE;
                        }
                        if (!cls.isPrimitive()) {
                            Object obj = this.value;
                            if (obj == null || cls.isInstance(obj)) {
                                return new Resolution.Resolved(this.value);
                            }
                            return Resolution.Unresolved.INSTANCE;
                        } else if (WRAPPER_TYPES.get(cls).isInstance(this.value)) {
                            return new Resolution.Resolved(this.value);
                        } else {
                            return Resolution.Unresolved.INSTANCE;
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForType<T> implements ArgumentResolver {
                    private final Class<? extends T> type;
                    private final T value;

                    public ForType(Class<? extends T> cls, T t11) {
                        this.type = cls;
                        this.value = t11;
                    }

                    public static <S> ArgumentResolver of(Class<? extends S> cls, S s11) {
                        return new ForType(cls, s11);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForType forType = (ForType) obj;
                        return this.type.equals(forType.type) && this.value.equals(forType.value);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.value.hashCode();
                    }

                    public Resolution resolve(int i11, Class<?> cls) {
                        return cls == this.type ? new Resolution.Resolved(this.value) : Resolution.Unresolved.INSTANCE;
                    }
                }

                public enum NoOp implements ArgumentResolver {
                    INSTANCE;

                    public Resolution resolve(int i11, Class<?> cls) {
                        return Resolution.Unresolved.INSTANCE;
                    }
                }

                public interface Resolution {

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Resolved implements Resolution {
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        private final Object argument;

                        public Resolved(Object obj) {
                            this.argument = obj;
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:17:0x0027 A[RETURN] */
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
                                java.lang.Object r2 = r4.argument
                                net.bytebuddy.build.Plugin$Factory$UsingReflection$ArgumentResolver$Resolution$Resolved r5 = (net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved) r5
                                java.lang.Object r5 = r5.argument
                                if (r5 == 0) goto L_0x0024
                                if (r2 == 0) goto L_0x0026
                                boolean r5 = r2.equals(r5)
                                if (r5 != 0) goto L_0x0027
                                return r1
                            L_0x0024:
                                if (r2 == 0) goto L_0x0027
                            L_0x0026:
                                return r1
                            L_0x0027:
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.Resolution.Resolved.equals(java.lang.Object):boolean");
                        }

                        public Object getArgument() {
                            return this.argument;
                        }

                        public int hashCode() {
                            int hashCode = getClass().hashCode() * 31;
                            Object obj = this.argument;
                            return obj != null ? hashCode + obj.hashCode() : hashCode;
                        }

                        public boolean isResolved() {
                            return true;
                        }
                    }

                    public enum Unresolved implements Resolution {
                        INSTANCE;

                        public Object getArgument() {
                            throw new IllegalStateException("Cannot get the argument for an unresolved parameter");
                        }

                        public boolean isResolved() {
                            return false;
                        }
                    }

                    Object getArgument();

                    boolean isResolved();
                }

                Resolution resolve(int i11, Class<?> cls);
            }

            public interface Instantiator {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Ambiguous implements Instantiator {
                    private final Constructor<?> left;
                    private final int parameters;
                    private final int priority;
                    private final Constructor<?> right;

                    public Ambiguous(Constructor<?> constructor, Constructor<?> constructor2, int i11, int i12) {
                        this.left = constructor;
                        this.right = constructor2;
                        this.priority = i11;
                        this.parameters = i12;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Ambiguous ambiguous = (Ambiguous) obj;
                        return this.priority == ambiguous.priority && this.parameters == ambiguous.parameters && this.left.equals(ambiguous.left) && this.right.equals(ambiguous.right);
                    }

                    public int hashCode() {
                        return (((((((getClass().hashCode() * 31) + this.left.hashCode()) * 31) + this.right.hashCode()) * 31) + this.priority) * 31) + this.parameters;
                    }

                    public Plugin instantiate() {
                        throw new IllegalStateException("Ambiguous constructors " + this.left + " and " + this.right);
                    }

                    public Instantiator replaceBy(Resolved resolved) {
                        int i11;
                        Priority priority2 = (Priority) resolved.a().getAnnotation(Priority.class);
                        int i12 = 0;
                        if (priority2 == null) {
                            i11 = 0;
                        } else {
                            i11 = priority2.value();
                        }
                        if (i11 > this.priority) {
                            return resolved;
                        }
                        if (priority2 != null) {
                            i12 = priority2.value();
                        }
                        if (i12 >= this.priority && resolved.a().getParameterTypes().length > this.parameters) {
                            return resolved;
                        }
                        return this;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Resolved implements Instantiator {
                    private final List<?> arguments;
                    private final Constructor<? extends Plugin> constructor;

                    public Resolved(Constructor<? extends Plugin> constructor2, List<?> list) {
                        this.constructor = constructor2;
                        this.arguments = list;
                    }

                    public Constructor<? extends Plugin> a() {
                        return this.constructor;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Resolved resolved = (Resolved) obj;
                        return this.constructor.equals(resolved.constructor) && this.arguments.equals(resolved.arguments);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.constructor.hashCode()) * 31) + this.arguments.hashCode();
                    }

                    public Plugin instantiate() {
                        try {
                            return (Plugin) this.constructor.newInstance(this.arguments.toArray(new Object[0]));
                        } catch (InstantiationException e11) {
                            throw new IllegalStateException("Failed to instantiate plugin via " + this.constructor, e11);
                        } catch (IllegalAccessException e12) {
                            throw new IllegalStateException("Failed to access " + this.constructor, e12);
                        } catch (InvocationTargetException e13) {
                            throw new IllegalStateException("Error during construction of" + this.constructor, e13.getTargetException());
                        }
                    }

                    public Instantiator replaceBy(Resolved resolved) {
                        int i11;
                        Class cls = Priority.class;
                        Priority priority = (Priority) this.constructor.getAnnotation(cls);
                        Priority priority2 = (Priority) resolved.a().getAnnotation(cls);
                        int i12 = 0;
                        if (priority == null) {
                            i11 = 0;
                        } else {
                            i11 = priority.value();
                        }
                        if (priority2 != null) {
                            i12 = priority2.value();
                        }
                        if (i11 > i12) {
                            return this;
                        }
                        if (i11 < i12) {
                            return resolved;
                        }
                        if (this.constructor.getParameterTypes().length > resolved.a().getParameterTypes().length) {
                            return this;
                        }
                        if (this.constructor.getParameterTypes().length < resolved.a().getParameterTypes().length) {
                            return resolved;
                        }
                        return new Ambiguous(this.constructor, resolved.a(), i11, this.constructor.getParameterTypes().length);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Unresolved implements Instantiator {
                    private final Class<? extends Plugin> type;

                    public Unresolved(Class<? extends Plugin> cls) {
                        this.type = cls;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.type.equals(((Unresolved) obj).type);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.type.hashCode();
                    }

                    public Plugin instantiate() {
                        throw new IllegalStateException("No constructor resolvable for " + this.type);
                    }

                    public Instantiator replaceBy(Resolved resolved) {
                        return resolved;
                    }
                }

                Plugin instantiate();

                Instantiator replaceBy(Resolved resolved);
            }

            @Documented
            @Target({ElementType.CONSTRUCTOR})
            @Retention(RetentionPolicy.RUNTIME)
            public @interface Priority {
                public static final int DEFAULT = 0;

                int value();
            }

            public UsingReflection(Class<? extends Plugin> cls) {
                this(cls, Collections.emptyList());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingReflection usingReflection = (UsingReflection) obj;
                return this.type.equals(usingReflection.type) && this.argumentResolvers.equals(usingReflection.argumentResolvers);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.argumentResolvers.hashCode();
            }

            public Plugin make() {
                boolean z11;
                Instantiator unresolved = new Instantiator.Unresolved(this.type);
                for (Constructor constructor : this.type.getConstructors()) {
                    if (!constructor.isSynthetic()) {
                        ArrayList arrayList = new ArrayList(constructor.getParameterTypes().length);
                        Class[] parameterTypes = constructor.getParameterTypes();
                        int length = parameterTypes.length;
                        int i11 = 0;
                        int i12 = 0;
                        while (true) {
                            if (i11 >= length) {
                                unresolved = unresolved.replaceBy(new Instantiator.Resolved(constructor, arrayList));
                                break;
                            }
                            Class cls = parameterTypes[i11];
                            Iterator<ArgumentResolver> it = this.argumentResolvers.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z11 = false;
                                    break;
                                }
                                ArgumentResolver.Resolution resolve = it.next().resolve(i12, cls);
                                if (resolve.isResolved()) {
                                    arrayList.add(resolve.getArgument());
                                    z11 = true;
                                    break;
                                }
                            }
                            if (!z11) {
                                break;
                            }
                            i12++;
                            i11++;
                        }
                    }
                }
                return unresolved.instantiate();
            }

            public UsingReflection with(ArgumentResolver... argumentResolverArr) {
                return with((List<? extends ArgumentResolver>) Arrays.asList(argumentResolverArr));
            }

            public UsingReflection(Class<? extends Plugin> cls, List<ArgumentResolver> list) {
                this.type = cls;
                this.argumentResolvers = list;
            }

            public UsingReflection with(List<? extends ArgumentResolver> list) {
                return new UsingReflection(this.type, CompoundList.of(list, (List<? extends ArgumentResolver>) this.argumentResolvers));
            }
        }

        Plugin make();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class ForElementMatcher implements Plugin {
        private final ElementMatcher<? super TypeDescription> matcher;

        public ForElementMatcher(ElementMatcher<? super TypeDescription> elementMatcher) {
            this.matcher = elementMatcher;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.matcher.equals(((ForElementMatcher) obj).matcher);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.matcher.hashCode();
        }

        public boolean matches(TypeDescription typeDescription) {
            return this.matcher.matches(typeDescription);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class NoOp implements Plugin, Factory {
        public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            throw new IllegalStateException("Cannot apply non-operational plugin");
        }

        public void close() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        public Plugin make() {
            return this;
        }

        public boolean matches(TypeDescription typeDescription) {
            return false;
        }
    }

    public interface WithPreprocessor extends Plugin {
        void onPreprocess(TypeDescription typeDescription, ClassFileLocator classFileLocator);
    }

    DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator);

    public interface Engine {
        public static final String CLASS_FILE_EXTENSION = ".class";

        public static abstract class AbstractBase implements Engine {
            public Summary apply(File file, File file2, Factory... factoryArr) throws IOException {
                return apply(file, file2, (List<? extends Factory>) Arrays.asList(factoryArr));
            }

            public Engine withErrorHandlers(ErrorHandler... errorHandlerArr) {
                return withErrorHandlers((List<? extends ErrorHandler>) Arrays.asList(errorHandlerArr));
            }

            public Engine withParallelTransformation(int i11) {
                if (i11 >= 1) {
                    return with((Dispatcher.Factory) new Dispatcher.ForParallelTransformation.WithThrowawayExecutorService.Factory(i11));
                }
                throw new IllegalArgumentException("Number of threads must be positive: " + i11);
            }

            public Summary apply(File file, File file2, List<? extends Factory> list) throws IOException {
                return apply(file.isDirectory() ? new Source.ForFolder(file) : new Source.ForJarFile(file), file2.isDirectory() ? new Target.ForFolder(file2) : new Target.ForJarFile(file2), list);
            }

            public Summary apply(Source source, Target target, Factory... factoryArr) throws IOException {
                return apply(source, target, (List<? extends Factory>) Arrays.asList(factoryArr));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Default extends AbstractBase {
            /* access modifiers changed from: private */
            public final ByteBuddy byteBuddy;
            private final ClassFileLocator classFileLocator;
            private final Dispatcher.Factory dispatcherFactory;
            private final ErrorHandler errorHandler;
            /* access modifiers changed from: private */
            public final ElementMatcher.Junction<? super TypeDescription> ignoredTypeMatcher;
            private final Listener listener;
            private final PoolStrategy poolStrategy;
            /* access modifiers changed from: private */
            public final TypeStrategy typeStrategy;

            public class Preprocessor implements Callable<Callable<? extends Dispatcher.Materializable>> {
                /* access modifiers changed from: private */
                public final ClassFileLocator classFileLocator;
                /* access modifiers changed from: private */
                public final Source.Element element;
                /* access modifiers changed from: private */
                public final Listener listener;
                /* access modifiers changed from: private */
                public final List<Plugin> plugins;
                private final List<WithPreprocessor> preprocessors;
                /* access modifiers changed from: private */
                public final String typeName;
                /* access modifiers changed from: private */
                public final TypePool typePool;

                public class Ignored implements Callable<Dispatcher.Materializable> {
                    private final TypeDescription typeDescription;

                    private Ignored(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    /* JADX INFO: finally extract failed */
                    public Dispatcher.Materializable call() {
                        try {
                            Preprocessor.this.listener.onIgnored(this.typeDescription, (List<Plugin>) Preprocessor.this.plugins);
                            Preprocessor.this.listener.onComplete(this.typeDescription);
                            return new Dispatcher.Materializable.ForRetainedElement(Preprocessor.this.element);
                        } catch (Throwable th2) {
                            Preprocessor.this.listener.onComplete(this.typeDescription);
                            throw th2;
                        }
                    }
                }

                public class Resolved implements Callable<Dispatcher.Materializable> {
                    private final TypeDescription typeDescription;

                    private Resolved(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    public Dispatcher.Materializable call() {
                        Dispatcher.Materializable forRetainedElement;
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        try {
                            DynamicType.Builder<?> builder = Default.this.typeStrategy.builder(Default.this.byteBuddy, this.typeDescription, Preprocessor.this.classFileLocator);
                            for (Plugin plugin : Preprocessor.this.plugins) {
                                if (plugin.matches(this.typeDescription)) {
                                    builder = plugin.apply(builder, this.typeDescription, Preprocessor.this.classFileLocator);
                                    Preprocessor.this.listener.onTransformation(this.typeDescription, plugin);
                                    arrayList.add(plugin);
                                } else {
                                    Preprocessor.this.listener.onIgnored(this.typeDescription, plugin);
                                    arrayList2.add(plugin);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                Preprocessor.this.listener.onError(this.typeDescription, (List<Throwable>) arrayList3);
                                forRetainedElement = new Dispatcher.Materializable.ForFailedElement(Preprocessor.this.element, this.typeDescription, arrayList3);
                            } else if (!arrayList.isEmpty()) {
                                DynamicType.Unloaded<?> make = builder.make(TypeResolutionStrategy.Disabled.INSTANCE, Preprocessor.this.typePool);
                                Preprocessor.this.listener.onTransformation(this.typeDescription, (List<Plugin>) arrayList);
                                for (Map.Entry next : make.getLoadedTypeInitializers().entrySet()) {
                                    if (((LoadedTypeInitializer) next.getValue()).isAlive()) {
                                        Preprocessor.this.listener.onLiveInitializer(this.typeDescription, (TypeDescription) next.getKey());
                                    }
                                }
                                forRetainedElement = new Dispatcher.Materializable.ForTransformedElement(make);
                            } else {
                                Preprocessor.this.listener.onIgnored(this.typeDescription, (List<Plugin>) arrayList2);
                                forRetainedElement = new Dispatcher.Materializable.ForRetainedElement(Preprocessor.this.element);
                            }
                            Preprocessor.this.listener.onComplete(this.typeDescription);
                            return forRetainedElement;
                        } catch (Throwable th2) {
                            Preprocessor.this.listener.onComplete(this.typeDescription);
                            throw th2;
                        }
                    }
                }

                public class Unresolved implements Callable<Dispatcher.Materializable> {
                    private Unresolved() {
                    }

                    public Dispatcher.Materializable call() {
                        Preprocessor.this.listener.onUnresolved(Preprocessor.this.typeName);
                        return new Dispatcher.Materializable.ForUnresolvedElement(Preprocessor.this.element, Preprocessor.this.typeName);
                    }
                }

                private Preprocessor(Source.Element element2, String str, ClassFileLocator classFileLocator2, TypePool typePool2, Listener listener2, List<Plugin> list, List<WithPreprocessor> list2) {
                    this.element = element2;
                    this.typeName = str;
                    this.classFileLocator = classFileLocator2;
                    this.typePool = typePool2;
                    this.listener = listener2;
                    this.plugins = list;
                    this.preprocessors = list2;
                }

                public Callable<Dispatcher.Materializable> call() throws Exception {
                    this.listener.onDiscovery(this.typeName);
                    TypePool.Resolution describe = this.typePool.describe(this.typeName);
                    if (!describe.isResolved()) {
                        return new Unresolved();
                    }
                    TypeDescription resolve = describe.resolve();
                    try {
                        if (Default.this.ignoredTypeMatcher.matches(resolve)) {
                            return new Ignored(resolve);
                        }
                        for (WithPreprocessor onPreprocess : this.preprocessors) {
                            onPreprocess.onPreprocess(resolve, this.classFileLocator);
                        }
                        return new Resolved(resolve);
                    } catch (Throwable th2) {
                        this.listener.onComplete(resolve);
                        if (th2 instanceof Exception) {
                            throw ((Exception) th2);
                        } else if (th2 instanceof Error) {
                            throw th2;
                        } else {
                            throw new IllegalStateException(th2);
                        }
                    }
                }
            }

            public Default() {
                this(new ByteBuddy());
            }

            public static void main(String... strArr) throws ClassNotFoundException, IOException {
                if (strArr.length >= 2) {
                    ArrayList arrayList = new ArrayList(strArr.length - 2);
                    for (String cls : Arrays.asList(strArr).subList(2, strArr.length)) {
                        arrayList.add(new Factory.UsingReflection(Class.forName(cls)));
                    }
                    new Default().apply(new File(strArr[0]), new File(strArr[1]), (List<? extends Factory>) arrayList);
                    return;
                }
                throw new IllegalArgumentException("Expected arguments: <source> <target> [<plugin>, ...]");
            }

            public static Engine of(EntryPoint entryPoint, ClassFileVersion classFileVersion, MethodNameTransformer methodNameTransformer) {
                return new Default(entryPoint.byteBuddy(classFileVersion), new TypeStrategy.ForEntryPoint(entryPoint, methodNameTransformer));
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: net.bytebuddy.build.Plugin$Engine$Dispatcher} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: net.bytebuddy.build.Plugin$Engine$Dispatcher} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: net.bytebuddy.build.Plugin$Engine$Default} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: net.bytebuddy.build.Plugin$Engine$Dispatcher} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: net.bytebuddy.build.Plugin$Engine$Default} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: net.bytebuddy.build.Plugin$Engine$Dispatcher} */
            /* JADX WARNING: type inference failed for: r2v26 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x01c8  */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x0156=Splitter:B:50:0x0156, B:89:0x01ab=Splitter:B:89:0x01ab} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.build.Plugin.Engine.Summary apply(net.bytebuddy.build.Plugin.Engine.Source r26, net.bytebuddy.build.Plugin.Engine.Target r27, java.util.List<? extends net.bytebuddy.build.Plugin.Factory> r28) throws java.io.IOException {
                /*
                    r25 = this;
                    r11 = r25
                    net.bytebuddy.build.Plugin$Engine$Listener$Compound r12 = new net.bytebuddy.build.Plugin$Engine$Listener$Compound
                    r0 = 2
                    net.bytebuddy.build.Plugin$Engine$Listener[] r1 = new net.bytebuddy.build.Plugin.Engine.Listener[r0]
                    net.bytebuddy.build.Plugin$Engine$Listener r2 = r11.listener
                    r13 = 0
                    r1[r13] = r2
                    net.bytebuddy.build.Plugin$Engine$Listener$ForErrorHandler r2 = new net.bytebuddy.build.Plugin$Engine$Listener$ForErrorHandler
                    net.bytebuddy.build.Plugin$Engine$ErrorHandler r3 = r11.errorHandler
                    r2.<init>(r3)
                    r14 = 1
                    r1[r14] = r2
                    r12.<init>((net.bytebuddy.build.Plugin.Engine.Listener[]) r1)
                    java.util.ArrayList r15 = new java.util.ArrayList
                    r15.<init>()
                    java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
                    r10.<init>()
                    java.util.ArrayList r9 = new java.util.ArrayList
                    r9.<init>()
                    java.util.ArrayList r8 = new java.util.ArrayList
                    int r1 = r28.size()
                    r8.<init>(r1)
                    java.util.ArrayList r7 = new java.util.ArrayList
                    r7.<init>()
                    r16 = 0
                    java.util.Iterator r1 = r28.iterator()     // Catch:{ all -> 0x01ba }
                L_0x003c:
                    boolean r2 = r1.hasNext()     // Catch:{ all -> 0x01ba }
                    if (r2 == 0) goto L_0x005f
                    java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0059 }
                    net.bytebuddy.build.Plugin$Factory r2 = (net.bytebuddy.build.Plugin.Factory) r2     // Catch:{ all -> 0x0059 }
                    net.bytebuddy.build.Plugin r2 = r2.make()     // Catch:{ all -> 0x0059 }
                    r8.add(r2)     // Catch:{ all -> 0x0059 }
                    boolean r3 = r2 instanceof net.bytebuddy.build.Plugin.WithPreprocessor     // Catch:{ all -> 0x0059 }
                    if (r3 == 0) goto L_0x003c
                    net.bytebuddy.build.Plugin$WithPreprocessor r2 = (net.bytebuddy.build.Plugin.WithPreprocessor) r2     // Catch:{ all -> 0x0059 }
                    r7.add(r2)     // Catch:{ all -> 0x0059 }
                    goto L_0x003c
                L_0x0059:
                    r0 = move-exception
                    r1 = r0
                    r24 = r8
                    goto L_0x01be
                L_0x005f:
                    net.bytebuddy.build.Plugin$Engine$Source$Origin r17 = r26.read()     // Catch:{ all -> 0x01ba }
                    net.bytebuddy.dynamic.ClassFileLocator$Compound r6 = new net.bytebuddy.dynamic.ClassFileLocator$Compound     // Catch:{ all -> 0x01b1 }
                    net.bytebuddy.dynamic.ClassFileLocator[] r0 = new net.bytebuddy.dynamic.ClassFileLocator[r0]     // Catch:{ all -> 0x01b1 }
                    net.bytebuddy.dynamic.ClassFileLocator r1 = r17.getClassFileLocator()     // Catch:{ all -> 0x01b1 }
                    r0[r13] = r1     // Catch:{ all -> 0x01b1 }
                    net.bytebuddy.dynamic.ClassFileLocator r1 = r11.classFileLocator     // Catch:{ all -> 0x01b1 }
                    r0[r14] = r1     // Catch:{ all -> 0x01b1 }
                    r6.<init>((net.bytebuddy.dynamic.ClassFileLocator[]) r0)     // Catch:{ all -> 0x01b1 }
                    net.bytebuddy.build.Plugin$Engine$PoolStrategy r0 = r11.poolStrategy     // Catch:{ all -> 0x01b1 }
                    net.bytebuddy.pool.TypePool r0 = r0.typePool(r6)     // Catch:{ all -> 0x01b1 }
                    java.util.jar.Manifest r1 = r17.getManifest()     // Catch:{ all -> 0x01b1 }
                    r12.onManifest(r1)     // Catch:{ all -> 0x01b1 }
                    r2 = r27
                    net.bytebuddy.build.Plugin$Engine$Target$Sink r5 = r2.write(r1)     // Catch:{ all -> 0x01b1 }
                    net.bytebuddy.build.Plugin$Engine$Dispatcher$Factory r1 = r11.dispatcherFactory     // Catch:{ all -> 0x01a7 }
                    net.bytebuddy.build.Plugin$Engine$Dispatcher r4 = r1.make(r5, r15, r10, r9)     // Catch:{ all -> 0x01a7 }
                    java.util.Iterator r18 = r17.iterator()     // Catch:{ all -> 0x019c }
                L_0x0091:
                    boolean r1 = r18.hasNext()     // Catch:{ all -> 0x019c }
                    if (r1 == 0) goto L_0x013b
                    java.lang.Object r1 = r18.next()     // Catch:{ all -> 0x019c }
                    r3 = r1
                    net.bytebuddy.build.Plugin$Engine$Source$Element r3 = (net.bytebuddy.build.Plugin.Engine.Source.Element) r3     // Catch:{ all -> 0x019c }
                    boolean r1 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x019c }
                    if (r1 != 0) goto L_0x0128
                    java.lang.String r1 = r3.getName()     // Catch:{ all -> 0x019c }
                L_0x00a8:
                    java.lang.String r2 = "/"
                    boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x019c }
                    if (r2 == 0) goto L_0x00b5
                    java.lang.String r1 = r1.substring(r14)     // Catch:{ all -> 0x019c }
                    goto L_0x00a8
                L_0x00b5:
                    java.lang.String r2 = ".class"
                    boolean r2 = r1.endsWith(r2)     // Catch:{ all -> 0x019c }
                    if (r2 == 0) goto L_0x00fe
                    net.bytebuddy.build.Plugin$Engine$Default$Preprocessor r2 = new net.bytebuddy.build.Plugin$Engine$Default$Preprocessor     // Catch:{ all -> 0x019c }
                    int r19 = r1.length()     // Catch:{ all -> 0x019c }
                    int r14 = r19 + -6
                    java.lang.String r1 = r1.substring(r13, r14)     // Catch:{ all -> 0x019c }
                    r14 = 47
                    r13 = 46
                    java.lang.String r13 = r1.replace(r14, r13)     // Catch:{ all -> 0x019c }
                    r14 = 0
                    r1 = r2
                    r20 = r2
                    r2 = r25
                    r21 = r4
                    r4 = r13
                    r13 = r5
                    r5 = r6
                    r22 = r6
                    r6 = r0
                    r23 = r7
                    r7 = r12
                    r24 = r8
                    r11 = r9
                    r9 = r23
                    r26 = r10
                    r10 = r14
                    r1.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00f9 }
                    boolean r1 = r23.isEmpty()     // Catch:{ all -> 0x00f9 }
                    r3 = r20
                    r2 = r21
                    r2.accept(r3, r1)     // Catch:{ all -> 0x019a }
                    goto L_0x0117
                L_0x00f9:
                    r0 = move-exception
                    r2 = r21
                    goto L_0x01a1
                L_0x00fe:
                    r2 = r4
                    r13 = r5
                    r22 = r6
                    r23 = r7
                    r24 = r8
                    r11 = r9
                    r26 = r10
                    java.lang.String r4 = "META-INF/MANIFEST.MF"
                    boolean r4 = r1.equals(r4)     // Catch:{ all -> 0x019a }
                    if (r4 != 0) goto L_0x0117
                    r12.onResource(r1)     // Catch:{ all -> 0x019a }
                    r13.retain(r3)     // Catch:{ all -> 0x019a }
                L_0x0117:
                    r10 = r26
                    r4 = r2
                    r9 = r11
                    r5 = r13
                    r6 = r22
                    r7 = r23
                    r8 = r24
                    r13 = 0
                    r14 = 1
                    r11 = r25
                    goto L_0x0091
                L_0x0128:
                    r2 = r4
                    r13 = r5
                    r24 = r8
                    java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x019a }
                    r0.interrupt()     // Catch:{ all -> 0x019a }
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x019a }
                    java.lang.String r1 = "Thread interrupted during plugin engine application"
                    r0.<init>(r1)     // Catch:{ all -> 0x019a }
                    throw r0     // Catch:{ all -> 0x019a }
                L_0x013b:
                    r2 = r4
                    r13 = r5
                    r24 = r8
                    r11 = r9
                    r26 = r10
                    r2.complete()     // Catch:{ all -> 0x019a }
                    r2.close()     // Catch:{ all -> 0x01a5 }
                    boolean r0 = r26.isEmpty()     // Catch:{ all -> 0x01a5 }
                    if (r0 != 0) goto L_0x0154
                    r1 = r26
                    r12.onError(r1)     // Catch:{ all -> 0x01a5 }
                    goto L_0x0156
                L_0x0154:
                    r1 = r26
                L_0x0156:
                    r13.close()     // Catch:{ all -> 0x01af }
                    r17.close()     // Catch:{ all -> 0x01b8 }
                    java.util.Iterator r2 = r24.iterator()
                    r3 = r16
                L_0x0162:
                    boolean r0 = r2.hasNext()
                    if (r0 == 0) goto L_0x017e
                    java.lang.Object r0 = r2.next()
                    r4 = r0
                    net.bytebuddy.build.Plugin r4 = (net.bytebuddy.build.Plugin) r4
                    r4.close()     // Catch:{ all -> 0x0173 }
                    goto L_0x0162
                L_0x0173:
                    r0 = move-exception
                    r5 = r0
                    r12.onError((net.bytebuddy.build.Plugin) r4, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0179 }
                    goto L_0x0162
                L_0x0179:
                    r0 = move-exception
                    if (r3 != 0) goto L_0x0162
                    r3 = r0
                    goto L_0x0162
                L_0x017e:
                    if (r3 != 0) goto L_0x0186
                    net.bytebuddy.build.Plugin$Engine$Summary r0 = new net.bytebuddy.build.Plugin$Engine$Summary
                    r0.<init>(r15, r1, r11)
                    return r0
                L_0x0186:
                    boolean r0 = r3 instanceof java.io.IOException
                    if (r0 != 0) goto L_0x0197
                    boolean r0 = r3 instanceof java.lang.RuntimeException
                    if (r0 == 0) goto L_0x0191
                    java.lang.RuntimeException r3 = (java.lang.RuntimeException) r3
                    throw r3
                L_0x0191:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    r0.<init>(r3)
                    throw r0
                L_0x0197:
                    java.io.IOException r3 = (java.io.IOException) r3
                    throw r3
                L_0x019a:
                    r0 = move-exception
                    goto L_0x01a1
                L_0x019c:
                    r0 = move-exception
                    r2 = r4
                    r13 = r5
                    r24 = r8
                L_0x01a1:
                    r2.close()     // Catch:{ all -> 0x01a5 }
                    throw r0     // Catch:{ all -> 0x01a5 }
                L_0x01a5:
                    r0 = move-exception
                    goto L_0x01ab
                L_0x01a7:
                    r0 = move-exception
                    r13 = r5
                    r24 = r8
                L_0x01ab:
                    r13.close()     // Catch:{ all -> 0x01af }
                    throw r0     // Catch:{ all -> 0x01af }
                L_0x01af:
                    r0 = move-exception
                    goto L_0x01b4
                L_0x01b1:
                    r0 = move-exception
                    r24 = r8
                L_0x01b4:
                    r17.close()     // Catch:{ all -> 0x01b8 }
                    throw r0     // Catch:{ all -> 0x01b8 }
                L_0x01b8:
                    r0 = move-exception
                    goto L_0x01bd
                L_0x01ba:
                    r0 = move-exception
                    r24 = r8
                L_0x01bd:
                    r1 = r0
                L_0x01be:
                    java.util.Iterator r2 = r24.iterator()
                L_0x01c2:
                    boolean r0 = r2.hasNext()
                    if (r0 == 0) goto L_0x01df
                    java.lang.Object r0 = r2.next()
                    r3 = r0
                    net.bytebuddy.build.Plugin r3 = (net.bytebuddy.build.Plugin) r3
                    r3.close()     // Catch:{ all -> 0x01d3 }
                    goto L_0x01c2
                L_0x01d3:
                    r0 = move-exception
                    r4 = r0
                    r12.onError((net.bytebuddy.build.Plugin) r3, (java.lang.Throwable) r4)     // Catch:{ all -> 0x01d9 }
                    goto L_0x01c2
                L_0x01d9:
                    r0 = move-exception
                    if (r16 != 0) goto L_0x01c2
                    r16 = r0
                    goto L_0x01c2
                L_0x01df:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.build.Plugin.Engine.Default.apply(net.bytebuddy.build.Plugin$Engine$Source, net.bytebuddy.build.Plugin$Engine$Target, java.util.List):net.bytebuddy.build.Plugin$Engine$Summary");
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Default defaultR = (Default) obj;
                return this.byteBuddy.equals(defaultR.byteBuddy) && this.typeStrategy.equals(defaultR.typeStrategy) && this.poolStrategy.equals(defaultR.poolStrategy) && this.classFileLocator.equals(defaultR.classFileLocator) && this.listener.equals(defaultR.listener) && this.errorHandler.equals(defaultR.errorHandler) && this.dispatcherFactory.equals(defaultR.dispatcherFactory) && this.ignoredTypeMatcher.equals(defaultR.ignoredTypeMatcher);
            }

            public int hashCode() {
                return (((((((((((((((getClass().hashCode() * 31) + this.byteBuddy.hashCode()) * 31) + this.typeStrategy.hashCode()) * 31) + this.poolStrategy.hashCode()) * 31) + this.classFileLocator.hashCode()) * 31) + this.listener.hashCode()) * 31) + this.errorHandler.hashCode()) * 31) + this.dispatcherFactory.hashCode()) * 31) + this.ignoredTypeMatcher.hashCode();
            }

            public Engine ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher.or(elementMatcher));
            }

            public Engine with(ByteBuddy byteBuddy2) {
                return new Default(byteBuddy2, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            public Engine withErrorHandlers(List<? extends ErrorHandler> list) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, new ErrorHandler.Compound(list), this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            public Engine withoutErrorHandlers() {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, Listener.NoOp.INSTANCE, this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            public Default(ByteBuddy byteBuddy2) {
                this(byteBuddy2, TypeStrategy.Default.REBASE);
            }

            public Engine with(TypeStrategy typeStrategy2) {
                return new Default(this.byteBuddy, typeStrategy2, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Default(net.bytebuddy.ByteBuddy r10, net.bytebuddy.build.Plugin.Engine.TypeStrategy r11) {
                /*
                    r9 = this;
                    net.bytebuddy.build.Plugin$Engine$PoolStrategy$Default r3 = net.bytebuddy.build.Plugin.Engine.PoolStrategy.Default.FAST
                    net.bytebuddy.dynamic.ClassFileLocator$NoOp r4 = net.bytebuddy.dynamic.ClassFileLocator.NoOp.INSTANCE
                    net.bytebuddy.build.Plugin$Engine$Listener$NoOp r5 = net.bytebuddy.build.Plugin.Engine.Listener.NoOp.INSTANCE
                    net.bytebuddy.build.Plugin$Engine$ErrorHandler$Compound r6 = new net.bytebuddy.build.Plugin$Engine$ErrorHandler$Compound
                    r0 = 3
                    net.bytebuddy.build.Plugin$Engine$ErrorHandler[] r0 = new net.bytebuddy.build.Plugin.Engine.ErrorHandler[r0]
                    r1 = 0
                    net.bytebuddy.build.Plugin$Engine$ErrorHandler$Failing r2 = net.bytebuddy.build.Plugin.Engine.ErrorHandler.Failing.FAIL_FAST
                    r0[r1] = r2
                    r1 = 1
                    net.bytebuddy.build.Plugin$Engine$ErrorHandler$Enforcing r2 = net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing.ALL_TYPES_RESOLVED
                    r0[r1] = r2
                    r1 = 2
                    net.bytebuddy.build.Plugin$Engine$ErrorHandler$Enforcing r2 = net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing.NO_LIVE_INITIALIZERS
                    r0[r1] = r2
                    r6.<init>((net.bytebuddy.build.Plugin.Engine.ErrorHandler[]) r0)
                    net.bytebuddy.build.Plugin$Engine$Dispatcher$ForSerialTransformation$Factory r7 = net.bytebuddy.build.Plugin.Engine.Dispatcher.ForSerialTransformation.Factory.INSTANCE
                    net.bytebuddy.matcher.ElementMatcher$Junction r8 = net.bytebuddy.matcher.ElementMatchers.none()
                    r0 = r9
                    r1 = r10
                    r2 = r11
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.build.Plugin.Engine.Default.<init>(net.bytebuddy.ByteBuddy, net.bytebuddy.build.Plugin$Engine$TypeStrategy):void");
            }

            public Engine with(PoolStrategy poolStrategy2) {
                return new Default(this.byteBuddy, this.typeStrategy, poolStrategy2, this.classFileLocator, this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            public Engine with(ClassFileLocator classFileLocator2) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, new ClassFileLocator.Compound(this.classFileLocator, classFileLocator2), this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            public Engine with(Listener listener2) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, new Listener.Compound(this.listener, listener2), this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            public Default(ByteBuddy byteBuddy2, TypeStrategy typeStrategy2, PoolStrategy poolStrategy2, ClassFileLocator classFileLocator2, Listener listener2, ErrorHandler errorHandler2, Dispatcher.Factory factory, ElementMatcher.Junction<? super TypeDescription> junction) {
                this.byteBuddy = byteBuddy2;
                this.typeStrategy = typeStrategy2;
                this.poolStrategy = poolStrategy2;
                this.classFileLocator = classFileLocator2;
                this.listener = listener2;
                this.errorHandler = errorHandler2;
                this.dispatcherFactory = factory;
                this.ignoredTypeMatcher = junction;
            }

            public Engine with(Dispatcher.Factory factory) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator, this.listener, this.errorHandler, factory, this.ignoredTypeMatcher);
            }
        }

        public interface Dispatcher extends Closeable {

            public interface Factory {
                Dispatcher make(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2);
            }

            public static class ForParallelTransformation implements Dispatcher {
                private int deferred;
                private final Map<TypeDescription, List<Throwable>> failed;
                private final Set<Future<?>> futures = new HashSet();
                private final CompletionService<Materializable> materializers;
                private final CompletionService<Callable<Materializable>> preprocessings;
                private final Target.Sink sink;
                private final List<TypeDescription> transformed;
                private final List<String> unresolved;

                @HashCodeAndEqualsPlugin.Enhance
                public static class EagerWork implements Callable<Materializable> {
                    private final Callable<? extends Callable<? extends Materializable>> work;

                    public EagerWork(Callable<? extends Callable<? extends Materializable>> callable) {
                        this.work = callable;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.work.equals(((EagerWork) obj).work);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.work.hashCode();
                    }

                    public Materializable call() throws Exception {
                        return (Materializable) ((Callable) this.work.call()).call();
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory implements Factory {
                    private final Executor executor;

                    public Factory(Executor executor2) {
                        this.executor = executor2;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.executor.equals(((Factory) obj).executor);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.executor.hashCode();
                    }

                    public Dispatcher make(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        return new ForParallelTransformation(this.executor, sink, list, map, list2);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithThrowawayExecutorService extends ForParallelTransformation {
                    private final ExecutorService executorService;

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory {
                        private final int threads;

                        public Factory(int i11) {
                            this.threads = i11;
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.threads == ((Factory) obj).threads;
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.threads;
                        }

                        public Dispatcher make(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                            return new WithThrowawayExecutorService(Executors.newFixedThreadPool(this.threads), sink, list, map, list2);
                        }
                    }

                    public WithThrowawayExecutorService(ExecutorService executorService2, Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        super(executorService2, sink, list, map, list2);
                        this.executorService = executorService2;
                    }

                    public void close() {
                        try {
                            super.close();
                        } finally {
                            this.executorService.shutdown();
                        }
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.executorService.equals(((WithThrowawayExecutorService) obj).executorService);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.executorService.hashCode();
                    }
                }

                public ForParallelTransformation(Executor executor, Target.Sink sink2, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                    this.sink = sink2;
                    this.transformed = list;
                    this.failed = map;
                    this.unresolved = list2;
                    this.preprocessings = new ExecutorCompletionService(executor);
                    this.materializers = new ExecutorCompletionService(executor);
                }

                public void accept(Callable<? extends Callable<? extends Materializable>> callable, boolean z11) {
                    if (z11) {
                        this.futures.add(this.materializers.submit(new EagerWork(callable)));
                        return;
                    }
                    this.deferred++;
                    this.futures.add(this.preprocessings.submit(callable));
                }

                public void close() {
                    for (Future<?> cancel : this.futures) {
                        cancel.cancel(true);
                    }
                }

                public void complete() throws IOException {
                    try {
                        ArrayList<Callable> arrayList = new ArrayList<>(this.deferred);
                        while (true) {
                            int i11 = this.deferred;
                            this.deferred = i11 - 1;
                            if (i11 <= 0) {
                                break;
                            }
                            Future<Callable<Materializable>> take = this.preprocessings.take();
                            this.futures.remove(take);
                            arrayList.add(take.get());
                        }
                        for (Callable submit : arrayList) {
                            this.futures.add(this.materializers.submit(submit));
                        }
                        while (!this.futures.isEmpty()) {
                            Future<Materializable> take2 = this.materializers.take();
                            this.futures.remove(take2);
                            take2.get().materialize(this.sink, this.transformed, this.failed, this.unresolved);
                        }
                    } catch (InterruptedException e11) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException(e11);
                    } catch (ExecutionException e12) {
                        Throwable cause = e12.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        } else if (cause instanceof RuntimeException) {
                            throw ((RuntimeException) cause);
                        } else if (cause instanceof Error) {
                            throw ((Error) cause);
                        } else {
                            throw new IllegalStateException(cause);
                        }
                    }
                }
            }

            public static class ForSerialTransformation implements Dispatcher {
                private final Map<TypeDescription, List<Throwable>> failed;
                private final List<Callable<? extends Materializable>> preprocessings = new ArrayList();
                private final Target.Sink sink;
                private final List<TypeDescription> transformed;
                private final List<String> unresolved;

                public enum Factory implements Factory {
                    INSTANCE;

                    public Dispatcher make(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        return new ForSerialTransformation(sink, list, map, list2);
                    }
                }

                public ForSerialTransformation(Target.Sink sink2, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                    this.sink = sink2;
                    this.transformed = list;
                    this.failed = map;
                    this.unresolved = list2;
                }

                public void accept(Callable<? extends Callable<? extends Materializable>> callable, boolean z11) throws IOException {
                    try {
                        Callable callable2 = (Callable) callable.call();
                        if (z11) {
                            ((Materializable) callable2.call()).materialize(this.sink, this.transformed, this.failed, this.unresolved);
                        } else {
                            this.preprocessings.add(callable2);
                        }
                    } catch (Exception e11) {
                        if (e11 instanceof IOException) {
                            throw ((IOException) e11);
                        } else if (e11 instanceof RuntimeException) {
                            throw ((RuntimeException) e11);
                        } else {
                            throw new IllegalStateException(e11);
                        }
                    }
                }

                public void close() {
                }

                public void complete() throws IOException {
                    for (Callable next : this.preprocessings) {
                        if (!Thread.interrupted()) {
                            try {
                                ((Materializable) next.call()).materialize(this.sink, this.transformed, this.failed, this.unresolved);
                            } catch (Exception e11) {
                                if (e11 instanceof IOException) {
                                    throw ((IOException) e11);
                                } else if (e11 instanceof RuntimeException) {
                                    throw ((RuntimeException) e11);
                                } else {
                                    throw new IllegalStateException(e11);
                                }
                            }
                        } else {
                            Thread.currentThread().interrupt();
                            throw new IllegalStateException("Interrupted during plugin engine completion");
                        }
                    }
                }
            }

            public interface Materializable {

                public static class ForFailedElement implements Materializable {
                    private final Source.Element element;
                    private final List<Throwable> errored;
                    private final TypeDescription typeDescription;

                    public ForFailedElement(Source.Element element2, TypeDescription typeDescription2, List<Throwable> list) {
                        this.element = element2;
                        this.typeDescription = typeDescription2;
                        this.errored = list;
                    }

                    public void materialize(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) throws IOException {
                        sink.retain(this.element);
                        map.put(this.typeDescription, this.errored);
                    }
                }

                public static class ForRetainedElement implements Materializable {
                    private final Source.Element element;

                    public ForRetainedElement(Source.Element element2) {
                        this.element = element2;
                    }

                    public void materialize(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) throws IOException {
                        sink.retain(this.element);
                    }
                }

                public static class ForTransformedElement implements Materializable {
                    private final DynamicType dynamicType;

                    public ForTransformedElement(DynamicType dynamicType2) {
                        this.dynamicType = dynamicType2;
                    }

                    public void materialize(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) throws IOException {
                        sink.store(this.dynamicType.getAllTypes());
                        list.add(this.dynamicType.getTypeDescription());
                    }
                }

                public static class ForUnresolvedElement implements Materializable {
                    private final Source.Element element;
                    private final String typeName;

                    public ForUnresolvedElement(Source.Element element2, String str) {
                        this.element = element2;
                        this.typeName = str;
                    }

                    public void materialize(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) throws IOException {
                        sink.retain(this.element);
                        list2.add(this.typeName);
                    }
                }

                void materialize(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) throws IOException;
            }

            void accept(Callable<? extends Callable<? extends Materializable>> callable, boolean z11) throws IOException;

            void complete() throws IOException;
        }

        public interface ErrorHandler {

            public static class Compound implements ErrorHandler {
                private final List<ErrorHandler> errorHandlers;

                public Compound(ErrorHandler... errorHandlerArr) {
                    this((List<? extends ErrorHandler>) Arrays.asList(errorHandlerArr));
                }

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    for (ErrorHandler onError : this.errorHandlers) {
                        onError.onError(typeDescription, plugin, th2);
                    }
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    for (ErrorHandler onLiveInitializer : this.errorHandlers) {
                        onLiveInitializer.onLiveInitializer(typeDescription, typeDescription2);
                    }
                }

                public void onManifest(Manifest manifest) {
                    for (ErrorHandler onManifest : this.errorHandlers) {
                        onManifest.onManifest(manifest);
                    }
                }

                public void onResource(String str) {
                    for (ErrorHandler onResource : this.errorHandlers) {
                        onResource.onResource(str);
                    }
                }

                public void onUnresolved(String str) {
                    for (ErrorHandler onUnresolved : this.errorHandlers) {
                        onUnresolved.onUnresolved(str);
                    }
                }

                public Compound(List<? extends ErrorHandler> list) {
                    this.errorHandlers = new ArrayList();
                    for (ErrorHandler errorHandler : list) {
                        if (errorHandler instanceof Compound) {
                            this.errorHandlers.addAll(((Compound) errorHandler).errorHandlers);
                        } else if (!(errorHandler instanceof Listener.NoOp)) {
                            this.errorHandlers.add(errorHandler);
                        }
                    }
                }

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    for (ErrorHandler onError : this.errorHandlers) {
                        onError.onError(typeDescription, list);
                    }
                }

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    for (ErrorHandler onError : this.errorHandlers) {
                        onError.onError(map);
                    }
                }

                public void onError(Plugin plugin, Throwable th2) {
                    for (ErrorHandler onError : this.errorHandlers) {
                        onError.onError(plugin, th2);
                    }
                }
            }

            public enum Enforcing implements ErrorHandler {
                ALL_TYPES_RESOLVED {
                    public void onUnresolved(String str) {
                        throw new IllegalStateException("Failed to resolve type description for " + str);
                    }
                },
                NO_LIVE_INITIALIZERS {
                    public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                        throw new IllegalStateException("Failed to instrument " + typeDescription + " due to live initializer for " + typeDescription2);
                    }
                },
                CLASS_FILES_ONLY {
                    public void onResource(String str) {
                        throw new IllegalStateException("Discovered a resource when only class files were allowed: " + str);
                    }
                },
                MANIFEST_REQUIRED {
                    public void onManifest(Manifest manifest) {
                        if (manifest == null) {
                            throw new IllegalStateException("Required a manifest but no manifest was found");
                        }
                    }
                };

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                }

                public void onError(Plugin plugin, Throwable th2) {
                }

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                }

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                public void onManifest(Manifest manifest) {
                }

                public void onResource(String str) {
                }

                public void onUnresolved(String str) {
                }
            }

            public enum Failing implements ErrorHandler {
                FAIL_FAST {
                    public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                        throw new IllegalStateException("Failed to transform " + typeDescription + " using " + plugin, th2);
                    }

                    public void onError(TypeDescription typeDescription, List<Throwable> list) {
                        throw new UnsupportedOperationException("onError");
                    }

                    public void onError(Map<TypeDescription, List<Throwable>> map) {
                        throw new UnsupportedOperationException("onError");
                    }
                },
                FAIL_AFTER_TYPE {
                    public void onError(TypeDescription typeDescription, List<Throwable> list) {
                        throw new IllegalStateException("Failed to transform " + typeDescription + ": " + list);
                    }

                    public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    }

                    public void onError(Map<TypeDescription, List<Throwable>> map) {
                        throw new UnsupportedOperationException("onError");
                    }
                },
                FAIL_LAST {
                    public void onError(Map<TypeDescription, List<Throwable>> map) {
                        throw new IllegalStateException("Failed to transform at least one type: " + map);
                    }

                    public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    }

                    public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    }
                };

                public void onError(Plugin plugin, Throwable th2) {
                    throw new IllegalStateException("Failed to close plugin " + plugin, th2);
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                public void onManifest(Manifest manifest) {
                }

                public void onResource(String str) {
                }

                public void onUnresolved(String str) {
                }
            }

            void onError(Map<TypeDescription, List<Throwable>> map);

            void onError(Plugin plugin, Throwable th2);

            void onError(TypeDescription typeDescription, List<Throwable> list);

            void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2);

            void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2);

            void onManifest(Manifest manifest);

            void onResource(String str);

            void onUnresolved(String str);
        }

        public interface PoolStrategy {

            public enum Default implements PoolStrategy {
                FAST(TypePool.Default.ReaderMode.FAST),
                EXTENDED(TypePool.Default.ReaderMode.EXTENDED);
                
                private final TypePool.Default.ReaderMode readerMode;

                private Default(TypePool.Default.ReaderMode readerMode2) {
                    this.readerMode = readerMode2;
                }

                public TypePool typePool(ClassFileLocator classFileLocator) {
                    return new TypePool.Default.WithLazyResolution(new TypePool.CacheProvider.Simple(), classFileLocator, this.readerMode, TypePool.ClassLoading.ofPlatformLoader());
                }
            }

            public enum Eager implements PoolStrategy {
                FAST(TypePool.Default.ReaderMode.FAST),
                EXTENDED(TypePool.Default.ReaderMode.EXTENDED);
                
                private final TypePool.Default.ReaderMode readerMode;

                private Eager(TypePool.Default.ReaderMode readerMode2) {
                    this.readerMode = readerMode2;
                }

                public TypePool typePool(ClassFileLocator classFileLocator) {
                    return new TypePool.Default(new TypePool.CacheProvider.Simple(), classFileLocator, this.readerMode, TypePool.ClassLoading.ofPlatformLoader());
                }
            }

            TypePool typePool(ClassFileLocator classFileLocator);
        }

        public interface Source {

            public interface Element {

                @HashCodeAndEqualsPlugin.Enhance
                @SuppressFBWarnings(justification = "Not mutating the byte array is part of the class contract.", value = {"EI_EXPOSE_REP2"})
                public static class ForByteArray implements Element {
                    private final byte[] binaryRepresentation;

                    /* renamed from: name  reason: collision with root package name */
                    private final String f27093name;

                    public ForByteArray(String str, byte[] bArr) {
                        this.f27093name = str;
                        this.binaryRepresentation = bArr;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForByteArray forByteArray = (ForByteArray) obj;
                        return this.f27093name.equals(forByteArray.f27093name) && Arrays.equals(this.binaryRepresentation, forByteArray.binaryRepresentation);
                    }

                    public InputStream getInputStream() {
                        return new ByteArrayInputStream(this.binaryRepresentation);
                    }

                    public String getName() {
                        return this.f27093name;
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.f27093name.hashCode()) * 31) + Arrays.hashCode(this.binaryRepresentation);
                    }

                    public <T> T resolveAs(Class<T> cls) {
                        return null;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForFile implements Element {
                    private final File file;
                    private final File root;

                    public ForFile(File file2, File file3) {
                        this.root = file2;
                        this.file = file3;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForFile forFile = (ForFile) obj;
                        return this.root.equals(forFile.root) && this.file.equals(forFile.file);
                    }

                    public InputStream getInputStream() throws IOException {
                        return new FileInputStream(this.file);
                    }

                    public String getName() {
                        return this.root.getAbsoluteFile().toURI().relativize(this.file.getAbsoluteFile().toURI()).getPath();
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.root.hashCode()) * 31) + this.file.hashCode();
                    }

                    public <T> T resolveAs(Class<T> cls) {
                        if (File.class.isAssignableFrom(cls)) {
                            return this.file;
                        }
                        return null;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJarEntry implements Element {
                    private final JarEntry entry;
                    private final JarFile file;

                    public ForJarEntry(JarFile jarFile, JarEntry jarEntry) {
                        this.file = jarFile;
                        this.entry = jarEntry;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForJarEntry forJarEntry = (ForJarEntry) obj;
                        return this.file.equals(forJarEntry.file) && this.entry.equals(forJarEntry.entry);
                    }

                    public InputStream getInputStream() throws IOException {
                        return this.file.getInputStream(this.entry);
                    }

                    public String getName() {
                        return this.entry.getName();
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.file.hashCode()) * 31) + this.entry.hashCode();
                    }

                    public <T> T resolveAs(Class<T> cls) {
                        if (JarEntry.class.isAssignableFrom(cls)) {
                            return this.entry;
                        }
                        return null;
                    }
                }

                InputStream getInputStream() throws IOException;

                String getName();

                <T> T resolveAs(Class<T> cls);
            }

            public enum Empty implements Source, Origin {
                INSTANCE;

                public void close() {
                }

                public ClassFileLocator getClassFileLocator() {
                    return ClassFileLocator.NoOp.INSTANCE;
                }

                public Manifest getManifest() {
                    return Origin.NO_MANIFEST;
                }

                public Iterator<Element> iterator() {
                    return Collections.emptySet().iterator();
                }

                public Origin read() {
                    return this;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Filtering implements Source {
                private final Source delegate;
                private final boolean manifest;
                private final ElementMatcher<Element> matcher;

                public Filtering(Source source, ElementMatcher<Element> elementMatcher) {
                    this(source, elementMatcher, true);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Filtering filtering = (Filtering) obj;
                    return this.manifest == filtering.manifest && this.delegate.equals(filtering.delegate) && this.matcher.equals(filtering.matcher);
                }

                public int hashCode() {
                    return (((((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.matcher.hashCode()) * 31) + (this.manifest ? 1 : 0);
                }

                public Origin read() throws IOException {
                    return new Origin.Filtering(this.delegate.read(), this.matcher, this.manifest);
                }

                public Filtering(Source source, ElementMatcher<Element> elementMatcher, boolean z11) {
                    this.delegate = source;
                    this.matcher = elementMatcher;
                    this.manifest = z11;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFolder implements Source, Origin {
                /* access modifiers changed from: private */
                public final File folder;

                public class FolderIterator implements Iterator<Element>, j$.util.Iterator {
                    private final LinkedList<File> files;

                    public FolderIterator(File file) {
                        this.files = new LinkedList<>(Collections.singleton(file));
                        while (true) {
                            File[] listFiles = this.files.removeFirst().listFiles();
                            if (listFiles != null) {
                                this.files.addAll(0, Arrays.asList(listFiles));
                            }
                            if (this.files.isEmpty()) {
                                return;
                            }
                            if (!this.files.peek().isDirectory() && !this.files.peek().equals(new File(file, "META-INF/MANIFEST.MF"))) {
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
                        return !this.files.isEmpty();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                    }

                    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: 
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                        */
                    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Exception is thrown by invoking removeFirst on an empty list.", value = {"IT_NO_SUCH_ELEMENT"})
                    public net.bytebuddy.build.Plugin.Engine.Source.Element next() {
                        /*
                            r6 = this;
                            java.lang.String r0 = "META-INF/MANIFEST.MF"
                            r1 = 0
                            net.bytebuddy.build.Plugin$Engine$Source$Element$ForFile r2 = new net.bytebuddy.build.Plugin$Engine$Source$Element$ForFile     // Catch:{ all -> 0x005e }
                            net.bytebuddy.build.Plugin$Engine$Source$ForFolder r3 = net.bytebuddy.build.Plugin.Engine.Source.ForFolder.this     // Catch:{ all -> 0x005e }
                            java.io.File r3 = r3.folder     // Catch:{ all -> 0x005e }
                            java.util.LinkedList<java.io.File> r4 = r6.files     // Catch:{ all -> 0x005e }
                            java.lang.Object r4 = r4.removeFirst()     // Catch:{ all -> 0x005e }
                            java.io.File r4 = (java.io.File) r4     // Catch:{ all -> 0x005e }
                            r2.<init>(r3, r4)     // Catch:{ all -> 0x005e }
                        L_0x0016:
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            boolean r3 = r3.isEmpty()
                            if (r3 != 0) goto L_0x005d
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            java.lang.Object r3 = r3.peek()
                            java.io.File r3 = (java.io.File) r3
                            boolean r3 = r3.isDirectory()
                            if (r3 != 0) goto L_0x0045
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            java.lang.Object r3 = r3.peek()
                            java.io.File r3 = (java.io.File) r3
                            java.io.File r4 = new java.io.File
                            net.bytebuddy.build.Plugin$Engine$Source$ForFolder r5 = net.bytebuddy.build.Plugin.Engine.Source.ForFolder.this
                            java.io.File r5 = r5.folder
                            r4.<init>(r5, r0)
                            boolean r3 = r3.equals(r4)
                            if (r3 == 0) goto L_0x005d
                        L_0x0045:
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            java.lang.Object r3 = r3.removeFirst()
                            java.io.File r3 = (java.io.File) r3
                            java.io.File[] r3 = r3.listFiles()
                            if (r3 == 0) goto L_0x0016
                            java.util.LinkedList<java.io.File> r4 = r6.files
                            java.util.List r3 = java.util.Arrays.asList(r3)
                            r4.addAll(r1, r3)
                            goto L_0x0016
                        L_0x005d:
                            return r2
                        L_0x005e:
                            r2 = move-exception
                        L_0x005f:
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            boolean r3 = r3.isEmpty()
                            if (r3 != 0) goto L_0x00a6
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            java.lang.Object r3 = r3.peek()
                            java.io.File r3 = (java.io.File) r3
                            boolean r3 = r3.isDirectory()
                            if (r3 != 0) goto L_0x008e
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            java.lang.Object r3 = r3.peek()
                            java.io.File r3 = (java.io.File) r3
                            java.io.File r4 = new java.io.File
                            net.bytebuddy.build.Plugin$Engine$Source$ForFolder r5 = net.bytebuddy.build.Plugin.Engine.Source.ForFolder.this
                            java.io.File r5 = r5.folder
                            r4.<init>(r5, r0)
                            boolean r3 = r3.equals(r4)
                            if (r3 == 0) goto L_0x00a6
                        L_0x008e:
                            java.util.LinkedList<java.io.File> r3 = r6.files
                            java.lang.Object r3 = r3.removeFirst()
                            java.io.File r3 = (java.io.File) r3
                            java.io.File[] r3 = r3.listFiles()
                            if (r3 == 0) goto L_0x005f
                            java.util.LinkedList<java.io.File> r4 = r6.files
                            java.util.List r3 = java.util.Arrays.asList(r3)
                            r4.addAll(r1, r3)
                            goto L_0x005f
                        L_0x00a6:
                            throw r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.build.Plugin.Engine.Source.ForFolder.FolderIterator.next():net.bytebuddy.build.Plugin$Engine$Source$Element");
                    }
                }

                public ForFolder(File file) {
                    this.folder = file;
                }

                public void close() {
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.folder.equals(((ForFolder) obj).folder);
                }

                public ClassFileLocator getClassFileLocator() {
                    return new ClassFileLocator.ForFolder(this.folder);
                }

                public Manifest getManifest() throws IOException {
                    File file = new File(this.folder, "META-INF/MANIFEST.MF");
                    if (!file.exists()) {
                        return Origin.NO_MANIFEST;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        return new Manifest(fileInputStream);
                    } finally {
                        fileInputStream.close();
                    }
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.folder.hashCode();
                }

                public java.util.Iterator<Element> iterator() {
                    return new FolderIterator(this.folder);
                }

                public Origin read() {
                    return this;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForJarFile implements Source {
                private final File file;

                public ForJarFile(File file2) {
                    this.file = file2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.file.equals(((ForJarFile) obj).file);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.file.hashCode();
                }

                public Origin read() throws IOException {
                    return new Origin.ForJarFile(new JarFile(this.file));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class InMemory implements Source, Origin {
                private final Map<String, byte[]> storage;

                public static class MapEntryIterator implements java.util.Iterator<Element>, j$.util.Iterator {
                    private final java.util.Iterator<Map.Entry<String, byte[]>> iterator;

                    public MapEntryIterator(java.util.Iterator<Map.Entry<String, byte[]>> it) {
                        this.iterator = it;
                    }

                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                    }

                    public boolean hasNext() {
                        return this.iterator.hasNext();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                    }

                    public Element next() {
                        Map.Entry next = this.iterator.next();
                        return new Element.ForByteArray((String) next.getKey(), (byte[]) next.getValue());
                    }
                }

                public InMemory(Map<String, byte[]> map) {
                    this.storage = map;
                }

                public static Source ofTypes(Class<?>... clsArr) {
                    return ofTypes((Collection<? extends Class<?>>) Arrays.asList(clsArr));
                }

                public void close() {
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.storage.equals(((InMemory) obj).storage);
                }

                public ClassFileLocator getClassFileLocator() {
                    return ClassFileLocator.Simple.ofResources(this.storage);
                }

                public Manifest getManifest() throws IOException {
                    byte[] bArr = this.storage.get("META-INF/MANIFEST.MF");
                    if (bArr == null) {
                        return Origin.NO_MANIFEST;
                    }
                    return new Manifest(new ByteArrayInputStream(bArr));
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.storage.hashCode();
                }

                public java.util.Iterator<Element> iterator() {
                    return new MapEntryIterator(this.storage.entrySet().iterator());
                }

                public Origin read() {
                    return this;
                }

                public static Source ofTypes(Collection<? extends Class<?>> collection) {
                    HashMap hashMap = new HashMap();
                    for (Class cls : collection) {
                        hashMap.put(TypeDescription.ForLoadedType.of(cls), ClassFileLocator.ForClassLoader.read((Class<?>) cls));
                    }
                    return ofTypes((Map<TypeDescription, byte[]>) hashMap);
                }

                public static Source ofTypes(Map<TypeDescription, byte[]> map) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : map.entrySet()) {
                        hashMap.put(((TypeDescription) next.getKey()).getInternalName() + ".class", next.getValue());
                    }
                    return new InMemory(hashMap);
                }
            }

            public interface Origin extends Iterable<Element>, Closeable {
                public static final Manifest NO_MANIFEST = null;

                @HashCodeAndEqualsPlugin.Enhance
                public static class Filtering implements Origin {
                    private final Origin delegate;
                    private final boolean manifest;
                    private final ElementMatcher<Element> matcher;

                    public static class FilteringIterator implements java.util.Iterator<Element>, j$.util.Iterator {
                        private Element current;
                        private final java.util.Iterator<Element> iterator;
                        private final ElementMatcher<Element> matcher;

                        public /* synthetic */ void forEachRemaining(Consumer consumer) {
                            Iterator.CC.$default$forEachRemaining(this, consumer);
                        }

                        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                        }

                        public boolean hasNext() {
                            return this.current != null;
                        }

                        public void remove() {
                            this.iterator.remove();
                        }

                        private FilteringIterator(java.util.Iterator<Element> it, ElementMatcher<Element> elementMatcher) {
                            this.iterator = it;
                            this.matcher = elementMatcher;
                            while (it.hasNext()) {
                                Element next = it.next();
                                if (elementMatcher.matches(next)) {
                                    this.current = next;
                                    return;
                                }
                            }
                        }

                        public Element next() {
                            Element element = this.current;
                            if (element != null) {
                                this.current = null;
                                while (true) {
                                    if (!this.iterator.hasNext()) {
                                        break;
                                    }
                                    Element next = this.iterator.next();
                                    if (this.matcher.matches(next)) {
                                        this.current = next;
                                        break;
                                    }
                                }
                                return element;
                            }
                            throw new NoSuchElementException();
                        }
                    }

                    public Filtering(Origin origin, ElementMatcher<Element> elementMatcher) {
                        this(origin, elementMatcher, true);
                    }

                    public void close() throws IOException {
                        this.delegate.close();
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Filtering filtering = (Filtering) obj;
                        return this.manifest == filtering.manifest && this.delegate.equals(filtering.delegate) && this.matcher.equals(filtering.matcher);
                    }

                    public ClassFileLocator getClassFileLocator() {
                        return this.delegate.getClassFileLocator();
                    }

                    public Manifest getManifest() throws IOException {
                        return this.manifest ? this.delegate.getManifest() : Origin.NO_MANIFEST;
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.delegate.hashCode()) * 31) + this.matcher.hashCode()) * 31) + (this.manifest ? 1 : 0);
                    }

                    public java.util.Iterator<Element> iterator() {
                        return new FilteringIterator(this.delegate.iterator(), this.matcher);
                    }

                    public Filtering(Origin origin, ElementMatcher<Element> elementMatcher, boolean z11) {
                        this.delegate = origin;
                        this.matcher = elementMatcher;
                        this.manifest = z11;
                    }
                }

                public static class ForJarFile implements Origin {
                    /* access modifiers changed from: private */
                    public final JarFile file;

                    public class JarFileIterator implements java.util.Iterator<Element>, j$.util.Iterator {
                        private final Enumeration<JarEntry> enumeration;

                        public JarFileIterator(Enumeration<JarEntry> enumeration2) {
                            this.enumeration = enumeration2;
                        }

                        public /* synthetic */ void forEachRemaining(Consumer consumer) {
                            Iterator.CC.$default$forEachRemaining(this, consumer);
                        }

                        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                        }

                        public boolean hasNext() {
                            return this.enumeration.hasMoreElements();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException(ProductAction.ACTION_REMOVE);
                        }

                        public Element next() {
                            return new Element.ForJarEntry(ForJarFile.this.file, this.enumeration.nextElement());
                        }
                    }

                    public ForJarFile(JarFile jarFile) {
                        this.file = jarFile;
                    }

                    public void close() throws IOException {
                        this.file.close();
                    }

                    public ClassFileLocator getClassFileLocator() {
                        return new ClassFileLocator.ForJarFile(this.file);
                    }

                    public Manifest getManifest() throws IOException {
                        return this.file.getManifest();
                    }

                    public java.util.Iterator<Element> iterator() {
                        return new JarFileIterator(this.file.entries());
                    }
                }

                ClassFileLocator getClassFileLocator();

                Manifest getManifest() throws IOException;
            }

            Origin read() throws IOException;
        }

        public static class Summary {
            private final Map<TypeDescription, List<Throwable>> failed;
            private final List<TypeDescription> transformed;
            private final List<String> unresolved;

            public Summary(List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                this.transformed = list;
                this.failed = map;
                this.unresolved = list2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Summary summary = (Summary) obj;
                if (!this.transformed.equals(summary.transformed) || !this.failed.equals(summary.failed) || !this.unresolved.equals(summary.unresolved)) {
                    return false;
                }
                return true;
            }

            public Map<TypeDescription, List<Throwable>> getFailed() {
                return this.failed;
            }

            public List<TypeDescription> getTransformed() {
                return this.transformed;
            }

            public List<String> getUnresolved() {
                return this.unresolved;
            }

            public int hashCode() {
                return (((this.transformed.hashCode() * 31) + this.failed.hashCode()) * 31) + this.unresolved.hashCode();
            }
        }

        public interface Target {

            public enum Discarding implements Target, Sink {
                INSTANCE;

                public void close() {
                }

                public void retain(Source.Element element) {
                }

                public void store(Map<TypeDescription, byte[]> map) {
                }

                public Sink write(Manifest manifest) {
                    return this;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFolder implements Target, Sink {
                private final File folder;

                public ForFolder(File file) {
                    this.folder = file;
                }

                public void close() {
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.folder.equals(((ForFolder) obj).folder);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.folder.hashCode();
                }

                public void retain(Source.Element element) throws IOException {
                    FileOutputStream fileOutputStream;
                    String name2 = element.getName();
                    if (!name2.endsWith("/")) {
                        File file = new File(this.folder, name2);
                        File file2 = (File) element.resolveAs(File.class);
                        if (!file.getCanonicalPath().startsWith(this.folder.getCanonicalPath())) {
                            throw new IllegalArgumentException(file + " is not a subdirectory of " + this.folder);
                        } else if (!file.getParentFile().isDirectory() && !file.getParentFile().mkdirs()) {
                            throw new IOException("Could not create directory: " + file.getParent());
                        } else if (file2 != null && !file2.equals(file)) {
                            FileSystem.getInstance().copy(file2, file);
                        } else if (!file.equals(file2)) {
                            InputStream inputStream = element.getInputStream();
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read != -1) {
                                        fileOutputStream.write(bArr, 0, read);
                                    } else {
                                        fileOutputStream.close();
                                        inputStream.close();
                                        return;
                                    }
                                }
                            } catch (Throwable th2) {
                                inputStream.close();
                                throw th2;
                            }
                        }
                    }
                }

                public void store(Map<TypeDescription, byte[]> map) throws IOException {
                    for (Map.Entry next : map.entrySet()) {
                        File file = this.folder;
                        File file2 = new File(file, ((TypeDescription) next.getKey()).getInternalName() + ".class");
                        if (file2.getParentFile().isDirectory() || file2.getParentFile().mkdirs()) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                fileOutputStream.write((byte[]) next.getValue());
                            } finally {
                                fileOutputStream.close();
                            }
                        } else {
                            throw new IOException("Could not create directory: " + file2.getParent());
                        }
                    }
                }

                public Sink write(Manifest manifest) throws IOException {
                    if (manifest != null) {
                        File file = new File(this.folder, "META-INF/MANIFEST.MF");
                        if (file.getParentFile().isDirectory() || file.getParentFile().mkdirs()) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                manifest.write(fileOutputStream);
                            } finally {
                                fileOutputStream.close();
                            }
                        } else {
                            throw new IOException("Could not create directory: " + file.getParent());
                        }
                    }
                    return this;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForJarFile implements Target {
                private final File file;

                public ForJarFile(File file2) {
                    this.file = file2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.file.equals(((ForJarFile) obj).file);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.file.hashCode();
                }

                public Sink write(Manifest manifest) throws IOException {
                    return manifest == null ? new Sink.ForJarOutputStream(new JarOutputStream(new FileOutputStream(this.file))) : new Sink.ForJarOutputStream(new JarOutputStream(new FileOutputStream(this.file), manifest));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class InMemory implements Target, Sink {
                private final Map<String, byte[]> storage;

                public InMemory() {
                    this(new HashMap());
                }

                public void close() {
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.storage.equals(((InMemory) obj).storage);
                }

                public Map<String, byte[]> getStorage() {
                    return this.storage;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.storage.hashCode();
                }

                public void retain(Source.Element element) throws IOException {
                    InputStream inputStream;
                    if (!element.getName().endsWith("/")) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            inputStream = element.getInputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    inputStream.close();
                                    byteArrayOutputStream.close();
                                    this.storage.put(element.getName(), byteArrayOutputStream.toByteArray());
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            byteArrayOutputStream.close();
                            throw th2;
                        }
                    }
                }

                public void store(Map<TypeDescription, byte[]> map) {
                    for (Map.Entry next : map.entrySet()) {
                        Map<String, byte[]> map2 = this.storage;
                        map2.put(((TypeDescription) next.getKey()).getInternalName() + ".class", next.getValue());
                    }
                }

                public Map<String, byte[]> toTypeMap() {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : this.storage.entrySet()) {
                        if (((String) next.getKey()).endsWith(".class")) {
                            hashMap.put(((String) next.getKey()).substring(0, ((String) next.getKey()).length() - 6).replace('/', '.'), next.getValue());
                        }
                    }
                    return hashMap;
                }

                /* JADX INFO: finally extract failed */
                public Sink write(Manifest manifest) throws IOException {
                    if (manifest != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            manifest.write(byteArrayOutputStream);
                            byteArrayOutputStream.close();
                            this.storage.put("META-INF/MANIFEST.MF", byteArrayOutputStream.toByteArray());
                        } catch (Throwable th2) {
                            byteArrayOutputStream.close();
                            throw th2;
                        }
                    }
                    return this;
                }

                public InMemory(Map<String, byte[]> map) {
                    this.storage = map;
                }
            }

            public interface Sink extends Closeable {

                public static class ForJarOutputStream implements Sink {
                    private final JarOutputStream outputStream;

                    public ForJarOutputStream(JarOutputStream jarOutputStream) {
                        this.outputStream = jarOutputStream;
                    }

                    public void close() throws IOException {
                        this.outputStream.close();
                    }

                    /* JADX INFO: finally extract failed */
                    public void retain(Source.Element element) throws IOException {
                        JarEntry jarEntry = (JarEntry) element.resolveAs(JarEntry.class);
                        JarOutputStream jarOutputStream = this.outputStream;
                        if (jarEntry == null) {
                            jarEntry = new JarEntry(element.getName());
                        }
                        jarOutputStream.putNextEntry(jarEntry);
                        InputStream inputStream = element.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    this.outputStream.write(bArr, 0, read);
                                } else {
                                    inputStream.close();
                                    this.outputStream.closeEntry();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            inputStream.close();
                            throw th2;
                        }
                    }

                    public void store(Map<TypeDescription, byte[]> map) throws IOException {
                        for (Map.Entry next : map.entrySet()) {
                            JarOutputStream jarOutputStream = this.outputStream;
                            jarOutputStream.putNextEntry(new JarEntry(((TypeDescription) next.getKey()).getInternalName() + ".class"));
                            this.outputStream.write((byte[]) next.getValue());
                            this.outputStream.closeEntry();
                        }
                    }
                }

                void retain(Source.Element element) throws IOException;

                void store(Map<TypeDescription, byte[]> map) throws IOException;
            }

            Sink write(Manifest manifest) throws IOException;
        }

        public interface TypeStrategy {

            public enum Default implements TypeStrategy {
                REDEFINE {
                    public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
                        return byteBuddy.redefine(typeDescription, classFileLocator);
                    }
                },
                REBASE {
                    public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
                        return byteBuddy.rebase(typeDescription, classFileLocator);
                    }
                },
                DECORATE {
                    public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
                        return byteBuddy.decorate(typeDescription, classFileLocator);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForEntryPoint implements TypeStrategy {
                private final EntryPoint entryPoint;
                private final MethodNameTransformer methodNameTransformer;

                public ForEntryPoint(EntryPoint entryPoint2, MethodNameTransformer methodNameTransformer2) {
                    this.entryPoint = entryPoint2;
                    this.methodNameTransformer = methodNameTransformer2;
                }

                public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
                    return this.entryPoint.transform(typeDescription, byteBuddy, classFileLocator, this.methodNameTransformer);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForEntryPoint forEntryPoint = (ForEntryPoint) obj;
                    return this.entryPoint.equals(forEntryPoint.entryPoint) && this.methodNameTransformer.equals(forEntryPoint.methodNameTransformer);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.entryPoint.hashCode()) * 31) + this.methodNameTransformer.hashCode();
                }
            }

            DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription, ClassFileLocator classFileLocator);
        }

        Summary apply(File file, File file2, List<? extends Factory> list) throws IOException;

        Summary apply(File file, File file2, Factory... factoryArr) throws IOException;

        Summary apply(Source source, Target target, List<? extends Factory> list) throws IOException;

        Summary apply(Source source, Target target, Factory... factoryArr) throws IOException;

        Engine ignore(ElementMatcher<? super TypeDescription> elementMatcher);

        Engine with(ByteBuddy byteBuddy);

        Engine with(Dispatcher.Factory factory);

        Engine with(Listener listener);

        Engine with(PoolStrategy poolStrategy);

        Engine with(TypeStrategy typeStrategy);

        Engine with(ClassFileLocator classFileLocator);

        Engine withErrorHandlers(List<? extends ErrorHandler> list);

        Engine withErrorHandlers(ErrorHandler... errorHandlerArr);

        Engine withParallelTransformation(int i11);

        Engine withoutErrorHandlers();

        public interface Listener extends ErrorHandler {

            public static abstract class Adapter implements Listener {
                public void onComplete(TypeDescription typeDescription) {
                }

                public void onDiscovery(String str) {
                }

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                }

                public void onError(Plugin plugin, Throwable th2) {
                }

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                }

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                }

                public void onIgnored(TypeDescription typeDescription, List<Plugin> list) {
                }

                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                public void onManifest(Manifest manifest) {
                }

                public void onResource(String str) {
                }

                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                }

                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                }

                public void onUnresolved(String str) {
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

                public void onComplete(TypeDescription typeDescription) {
                    for (Listener onComplete : this.listeners) {
                        onComplete.onComplete(typeDescription);
                    }
                }

                public void onDiscovery(String str) {
                    for (Listener onDiscovery : this.listeners) {
                        onDiscovery.onDiscovery(str);
                    }
                }

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    for (Listener onError : this.listeners) {
                        onError.onError(typeDescription, plugin, th2);
                    }
                }

                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                    for (Listener onIgnored : this.listeners) {
                        onIgnored.onIgnored(typeDescription, plugin);
                    }
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    for (Listener onLiveInitializer : this.listeners) {
                        onLiveInitializer.onLiveInitializer(typeDescription, typeDescription2);
                    }
                }

                public void onManifest(Manifest manifest) {
                    for (Listener onManifest : this.listeners) {
                        onManifest.onManifest(manifest);
                    }
                }

                public void onResource(String str) {
                    for (Listener onResource : this.listeners) {
                        onResource.onResource(str);
                    }
                }

                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                    for (Listener onTransformation : this.listeners) {
                        onTransformation.onTransformation(typeDescription, plugin);
                    }
                }

                public void onUnresolved(String str) {
                    for (Listener onUnresolved : this.listeners) {
                        onUnresolved.onUnresolved(str);
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

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    for (Listener onError : this.listeners) {
                        onError.onError(typeDescription, list);
                    }
                }

                public void onIgnored(TypeDescription typeDescription, List<Plugin> list) {
                    for (Listener onIgnored : this.listeners) {
                        onIgnored.onIgnored(typeDescription, list);
                    }
                }

                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                    for (Listener onTransformation : this.listeners) {
                        onTransformation.onTransformation(typeDescription, list);
                    }
                }

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    for (Listener onError : this.listeners) {
                        onError.onError(map);
                    }
                }

                public void onError(Plugin plugin, Throwable th2) {
                    for (Listener onError : this.listeners) {
                        onError.onError(plugin, th2);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForErrorHandler extends Adapter {
                private final ErrorHandler errorHandler;

                public ForErrorHandler(ErrorHandler errorHandler2) {
                    this.errorHandler = errorHandler2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.errorHandler.equals(((ForErrorHandler) obj).errorHandler);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.errorHandler.hashCode();
                }

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    this.errorHandler.onError(typeDescription, plugin, th2);
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    this.errorHandler.onLiveInitializer(typeDescription, typeDescription2);
                }

                public void onManifest(Manifest manifest) {
                    this.errorHandler.onManifest(manifest);
                }

                public void onResource(String str) {
                    this.errorHandler.onResource(str);
                }

                public void onUnresolved(String str) {
                    this.errorHandler.onUnresolved(str);
                }

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    this.errorHandler.onError(typeDescription, list);
                }

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    this.errorHandler.onError(map);
                }

                public void onError(Plugin plugin, Throwable th2) {
                    this.errorHandler.onError(plugin, th2);
                }
            }

            public enum NoOp implements Listener {
                INSTANCE;

                public void onComplete(TypeDescription typeDescription) {
                }

                public void onDiscovery(String str) {
                }

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                }

                public void onError(Plugin plugin, Throwable th2) {
                }

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                }

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                }

                public void onIgnored(TypeDescription typeDescription, List<Plugin> list) {
                }

                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                public void onManifest(Manifest manifest) {
                }

                public void onResource(String str) {
                }

                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                }

                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                }

                public void onUnresolved(String str) {
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

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    this.delegate.onError(typeDescription, plugin, th2);
                }

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    this.delegate.onError(typeDescription, list);
                }

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    this.delegate.onError(map);
                }

                public void onError(Plugin plugin, Throwable th2) {
                    this.delegate.onError(plugin, th2);
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

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    this.delegate.onError(typeDescription, plugin, th2);
                }

                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                    this.delegate.onTransformation(typeDescription, plugin);
                }

                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    this.delegate.onError(typeDescription, list);
                }

                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                    this.delegate.onTransformation(typeDescription, list);
                }

                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    this.delegate.onError(map);
                }

                public void onError(Plugin plugin, Throwable th2) {
                    this.delegate.onError(plugin, th2);
                }
            }

            void onComplete(TypeDescription typeDescription);

            void onDiscovery(String str);

            void onIgnored(TypeDescription typeDescription, List<Plugin> list);

            void onIgnored(TypeDescription typeDescription, Plugin plugin);

            void onTransformation(TypeDescription typeDescription, List<Plugin> list);

            void onTransformation(TypeDescription typeDescription, Plugin plugin);

            @HashCodeAndEqualsPlugin.Enhance
            public static class StreamWriting extends Adapter {
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

                public void onComplete(TypeDescription typeDescription) {
                    this.printStream.printf("[Byte Buddy] COMPLETE %s", new Object[]{typeDescription});
                }

                public void onDiscovery(String str) {
                    this.printStream.printf("[Byte Buddy] DISCOVERY %s", new Object[]{str});
                }

                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th2) {
                    synchronized (this.printStream) {
                        this.printStream.printf("[Byte Buddy] ERROR %s for %s", new Object[]{typeDescription, plugin});
                        th2.printStackTrace(this.printStream);
                    }
                }

                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                    this.printStream.printf("[Byte Buddy] IGNORE %s for %s", new Object[]{typeDescription, plugin});
                }

                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    this.printStream.printf("[Byte Buddy] LIVE %s on %s", new Object[]{typeDescription, typeDescription2});
                }

                public void onManifest(Manifest manifest) {
                    PrintStream printStream2 = this.printStream;
                    boolean z11 = true;
                    Object[] objArr = new Object[1];
                    if (manifest == null) {
                        z11 = false;
                    }
                    objArr[0] = Boolean.valueOf(z11);
                    printStream2.printf("[Byte Buddy] MANIFEST %b", objArr);
                }

                public void onResource(String str) {
                    this.printStream.printf("[Byte Buddy] RESOURCE %s", new Object[]{str});
                }

                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                    this.printStream.printf("[Byte Buddy] TRANSFORM %s for %s", new Object[]{typeDescription, plugin});
                }

                public void onUnresolved(String str) {
                    this.printStream.printf("[Byte Buddy] UNRESOLVED %s", new Object[]{str});
                }

                public Listener withErrorsOnly() {
                    return new WithErrorsOnly(this);
                }

                public Listener withTransformationsOnly() {
                    return new WithTransformationsOnly(this);
                }

                public void onError(Plugin plugin, Throwable th2) {
                    synchronized (this.printStream) {
                        this.printStream.printf("[Byte Buddy] ERROR %s", new Object[]{plugin});
                        th2.printStackTrace(this.printStream);
                    }
                }
            }
        }
    }
}
