package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class SuperFieldRefForm extends ClassSpecificReferenceForm {
    public SuperFieldRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public String context(OperandManager operandManager) {
        return operandManager.getSuperClass();
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextSuperFieldRef();
    }

    public int getPoolID() {
        return 10;
    }
}
