package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class SuperInitMethodRefForm extends InitMethodReferenceForm {
    public SuperInitMethodRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public String context(OperandManager operandManager) {
        return operandManager.getSuperClass();
    }
}
