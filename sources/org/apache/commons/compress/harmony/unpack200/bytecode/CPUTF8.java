package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CPUTF8 extends ConstantPoolEntry {
    private int cachedHashCode;
    private boolean hashcodeComputed;
    private final String utf8;

    public CPUTF8(String str, int i11) {
        super((byte) 1, i11);
        this.utf8 = str;
        if (str == null) {
            throw new NullPointerException("Null arguments are not allowed");
        }
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = this.utf8.hashCode() + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.utf8.equals(((CPUTF8) obj).utf8);
        }
        return false;
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public void setGlobalIndex(int i11) {
        this.globalIndex = i11;
    }

    public String toString() {
        return "UTF8: " + this.utf8;
    }

    public String underlyingString() {
        return this.utf8;
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.utf8);
    }

    public CPUTF8(String str) {
        this(str, -1);
    }
}
