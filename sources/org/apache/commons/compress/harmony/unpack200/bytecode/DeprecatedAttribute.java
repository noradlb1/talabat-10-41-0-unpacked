package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class DeprecatedAttribute extends Attribute {
    private static CPUTF8 attributeName;

    public DeprecatedAttribute() {
        super(attributeName);
    }

    public static void setAttributeName(CPUTF8 cputf8) {
        attributeName = cputf8;
    }

    public int getLength() {
        return 0;
    }

    public String toString() {
        return "Deprecated Attribute";
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
    }
}
