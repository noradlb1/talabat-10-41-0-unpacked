package net.bytebuddy.utility.dispatcher;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.Invoker;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

@HashCodeAndEqualsPlugin.Enhance
public class JavaDispatcher<T> implements PrivilegedAction<T> {
    private static final boolean ACCESS_CONTROLLER;
    private static final boolean GENERATE = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(GENERATE_PROPERTY)));
    public static final String GENERATE_PROPERTY = "net.bytebuddy.generate";
    /* access modifiers changed from: private */
    public static final Invoker INVOKER = ((Invoker) doPrivileged(new InvokerCreationAction()));
    /* access modifiers changed from: private */
    public static final DynamicClassLoader.Resolver RESOLVER = ((DynamicClassLoader.Resolver) doPrivileged(DynamicClassLoader.Resolver.CreationAction.INSTANCE));
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final ClassLoader classLoader;
    private final boolean generate;
    private final Class<T> proxy;

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Container {
    }

    @Documented
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Defaults {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class DirectInvoker implements Invoker {
        private DirectInvoker() {
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

        public Object invoke(Method method, Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            return method.invoke(obj, objArr);
        }

        public Object newInstance(Constructor<?> constructor, Object[] objArr) throws InstantiationException, IllegalAccessException, InvocationTargetException {
            return constructor.newInstance(objArr);
        }
    }

    public interface Dispatcher {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForConstructor implements Dispatcher {
            private final Constructor<?> constructor;

            public ForConstructor(Constructor<?> constructor2) {
                this.constructor = constructor2;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                Class[] parameterTypes = method.getParameterTypes();
                Class[] parameterTypes2 = this.constructor.getParameterTypes();
                methodVisitor.visitTypeInsn(Opcodes.NEW, Type.getInternalName(this.constructor.getDeclaringClass()));
                methodVisitor.visitInsn(89);
                int i11 = 1;
                for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                    Type type = Type.getType((Class<?>) parameterTypes[i12]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), i11);
                    Class cls = parameterTypes[i12];
                    Class cls2 = parameterTypes2[i12];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    i11 += type.getSize();
                }
                methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(this.constructor.getDeclaringClass()), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getConstructorDescriptor(this.constructor), false);
                methodVisitor.visitInsn(Opcodes.ARETURN);
                return i11 + 1;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForConstructor) obj).constructor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.constructor.hashCode();
            }

            public Object invoke(Object[] objArr) throws Throwable {
                return JavaDispatcher.INVOKER.newInstance(this.constructor, objArr);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForContainerCreation implements Dispatcher {
            private final Class<?> target;

            public ForContainerCreation(Class<?> cls) {
                this.target = cls;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(21, 1);
                methodVisitor.visitTypeInsn(189, Type.getInternalName(this.target));
                methodVisitor.visitInsn(Opcodes.ARETURN);
                return 1;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForContainerCreation) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            public Object invoke(Object[] objArr) {
                return Array.newInstance(this.target, objArr[0].intValue());
            }
        }

        public enum ForDefaultValue implements Dispatcher {
            VOID((String) null, 0, Opcodes.RETURN, 0),
            BOOLEAN(Boolean.FALSE, 3, 172, 1),
            BOOLEAN_REVERSE(Boolean.TRUE, 4, 172, 1),
            BYTE((byte) 0, 3, 172, 1),
            SHORT((short) 0, 3, 172, 1),
            CHARACTER(0, 3, 172, 1),
            INTEGER(0, 3, 172, 1),
            LONG(0L, 9, Opcodes.LRETURN, 2),
            FLOAT(Float.valueOf(0.0f), 11, Opcodes.FRETURN, 1),
            DOUBLE(Double.valueOf(0.0d), 14, Opcodes.DRETURN, 2),
            REFERENCE((String) null, 1, Opcodes.ARETURN, 1);
            
            private final int load;
            private final int returned;
            private final int size;
            private final Object value;

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfNonPrimitiveArray implements Dispatcher {
                private final Class<?> componentType;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
                private final Object value;

                public OfNonPrimitiveArray(Object obj, Class<?> cls) {
                    this.value = obj;
                    this.componentType = cls;
                }

                public static Dispatcher a(Class<?> cls) {
                    return new OfNonPrimitiveArray(Array.newInstance(cls, 0), cls);
                }

                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitTypeInsn(189, Type.getInternalName(this.componentType));
                    methodVisitor.visitInsn(Opcodes.ARETURN);
                    return 1;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfNonPrimitiveArray) obj).componentType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.componentType.hashCode();
                }

                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            public enum OfPrimitiveArray implements Dispatcher {
                BOOLEAN(new boolean[0], 4),
                BYTE(new byte[0], 8),
                SHORT(new short[0], 9),
                CHARACTER(new char[0], 5),
                INTEGER(new int[0], 10),
                LONG(new long[0], 11),
                FLOAT(new float[0], 6),
                DOUBLE(new double[0], 7);
                
                private final int operand;
                private final Object value;

                private OfPrimitiveArray(Object obj, int i11) {
                    this.value = obj;
                    this.operand = i11;
                }

                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitIntInsn(188, this.operand);
                    methodVisitor.visitInsn(Opcodes.ARETURN);
                    return 1;
                }

                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            private ForDefaultValue(Object obj, int i11, int i12, int i13) {
                this.value = obj;
                this.load = i11;
                this.returned = i12;
                this.size = i13;
            }

            public static Dispatcher a(Class<?> cls) {
                if (cls == Void.TYPE) {
                    return VOID;
                }
                Class<?> cls2 = Boolean.TYPE;
                if (cls == cls2) {
                    return BOOLEAN;
                }
                if (cls == Byte.TYPE) {
                    return BYTE;
                }
                if (cls == Short.TYPE) {
                    return SHORT;
                }
                if (cls == Character.TYPE) {
                    return CHARACTER;
                }
                Class<?> cls3 = Integer.TYPE;
                if (cls == cls3) {
                    return INTEGER;
                }
                Class<?> cls4 = Long.TYPE;
                if (cls == cls4) {
                    return LONG;
                }
                Class<?> cls5 = Float.TYPE;
                if (cls == cls5) {
                    return FLOAT;
                }
                if (cls == Double.TYPE) {
                    return DOUBLE;
                }
                if (!cls.isArray()) {
                    return REFERENCE;
                }
                if (cls.getComponentType() == cls2) {
                    return OfPrimitiveArray.BOOLEAN;
                }
                if (cls.getComponentType() == Byte.TYPE) {
                    return OfPrimitiveArray.BYTE;
                }
                if (cls.getComponentType() == Short.TYPE) {
                    return OfPrimitiveArray.SHORT;
                }
                if (cls.getComponentType() == Character.TYPE) {
                    return OfPrimitiveArray.CHARACTER;
                }
                if (cls.getComponentType() == cls3) {
                    return OfPrimitiveArray.INTEGER;
                }
                if (cls.getComponentType() == cls4) {
                    return OfPrimitiveArray.LONG;
                }
                if (cls.getComponentType() == cls5) {
                    return OfPrimitiveArray.FLOAT;
                }
                if (cls.getComponentType() == Double.TYPE) {
                    return OfPrimitiveArray.DOUBLE;
                }
                return OfNonPrimitiveArray.a(cls.getComponentType());
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                int i11 = this.load;
                if (i11 != 0) {
                    methodVisitor.visitInsn(i11);
                }
                methodVisitor.visitInsn(this.returned);
                return this.size;
            }

            public Object invoke(Object[] objArr) {
                return this.value;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForInstanceCheck implements Dispatcher {
            private final Class<?> target;

            public ForInstanceCheck(Class<?> cls) {
                this.target = cls;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, Type.getInternalName(this.target));
                methodVisitor.visitInsn(172);
                return 1;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForInstanceCheck) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            public Object invoke(Object[] objArr) {
                return Boolean.valueOf(this.target.isInstance(objArr[0]));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForNonStaticMethod implements Dispatcher {
            private static final Object[] NO_ARGUMENTS = new Object[0];
            private final Method method;

            public ForNonStaticMethod(Method method2) {
                this.method = method2;
            }

            public int apply(MethodVisitor methodVisitor, Method method2) {
                int i11;
                Class<?> cls;
                Class<?> cls2;
                Class<?>[] parameterTypes = method2.getParameterTypes();
                Class<?>[] parameterTypes2 = this.method.getParameterTypes();
                int i12 = 1;
                for (int i13 = 0; i13 < parameterTypes.length; i13++) {
                    Type type = Type.getType(parameterTypes[i13]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), i12);
                    Class<?> cls3 = parameterTypes[i13];
                    if (i13 == 0) {
                        cls = this.method.getDeclaringClass();
                    } else {
                        cls = parameterTypes2[i13 - 1];
                    }
                    if (cls3 != cls) {
                        if (i13 == 0) {
                            cls2 = this.method.getDeclaringClass();
                        } else {
                            cls2 = parameterTypes2[i13 - 1];
                        }
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    i12 += type.getSize();
                }
                if (this.method.getDeclaringClass().isInterface()) {
                    i11 = Opcodes.INVOKEINTERFACE;
                } else {
                    i11 = Opcodes.INVOKEVIRTUAL;
                }
                methodVisitor.visitMethodInsn(i11, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(i12 - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForNonStaticMethod) obj).method);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            public Object invoke(Object[] objArr) throws Throwable {
                Object[] objArr2;
                if (objArr.length == 1) {
                    objArr2 = NO_ARGUMENTS;
                } else {
                    int length = objArr.length - 1;
                    Object[] objArr3 = new Object[length];
                    System.arraycopy(objArr, 1, objArr3, 0, length);
                    objArr2 = objArr3;
                }
                return JavaDispatcher.INVOKER.invoke(this.method, objArr[0], objArr2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStaticMethod implements Dispatcher {
            private final Method method;

            public ForStaticMethod(Method method2) {
                this.method = method2;
            }

            public int apply(MethodVisitor methodVisitor, Method method2) {
                Class[] parameterTypes = method2.getParameterTypes();
                Class[] parameterTypes2 = this.method.getParameterTypes();
                int i11 = 1;
                for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                    Type type = Type.getType((Class<?>) parameterTypes[i12]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), i11);
                    Class cls = parameterTypes[i12];
                    Class cls2 = parameterTypes2[i12];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    i11 += type.getSize();
                }
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(i11 - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForStaticMethod) obj).method);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            public Object invoke(Object[] objArr) throws Throwable {
                return JavaDispatcher.INVOKER.invoke(this.method, (Object) null, objArr);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnresolvedMethod implements Dispatcher {
            private final String message;

            public ForUnresolvedMethod(String str) {
                this.message = str;
            }

            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<IllegalStateException> cls = IllegalStateException.class;
                methodVisitor.visitTypeInsn(Opcodes.NEW, Type.getInternalName(cls));
                methodVisitor.visitInsn(89);
                methodVisitor.visitLdcInsn(this.message);
                MethodVisitor methodVisitor2 = methodVisitor;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(cls), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType((Class<?>) String.class)), false);
                methodVisitor.visitInsn(Opcodes.ATHROW);
                return 3;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((ForUnresolvedMethod) obj).message);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.message.hashCode();
            }

            public Object invoke(Object[] objArr) throws Throwable {
                throw new IllegalStateException("Could not invoke proxy: " + this.message);
            }
        }

        int apply(MethodVisitor methodVisitor, Method method);

        Object invoke(Object[] objArr) throws Throwable;
    }

    public static class DynamicClassLoader extends ClassLoader {
        private static final Object[] NO_ARGUMENT = new Object[0];
        private static final Class<?>[] NO_PARAMETER = new Class[0];

        public interface Resolver {

            public enum CreationAction implements PrivilegedAction<Resolver> {
                INSTANCE;

                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
                public Resolver run() {
                    Class<String> cls = String.class;
                    try {
                        Class<?> cls2 = Class.forName("java.lang.Module", false, (ClassLoader) null);
                        return new ForModuleSystem(Class.class.getMethod("getModule", new Class[0]), cls2.getMethod("isExported", new Class[]{cls}), cls2.getMethod("addExports", new Class[]{cls, cls2}), ClassLoader.class.getMethod("getUnnamedModule", new Class[0]));
                    } catch (Exception unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForModuleSystem implements Resolver {
                private final Method addExports;
                private final Method getModule;
                private final Method getUnnamedModule;
                private final Method isExported;

                public ForModuleSystem(Method method, Method method2, Method method3, Method method4) {
                    this.getModule = method;
                    this.isExported = method2;
                    this.addExports = method3;
                    this.getUnnamedModule = method4;
                }

                @SuppressFBWarnings(justification = "Exception should always be wrapped for clarity", value = {"REC_CATCH_EXCEPTION"})
                public void accept(ClassLoader classLoader, Class<?> cls) {
                    Package packageR = cls.getPackage();
                    if (packageR != null) {
                        try {
                            Object invoke = this.getModule.invoke(cls, new Object[0]);
                            if (!((Boolean) this.isExported.invoke(invoke, new Object[]{packageR.getName()})).booleanValue()) {
                                this.addExports.invoke(invoke, new Object[]{packageR.getName(), this.getUnnamedModule.invoke(classLoader, new Object[0])});
                            }
                        } catch (Exception e11) {
                            throw new IllegalStateException("Failed to adjust module graph for dispatcher", e11);
                        }
                    }
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForModuleSystem forModuleSystem = (ForModuleSystem) obj;
                    return this.getModule.equals(forModuleSystem.getModule) && this.isExported.equals(forModuleSystem.isExported) && this.addExports.equals(forModuleSystem.addExports) && this.getUnnamedModule.equals(forModuleSystem.getUnnamedModule);
                }

                public int hashCode() {
                    return (((((((getClass().hashCode() * 31) + this.getModule.hashCode()) * 31) + this.isExported.hashCode()) * 31) + this.addExports.hashCode()) * 31) + this.getUnnamedModule.hashCode();
                }
            }

            public enum NoOp implements Resolver {
                INSTANCE;

                public void accept(ClassLoader classLoader, Class<?> cls) {
                }
            }

            void accept(ClassLoader classLoader, Class<?> cls);
        }

        public DynamicClassLoader(Class<?> cls) {
            super(cls.getClassLoader());
            JavaDispatcher.RESOLVER.accept(this, cls);
        }

        @SuppressFBWarnings(justification = "Expected internal invocation", value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        public static Invoker a() {
            ClassWriter classWriter = new ClassWriter(0);
            int minorMajorVersion = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion();
            StringBuilder sb2 = new StringBuilder();
            Class<Invoker> cls = Invoker.class;
            sb2.append(Type.getInternalName(cls));
            sb2.append("$Dispatcher");
            Class<Object> cls2 = Object.class;
            classWriter.visit(minorMajorVersion, 1, sb2.toString(), (String) null, Type.getInternalName(cls2), new String[]{Type.getInternalName(cls)});
            for (Method method : cls.getMethods()) {
                Class[] exceptionTypes = method.getExceptionTypes();
                String[] strArr = new String[exceptionTypes.length];
                for (int i11 = 0; i11 < exceptionTypes.length; i11++) {
                    strArr[i11] = Type.getInternalName(exceptionTypes[i11]);
                }
                MethodVisitor visitMethod = classWriter.visitMethod(1, method.getName(), Type.getMethodDescriptor(method), (String) null, strArr);
                visitMethod.visitCode();
                Type[] typeArr = new Type[(method.getParameterTypes().length - 1)];
                int i12 = 1;
                for (int i13 = 0; i13 < method.getParameterTypes().length; i13++) {
                    Type type = Type.getType((Class<?>) method.getParameterTypes()[i13]);
                    if (i13 > 0) {
                        typeArr[i13 - 1] = type;
                    }
                    visitMethod.visitVarInsn(type.getOpcode(21), i12);
                    i12 += type.getSize();
                }
                visitMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Type.getInternalName(method.getParameterTypes()[0]), method.getName(), Type.getMethodDescriptor(Type.getReturnType(method), typeArr), false);
                visitMethod.visitInsn(Type.getReturnType(method).getOpcode(172));
                visitMethod.visitMaxs(Math.max(i12 - 1, Type.getReturnType(method).getSize()), i12);
                visitMethod.visitEnd();
            }
            Type type2 = Type.VOID_TYPE;
            MethodVisitor visitMethod2 = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), (String) null, (String[]) null);
            visitMethod2.visitCode();
            visitMethod2.visitVarInsn(25, 0);
            visitMethod2.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(cls2), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), false);
            visitMethod2.visitInsn(Opcodes.RETURN);
            visitMethod2.visitMaxs(1, 1);
            visitMethod2.visitEnd();
            classWriter.visitEnd();
            byte[] byteArray = classWriter.toByteArray();
            try {
                return (Invoker) new DynamicClassLoader(cls).defineClass(cls.getName() + "$Dispatcher", byteArray, 0, byteArray.length, JavaDispatcher.class.getProtectionDomain()).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
            } catch (UnsupportedOperationException unused) {
                return new DirectInvoker();
            } catch (Exception e11) {
                throw new IllegalStateException("Failed to create invoker for " + cls.getName(), e11);
            }
        }

        @SuppressFBWarnings(justification = "Expected internal invocation", value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        public static Object b(Class<?> cls, Map<Method, Dispatcher> map) {
            int i11;
            ClassWriter classWriter = new ClassWriter(0);
            Class<Object> cls2 = Object.class;
            classWriter.visit(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion(), 1, Type.getInternalName(cls) + "$Proxy", (String) null, Type.getInternalName(cls2), new String[]{Type.getInternalName(cls)});
            for (Map.Entry next : map.entrySet()) {
                Class[] exceptionTypes = ((Method) next.getKey()).getExceptionTypes();
                String[] strArr = new String[exceptionTypes.length];
                for (int i12 = 0; i12 < exceptionTypes.length; i12++) {
                    strArr[i12] = Type.getInternalName(exceptionTypes[i12]);
                }
                MethodVisitor visitMethod = classWriter.visitMethod(1, ((Method) next.getKey()).getName(), Type.getMethodDescriptor((Method) next.getKey()), (String) null, strArr);
                visitMethod.visitCode();
                if ((((Method) next.getKey()).getModifiers() & 8) == 0) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                for (Class type : ((Method) next.getKey()).getParameterTypes()) {
                    i11 += Type.getType((Class<?>) type).getSize();
                }
                visitMethod.visitMaxs(((Dispatcher) next.getValue()).apply(visitMethod, (Method) next.getKey()), i11);
                visitMethod.visitEnd();
            }
            Type type2 = Type.VOID_TYPE;
            MethodVisitor visitMethod2 = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), (String) null, (String[]) null);
            visitMethod2.visitCode();
            visitMethod2.visitVarInsn(25, 0);
            visitMethod2.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(cls2), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), false);
            visitMethod2.visitInsn(Opcodes.RETURN);
            visitMethod2.visitMaxs(1, 1);
            visitMethod2.visitEnd();
            classWriter.visitEnd();
            byte[] byteArray = classWriter.toByteArray();
            try {
                try {
                    return new DynamicClassLoader(cls).defineClass(cls.getName() + "$Proxy", byteArray, 0, byteArray.length, JavaDispatcher.class.getProtectionDomain()).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
                } catch (Exception e11) {
                    e = e11;
                    throw new IllegalStateException("Failed to create proxy for " + cls.getName(), e);
                }
            } catch (Exception e12) {
                e = e12;
                Class<?> cls3 = cls;
                throw new IllegalStateException("Failed to create proxy for " + cls.getName(), e);
            }
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Instance {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class InvokerCreationAction implements PrivilegedAction<Invoker> {
        private InvokerCreationAction() {
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

        public Invoker run() {
            return DynamicClassLoader.a();
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsConstructor {
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsStatic {
    }

    @Documented
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Proxied {
        String value();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ProxiedInvocationHandler implements InvocationHandler {
        private static final Object[] NO_ARGUMENTS = new Object[0];

        /* renamed from: name  reason: collision with root package name */
        private final String f27512name;
        private final Map<Method, Dispatcher> targets;

        public ProxiedInvocationHandler(String str, Map<Method, Dispatcher> map) {
            this.f27512name = str;
            this.targets = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ProxiedInvocationHandler proxiedInvocationHandler = (ProxiedInvocationHandler) obj;
            return this.f27512name.equals(proxiedInvocationHandler.f27512name) && this.targets.equals(proxiedInvocationHandler.targets);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.f27512name.hashCode()) * 31) + this.targets.hashCode();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: boolean} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v1, types: [int] */
        /* JADX WARNING: type inference failed for: r1v5 */
        /* JADX WARNING: type inference failed for: r1v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(java.lang.Object r4, java.lang.reflect.Method r5, java.lang.Object[] r6) throws java.lang.Throwable {
            /*
                r3 = this;
                java.lang.Class r4 = r5.getDeclaringClass()
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                r1 = 0
                if (r4 != r0) goto L_0x0081
                java.lang.String r4 = r5.getName()
                java.lang.String r0 = "hashCode"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x001e
                int r4 = r3.hashCode()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                return r4
            L_0x001e:
                java.lang.String r4 = r5.getName()
                java.lang.String r0 = "equals"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x004a
                r4 = r6[r1]
                if (r4 == 0) goto L_0x0045
                java.lang.Class r4 = r4.getClass()
                boolean r4 = java.lang.reflect.Proxy.isProxyClass(r4)
                if (r4 == 0) goto L_0x0045
                r4 = r6[r1]
                java.lang.reflect.InvocationHandler r4 = java.lang.reflect.Proxy.getInvocationHandler(r4)
                boolean r4 = r4.equals(r3)
                if (r4 == 0) goto L_0x0045
                r1 = 1
            L_0x0045:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
                return r4
            L_0x004a:
                java.lang.String r4 = r5.getName()
                java.lang.String r6 = "toString"
                boolean r4 = r4.equals(r6)
                if (r4 == 0) goto L_0x006a
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Call proxy for "
                r4.append(r5)
                java.lang.String r5 = r3.f27512name
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                return r4
            L_0x006a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Unexpected object method: "
                r6.append(r0)
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                r4.<init>(r5)
                throw r4
            L_0x0081:
                java.util.Map<java.lang.reflect.Method, net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher> r4 = r3.targets
                java.lang.Object r4 = r4.get(r5)
                net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r4 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher) r4
                if (r4 == 0) goto L_0x0094
                if (r6 != 0) goto L_0x008f
                java.lang.Object[] r6 = NO_ARGUMENTS     // Catch:{ InvocationTargetException -> 0x00af }
            L_0x008f:
                java.lang.Object r4 = r4.invoke(r6)     // Catch:{ InvocationTargetException -> 0x00af }
                return r4
            L_0x0094:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ InvocationTargetException -> 0x00af }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InvocationTargetException -> 0x00af }
                r6.<init>()     // Catch:{ InvocationTargetException -> 0x00af }
                java.lang.String r0 = "No proxy target found for "
                r6.append(r0)     // Catch:{ InvocationTargetException -> 0x00af }
                r6.append(r5)     // Catch:{ InvocationTargetException -> 0x00af }
                java.lang.String r6 = r6.toString()     // Catch:{ InvocationTargetException -> 0x00af }
                r4.<init>(r6)     // Catch:{ InvocationTargetException -> 0x00af }
                throw r4     // Catch:{ InvocationTargetException -> 0x00af }
            L_0x00ab:
                r4 = move-exception
                goto L_0x00b5
            L_0x00ad:
                r4 = move-exception
                goto L_0x00df
            L_0x00af:
                r4 = move-exception
                java.lang.Throwable r4 = r4.getTargetException()     // Catch:{ RuntimeException -> 0x00ad, all -> 0x00ab }
                throw r4     // Catch:{ RuntimeException -> 0x00ad, all -> 0x00ab }
            L_0x00b5:
                java.lang.Class[] r6 = r5.getExceptionTypes()
                int r0 = r6.length
            L_0x00ba:
                if (r1 >= r0) goto L_0x00c8
                r2 = r6[r1]
                boolean r2 = r2.isInstance(r4)
                if (r2 != 0) goto L_0x00c7
                int r1 = r1 + 1
                goto L_0x00ba
            L_0x00c7:
                throw r4
            L_0x00c8:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Failed to invoke proxy for "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                r6.<init>(r5, r4)
                throw r6
            L_0x00df:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.ProxiedInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
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

    public JavaDispatcher(Class<T> cls, ClassLoader classLoader2, boolean z11) {
        this.proxy = cls;
        this.classLoader = classLoader2;
        this.generate = z11;
    }

    public static <T> PrivilegedAction<T> c(Class<T> cls, ClassLoader classLoader2) {
        return d(cls, classLoader2, GENERATE);
    }

    public static <T> PrivilegedAction<T> d(Class<T> cls, ClassLoader classLoader2, boolean z11) {
        if (cls.isInterface()) {
            Class<Proxied> cls2 = Proxied.class;
            if (!cls.isAnnotationPresent(cls2)) {
                throw new IllegalArgumentException("Expected " + cls.getName() + " to be annotated with " + cls2.getName());
            } else if (!((Proxied) cls.getAnnotation(cls2)).value().startsWith("java.security.")) {
                return new JavaDispatcher(cls, classLoader2, z11);
            } else {
                throw new IllegalArgumentException("Classes related to Java security cannot be proxied: " + cls.getName());
            }
        } else {
            throw new IllegalArgumentException("Expected an interface instead of " + cls);
        }
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        if (ACCESS_CONTROLLER) {
            return AccessController.doPrivileged(privilegedAction);
        }
        return privilegedAction.run();
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls) {
        return c(cls, (ClassLoader) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039 A[RETURN] */
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
            boolean r2 = r4.generate
            net.bytebuddy.utility.dispatcher.JavaDispatcher r5 = (net.bytebuddy.utility.dispatcher.JavaDispatcher) r5
            boolean r3 = r5.generate
            if (r2 == r3) goto L_0x001c
            return r1
        L_0x001c:
            java.lang.Class<T> r2 = r4.proxy
            java.lang.Class<T> r3 = r5.proxy
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0027
            return r1
        L_0x0027:
            java.lang.ClassLoader r2 = r4.classLoader
            java.lang.ClassLoader r5 = r5.classLoader
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
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = ((getClass().hashCode() * 31) + this.proxy.hashCode()) * 31;
        ClassLoader classLoader2 = this.classLoader;
        if (classLoader2 != null) {
            hashCode += classLoader2.hashCode();
        }
        return (hashCode * 31) + (this.generate ? 1 : 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0282, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0289, code lost:
        if (r4[r14].isArray() == false) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x028b, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        r4[r14] = r4[r14].getComponentType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0296, code lost:
        r27 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x029c, code lost:
        if (r5 <= 0) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a4, code lost:
        if (r4[r14].isPrimitive() != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02a6, code lost:
        r25 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ae, code lost:
        r28 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02b4, code lost:
        r29 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02b8, code lost:
        r30 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02c3, code lost:
        if (r4[r14].isAssignableFrom(java.lang.Class.forName(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2).value(), false, r1.classLoader)) == false) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02c5, code lost:
        r5 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02ca, code lost:
        r6 = r25 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02cc, code lost:
        if (r25 <= 0) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02ce, code lost:
        r5.append('[');
        r25 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02d6, code lost:
        r5.append('L');
        r5.append(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2).value());
        r5.append(net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        r4[r14] = java.lang.Class.forName(r5.toString(), false, r1.classLoader);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0320, code lost:
        throw new java.lang.IllegalStateException("Cannot resolve to component type: " + ((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2).value() + " at " + r14 + " of " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0321, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0324, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0327, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0329, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x032a, code lost:
        r29 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x032e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x032f, code lost:
        r29 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0333, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0334, code lost:
        r29 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0336, code lost:
        r2 = r0;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x033a, code lost:
        r30 = r6;
        r29 = r10;
        r28 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x035c, code lost:
        throw new java.lang.IllegalStateException("Primitive values are not supposed to be proxied: " + r14 + " of " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x035d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0360, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0363, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0366, code lost:
        r30 = r6;
        r29 = r10;
        r28 = r11;
        r2 = java.lang.Class.forName(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2).value(), false, r1.classLoader);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x037f, code lost:
        if (r4[r14].isAssignableFrom(r2) == false) goto L_0x0384;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0381, code lost:
        r4[r14] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03aa, code lost:
        throw new java.lang.IllegalStateException("Cannot resolve to type: " + r2.getName() + " at " + r14 + " of " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0455, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0456, code lost:
        r2 = r0;
        r14 = r22;
        r4 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x045d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x045e, code lost:
        r2 = r0;
        r14 = r22;
        r4 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0465, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0466, code lost:
        r2 = r0;
        r14 = r22;
        r3 = r28;
        r4 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x05cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x05ce, code lost:
        r20 = r2;
        r19 = r3;
        r21 = r5;
        r4 = r6;
        r27 = r7;
        r29 = r10;
        r22 = r14;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x05df, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x05e0, code lost:
        r20 = r2;
        r19 = r3;
        r21 = r5;
        r4 = r6;
        r27 = r7;
        r29 = r10;
        r28 = r11;
        r22 = r14;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0611, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0612, code lost:
        r20 = r2;
        r19 = r3;
        r21 = r5;
        r4 = r6;
        r27 = r7;
        r29 = r10;
        r28 = r11;
        r22 = r14;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x062d, code lost:
        r5 = new net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForUnresolvedMethod("Method not available on current VM: " + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0648, code lost:
        r5 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.a(r8.getReturnType());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x066d, code lost:
        r5 = new net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForUnresolvedMethod("Class not available on current VM: " + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0688, code lost:
        r5 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.a(r8.getReturnType());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0404 A[SYNTHETIC, Splitter:B:189:0x0404] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x046f A[SYNTHETIC, Splitter:B:206:0x046f] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x050c  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x053a A[Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x05df A[ExcHandler: all (r0v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:59:0x0190] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0611 A[ExcHandler: NoSuchMethodException (r0v2 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE]), Splitter:B:59:0x0190] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x062d  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0648  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0688  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T run() {
        /*
            r31 = this;
            r1 = r31
            java.lang.String r2 = "Instance check requires a boolean return type: "
            java.lang.String r3 = "Instance check requires a single regular-typed argument: "
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Instance> r4 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Instance.class
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$IsStatic> r6 = net.bytebuddy.utility.dispatcher.JavaDispatcher.IsStatic.class
            r7 = 1
            r8 = 0
            java.lang.Class<java.lang.System> r9 = java.lang.System.class
            java.lang.String r10 = "getSecurityManager"
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.reflect.Method r9 = r9.getMethod(r10, r11)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            r11 = 0
            java.lang.Object r9 = r9.invoke(r11, r10)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            if (r9 == 0) goto L_0x0061
            java.lang.String r10 = "java.lang.SecurityManager"
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.String r11 = "checkPermission"
            java.lang.Class[] r12 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.Class<java.security.Permission> r13 = java.security.Permission.class
            r12[r8] = r13     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.reflect.Method r10 = r10.getMethod(r11, r12)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.RuntimePermission r12 = new java.lang.RuntimePermission     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            java.lang.String r13 = "net.bytebuddy.createJavaDispatcher"
            r12.<init>(r13)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            r11[r8] = r12     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            r10.invoke(r9, r11)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0061, InvocationTargetException -> 0x004c, IllegalAccessException -> 0x0042 }
            goto L_0x0061
        L_0x0042:
            r0 = move-exception
            r2 = r0
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Failed to access security manager"
            r3.<init>(r4, r2)
            throw r3
        L_0x004c:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r2 = r2.getTargetException()
            boolean r3 = r2 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0059
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2
            throw r2
        L_0x0059:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Failed to assert access rights using security manager"
            r3.<init>(r4, r2)
            throw r3
        L_0x0061:
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.Class<T> r10 = r1.proxy
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Defaults> r11 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Defaults.class
            boolean r10 = r10.isAnnotationPresent(r11)
            java.lang.Class<T> r12 = r1.proxy
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied> r13 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied.class
            java.lang.annotation.Annotation r12 = r12.getAnnotation(r13)
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r12 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r12
            java.lang.String r12 = r12.value()
            java.lang.ClassLoader r14 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x06ce }
            java.lang.Class r12 = java.lang.Class.forName(r12, r8, r14)     // Catch:{ ClassNotFoundException -> 0x06ce }
            boolean r14 = r1.generate
            java.lang.Class<T> r15 = r1.proxy
            java.lang.reflect.Method[] r15 = r15.getMethods()
            int r8 = r15.length
            r7 = 0
        L_0x008c:
            if (r7 >= r8) goto L_0x06a7
            r16 = r8
            r8 = r15[r7]
            r17 = r15
            java.lang.Class r15 = r8.getDeclaringClass()
            if (r15 != r5) goto L_0x009e
            r18 = r4
            goto L_0x0133
        L_0x009e:
            boolean r15 = r8.isAnnotationPresent(r4)
            if (r15 == 0) goto L_0x00f6
            java.lang.Class[] r15 = r8.getParameterTypes()
            int r15 = r15.length
            r18 = r4
            r4 = 1
            if (r15 != r4) goto L_0x00e1
            java.lang.Class[] r4 = r8.getParameterTypes()
            r15 = 0
            r4 = r4[r15]
            boolean r4 = r4.isAssignableFrom(r12)
            if (r4 == 0) goto L_0x00e1
            java.lang.Class r4 = r8.getReturnType()
            java.lang.Class r15 = java.lang.Boolean.TYPE
            if (r4 != r15) goto L_0x00cc
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForInstanceCheck r4 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForInstanceCheck
            r4.<init>(r12)
            r9.put(r8, r4)
            goto L_0x0133
        L_0x00cc:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r8)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x00e1:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r8)
            java.lang.String r3 = r4.toString()
            r2.<init>(r3)
            throw r2
        L_0x00f6:
            r18 = r4
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$Container> r4 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Container.class
            boolean r4 = r8.isAnnotationPresent(r4)
            if (r4 == 0) goto L_0x016f
            java.lang.Class[] r4 = r8.getParameterTypes()
            int r4 = r4.length
            r15 = 1
            if (r4 != r15) goto L_0x0158
            java.lang.Class[] r4 = r8.getParameterTypes()
            r15 = 0
            r4 = r4[r15]
            java.lang.Class r15 = java.lang.Integer.TYPE
            if (r4 != r15) goto L_0x0158
            java.lang.Class r4 = r8.getReturnType()
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L_0x0141
            java.lang.Class r4 = r8.getReturnType()
            java.lang.Class r4 = r4.getComponentType()
            boolean r4 = r4.isAssignableFrom(r12)
            if (r4 == 0) goto L_0x0141
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForContainerCreation r4 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForContainerCreation
            r4.<init>(r12)
            r9.put(r8, r4)
        L_0x0133:
            r20 = r2
            r19 = r3
            r21 = r5
            r4 = r6
            r27 = r7
            r29 = r10
            r3 = r11
            goto L_0x0693
        L_0x0141:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Container creation requires an assignable array as return value: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0158:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Container creation requires a single int-typed argument: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x016f:
            java.lang.String r4 = r12.getName()
            java.lang.String r15 = "java.lang.invoke.MethodHandles"
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x0190
            java.lang.String r4 = r8.getName()
            java.lang.String r15 = "lookup"
            boolean r4 = r4.equals(r15)
            if (r4 != 0) goto L_0x0188
            goto L_0x0190
        L_0x0188:
            java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
            java.lang.String r3 = "Cannot resolve Byte Buddy lookup via dispatcher"
            r2.<init>(r3)
            throw r2
        L_0x0190:
            java.lang.Class[] r4 = r8.getParameterTypes()     // Catch:{ ClassNotFoundException -> 0x0654, NoSuchMethodException -> 0x0611, all -> 0x05df }
            boolean r15 = r8.isAnnotationPresent(r6)     // Catch:{ ClassNotFoundException -> 0x05cd, NoSuchMethodException -> 0x0611, all -> 0x05df }
            r19 = r3
            java.lang.Class<net.bytebuddy.utility.dispatcher.JavaDispatcher$IsConstructor> r3 = net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor.class
            if (r15 != 0) goto L_0x025d
            boolean r15 = r8.isAnnotationPresent(r3)     // Catch:{ ClassNotFoundException -> 0x024e, NoSuchMethodException -> 0x023d, all -> 0x022c }
            if (r15 == 0) goto L_0x01a6
            goto L_0x025d
        L_0x01a6:
            int r15 = r4.length     // Catch:{ ClassNotFoundException -> 0x024e, NoSuchMethodException -> 0x023d, all -> 0x022c }
            if (r15 == 0) goto L_0x01f0
            r20 = r2
            r15 = 0
            r2 = r4[r15]     // Catch:{ ClassNotFoundException -> 0x01ed, NoSuchMethodException -> 0x01eb, all -> 0x01e9 }
            boolean r2 = r2.isAssignableFrom(r12)     // Catch:{ ClassNotFoundException -> 0x01ed, NoSuchMethodException -> 0x01eb, all -> 0x01e9 }
            if (r2 == 0) goto L_0x01c6
            int r2 = r4.length     // Catch:{ ClassNotFoundException -> 0x01ed, NoSuchMethodException -> 0x01eb, all -> 0x01e9 }
            r15 = 1
            int r2 = r2 - r15
            java.lang.Class[] r15 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x01ed, NoSuchMethodException -> 0x01eb, all -> 0x01e9 }
            r21 = r5
            r22 = r14
            r5 = 1
            r14 = 0
            java.lang.System.arraycopy(r4, r5, r15, r14, r2)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r4 = r15
            r2 = 1
            goto L_0x0264
        L_0x01c6:
            r21 = r5
            r22 = r14
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.String r4 = "Cannot assign self type: "
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r3.append(r12)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.String r4 = " on "
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r3.append(r8)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.String r3 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
        L_0x01e9:
            r0 = move-exception
            goto L_0x022f
        L_0x01eb:
            r0 = move-exception
            goto L_0x0240
        L_0x01ed:
            r0 = move-exception
            goto L_0x0251
        L_0x01f0:
            r20 = r2
            r21 = r5
            r22 = r14
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.String r4 = "Expected self type: "
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r3.append(r8)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.String r3 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
        L_0x020d:
            r0 = move-exception
            r2 = r0
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            goto L_0x05b1
        L_0x0218:
            r0 = move-exception
            r2 = r0
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            goto L_0x05bd
        L_0x0223:
            r0 = move-exception
            r2 = r0
            r4 = r6
            r27 = r7
            r29 = r10
            goto L_0x05c8
        L_0x022c:
            r0 = move-exception
            r20 = r2
        L_0x022f:
            r21 = r5
            r22 = r14
            r2 = r0
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            goto L_0x05f0
        L_0x023d:
            r0 = move-exception
            r20 = r2
        L_0x0240:
            r21 = r5
            r22 = r14
            r2 = r0
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            goto L_0x0622
        L_0x024e:
            r0 = move-exception
            r20 = r2
        L_0x0251:
            r21 = r5
            r22 = r14
            r2 = r0
            r4 = r6
            r27 = r7
            r29 = r10
            goto L_0x05dc
        L_0x025d:
            r20 = r2
            r21 = r5
            r22 = r14
            r2 = 0
        L_0x0264:
            java.lang.annotation.Annotation[][] r5 = r8.getParameterAnnotations()     // Catch:{ ClassNotFoundException -> 0x05c1, NoSuchMethodException -> 0x05b4, all -> 0x05a8 }
            r14 = 0
        L_0x0269:
            int r15 = r4.length     // Catch:{ ClassNotFoundException -> 0x05c1, NoSuchMethodException -> 0x05b4, all -> 0x05a8 }
            if (r14 >= r15) goto L_0x03f2
            int r15 = r14 + r2
            r15 = r5[r15]     // Catch:{ ClassNotFoundException -> 0x03e9, NoSuchMethodException -> 0x03de, all -> 0x03d3 }
            r23 = r2
            int r2 = r15.length     // Catch:{ ClassNotFoundException -> 0x03e9, NoSuchMethodException -> 0x03de, all -> 0x03d3 }
            r24 = r5
            r5 = 0
        L_0x0276:
            if (r5 >= r2) goto L_0x03bb
            r25 = r2
            r2 = r15[r5]     // Catch:{ ClassNotFoundException -> 0x03e9, NoSuchMethodException -> 0x03de, all -> 0x03d3 }
            r26 = r15
            boolean r15 = r2 instanceof net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied     // Catch:{ ClassNotFoundException -> 0x03e9, NoSuchMethodException -> 0x03de, all -> 0x03d3 }
            if (r15 == 0) goto L_0x03ab
            r5 = 0
        L_0x0283:
            r15 = r4[r14]     // Catch:{ ClassNotFoundException -> 0x03e9, NoSuchMethodException -> 0x03de, all -> 0x03d3 }
            boolean r15 = r15.isArray()     // Catch:{ ClassNotFoundException -> 0x03e9, NoSuchMethodException -> 0x03de, all -> 0x03d3 }
            if (r15 == 0) goto L_0x0296
            int r5 = r5 + 1
            r15 = r4[r14]     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            java.lang.Class r15 = r15.getComponentType()     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            r4[r14] = r15     // Catch:{ ClassNotFoundException -> 0x0223, NoSuchMethodException -> 0x0218, all -> 0x020d }
            goto L_0x0283
        L_0x0296:
            java.lang.String r15 = " at "
            r27 = r7
            java.lang.String r7 = " of "
            if (r5 <= 0) goto L_0x0366
            r25 = r4[r14]     // Catch:{ ClassNotFoundException -> 0x0363, NoSuchMethodException -> 0x0360, all -> 0x035d }
            boolean r25 = r25.isPrimitive()     // Catch:{ ClassNotFoundException -> 0x0363, NoSuchMethodException -> 0x0360, all -> 0x035d }
            if (r25 != 0) goto L_0x033a
            r25 = r5
            r5 = r4[r14]     // Catch:{ ClassNotFoundException -> 0x0363, NoSuchMethodException -> 0x0360, all -> 0x035d }
            r26 = r2
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r26 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r26     // Catch:{ ClassNotFoundException -> 0x0363, NoSuchMethodException -> 0x0360, all -> 0x035d }
            r28 = r11
            java.lang.String r11 = r26.value()     // Catch:{ ClassNotFoundException -> 0x0333, NoSuchMethodException -> 0x032e, all -> 0x0329 }
            r29 = r10
            java.lang.ClassLoader r10 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x0327, NoSuchMethodException -> 0x0324, all -> 0x0321 }
            r30 = r6
            r6 = 0
            java.lang.Class r10 = java.lang.Class.forName(r11, r6, r10)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            boolean r5 = r5.isAssignableFrom(r10)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            if (r5 == 0) goto L_0x02f8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
        L_0x02ca:
            int r6 = r25 + -1
            if (r25 <= 0) goto L_0x02d6
            r7 = 91
            r5.append(r7)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r25 = r6
            goto L_0x02ca
        L_0x02d6:
            r6 = 76
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r2 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r2.value()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r5.append(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r2 = 59
            r5.append(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.ClassLoader r5 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r6 = 0
            java.lang.Class r2 = java.lang.Class.forName(r2, r6, r5)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4[r14] = r2     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            goto L_0x03c3
        L_0x02f8:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r5 = "Cannot resolve to component type: "
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r2 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r2.value()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r15)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r14)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r7)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r8)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
        L_0x0321:
            r0 = move-exception
            goto L_0x03da
        L_0x0324:
            r0 = move-exception
            goto L_0x03e5
        L_0x0327:
            r0 = move-exception
            goto L_0x0336
        L_0x0329:
            r0 = move-exception
            r29 = r10
            goto L_0x03da
        L_0x032e:
            r0 = move-exception
            r29 = r10
            goto L_0x03e5
        L_0x0333:
            r0 = move-exception
            r29 = r10
        L_0x0336:
            r2 = r0
            r4 = r6
            goto L_0x05a2
        L_0x033a:
            r30 = r6
            r29 = r10
            r28 = r11
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r4 = "Primitive values are not supposed to be proxied: "
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.append(r14)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.append(r7)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.append(r8)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r3 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
        L_0x035d:
            r0 = move-exception
            goto L_0x03d6
        L_0x0360:
            r0 = move-exception
            goto L_0x03e1
        L_0x0363:
            r0 = move-exception
            goto L_0x03ec
        L_0x0366:
            r30 = r6
            r29 = r10
            r28 = r11
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r2 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r2.value()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.ClassLoader r5 = r1.classLoader     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r6 = 0
            java.lang.Class r2 = java.lang.Class.forName(r2, r6, r5)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r5 = r4[r14]     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            boolean r5 = r5.isAssignableFrom(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            if (r5 == 0) goto L_0x0384
            r4[r14] = r2     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            goto L_0x03c3
        L_0x0384:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r5 = "Cannot resolve to type: "
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r15)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r14)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r7)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.append(r8)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
        L_0x03ab:
            r30 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            int r5 = r5 + 1
            r2 = r25
            r15 = r26
            goto L_0x0276
        L_0x03bb:
            r30 = r6
            r27 = r7
            r29 = r10
            r28 = r11
        L_0x03c3:
            int r14 = r14 + 1
            r2 = r23
            r5 = r24
            r7 = r27
            r11 = r28
            r10 = r29
            r6 = r30
            goto L_0x0269
        L_0x03d3:
            r0 = move-exception
            r27 = r7
        L_0x03d6:
            r29 = r10
            r28 = r11
        L_0x03da:
            r2 = r0
            r4 = r6
            goto L_0x05b1
        L_0x03de:
            r0 = move-exception
            r27 = r7
        L_0x03e1:
            r29 = r10
            r28 = r11
        L_0x03e5:
            r2 = r0
            r4 = r6
            goto L_0x05bd
        L_0x03e9:
            r0 = move-exception
            r27 = r7
        L_0x03ec:
            r29 = r10
            r2 = r0
            r4 = r6
            goto L_0x05c8
        L_0x03f2:
            r30 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            boolean r2 = r8.isAnnotationPresent(r3)     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            java.lang.String r3 = " to "
            java.lang.String r5 = "Cannot assign "
            if (r2 == 0) goto L_0x046f
            java.lang.reflect.Constructor r2 = r12.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.Class r4 = r8.getReturnType()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            boolean r4 = r4.isAssignableFrom(r12)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            if (r4 == 0) goto L_0x0432
            int r3 = r2.getModifiers()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0421
            int r3 = r12.getModifiers()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3 = r3 & r4
            if (r3 != 0) goto L_0x0426
        L_0x0421:
            r2.setAccessible(r4)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r22 = 0
        L_0x0426:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForConstructor r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForConstructor     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r9.put(r8, r3)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4 = r30
            goto L_0x054a
        L_0x0432:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r6.append(r5)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.Class r2 = r2.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r6.append(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r6.append(r3)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r6.append(r8)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r2 = r6.toString()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r4.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            throw r4     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
        L_0x0455:
            r0 = move-exception
            r2 = r0
            r14 = r22
            r4 = r30
            goto L_0x05f0
        L_0x045d:
            r0 = move-exception
            r2 = r0
            r14 = r22
            r4 = r30
            goto L_0x0622
        L_0x0465:
            r0 = move-exception
            r2 = r0
            r14 = r22
            r3 = r28
            r4 = r30
            goto L_0x0664
        L_0x046f:
            java.lang.annotation.Annotation r2 = r8.getAnnotation(r13)     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Proxied r2 = (net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r2     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            if (r2 != 0) goto L_0x047c
            java.lang.String r2 = r8.getName()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            goto L_0x0480
        L_0x047c:
            java.lang.String r2 = r2.value()     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
        L_0x0480:
            java.lang.reflect.Method r2 = r12.getMethod(r2, r4)     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            java.lang.Class r4 = r8.getReturnType()     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            java.lang.Class r6 = r2.getReturnType()     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            boolean r4 = r4.isAssignableFrom(r6)     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            if (r4 == 0) goto L_0x056b
            java.lang.Class[] r3 = r2.getExceptionTypes()     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            int r4 = r3.length     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            r5 = 0
        L_0x0498:
            java.lang.String r6 = "Resolved method for "
            if (r5 >= r4) goto L_0x04e7
            r7 = r3[r5]     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.Class<java.lang.RuntimeException> r10 = java.lang.RuntimeException.class
            boolean r10 = r10.isAssignableFrom(r7)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            if (r10 != 0) goto L_0x04e4
            java.lang.Class<java.lang.Error> r10 = java.lang.Error.class
            boolean r10 = r10.isAssignableFrom(r7)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            if (r10 == 0) goto L_0x04af
            goto L_0x04e4
        L_0x04af:
            java.lang.Class[] r10 = r8.getExceptionTypes()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            int r11 = r10.length     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r14 = 0
        L_0x04b5:
            if (r14 >= r11) goto L_0x04c3
            r15 = r10[r14]     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            boolean r15 = r15.isAssignableFrom(r7)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            if (r15 == 0) goto L_0x04c0
            goto L_0x04e4
        L_0x04c0:
            int r14 = r14 + 1
            goto L_0x04b5
        L_0x04c3:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.append(r6)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.append(r8)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r4 = " throws undeclared checked exception "
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r4 = r7.getName()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            java.lang.String r3 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r2.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
        L_0x04e4:
            int r5 = r5 + 1
            goto L_0x0498
        L_0x04e7:
            int r3 = r2.getModifiers()     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x04fc
            java.lang.Class r3 = r2.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            int r3 = r3.getModifiers()     // Catch:{ ClassNotFoundException -> 0x0465, NoSuchMethodException -> 0x045d, all -> 0x0455 }
            r3 = r3 & r4
            if (r3 != 0) goto L_0x0502
            r3 = 1
            goto L_0x04fd
        L_0x04fc:
            r3 = r4
        L_0x04fd:
            r2.setAccessible(r3)     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            r22 = 0
        L_0x0502:
            int r3 = r2.getModifiers()     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch:{ ClassNotFoundException -> 0x059e, NoSuchMethodException -> 0x059a, all -> 0x0596 }
            if (r3 == 0) goto L_0x053a
            r4 = r30
            boolean r3 = r8.isAnnotationPresent(r4)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            if (r3 == 0) goto L_0x051d
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForStaticMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForStaticMethod     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r9.put(r8, r3)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            goto L_0x054a
        L_0x051d:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.append(r8)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.String r6 = " was expected to be static: "
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.append(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
        L_0x053a:
            r4 = r30
            boolean r3 = r8.isAnnotationPresent(r4)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            if (r3 != 0) goto L_0x054e
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForNonStaticMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForNonStaticMethod     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r9.put(r8, r3)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
        L_0x054a:
            r14 = r22
            goto L_0x060d
        L_0x054e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.append(r8)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.String r6 = " was expected to be virtual: "
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r5.append(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
        L_0x056b:
            r4 = r30
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r7.<init>()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r7.append(r5)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r7.append(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r7.append(r3)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r7.append(r8)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            java.lang.String r2 = r7.toString()     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            r6.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
            throw r6     // Catch:{ ClassNotFoundException -> 0x0594, NoSuchMethodException -> 0x0592, all -> 0x0590 }
        L_0x0590:
            r0 = move-exception
            goto L_0x05b0
        L_0x0592:
            r0 = move-exception
            goto L_0x05bc
        L_0x0594:
            r0 = move-exception
            goto L_0x05a1
        L_0x0596:
            r0 = move-exception
            r4 = r30
            goto L_0x05b0
        L_0x059a:
            r0 = move-exception
            r4 = r30
            goto L_0x05bc
        L_0x059e:
            r0 = move-exception
            r4 = r30
        L_0x05a1:
            r2 = r0
        L_0x05a2:
            r14 = r22
            r3 = r28
            goto L_0x0664
        L_0x05a8:
            r0 = move-exception
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
        L_0x05b0:
            r2 = r0
        L_0x05b1:
            r14 = r22
            goto L_0x05f0
        L_0x05b4:
            r0 = move-exception
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
        L_0x05bc:
            r2 = r0
        L_0x05bd:
            r14 = r22
            goto L_0x0622
        L_0x05c1:
            r0 = move-exception
            r4 = r6
            r27 = r7
            r29 = r10
            r2 = r0
        L_0x05c8:
            r3 = r11
            r14 = r22
            goto L_0x0664
        L_0x05cd:
            r0 = move-exception
            r20 = r2
            r19 = r3
            r21 = r5
            r4 = r6
            r27 = r7
            r29 = r10
            r22 = r14
            r2 = r0
        L_0x05dc:
            r3 = r11
            goto L_0x0664
        L_0x05df:
            r0 = move-exception
            r20 = r2
            r19 = r3
            r21 = r5
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            r22 = r14
            r2 = r0
        L_0x05f0:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r3 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unexpected error: "
            r5.append(r6)
            java.lang.String r2 = r2.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r3.<init>(r2)
            r9.put(r8, r3)
        L_0x060d:
            r3 = r28
            goto L_0x0693
        L_0x0611:
            r0 = move-exception
            r20 = r2
            r19 = r3
            r21 = r5
            r4 = r6
            r27 = r7
            r29 = r10
            r28 = r11
            r22 = r14
            r2 = r0
        L_0x0622:
            r3 = r28
            if (r29 != 0) goto L_0x0648
            boolean r5 = r8.isAnnotationPresent(r3)
            if (r5 == 0) goto L_0x062d
            goto L_0x0648
        L_0x062d:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r5 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Method not available on current VM: "
            r6.append(r7)
            java.lang.String r2 = r2.getMessage()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r5.<init>(r2)
            goto L_0x0650
        L_0x0648:
            java.lang.Class r2 = r8.getReturnType()
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r5 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.a(r2)
        L_0x0650:
            r9.put(r8, r5)
            goto L_0x0693
        L_0x0654:
            r0 = move-exception
            r20 = r2
            r19 = r3
            r21 = r5
            r4 = r6
            r27 = r7
            r29 = r10
            r3 = r11
            r22 = r14
            r2 = r0
        L_0x0664:
            if (r29 != 0) goto L_0x0688
            boolean r5 = r8.isAnnotationPresent(r3)
            if (r5 == 0) goto L_0x066d
            goto L_0x0688
        L_0x066d:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r5 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Class not available on current VM: "
            r6.append(r7)
            java.lang.String r2 = r2.getMessage()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r5.<init>(r2)
            goto L_0x0690
        L_0x0688:
            java.lang.Class r2 = r8.getReturnType()
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r5 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.a(r2)
        L_0x0690:
            r9.put(r8, r5)
        L_0x0693:
            int r7 = r27 + 1
            r11 = r3
            r6 = r4
            r8 = r16
            r15 = r17
            r4 = r18
            r3 = r19
            r2 = r20
            r5 = r21
            r10 = r29
            goto L_0x008c
        L_0x06a7:
            r22 = r14
            if (r22 == 0) goto L_0x06b2
            java.lang.Class<T> r2 = r1.proxy
            java.lang.Object r2 = net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.b(r2, r9)
            return r2
        L_0x06b2:
            java.lang.Class<T> r2 = r1.proxy
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]
            java.lang.Class<T> r4 = r1.proxy
            r5 = 0
            r3[r5] = r4
            net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler r4 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler
            java.lang.String r5 = r12.getName()
            r4.<init>(r5, r9)
            java.lang.Object r2 = java.lang.reflect.Proxy.newProxyInstance(r2, r3, r4)
            return r2
        L_0x06ce:
            r0 = move-exception
            r20 = r2
            r19 = r3
            r18 = r4
            r21 = r5
            r29 = r10
            r3 = r11
            r2 = r0
            java.lang.Class<T> r4 = r1.proxy
            java.lang.reflect.Method[] r4 = r4.getMethods()
            int r5 = r4.length
            r15 = 0
        L_0x06e3:
            if (r15 >= r5) goto L_0x07a5
            r6 = r4[r15]
            java.lang.Class r7 = r6.getDeclaringClass()
            r8 = r21
            if (r7 != r8) goto L_0x06f9
            r28 = r3
            r7 = r18
        L_0x06f3:
            r11 = r19
            r10 = r20
            goto L_0x0797
        L_0x06f9:
            r7 = r18
            boolean r10 = r6.isAnnotationPresent(r7)
            if (r10 == 0) goto L_0x0760
            java.lang.Class[] r10 = r6.getParameterTypes()
            int r10 = r10.length
            r11 = 1
            if (r10 != r11) goto L_0x0749
            java.lang.Class[] r10 = r6.getParameterTypes()
            r11 = 0
            r10 = r10[r11]
            boolean r10 = r10.isPrimitive()
            if (r10 != 0) goto L_0x0749
            java.lang.Class[] r10 = r6.getParameterTypes()
            r10 = r10[r11]
            boolean r10 = r10.isArray()
            if (r10 != 0) goto L_0x0749
            java.lang.Class r10 = r6.getReturnType()
            java.lang.Class r11 = java.lang.Boolean.TYPE
            if (r10 != r11) goto L_0x0732
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForDefaultValue r10 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.BOOLEAN
            r9.put(r6, r10)
            r28 = r3
            goto L_0x06f3
        L_0x0732:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r10 = r20
            r3.append(r10)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0749:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r11 = r19
            r3.append(r11)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0760:
            r11 = r19
            r10 = r20
            if (r29 != 0) goto L_0x078a
            boolean r13 = r6.isAnnotationPresent(r3)
            if (r13 == 0) goto L_0x076d
            goto L_0x078a
        L_0x076d:
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod r13 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher$ForUnresolvedMethod
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r28 = r3
            java.lang.String r3 = "Type not available on current VM: "
            r14.append(r3)
            java.lang.String r3 = r2.getMessage()
            r14.append(r3)
            java.lang.String r3 = r14.toString()
            r13.<init>(r3)
            goto L_0x0794
        L_0x078a:
            r28 = r3
            java.lang.Class r3 = r6.getReturnType()
            net.bytebuddy.utility.dispatcher.JavaDispatcher$Dispatcher r13 = net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher.ForDefaultValue.a(r3)
        L_0x0794:
            r9.put(r6, r13)
        L_0x0797:
            int r15 = r15 + 1
            r18 = r7
            r21 = r8
            r20 = r10
            r19 = r11
            r3 = r28
            goto L_0x06e3
        L_0x07a5:
            boolean r2 = r1.generate
            if (r2 == 0) goto L_0x07b0
            java.lang.Class<T> r2 = r1.proxy
            java.lang.Object r2 = net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.b(r2, r9)
            return r2
        L_0x07b0:
            java.lang.Class<T> r2 = r1.proxy
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]
            java.lang.Class<T> r4 = r1.proxy
            r5 = 0
            r3[r5] = r4
            net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler r4 = new net.bytebuddy.utility.dispatcher.JavaDispatcher$ProxiedInvocationHandler
            r4.<init>(r12, r9)
            java.lang.Object r2 = java.lang.reflect.Proxy.newProxyInstance(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.run():java.lang.Object");
    }
}
