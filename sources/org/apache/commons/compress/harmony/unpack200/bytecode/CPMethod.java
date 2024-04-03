package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.List;

public class CPMethod extends CPMember {
    private int cachedHashCode;
    private boolean hashcodeComputed;

    public CPMethod(CPUTF8 cputf8, CPUTF8 cputf82, long j11, List list) {
        super(cputf8, cputf82, j11, list);
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = ((this.f27756name.hashCode() + 31) * 31) + this.descriptor.hashCode();
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public String toString() {
        return "Method: " + this.f27756name + "(" + this.descriptor + ")";
    }
}
