package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class LabelForm extends ByteCodeForm {
    protected boolean widened;

    public LabelForm(int i11, String str, int[] iArr) {
        super(i11, str, iArr);
    }

    public void fixUpByteCodeTargets(ByteCode byteCode, CodeAttribute codeAttribute) {
        int i11 = byteCode.getByteCodeTargets()[0];
        int byteCodeIndex = byteCode.getByteCodeIndex();
        byteCode.setOperandSigned2Bytes(((Integer) codeAttribute.byteCodeOffsets.get(i11 + byteCodeIndex)).intValue() - ((Integer) codeAttribute.byteCodeOffsets.get(byteCodeIndex)).intValue(), 0);
        if (this.widened) {
            byteCode.setNestedPositions(new int[][]{new int[]{0, 4}});
            return;
        }
        byteCode.setNestedPositions(new int[][]{new int[]{0, 2}});
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        byteCode.setByteCodeTargets(new int[]{operandManager.nextLabel()});
    }

    public LabelForm(int i11, String str, int[] iArr, boolean z11) {
        this(i11, str, iArr);
        this.widened = z11;
    }
}
