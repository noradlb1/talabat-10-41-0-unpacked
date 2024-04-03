package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CPFloat extends CPConstantNumber {
    public CPFloat(Float f11, int i11) {
        super((byte) 4, f11, i11);
    }

    public String toString() {
        return "Float: " + getValue();
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(getNumber().floatValue());
    }
}
