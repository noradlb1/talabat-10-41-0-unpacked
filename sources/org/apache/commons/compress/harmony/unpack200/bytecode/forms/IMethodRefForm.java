package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class IMethodRefForm extends ReferenceForm {
    public IMethodRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextIMethodRef();
    }

    public int getPoolID() {
        return 12;
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        super.setByteCodeOperands(byteCode, operandManager, i11);
        byteCode.getRewrite()[3] = ((CPInterfaceMethodRef) byteCode.getNestedClassFileEntries()[0]).invokeInterfaceCount();
    }
}
