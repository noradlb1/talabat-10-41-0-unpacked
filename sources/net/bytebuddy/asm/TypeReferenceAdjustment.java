package net.bytebuddy.asm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;

@HashCodeAndEqualsPlugin.Enhance
public class TypeReferenceAdjustment extends AsmVisitorWrapper.AbstractBase {
    private final ElementMatcher.Junction<? super TypeDescription> filter;
    private final boolean strict;

    public static class TypeReferenceClassVisitor extends ClassVisitor {
        /* access modifiers changed from: private */
        public static final AnnotationVisitor IGNORE_ANNOTATION = null;
        private static final FieldVisitor IGNORE_FIELD = null;
        private static final MethodVisitor IGNORE_METHOD = null;
        private final ElementMatcher<? super TypeDescription> filter;
        /* access modifiers changed from: private */
        public final Set<String> observedTypes = new HashSet();
        private final boolean strict;
        private final TypePool typePool;
        private final Set<String> visitedInnerTypes = new HashSet();

        public class TypeReferenceAnnotationVisitor extends AnnotationVisitor {
            public TypeReferenceAnnotationVisitor(AnnotationVisitor annotationVisitor) {
                super(OpenedClassReader.ASM_API, annotationVisitor);
            }

            public void visit(String str, Object obj) {
                TypeReferenceClassVisitor.this.c(obj);
                super.visit(str, obj);
            }

            public AnnotationVisitor visitAnnotation(String str, String str2) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str2).getInternalName());
                AnnotationVisitor visitAnnotation = super.visitAnnotation(str, str2);
                if (visitAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public AnnotationVisitor visitArray(String str) {
                AnnotationVisitor visitArray = super.visitArray(str);
                if (visitArray != null) {
                    return new TypeReferenceAnnotationVisitor(visitArray);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitEnum(String str, String str2, String str3) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str2).getInternalName());
                super.visitEnum(str, str2, str3);
            }
        }

        public class TypeReferenceFieldVisitor extends FieldVisitor {
            public TypeReferenceFieldVisitor(FieldVisitor fieldVisitor) {
                super(OpenedClassReader.ASM_API, fieldVisitor);
            }

            public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitAnnotation = super.visitAnnotation(str, z11);
                if (visitAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }
        }

        public class TypeReferenceMethodVisitor extends MethodVisitor {
            public TypeReferenceMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }

            public AnnotationVisitor visitAnnotation(String str, boolean z11) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitAnnotation = super.visitAnnotation(str, z11);
                if (visitAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public AnnotationVisitor visitAnnotationDefault() {
                AnnotationVisitor visitAnnotationDefault = super.visitAnnotationDefault();
                if (visitAnnotationDefault != null) {
                    return new TypeReferenceAnnotationVisitor(visitAnnotationDefault);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitFieldInsn(int i11, String str, String str2, String str3) {
                TypeReferenceClassVisitor.this.g(str);
                TypeReferenceClassVisitor.this.f(Type.getType(str3));
                super.visitFieldInsn(i11, str, str2, str3);
            }

            public AnnotationVisitor visitInsnAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitInsnAnnotation = super.visitInsnAnnotation(i11, typePath, str, z11);
                if (visitInsnAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitInsnAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
                TypeReferenceClassVisitor.this.f(Type.getType(str2));
                TypeReferenceClassVisitor.this.e(handle);
                for (Object c11 : objArr) {
                    TypeReferenceClassVisitor.this.c(c11);
                }
                super.visitInvokeDynamicInsn(str, str2, handle, objArr);
            }

            public void visitLdcInsn(Object obj) {
                TypeReferenceClassVisitor.this.c(obj);
                super.visitLdcInsn(obj);
            }

            public AnnotationVisitor visitLocalVariableAnnotation(int i11, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z11) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitLocalVariableAnnotation = super.visitLocalVariableAnnotation(i11, typePath, labelArr, labelArr2, iArr, str, z11);
                if (visitLocalVariableAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitLocalVariableAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitMethodInsn(int i11, String str, String str2, String str3, boolean z11) {
                TypeReferenceClassVisitor.this.g(str);
                TypeReferenceClassVisitor.this.f(Type.getType(str3));
                super.visitMethodInsn(i11, str, str2, str3, z11);
            }

            public void visitMultiANewArrayInsn(String str, int i11) {
                TypeReferenceClassVisitor.this.f(Type.getType(str));
                super.visitMultiANewArrayInsn(str, i11);
            }

            public AnnotationVisitor visitParameterAnnotation(int i11, String str, boolean z11) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitParameterAnnotation = super.visitParameterAnnotation(i11, str, z11);
                if (visitParameterAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitParameterAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public AnnotationVisitor visitTryCatchAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitTryCatchAnnotation = super.visitTryCatchAnnotation(i11, typePath, str, z11);
                if (visitTryCatchAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitTryCatchAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
                if (str != null) {
                    TypeReferenceClassVisitor.this.observedTypes.add(str);
                }
                super.visitTryCatchBlock(label, label2, label3, str);
            }

            public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
                TypeReferenceClassVisitor.this.observedTypes.add(Type.getType(str).getInternalName());
                AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i11, typePath, str, z11);
                if (visitTypeAnnotation != null) {
                    return new TypeReferenceAnnotationVisitor(visitTypeAnnotation);
                }
                return TypeReferenceClassVisitor.IGNORE_ANNOTATION;
            }

            public void visitTypeInsn(int i11, String str) {
                TypeReferenceClassVisitor.this.g(str);
                super.visitTypeInsn(i11, str);
            }
        }

        public TypeReferenceClassVisitor(ClassVisitor classVisitor, boolean z11, ElementMatcher<? super TypeDescription> elementMatcher, TypePool typePool2) {
            super(OpenedClassReader.ASM_API, classVisitor);
            this.typePool = typePool2;
            this.strict = z11;
            this.filter = elementMatcher;
        }

        public void c(Object obj) {
            if (obj instanceof Type) {
                f((Type) obj);
            } else if (obj instanceof Handle) {
                e((Handle) obj);
            } else if (obj instanceof ConstantDynamic) {
                d((ConstantDynamic) obj);
            }
        }

        public void d(ConstantDynamic constantDynamic) {
            Type type = Type.getType(constantDynamic.getDescriptor());
            f(type.getReturnType());
            for (Type f11 : type.getArgumentTypes()) {
                f(f11);
            }
            e(constantDynamic.getBootstrapMethod());
            for (int i11 = 0; i11 < constantDynamic.getBootstrapMethodArgumentCount(); i11++) {
                c(constantDynamic.getBootstrapMethodArgument(i11));
            }
        }

        public void e(Handle handle) {
            this.observedTypes.add(handle.getOwner());
            Type type = Type.getType(handle.getDesc());
            f(type.getReturnType());
            for (Type f11 : type.getArgumentTypes()) {
                f(f11);
            }
        }

        public void f(Type type) {
            if (type.getSort() == 11) {
                f(type.getReturnType());
                for (Type f11 : type.getArgumentTypes()) {
                    f(f11);
                }
                return;
            }
            while (type.getSort() == 9) {
                type = type.getElementType();
            }
            if (type.getSort() == 10) {
                this.observedTypes.add(type.getInternalName());
            }
        }

        public void g(String str) {
            while (str.startsWith("[")) {
                str = str.substring(1);
            }
            this.observedTypes.add(str);
        }

        public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
            if (str3 != null) {
                this.observedTypes.add(str3);
            }
            if (strArr != null) {
                this.observedTypes.addAll(Arrays.asList(strArr));
            }
            super.visit(i11, i12, str, str2, str3, strArr);
        }

        public AnnotationVisitor visitAnnotation(String str, boolean z11) {
            this.observedTypes.add(Type.getType(str).getInternalName());
            AnnotationVisitor visitAnnotation = super.visitAnnotation(str, z11);
            if (visitAnnotation != null) {
                return new TypeReferenceAnnotationVisitor(visitAnnotation);
            }
            return IGNORE_ANNOTATION;
        }

        public void visitEnd() {
            String str;
            for (String next : this.observedTypes) {
                if (this.visitedInnerTypes.add(next)) {
                    TypePool.Resolution describe = this.typePool.describe(next.replace('/', '.'));
                    if (describe.isResolved()) {
                        TypeDescription resolve = describe.resolve();
                        if (!this.filter.matches(resolve)) {
                            while (resolve != null && resolve.isNestedClass()) {
                                String internalName = resolve.getInternalName();
                                String str2 = null;
                                if (resolve.isMemberType()) {
                                    str = resolve.getDeclaringType().getInternalName();
                                } else {
                                    str = null;
                                }
                                if (!resolve.isAnonymousType()) {
                                    str2 = resolve.getSimpleName();
                                }
                                super.visitInnerClass(internalName, str, str2, resolve.getModifiers());
                                do {
                                    try {
                                        resolve = resolve.getEnclosingType();
                                        if (resolve == null || this.visitedInnerTypes.add(resolve.getInternalName())) {
                                        }
                                        resolve = resolve.getEnclosingType();
                                        break;
                                    } catch (RuntimeException e11) {
                                        if (this.strict) {
                                            throw e11;
                                        }
                                    }
                                } while (this.visitedInnerTypes.add(resolve.getInternalName()));
                            }
                        } else {
                            continue;
                        }
                    } else if (this.strict) {
                        throw new IllegalStateException("Could not locate type for: " + next.replace('/', '.'));
                    }
                }
            }
            super.visitEnd();
        }

        public FieldVisitor visitField(int i11, String str, String str2, String str3, Object obj) {
            FieldVisitor visitField = super.visitField(i11, str, str2, str3, obj);
            if (visitField == null) {
                return IGNORE_FIELD;
            }
            f(Type.getType(str2));
            return new TypeReferenceFieldVisitor(visitField);
        }

        public void visitInnerClass(String str, String str2, String str3, int i11) {
            this.visitedInnerTypes.add(str);
            super.visitInnerClass(str, str2, str3, i11);
        }

        public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
            MethodVisitor visitMethod = super.visitMethod(i11, str, str2, str3, strArr);
            if (visitMethod == null) {
                return IGNORE_METHOD;
            }
            f(Type.getType(str2));
            if (strArr != null) {
                this.observedTypes.addAll(Arrays.asList(strArr));
            }
            return new TypeReferenceMethodVisitor(visitMethod);
        }

        public void visitNestHost(String str) {
            this.observedTypes.add(str);
            super.visitNestHost(str);
        }

        public void visitNestMember(String str) {
            this.observedTypes.add(str);
            super.visitNestMember(str);
        }

        public void visitOuterClass(String str, String str2, String str3) {
            this.observedTypes.add(str);
            super.visitOuterClass(str, str2, str3);
        }

        public RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
            this.observedTypes.add(Type.getType(str2).getInternalName());
            return super.visitRecordComponent(str, str2, str3);
        }

        public AnnotationVisitor visitTypeAnnotation(int i11, TypePath typePath, String str, boolean z11) {
            this.observedTypes.add(Type.getType(str).getInternalName());
            AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i11, typePath, str, z11);
            if (visitTypeAnnotation != null) {
                return new TypeReferenceAnnotationVisitor(visitTypeAnnotation);
            }
            return IGNORE_ANNOTATION;
        }
    }

    public TypeReferenceAdjustment(boolean z11, ElementMatcher.Junction<? super TypeDescription> junction) {
        this.strict = z11;
        this.filter = junction;
    }

    public static TypeReferenceAdjustment relaxed() {
        return new TypeReferenceAdjustment(false, ElementMatchers.none());
    }

    public static TypeReferenceAdjustment strict() {
        return new TypeReferenceAdjustment(true, ElementMatchers.none());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TypeReferenceAdjustment typeReferenceAdjustment = (TypeReferenceAdjustment) obj;
        return this.strict == typeReferenceAdjustment.strict && this.filter.equals(typeReferenceAdjustment.filter);
    }

    public TypeReferenceAdjustment filter(ElementMatcher<? super TypeDescription> elementMatcher) {
        return new TypeReferenceAdjustment(this.strict, this.filter.or(elementMatcher));
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + (this.strict ? 1 : 0)) * 31) + this.filter.hashCode();
    }

    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
        return new TypeReferenceClassVisitor(classVisitor, this.strict, this.filter, typePool);
    }
}
