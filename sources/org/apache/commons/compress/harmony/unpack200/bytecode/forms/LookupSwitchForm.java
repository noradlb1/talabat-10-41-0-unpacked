package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class LookupSwitchForm extends SwitchForm {
    public LookupSwitchForm(int i11, String str) {
        super(i11, str);
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        int nextCaseCount = operandManager.nextCaseCount();
        int nextLabel = operandManager.nextLabel();
        int[] iArr = new int[nextCaseCount];
        for (int i12 = 0; i12 < nextCaseCount; i12++) {
            iArr[i12] = operandManager.nextCaseValues();
        }
        int[] iArr2 = new int[nextCaseCount];
        for (int i13 = 0; i13 < nextCaseCount; i13++) {
            iArr2[i13] = operandManager.nextLabel();
        }
        int i14 = nextCaseCount + 1;
        int[] iArr3 = new int[i14];
        iArr3[0] = nextLabel;
        int i15 = 1;
        for (int i16 = 1; i16 < i14; i16++) {
            iArr3[i16] = iArr2[i16 - 1];
        }
        byteCode.setByteCodeTargets(iArr3);
        int i17 = 3 - (i11 % 4);
        int i18 = nextCaseCount * 4;
        int[] iArr4 = new int[(i17 + 1 + 4 + 4 + i18 + i18)];
        iArr4[0] = byteCode.getOpcode();
        int i19 = 0;
        while (i19 < i17) {
            iArr4[i15] = 0;
            i19++;
            i15++;
        }
        int i21 = i15 + 1;
        iArr4[i15] = -1;
        int i22 = i21 + 1;
        iArr4[i21] = -1;
        int i23 = i22 + 1;
        iArr4[i22] = -1;
        int i24 = i23 + 1;
        iArr4[i23] = -1;
        setRewrite4Bytes(nextCaseCount, i24, iArr4);
        int i25 = i24 + 4;
        for (int i26 = 0; i26 < nextCaseCount; i26++) {
            setRewrite4Bytes(iArr[i26], i25, iArr4);
            int i27 = i25 + 4;
            int i28 = i27 + 1;
            iArr4[i27] = -1;
            int i29 = i28 + 1;
            iArr4[i28] = -1;
            int i31 = i29 + 1;
            iArr4[i29] = -1;
            i25 = i31 + 1;
            iArr4[i31] = -1;
        }
        byteCode.setRewrite(iArr4);
    }
}
