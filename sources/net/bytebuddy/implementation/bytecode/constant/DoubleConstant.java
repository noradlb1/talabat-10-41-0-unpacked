package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum DoubleConstant implements StackManipulation {
    ZERO(14),
    ONE(15);
    
    /* access modifiers changed from: private */
    public static final StackManipulation.Size SIZE = null;
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantPool extends StackManipulation.AbstractBase {
        private final double value;

        public ConstantPool(double d11) {
            this.value = d11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Double.valueOf(this.value));
            return DoubleConstant.SIZE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Double.compare(this.value, ((ConstantPool) obj).value) == 0;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(this.value);
            return (getClass().hashCode() * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
    }

    /* access modifiers changed from: public */
    static {
        SIZE = StackSize.DOUBLE.toIncreasingSize();
    }

    private DoubleConstant(int i11) {
        this.opcode = i11;
    }

    public static StackManipulation forValue(double d11) {
        if (d11 == 0.0d) {
            return ZERO;
        }
        if (d11 == 1.0d) {
            return ONE;
        }
        return new ConstantPool(d11);
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    public boolean isValid() {
        return true;
    }
}
