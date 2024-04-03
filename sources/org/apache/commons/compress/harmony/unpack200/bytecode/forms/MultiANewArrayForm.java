package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class MultiANewArrayForm extends ClassRefForm {
    public MultiANewArrayForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        super.setByteCodeOperands(byteCode, operandManager, i11);
        byteCode.setOperandByte(operandManager.nextByte(), 2);
    }
}
