package org.mockito.internal.creation.bytebuddy;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.RandomString;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.SuppressSignatureCheck;
import org.mockito.internal.creation.bytebuddy.MockMethodAdvice;
import org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.util.concurrent.DetachedThreadLocal;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;
import org.mockito.internal.util.concurrent.WeakConcurrentSet;
import org.mockito.mock.SerializableMode;
import w30.b;

@SuppressSignatureCheck
public class InlineBytecodeGenerator implements BytecodeGenerator, ClassFileTransformer {
    private static final String PRELOAD = "org.mockito.inline.preload";

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Class<?>> f63154b = new HashSet(Arrays.asList(new Class[]{Class.class, Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, String.class}));
    private final ByteBuddy byteBuddy = new ByteBuddy().with(TypeValidation.DISABLED).with((Implementation.Context.Factory) Implementation.Context.Disabled.Factory.INSTANCE).with((MethodGraph.Compiler) MethodGraph.Compiler.ForDeclaredMethods.INSTANCE).ignore((ElementMatcher<? super MethodDescription>) ElementMatchers.isSynthetic().and(ElementMatchers.not(ElementMatchers.isConstructor())).or(ElementMatchers.isDefaultFinalizer()));
    private final Method canRead;
    private final WeakConcurrentSet<Class<?>> flatMocked;
    private final Method getModule;
    private final Instrumentation instrumentation;
    private volatile Throwable lastException;
    private final AsmVisitorWrapper mockTransformer;
    private final WeakConcurrentSet<Class<?>> mocked;
    private final Method redefineModule;
    private final BytecodeGenerator subclassEngine;

    public static class ParameterWritingVisitorWrapper extends AsmVisitorWrapper.AbstractBase {
        private final Class<?> type;

        public static class MethodParameterStrippingMethodVisitor extends MethodVisitor {
            public MethodParameterStrippingMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }

            public void visitParameter(String str, int i11) {
            }
        }

        public static class ParameterAddingClassVisitor extends ClassVisitor {
            private final TypeDescription typeDescription;

            public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
                ElementMatcher.Junction junction;
                MethodVisitor visitMethod = super.visitMethod(i11, str, str2, str3, strArr);
                MethodList<MethodDescription.InDefinedShape> declaredMethods = this.typeDescription.getDeclaredMethods();
                if (str.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
                    junction = ElementMatchers.isConstructor();
                } else {
                    junction = ElementMatchers.named(str);
                }
                MethodList methodList = (MethodList) declaredMethods.filter(junction.and(ElementMatchers.hasDescriptor(str2)));
                if (methodList.size() != 1 || !((MethodDescription) methodList.getOnly()).getParameters().hasExplicitMetaData()) {
                    return visitMethod;
                }
                Iterator<E> it = ((MethodDescription) methodList.getOnly()).getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    visitMethod.visitParameter(parameterDescription.getName(), parameterDescription.getModifiers());
                }
                return new MethodParameterStrippingMethodVisitor(visitMethod);
            }

            private ParameterAddingClassVisitor(ClassVisitor classVisitor, TypeDescription typeDescription2) {
                super(OpenedClassReader.ASM_API, classVisitor);
                this.typeDescription = typeDescription2;
            }
        }

        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
            if (context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V8)) {
                return new ParameterAddingClassVisitor(classVisitor, new TypeDescription.ForLoadedType(this.type));
            }
            return classVisitor;
        }

        private ParameterWritingVisitorWrapper(Class<?> cls) {
            this.type = cls;
        }
    }

    public InlineBytecodeGenerator(Instrumentation instrumentation2, WeakConcurrentMap<Object, MockMethodInterceptor> weakConcurrentMap, DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> detachedThreadLocal, Predicate<Class<?>> predicate, ConstructionCallback constructionCallback) {
        Method method;
        Method method2;
        Method method3;
        Class<Set> cls = Set.class;
        Class<Map> cls2 = Map.class;
        preload();
        this.instrumentation = instrumentation2;
        WeakConcurrentSet.Cleaner cleaner = WeakConcurrentSet.Cleaner.INLINE;
        this.mocked = new WeakConcurrentSet<>(cleaner);
        this.flatMocked = new WeakConcurrentSet<>(cleaner);
        String make = RandomString.make();
        Class<MockMethodAdvice.Identifier> cls3 = MockMethodAdvice.Identifier.class;
        this.subclassEngine = new TypeCachingBytecodeGenerator(new SubclassBytecodeGenerator(MethodDelegation.withDefaultConfiguration().withBinders((TargetMethodAnnotationDrivenBinder.ParameterBinder<?>[]) new TargetMethodAnnotationDrivenBinder.ParameterBinder[]{TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFixedValue.OfConstant.of(cls3, make)}).to((Class<?>) MockMethodAdvice.ForReadObject.class), ElementMatchers.isAbstract().or(ElementMatchers.isNative()).or(ElementMatchers.isToString())), false);
        this.mockTransformer = new AsmVisitorWrapper.ForDeclaredMethods().method((ElementMatcher<? super MethodDescription>) ElementMatchers.isVirtual().and(ElementMatchers.not(ElementMatchers.isBridge().or(ElementMatchers.isHashCode()).or(ElementMatchers.isEquals()).or(ElementMatchers.isDefaultFinalizer()))).and(ElementMatchers.not(ElementMatchers.isDeclaredBy((ElementMatcher<? super TypeDescription>) ElementMatchers.nameStartsWith("java.")).and(ElementMatchers.isPackagePrivate()))), Advice.withCustomMapping().bind(cls3, (Object) make).to(MockMethodAdvice.class)).method((ElementMatcher<? super MethodDescription>) ElementMatchers.isStatic(), Advice.withCustomMapping().bind(cls3, (Object) make).to(MockMethodAdvice.ForStatic.class)).constructor((ElementMatcher<? super MethodDescription>) ElementMatchers.any(), new MockMethodAdvice.ConstructorShortcut(make)).method((ElementMatcher<? super MethodDescription>) ElementMatchers.isHashCode(), Advice.withCustomMapping().bind(cls3, (Object) make).to(MockMethodAdvice.ForHashCode.class)).method((ElementMatcher<? super MethodDescription>) ElementMatchers.isEquals(), Advice.withCustomMapping().bind(cls3, (Object) make).to(MockMethodAdvice.ForEquals.class));
        try {
            method2 = Class.class.getMethod("getModule", new Class[0]);
            method = method2.getReturnType().getMethod("canRead", new Class[]{method2.getReturnType()});
            method3 = Instrumentation.class.getMethod("redefineModule", new Class[]{method2.getReturnType(), cls, cls2, cls2, cls, cls2});
        } catch (Exception unused) {
            method2 = null;
            method3 = null;
            method = null;
        }
        this.getModule = method2;
        this.canRead = method;
        this.redefineModule = method3;
        MockMethodDispatcher.set(make, new MockMethodAdvice(weakConcurrentMap, detachedThreadLocal, make, predicate, constructionCallback));
        instrumentation2.addTransformer(this, true);
    }

    private void addInterfaces(Set<Class<?>> set, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (this.mocked.add(cls)) {
                if (!this.flatMocked.remove(cls)) {
                    set.add(cls);
                }
                addInterfaces(set, cls.getInterfaces());
            }
        }
    }

    private void assureCanReadMockito(Set<Class<?>> set) {
        if (this.redefineModule != null) {
            HashSet hashSet = new HashSet();
            try {
                Object invoke = this.getModule.invoke(Class.forName("org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher", false, (ClassLoader) null), new Object[0]);
                for (Class<?> invoke2 : set) {
                    Object invoke3 = this.getModule.invoke(invoke2, new Object[0]);
                    if (!hashSet.contains(invoke3)) {
                        if (!((Boolean) this.canRead.invoke(invoke3, new Object[]{invoke})).booleanValue()) {
                            hashSet.add(invoke3);
                        }
                    }
                }
                for (Object next : hashSet) {
                    this.redefineModule.invoke(this.instrumentation, new Object[]{next, Collections.singleton(invoke), Collections.emptyMap(), Collections.emptyMap(), Collections.emptySet(), Collections.emptyMap()});
                }
            } catch (Exception e11) {
                throw new IllegalStateException(StringUtil.join("Could not adjust module graph to make the mock instance dispatcher visible to some classes", "", "At least one of those modules: " + hashSet + " is not reading the unnamed module of the bootstrap loader", "Without such a read edge, the classes that are redefined to become mocks cannot access the mock dispatcher.", "To circumvent this, Mockito attempted to add a read edge to this module what failed for an unexpected reason"), e11);
            }
        }
    }

    private static void assureInitialization(Class<?> cls) {
        try {
            Class.forName(cls.getName(), true, cls.getClassLoader());
        } catch (ExceptionInInitializerError e11) {
            throw new MockitoException("Cannot instrument " + cls + " because it or one of its supertypes could not be initialized", e11.getException());
        } catch (Throwable unused) {
        }
    }

    private <T> void checkSupportedCombination(boolean z11, MockFeatures<T> mockFeatures) {
        if (z11 && !mockFeatures.f63158a.isArray() && !mockFeatures.f63158a.isPrimitive()) {
            if (!Modifier.isFinal(mockFeatures.f63158a.getModifiers())) {
                TypeSupport typeSupport = TypeSupport.f63171a;
                if (!typeSupport.a(mockFeatures.f63158a)) {
                    Stream stream = Collection.EL.stream(mockFeatures.f63159b);
                    Objects.requireNonNull(typeSupport);
                    if (!stream.anyMatch(new a(typeSupport))) {
                        return;
                    }
                }
            }
            throw new MockitoException("Unsupported settings with this type '" + mockFeatures.f63158a.getName() + "'");
        }
    }

    private static void preload() {
        String property = System.getProperty(PRELOAD);
        if (property == null) {
            property = "java.lang.WeakPairMap,java.lang.WeakPairMap$Pair,java.lang.WeakPairMap$Pair$Weak";
        }
        for (String cls : property.split(",")) {
            try {
                Class.forName(cls, false, (ClassLoader) null);
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <T> void triggerRetransformation(java.util.Set<java.lang.Class<?>> r6, boolean r7) {
        /*
            r5 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00d3 }
        L_0x0009:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x00d3 }
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x00d3 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x00d3 }
            if (r7 == 0) goto L_0x002e
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r2 = r5.mocked     // Catch:{ all -> 0x00d3 }
            boolean r2 = r2.contains(r1)     // Catch:{ all -> 0x00d3 }
            if (r2 != 0) goto L_0x0009
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r2 = r5.flatMocked     // Catch:{ all -> 0x00d3 }
            boolean r2 = r2.add(r1)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x0009
            assureInitialization(r1)     // Catch:{ all -> 0x00d3 }
            r0.add(r1)     // Catch:{ all -> 0x00d3 }
            goto L_0x0009
        L_0x002e:
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r2 = r5.mocked     // Catch:{ all -> 0x00d3 }
            boolean r2 = r2.add(r1)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x004b
            assureInitialization(r1)     // Catch:{ all -> 0x00d3 }
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r2 = r5.flatMocked     // Catch:{ all -> 0x00d3 }
            boolean r2 = r2.remove(r1)     // Catch:{ all -> 0x00d3 }
            if (r2 != 0) goto L_0x0044
            r0.add(r1)     // Catch:{ all -> 0x00d3 }
        L_0x0044:
            java.lang.Class[] r2 = r1.getInterfaces()     // Catch:{ all -> 0x00d3 }
            r5.addInterfaces(r0, r2)     // Catch:{ all -> 0x00d3 }
        L_0x004b:
            java.lang.Class r1 = r1.getSuperclass()     // Catch:{ all -> 0x00d3 }
            if (r1 != 0) goto L_0x002e
            goto L_0x0009
        L_0x0052:
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x00d2
            r6 = 0
            r5.assureCanReadMockito(r0)     // Catch:{ Exception -> 0x009c }
            java.lang.instrument.Instrumentation r7 = r5.instrumentation     // Catch:{ Exception -> 0x009c }
            int r1 = r0.size()     // Catch:{ Exception -> 0x009c }
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x009c }
            java.lang.Object[] r1 = r0.toArray(r1)     // Catch:{ Exception -> 0x009c }
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch:{ Exception -> 0x009c }
            r7.retransformClasses(r1)     // Catch:{ Exception -> 0x009c }
            java.lang.Throwable r7 = r5.lastException     // Catch:{ Exception -> 0x009c }
            if (r7 != 0) goto L_0x0074
            r5.lastException = r6
            goto L_0x00d2
        L_0x0074:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x009c }
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = "Byte Buddy could not instrument all classes within the mock's type hierarchy"
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = ""
            r4 = 1
            r2[r4] = r3     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = "This problem should never occur for javac-compiled classes. This problem has been observed for classes that are:"
            r4 = 2
            r2[r4] = r3     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = " - Compiled by older versions of scalac"
            r4 = 3
            r2[r4] = r3     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = " - Classes that are part of the Android distribution"
            r4 = 4
            r2[r4] = r3     // Catch:{ Exception -> 0x009c }
            java.lang.String r2 = org.mockito.internal.util.StringUtil.join(r2)     // Catch:{ Exception -> 0x009c }
            r1.<init>(r2, r7)     // Catch:{ Exception -> 0x009c }
            throw r1     // Catch:{ Exception -> 0x009c }
        L_0x009a:
            r7 = move-exception
            goto L_0x00cf
        L_0x009c:
            r7 = move-exception
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x009a }
        L_0x00a1:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x00b8
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x009a }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ all -> 0x009a }
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r3 = r5.mocked     // Catch:{ all -> 0x009a }
            r3.remove(r2)     // Catch:{ all -> 0x009a }
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r3 = r5.flatMocked     // Catch:{ all -> 0x009a }
            r3.remove(r2)     // Catch:{ all -> 0x009a }
            goto L_0x00a1
        L_0x00b8:
            org.mockito.exceptions.base.MockitoException r1 = new org.mockito.exceptions.base.MockitoException     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r2.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r3 = "Could not modify all classes "
            r2.append(r3)     // Catch:{ all -> 0x009a }
            r2.append(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x009a }
            r1.<init>(r0, r7)     // Catch:{ all -> 0x009a }
            throw r1     // Catch:{ all -> 0x009a }
        L_0x00cf:
            r5.lastException = r6
            throw r7
        L_0x00d2:
            return
        L_0x00d3:
            r6 = move-exception
            java.util.Iterator r7 = r0.iterator()
        L_0x00d8:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00ef
            java.lang.Object r0 = r7.next()
            java.lang.Class r0 = (java.lang.Class) r0
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r1 = r5.mocked
            r1.remove(r0)
            org.mockito.internal.util.concurrent.WeakConcurrentSet<java.lang.Class<?>> r1 = r5.flatMocked
            r1.remove(r0)
            goto L_0x00d8
        L_0x00ef:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.InlineBytecodeGenerator.triggerRetransformation(java.util.Set, boolean):void");
    }

    public synchronized void clearAllCaches() {
        HashSet hashSet = new HashSet();
        Iterable.EL.forEach(this.mocked, new b(hashSet));
        if (!hashSet.isEmpty()) {
            this.mocked.clear();
            this.flatMocked.clear();
            try {
                this.instrumentation.retransformClasses((Class[]) hashSet.toArray(new Class[0]));
            } catch (UnmodifiableClassException e11) {
                throw new MockitoException(StringUtil.join("Failed to reset mocks.", "", "This should not influence the working of Mockito.", "But if the reset intends to remove mocking code to improve performance, it is still impacted."), e11);
            }
        }
    }

    public <T> Class<? extends T> mockClass(MockFeatures<T> mockFeatures) {
        boolean z11;
        if (!mockFeatures.f63159b.isEmpty() || mockFeatures.f63160c != SerializableMode.NONE || Modifier.isAbstract(mockFeatures.f63158a.getModifiers())) {
            z11 = true;
        } else {
            z11 = false;
        }
        checkSupportedCombination(z11, mockFeatures);
        HashSet hashSet = new HashSet();
        hashSet.add(mockFeatures.f63158a);
        hashSet.addAll(mockFeatures.f63159b);
        synchronized (this) {
            triggerRetransformation(hashSet, false);
        }
        if (z11) {
            return this.subclassEngine.mockClass(mockFeatures);
        }
        return mockFeatures.f63158a;
    }

    public synchronized void mockClassConstruction(Class<?> cls) {
        triggerRetransformation(Collections.singleton(cls), false);
    }

    public synchronized void mockClassStatic(Class<?> cls) {
        triggerRetransformation(Collections.singleton(cls), true);
    }

    public byte[] transform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
        if (cls != null && ((this.mocked.contains(cls) || this.flatMocked.contains(cls)) && !f63154b.contains(cls))) {
            try {
                return this.byteBuddy.redefine(cls, ClassFileLocator.Simple.of(cls.getName(), bArr)).visit(new ParameterWritingVisitorWrapper(cls)).visit(this.mockTransformer).make().getBytes();
            } catch (Throwable th2) {
                this.lastException = th2;
            }
        }
        return null;
    }
}
