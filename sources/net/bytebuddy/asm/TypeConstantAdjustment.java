package net.bytebuddy.asm;

import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;

public enum TypeConstantAdjustment implements AsmVisitorWrapper {
    INSTANCE;

    public static class TypeConstantDissolvingClassVisitor extends ClassVisitor {
        private boolean supportsTypeConstants;

        public static class TypeConstantDissolvingMethodVisitor extends MethodVisitor {
            private static final String DESCRIPTOR = "(Ljava/lang/String;)Ljava/lang/Class;";
            private static final String FOR_NAME = "forName";
            private static final String JAVA_LANG_CLASS = "java/lang/Class";

            public TypeConstantDissolvingMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = (net.bytebuddy.jar.asm.Type) r7;
             */
            @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Fall through to default case is intentional", value = {"SF_SWITCH_NO_DEFAULT"})
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void visitLdcInsn(java.lang.Object r7) {
                /*
                    r6 = this;
                    boolean r0 = r7 instanceof net.bytebuddy.jar.asm.Type
                    if (r0 == 0) goto L_0x0031
                    r0 = r7
                    net.bytebuddy.jar.asm.Type r0 = (net.bytebuddy.jar.asm.Type) r0
                    int r1 = r0.getSort()
                    r2 = 9
                    if (r1 == r2) goto L_0x0014
                    r2 = 10
                    if (r1 == r2) goto L_0x0014
                    goto L_0x0031
                L_0x0014:
                    java.lang.String r7 = r0.getInternalName()
                    r0 = 47
                    r1 = 46
                    java.lang.String r7 = r7.replace(r0, r1)
                    super.visitLdcInsn(r7)
                    r1 = 184(0xb8, float:2.58E-43)
                    java.lang.String r2 = "java/lang/Class"
                    java.lang.String r3 = "forName"
                    java.lang.String r4 = "(Ljava/lang/String;)Ljava/lang/Class;"
                    r5 = 0
                    r0 = r6
                    super.visitMethodInsn(r1, r2, r3, r4, r5)
                    return
                L_0x0031:
                    super.visitLdcInsn(r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.TypeConstantAdjustment.TypeConstantDissolvingClassVisitor.TypeConstantDissolvingMethodVisitor.visitLdcInsn(java.lang.Object):void");
            }
        }

        public TypeConstantDissolvingClassVisitor(ClassVisitor classVisitor) {
            super(OpenedClassReader.ASM_API, classVisitor);
        }

        public void visit(int i11, int i12, String str, String str2, String str3, String[] strArr) {
            this.supportsTypeConstants = ClassFileVersion.ofMinorMajor(i11).isAtLeast(ClassFileVersion.JAVA_V5);
            super.visit(i11, i12, str, str2, str3, strArr);
        }

        public MethodVisitor visitMethod(int i11, String str, String str2, String str3, String[] strArr) {
            MethodVisitor visitMethod = super.visitMethod(i11, str, str2, str3, strArr);
            if (this.supportsTypeConstants || visitMethod == null) {
                return visitMethod;
            }
            return new TypeConstantDissolvingMethodVisitor(visitMethod);
        }
    }

    public int mergeReader(int i11) {
        return i11;
    }

    public int mergeWriter(int i11) {
        return i11;
    }

    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i11, int i12) {
        return new TypeConstantDissolvingClassVisitor(classVisitor);
    }
}
