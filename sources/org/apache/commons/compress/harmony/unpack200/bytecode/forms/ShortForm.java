package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class ShortForm extends ByteCodeForm {
    public ShortForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        byteCode.setOperand2Bytes(operandManager.nextShort(), 0);
    }
}
