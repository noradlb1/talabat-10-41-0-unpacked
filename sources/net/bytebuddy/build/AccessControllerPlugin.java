package net.bytebuddy.build;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;

@HashCodeAndEqualsPlugin.Enhance
public class AccessControllerPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String ACCESS_CONTROLLER = "java.security.AccessController";
    /* access modifiers changed from: private */
    public static final Object[] EMPTY = new Object[0];
    private static final String NAME = "ACCESS_CONTROLLER";
    /* access modifiers changed from: private */
    public static final Map<MethodDescription.SignatureToken, MethodDescription.SignatureToken> SIGNATURES;
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final String property;

    @HashCodeAndEqualsPlugin.Enhance
    public static class AccessControlWrapper implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {

        /* renamed from: name  reason: collision with root package name */
        private final String f27085name;

        public static class PrefixingMethodVisitor extends MethodVisitor {
            private final boolean frames;
            private final TypeDescription instrumentedType;

            /* renamed from: name  reason: collision with root package name */
            private final String f27086name;
            private final int offset;
            private final MethodDescription.SignatureToken token;

            public PrefixingMethodVisitor(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodDescription.SignatureToken signatureToken, String str, int i11, boolean z11) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.instrumentedType = typeDescription;
                this.token = signatureToken;
                this.f27086name = str;
                this.offset = i11;
                this.frames = z11;
            }

            public void visitCode() {
                this.f27400c.visitCode();
                this.f27400c.visitFieldInsn(Opcodes.GETSTATIC, this.instrumentedType.getInternalName(), this.f27086name, Type.getDescriptor(Boolean.TYPE));
                Label label = new Label();
                this.f27400c.visitJumpInsn(Opcodes.IFEQ, label);
                int i11 = this.offset;
                for (TypeDescription next : this.token.getParameterTypes()) {
                    this.f27400c.visitVarInsn(Type.getType(next.getDescriptor()).getOpcode(21), i11);
                    if (next.equals(JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub())) {
                        this.f27400c.visitTypeInsn(192, next.getInternalName());
                    }
                    i11 += next.getStackSize().getSize();
                }
                this.f27400c.visitMethodInsn(Opcodes.INVOKESTATIC, AccessControllerPlugin.ACCESS_CONTROLLER.replace('.', '/'), this.token.getName(), this.token.getDescriptor(), false);
                this.f27400c.visitInsn(Type.getType(this.token.getReturnType().getDescriptor()).getOpcode(172));
                this.f27400c.visitLabel(label);
                if (this.frames) {
                    this.f27400c.visitFrame(3, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY);
                }
            }

            public void visitMaxs(int i11, int i12) {
                this.f27400c.visitMaxs(Math.max(Math.max(StackSize.of((Collection<? extends TypeDefinition>) this.token.getParameterTypes()), this.token.getReturnType().getStackSize().getSize()), i11), i12);
            }
        }

        public AccessControlWrapper(String str) {
            this.f27085name = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f27085name.equals(((AccessControlWrapper) obj).f27085name);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.f27085name.hashCode();
        }

        public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i11, int i12) {
            boolean z11;
            MethodDescription.SignatureToken signatureToken = (MethodDescription.SignatureToken) AccessControllerPlugin.SIGNATURES.get(((MethodDescription.InDefinedShape) methodDescription.asDefined()).asSignatureToken());
            if (signatureToken == null) {
                throw new IllegalStateException(methodDescription + " does not have a method with a matching signature in " + AccessControllerPlugin.ACCESS_CONTROLLER);
            } else if (methodDescription.isPublic() || methodDescription.isProtected()) {
                throw new IllegalStateException(methodDescription + " is either public or protected what is not permitted to avoid context leaks");
            } else {
                String str = this.f27085name;
                boolean z12 = !methodDescription.isStatic();
                if ((i11 & 2) != 0 || !context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                return new PrefixingMethodVisitor(methodVisitor, typeDescription, signatureToken, str, z12 ? 1 : 0, z11);
            }
        }
    }

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class Initializer implements ByteCodeAppender {
        private final TypeDescription instrumentedType;

        /* renamed from: name  reason: collision with root package name */
        private final String f27087name;

        @HashCodeAndEqualsPlugin.Enhance
        public static class WithProperty extends Initializer {
            private final String property;

            public WithProperty(TypeDescription typeDescription, String str, String str2) {
                super(typeDescription, str);
                this.property = str2;
            }

            public int a(MethodVisitor methodVisitor) {
                methodVisitor.visitLdcInsn(this.property);
                methodVisitor.visitLdcInsn("true");
                Class<String> cls = String.class;
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(System.class), "getProperty", Type.getMethodDescriptor(Type.getType((Class<?>) cls), Type.getType((Class<?>) cls), Type.getType((Class<?>) cls)), false);
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(Boolean.class), "parseBoolean", Type.getMethodDescriptor(Type.getType((Class<?>) Boolean.TYPE), Type.getType((Class<?>) cls)), false);
                return 2;
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.property.equals(((WithProperty) obj).property);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.property.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class WithoutProperty extends Initializer {
            public WithoutProperty(TypeDescription typeDescription, String str) {
                super(typeDescription, str);
            }

            public int a(MethodVisitor methodVisitor) {
                methodVisitor.visitInsn(4);
                return 1;
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return super.hashCode();
            }
        }

        public Initializer(TypeDescription typeDescription, String str) {
            this.instrumentedType = typeDescription;
            this.f27087name = str;
        }

        public abstract int a(MethodVisitor methodVisitor);

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            int i11;
            int i12;
            int i13;
            MethodVisitor methodVisitor2 = methodVisitor;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            Class<ClassNotFoundException> cls = ClassNotFoundException.class;
            methodVisitor2.visitTryCatchBlock(label, label2, label3, Type.getInternalName(cls));
            Class<SecurityException> cls2 = SecurityException.class;
            methodVisitor2.visitTryCatchBlock(label, label2, label4, Type.getInternalName(cls2));
            methodVisitor2.visitLabel(label);
            methodVisitor2.visitLdcInsn(AccessControllerPlugin.ACCESS_CONTROLLER);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitInsn(1);
            Class<Class> cls3 = Class.class;
            String internalName = Type.getInternalName(cls3);
            Type type = Type.getType((Class<?>) cls3);
            Class cls4 = Boolean.TYPE;
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, internalName, "forName", Type.getMethodDescriptor(type, Type.getType((Class<?>) String.class), Type.getType((Class<?>) cls4), Type.getType((Class<?>) ClassLoader.class)), false);
            methodVisitor2.visitInsn(87);
            int a11 = a(methodVisitor);
            methodVisitor2.visitFieldInsn(Opcodes.PUTSTATIC, this.instrumentedType.getInternalName(), this.f27087name, Type.getDescriptor(cls4));
            methodVisitor2.visitLabel(label2);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
            methodVisitor2.visitLabel(label3);
            ClassFileVersion classFileVersion = context.getClassFileVersion();
            ClassFileVersion classFileVersion2 = ClassFileVersion.JAVA_V6;
            if (classFileVersion.isAtLeast(classFileVersion2)) {
                i13 = 179;
                i11 = a11;
                i12 = 87;
                methodVisitor.visitFrame(4, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, 1, new Object[]{Type.getInternalName(cls)});
            } else {
                i13 = 179;
                i11 = a11;
                i12 = 87;
            }
            methodVisitor2.visitInsn(i12);
            methodVisitor2.visitInsn(3);
            methodVisitor2.visitFieldInsn(i13, this.instrumentedType.getInternalName(), this.f27087name, Type.getDescriptor(cls4));
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label5);
            methodVisitor2.visitLabel(label4);
            if (context.getClassFileVersion().isAtLeast(classFileVersion2)) {
                methodVisitor.visitFrame(4, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, 1, new Object[]{Type.getInternalName(cls2)});
            }
            methodVisitor2.visitInsn(i12);
            methodVisitor2.visitInsn(4);
            methodVisitor2.visitFieldInsn(i13, this.instrumentedType.getInternalName(), this.f27087name, Type.getDescriptor(cls4));
            methodVisitor2.visitLabel(label5);
            if (context.getClassFileVersion().isAtLeast(classFileVersion2)) {
                methodVisitor.visitFrame(3, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY);
            }
            return new ByteCodeAppender.Size(Math.max(3, i11), 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Initializer initializer = (Initializer) obj;
            return this.f27087name.equals(initializer.f27087name) && this.instrumentedType.equals(initializer.instrumentedType);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.f27087name.hashCode();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        SIGNATURES = hashMap;
        TypeDescription typeDescription = TypeDescription.OBJECT;
        Class<PrivilegedAction> cls = PrivilegedAction.class;
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls)), new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls)));
        MethodDescription.SignatureToken signatureToken = new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls), typeDescription);
        JavaType javaType = JavaType.ACCESS_CONTROL_CONTEXT;
        hashMap.put(signatureToken, new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls), javaType.getTypeStub()));
        Class<Permission[]> cls2 = Permission[].class;
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls), typeDescription, TypeDescription.ForLoadedType.of(cls2)), new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(cls2)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls), typeDescription, TypeDescription.ForLoadedType.of(cls2)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(cls2)));
        Class<PrivilegedExceptionAction> cls3 = PrivilegedExceptionAction.class;
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls3)), new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls3)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls3)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls3)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls3), typeDescription), new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls3), javaType.getTypeStub()));
        hashMap.put(new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls3), typeDescription, TypeDescription.ForLoadedType.of(cls2)), new MethodDescription.SignatureToken("doPrivileged", typeDescription, TypeDescription.ForLoadedType.of(cls3), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(cls2)));
        hashMap.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls3), typeDescription, TypeDescription.ForLoadedType.of(cls2)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", typeDescription, TypeDescription.ForLoadedType.of(cls3), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(cls2)));
        hashMap.put(new MethodDescription.SignatureToken("getContext", typeDescription, new TypeDescription[0]), new MethodDescription.SignatureToken("getContext", javaType.getTypeStub(), new TypeDescription[0]));
        TypeDescription typeDescription2 = TypeDescription.VOID;
        Class<Permission> cls4 = Permission.class;
        hashMap.put(new MethodDescription.SignatureToken("checkPermission", typeDescription2, TypeDescription.ForLoadedType.of(cls4)), new MethodDescription.SignatureToken("checkPermission", typeDescription2, TypeDescription.ForLoadedType.of(cls4)));
    }

    public AccessControllerPlugin() {
        this((String) null);
    }

    @SuppressFBWarnings(justification = "Collision is unlikely and buffer overhead not justified", value = {"SBSC_USE_STRINGBUFFER_CONCATENATION"})
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        ByteCodeAppender byteCodeAppender;
        String str = NAME;
        while (!((FieldList) typeDescription.getDeclaredFields().filter(ElementMatchers.named(str))).isEmpty()) {
            str = str + "$";
        }
        DynamicType.Builder<T> visit = builder.defineField(str, (java.lang.reflect.Type) Boolean.TYPE, Visibility.PRIVATE, Ownership.STATIC, FieldManifestation.FINAL).visit(new AsmVisitorWrapper.ForDeclaredMethods().method((ElementMatcher<? super MethodDescription>) ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class), new AccessControlWrapper(str)));
        String str2 = this.property;
        if (str2 == null) {
            byteCodeAppender = new Initializer.WithoutProperty(typeDescription, str);
        } else {
            byteCodeAppender = new Initializer.WithProperty(typeDescription, str, str2);
        }
        return visit.initializer(byteCodeAppender);
    }

    public void close() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = super.equals(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = 1
            if (r4 != r5) goto L_0x000c
            return r0
        L_0x000c:
            if (r5 != 0) goto L_0x000f
            return r1
        L_0x000f:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x001a
            return r1
        L_0x001a:
            java.lang.String r2 = r4.property
            net.bytebuddy.build.AccessControllerPlugin r5 = (net.bytebuddy.build.AccessControllerPlugin) r5
            java.lang.String r5 = r5.property
            if (r5 == 0) goto L_0x002b
            if (r2 == 0) goto L_0x002d
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x002e
            return r1
        L_0x002b:
            if (r2 == 0) goto L_0x002e
        L_0x002d:
            return r1
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.build.AccessControllerPlugin.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.property;
        return str != null ? hashCode + str.hashCode() : hashCode;
    }

    public Plugin make() {
        return this;
    }

    @Plugin.Factory.UsingReflection.Priority(Integer.MAX_VALUE)
    public AccessControllerPlugin(String str) {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
        this.property = str;
    }
}
