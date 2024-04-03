package org.mockito.internal.creation.bytebuddy;

import j$.util.function.Predicate;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.This;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.internal.invocation.SerializableMethod;
import org.mockito.internal.invocation.mockref.MockReference;
import org.mockito.internal.invocation.mockref.MockWeakReference;
import org.mockito.internal.util.concurrent.DetachedThreadLocal;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;

public class MockMethodAdvice extends MockMethodDispatcher {
    private final MethodGraph.Compiler compiler = MethodGraph.Compiler.Default.forJavaHierarchy();
    private final WeakConcurrentMap<Class<?>, SoftReference<MethodGraph>> graphs = new WeakConcurrentMap.WithInlinedExpunction();
    private final String identifier;
    /* access modifiers changed from: private */
    public final WeakConcurrentMap<Object, MockMethodInterceptor> interceptors;
    private final Predicate<Class<?>> isMockConstruction;
    private final DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> mockedStatics;
    private final ConstructionCallback onConstruction;
    /* access modifiers changed from: private */
    public final SelfCallInfo selfCallInfo = new SelfCallInfo();

    public static class ConstructorShortcut implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
        /* access modifiers changed from: private */
        public final String identifier;

        public ConstructorShortcut(String str) {
            this.identifier = str;
        }

        /* access modifiers changed from: private */
        public static Object[] toFrames(Object obj, List<TypeDescription> list) {
            Object obj2;
            Object[] objArr = new Object[(list.size() + 1)];
            int i11 = 0;
            objArr[0] = obj;
            for (TypeDescription next : list) {
                if (next.represents(Boolean.TYPE) || next.represents(Byte.TYPE) || next.represents(Short.TYPE) || next.represents(Character.TYPE) || next.represents(Integer.TYPE)) {
                    obj2 = Opcodes.INTEGER;
                } else if (next.represents(Long.TYPE)) {
                    obj2 = Opcodes.LONG;
                } else if (next.represents(Float.TYPE)) {
                    obj2 = Opcodes.FLOAT;
                } else if (next.represents(Double.TYPE)) {
                    obj2 = Opcodes.DOUBLE;
                } else {
                    obj2 = next.getInternalName();
                }
                i11++;
                objArr[i11] = obj2;
            }
            return objArr;
        }

        public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
            final MethodDescription.InDefinedShape inDefinedShape;
            if (methodDescription.isConstructor() && !typeDescription.represents(Object.class)) {
                int i13 = Integer.MAX_VALUE;
                boolean z11 = true;
                r0 = null;
                loop0:
                while (true) {
                    inDefinedShape = r0;
                    for (MethodDescription.InDefinedShape inDefinedShape2 : (MethodList) typeDescription.getSuperClass().asErasure().getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.not(ElementMatchers.isPrivate())))) {
                        if (inDefinedShape2.getParameters().size() < i13 && (z11 || !inDefinedShape2.isPackagePrivate())) {
                            i13 = inDefinedShape2.getParameters().size();
                            z11 = inDefinedShape2.isPackagePrivate();
                        }
                    }
                    break loop0;
                }
                if (inDefinedShape != null) {
                    final Implementation.Context context2 = context;
                    final TypeDescription typeDescription2 = typeDescription;
                    final MethodDescription methodDescription2 = methodDescription;
                    return new MethodVisitor(OpenedClassReader.ASM_API, methodVisitor) {
                        public void visitCode() {
                            int i11;
                            int i12;
                            int i13;
                            super.visitCode();
                            Label label = new Label();
                            super.visitLdcInsn(ConstructorShortcut.this.identifier);
                            Class<String> cls = String.class;
                            Class<Class> cls2 = Class.class;
                            if (context2.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V5)) {
                                super.visitLdcInsn(Type.getType(typeDescription2.getDescriptor()));
                            } else {
                                super.visitLdcInsn(typeDescription2.getName());
                                super.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(cls2), "forName", Type.getMethodDescriptor(Type.getType((Class<?>) cls2), Type.getType((Class<?>) cls)), false);
                            }
                            super.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(MockMethodDispatcher.class), "isConstructorMock", Type.getMethodDescriptor(Type.BOOLEAN_TYPE, Type.getType((Class<?>) cls), Type.getType((Class<?>) cls2)), false);
                            super.visitInsn(3);
                            super.visitJumpInsn(Opcodes.IF_ICMPEQ, label);
                            super.visitVarInsn(25, 0);
                            for (TypeDescription typeDescription : inDefinedShape.getParameters().asTypeList().asErasures()) {
                                if (typeDescription.represents(Boolean.TYPE) || typeDescription.represents(Byte.TYPE) || typeDescription.represents(Short.TYPE) || typeDescription.represents(Character.TYPE) || typeDescription.represents(Integer.TYPE)) {
                                    super.visitInsn(3);
                                } else if (typeDescription.represents(Long.TYPE)) {
                                    super.visitInsn(9);
                                } else if (typeDescription.represents(Float.TYPE)) {
                                    super.visitInsn(11);
                                } else if (typeDescription.represents(Double.TYPE)) {
                                    super.visitInsn(14);
                                } else {
                                    super.visitInsn(1);
                                }
                            }
                            super.visitMethodInsn(Opcodes.INVOKESPECIAL, inDefinedShape.getDeclaringType().getInternalName(), inDefinedShape.getInternalName(), inDefinedShape.getDescriptor(), false);
                            super.visitLdcInsn(ConstructorShortcut.this.identifier);
                            if (context2.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V5)) {
                                super.visitLdcInsn(Type.getType(typeDescription2.getDescriptor()));
                            } else {
                                super.visitLdcInsn(typeDescription2.getName());
                                super.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(cls2), "forName", Type.getMethodDescriptor(Type.getType((Class<?>) cls2), Type.getType((Class<?>) cls)), false);
                            }
                            super.visitVarInsn(25, 0);
                            super.visitLdcInsn(Integer.valueOf(methodDescription2.getParameters().size()));
                            Class<Object> cls3 = Object.class;
                            int i14 = 189;
                            super.visitTypeInsn(189, Type.getInternalName(cls3));
                            Iterator<E> it = methodDescription2.getParameters().iterator();
                            int i15 = 0;
                            while (it.hasNext()) {
                                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                                super.visitInsn(89);
                                int i16 = i15 + 1;
                                super.visitLdcInsn(Integer.valueOf(i15));
                                Type type = Type.getType(parameterDescription.getType().asErasure().getDescriptor());
                                super.visitVarInsn(type.getOpcode(21), parameterDescription.getOffset());
                                if (parameterDescription.getType().isPrimitive()) {
                                    Type type2 = Type.getType(parameterDescription.getType().asErasure().asBoxed().getDescriptor());
                                    i12 = 83;
                                    i13 = i14;
                                    super.visitMethodInsn(Opcodes.INVOKESTATIC, type2.getInternalName(), "valueOf", Type.getMethodDescriptor(type2, type), false);
                                } else {
                                    i13 = i14;
                                    i12 = 83;
                                }
                                super.visitInsn(i12);
                                i14 = i13;
                                i15 = i16;
                            }
                            super.visitLdcInsn(Integer.valueOf(methodDescription2.getParameters().size()));
                            super.visitTypeInsn(i14, Type.getInternalName(cls));
                            int i17 = 0;
                            for (TypeDescription name2 : methodDescription2.getParameters().asTypeList().asErasures()) {
                                super.visitInsn(89);
                                super.visitLdcInsn(Integer.valueOf(i17));
                                super.visitLdcInsn(name2.getName());
                                super.visitInsn(83);
                                i17++;
                            }
                            super.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(MockMethodDispatcher.class), "handleConstruction", Type.getMethodDescriptor(Type.getType((Class<?>) cls3), Type.getType((Class<?>) cls), Type.getType((Class<?>) cls2), Type.getType((Class<?>) cls3), Type.getType((Class<?>) Object[].class), Type.getType((Class<?>) String[].class)), false);
                            super.visitTypeInsn(192, typeDescription2.getInternalName());
                            super.visitInsn(89);
                            Label label2 = new Label();
                            super.visitJumpInsn(Opcodes.IFNULL, label2);
                            for (FieldDescription fieldDescription : (FieldList) typeDescription2.getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic()))) {
                                super.visitInsn(89);
                                super.visitFieldInsn(180, typeDescription2.getInternalName(), fieldDescription.getInternalName(), fieldDescription.getDescriptor());
                                super.visitVarInsn(25, 0);
                                if (fieldDescription.getType().getStackSize() == StackSize.DOUBLE) {
                                    i11 = 91;
                                } else {
                                    i11 = 90;
                                }
                                super.visitInsn(i11);
                                super.visitInsn(87);
                                super.visitFieldInsn(Opcodes.PUTFIELD, typeDescription2.getInternalName(), fieldDescription.getInternalName(), fieldDescription.getDescriptor());
                            }
                            super.visitLabel(label2);
                            ClassFileVersion classFileVersion = context2.getClassFileVersion();
                            ClassFileVersion classFileVersion2 = ClassFileVersion.JAVA_V6;
                            if (classFileVersion.isAtLeast(classFileVersion2)) {
                                Object[] b11 = ConstructorShortcut.toFrames(typeDescription2.getInternalName(), methodDescription2.getParameters().asTypeList().asErasures());
                                super.visitFrame(0, b11.length, b11, 1, new Object[]{typeDescription2.getInternalName()});
                            }
                            super.visitInsn(87);
                            super.visitInsn(Opcodes.RETURN);
                            super.visitLabel(label);
                            if (context2.getClassFileVersion().isAtLeast(classFileVersion2)) {
                                Object[] b12 = ConstructorShortcut.toFrames(Opcodes.UNINITIALIZED_THIS, methodDescription2.getParameters().asTypeList().asErasures());
                                super.visitFrame(0, b12.length, b12, 0, new Object[0]);
                            }
                        }

                        public void visitMaxs(int i11, int i12) {
                            int max = Math.max(5, inDefinedShape.getStackSize());
                            Iterator<E> it = methodDescription2.getParameters().iterator();
                            while (it.hasNext()) {
                                max = Math.max(Math.max(max, ((ParameterDescription) it.next()).getType().getStackSize().getSize() + 6), 8);
                            }
                            super.visitMaxs(Math.max(i11, max), i12);
                        }
                    };
                }
            }
            return methodVisitor;
        }
    }

    public static class ForEquals {
        @Advice.OnMethodExit
        private static void enter(@Advice.This Object obj, @Advice.Argument(0) Object obj2, @Advice.Return(readOnly = false) boolean z11, @Advice.Enter boolean z12) {
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        private static boolean enter(@Identifier String str, @Advice.This Object obj) {
            MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.get(str, obj);
            if (mockMethodDispatcher == null || !mockMethodDispatcher.isMock(obj)) {
                return false;
            }
            return true;
        }
    }

    public static class ForReadObject {
        public static void doReadObject(@Identifier String str, @This MockAccess mockAccess, @Argument(0) ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            MockMethodAdvice mockMethodAdvice = MockMethodDispatcher.get(str, mockAccess);
            if (mockMethodAdvice != null) {
                mockMethodAdvice.interceptors.put(mockAccess, mockAccess.getMockitoInterceptor());
            }
        }
    }

    public static class ForStatic {
        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        private static Callable<?> enter(@Identifier String str, @Advice.Origin Class<?> cls, @Advice.Origin Method method, @Advice.AllArguments Object[] objArr) throws Throwable {
            MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.getStatic(str, cls);
            if (mockMethodDispatcher == null || !mockMethodDispatcher.isMockedStatic(cls)) {
                return null;
            }
            return mockMethodDispatcher.handleStatic(cls, method, objArr);
        }

        @Advice.OnMethodExit
        private static void exit(@Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object obj, @Advice.Enter Callable<?> callable) throws Throwable {
            if (callable != null) {
                callable.call();
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Identifier {
    }

    public static class RealMethodCall implements RealMethod {
        private final Object[] arguments;
        private final MockWeakReference<Object> instanceRef;
        private final Method origin;
        private final SelfCallInfo selfCallInfo;

        public Object invoke() throws Throwable {
            this.selfCallInfo.set(this.instanceRef.get());
            return MockMethodAdvice.tryInvoke(this.origin, this.instanceRef.get(), this.arguments);
        }

        public boolean isInvokable() {
            return true;
        }

        private RealMethodCall(SelfCallInfo selfCallInfo2, Method method, Object obj, Object[] objArr) {
            this.selfCallInfo = selfCallInfo2;
            this.origin = method;
            this.instanceRef = new MockWeakReference<>(obj);
            this.arguments = objArr;
        }
    }

    public static class ReturnValueWrapper implements Callable<Object> {
        private final Object returned;

        public Object call() {
            return this.returned;
        }

        private ReturnValueWrapper(Object obj) {
            this.returned = obj;
        }
    }

    public static class SelfCallInfo extends ThreadLocal<Object> {
        private SelfCallInfo() {
        }

        public boolean a(Object obj) {
            if (obj != get()) {
                return true;
            }
            set((Object) null);
            return false;
        }

        public Object b(Object obj) {
            Object obj2 = get();
            set(obj);
            return obj2;
        }
    }

    public static class SerializableRealMethodCall implements RealMethod {
        private final Object[] arguments;
        private final String identifier;
        private final MockReference<Object> instanceRef;
        private final SerializableMethod origin;

        public Object invoke() throws Throwable {
            Method javaMethod = this.origin.getJavaMethod();
            MockMethodAdvice mockMethodAdvice = MockMethodDispatcher.get(this.identifier, this.instanceRef.get());
            if (mockMethodAdvice instanceof MockMethodAdvice) {
                MockMethodAdvice mockMethodAdvice2 = mockMethodAdvice;
                Object b11 = mockMethodAdvice2.selfCallInfo.b(this.instanceRef.get());
                try {
                    return MockMethodAdvice.tryInvoke(javaMethod, this.instanceRef.get(), this.arguments);
                } finally {
                    mockMethodAdvice2.selfCallInfo.set(b11);
                }
            } else {
                throw new MockitoException("Unexpected dispatcher for advice-based super call");
            }
        }

        public boolean isInvokable() {
            return true;
        }

        private SerializableRealMethodCall(String str, Method method, Object obj, Object[] objArr) {
            this.origin = new SerializableMethod(method);
            this.identifier = str;
            this.instanceRef = new MockWeakReference(obj);
            this.arguments = objArr;
        }
    }

    public static class StaticMethodCall implements RealMethod {
        private final Object[] arguments;
        private final Method origin;
        private final SelfCallInfo selfCallInfo;
        private final Class<?> type;

        public Object invoke() throws Throwable {
            this.selfCallInfo.set(this.type);
            return MockMethodAdvice.tryInvoke(this.origin, (Object) null, this.arguments);
        }

        public boolean isInvokable() {
            return true;
        }

        private StaticMethodCall(SelfCallInfo selfCallInfo2, Class<?> cls, Method method, Object[] objArr) {
            this.selfCallInfo = selfCallInfo2;
            this.type = cls;
            this.origin = method;
            this.arguments = objArr;
        }
    }

    public MockMethodAdvice(WeakConcurrentMap<Object, MockMethodInterceptor> weakConcurrentMap, DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> detachedThreadLocal, String str, Predicate<Class<?>> predicate, ConstructionCallback constructionCallback) {
        this.interceptors = weakConcurrentMap;
        this.mockedStatics = detachedThreadLocal;
        this.onConstruction = constructionCallback;
        this.identifier = str;
        this.isMockConstruction = predicate;
    }

    public static Throwable d(Throwable th2, int i11, Class<?> cls) {
        try {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int i12 = 0;
            do {
                i12++;
            } while (!stackTrace[(stackTrace.length - i11) - i12].getClassName().equals(cls.getName()));
            int length = (stackTrace.length - i11) - i12;
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length - i12)];
            System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, length);
            System.arraycopy(stackTrace, i12 + length, stackTraceElementArr, length, i11);
            th2.setStackTrace(stackTraceElementArr);
        } catch (RuntimeException unused) {
        }
        return th2;
    }

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    private static Callable<?> enter(@Identifier String str, @Advice.This Object obj, @Advice.Origin Method method, @Advice.AllArguments Object[] objArr) throws Throwable {
        MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.get(str, obj);
        if (mockMethodDispatcher == null || !mockMethodDispatcher.isMocked(obj) || mockMethodDispatcher.isOverridden(obj, method)) {
            return null;
        }
        return mockMethodDispatcher.handle(obj, method, objArr);
    }

    @Advice.OnMethodExit
    private static void exit(@Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object obj, @Advice.Enter Callable<?> callable) throws Throwable {
        if (callable != null) {
            callable.call();
        }
    }

    /* access modifiers changed from: private */
    public static Object tryInvoke(Method method, Object obj, Object[] objArr) throws Throwable {
        int i11;
        try {
            return Plugins.getMemberAccessor().invoke(method, obj, objArr);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int length = stackTrace.length;
            if (obj != null) {
                int i12 = 0;
                while (true) {
                    i11 = i12 + 1;
                    if (!stackTrace[i12].getClassName().startsWith(obj.getClass().getName())) {
                        break;
                    }
                    i12 = i11;
                }
                length = i11;
            }
            new ConditionalStackTraceFilter().filter(d(cause, length, method.getDeclaringClass()));
            throw cause;
        }
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r0v8, types: [org.mockito.internal.creation.bytebuddy.MockMethodAdvice$RealMethodCall] */
    /* JADX WARNING: type inference failed for: r0v9, types: [org.mockito.internal.creation.bytebuddy.MockMethodAdvice$SerializableRealMethodCall] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.concurrent.Callable<?> handle(java.lang.Object r10, java.lang.reflect.Method r11, java.lang.Object[] r12) throws java.lang.Throwable {
        /*
            r9 = this;
            org.mockito.internal.util.concurrent.WeakConcurrentMap<java.lang.Object, org.mockito.internal.creation.bytebuddy.MockMethodInterceptor> r0 = r9.interceptors
            java.lang.Object r0 = r0.get(r10)
            r6 = r0
            org.mockito.internal.creation.bytebuddy.MockMethodInterceptor r6 = (org.mockito.internal.creation.bytebuddy.MockMethodInterceptor) r6
            r7 = 0
            if (r6 != 0) goto L_0x000d
            return r7
        L_0x000d:
            boolean r0 = r10 instanceof java.io.Serializable
            if (r0 == 0) goto L_0x001e
            org.mockito.internal.creation.bytebuddy.MockMethodAdvice$SerializableRealMethodCall r8 = new org.mockito.internal.creation.bytebuddy.MockMethodAdvice$SerializableRealMethodCall
            java.lang.String r1 = r9.identifier
            r5 = 0
            r0 = r8
            r2 = r11
            r3 = r10
            r4 = r12
            r0.<init>(r1, r2, r3, r4)
            goto L_0x002a
        L_0x001e:
            org.mockito.internal.creation.bytebuddy.MockMethodAdvice$RealMethodCall r8 = new org.mockito.internal.creation.bytebuddy.MockMethodAdvice$RealMethodCall
            org.mockito.internal.creation.bytebuddy.MockMethodAdvice$SelfCallInfo r1 = r9.selfCallInfo
            r5 = 0
            r0 = r8
            r2 = r11
            r3 = r10
            r4 = r12
            r0.<init>(r1, r2, r3, r4)
        L_0x002a:
            r4 = r8
            org.mockito.internal.creation.bytebuddy.MockMethodAdvice$ReturnValueWrapper r8 = new org.mockito.internal.creation.bytebuddy.MockMethodAdvice$ReturnValueWrapper
            org.mockito.internal.debugging.LocationImpl r5 = new org.mockito.internal.debugging.LocationImpl
            java.lang.Throwable r0 = new java.lang.Throwable
            r0.<init>()
            r1 = 1
            r5.<init>(r0, r1)
            r0 = r6
            r1 = r10
            r2 = r11
            r3 = r12
            java.lang.Object r0 = r0.b(r1, r2, r3, r4, r5)
            r8.<init>(r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.MockMethodAdvice.handle(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.util.concurrent.Callable");
    }

    public Object handleConstruction(Class<?> cls, Object obj, Object[] objArr, String[] strArr) {
        return this.onConstruction.apply(cls, obj, objArr, strArr);
    }

    public Callable<?> handleStatic(Class<?> cls, Method method, Object[] objArr) throws Throwable {
        Map map = this.mockedStatics.get();
        if (map == null || !map.containsKey(cls)) {
            return null;
        }
        return new ReturnValueWrapper(((MockMethodInterceptor) map.get(cls)).b(cls, method, objArr, new StaticMethodCall(this.selfCallInfo, cls, method, objArr), new LocationImpl(new Throwable(), true)));
    }

    public boolean isConstructorMock(Class<?> cls) {
        return this.isMockConstruction.test(cls);
    }

    public boolean isMock(Object obj) {
        WeakConcurrentMap<Object, MockMethodInterceptor> weakConcurrentMap = this.interceptors;
        return obj != weakConcurrentMap.target && weakConcurrentMap.containsKey(obj);
    }

    public boolean isMocked(Object obj) {
        return this.selfCallInfo.a(obj) && isMock(obj);
    }

    public boolean isMockedStatic(Class<?> cls) {
        Map map;
        if (this.selfCallInfo.a(cls) && (map = this.mockedStatics.get()) != null && map.containsKey(cls)) {
            return true;
        }
        return false;
    }

    public boolean isOverridden(Object obj, Method method) {
        MethodGraph methodGraph;
        SoftReference softReference = this.graphs.get(obj.getClass());
        if (softReference == null) {
            methodGraph = null;
        } else {
            methodGraph = (MethodGraph) softReference.get();
        }
        if (methodGraph == null) {
            methodGraph = this.compiler.compile((TypeDescription) new TypeDescription.ForLoadedType(obj.getClass()));
            this.graphs.put(obj.getClass(), new SoftReference(methodGraph));
        }
        MethodGraph.Node locate = methodGraph.locate(new MethodDescription.ForLoadedMethod(method).asSignatureToken());
        if (!locate.getSort().isResolved() || !((MethodDescription.InDefinedShape) locate.getRepresentative().asDefined()).getDeclaringType().represents(method.getDeclaringClass())) {
            return true;
        }
        return false;
    }

    public static class ForHashCode {
        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        private static boolean enter(@Identifier String str, @Advice.This Object obj) {
            MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.get(str, obj);
            return mockMethodDispatcher != null && mockMethodDispatcher.isMock(obj);
        }

        @Advice.OnMethodExit
        private static void enter(@Advice.This Object obj, @Advice.Return(readOnly = false) int i11, @Advice.Enter boolean z11) {
            if (z11) {
                System.identityHashCode(obj);
            }
        }
    }
}
