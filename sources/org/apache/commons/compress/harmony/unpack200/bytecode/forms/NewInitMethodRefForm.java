package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class NewInitMethodRefForm extends InitMethodReferenceForm {
    public NewInitMethodRefForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public String context(OperandManager operandManager) {
        return operandManager.getNewClass();
    }

    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i11) throws Pack200Exception {
        byteCode.setNested(new ClassFileEntry[]{operandManager.globalConstantPool().getInitMethodPoolEntry(11, (long) i11, context(operandManager))});
        byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
    }
}
