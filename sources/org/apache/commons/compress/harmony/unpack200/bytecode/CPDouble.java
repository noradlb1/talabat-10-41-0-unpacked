package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CPDouble extends CPConstantNumber {
    public CPDouble(Double d11, int i11) {
        super((byte) 6, d11, i11);
    }

    public String toString() {
        return "Double: " + getValue();
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeDouble(getNumber().doubleValue());
    }
}
