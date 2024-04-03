package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public abstract class ReferenceForm extends ByteCodeForm {
    public ReferenceForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public abstract int getOffset(OperandManager operandManager);

    public abstract int getPoolID();

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        try {
            setNestedEntries(byteCode, operandManager, getOffset(operandManager));
        } catch (Pack200Exception unused) {
            throw new Error("Got a pack200 exception. What to do?");
        }
    }

    public void setNestedEntries(ByteCode byteCode, OperandManager operandManager, int i11) throws Pack200Exception {
        ConstantPoolEntry constantPoolEntry = operandManager.globalConstantPool().getConstantPoolEntry(getPoolID(), (long) i11);
        ClassFileEntry[] classFileEntryArr = {constantPoolEntry};
        if (constantPoolEntry != null) {
            byteCode.setNested(classFileEntryArr);
            byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
            return;
        }
        throw new NullPointerException("Null nested entries are not allowed");
    }
}
