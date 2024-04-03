package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class DoubleForm extends ReferenceForm {
    public DoubleForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextDoubleRef();
    }

    public int getPoolID() {
        return 5;
    }
}
