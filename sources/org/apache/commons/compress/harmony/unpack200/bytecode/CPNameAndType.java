package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.commons.compress.harmony.unpack200.SegmentUtils;

public class CPNameAndType extends ConstantPoolEntry {
    private int cachedHashCode;
    CPUTF8 descriptor;
    transient int descriptorIndex;
    private boolean hashcodeComputed;

    /* renamed from: name  reason: collision with root package name */
    CPUTF8 f27757name;
    transient int nameIndex;

    public CPNameAndType(CPUTF8 cputf8, CPUTF8 cputf82, int i11) {
        super((byte) 12, i11);
        this.f27757name = cputf8;
        this.descriptor = cputf82;
        if (cputf8 == null || cputf82 == null) {
            throw new NullPointerException("Null arguments are not allowed");
        }
    }

    private void generateHashCode() {
        this.hashcodeComputed = true;
        this.cachedHashCode = ((this.descriptor.hashCode() + 31) * 31) + this.f27757name.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CPNameAndType cPNameAndType = (CPNameAndType) obj;
        if (this.descriptor.equals(cPNameAndType.descriptor) && this.f27757name.equals(cPNameAndType.f27757name)) {
            return true;
        }
        return false;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        return new ClassFileEntry[]{this.f27757name, this.descriptor};
    }

    public int hashCode() {
        if (!this.hashcodeComputed) {
            generateHashCode();
        }
        return this.cachedHashCode;
    }

    public int invokeInterfaceCount() {
        return SegmentUtils.countInvokeInterfaceArgs(this.descriptor.underlyingString()) + 1;
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.descriptorIndex = classConstantPool.indexOf(this.descriptor);
        this.nameIndex = classConstantPool.indexOf(this.f27757name);
    }

    public String toString() {
        return "NameAndType: " + this.f27757name + "(" + this.descriptor + ")";
    }

    public void writeBody(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.nameIndex);
        dataOutputStream.writeShort(this.descriptorIndex);
    }
}
