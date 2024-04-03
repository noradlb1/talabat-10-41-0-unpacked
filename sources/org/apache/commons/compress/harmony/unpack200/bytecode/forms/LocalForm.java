package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class LocalForm extends ByteCodeForm {
    public LocalForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        byteCode.setOperandBytes(new int[]{operandManager.nextLocal()});
    }
}
