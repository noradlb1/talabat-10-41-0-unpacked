package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class StringRefForm extends SingleByteReferenceForm {
    public StringRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public int getOffset(OperandManager operandManager) {
        return operandManager.nextStringRef();
    }

    public int getPoolID() {
        return 6;
    }

    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i11) throws Pack200Exception {
        byteCode.setNested(new ClassFileEntry[]{(CPString) operandManager.globalConstantPool().getValue(getPoolID(), (long) i11)});
        if (this.widened) {
            byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
            return;
        }
        byteCode.setNestedPositions(new int[][]{new int[]{0, 1}});
    }

    public StringRefForm(int i11, String str, int[] iArr, boolean z11) {
        this(i11, str, iArr);
        this.widened = z11;
    }
}
