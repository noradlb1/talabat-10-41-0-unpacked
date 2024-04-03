package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public abstract class SingleByteReferenceForm extends ReferenceForm {
    protected boolean widened;

    public SingleByteReferenceForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public abstract int getOffset(OperandManager operandManager);

    public abstract int getPoolID();

    public boolean nestedMustStartClassPool() {
        return !this.widened;
    }

    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i11) throws Pack200Exception {
        super.setNestedEntries(byteCode, operandManager, i11);
        if (this.widened) {
            byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
            return;
        }
        byteCode.setNestedPositions(new int[][]{new int[]{0, 1}});
    }
}
