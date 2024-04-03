package net.bytebuddy.implementation.bytecode.collection;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum ArrayAccess {
    BYTE(51, 84, r13),
    SHORT(53, 86, r12),
    CHARACTER(52, 85, r12),
    INTEGER(46, 79, r12),
    LONG(47, 80, r4),
    FLOAT(48, 81, r12),
    DOUBLE(49, 82, r4),
    REFERENCE(50, 83, r13);
    
    /* access modifiers changed from: private */
    public final int loadOpcode;
    /* access modifiers changed from: private */
    public final StackSize stackSize;
    /* access modifiers changed from: private */
    public final int storeOpcode;

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class Loader extends StackManipulation.AbstractBase {
        public Loader() {
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitInsn(ArrayAccess.this.loadOpcode);
            return ArrayAccess.this.stackSize.toIncreasingSize().aggregate(new StackManipulation.Size(-2, 0));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && ArrayAccess.this.equals(ArrayAccess.this);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + ArrayAccess.this.hashCode();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class Putter extends StackManipulation.AbstractBase {
        public Putter() {
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitInsn(ArrayAccess.this.storeOpcode);
            return ArrayAccess.this.stackSize.toDecreasingSize().aggregate(new StackManipulation.Size(-2, 0));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && ArrayAccess.this.equals(ArrayAccess.this);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + ArrayAccess.this.hashCode();
        }
    }

    private ArrayAccess(int i11, int i12, StackSize stackSize2) {
        this.loadOpcode = i11;
        this.storeOpcode = i12;
        this.stackSize = stackSize2;
    }

    public static ArrayAccess of(TypeDefinition typeDefinition) {
        if (!typeDefinition.isPrimitive()) {
            return REFERENCE;
        }
        if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE)) {
            return BYTE;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return SHORT;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return CHARACTER;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return INTEGER;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return LONG;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return DOUBLE;
        }
        throw new IllegalArgumentException("Not a legal array type: " + typeDefinition);
    }

    public StackManipulation forEach(List<? extends StackManipulation> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i11 = 0;
        for (StackManipulation stackManipulation : list) {
            arrayList.add(new StackManipulation.Compound(Duplication.SINGLE, IntegerConstant.forValue(i11), new Loader(), stackManipulation));
            i11++;
        }
        return new StackManipulation.Compound((List<? extends StackManipulation>) arrayList);
    }

    public StackManipulation load() {
        return new Loader();
    }

    public StackManipulation store() {
        return new Putter();
    }
}
