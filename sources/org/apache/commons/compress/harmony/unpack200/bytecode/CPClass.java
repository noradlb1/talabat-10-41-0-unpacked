package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CPClass extends ConstantPoolEntry {
    private int cachedHashCode;
    private boolean hashcodeComputed;
    private int index;

    /* renamed from: name  reason: collision with root package name */
    public String f27755name;
    private final CPUTF8 utf8;

    public CPClass(CPUTF8 cputf8, int i11) {
        super((byte) 7, i11);
        if (cputf8 != null) {
            this.f27755name = cputf8.underlyingString();
            this.utf8 = cputf8;
            return;
        }
        throw new NullPointerException("Null arguments are not allowed");
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = this.utf8.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.utf8.equals(((CPClass) obj).utf8);
        }
        return false;
    }

    public String getName() {
        return this.f27755name;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{this.utf8};
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.index = classConstantPool.indexOf(this.utf8);
    }

    public String toString() {
        return "Class: " + getName();
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.index);
    }
}
