package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CPString extends CPConstant {
    private int cachedHashCode;
    private boolean hashcodeComputed;

    /* renamed from: name  reason: collision with root package name */
    private final CPUTF8 f27758name;
    private transient int nameIndex;

    public CPString(CPUTF8 cputf8, int i11) {
        super((byte) 8, cputf8, i11);
        this.f27758name = cputf8;
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = 31 + this.f27758name.hashCode();
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{this.f27758name};
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.nameIndex = classConstantPool.indexOf(this.f27758name);
    }

    public String toString() {
        return "String: " + getValue();
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.nameIndex);
    }
}
