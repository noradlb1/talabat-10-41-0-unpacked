package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CPMember extends ClassFileEntry {
    List attributes;
    protected final CPUTF8 descriptor;
    transient int descriptorIndex;
    short flags;

    /* renamed from: name  reason: collision with root package name */
    CPUTF8 f27756name;
    transient int nameIndex;

    public CPMember(CPUTF8 cputf8, CPUTF8 cputf82, long j11, List list) {
        this.f27756name = cputf8;
        this.descriptor = cputf82;
        this.flags = (short) ((int) j11);
        this.attributes = list == null ? Collections.EMPTY_LIST : list;
        if (cputf8 == null || cputf82 == null) {
            throw new NullPointerException("Null arguments are not allowed");
        }
    }

    public void doWrite(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.flags);
        dataOutputStream.writeShort(this.nameIndex);
        dataOutputStream.writeShort(this.descriptorIndex);
        int size = this.attributes.size();
        dataOutputStream.writeShort(size);
        for (int i11 = 0; i11 < size; i11++) {
            ((Attribute) this.attributes.get(i11)).doWrite(dataOutputStream);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CPMember cPMember = (CPMember) obj;
        if (this.attributes.equals(cPMember.attributes) && this.descriptor.equals(cPMember.descriptor) && this.flags == cPMember.flags && this.f27756name.equals(cPMember.f27756name)) {
            return true;
        }
        return false;
    }

    public ClassFileEntry[] getNestedClassFileEntries() {
        int size = this.attributes.size();
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[(size + 2)];
        classFileEntryArr[0] = this.f27756name;
        classFileEntryArr[1] = this.descriptor;
        for (int i11 = 0; i11 < size; i11++) {
            classFileEntryArr[i11 + 2] = (Attribute) this.attributes.get(i11);
        }
        return classFileEntryArr;
    }

    public int hashCode() {
        return ((((((this.attributes.hashCode() + 31) * 31) + this.descriptor.hashCode()) * 31) + this.flags) * 31) + this.f27756name.hashCode();
    }

    public void resolve(ClassConstantPool classConstantPool) {
        super.resolve(classConstantPool);
        this.nameIndex = classConstantPool.indexOf(this.f27756name);
        this.descriptorIndex = classConstantPool.indexOf(this.descriptor);
        for (int i11 = 0; i11 < this.attributes.size(); i11++) {
            ((Attribute) this.attributes.get(i11)).resolve(classConstantPool);
        }
    }

    public String toString() {
        return "CPMember: " + this.f27756name + "(" + this.descriptor + ")";
    }
}
