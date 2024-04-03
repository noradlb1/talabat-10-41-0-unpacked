package net.bytebuddy.implementation.bytecode.assign.primitive;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public enum PrimitiveWideningDelegate {
    BOOLEAN(r23, r24, r24, r24, r24, r24, r24, r24),
    BYTE(r15, r23, r17, r18, r19, r1, new WideningStackManipulation(134, r5.toIncreasingSize()), new WideningStackManipulation(Opcodes.I2L, r2.toIncreasingSize())),
    SHORT(r15, r16, r17, r18, r19, new WideningStackManipulation(Opcodes.I2L, r2.toIncreasingSize()), new WideningStackManipulation(134, r5.toIncreasingSize()), new WideningStackManipulation(135, r2.toIncreasingSize())),
    CHARACTER(r15, r16, r17, r23, r19, new WideningStackManipulation(Opcodes.I2L, r2.toIncreasingSize()), new WideningStackManipulation(134, r5.toIncreasingSize()), new WideningStackManipulation(135, r2.toIncreasingSize())),
    INTEGER(r15, r16, r17, r18, r19, new WideningStackManipulation(Opcodes.I2L, r2.toIncreasingSize()), new WideningStackManipulation(134, r5.toIncreasingSize()), new WideningStackManipulation(135, r2.toIncreasingSize())),
    LONG(r15, r16, r17, r18, r19, r23, new WideningStackManipulation(Opcodes.L2F, r2.toDecreasingSize()), new WideningStackManipulation(138, r5.toIncreasingSize())),
    FLOAT(r15, r16, r17, r18, r19, r20, r23, new WideningStackManipulation(Opcodes.F2D, r2.toIncreasingSize())),
    DOUBLE(r15, r16, r17, r18, r19, r20, r24, r23);
    
    private final StackManipulation toBooleanStackManipulation;
    private final StackManipulation toByteStackManipulation;
    private final StackManipulation toCharacterStackManipulation;
    private final StackManipulation toDoubleStackManipulation;
    private final StackManipulation toFloatStackManipulation;
    private final StackManipulation toIntegerStackManipulation;
    private final StackManipulation toLongStackManipulation;
    private final StackManipulation toShortStackManipulation;

    @HashCodeAndEqualsPlugin.Enhance
    public static class WideningStackManipulation extends StackManipulation.AbstractBase {
        private final int conversionOpcode;
        private final StackManipulation.Size size;

        public WideningStackManipulation(int i11, StackManipulation.Size size2) {
            this.conversionOpcode = i11;
            this.size = size2;
        }

        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitInsn(this.conversionOpcode);
            return this.size;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WideningStackManipulation wideningStackManipulation = (WideningStackManipulation) obj;
            return this.conversionOpcode == wideningStackManipulation.conversionOpcode && this.size.equals(wideningStackManipulation.size);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.conversionOpcode) * 31) + this.size.hashCode();
        }
    }

    private PrimitiveWideningDelegate(StackManipulation stackManipulation, StackManipulation stackManipulation2, StackManipulation stackManipulation3, StackManipulation stackManipulation4, StackManipulation stackManipulation5, StackManipulation stackManipulation6, StackManipulation stackManipulation7, StackManipulation stackManipulation8) {
        this.toBooleanStackManipulation = stackManipulation;
        this.toByteStackManipulation = stackManipulation2;
        this.toShortStackManipulation = stackManipulation3;
        this.toCharacterStackManipulation = stackManipulation4;
        this.toIntegerStackManipulation = stackManipulation5;
        this.toLongStackManipulation = stackManipulation6;
        this.toFloatStackManipulation = stackManipulation7;
        this.toDoubleStackManipulation = stackManipulation8;
    }

    public static PrimitiveWideningDelegate forPrimitive(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return BOOLEAN;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
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
        throw new IllegalArgumentException("Not a primitive, non-void type: " + typeDefinition);
    }

    public StackManipulation widenTo(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return this.toBooleanStackManipulation;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
            return this.toByteStackManipulation;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return this.toShortStackManipulation;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return this.toCharacterStackManipulation;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return this.toIntegerStackManipulation;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return this.toLongStackManipulation;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return this.toFloatStackManipulation;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return this.toDoubleStackManipulation;
        }
        throw new IllegalArgumentException("Not a primitive non-void type: " + typeDefinition);
    }
}
