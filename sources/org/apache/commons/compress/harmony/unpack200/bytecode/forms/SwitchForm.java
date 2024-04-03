package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;

public abstract class SwitchForm extends VariableInstructionForm {
    public SwitchForm(int i11, String str) {
        super(i11, str);
    }

    public void fixUpByteCodeTargets(ByteCode byteCode, CodeAttribute codeAttribute) {
        int[] byteCodeTargets = byteCode.getByteCodeTargets();
        int length = byteCodeTargets.length;
        int[] iArr = new int[length];
        int byteCodeIndex = byteCode.getByteCodeIndex();
        int intValue = ((Integer) codeAttribute.byteCodeOffsets.get(byteCodeIndex)).intValue();
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = ((Integer) codeAttribute.byteCodeOffsets.get(byteCodeTargets[i11] + byteCodeIndex)).intValue() - intValue;
        }
        int[] rewrite = byteCode.getRewrite();
        for (int i12 = 0; i12 < length; i12++) {
            setRewrite4Bytes(iArr[i12], rewrite);
        }
    }
}
