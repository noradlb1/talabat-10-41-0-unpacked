package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class TableSwitchForm extends SwitchForm {
    public TableSwitchForm(int i11, String str) {
        super(i11, str);
    }

    public void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11) {
        int nextCaseCount = operandManager.nextCaseCount();
        int nextLabel = operandManager.nextLabel();
        int nextCaseValues = operandManager.nextCaseValues();
        int[] iArr = new int[nextCaseCount];
        for (int i12 = 0; i12 < nextCaseCount; i12++) {
            iArr[i12] = operandManager.nextLabel();
        }
        int i13 = nextCaseCount + 1;
        int[] iArr2 = new int[i13];
        iArr2[0] = nextLabel;
        int i14 = 1;
        for (int i15 = 1; i15 < i13; i15++) {
            iArr2[i15] = iArr[i15 - 1];
        }
        byteCode.setByteCodeTargets(iArr2);
        int i16 = (nextCaseValues + nextCaseCount) - 1;
        int i17 = 3 - (i11 % 4);
        int[] iArr3 = new int[(i17 + 1 + 4 + 4 + 4 + (nextCaseCount * 4))];
        iArr3[0] = byteCode.getOpcode();
        int i18 = 0;
        while (i18 < i17) {
            iArr3[i14] = 0;
            i18++;
            i14++;
        }
        int i19 = i14 + 1;
        iArr3[i14] = -1;
        int i21 = i19 + 1;
        iArr3[i19] = -1;
        int i22 = i21 + 1;
        iArr3[i21] = -1;
        int i23 = i22 + 1;
        iArr3[i22] = -1;
        setRewrite4Bytes(nextCaseValues, i23, iArr3);
        int i24 = i23 + 4;
        setRewrite4Bytes(i16, i24, iArr3);
        int i25 = i24 + 4;
        for (int i26 = 0; i26 < nextCaseCount; i26++) {
            int i27 = i25 + 1;
            iArr3[i25] = -1;
            int i28 = i27 + 1;
            iArr3[i27] = -1;
            int i29 = i28 + 1;
            iArr3[i28] = -1;
            i25 = i29 + 1;
            iArr3[i29] = -1;
        }
        byteCode.setRewrite(iArr3);
    }
}
