package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class ThisFieldRefForm extends ClassSpecificReferenceForm {
    public ThisFieldRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public String context(OperandManager operandManager) {
        return operandManager.getCurrentClass();
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextThisFieldRef();
    }

    public int getPoolID() {
        return 10;
    }
}
