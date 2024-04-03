package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.List;

public class CPField extends CPMember {
    public CPField(CPUTF8 cputf8, CPUTF8 cputf82, long j11, List list) {
        super(cputf8, cputf82, j11, list);
    }

    public String toString() {
        return "Field: " + this.f27756name + "(" + this.descriptor + ")";
    }
}
