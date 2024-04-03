package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class WideForm extends VariableInstructionForm {
    public WideForm(int i11, String str) {
        super(i11, str);
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        int nextWideByteCode = operandManager.nextWideByteCode();
        if (nextWideByteCode == 132) {
            setByteCodeOperandsFormat2(nextWideByteCode, byteCode, operandManager, i11);
        } else {
            setByteCodeOperandsFormat1(nextWideByteCode, byteCode, operandManager, i11);
        }
    }

    public void setByteCodeOperandsFormat1(int i11, ByteCode byteCode, OperandManager operandManager, int i12) {
        int nextLocal = operandManager.nextLocal();
        int[] iArr = new int[4];
        iArr[0] = byteCode.getOpcode();
        iArr[1] = i11;
        setRewrite2Bytes(nextLocal, 2, iArr);
        byteCode.setRewrite(iArr);
    }

    public void setByteCodeOperandsFormat2(int i11, ByteCode byteCode, OperandManager operandManager, int i12) {
        int nextLocal = operandManager.nextLocal();
        int nextShort = operandManager.nextShort();
        int[] iArr = new int[6];
        iArr[0] = byteCode.getOpcode();
        iArr[1] = i11;
        setRewrite2Bytes(nextLocal, 2, iArr);
        setRewrite2Bytes(nextShort, 4, iArr);
        byteCode.setRewrite(iArr);
    }
}
