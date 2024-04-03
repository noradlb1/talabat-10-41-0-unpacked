package net.bytebuddy.implementation.bytecode.member;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatchers;

public enum FieldAccess {
    STATIC(Opcodes.PUTSTATIC, Opcodes.GETSTATIC, StackSize.ZERO),
    INSTANCE(Opcodes.PUTFIELD, 180, StackSize.SINGLE);
    
    /* access modifiers changed from: private */
    public final int getterOpcode;
    /* access modifiers changed from: private */
    public final int putterOpcode;
    /* access modifiers changed from: private */
    public final int targetSizeChange;

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class AccessDispatcher implements Defined {
        /* access modifiers changed from: private */
        public final FieldDescription.InDefinedShape fieldDescription;

        public abstract class AbstractFieldInstruction extends StackManipulation.AbstractBase {
            private AbstractFieldInstruction() {
            }

            public abstract int a();

            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitFieldInsn(a(), AccessDispatcher.this.fieldDescription.getDeclaringType().getInternalName(), AccessDispatcher.this.fieldDescription.getInternalName(), AccessDispatcher.this.fieldDescription.getDescriptor());
                return b(AccessDispatcher.this.fieldDescription.getType().getStackSize());
            }

            public abstract StackManipulation.Size b(StackSize stackSize);
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class FieldGetInstruction extends AbstractFieldInstruction {
            public FieldGetInstruction() {
                super();
            }

            public int a() {
                return FieldAccess.this.getterOpcode;
            }

            public StackManipulation.Size b(StackSize stackSize) {
                int size = stackSize.getSize() - FieldAccess.this.targetSizeChange;
                return new StackManipulation.Size(size, size);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && AccessDispatcher.this.equals(AccessDispatcher.this);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + AccessDispatcher.this.hashCode();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class FieldPutInstruction extends AbstractFieldInstruction {
            public FieldPutInstruction() {
                super();
            }

            public int a() {
                return FieldAccess.this.putterOpcode;
            }

            public StackManipulation.Size b(StackSize stackSize) {
                return new StackManipulation.Size((stackSize.getSize() + FieldAccess.this.targetSizeChange) * -1, 0);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && AccessDispatcher.this.equals(AccessDispatcher.this);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + AccessDispatcher.this.hashCode();
            }
        }

        public AccessDispatcher(FieldDescription.InDefinedShape inDefinedShape) {
            this.fieldDescription = inDefinedShape;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AccessDispatcher accessDispatcher = (AccessDispatcher) obj;
            return FieldAccess.this.equals(FieldAccess.this) && this.fieldDescription.equals(accessDispatcher.fieldDescription);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + FieldAccess.this.hashCode();
        }

        public StackManipulation read() {
            return new FieldGetInstruction();
        }

        public StackManipulation write() {
            return new FieldPutInstruction();
        }
    }

    public interface Defined {
        StackManipulation read();

        StackManipulation write();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class OfGenericField implements Defined {
        private final Defined defined;
        private final TypeDefinition targetType;

        public OfGenericField(TypeDefinition typeDefinition, Defined defined2) {
            this.targetType = typeDefinition;
            this.defined = defined2;
        }

        public static Defined a(FieldDescription fieldDescription, Defined defined2) {
            return new OfGenericField(fieldDescription.getType(), defined2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OfGenericField ofGenericField = (OfGenericField) obj;
            return this.targetType.equals(ofGenericField.targetType) && this.defined.equals(ofGenericField.defined);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.targetType.hashCode()) * 31) + this.defined.hashCode();
        }

        public StackManipulation read() {
            return new StackManipulation.Compound(this.defined.read(), TypeCasting.to(this.targetType));
        }

        public StackManipulation write() {
            return this.defined.write();
        }
    }

    private FieldAccess(int i11, int i12, StackSize stackSize) {
        this.putterOpcode = i11;
        this.getterOpcode = i12;
        this.targetSizeChange = stackSize.getSize();
    }

    public static StackManipulation forEnumeration(EnumerationDescription enumerationDescription) {
        FieldList fieldList = (FieldList) enumerationDescription.getEnumerationType().getDeclaredFields().filter(ElementMatchers.named(enumerationDescription.getValue()));
        if (fieldList.size() != 1 || !((FieldDescription.InDefinedShape) fieldList.getOnly()).isStatic() || !((FieldDescription.InDefinedShape) fieldList.getOnly()).isPublic() || !((FieldDescription.InDefinedShape) fieldList.getOnly()).isEnum()) {
            return StackManipulation.Illegal.INSTANCE;
        }
        FieldAccess fieldAccess = STATIC;
        fieldAccess.getClass();
        return new AccessDispatcher((FieldDescription.InDefinedShape) fieldList.getOnly()).read();
    }

    public static Defined forField(FieldDescription.InDefinedShape inDefinedShape) {
        if (inDefinedShape.isStatic()) {
            FieldAccess fieldAccess = STATIC;
            fieldAccess.getClass();
            return new AccessDispatcher(inDefinedShape);
        }
        FieldAccess fieldAccess2 = INSTANCE;
        fieldAccess2.getClass();
        return new AccessDispatcher(inDefinedShape);
    }

    public static Defined forField(FieldDescription fieldDescription) {
        FieldDescription.InDefinedShape inDefinedShape = (FieldDescription.InDefinedShape) fieldDescription.asDefined();
        if (fieldDescription.getType().asErasure().equals(inDefinedShape.getType().asErasure())) {
            return forField(inDefinedShape);
        }
        return OfGenericField.a(fieldDescription, forField(inDefinedShape));
    }
}
