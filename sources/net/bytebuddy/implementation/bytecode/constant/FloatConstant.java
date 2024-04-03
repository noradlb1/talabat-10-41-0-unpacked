package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum FloatConstant implements StackManipulation {
    ZERO(11),
    ONE(12),
    TWO(13);
    
    /* access modifiers changed from: private */
    public static final StackManipulation.Size SIZE = null;
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantPool extends StackManipulation.AbstractBase {
        private final float value;

        public ConstantPool(float f11) {
            this.value = f11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Float.valueOf(this.value));
            return FloatConstant.SIZE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.compare(this.value, ((ConstantPool) obj).value) == 0;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + Float.floatToIntBits(this.value);
        }
    }

    /* access modifiers changed from: public */
    static {
        SIZE = StackSize.SINGLE.toIncreasingSize();
    }

    private FloatConstant(int i11) {
        this.opcode = i11;
    }

    public static StackManipulation forValue(float f11) {
        if (f11 == 0.0f) {
            return ZERO;
        }
        if (f11 == 1.0f) {
            return ONE;
        }
        if (f11 == 2.0f) {
            return TWO;
        }
        return new ConstantPool(f11);
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    public boolean isValid() {
        return true;
    }
}
