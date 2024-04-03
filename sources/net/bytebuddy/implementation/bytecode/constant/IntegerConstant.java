package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;

public enum IntegerConstant implements StackManipulation {
    MINUS_ONE(2),
    ZERO(3),
    ONE(4),
    TWO(5),
    THREE(6),
    FOUR(7),
    FIVE(8);
    
    /* access modifiers changed from: private */
    public static final StackManipulation.Size SIZE = null;
    private final int opcode;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantPool extends StackManipulation.AbstractBase {
        private final int value;

        public ConstantPool(int i11) {
            this.value = i11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitLdcInsn(Integer.valueOf(this.value));
            return IntegerConstant.SIZE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ConstantPool) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class SingleBytePush extends StackManipulation.AbstractBase {
        private final byte value;

        public SingleBytePush(byte b11) {
            this.value = b11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitIntInsn(16, this.value);
            return IntegerConstant.SIZE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((SingleBytePush) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class TwoBytePush extends StackManipulation.AbstractBase {
        private final short value;

        public TwoBytePush(short s11) {
            this.value = s11;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitIntInsn(17, this.value);
            return IntegerConstant.SIZE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((TwoBytePush) obj).value;
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.value;
        }
    }

    /* access modifiers changed from: public */
    static {
        SIZE = StackSize.SINGLE.toIncreasingSize();
    }

    private IntegerConstant(int i11) {
        this.opcode = i11;
    }

    public static StackManipulation forValue(boolean z11) {
        return z11 ? ONE : ZERO;
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    public boolean isValid() {
        return true;
    }

    public static StackManipulation forValue(int i11) {
        switch (i11) {
            case -1:
                return MINUS_ONE;
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            default:
                if (i11 >= -128 && i11 <= 127) {
                    return new SingleBytePush((byte) i11);
                }
                if (i11 < -32768 || i11 > 32767) {
                    return new ConstantPool(i11);
                }
                return new TwoBytePush((short) i11);
        }
    }
}
