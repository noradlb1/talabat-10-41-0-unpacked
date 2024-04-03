package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class LongForm extends ReferenceForm {
    public LongForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextLongRef();
    }

    public int getPoolID() {
        return 4;
    }
}
