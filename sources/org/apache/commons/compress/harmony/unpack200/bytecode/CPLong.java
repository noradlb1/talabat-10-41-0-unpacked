package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CPLong extends CPConstantNumber {
    public CPLong(Long l11, int i11) {
        super((byte) 5, l11, i11);
    }

    public String toString() {
        return "Long: " + getValue();
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeLong(getNumber().longValue());
    }
}
