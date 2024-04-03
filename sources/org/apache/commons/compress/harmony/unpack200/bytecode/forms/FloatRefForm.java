package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class FloatRefForm extends SingleByteReferenceForm {
    public FloatRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextFloatRef();
    }

    public int getPoolID() {
        return 3;
    }

    public FloatRefForm(int i11, String str, int[] iArr, boolean z11) {
        this(i11, str, iArr);
        this.widened = z11;
    }
}
