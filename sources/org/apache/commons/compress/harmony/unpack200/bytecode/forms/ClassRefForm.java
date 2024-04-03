package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class ClassRefForm extends ReferenceForm {
    protected boolean widened;

    public ClassRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextClassRef();
    }

    public int getPoolID() {
        return 7;
    }

    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i11) throws Pack200Exception {
        if (i11 != 0) {
            super.setNestedEntries(byteCode, operandManager, i11 - 1);
            return;
        }
        byteCode.setNested(new ClassFileEntry[]{operandManager.globalConstantPool().getClassPoolEntry(operandManager.getCurrentClass())});
        byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
    }

    public ClassRefForm(int i11, String str, int[] iArr, boolean z11) {
        this(i11, str, iArr);
        this.widened = z11;
    }
}
