package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class SuperMethodRefForm extends ClassSpecificReferenceForm {
    public SuperMethodRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public String context(OperandManager operandManager) {
        return operandManager.getSuperClass();
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextSuperMethodRef();
    }

    public int getPoolID() {
        return 11;
    }
}
