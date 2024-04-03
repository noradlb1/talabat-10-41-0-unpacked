package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class FieldRefForm extends ReferenceForm {
    public FieldRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextFieldRef();
    }

    public int getPoolID() {
        return 10;
    }
}
