package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

public abstract class VariableInstructionForm extends ByteCodeForm {
    public VariableInstructionForm(int i11, String str) {
        super(i11, str);
    }

    public void setRewrite2Bytes(int i11, int i12, int[] iArr) {
        if (i12 >= 0) {
            int i13 = i12 + 1;
            if (i13 <= iArr.length) {
                iArr[i12] = (65280 & i11) >> 8;
                iArr[i13] = i11 & 255;
                return;
            }
            throw new Error("Trying to rewrite " + this + " with an int at position " + i12 + " but this won't fit in the rewrite array");
        }
        throw new Error("Trying to rewrite " + this + " but there is no room for 4 bytes");
    }

    public void setRewrite4Bytes(int i11, int[] iArr) {
        int i12 = 0;
        while (true) {
            if (i12 < iArr.length - 3) {
                if (iArr[i12] == -1 && iArr[i12 + 1] == -1 && iArr[i12 + 2] == -1 && iArr[i12 + 3] == -1) {
                    break;
                }
                i12++;
            } else {
                i12 = -1;
                break;
            }
        }
        setRewrite4Bytes(i11, i12, iArr);
    }

    public void setRewrite4Bytes(int i11, int i12, int[] iArr) {
        if (i12 >= 0) {
            int i13 = i12 + 3;
            if (i13 <= iArr.length) {
                iArr[i12] = (-16777216 & i11) >> 24;
                iArr[i12 + 1] = (16711680 & i11) >> 16;
                iArr[i12 + 2] = (65280 & i11) >> 8;
                iArr[i13] = i11 & 255;
                return;
            }
            throw new Error("Trying to rewrite " + this + " with an int at position " + i12 + " but this won't fit in the rewrite array");
        }
        throw new Error("Trying to rewrite " + this + " but there is no room for 4 bytes");
    }
}
