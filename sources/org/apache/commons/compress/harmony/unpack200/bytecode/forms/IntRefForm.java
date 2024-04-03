package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class IntRefForm extends SingleByteReferenceForm {
    public IntRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextIntRef();
    }

    public int getPoolID() {
        return 2;
    }

    public IntRefForm(int i11, String str, int[] iArr, boolean z11) {
        this(i11, str, iArr);
        this.widened = z11;
    }
}
