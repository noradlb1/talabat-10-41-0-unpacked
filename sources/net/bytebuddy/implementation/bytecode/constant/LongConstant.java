package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum LongConstant implements StackManipulation {
    ZERO(9),
    ONE(10);
    
    /* access modifiers changed from: private */
    public static final StackManipulation.Size SIZE = null;
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantPool extends StackManipulation.AbstractBase {
        private final long value;

        public ConstantPool(long j11) {
            this.value = j11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Long.valueOf(this.value));
            return LongConstant.SIZE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ConstantPool) obj).value;
        }

        public int hashCode() {
            long j11 = this.value;
            return (getClass().hashCode() * 31) + ((int) (j11 ^ (j11 >>> 32)));
        }
    }

    /* access modifiers changed from: public */
    static {
        SIZE = StackSize.DOUBLE.toIncreasingSize();
    }

    private LongConstant(int i11) {
        this.opcode = i11;
    }

    public static StackManipulation forValue(long j11) {
        if (j11 == 0) {
            return ZERO;
        }
        if (j11 == 1) {
            return ONE;
        }
        return new ConstantPool(j11);
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    public boolean isValid() {
        return true;
    }
}
